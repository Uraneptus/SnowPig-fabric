package net.uraneptus.snowpig.core.mixin;

import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.uraneptus.snowpig.client.entity.renderer.FreezingRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
    @Inject(method = "isShaking", at = @At("RETURN"), cancellable = true)
    private void pigShaking(LivingEntityRenderState state, CallbackInfoReturnable<Boolean> cir) {
        if (state instanceof FreezingRenderState) {
            cir.setReturnValue(((FreezingRenderState) state).isFreezing());
        }
    }
}