package com.brandrobkus.abyssal_slime.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;

public class AbyssalSicknessEffect extends StatusEffect {
    protected AbyssalSicknessEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient()) return true;
        if (!(entity instanceof ServerPlayerEntity player)) return true;

        player.removeStatusEffect(ModEffects.RENEWED);
        return true;
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
