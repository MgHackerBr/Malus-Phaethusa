package net.zestyblaze.goldencows.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.zestyblaze.goldencows.init.EntityInit;

public class AppleCow extends CowEntity {
    public AppleCow(EntityType<? extends CowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public AppleCow createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return EntityInit.APPLE_COW.create(serverWorld);
    }
}
