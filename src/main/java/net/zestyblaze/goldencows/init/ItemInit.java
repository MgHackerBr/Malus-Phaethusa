package net.zestyblaze.goldencows.init;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zestyblaze.goldencows.GoldenCows;
import net.zestyblaze.goldencows.food.EnchantedGoldenBread;
import net.zestyblaze.goldencows.food.GoldenBread;
import net.zestyblaze.goldencows.items.AppleCowSpawnEgg;
import net.zestyblaze.goldencows.items.EnchantedGoldenWheat;
import net.zestyblaze.goldencows.items.GoldenAppleCowSpawnEgg;
import net.zestyblaze.goldencows.items.GoldenWheat;

public class ItemInit {
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(GoldenCows.MOD_ID, "golden_wheat"), GoldenWheat.GOLDEN_WHEAT);
        Registry.register(Registry.ITEM, new Identifier(GoldenCows.MOD_ID, "enchanted_golden_wheat"), EnchantedGoldenWheat.ENCHANTED_GOLDEN_WHEAT);
        Registry.register(Registry.ITEM, new Identifier(GoldenCows.MOD_ID, "golden_bread"), GoldenBread.GOLDEN_BREAD);
        Registry.register(Registry.ITEM, new Identifier(GoldenCows.MOD_ID, "enchanted_golden_bread"), EnchantedGoldenBread.ENCHANTED_GOLDEN_BREAD);
        Registry.register(Registry.ITEM, new Identifier(GoldenCows.MOD_ID, "apple_cow_spawn_egg"), AppleCowSpawnEgg.APPLE_COW_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(GoldenCows.MOD_ID, "golden_apple_cow_spawn_egg"), GoldenAppleCowSpawnEgg.GOLDEN_APPLE_COW_SPAWN_EGG);
    }
}
