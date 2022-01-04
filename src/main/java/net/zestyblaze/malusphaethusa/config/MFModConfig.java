package net.zestyblaze.malusphaethusa.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;

@Config(name = MalusPhaethusa.MODID)
public class MFModConfig implements ConfigData {
    public boolean debugMode = false;

    @ConfigEntry.Gui.CollapsibleObject
    public AppleCow appleCow = new AppleCow();

    public static class AppleCow {
        public int acSpawnWeight = 3;
        public int acMinGroupSize = 4;
        public int acMaxGroupSize = 8;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public GoldenAppleCow goldenAppleCow = new GoldenAppleCow();

    public static class GoldenAppleCow {
        public int gacSpawnWeight = 1;
        public int gacMinGroupSize = 3;
        public int gacMaxGroupSize = 6;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public EnchantedGoldenAppleCow eGoldenAppleCow = new EnchantedGoldenAppleCow();

    public static class EnchantedGoldenAppleCow {
        public int egacSpawnWeight = 1;
        public int egacMinGroupSize = 1;
        public int egacMaxGroupSize = 3;
    }

    public static MFModConfig get() {
        return AutoConfig.getConfigHolder(MFModConfig.class).getConfig();
    }
}
