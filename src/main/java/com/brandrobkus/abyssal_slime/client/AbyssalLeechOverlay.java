package com.brandrobkus.abyssal_slime.client;

import com.brandrobkus.abyssal_slime.effect.ModEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

@Environment(EnvType.CLIENT)
public class AbyssalLeechOverlay {

    private static final Identifier POWDER_SNOW_OVERLAY = Identifier.of("minecraft", "textures/misc/powder_snow_overlay.png");

    public static void register() {
        HudRenderCallback.EVENT.register(AbyssalLeechOverlay::onHudRender);
    }

    private static void onHudRender(DrawContext context, RenderTickCounter renderTickCounter) {
    MinecraftClient client = MinecraftClient.getInstance();

        if (client.player == null) return;

        if (client.player.hasStatusEffect(ModEffects.ABYSSAL_LEECH)) {
            renderPowderSnowOverlay(context);
        }
    }

    private static void renderPowderSnowOverlay(DrawContext context) {
        MinecraftClient client = MinecraftClient.getInstance();
        int width = client.getWindow().getScaledWidth();
        int height = client.getWindow().getScaledHeight();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        context.drawTexture(POWDER_SNOW_OVERLAY, 0, 0, 0, 0, width, height, width, height);

        RenderSystem.disableBlend();
    }
}
