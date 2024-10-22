package net.uraneptus.snowpig.core.mixin;


import net.minecraft.client.render.entity.state.PigEntityRenderState;
import net.uraneptus.snowpig.client.entity.renderer.FreezingRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PigEntityRenderState.class)
public class PigRenderStateMixin implements FreezingRenderState {
    private boolean isFreezing;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void initFreezing(CallbackInfo ci){
        isFreezing = false;
    }

    @Override
    public void setFreezing(boolean value) {
        this.isFreezing = value;
    }

    @Override
    public boolean isFreezing() {
        return this.isFreezing;
    }
}
