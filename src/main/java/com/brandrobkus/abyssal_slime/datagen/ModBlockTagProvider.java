package com.brandrobkus.abyssal_slime.datagen;


import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.brandrobkus.abyssal_slime.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL)
        ;
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.ABYSSAL_POWDER_BLOCK)
                .add(ModBlocks.ABYSS_BLOCK)
                ;
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_SLAB)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL)

                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_SLAB)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL)

                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_SLAB)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL)

                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_SLAB)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL)

                .add(ModBlocks.CRYSTALLIZED_ABYSSAL_SLIME)
                .add(ModBlocks.ABYSSAL_LECTERN)
                .add(ModBlocks.ABYSSAL_SLIMED_STONE_BRICKS)
                .add(ModBlocks.ABYSSAL_CONCRETE)
        ;
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.OOZEWOOD)
                .add(ModBlocks.OOZEWOOD_LOG)
                .add(ModBlocks.STRIPPED_OOZEWOOD)
                .add(ModBlocks.STRIPPED_OOZEWOOD_LOG)
                .add(ModBlocks.OOZEWOOD_PLANKS)
                .add(ModBlocks.OOZEWOOD_FENCE_GATE)
                ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ABYSSAL_POWDER_BLOCK)
                ;
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_SLAB)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL)

                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_SLAB)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL)

                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_SLAB)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL)

                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_SLAB)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL)

                .add(ModBlocks.ABYSSAL_LECTERN)
        ;

        getOrCreateTagBuilder(BlockTags.STONE_BRICKS)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS)
                .add(ModBlocks.ABYSSAL_SLIMED_STONE_BRICKS)
                ;
        getOrCreateTagBuilder(BlockTags.PREVENT_MOB_SPAWNING_INSIDE)
                .add(ModBlocks.ABYSS_BLOCK)
                .add(ModBlocks.ABYSSAL_POWDER_BLOCK)
                ;
        getOrCreateTagBuilder(BlockTags.PIGLIN_REPELLENTS)
                .add(ModBlocks.ABYSS_BLOCK)
                ;
        getOrCreateTagBuilder(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.ABYSS_BLOCK)
                .add(ModBlocks.ABYSSAL_POWDER_BLOCK)
                ;
        getOrCreateTagBuilder(BlockTags.WITHER_IMMUNE)
                .add(ModBlocks.ABYSS_BLOCK)
                .add(ModBlocks.ABYSSAL_POWDER_BLOCK)
                ;
        getOrCreateTagBuilder(BlockTags.OCCLUDES_VIBRATION_SIGNALS)
                .add(ModBlocks.ABYSS_BLOCK)
                ;
        getOrCreateTagBuilder(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON)
                .add(ModBlocks.ABYSS_BLOCK)
                ;

        getOrCreateTagBuilder(ModTags.Blocks.OOZEWOOD_LOGS)
                .add(ModBlocks.OOZEWOOD)
                .add(ModBlocks.OOZEWOOD_LOG)
                .add(ModBlocks.STRIPPED_OOZEWOOD)
                .add(ModBlocks.STRIPPED_OOZEWOOD_LOG)
        ;

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.OOZEWOOD)
                .add(ModBlocks.OOZEWOOD_LOG)
                .add(ModBlocks.STRIPPED_OOZEWOOD)
                .add(ModBlocks.STRIPPED_OOZEWOOD_LOG)
        ;

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.OOZEWOOD)
                .add(ModBlocks.OOZEWOOD_LOG)
                .add(ModBlocks.STRIPPED_OOZEWOOD)
                .add(ModBlocks.STRIPPED_OOZEWOOD_LOG)
        ;

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.OOZEWOOD_PLANKS)
        ;

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.OOZEWOOD_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.OOZEWOOD_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.OOZEWOOD_DOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.OOZEWOOD_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.OOZEWOOD_FENCE);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.OOZEWOOD_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.OOZEWOOD_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.OOZEWOOD_SLAB)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_SLAB)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_SLAB)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_SLAB)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_SLAB)
        ;

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.OOZEWOOD_SLAB)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS)
                .add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS)
                .add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS)
        ;

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.OOZEWOOD_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.OOZEWOOD_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.COMPLETES_FIND_TREE_TUTORIAL)
                .add(ModBlocks.OOZEWOOD_LOG)
                .add(ModBlocks.STRIPPED_OOZEWOOD_LOG);

        getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
                .add(ModBlocks.OOZEWOOD_WALL_SIGN)
        ;

        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.OOZEWOOD_SIGN)
        ;

        getOrCreateTagBuilder(BlockTags.SIGNS)
                .add(ModBlocks.OOZEWOOD_WALL_SIGN)
                .add(ModBlocks.OOZEWOOD_SIGN)
        ;

        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
                .add(ModBlocks.OOZEWOOD_WALL_HANGING_SIGN)
        ;

        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
                .add(ModBlocks.OOZEWOOD_HANGING_SIGN)
        ;

        getOrCreateTagBuilder(BlockTags.ALL_HANGING_SIGNS)
                .add(ModBlocks.OOZEWOOD_WALL_HANGING_SIGN)
                .add(ModBlocks.OOZEWOOD_HANGING_SIGN)
        ;

        getOrCreateTagBuilder(BlockTags.ALL_SIGNS)
                .add(ModBlocks.OOZEWOOD_WALL_SIGN)
                .add(ModBlocks.OOZEWOOD_SIGN)
                .add(ModBlocks.OOZEWOOD_WALL_HANGING_SIGN)
                .add(ModBlocks.OOZEWOOD_HANGING_SIGN)
        ;
    }
}