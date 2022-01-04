package net.zestyblaze.malusphaethusa.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import net.zestyblaze.malusphaethusa.blocks.AppleBlock;
import net.zestyblaze.malusphaethusa.blocks.GoldenAppleBlock;
import net.zestyblaze.malusphaethusa.config.MFModConfig;

public class MFBlockInit {
    public static final Block APPLE_BLOCK = new AppleBlock(FabricBlockSettings.of(Material.PLANT));
    public static final Block GOLDEN_APPLE_BLOCK = new GoldenAppleBlock(FabricBlockSettings.of(Material.PLANT));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(MalusPhaethusa.MODID, "apple_block"), APPLE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MalusPhaethusa.MODID, "golden_apple_block"), GOLDEN_APPLE_BLOCK);

        if(MFModConfig.get().debugMode) {
            MalusPhaethusa.LOGGER.info("Malus Phaethusa: Registry - Blocks Registered");
        }
    }
}
