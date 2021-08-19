package net.zestyblaze.malusphaethusa.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.zestyblaze.malusphaethusa.food.GoldenMilk;
import net.zestyblaze.malusphaethusa.init.EntityInit;
import net.zestyblaze.malusphaethusa.items.GoldenWheat;
import org.jetbrains.annotations.NotNull;

public class GoldenAppleCow extends CowEntity {
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
    public ActionResult interactMob(@NotNull PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.BUCKET) && !this.isBaby()) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, player, GoldenMilk.GOLDEN_MILK.getDefaultStack());
            player.setStackInHand(hand, itemStack2);
            return ActionResult.success(this.world.isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }
}