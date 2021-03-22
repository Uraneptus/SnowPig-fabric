package net.uraneptus.snowpig;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.uraneptus.snowpig.common.entities.SnowPigEntity;
import net.uraneptus.snowpig.core.registry.EntityReg;
import net.uraneptus.snowpig.core.registry.ItemReg;

@SuppressWarnings("deprecation")
public class SnowPig implements ModInitializer {

	public static final String MOD_ID = "snowpig";

	@Override
	public void onInitialize() {
		ItemReg.registerItems();
		EntityReg.registerEntityTypes();

		FabricDefaultAttributeRegistry.register(EntityReg.SNOW_PIG, SnowPigEntity.createMobAttributes());

		BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.ICY), SpawnGroup.CREATURE, EntityReg.SNOW_PIG, 20, 1, 4);

	}
}
