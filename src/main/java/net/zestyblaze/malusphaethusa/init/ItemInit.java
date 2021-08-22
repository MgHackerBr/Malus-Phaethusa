package net.zestyblaze.malusphaethusa.init;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import net.zestyblaze.malusphaethusa.food.EnchantedGoldenBread;
import net.zestyblaze.malusphaethusa.food.EnchantedGoldenMilk;
import net.zestyblaze.malusphaethusa.food.GoldenBread;
import net.zestyblaze.malusphaethusa.food.GoldenMilk;
import net.zestyblaze.malusphaethusa.items.*;

public class ItemInit {
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MOD_ID, "golden_wheat"), GoldenWheat.GOLDEN_WHEAT);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MOD_ID, "enchanted_golden_wheat"), EnchantedGoldenWheat.ENCHANTED_GOLDEN_WHEAT);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MOD_ID, "golden_bread"), GoldenBread.GOLDEN_BREAD);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MOD_ID, "enchanted_golden_bread"), EnchantedGoldenBread.ENCHANTED_GOLDEN_BREAD);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MOD_ID, "golden_milk"), GoldenMilk.GOLDEN_MILK);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MOD_ID, "enchanted_golden_milk"), EnchantedGoldenMilk.ENCHANTED_GOLDEN_MILK);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MOD_ID, "apple_cow_spawn_egg"), AppleCowSpawnEgg.APPLE_COW_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MOD_ID, "golden_apple_cow_spawn_egg"), GoldenAppleCowSpawnEgg.GOLDEN_APPLE_COW_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MOD_ID, "enchanted_golden_apple_cow_spawn_egg"), EnchantedGoldenAppleCowSpawnEgg.ENCHANTED_GOLDEN_APPLE_COW_SPAWN_EGG);
    }
}
