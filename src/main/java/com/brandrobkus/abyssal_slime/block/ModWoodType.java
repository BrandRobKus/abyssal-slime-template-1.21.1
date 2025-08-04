package com.brandrobkus.abyssal_slime.block;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.lang.reflect.Method;

public record ModWoodType(String name, BlockSetType setType, BlockSoundGroup soundType, BlockSoundGroup hangingSignSoundType,
        SoundEvent fenceGateClose, SoundEvent fenceGateOpen, WoodType woodType)
{

    public static ModWoodType create(String name, BlockSetType setType) {
        WoodType woodType = null;
        try {
            WoodType newWoodType = new WoodType(name, setType);

            Method registerMethod = WoodType.class.getDeclaredMethod("register", WoodType.class);
            registerMethod.setAccessible(true);

            woodType = (WoodType) registerMethod.invoke(null, newWoodType);
        } catch (Exception e) {
            e.printStackTrace();
            woodType = new WoodType(name, setType);
        }

        return new ModWoodType(
                name,
                setType,
                BlockSoundGroup.WOOD,
                BlockSoundGroup.HANGING_SIGN,
                SoundEvents.BLOCK_FENCE_GATE_CLOSE,
                SoundEvents.BLOCK_FENCE_GATE_OPEN,
                woodType);
    }

    public static void registerWoodType() {
        System.out.println("Registering Mod Wood Type for " + AbyssalSlime.MOD_ID);
    }
}
