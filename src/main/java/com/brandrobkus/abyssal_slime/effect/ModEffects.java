package com.brandrobkus.abyssal_slime.effect;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> ABYSSAL_LEECH = registerStatusEffect("abyssal_leech",
            new AbyssalLeechEffect(StatusEffectCategory.HARMFUL, 0x593e68)
            .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, Identifier.of(AbyssalSlime.MOD_ID, "abyssal_leech"), -0.15F,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, Identifier.of(AbyssalSlime.MOD_ID, "abyssal_leech"), -0.3D,
                    EntityAttributeModifier.Operation.ADD_VALUE));
    public static final RegistryEntry<StatusEffect> RENEWED = registerStatusEffect("renewed",
            (new RenewedEffect(StatusEffectCategory.BENEFICIAL, 0x4f007c)));

    public static final RegistryEntry<StatusEffect> CONCUSSED = registerStatusEffect("concussed", (new
            ConcussionEffect(StatusEffectCategory.HARMFUL, 0x969696)));
    public static final RegistryEntry<StatusEffect> ABYSSAL_SICKNESS = registerStatusEffect("abyssal_sickness",
            new AbyssalSicknessEffect(StatusEffectCategory.NEUTRAL, 0x9775ab));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(AbyssalSlime.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        AbyssalSlime.LOGGER.info("Registering Mod Effects for " + AbyssalSlime.MOD_ID);
    }
}
