package net.zestyblaze.malusphaethusa.client.renderer.feature;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.math.Vec3f;
import net.zestyblaze.malusphaethusa.blocks.AppleBlock;
import org.jetbrains.annotations.NotNull;

public class AppleCowFeatureRenderer<T extends CowEntity> extends FeatureRenderer<T, CowEntityModel<T>> {

    public AppleCowFeatureRenderer(FeatureRendererContext<T, CowEntityModel<T>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, @NotNull T entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if(!entity.isBaby()) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            boolean shouldRender = minecraftClient.hasOutline(entity) && entity.isInvisible();
            if(!entity.isInvisible() || shouldRender) {
                BlockRenderManager blockRenderManager = minecraftClient.getBlockRenderManager();
                BlockState blockState = AppleBlock.APPLE_BLOCK.getDefaultState();
                int renderAsModel = LivingEntityRenderer.getOverlay(entity, 0.0F);
                BakedModel bakedModel = blockRenderManager.getModel(blockState);
                matrices.push();
                matrices.scale(-1.0F, -1.0F, 1.0F);
                matrices.translate(-0.1D, -1.10D, -0.5D);
                this.renderApple(matrices, vertexConsumers, light, shouldRender, blockRenderManager, blockState, renderAsModel, bakedModel);
                matrices.pop();
                matrices.push();
                matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180));
                matrices.scale(-1.0F, -1.0F, 1.0F);
                matrices.translate(0.0D, -0.6D, -0.5D);
                this.renderApple(matrices, vertexConsumers, light, shouldRender, blockRenderManager, blockState, renderAsModel, bakedModel);
                matrices.pop();
                matrices.push();
                matrices.scale(-1.0F, -1.0F, 1.0F);
                matrices.translate(0.0D, -0.6D, -0.25D);
                this.renderApple(matrices, vertexConsumers, light, shouldRender, blockRenderManager, blockState, renderAsModel, bakedModel);
                matrices.pop();
            }
        }
    }

    private void renderApple(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, boolean renderAsModel, BlockRenderManager blockRenderManager, BlockState appleState, int overlay, BakedModel appleModel) {
        if (renderAsModel) {
            blockRenderManager.getModelRenderer().render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getOutline(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE)), appleState, appleModel, 0.0F, 0.0F, 0.0F, light, overlay);
        } else {
            blockRenderManager.renderBlockAsEntity(appleState, matrices, vertexConsumers, light, overlay);
        }
    }

}
