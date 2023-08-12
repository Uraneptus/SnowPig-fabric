package net.uraneptus.snowpig.core.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.uraneptus.snowpig.SnowPig;
import net.uraneptus.snowpig.common.entities.SnowPigEntity;

public class SnowPigEntityTypes {
    public static final EntityType<SnowPigEntity> SNOW_PIG = FabricEntityTypeBuilder
            .create(SpawnGroup.CREATURE, SnowPigEntity::new)
            .dimensions(EntityDimensions.fixed(0.9f, 0.9f)).build();


    public static void registerEntityTypes() {
        FabricDefaultAttributeRegistry.register(SNOW_PIG, SnowPigEntity.createSnowPigAttributes());

        Registry.register(Registries.ENTITY_TYPE, new Identifier(SnowPig.MOD_ID, "snow_pig"), SNOW_PIG);
    }
}