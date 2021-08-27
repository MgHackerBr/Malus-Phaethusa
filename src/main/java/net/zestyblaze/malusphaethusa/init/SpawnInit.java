package net.zestyblaze.malusphaethusa.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;

public class SpawnInit {
    public static void register() {
        BiomeModifications.addSpawn(BiomeSelectors.spawnsOneOf(EntityType.COW),
                SpawnGroup.CREATURE, EntityInit.APPLE_COW, 3, 5, 8);
        BiomeModifications.addSpawn(BiomeSelectors.spawnsOneOf(EntityType.COW),
                SpawnGroup.CREATURE, EntityInit.GOLDEN_APPLE_COW, 1, 3, 6);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.MUSHROOM_FIELDS),
                SpawnGroup.CREATURE, EntityInit.ENCHANTED_GOLDEN_APPLE_COW, 1, 1, 3);
    }
}
