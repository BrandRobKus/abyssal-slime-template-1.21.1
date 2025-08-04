package com.brandrobkus.abyssal_slime.block.entity.custom;

import com.brandrobkus.abyssal_slime.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

public class OozewoodHangingSignBlockEntity extends SignBlockEntity {
    public OozewoodHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OOZEWOOD_HANGING_SIGN_BE, pos, state);
    }

    @Override
    public int getTextLineHeight() {
        return 9;
    }

    @Override
    public int getMaxTextWidth() {
        return 60;
    }

    @Override
    public SoundEvent getInteractionFailSound() {
        return SoundEvents.BLOCK_HANGING_SIGN_WAXED_INTERACT_FAIL;
    }
}
