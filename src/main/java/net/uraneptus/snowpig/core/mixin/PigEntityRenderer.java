package net.uraneptus.snowpig.core.mixin;

import net.minecraft.client.render.entity.state.PigEntityRenderState;
import net.minecraft.entity.passive.PigEntity;
import net.uraneptus.snowpig.client.entity.renderer.FreezingRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.render.entity.PigEntityRenderer.class)
public class PigEntityRenderer {
    @Inject(method = "updateRenderState(Lnet/minecraft/entity/passive/PigEntity;Lnet/minecraft/client/render/entity/state/PigEntityRenderState;F)V", at = @At("HEAD"), cancellable = true)
    private void updateFreezing(PigEntity pigEntity, PigEntityRenderState pigEntityRenderState, float f, CallbackInfo ci){
        if (pigEntityRenderState instanceof FreezingRenderState){
            ((FreezingRenderState) pigEntityRenderState).setFreezing(pigEntity.inPowderSnow);
        }
    }
}
