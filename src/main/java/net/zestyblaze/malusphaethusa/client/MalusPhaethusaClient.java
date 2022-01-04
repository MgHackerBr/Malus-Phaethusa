package net.zestyblaze.malusphaethusa.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.zestyblaze.malusphaethusa.registry.MFClientInit;

@Environment(EnvType.CLIENT)
public class MalusPhaethusaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MFClientInit.registerClient();
    }
}
