package net.zestyblaze.malusphaethusa.food;

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
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EnchantedGoldenBread {

    public static final EnchantGoldenBread ENCHANTED_GOLDEN_BREAD = new EnchantGoldenBread(new FabricItemSettings()
            .food(new FoodComponent.Builder()
                    .alwaysEdible()
                    .hunger(4)
                    .saturationModifier(9.6F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2000, 4), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 700, 1), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 4200, 0), 1.0F)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 4800, 0), 1.0F)
                    .build())
            .rarity(Rarity.EPIC)
            .group(MalusPhaethusa.MAIN_TAB)
    );

    public static class EnchantGoldenBread extends Item {
        public EnchantGoldenBread(Item.Settings settings) {
            super(settings);
        }
        @Override
        public boolean hasGlint(ItemStack stack) {
            return true;
        }
        @Override
        public void appendTooltip(ItemStack itemStack, World world, @NotNull List<Text> tooltip, TooltipContext tooltipContext) {
            tooltip.add(new TranslatableText("item.malusphaethusa.enchanted_golden_bread.tooltip")
                    .formatted(Formatting.DARK_GRAY)
            );
        }
    }
}
