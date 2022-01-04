package net.zestyblaze.malusphaethusa.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;

public class GlintedItem extends SpawnEggItem {
    public GlintedItem(EntityType<? extends MobEntity> type, int primaryColor, int secondaryColor, Settings settings) {
        super(type, primaryColor, secondaryColor, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
            return true;
        }

}
