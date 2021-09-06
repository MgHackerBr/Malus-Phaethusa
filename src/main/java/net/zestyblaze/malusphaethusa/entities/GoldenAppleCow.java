package net.zestyblaze.malusphaethusa.entities;

import net.minecraft.client.render.entity.feature.SkinOverlayOwner;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.zestyblaze.malusphaethusa.food.EnchantedGoldenMilk;
import net.zestyblaze.malusphaethusa.food.GoldenMilk;
import net.zestyblaze.malusphaethusa.init.EntityInit;
import net.zestyblaze.malusphaethusa.items.GoldenWheat;
import org.jetbrains.annotations.NotNull;

public class GoldenAppleCow extends AppleCow implements SkinOverlayOwner {
    public GoldenAppleCow(EntityType<? extends CowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public GoldenAppleCow createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return EntityInit.GOLDEN_APPLE_COW.create(serverWorld);
    }

    @Override
    public boolean isBreedingItem(@NotNull ItemStack stack) {
        return stack.isOf(GoldenWheat.GOLDEN_WHEAT);
    }

    @Override
    public boolean shouldRenderOverlay() {
        return true;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0D));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.25D, Ingredient.ofItems(GoldenWheat.GOLDEN_WHEAT), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    @Override
    public ActionResult interactMob(@NotNull PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.BUCKET) && !this.isBaby()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, GoldenMilk.GOLDEN_MILK.getDefaultStack());
            player.setStackInHand(hand, itemStack2);
            return ActionResult.success(this.world.isClient);
        } else if(itemStack.isOf(Items.SHEARS) && this.isShearable()){
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
            for(int i = 0; i < 2; ++i) {
                this.world.spawnEntity(new ItemEntity(this.world, this.getX(), this.getBodyY(1.0D), this.getZ(), new ItemStack(Items.GOLDEN_APPLE)));
            }
        }
    }

    public boolean isShearable() {
        return this.isAlive() && !this.isBaby();
    }
}
