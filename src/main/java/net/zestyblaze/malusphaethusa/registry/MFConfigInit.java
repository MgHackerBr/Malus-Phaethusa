package net.zestyblaze.malusphaethusa.registry;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import net.zestyblaze.malusphaethusa.config.MFModConfig;

public class MFConfigInit {
    public static void registerConfig() {
        AutoConfig.register(MFModConfig.class, GsonConfigSerializer::new);

        if(MFModConfig.get().debugMode) {
            MalusPhaethusa.LOGGER.info("Malus Phaethusa: Registry - Config Registered");
        }
    }
}
