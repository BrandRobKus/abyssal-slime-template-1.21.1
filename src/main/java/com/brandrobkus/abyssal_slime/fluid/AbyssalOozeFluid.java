package com.brandrobkus.abyssal_slime.fluid;

import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.brandrobkus.abyssal_slime.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class AbyssalOozeFluid extends FlowableFluid {
    public AbyssalOozeFluid() {
    }

    public Fluid getFlowing() {
        return ModFluids.ABYSSAL_OOZE_FLOWING;
    }

    public Fluid getStill() {
        return ModFluids.ABYSSAL_OOZE_STILL;
    }

    public Item getBucketItem() {
        return ModItems.ABYSSAL_OOZE_BUCKET;
    }

    public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        if (!state.isStill() && !(Boolean)state.get(FALLING)) {
            if (random.nextInt(64) == 0) {
                world.playSound((double)pos.getX() + (double)0.5F, (double)pos.getY() + (double)0.5F, (double)pos.getZ() + (double)0.5F,
                        SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
            }
        } else if (random.nextInt(10) == 0) {
            world.addParticle(ParticleTypes.UNDERWATER, (double)pos.getX() + random.nextDouble(), (double)pos.getY() + random.nextDouble(), (double)pos.getZ() + random.nextDouble(), 0.0F, 0.0F, 0.0F);
        }

    }

    @Nullable
    public ParticleEffect getParticle() {
        return ParticleTypes.DRAGON_BREATH;
    }

    protected boolean isInfinite(World world) {
        return false;
    }

    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    public int getMaxFlowDistance(WorldView world) {
        return 4;
    }

    public BlockState toBlockState(FluidState state) {
        return ModBlocks.ABYSSAL_OOZE_FLUID_BLOCK.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }

    public boolean matchesType(Fluid fluid) {
        return fluid == ModFluids.ABYSSAL_OOZE_STILL || fluid == ModFluids.ABYSSAL_OOZE_FLOWING;
    }

    public int getLevelDecreasePerBlock(WorldView world) {
        return 2 ;
    }

    public int getTickRate(WorldView world) {
        return 10;
    }

    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN;
    }

    protected float getBlastResistance() {
        return 100.0F;
    }

    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
    }

    public static class Still extends AbyssalOozeFluid {
        public Still() {
        }

        public int getLevel(FluidState state) {
            return 8;
        }

        public boolean isStill(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends AbyssalOozeFluid {
        public Flowing() {
        }

        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }

        public boolean isStill(FluidState state) {
            return false;
        }
    }

}
