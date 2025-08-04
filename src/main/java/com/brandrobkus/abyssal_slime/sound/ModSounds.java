package com.brandrobkus.abyssal_slime.sound;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent CONCUSSED = registerSoundEvent("concussed_effect");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(AbyssalSlime.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        AbyssalSlime.LOGGER.info("Registering Sounds for " + AbyssalSlime.MOD_ID);
    }
}
