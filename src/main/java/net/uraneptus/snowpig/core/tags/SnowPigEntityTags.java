package net.uraneptus.snowpig.core.tags;

import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.uraneptus.snowpig.SnowPig;

public class SnowPigEntityTags {
    public static final TagKey<EntityType<?>> KILLER_FOR_SNOWPIG_DISC = of("killer_for_snowpig_disc");


    private static TagKey<EntityType<?>> of(String id) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, SnowPig.id(id));
    }
}
