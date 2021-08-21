package net.zestyblaze.malusphaethusa.client.renderer.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import net.zestyblaze.malusphaethusa.client.renderer.feature.AppleCowFeatureRenderer;
import net.zestyblaze.malusphaethusa.entities.AppleCow;

public class AppleCowEntityRenderer extends MobEntityRenderer<AppleCow, CowEntityModel<AppleCow>> {

    public AppleCowEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CowEntityModel<>(context.getPart(EntityModelLayers.COW)), 0.5f);
        this.addFeature(new AppleCowFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(AppleCow entity) {
        return new Identifier(MalusPhaethusa.MOD_ID, "textures/entity/apple_cow.png");
    }
}
