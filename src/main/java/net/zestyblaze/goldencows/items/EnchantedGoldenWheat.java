package net.zestyblaze.goldencows.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.zestyblaze.goldencows.GoldenCows;

import java.util.List;

public class EnchantedGoldenWheat {

    public static final EnchantGoldenWheat ENCHANTED_GOLDEN_WHEAT = new EnchantGoldenWheat(new FabricItemSettings()
            .group(GoldenCows.MAIN_TAB)
            .rarity(Rarity.EPIC)
    );

    public static class EnchantGoldenWheat extends Item {
        public EnchantGoldenWheat(Settings settings) {
            super(settings);
        }
        @Override
        public boolean hasGlint(ItemStack stack) {
            return true;
        }
        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
            tooltip.add(new TranslatableText("item.goldencows.enchanted_golden_wheat.tooltip")
                    .formatted(Formatting.DARK_GRAY)
            );
        }
    }

}
