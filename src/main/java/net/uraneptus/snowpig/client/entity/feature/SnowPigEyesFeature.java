package net.uraneptus.snowpig.client.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.uraneptus.snowpig.SnowPig;

@Environment(EnvType.CLIENT)
public class SnowPigEyesFeature<S extends EntityRenderState, M extends EntityModel<S>> extends FeatureRenderer<S, M> {
    private static final RenderLayer TEXTURE = RenderLayer.getEyes(SnowPig.id("textures/entity/glow_eyes.png"));
    public SnowPigEyesFeature(FeatureRendererContext<S, M> featureRendererContext) {
        super(featureRendererContext);
    }

    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, S state, float limbAngle, float limbDistance) {
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.getEyesTexture());
        this.getContextModel().render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
    }

    public RenderLayer getEyesTexture(){
        return TEXTURE;
    }
}
