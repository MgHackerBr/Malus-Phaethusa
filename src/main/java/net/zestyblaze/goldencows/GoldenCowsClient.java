package net.zestyblaze.goldencows;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.zestyblaze.goldencows.client.renderer.AppleCowEntityRenderer;
import net.zestyblaze.goldencows.init.EntityInit;

@Environment(EnvType.CLIENT)
public class GoldenCowsClient implements ClientModInitializer {

    public static final EntityModelLayer MODEL_APPLECOW_LAYER = new EntityModelLayer(
            new Identifier(GoldenCows.MOD_ID, "apple_cow"),
            "main"
    );

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(EntityInit.APPLE_COW, AppleCowEntityRenderer::new);
    }

}
