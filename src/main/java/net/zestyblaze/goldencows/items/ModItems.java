package net.zestyblaze.goldencows.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import net.zestyblaze.goldencows.GoldenCows;

public class ModItems {

    public static final Item GOLDEN_WHEAT = new Item(new FabricItemSettings()
            .group(GoldenCows.MAIN_TAB)
            .rarity(Rarity.RARE)
    );

    public static final EnchantedGoldenWheat ENCHANTED_GOLDEN_WHEAT = new EnchantedGoldenWheat(new FabricItemSettings()
            .group(GoldenCows.MAIN_TAB)
            .rarity(Rarity.EPIC)
    );

    public static class EnchantedGoldenWheat extends Item {
        public EnchantedGoldenWheat(Settings settings) {
            super(settings);
        }
        @Override
        public boolean hasGlint(ItemStack stack) {
            return true;
        }
    }

}
