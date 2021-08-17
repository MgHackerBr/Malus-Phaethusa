package net.zestyblaze.goldencows.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class AppleCow extends PathAwareEntity {
    public AppleCow(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
}
