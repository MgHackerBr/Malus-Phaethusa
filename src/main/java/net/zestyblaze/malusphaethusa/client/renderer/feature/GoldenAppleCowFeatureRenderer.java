package net.zestyblaze.malusphaethusa.client.renderer.feature;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;
import net.zestyblaze.malusphaethusa.blocks.GoldenAppleBlock;
import net.zestyblaze.malusphaethusa.init.EntityInit;
import net.zestyblaze.malusphaethusa.mixin.ItemRendererAccessor;

public class GoldenAppleCowFeatureRenderer<T extends CowEntity> extends FeatureRenderer<T, CowEntityModel<T>> {

    public static ItemStack stack;
    private final ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

    public GoldenAppleCowFeatureRenderer(FeatureRendererContext<T, CowEntityModel<T>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (!entity.isBaby()) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            boolean shouldRender = minecraftClient.hasOutline(entity) && entity.isInvisible();
            if (!entity.isInvisible() || shouldRender) {
                BlockRenderManager blockRenderManager = minecraftClient.getBlockRenderManager();
                BlockState blockState = GoldenAppleBlock.GOLDEN_APPLE_BLOCK.getDefaultState();
                int renderAsModel = LivingEntityRenderer.getOverlay(entity, 0.0F);
                BakedModel bakedModel = blockRenderManager.getModel(blockState);
                matrices.push();
                matrices.scale(-1.0F, -1.0F, 1.0F);
                matrices.translate(-0.1D, -1.10D, -0.5D);
                this.renderApple(matrices, vertexConsumers, light, shouldRender, blockRenderManager, blockState, renderAsModel, bakedModel, entity);
                matrices.pop();
                matrices.push();
                matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180));
                matrices.scale(-1.0F, -1.0F, 1.0F);
                matrices.translate(0.0D, -0.6D, -0.5D);
                this.renderApple(matrices, vertexConsumers, light, shouldRender, blockRenderManager, blockState, renderAsModel, bakedModel, entity);
                matrices.pop();
                matrices.push();
                matrices.scale(-1.0F, -1.0F, 1.0F);
                matrices.translate(0.0D, -0.6D, -0.25D);
                this.renderApple(matrices, vertexConsumers, light, shouldRender, blockRenderManager, blockState, renderAsModel, bakedModel, entity);
                vertexConsumers.getBuffer(RenderLayer.getEntityGlint());
                matrices.pop();
            }
        }
    }

    private void renderApple(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, boolean renderAsModel, BlockRenderManager blockRenderManager, BlockState appleState, int overlay, BakedModel appleModel, T entity) {
        if (renderAsModel) {
            blockRenderManager.getModelRenderer().render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getOutline(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE)), appleState, appleModel, 0.0F, 0.0F, 0.0F, light, overlay);
        }
        else {
            if(entity.getType() == EntityInit.GOLDEN_APPLE_COW){
                blockRenderManager.renderBlockAsEntity(appleState, matrices, vertexConsumers, light, overlay);
            }

            else {
                if (stack == null) {
                    stack = new ItemStack(appleState.getBlock().asItem());
                }

                matrices.push();
                VertexConsumer vertex = ItemRenderer.getItemGlintConsumer(vertexConsumers, RenderLayers.getItemLayer(stack, false), false, true);

                ((ItemRendererAccessor) itemRenderer).invokeRenderBakedItemModel(appleModel, stack, LightmapTextureManager.pack(15, 15), OverlayTexture.DEFAULT_UV, matrices, vertex);

                matrices.pop();
            }
        }
    }
}
