package net.zestyblaze.malusphaethusa;

import net.fabricmc.api.ModInitializer;
import net.zestyblaze.malusphaethusa.config.MFModConfig;
import net.zestyblaze.malusphaethusa.registry.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MalusPhaethusa implements ModInitializer {
	public static final String MODID = "malusphaethusa";
	private static final String MODNAME = "Malus Phaethusa";
	public static final Logger LOGGER = LogManager.getLogger(MODNAME);

	@Override
	public void onInitialize() {
		LOGGER.info("Malus Phaethusa is successfully installed! Thanks for downloading! <3");
		MFConfigInit.registerConfig();
		MFItemInit.registerItems();
		MFBlockInit.registerBlocks();
		MFEntityInit.registerEntities();
		MFSpawnInit.registerSpawns();

		if(MFModConfig.get().debugMode) {
			LOGGER.info("Malus Phaethusa: Registry - Mod Fully Loaded!");
		}
	}
}
