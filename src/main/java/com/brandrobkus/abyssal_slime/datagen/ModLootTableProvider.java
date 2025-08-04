package com.brandrobkus.abyssal_slime.datagen;

import com.brandrobkus.abyssal_slime.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ABYSSAL_SLIME_BLOCK);
        addDrop(ModBlocks.ABYSSAL_SLIMED_STONE_BRICKS);
        addDrop(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME);
        addDrop(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_SLAB);
        addDrop(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS);
        addDrop(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL);
        addDrop(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME);
        addDrop(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_SLAB);
        addDrop(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS);
        addDrop(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL);
        addDrop(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS);
        addDrop(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_SLAB);
        addDrop(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS);
        addDrop(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL);
        addDrop(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS);
        addDrop(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_SLAB);
        addDrop(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS);
        addDrop(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL);
        addDrop(ModBlocks.CRYSTALLIZED_ABYSSAL_SLIME);
        addDrop(ModBlocks.ABYSSAL_POWDER_BLOCK);
        addDrop(ModBlocks.ABYSS_BLOCK);
        addDrop(ModBlocks.ABYSSAL_LECTERN);
        addDrop(ModBlocks.ABYSSAL_OOZE_FLUID_BLOCK);
        addDrop(ModBlocks.OOZEWOOD_PLANKS);
        addDrop(ModBlocks.OOZEWOOD_STAIRS);
        addDrop(ModBlocks.OOZEWOOD_SLAB);
        addDrop(ModBlocks.OOZEWOOD_LOG);
        addDrop(ModBlocks.STRIPPED_OOZEWOOD_LOG);
        addDrop(ModBlocks.OOZEWOOD);
        addDrop(ModBlocks.STRIPPED_OOZEWOOD);
        addDrop(ModBlocks.OOZEWOOD_PRESSURE_PLATE);
        addDrop(ModBlocks.OOZEWOOD_TRAPDOOR);
        addDrop(ModBlocks.OOZEWOOD_BUTTON);
        addDrop(ModBlocks.OOZEWOOD_FENCE_GATE);
        addDrop(ModBlocks.OOZEWOOD_FENCE);
        addDrop(ModBlocks.OOZEWOOD_DOOR);
        addDrop(ModBlocks.OOZEWOOD_SIGN, ModBlocks.OOZEWOOD_WALL_SIGN);
        addDrop(ModBlocks.OOZEWOOD_HANGING_SIGN, ModBlocks.OOZEWOOD_WALL_HANGING_SIGN);
        addDrop(ModBlocks.ABYSSAL_TORCH, ModBlocks.ABYSSAL_WALL_TORCH);
        addDrop(ModBlocks.ABYSSAL_CONCRETE);
    }
}
