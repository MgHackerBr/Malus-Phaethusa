package net.zestyblaze.malusphaethusa.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;

public class SpawnInit {
    public static void register() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                SpawnGroup.CREATURE, EntityInit.APPLE_COW, 4, 10, 30);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                SpawnGroup.CREATURE, EntityInit.GOLDEN_APPLE_COW, 4, 10, 30);
    }
}
