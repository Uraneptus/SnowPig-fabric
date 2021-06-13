package net.uraneptus.snowpig.common.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.uraneptus.snowpig.core.registry.EntityReg;
import net.uraneptus.snowpig.core.registry.SoundReg;

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
    }

    public static boolean canSpawn(EntityType<SnowPigEntity> entityType, ServerWorldAccess world, SpawnReason reason, BlockPos pos, Random random) {
        return world.getLightLevel(pos, 0) >8;
    }

    @Override
    public PigEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return EntityReg.SNOW_PIG.create(serverWorld);
    }

    public SoundEvent getAmbientSound() {
        return SoundReg.SNOW_PIG_AMBIENT;
    }

    public SoundEvent getHurtSound(DamageSource source) {
        return SoundReg.SNOW_PIG_HURT;
    }

    public SoundEvent getDeathSound() {
        return SoundReg.SNOW_PIG_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundReg.SNOW_PIG_STEP, 0.15F, 1.0F);
    }
}
