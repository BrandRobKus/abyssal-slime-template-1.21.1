package com.brandrobkus.abyssal_slime.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

public class RenewedEffect extends StatusEffect {

    protected RenewedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient()) return true;
        if (!(entity instanceof ServerPlayerEntity player)) return true;

        if (player.getHealth() > 4.0F) {
            return true;
        }

        ServerWorld currentWorld = (ServerWorld) player.getWorld();

        ServerWorld targetWorld = currentWorld;
        BlockPos spawn = player.getSpawnPointPosition();

        if (spawn != null) {
            if (!player.getSpawnPointDimension().equals(currentWorld.getRegistryKey())) {
                targetWorld = currentWorld.getServer().getWorld(player.getSpawnPointDimension());
                if (targetWorld == null) {
                    targetWorld = currentWorld.getServer().getOverworld();
                    spawn = targetWorld.getSpawnPos();
                }
            }
        } else {
            targetWorld = currentWorld.getServer().getOverworld();
            spawn = targetWorld.getSpawnPos();
        }

        currentWorld.playSound(null, spawn,
                SoundEvents.AMBIENT_UNDERWATER_ENTER,
                SoundCategory.PLAYERS,
                1.0F, 1.0F);

        currentWorld.spawnParticles(
                ParticleTypes.SQUID_INK,
                spawn.getX() + 0.5, spawn.getY() + 1, spawn.getZ() + 0.5,
                100, 0.5, 0.5, 0.5, 0.2);

        currentWorld.spawnParticles(
                ParticleTypes.DRIPPING_OBSIDIAN_TEAR,
                spawn.getX() + 0.5, spawn.getY() + 1, spawn.getZ() + 0.5,
                75, 0.5, 0.5, 0.5, 0.2);


        player.teleport(
                targetWorld,
                spawn.getX() + 0.5,
                spawn.getY(),
                spawn.getZ() + 0.5,
                player.getYaw(),
                player.getPitch());



        targetWorld.playSound(null, spawn,
                SoundEvents.AMBIENT_UNDERWATER_EXIT,
                SoundCategory.PLAYERS,
                1.0F, 1.0F);

        targetWorld.playSound(null, spawn,
                SoundEvents.ITEM_TOTEM_USE,
                SoundCategory.PLAYERS,
                1.0F, 1.0F);

        targetWorld.spawnParticles(
                ParticleTypes.SQUID_INK,
                spawn.getX() + 0.5, spawn.getY() + 1, spawn.getZ() + 0.5,
                100, 0.5, 0.5, 0.5, 0.2);

        targetWorld.spawnParticles(
                ParticleTypes.DRIPPING_OBSIDIAN_TEAR,
                spawn.getX() + 0.5, spawn.getY() + 1, spawn.getZ() + 0.5,
                75, 0.5, 0.5, 0.5, 0.2);

        player.removeStatusEffect(ModEffects.RENEWED);
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100,2,true,true));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200,0,true,true));
        player.addStatusEffect(new StatusEffectInstance(ModEffects.ABYSSAL_SICKNESS, 12000,0,false,true));
        return false;
    }

}
