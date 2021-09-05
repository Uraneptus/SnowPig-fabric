package net.uraneptus.snowpig;

import com.google.common.reflect.Reflection;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.uraneptus.snowpig.common.entities.SnowPigEntity;
import net.uraneptus.snowpig.core.registry.EntityRegistry;
import net.uraneptus.snowpig.core.registry.ItemRegistry;
import net.uraneptus.snowpig.core.registry.SoundRegistry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("deprecation")
public class SnowPig implements ModInitializer {
	public static Logger LOGGER = LogManager.getLogger();

	public static final String MOD_ID = "snowpig";
	public static final String MOD_NAME = "Snow Pig";

	@Override
	public void onInitialize() {
		Reflection.initialize(
				ItemRegistry.class
		);

		EntityRegistry.registerEntityTypes();
		SoundRegistry.registerSounds();

		FabricDefaultAttributeRegistry.register(EntityRegistry.SNOW_PIG, SnowPigEntity.createMobAttributes());

		BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.ICY), SpawnGroup.CREATURE, EntityRegistry.SNOW_PIG, 20, 1, 4);

		log(Level.INFO, "Snowing The Pig!");
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	public static void log(Level level, String message){
		LOGGER.log(level, "["+MOD_NAME+"] " + message);
	}
}
