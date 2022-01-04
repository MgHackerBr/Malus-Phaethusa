package net.zestyblaze.malusphaethusa.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import net.zestyblaze.malusphaethusa.config.MFModConfig;
import net.zestyblaze.malusphaethusa.item.EnchantedGoldenBreadItem;
import net.zestyblaze.malusphaethusa.item.EnchantedGoldenMilkItem;
import net.zestyblaze.malusphaethusa.item.GoldenBreadItem;
import net.zestyblaze.malusphaethusa.item.GoldenMilkItem;
import net.zestyblaze.malusphaethusa.item.*;

public class MFItemInit {
    public static final Item GOLDEN_WHEAT = new GoldenWheatItem(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.RARE));
    public static final Item ENCHANTED_GOLDEN_WHEAT = new EnchantedGoldenWheat(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC));
    public static final Item GOLDEN_BREAD = new GoldenBreadItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(3).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3000, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 140, 0), 1.0F).alwaysEdible().build()).rarity(Rarity.RARE).group(ItemGroup.FOOD));
    public static final Item ENCHANTED_GOLDEN_BREAD = new EnchantedGoldenBreadItem(new FabricItemSettings().food(new FoodComponent.Builder().hunger(4).saturationModifier(1.3F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1500, 3), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 700, 1), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 4200, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3200, 0), 1.0F).alwaysEdible().build()).rarity(Rarity.EPIC).group(ItemGroup.FOOD));
    public static final Item GOLDEN_MILK = new GoldenMilkItem(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1).group(ItemGroup.MISC));
    public static final Item ENCHANTED_GOLDEN_MILK = new EnchantedGoldenMilkItem(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1).group(ItemGroup.MISC));
    public static final Item APPLE_COW_SPAWN_EGG = new SpawnEggItem(MFEntityInit.APPLE_COW, 14554916, 16750237, new Item.Settings().group(ItemGroup.MISC));
    public static final Item GOLDEN_APPLE_COW_SPAWN_EGG = new SpawnEggItem(MFEntityInit.GOLDEN_APPLE_COW, 15714384, 16776935, new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.RARE));
    public static final Item ENCHANTED_GOLDEN_APPLE_COW_SPAWN_EGG = new GlintedItem(MFEntityInit.ENCHANTED_GOLDEN_APPLE_COW, 15714384, 16776935, new FabricItemSettings().rarity(Rarity.EPIC).group(ItemGroup.MISC));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MODID, "golden_wheat"), GOLDEN_WHEAT);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MODID, "enchanted_golden_wheat"), ENCHANTED_GOLDEN_WHEAT);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MODID, "golden_bread"), GOLDEN_BREAD);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MODID, "enchanted_golden_bread"), ENCHANTED_GOLDEN_BREAD);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MODID, "golden_milk"), GOLDEN_MILK);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MODID, "enchanted_golden_milk"), ENCHANTED_GOLDEN_MILK);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MODID, "apple_cow_spawn_egg"), APPLE_COW_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MODID, "golden_apple_cow_spawn_egg"), GOLDEN_APPLE_COW_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(MalusPhaethusa.MODID, "enchanted_golden_apple_cow_spawn_egg"), ENCHANTED_GOLDEN_APPLE_COW_SPAWN_EGG);

        if(MFModConfig.get().debugMode) {
            MalusPhaethusa.LOGGER.info("Malus Phaethusa: Registry - Items Registered");
        }
    }
}
