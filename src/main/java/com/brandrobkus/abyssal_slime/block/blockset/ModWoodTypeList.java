package com.brandrobkus.abyssal_slime.block.blockset;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class ModWoodTypeList {
    public static final WoodType OOZEWOOD = new WoodType(
            AbyssalSlime.id("oozewood").toString(),
            ModBlockSetTypeList.OOZEWOOD,
            BlockSoundGroup.NETHER_WOOD,
            BlockSoundGroup.NETHER_WOOD_HANGING_SIGN,
            SoundEvents.BLOCK_NETHER_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.BLOCK_NETHER_WOOD_FENCE_GATE_OPEN
    );
}
