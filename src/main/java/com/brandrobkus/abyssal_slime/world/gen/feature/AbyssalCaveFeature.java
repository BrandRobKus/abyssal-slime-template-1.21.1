package com.brandrobkus.abyssal_slime.world.gen.feature;

import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class AbyssalCaveFeature extends Feature<DefaultFeatureConfig> {
    public AbyssalCaveFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        WorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();

        Random random = context.getRandom();

        int y = -60 + random.nextInt(16);
        BlockPos center = new BlockPos(origin.getX(), y, origin.getZ());

        int radiusX = 10;
        int radiusY = 3;

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int dx = -radiusX; dx <= radiusX; dx++) {
            for (int dy = -radiusY; dy <= radiusY; dy++) {
                for (int dz = -radiusX; dz <= radiusX; dz++) {
                    double dist = Math.sqrt(dx*dx + (dy*2)*(dy*2) + dz*dz);
                    if (dist <= radiusX) {
                        mutable.set(center.getX() + dx, center.getY() + dy, center.getZ() + dz);

                        world.setBlockState(mutable, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);

                        if (dist >= radiusX - 3) {
                            if (mutable.getY() <= -50) {
                                world.setBlockState(mutable, ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME.getDefaultState(), Block.NOTIFY_ALL);
                            } else {
                                world.setBlockState(mutable, ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME.getDefaultState(), Block.NOTIFY_ALL);
                            }
                        }

                        if (dy == radiusY && random.nextFloat() < 0.1F) {
                            world.setBlockState(mutable, ModBlocks.CRYSTALLIZED_ABYSSAL_SLIME.getDefaultState(), Block.NOTIFY_ALL);
                        }
                    }
                }
            }
        }

        // Place central pond
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                BlockPos pos = center.add(dx, -radiusY, dz);
                world.setBlockState(pos, ModBlocks.ABYSSAL_OOZE_FLUID_BLOCK.getDefaultState(), Block.NOTIFY_ALL);

                // Surround pond
                for (Direction dir : Direction.Type.HORIZONTAL) {
                    BlockPos adj = pos.offset(dir);
                    world.setBlockState(adj, ModBlocks.ABYSSAL_SLIME_BLOCK.getDefaultState(), Block.NOTIFY_ALL);
                }
            }
        }

        return true;
    }
}