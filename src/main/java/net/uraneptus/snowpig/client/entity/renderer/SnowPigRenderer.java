package net.uraneptus.snowpig.client.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.util.Identifier;
import net.uraneptus.snowpig.SnowPig;
import net.uraneptus.snowpig.client.entity.feature.SnowPigEyesFeature;
import net.uraneptus.snowpig.common.entities.SnowPigEntity;

@Environment(EnvType.CLIENT)
public class SnowPigRenderer extends MobEntityRenderer<SnowPigEntity, PigEntityModel<SnowPigEntity>> {

    protected static final Identifier TEXTURE = new Identifier(SnowPig.MOD_ID, "textures/entity/snow_pig.png");

    public SnowPigRenderer(EntityRendererFactory.Context context) {
        super(context, new PigEntityModel(context.getPart(EntityModelLayers.PIG)), 0.7F);
        this.addFeature(new SaddleFeatureRenderer(this, new PigEntityModel(context.getPart(EntityModelLayers.PIG_SADDLE)), new Identifier("textures/entity/pig/pig_saddle.png")));
        this.addFeature(new SnowPigEyesFeature(this));
    }

    @Override
    public Identifier getTexture(SnowPigEntity snowPigEntity) {
        return TEXTURE;
    }
}
