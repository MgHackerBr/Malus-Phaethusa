package net.zestyblaze.goldencows.client.renderer;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.zestyblaze.goldencows.GoldenCows;
import net.zestyblaze.goldencows.GoldenCowsClient;
import net.zestyblaze.goldencows.client.model.AppleCowEntityModel;
import net.zestyblaze.goldencows.entities.AppleCow;

public class AppleCowEntityRenderer extends MobEntityRenderer<AppleCow, AppleCowEntityModel> {

    public AppleCowEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AppleCowEntityModel(context.getPart(GoldenCowsClient.MODE_APPLECOW_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(AppleCow entity) {
        return new Identifier(GoldenCows.MOD_ID, "textures/entity/apple_cow/apple_cow.png");
    }

}
