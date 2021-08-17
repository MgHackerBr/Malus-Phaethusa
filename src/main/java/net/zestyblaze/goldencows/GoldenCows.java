package net.zestyblaze.goldencows;

import net.fabricmc.api.ModInitializer;
import net.zestyblaze.goldencows.init.EntityInit;

public class GoldenCows implements ModInitializer {

	public static String MOD_ID = "goldencows";

	@Override
	public void onInitialize() {

		EntityInit.register();

	}
}
