package net.zestyblaze.goldencows.items;

import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.zestyblaze.goldencows.GoldenCows;
import net.zestyblaze.goldencows.init.EntityInit;

public class GoldenAppleCowSpawnEgg {

    public static Item GOLDEN_APPLE_COW_SPAWN_EGG = new SpawnEggItem(
            EntityInit.GOLDEN_APPLE_COW,
            15714384,
            16776935,
            new Item.Settings()
                    .group(GoldenCows.MAIN_TAB)
    );

}
