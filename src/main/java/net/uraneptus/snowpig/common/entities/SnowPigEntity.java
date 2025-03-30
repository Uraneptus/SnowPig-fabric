package net.uraneptus.snowpig.common.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.conversion.EntityConversionContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;
import net.uraneptus.snowpig.SnowPig;
import net.uraneptus.snowpig.core.registry.SnowPigSounds;

public class SnowPigEntity extends PigEntity{
//    private static final TrackedData<Integer> MELTING_TICKS = DataTracker.registerData(SnowPigEntity.class, TrackedDataHandlerRegistry.INTEGER);
//    public static final int BASE_MELT = 300;
    public SnowPigEntity(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
//        this.setMeltingTicks(BASE_MELT);
    }

//    @Override
//    protected void initDataTracker(DataTracker.Builder builder) {
//        super.initDataTracker(builder);
//        builder.add(MELTING_TICKS, BASE_MELT);
//    }


    @Override
    public boolean canFreeze() {
        return false;
    }
    @Override
    public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {

    }

//    public int getMeltTicks() {
//        return this.dataTracker.get(MELTING_TICKS);
//    }
//    public void setMeltingTicks(int value){
//        this.dataTracker.set(MELTING_TICKS, value);
//    }
//
//    public int getMinBurnDamageTicks(){
//        return 140;
//    }
//
//    public boolean shouldMelt(){
//        return this.getWorld().getDimensionEntry().getKey().get().getValue().equals(DimensionTypes.THE_NETHER_ID);
//    }
//    @Override
//    public void tick() {
//        super.tick();
//        if (this.shouldMelt()) {
//            if (getMeltTicks() > 0) {
//                setMeltingTicks(getMeltTicks() - 1);
//            }
//            if (getMeltTicks() <= 0) {
//                this.convertTo(EntityType.PIG, EntityConversionContext.create(this, true, true), pig -> {
//                    if (!this.isSilent()) {
//                        this.getWorld().syncWorldEvent(null, 1048, this.getBlockPos(), 0);
//                    }
//                });
//            }
//        }
//        else {
//            this.setMeltingTicks(BASE_MELT);
//        }
//        SnowPig.LOGGER.info(getMeltTicks());
//    }

    public static DefaultAttributeContainer.Builder createSnowPigAttributes() {
        return createPigAttributes()
                .add(EntityAttributes.MOVEMENT_SPEED, 0.15D)
                .add(EntityAttributes.MAX_HEALTH, 10.0D)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 0.3D)
                .add(EntityAttributes.ARMOR, 0.5D);
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