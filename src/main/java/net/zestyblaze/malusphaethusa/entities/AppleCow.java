package net.zestyblaze.malusphaethusa.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.zestyblaze.malusphaethusa.init.EntityInit;
import org.jetbrains.annotations.NotNull;

public class AppleCow extends CowEntity {
    public AppleCow(EntityType<? extends CowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public AppleCow createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return EntityInit.APPLE_COW.create(serverWorld);
    }

    @Override
    public ActionResult interactMob(@NotNull PlayerEntity player, Hand hand){
        ItemStack itemStack = player.getStackInHand(hand);
        if(itemStack.isOf(Items.SHEARS) && this.isShearable()){
            this.sheared(SoundCategory.PLAYERS);
            this.emitGameEvent(GameEvent.SHEAR, player);
            if(!this.world.isClient()){
                itemStack.damage(1, player, (player1) -> player1.sendToolBreakStatus(hand));
            }
            return ActionResult.success(this.world.isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }

    public void sheared(SoundCategory shearedSoundCategory){
        this.world.playSoundFromEntity(null, this, SoundEvents.ENTITY_MOOSHROOM_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
        if(!this.world.isClient()){
            ((ServerWorld)this.world).spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getBodyY(0.5D), this.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
            this.discard();
            CowEntity cowEntity = EntityType.COW.create(this.world);
            assert cowEntity != null;
            cowEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), this.getPitch());
            cowEntity.setHealth(this.getHealth());
            cowEntity.bodyYaw = this.bodyYaw;
            if (this.hasCustomName()) {
                cowEntity.setCustomName(this.getCustomName());
                cowEntity.setCustomNameVisible(this.isCustomNameVisible());
            }
            if (this.isPersistent()) {
                cowEntity.setPersistent();
            }
            cowEntity.setInvulnerable(this.isInvulnerable());
            this.world.spawnEntity(cowEntity);
            for(int i = 0; i < 3; ++i) {
                this.world.spawnEntity(new ItemEntity(this.world, this.getX(), this.getBodyY(1.0D), this.getZ(), new ItemStack(Items.APPLE)));
            }
        }
    }

    public boolean isShearable() {
        return this.isAlive() && !this.isBaby();
    }

}
