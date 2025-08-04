package com.brandrobkus.abyssal_slime.effect;

import com.brandrobkus.abyssal_slime.sound.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class ConcussionEffect extends StatusEffect {
    protected ConcussionEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int interval = 30 >> amplifier;
        return duration == 1 || duration % interval == 0;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            if (player.getWorld().isClient) {
                player.playSound(ModSounds.CONCUSSED, 1f, 1f);
            }
        }
        return super.applyUpdateEffect(entity, amplifier);
    }
}
