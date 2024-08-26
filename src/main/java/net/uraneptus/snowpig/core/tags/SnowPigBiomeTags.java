package net.uraneptus.snowpig.core.tags;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;
import net.uraneptus.snowpig.SnowPig;

public class SnowPigBiomeTags {
    public static final TagKey<Biome> SPAWNS_SNOW_PIG = of("spawns_snow_pig");


    private static TagKey<Biome> of(String id) {
        return TagKey.of(RegistryKeys.BIOME, SnowPig.id(id));
    }
}
