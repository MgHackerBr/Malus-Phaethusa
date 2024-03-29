package net.zestyblaze.malusphaethusa.init;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import net.zestyblaze.malusphaethusa.blocks.AppleBlock;
import net.zestyblaze.malusphaethusa.blocks.GoldenAppleBlock;
import net.zestyblaze.malusphaethusa.client.renderer.entity.AppleCowEntityRenderer;
import net.zestyblaze.malusphaethusa.client.renderer.entity.EnchantedGoldenAppleCowEntityRenderer;
import net.zestyblaze.malusphaethusa.client.renderer.entity.GoldenAppleCowEntityRenderer;

public class ClientInit {
    public static final EntityModelLayer COW_GLINT = new EntityModelLayer(new Identifier(MalusPhaethusa.MOD_ID, "cow_glint"), "main");
    public static void register() {
        EntityRendererRegistry.INSTANCE.register(EntityInit.APPLE_COW, AppleCowEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(EntityInit.GOLDEN_APPLE_COW, GoldenAppleCowEntityRenderer::new);
        EntityRendererRegistry.INSTANCE.register(EntityInit.ENCHANTED_GOLDEN_APPLE_COW, EnchantedGoldenAppleCowEntityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(AppleBlock.APPLE_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GoldenAppleBlock.GOLDEN_APPLE_BLOCK, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(COW_GLINT, CowEntityModel::getTexturedModelData);
    }
}
