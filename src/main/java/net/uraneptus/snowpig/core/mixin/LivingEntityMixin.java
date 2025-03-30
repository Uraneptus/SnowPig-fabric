package net.uraneptus.snowpig.core.mixin;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.conversion.EntityConversionContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.uraneptus.snowpig.core.registry.SnowPigEntityTypes;
import net.uraneptus.snowpig.core.registry.tags.SnowPigEntityTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> pEntityType, World world) {
        super(pEntityType, world);
    }

    @Unique
    private int freezeTicks = 300;

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void doNotMove(ServerWorld world, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir){
        if (source == world.getDamageSources().freeze() && this.getType() == EntityType.PIG){
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void tick(CallbackInfo ci) {
        Entity entity = this;
        if (entity instanceof MobEntity mobEntity && entity.getType().isIn(SnowPigEntityTags.CONVERTS_TO_SNOW_PIG)) {
            if (mobEntity.inPowderSnow) {
                if (mobEntity.isFrozen()) {
                    if (freezeTicks > 0) {
                        freezeTicks--;
                    }
                    if (freezeTicks == 0) {
                        mobEntity.convertTo(SnowPigEntityTypes.SNOW_PIG, EntityConversionContext.create(mobEntity, true, true), snowPig -> {
                            if (!this.isSilent()) {
                                this.getWorld().syncWorldEvent(null, 1048, this.getBlockPos(), 0);
                                if (mobEntity instanceof PigEntity pigEntity){
                                    snowPig.setComponent(DataComponentTypes.PIG_VARIANT, pigEntity.getVariant());
                                }
                            }
                        });
                    }
                }
            }
        }
    }
}