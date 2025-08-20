package com.brandrobkus.abyssal_slime.datagen;

import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.brandrobkus.abyssal_slime.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamily;
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

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRYSTALLIZED_ABYSSAL_SLIME);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABYSS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABYSSAL_CONCRETE);
        blockStateModelGenerator.registerLantern(ModBlocks.ABYSSAL_LANTERN);

        TextureMap textureMap = TextureMap.torch(ModBlocks.ABYSSAL_TORCH);
        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(ModBlocks.ABYSSAL_TORCH, Models.TEMPLATE_TORCH.upload(ModBlocks.ABYSSAL_TORCH, textureMap, blockStateModelGenerator.modelCollector)));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.ABYSSAL_WALL_TORCH, BlockStateVariant.create().put(VariantSettings.MODEL, Models.TEMPLATE_TORCH_WALL.upload(ModBlocks.ABYSSAL_WALL_TORCH, textureMap, blockStateModelGenerator.modelCollector))).coordinate(createEastDefaultHorizontalRotationStates()));
        blockStateModelGenerator.registerItemModel(ModBlocks.ABYSSAL_TORCH);
        blockStateModelGenerator.excludeFromSimpleItemModelGeneration(ModBlocks.ABYSSAL_WALL_TORCH);

        blockStateModelGenerator.registerLog(ModBlocks.OOZEWOOD_LOG)
                .log(ModBlocks.OOZEWOOD_LOG)
                .wood(ModBlocks.OOZEWOOD);

        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_OOZEWOOD_LOG)
                .log(ModBlocks.STRIPPED_OOZEWOOD_LOG)
                .wood(ModBlocks.STRIPPED_OOZEWOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OOZEWOOD_LEAVES);

        blockStateModelGenerator.registerTintableCross(ModBlocks.OOZEWOOD_SAPLING,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_OOZEWOOD_LOG,
                ModBlocks.OOZEWOOD_HANGING_SIGN,
                ModBlocks.OOZEWOOD_WALL_HANGING_SIGN);

        var oozewoodFamily = new BlockFamily.Builder(ModBlocks.OOZEWOOD_PLANKS)
                .button(ModBlocks.OOZEWOOD_BUTTON)
                .fence(ModBlocks.OOZEWOOD_FENCE)
                .fenceGate(ModBlocks.OOZEWOOD_FENCE_GATE)
                .pressurePlate(ModBlocks.OOZEWOOD_PRESSURE_PLATE)
                .sign(ModBlocks.OOZEWOOD_SIGN, ModBlocks.OOZEWOOD_WALL_SIGN)
                .slab(ModBlocks.OOZEWOOD_SLAB)
                .stairs(ModBlocks.OOZEWOOD_STAIRS)
                .door(ModBlocks.OOZEWOOD_DOOR)
                .trapdoor(ModBlocks.OOZEWOOD_TRAPDOOR)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(oozewoodFamily.getBaseBlock())
                .family(oozewoodFamily);

        var condensedStoneFamily = new BlockFamily.Builder(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME)
                .wall(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL)
                .slab(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_SLAB)
                .stairs(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS)
                .group("stone")
                .unlockCriterionName("has_stone")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(condensedStoneFamily.getBaseBlock())
                .family(condensedStoneFamily);

        var condensedDeepslateFamily = new BlockFamily.Builder(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME)
                .wall(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL)
                .slab(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_SLAB)
                .stairs(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS)
                .group("stone")
                .unlockCriterionName("has_stone")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(condensedDeepslateFamily.getBaseBlock())
                .family(condensedDeepslateFamily);

        var condensedStoneBrickFamily = new BlockFamily.Builder(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS)
                .wall(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL)
                .slab(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_SLAB)
                .stairs(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS)
                .group("bricks")
                .unlockCriterionName("has_bricks")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(condensedStoneBrickFamily.getBaseBlock())
                .family(condensedStoneBrickFamily);

        var condensedDeepslateBrickFamily = new BlockFamily.Builder(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS)
                .wall(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL)
                .slab(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_SLAB)
                .stairs(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS)
                .group("bricks")
                .unlockCriterionName("has_bricks")
                .build();
        blockStateModelGenerator.registerCubeAllModelTexturePool(condensedDeepslateBrickFamily.getBaseBlock())
                .family(condensedDeepslateBrickFamily);
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
        itemModelGenerator.register(ModItems.OOZEWOOD_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OOZEWOOD_CHEST_BOAT, Models.GENERATED);
    }
}