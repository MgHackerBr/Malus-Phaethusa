package net.zestyblaze.malusphaethusa.registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import net.zestyblaze.malusphaethusa.client.renderer.entity.AppleCowEntityRenderer;
import net.zestyblaze.malusphaethusa.client.renderer.entity.EnchantedGoldenAppleCowEntityRenderer;
import net.zestyblaze.malusphaethusa.client.renderer.entity.GoldenAppleCowEntityRenderer;
import net.zestyblaze.malusphaethusa.config.MFModConfig;

public class MFClientInit {
    public static final EntityModelLayer COW_GLINT = new EntityModelLayer(new Identifier(MalusPhaethusa.MODID, "cow_glint"), "main");

    public static void registerClient() {
        EntityRendererRegistry.register(MFEntityInit.APPLE_COW, AppleCowEntityRenderer::new);
        EntityRendererRegistry.register(MFEntityInit.GOLDEN_APPLE_COW, GoldenAppleCowEntityRenderer::new);
        EntityRendererRegistry.register(MFEntityInit.ENCHANTED_GOLDEN_APPLE_COW, EnchantedGoldenAppleCowEntityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(MFBlockInit.APPLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MFBlockInit.GOLDEN_APPLE_BLOCK, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(COW_GLINT, CowEntityModel::getTexturedModelData);

        if(MFModConfig.get().debugMode) {
            MalusPhaethusa.LOGGER.info("Malus Phaethusa: Registry - Client Registered");
        }
    }
}
