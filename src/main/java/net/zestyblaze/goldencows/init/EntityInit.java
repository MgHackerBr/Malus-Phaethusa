package net.zestyblaze.goldencows.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.BiomeKeys;
import net.zestyblaze.goldencows.GoldenCows;
import net.zestyblaze.goldencows.entities.AppleCow;

public class EntityInit {

    public static final EntityType<AppleCow> APPLE_COW = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(GoldenCows.MOD_ID, "apple_cow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AppleCow::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 1.4f))
                    .build()
    );

    public static void register() {

        FabricDefaultAttributeRegistry.register(APPLE_COW, AppleCow.createCowAttributes());

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                SpawnGroup.CREATURE, APPLE_COW, 4, 10, 30);

    }

}
