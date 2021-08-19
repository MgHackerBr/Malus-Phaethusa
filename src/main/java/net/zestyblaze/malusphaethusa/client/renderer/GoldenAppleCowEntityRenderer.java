package net.zestyblaze.malusphaethusa.client.renderer;

import net.minecraft.client.render.entity.CowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.Identifier;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;

public class GoldenAppleCowEntityRenderer extends CowEntityRenderer {

    public GoldenAppleCowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(CowEntity cowEntity) {
        return new Identifier(MalusPhaethusa.MOD_ID, "textures/entity/golden_apple_cow/golden_apple_cow.png");
    }

}
