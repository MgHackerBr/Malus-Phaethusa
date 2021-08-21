package net.zestyblaze.malusphaethusa.init;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import net.zestyblaze.malusphaethusa.blocks.AppleBlock;
import net.zestyblaze.malusphaethusa.blocks.GoldenAppleBlock;

public class BlockInit {
    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(MalusPhaethusa.MOD_ID, "apple_block"), AppleBlock.APPLE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MalusPhaethusa.MOD_ID, "golden_apple_block"), GoldenAppleBlock.GOLDEN_APPLE_BLOCK);
    }
}
