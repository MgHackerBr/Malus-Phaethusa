package net.zestyblaze.goldencows;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.zestyblaze.goldencows.client.renderer.AppleCowEntityRenderer;
import net.zestyblaze.goldencows.client.renderer.GoldenAppleCowEntityRenderer;
import net.zestyblaze.goldencows.init.EntityInit;

@Environment(EnvType.CLIENT)
public class GoldenCowsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(EntityInit.APPLE_COW, AppleCowEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_APPLE_COW, GoldenAppleCowEntityRenderer::new);
    }

}
