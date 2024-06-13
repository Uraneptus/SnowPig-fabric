package net.uraneptus.snowpig;


import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.uraneptus.snowpig.common.entities.SnowPigEntity;
import net.uraneptus.snowpig.core.registry.SnowPigEntityTypes;
import net.uraneptus.snowpig.core.registry.SnowPigItems;
import net.uraneptus.snowpig.core.registry.SnowPigSounds;
import net.uraneptus.snowpig.core.tags.SnowPigBiomeTags;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SnowPig implements ModInitializer {
	public static Logger LOGGER = LogManager.getLogger();

	public static final String MOD_ID = "snowpig";
	public static final String MOD_NAME = "Snow Pig";

	@Override
	public void onInitialize() {
		SnowPigItems.init();
		SnowPigEntityTypes.registerEntityTypes();
		SnowPigSounds.registerSounds();

		addMobSpawn(SnowPigBiomeTags.SPAWNS_SNOW_PIG, SpawnGroup.CREATURE, SnowPigEntityTypes.SNOW_PIG, 20, 1, 4);

		FabricDefaultAttributeRegistry.register(SnowPigEntityTypes.SNOW_PIG, SnowPigEntity.createMobAttributes());

		log(Level.INFO, "Snowing The Pig!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static void log(Level level, String message){
		LOGGER.log(level, "["+MOD_NAME+"] " + message);
	}

	void addMobSpawn(TagKey<Biome> tag, SpawnGroup mobCategory, EntityType<?> entityType, int weight, int minGroupSize, int maxGroupSize) {
		BiomeModifications.addSpawn(biomeSelector -> biomeSelector.hasTag(tag), mobCategory, entityType, weight, minGroupSize, maxGroupSize);
	}
}
