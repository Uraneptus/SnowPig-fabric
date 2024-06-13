package net.uraneptus.snowpig.client.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.PigEntityRenderer;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.Identifier;
import net.uraneptus.snowpig.SnowPig;
import net.uraneptus.snowpig.client.entity.feature.SnowPigEyesFeature;
import net.uraneptus.snowpig.common.entities.SnowPigEntity;

@Environment(EnvType.CLIENT)
public class SnowPigRenderer extends PigEntityRenderer{
    protected static final Identifier TEXTURE = SnowPig.id("textures/entity/snow_pig.png");

    public SnowPigRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.addFeature(new SnowPigEyesFeature(this));
    }

    @Override
    public Identifier getTexture(PigEntity pigEntity) {
        return TEXTURE;
    }
}