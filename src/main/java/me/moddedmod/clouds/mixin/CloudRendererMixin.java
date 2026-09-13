package me.moddedmod.clouds.mixin;

import net.minecraft.client.CloudStatus;
import net.minecraft.client.renderer.CloudRenderer;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CloudRenderer.class)
public abstract class CloudRendererMixin {

    @Shadow
    public abstract void render(int color, CloudStatus cloudStatus, float bottomY, int range, Vec3 cameraPosition, long gameTime, float partialTicks);

    @Unique
    private boolean clouds$isRendering = false;

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void clouds$cloudRenderer(int color, CloudStatus cloudStatus, float bottomY, int range, Vec3 cameraPosition, long gameTime, float partialTicks, CallbackInfo ci){

        if (clouds$isRendering){
            return;
        }
        clouds$isRendering = true;
        try {
            this.render(0xFFFFFFFF, cloudStatus, bottomY, range, cameraPosition, gameTime, partialTicks);
            ci.cancel();
        } finally {
            clouds$isRendering = false;
        }
    }
}
