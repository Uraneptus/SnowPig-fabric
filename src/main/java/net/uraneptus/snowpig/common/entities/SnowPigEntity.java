package net.uraneptus.snowpig.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.uraneptus.snowpig.core.registry.EntityReg;

import java.util.Random;

public class SnowPigEntity extends PigEntity {

    public SnowPigEntity(EntityType<? extends SnowPigEntity> snowpig, World worldIn) {
        super(snowpig, worldIn);
    }

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.3D)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5D);
    }

    public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {
        return;
    }

    public static boolean canSpawn(EntityType<SnowPigEntity> entityType, ServerWorldAccess world, SpawnReason reason, BlockPos pos, Random random) {
        return world.getLightLevel(pos, 0) >8;
    }

    @Override
    public PigEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return EntityReg.SNOW_PIG.create(serverWorld);
    }


}
