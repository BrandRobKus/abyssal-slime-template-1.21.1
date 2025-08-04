package com.brandrobkus.abyssal_slime.mixin;

import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.brandrobkus.abyssal_slime.effect.ModEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.FogShape;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public class AbyssalFogMixin {

    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private static void applyAbyssalFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client.world == null) return;

        BlockPos cameraPos = BlockPos.ofFloored(camera.getPos());
        BlockState blockState = client.world.getBlockState(cameraPos);

        if (client.player != null) {
            StatusEffectInstance concussed = client.player.getStatusEffect(ModEffects.CONCUSSED);
            if (concussed != null) {
                int duration = concussed.getDuration();
                int maxDuration = 600;

                float fadeInDuration = 20f;
                float fadeOutDuration = 20f;
                float factor;

                if (duration > maxDuration - fadeInDuration) {
                    factor = 1.0f - (duration - (maxDuration - fadeInDuration)) / fadeInDuration;
                } else if (duration < fadeOutDuration) {
                    factor = duration / fadeOutDuration;
                } else {
                    factor = 1.0f;
                }

                factor = Math.min(1f, Math.max(0f, factor));

                float baseFogStart = 10.0f;
                float baseFogEnd = 200.0f;
                float baseR = 1f, baseG = 1f, baseB = 1f;

                float concussionFogStart = 0.1f;
                float concussionFogEnd = 10.0f;
                float concussionR = 1f, concussionG = 1f, concussionB = 1f;

                float fogStart = lerp(baseFogStart, concussionFogStart, factor);
                float fogEnd = lerp(baseFogEnd, concussionFogEnd, factor);
                float r = lerp(baseR, concussionR, factor);
                float g = lerp(baseG, concussionG, factor);
                float b = lerp(baseB, concussionB, factor);

                RenderSystem.setShaderFogStart(fogStart);
                RenderSystem.setShaderFogEnd(fogEnd);
                RenderSystem.setShaderFogShape(FogShape.SPHERE);
                RenderSystem.setShaderFogColor(r, g, b);
                ci.cancel();
                return;
            }
        }

        if (blockState.isOf(ModBlocks.ABYSSAL_POWDER_BLOCK)) {
            RenderSystem.setShaderFogStart(0.0F);
            RenderSystem.setShaderFogEnd(1.25F);
            RenderSystem.setShaderFogShape(FogShape.SPHERE);
            RenderSystem.setShaderFogColor(0.025F, 0.0F, 0.025F);
            ci.cancel();
        }
    }

    @Unique
    private static float lerp(float a, float b, float t) {
        return a + t * (b - a);
    }
}
