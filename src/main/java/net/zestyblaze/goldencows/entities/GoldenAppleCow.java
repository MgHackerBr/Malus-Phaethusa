package net.zestyblaze.goldencows.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.zestyblaze.goldencows.init.EntityInit;
import net.zestyblaze.goldencows.items.GoldenWheat;

public class GoldenAppleCow extends CowEntity {
    public GoldenAppleCow(EntityType<? extends CowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public GoldenAppleCow createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return EntityInit.GOLDEN_APPLE_COW.create(serverWorld);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(GoldenWheat.GOLDEN_WHEAT);
    }
}
