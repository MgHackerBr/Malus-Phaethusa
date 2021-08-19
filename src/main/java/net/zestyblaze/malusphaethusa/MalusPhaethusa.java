package net.zestyblaze.malusphaethusa;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.zestyblaze.malusphaethusa.init.EntityInit;
import net.zestyblaze.malusphaethusa.init.ItemInit;
import net.zestyblaze.malusphaethusa.init.SpawnInit;
import net.zestyblaze.malusphaethusa.items.EnchantedGoldenWheat;

public class MalusPhaethusa implements ModInitializer {

	public static String MOD_ID = "malusphaethusa";

	public static final ItemGroup MAIN_TAB = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "main_tab"),
			() -> new ItemStack(EnchantedGoldenWheat.ENCHANTED_GOLDEN_WHEAT)
	);

	@Override
	public void onInitialize() {
		EntityInit.register();
		SpawnInit.register();
		ItemInit.register();
	}
}
