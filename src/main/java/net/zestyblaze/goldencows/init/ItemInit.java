package net.zestyblaze.goldencows.init;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zestyblaze.goldencows.GoldenCows;
import net.zestyblaze.goldencows.items.ModItems;

public class ItemInit {

    public static void register() {

        Registry.register(Registry.ITEM, new Identifier(GoldenCows.MOD_ID, "golden_wheat"), ModItems.GOLDEN_WHEAT);
        Registry.register(Registry.ITEM, new Identifier(GoldenCows.MOD_ID, "enchanted_golden_wheat"), ModItems.ENCHANTED_GOLDEN_WHEAT);

    }

}
