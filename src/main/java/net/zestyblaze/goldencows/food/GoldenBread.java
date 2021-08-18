package net.zestyblaze.goldencows.food;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.zestyblaze.goldencows.GoldenCows;

import java.util.List;

public class GoldenBread {
    public static final GoldenBreadItem GOLDEN_BREAD = new GoldenBreadItem(new FabricItemSettings()
            .food(new FoodComponent.Builder()
                    .alwaysEdible()
                    .hunger(2)
                    .saturationModifier(4.8F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 0), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 50, 0), 1.0F)
                    .build())
            .rarity(Rarity.RARE)
            .group(GoldenCows.MAIN_TAB)
    );
    public static class GoldenBreadItem extends Item {
        public GoldenBreadItem(Item.Settings settings) {
            super(settings);
        }
        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
            tooltip.add(new TranslatableText("item.goldencows.golden_bread.tooltip")
                    .formatted(Formatting.DARK_GRAY)
            );
        }
    }
}
