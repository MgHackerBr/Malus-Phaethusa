package net.zestyblaze.malusphaethusa.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Rarity;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import net.zestyblaze.malusphaethusa.init.EntityInit;

public class EnchantedGoldenAppleCowSpawnEgg {

    public static EnchantedEgg ENCHANTED_GOLDEN_APPLE_COW_SPAWN_EGG = new EnchantedEgg(
            EntityInit.ENCHANTED_GOLDEN_APPLE_COW,
            15714384,
            16776935,
            new Item.Settings()
                    .group(MalusPhaethusa.MAIN_TAB)
                    .rarity(Rarity.EPIC)
    );

    public static class EnchantedEgg extends SpawnEggItem{
        public EnchantedEgg(EntityType<? extends MobEntity> type, int primaryColor, int secondaryColor, Settings settings) {
            super(type, primaryColor, secondaryColor, settings);
        }
        @Override
        public boolean hasGlint(ItemStack stack) {
            return true;
        }
    }

}
