package net.zestyblaze.malusphaethusa.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import net.zestyblaze.malusphaethusa.config.MFModConfig;

public class MFSpawnInit {
    public static void registerSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.spawnsOneOf(EntityType.COW), SpawnGroup.CREATURE, MFEntityInit.APPLE_COW, MFModConfig.get().appleCow.acSpawnWeight, MFModConfig.get().appleCow.acMinGroupSize, MFModConfig.get().appleCow.acMaxGroupSize);
        BiomeModifications.addSpawn(BiomeSelectors.spawnsOneOf(EntityType.COW), SpawnGroup.CREATURE, MFEntityInit.GOLDEN_APPLE_COW, MFModConfig.get().goldenAppleCow.gacSpawnWeight, MFModConfig.get().goldenAppleCow.gacMinGroupSize, MFModConfig.get().goldenAppleCow.gacMaxGroupSize);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.MUSHROOM_FIELDS), SpawnGroup.CREATURE, MFEntityInit.ENCHANTED_GOLDEN_APPLE_COW, MFModConfig.get().eGoldenAppleCow.egacSpawnWeight, MFModConfig.get().eGoldenAppleCow.egacMinGroupSize, MFModConfig.get().eGoldenAppleCow.egacMaxGroupSize);

        if(MFModConfig.get().debugMode) {
            MalusPhaethusa.LOGGER.info("Malus Phaethusa: Registry - Spawns Registered");
        }
    }
}
