package net.uraneptus.snowpig;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.uraneptus.snowpig.client.entity.renderer.SnowPigRenderer;
import net.uraneptus.snowpig.core.registry.SnowPigEntity;

@Environment(EnvType.CLIENT)
public class SnowPigClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(SnowPigEntity.SNOW_PIG, SnowPigRenderer::new);
    }
}