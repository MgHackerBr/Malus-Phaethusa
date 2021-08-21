package net.zestyblaze.malusphaethusa.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.zestyblaze.malusphaethusa.init.ClientInit;

@Environment(EnvType.CLIENT)
public class MalusPhaethusaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientInit.register();
    }

}
