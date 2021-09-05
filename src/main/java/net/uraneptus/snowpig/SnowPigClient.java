package net.uraneptus.snowpig;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.uraneptus.snowpig.client.entity.renderer.SnowPigRenderer;
import net.uraneptus.snowpig.core.registry.EntityRegistry;

@Environment(EnvType.CLIENT)
public class SnowPigClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.SNOW_PIG, SnowPigRenderer::new);
    }
}