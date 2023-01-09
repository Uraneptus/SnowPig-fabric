package net.uraneptus.snowpig;

import com.google.common.reflect.Reflection;
import me.alphamode.forgetags.Tags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.tag.BiomeTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.uraneptus.snowpig.core.registry.SnowPigEntity;
import net.uraneptus.snowpig.core.registry.SnowPigItems;
import net.uraneptus.snowpig.core.registry.SnowPigSounds;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("UnstableApiUsage")
public class SnowPig implements ModInitializer {
	public static Logger LOGGER = LogManager.getLogger();

	public static final String MOD_ID = "snowpig";
	public static final String MOD_NAME = "Snow Pig";

	@Override
	public void onInitialize() {
		Reflection.initialize(
				SnowPigItems.class
		);

		SnowPigEntity.registerEntityTypes();
		SnowPigSounds.registerSounds();
		addSpawns();

		FabricDefaultAttributeRegistry.register(SnowPigEntity.SNOW_PIG, net.uraneptus.snowpig.common.entities.SnowPigEntity.createMobAttributes());

		new SpawnSettings.SpawnEntry(SnowPigEntity.SNOW_PIG, 20, 1, 4);

		log(Level.INFO, "Snowing The Pig!");
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	public static void log(Level level, String message){
		LOGGER.log(level, "["+MOD_NAME+"] " + message);
	}

	void addSpawns() {
		addMobSpawn(Tags.Biomes.IS_SNOWY, SpawnGroup.CREATURE, SnowPigEntity.SNOW_PIG, 20, 1, 4);
	}

	void addMobSpawn(TagKey<Biome> tag, SpawnGroup mobCategory, EntityType<?> entityType, int weight, int minGroupSize, int maxGroupSize) {
		BiomeModifications.addSpawn(biomeSelector -> biomeSelector.hasTag(tag), mobCategory, entityType, weight, minGroupSize, maxGroupSize);
	}
}
