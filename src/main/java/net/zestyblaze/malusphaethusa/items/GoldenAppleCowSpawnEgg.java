package net.zestyblaze.malusphaethusa.items;

import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Rarity;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import net.zestyblaze.malusphaethusa.init.EntityInit;

public class GoldenAppleCowSpawnEgg {

    public static Item GOLDEN_APPLE_COW_SPAWN_EGG = new SpawnEggItem(
            EntityInit.GOLDEN_APPLE_COW,
            15714384,
            16776935,
            new Item.Settings()
                    .group(MalusPhaethusa.MAIN_TAB)
                    .rarity(Rarity.RARE)
    );

}
