package net.uraneptus.snowpig.core.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.uraneptus.snowpig.core.registry.SnowPigEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> pEntityType, World world) {
        super(pEntityType, world);
    }

    @Inject(method = "tickMovement()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z", ordinal = 0), cancellable = true)
    private void snowpig_tickMovement(CallbackInfo tickMovement) {
        if (this.getType() == SnowPigEntity.SNOW_PIG) {
            tickMovement.cancel();
        }
    }
}
