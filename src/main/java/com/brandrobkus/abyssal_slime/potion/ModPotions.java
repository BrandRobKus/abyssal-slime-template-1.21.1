package com.brandrobkus.abyssal_slime.potion;


import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> ABYSSAL_LEECH_POTION = registerPotion("abyssal_leech_potion",
            new Potion(new StatusEffectInstance(ModEffects.ABYSSAL_LEECH, 1200, 0)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion){
        return Registry.registerReference(Registries.POTION, Identifier.of(AbyssalSlime.MOD_ID, name), potion);
    }


    public static void registerPotions(){
        AbyssalSlime.LOGGER.info("Registering Mod Potions for " + AbyssalSlime.MOD_ID);
    }
}
