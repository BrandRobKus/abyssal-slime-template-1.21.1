package com.brandrobkus.abyssal_slime.block;

import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModSaplingBlock extends SaplingBlock {
    private final Block blockToPlaceOn;

    public ModSaplingBlock(SaplingGenerator generator, Settings settings, Block block) {
        super(generator, settings);
        this.blockToPlaceOn = block;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.SCULK) || floor.isOf(Blocks.DEEPSLATE);
    }
}