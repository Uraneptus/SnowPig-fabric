package net.uraneptus.snowpig.client.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PhantomEntityModel;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.util.Identifier;
import net.uraneptus.snowpig.SnowPig;
import net.uraneptus.snowpig.common.entities.SnowPigEntity;

@Environment(EnvType.CLIENT)
public class SnowPigEyesFeature<T extends SnowPigEntity> extends EyesFeatureRenderer<T, PigEntityModel<T>> {
    private static final RenderLayer TEXTURE = RenderLayer.getEyes(SnowPig.id("textures/entity/glow_eyes.png"));

    public SnowPigEyesFeature(FeatureRendererContext<T, PigEntityModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return TEXTURE;
    }

}