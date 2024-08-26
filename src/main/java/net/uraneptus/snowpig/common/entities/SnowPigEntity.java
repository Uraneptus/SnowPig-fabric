package net.uraneptus.snowpig.common.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.uraneptus.snowpig.core.registry.SnowPigSounds;

//TODO create event to access the pig's tick method for the transformation to the snowpig
public class SnowPigEntity extends PigEntity{
    public SnowPigEntity(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean canFreeze() {
        return false;
    }

    @Override
    public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {

    }

    public static DefaultAttributeContainer.Builder createSnowPigAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.3D)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5D);
    }


    @Override
    public float getMovementSpeed() {
        return super.getMovementSpeed() / 6;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SnowPigSounds.SNOW_PIG_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SnowPigSounds.SNOW_PIG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SnowPigSounds.SNOW_PIG_DEATH;
    }
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SnowPigSounds.SNOW_PIG_STEP, 0.15F, 1.0F);
    }
}