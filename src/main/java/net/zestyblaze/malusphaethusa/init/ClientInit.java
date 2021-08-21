package net.zestyblaze.malusphaethusa.init;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.zestyblaze.malusphaethusa.blocks.AppleBlock;
import net.zestyblaze.malusphaethusa.blocks.GoldenAppleBlock;
import net.zestyblaze.malusphaethusa.client.renderer.entity.AppleCowEntityRenderer;
import net.zestyblaze.malusphaethusa.client.renderer.entity.GoldenAppleCowEntityRenderer;

public class ClientInit {
    public static void register() {
        EntityRendererRegistry.INSTANCE.register(EntityInit.APPLE_COW, AppleCowEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_APPLE_COW, GoldenAppleCowEntityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(AppleBlock.APPLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GoldenAppleBlock.GOLDEN_APPLE_BLOCK, RenderLayer.getCutout());
    }
}
