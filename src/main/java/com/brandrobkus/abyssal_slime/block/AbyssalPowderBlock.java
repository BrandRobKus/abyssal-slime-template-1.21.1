package com.brandrobkus.abyssal_slime.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class AbyssalPowderBlock extends Block {
    public static final MapCodec<AbyssalPowderBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(Registries.BLOCK.getCodec().fieldOf("abyssal_concrete").forGetter((block) -> block.hardenedState), createSettingsCodec()).apply(instance, AbyssalPowderBlock::new));
    private static final VoxelShape FALLING_SHAPE = VoxelShapes.cuboid(0.0F, 0.0F, 0.0F, 1.0F, 0.9F, 1.0F);
    private final Block hardenedState;


    public MapCodec<AbyssalPowderBlock> getCodec() {
        return CODEC;
    }

    public AbyssalPowderBlock(Block hardened, AbstractBlock.Settings settings) {
        super(settings);
        this.hardenedState = hardened;
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState adjacentState, Direction direction) {
        return adjacentState.isOf(this) || super.isSideInvisible(state, adjacentState, direction);
    }

    protected VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!(entity instanceof LivingEntity) || entity.getBlockStateAtPos().isOf(this)) {
            entity.slowMovement(state, new Vec3d(0.9F, 1.5F, 0.9F));
            if (world.isClient) {
                Random random = world.getRandom();
                boolean bl = entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ();
                if (bl && random.nextBoolean()) {
                    world.addParticle(ParticleTypes.SQUID_INK, entity.getX(), (pos.getY() + 1), entity.getZ(),
                            (MathHelper.nextBetween(random, -1.0F, 1.0F) * 0.083333336F), 0.05F,
                            (MathHelper.nextBetween(random, -1.0F, 1.0F) * 0.083333336F));
                }
            }
        }
        if (!world.isClient) {
            if (entity.isOnFire() && (world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) || entity instanceof PlayerEntity) && entity.canModifyAt(world, pos)) {
                world.breakBlock(pos, false);
            }

            entity.setOnFire(false);
        }

    }

    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (!((double)fallDistance < (double)4.0F) && entity instanceof LivingEntity livingEntity) {
            LivingEntity.FallSounds fallSounds = livingEntity.getFallSounds();
            SoundEvent soundEvent = (double)fallDistance < (double)7.0F ? fallSounds.small() : fallSounds.big();
            entity.playSound(soundEvent, 1.0F, 1.0F);
        }
    }

    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (context instanceof EntityShapeContext entityShapeContext) {
            Entity entity = entityShapeContext.getEntity();
            if (entity != null) {
                if (entity.fallDistance > 2.5F) {
                    return FALLING_SHAPE;
                }

                boolean bl = entity instanceof FallingBlockEntity;
                if (bl || canWalkOnAbyssalPowder(entity) && context.isAbove(VoxelShapes.fullCube(), pos, false) && !context.isDescending()) {
                    return super.getCollisionShape(state, world, pos, context);
                }
            }
        }

        return VoxelShapes.empty();
    }

    protected VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    public static boolean canWalkOnAbyssalPowder(Entity entity) {
            return entity instanceof LivingEntity ? ((LivingEntity)entity).getEquippedStack(EquipmentSlot.FEET).isOf(Items.LEATHER_BOOTS) : false;
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return true;
    }

    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return false;
    }

    public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        if (shouldHarden(world, pos, currentStateInPos)) {
            world.setBlockState(pos, this.hardenedState.getDefaultState(), 3);
        }

    }

    private static boolean shouldHarden(BlockView world, BlockPos pos, BlockState state) {
        return hardensIn(state) || hardensOnAnySide(world, pos);
    }

    private static boolean hardensOnAnySide(BlockView world, BlockPos pos) {
        boolean bl = false;
        BlockPos.Mutable mutable = pos.mutableCopy();

        for(Direction direction : Direction.values()) {
            BlockState blockState = world.getBlockState(mutable);
            if (direction != Direction.DOWN || hardensIn(blockState)) {
                mutable.set(pos, direction);
                blockState = world.getBlockState(mutable);
                if (hardensIn(blockState) && !blockState.isSideSolidFullSquare(world, pos, direction.getOpposite())) {
                    bl = true;
                    break;
                }
            }
        }

        return bl;
    }

    private static boolean hardensIn(BlockState state) {
        return state.getFluidState().isIn(FluidTags.WATER) || state.getFluidState().isIn(FluidTags.LAVA);
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return hardensOnAnySide(world, pos) ? this.hardenedState.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }}
