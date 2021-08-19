package net.zestyblaze.malusphaethusa.food;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GoldenMilk {

    public static final GoldenMilkItem GOLDEN_MILK = new GoldenMilkItem(new FabricItemSettings()
            .rarity(Rarity.RARE)
            .group(MalusPhaethusa.MAIN_TAB)
    );

    public static class GoldenMilkItem extends MilkBucketItem{
        public GoldenMilkItem(Settings settings) {
            super(settings);
        }
        @Override
        public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
            if (user instanceof ServerPlayerEntity serverPlayerEntity) {
                Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
                serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            }
            if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
                stack.decrement(1);
            }
            if (!world.isClient) {
                user.clearStatusEffects();
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 0, false, false));
            }
            return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
        }
        @Override
        public void appendTooltip(ItemStack itemStack, World world, @NotNull List<Text> tooltip, TooltipContext tooltipContext) {
            tooltip.add(new TranslatableText("item.malusphaethusa.golden_milk.tooltip")
                    .formatted(Formatting.DARK_GRAY)
            );
        }
    }

}
