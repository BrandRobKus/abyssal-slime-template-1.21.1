package com.brandrobkus.abyssal_slime.block;

import com.brandrobkus.abyssal_slime.block.entity.custom.OozewoodSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class OozewoodSignBlock extends SignBlock {
    public OozewoodSignBlock(WoodType woodType, Settings settings) {
        super(woodType, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return new OozewoodSignBlockEntity(pos, state);
    }
}
