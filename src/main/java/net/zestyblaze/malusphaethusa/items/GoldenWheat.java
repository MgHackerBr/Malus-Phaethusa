package net.zestyblaze.malusphaethusa.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GoldenWheat {

    public static final GoldenWheatItem GOLDEN_WHEAT = new GoldenWheatItem(new FabricItemSettings()
            .group(MalusPhaethusa.MAIN_TAB)
            .rarity(Rarity.RARE)
    );

    public static class GoldenWheatItem extends Item {
        public GoldenWheatItem(Settings settings) {
            super(settings);
        }
        @Override
        public void appendTooltip(ItemStack itemStack, World world, @NotNull List<Text> tooltip, TooltipContext tooltipContext) {
            tooltip.add(new TranslatableText("item.malusphaethusa.golden_wheat.tooltip")
                    .formatted(Formatting.DARK_GRAY)
            );
        }
    }

}
