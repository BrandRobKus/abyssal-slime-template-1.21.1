package com.brandrobkus.abyssal_slime.effect;

import com.brandrobkus.abyssal_slime.entity.ModEntities;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalBlazeEntity;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalCreeperEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AbyssalLeechEffect extends StatusEffect {
    protected AbyssalLeechEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient && entity instanceof CreeperEntity creeper) {
            if (!creeper.hasCustomName()) {
                World world = creeper.getWorld();
                BlockPos pos = creeper.getBlockPos();
                float health = creeper.getHealth();

                creeper.discard();

                AbyssalCreeperEntity abyssal = new AbyssalCreeperEntity(ModEntities.ABYSSAL_CREEPER, world);
                abyssal.refreshPositionAndAngles(pos, 0.0F, 0.0F);
                abyssal.setHealth(health);
                world.playSound(null, creeper.getBlockPos(), SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, SoundCategory.HOSTILE, 1.0F, 1.0F);

                ((ServerWorld) world).spawnParticles(ParticleTypes.SQUID_INK,
                        pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 150,
                        0.5, 0.5, 0.5, 0.2);

                ((ServerWorld) world).spawnParticles(
                        ParticleTypes.DRIPPING_OBSIDIAN_TEAR,
                        pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                        75, 0.5, 0.5, 0.5, 0.2);

                world.spawnEntity(abyssal);
            }
        }

        if (!entity.getWorld().isClient && entity instanceof BlazeEntity blaze) {
            if (!blaze.hasCustomName()) {
                World world = blaze.getWorld();
                BlockPos pos = blaze.getBlockPos();
                float health = blaze.getHealth();

                blaze.discard();

                AbyssalBlazeEntity abyssal = new AbyssalBlazeEntity(ModEntities.ABYSSAL_BLAZE, world);
                abyssal.refreshPositionAndAngles(pos, 0.0F, 0.0F);
                abyssal.setHealth(health);
                world.playSound(null, blaze.getBlockPos(), SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, SoundCategory.HOSTILE, 1.0F, 1.0F);

                ((ServerWorld) world).spawnParticles(ParticleTypes.SQUID_INK,
                        pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 150,
                        0.5, 0.5, 0.5, 0.2);

                ((ServerWorld) world).spawnParticles(
                        ParticleTypes.DRIPPING_OBSIDIAN_TEAR,
                        pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5,
                        75, 0.5, 0.5, 0.5, 0.2);

                world.spawnEntity(abyssal);
            }
        }
        return super.applyUpdateEffect(entity, amplifier);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
