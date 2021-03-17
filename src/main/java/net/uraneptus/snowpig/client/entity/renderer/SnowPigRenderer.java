package net.uraneptus.snowpig.client.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.util.Identifier;
import net.uraneptus.snowpig.SnowPig;
import net.uraneptus.snowpig.common.entities.SnowPigEntity;

@Environment(EnvType.CLIENT)
public class SnowPigRenderer extends MobEntityRenderer<SnowPigEntity, PigEntityModel<SnowPigEntity>> {

    protected static final Identifier TEXTURE = new Identifier(SnowPig.MOD_ID, "textures/entity/snow_pig.png");

    public SnowPigRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new PigEntityModel<>(), 0.5f);
        this.addFeature(new SaddleFeatureRenderer<>(this, new PigEntityModel<>(0.5f), new Identifier("textures/entity/pig/pig_saddle.png")));
    }

    @Override
    public Identifier getTexture(SnowPigEntity snowPigEntity) {
        return TEXTURE;
    }
}
