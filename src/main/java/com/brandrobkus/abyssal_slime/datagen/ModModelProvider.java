package com.brandrobkus.abyssal_slime.datagen;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.brandrobkus.abyssal_slime.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    public static VariantsBlockStateSupplier createSingletonBlockState(Block block, Identifier modelId) {
        return VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, modelId));
    }

    public static BlockStateVariantMap createEastDefaultHorizontalRotationStates() {
        return BlockStateVariantMap.create(Properties.HORIZONTAL_FACING).register(Direction.EAST, BlockStateVariant.create()).register(Direction.SOUTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R90)).register(Direction.WEST, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R180)).register(Direction.NORTH, BlockStateVariant.create().put(VariantSettings.Y, VariantSettings.Rotation.R270));
    }


    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABYSSAL_SLIME_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABYSSAL_SLIMED_STONE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRYSTALLIZED_ABYSSAL_SLIME);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABYSS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OOZEWOOD_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABYSSAL_CONCRETE);
        blockStateModelGenerator.registerDoor(ModBlocks.OOZEWOOD_DOOR);
        blockStateModelGenerator.registerLantern(ModBlocks.ABYSSAL_LANTERN);

        TextureMap textureMap = TextureMap.torch(ModBlocks.ABYSSAL_TORCH);
        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(ModBlocks.ABYSSAL_TORCH, Models.TEMPLATE_TORCH.upload(ModBlocks.ABYSSAL_TORCH, textureMap, blockStateModelGenerator.modelCollector)));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.ABYSSAL_WALL_TORCH, BlockStateVariant.create().put(VariantSettings.MODEL, Models.TEMPLATE_TORCH_WALL.upload(ModBlocks.ABYSSAL_WALL_TORCH, textureMap, blockStateModelGenerator.modelCollector))).coordinate(createEastDefaultHorizontalRotationStates()));
        blockStateModelGenerator.registerItemModel(ModBlocks.ABYSSAL_TORCH);
        blockStateModelGenerator.excludeFromSimpleItemModelGeneration(ModBlocks.ABYSSAL_WALL_TORCH);

        TextureMap condensedStoneSlimeTexture = TextureMap.all(Identifier.of(AbyssalSlime.MOD_ID, "block/condensed_stone_abyssal_slime"));
        TextureMap condensedDeepslateSlimeTexture = TextureMap.all(Identifier.of(AbyssalSlime.MOD_ID, "block/condensed_deepslate_abyssal_slime"));
        TextureMap condensedStoneSlimeBricksTexture = TextureMap.all(Identifier.of(AbyssalSlime.MOD_ID, "block/condensed_stone_abyssal_slime_bricks"));
        TextureMap condensedDeepslateBricksSlimeTexture = TextureMap.all(Identifier.of(AbyssalSlime.MOD_ID, "block/condensed_deepslate_abyssal_slime_bricks"));
        TextureMap oozewoodPlanksTexture = TextureMap.all(Identifier.of(AbyssalSlime.MOD_ID, "block/oozewood_planks"));

        //stairs
        {
            final Identifier stairsModelId = Models.STAIRS.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS, condensedStoneSlimeTexture, blockStateModelGenerator.modelCollector);
            final Identifier innerStairsModelId = Models.INNER_STAIRS.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS, condensedStoneSlimeTexture, blockStateModelGenerator.modelCollector);
            final Identifier outerStairsModelId = Models.OUTER_STAIRS.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS, condensedStoneSlimeTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createStairsBlockState(
                            ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS,
                            innerStairsModelId, stairsModelId, outerStairsModelId));
            blockStateModelGenerator.registerParentedItemModel(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS, stairsModelId);

            final Identifier deepslateStairsModelId = Models.STAIRS.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS, condensedDeepslateSlimeTexture, blockStateModelGenerator.modelCollector);
            final Identifier deepslateInnerStairsModelId = Models.INNER_STAIRS.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS, condensedDeepslateSlimeTexture, blockStateModelGenerator.modelCollector);
            final Identifier deepslateOuterStairsModelId = Models.OUTER_STAIRS.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS, condensedDeepslateSlimeTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createStairsBlockState(
                            ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS,
                            deepslateInnerStairsModelId, deepslateStairsModelId, deepslateOuterStairsModelId));
            blockStateModelGenerator.registerParentedItemModel(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS, deepslateStairsModelId);

            final Identifier stoneBrickStairsModelId = Models.STAIRS.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS, condensedStoneSlimeBricksTexture, blockStateModelGenerator.modelCollector);
            final Identifier stoneBrickInnerStairsModelId = Models.INNER_STAIRS.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS, condensedStoneSlimeBricksTexture, blockStateModelGenerator.modelCollector);
            final Identifier stoneBrickOuterStairsModelId = Models.OUTER_STAIRS.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS, condensedStoneSlimeBricksTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createStairsBlockState(
                            ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS,
                            stoneBrickInnerStairsModelId, stoneBrickStairsModelId, stoneBrickOuterStairsModelId));
            blockStateModelGenerator.registerParentedItemModel(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS, stoneBrickStairsModelId);

            final Identifier deepslateBricksStairsModelId = Models.STAIRS.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS, condensedDeepslateBricksSlimeTexture, blockStateModelGenerator.modelCollector);
            final Identifier deepslateBricksInnerStairsModelId = Models.INNER_STAIRS.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS, condensedDeepslateBricksSlimeTexture, blockStateModelGenerator.modelCollector);
            final Identifier deepslateBricksOuterStairsModelId = Models.OUTER_STAIRS.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS, condensedDeepslateBricksSlimeTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createStairsBlockState(
                            ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS,
                            deepslateBricksInnerStairsModelId, deepslateBricksStairsModelId, deepslateBricksOuterStairsModelId));
            blockStateModelGenerator.registerParentedItemModel(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS, deepslateBricksStairsModelId);

            final Identifier OozewoodStairsModelId = Models.STAIRS.upload(ModBlocks.OOZEWOOD_STAIRS, oozewoodPlanksTexture, blockStateModelGenerator.modelCollector);
            final Identifier OozewoodInnerStairsModelId = Models.INNER_STAIRS.upload(ModBlocks.OOZEWOOD_STAIRS, oozewoodPlanksTexture, blockStateModelGenerator.modelCollector);
            final Identifier OozewoodOuterStairsModelId = Models.OUTER_STAIRS.upload(ModBlocks.OOZEWOOD_STAIRS, oozewoodPlanksTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createStairsBlockState(
                            ModBlocks.OOZEWOOD_STAIRS,
                            OozewoodInnerStairsModelId, OozewoodStairsModelId, OozewoodOuterStairsModelId));
            blockStateModelGenerator.registerParentedItemModel(ModBlocks.OOZEWOOD_STAIRS, OozewoodStairsModelId);
        }

        //slabs
        {
            final Identifier slabBottomModelId = Models.SLAB.upload(
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_SLAB,
                    condensedStoneSlimeTexture,
                    blockStateModelGenerator.modelCollector);
            final Identifier slabTopModelId = Models.SLAB_TOP.upload(
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_SLAB,
                    condensedStoneSlimeTexture,
                    blockStateModelGenerator.modelCollector);
            Identifier fullBlockModelId = ModelIds.getBlockModelId(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createSlabBlockState(
                            ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_SLAB,
                            slabBottomModelId, slabTopModelId, fullBlockModelId));

            final Identifier deepslateSlabBottomModelId = Models.SLAB.upload(
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_SLAB,
                    condensedDeepslateSlimeTexture,
                    blockStateModelGenerator.modelCollector);
            final Identifier deepslateSlabTopModelId = Models.SLAB_TOP.upload(
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_SLAB,
                    condensedDeepslateSlimeTexture,
                    blockStateModelGenerator.modelCollector);
            Identifier deepslateFullBlockModelId = ModelIds.getBlockModelId(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createSlabBlockState(
                            ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_SLAB,
                            deepslateSlabBottomModelId, deepslateSlabTopModelId, deepslateFullBlockModelId));

            final Identifier stoneBrickSlabBottomModelId = Models.SLAB.upload(
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_SLAB,
                    condensedStoneSlimeBricksTexture,
                    blockStateModelGenerator.modelCollector);
            final Identifier stoneBrickSlabTopModelId = Models.SLAB_TOP.upload(
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_SLAB,
                    condensedStoneSlimeBricksTexture,
                    blockStateModelGenerator.modelCollector);
            Identifier stoneBrickFullBlockModelId = ModelIds.getBlockModelId(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createSlabBlockState(
                            ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_SLAB,
                            stoneBrickSlabBottomModelId, stoneBrickSlabTopModelId, stoneBrickFullBlockModelId));

            final Identifier deepslateBrickSlabBottomModelId = Models.SLAB.upload(
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_SLAB,
                    condensedDeepslateBricksSlimeTexture,
                    blockStateModelGenerator.modelCollector);
            final Identifier deepslateBrickSlabTopModelId = Models.SLAB_TOP.upload(
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_SLAB,
                    condensedDeepslateBricksSlimeTexture,
                    blockStateModelGenerator.modelCollector);
            Identifier deepslateBrickFullBlockModelId = ModelIds.getBlockModelId(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createSlabBlockState(
                            ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_SLAB,
                            deepslateBrickSlabBottomModelId, deepslateBrickSlabTopModelId, deepslateBrickFullBlockModelId));

            final Identifier OozewoodSlabBottomModelId = Models.SLAB.upload(
                    ModBlocks.OOZEWOOD_SLAB,
                    oozewoodPlanksTexture,
                    blockStateModelGenerator.modelCollector);
            final Identifier OozewoodSlabTopModelId = Models.SLAB_TOP.upload(
                    ModBlocks.OOZEWOOD_SLAB,
                    oozewoodPlanksTexture,
                    blockStateModelGenerator.modelCollector);
            Identifier OozewoodFullBlockModelId = ModelIds.getBlockModelId(ModBlocks.OOZEWOOD_PLANKS);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createSlabBlockState(
                            ModBlocks.OOZEWOOD_SLAB,
                            OozewoodSlabBottomModelId, OozewoodSlabTopModelId, OozewoodFullBlockModelId));
        }

        //walls
        {
            final Identifier stoneWallPost = Models.TEMPLATE_WALL_POST.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL,
                    condensedStoneSlimeTexture, blockStateModelGenerator.modelCollector);
            final Identifier stoneWallSide = Models.TEMPLATE_WALL_SIDE.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL,
                    condensedStoneSlimeTexture, blockStateModelGenerator.modelCollector);
            final Identifier stoneWallTop = Models.TEMPLATE_WALL_SIDE_TALL.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL,
                    condensedStoneSlimeTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createWallBlockState(
                            ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL, stoneWallPost, stoneWallSide, stoneWallTop));
            Identifier stoneWallInventory = Models.WALL_INVENTORY.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL,
                    condensedStoneSlimeTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.registerParentedItemModel(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL, stoneWallInventory);

            final Identifier deepslateWallPost = Models.TEMPLATE_WALL_POST.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL,
                    condensedDeepslateSlimeTexture, blockStateModelGenerator.modelCollector);
            final Identifier deepslateWallSide = Models.TEMPLATE_WALL_SIDE.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL,
                    condensedDeepslateSlimeTexture, blockStateModelGenerator.modelCollector);
            final Identifier deepslateWallTop = Models.TEMPLATE_WALL_SIDE_TALL.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL,
                    condensedDeepslateSlimeTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createWallBlockState(
                            ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL, deepslateWallPost, deepslateWallSide, deepslateWallTop));
            Identifier deepslateWallInventory = Models.WALL_INVENTORY.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL,
                    condensedDeepslateSlimeTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.registerParentedItemModel(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL, deepslateWallInventory);

            final Identifier stoneBrickWallPost = Models.TEMPLATE_WALL_POST.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL,
                    condensedStoneSlimeBricksTexture, blockStateModelGenerator.modelCollector);
            final Identifier stoneBrickWallSide = Models.TEMPLATE_WALL_SIDE.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL,
                    condensedStoneSlimeBricksTexture, blockStateModelGenerator.modelCollector);
            final Identifier stoneBrickWallTop = Models.TEMPLATE_WALL_SIDE_TALL.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL,
                    condensedStoneSlimeBricksTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createWallBlockState(
                            ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL, stoneBrickWallPost, stoneBrickWallSide, stoneBrickWallTop));
            Identifier stoneBrickWallInventory = Models.WALL_INVENTORY.upload(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL,
                    condensedStoneSlimeBricksTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.registerParentedItemModel(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL, stoneBrickWallInventory);

            final Identifier deepslateBrickWallPost = Models.TEMPLATE_WALL_POST.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL,
                    condensedDeepslateBricksSlimeTexture, blockStateModelGenerator.modelCollector);
            final Identifier deepslateBrickWallSide = Models.TEMPLATE_WALL_SIDE.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL,
                    condensedDeepslateBricksSlimeTexture, blockStateModelGenerator.modelCollector);
            final Identifier deepslateBrickWallTop = Models.TEMPLATE_WALL_SIDE_TALL.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL,
                    condensedDeepslateBricksSlimeTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.blockStateCollector.accept(
                    BlockStateModelGenerator.createWallBlockState(
                            ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL, deepslateBrickWallPost, deepslateBrickWallSide, deepslateBrickWallTop));
            Identifier deepslateBrickWallInventory = Models.WALL_INVENTORY.upload(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL,
                    condensedDeepslateBricksSlimeTexture, blockStateModelGenerator.modelCollector);
            blockStateModelGenerator.registerParentedItemModel(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL, deepslateBrickWallInventory);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ABYSSAL_SLIME_CHUNK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ABYSSAL_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ABYSSAL_SLIME_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ABYSSAL_OOZE_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ABYSSAL_ALLOY, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOTEM_OF_RENEWAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ABYSSAL_RELIQUARY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ABYSSAL_CREEPER_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.ABYSSAL_SLIME_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.ABYSSAL_BLAZE_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
    }
}