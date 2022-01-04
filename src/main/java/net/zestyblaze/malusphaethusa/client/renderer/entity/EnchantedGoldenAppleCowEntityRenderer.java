package net.zestyblaze.malusphaethusa.client.renderer.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.zestyblaze.malusphaethusa.client.renderer.feature.EnchantedMobFeatureRenderer;

@SuppressWarnings("ALL")
public class EnchantedGoldenAppleCowEntityRenderer extends GoldenAppleCowEntityRenderer {
    public EnchantedGoldenAppleCowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.addFeature(new EnchantedMobFeatureRenderer(this, context.getModelLoader()));
    }
}
