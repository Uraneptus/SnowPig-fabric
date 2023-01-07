package net.uraneptus.snowpig.core.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.world.World;
import net.uraneptus.snowpig.core.registry.SnowPigEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> pEntityType, World world) {
        super(pEntityType, world);
    }

    @Unique
    private int freezeTicks = 300;


    @Inject(method = "tickMovement()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z", ordinal = 0), cancellable = true)
    private void snowpig_tickMovement(CallbackInfo tickMovement) {
        if (this.getType() == EntityType.PIG) {
            tickMovement.cancel();
        }
    }

    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void tick(CallbackInfo ci) {
        Entity entity = ((LivingEntity) (Object) this);

        if (entity instanceof PigEntity pig) {
            if (pig.inPowderSnow) {
                if (pig.isFrozen()) {
                    if (freezeTicks > 0) {
                        freezeTicks--;
                    }
                    if (freezeTicks == 0) {
                        pig.convertTo(SnowPigEntity.SNOW_PIG, true);
                    }
                }
            }
        }
    }
}