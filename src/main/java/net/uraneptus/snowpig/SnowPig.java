package net.uraneptus.snowpig;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.uraneptus.snowpig.common.entities.SnowPigEntity;
import net.uraneptus.snowpig.core.registry.EntityReg;
import net.uraneptus.snowpig.core.registry.ItemReg;

public class SnowPig implements ModInitializer {

	public static final String MOD_ID = "snowpig";

	@Override
	public void onInitialize() {
		ItemReg.registerItems();
		EntityReg.registerEntityTypes();

		FabricDefaultAttributeRegistry.register(EntityReg.SNOW_PIG, SnowPigEntity.createMobAttributes());
	}
}
