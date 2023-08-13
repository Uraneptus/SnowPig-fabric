package net.uraneptus.snowpig.core.mixin;

import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PigEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {

    @Inject(method = "isShaking(Lnet/minecraft/entity/LivingEntity;)Z", at = @At("HEAD"), cancellable = true)
    private void snowpig_isShaking(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof PigEntity pig) {
            if (pig.isFrozen()) {
                cir.setReturnValue(true);
            }
        }
    }
}