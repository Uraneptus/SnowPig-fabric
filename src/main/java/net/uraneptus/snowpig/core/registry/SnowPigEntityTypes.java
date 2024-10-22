package net.uraneptus.snowpig.core.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.uraneptus.snowpig.SnowPig;
import net.uraneptus.snowpig.common.entities.SnowPigEntity;

public class SnowPigEntityTypes {
    public static final EntityType<SnowPigEntity> SNOW_PIG = EntityType.Builder
            .create(SnowPigEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.9f, 0.9f).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, SnowPig.id("snow_pig")));


    public static void registerEntityTypes() {
        FabricDefaultAttributeRegistry.register(SNOW_PIG, SnowPigEntity.createSnowPigAttributes());

        Registry.register(Registries.ENTITY_TYPE, SnowPig.id("snow_pig"), SNOW_PIG);
    }
}