package net.zestyblaze.malusphaethusa.client.renderer.feature;

import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.SkinOverlayOwner;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.Identifier;
import net.zestyblaze.malusphaethusa.init.ClientInit;

public class EnchantedMobFeatureRenderer<T extends CowEntity & SkinOverlayOwner> extends GlintOverlayFeatureRenderer<T, CowEntityModel<T>> {

    private final CowEntityModel<T> model;

    public EnchantedMobFeatureRenderer(FeatureRendererContext<T, CowEntityModel<T>> context, EntityModelLoader loader) {
        super(context);
        this.model = new CowEntityModel(loader.getModelPart(ClientInit.COW_GLINT));
    }

    @Override
    protected float getEnergySwirlX(float partialAge) {
        return 0;
    }

    @Override
    protected Identifier getEnergySwirlTexture() {
        return new Identifier("textures/misc/enchanted_item_glint.png");
    }

    @Override
    protected EntityModel<T> getEnergySwirlModel() {
        return this.model;
    }
}
