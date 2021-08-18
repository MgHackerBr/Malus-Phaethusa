package net.zestyblaze.goldencows.items;

import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.zestyblaze.goldencows.GoldenCows;
import net.zestyblaze.goldencows.init.EntityInit;

public class AppleCowSpawnEgg {

    public static Item APPLE_COW_SPAWN_EGG = new SpawnEggItem(
            EntityInit.APPLE_COW,
            14554916,
            16750237,
            new Item.Settings()
                    .group(GoldenCows.MAIN_TAB)
    );

}
