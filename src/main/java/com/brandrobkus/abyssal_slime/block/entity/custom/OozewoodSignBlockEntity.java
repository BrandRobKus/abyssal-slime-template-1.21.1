package com.brandrobkus.abyssal_slime.block.entity.custom;

import com.brandrobkus.abyssal_slime.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class OozewoodSignBlockEntity extends SignBlockEntity {
    public OozewoodSignBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OOZEWOOD_SIGN_BE, pos, state);
    }
}
