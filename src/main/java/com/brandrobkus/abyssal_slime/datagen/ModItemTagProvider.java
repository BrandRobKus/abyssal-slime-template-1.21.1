package com.brandrobkus.abyssal_slime.datagen;

import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.brandrobkus.abyssal_slime.item.ModItems;
import com.brandrobkus.abyssal_slime.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider<Item> {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.OOZEWOOD_LOGS)
                .add(ModBlocks.OOZEWOOD_LOG.asItem())
                .add(ModBlocks.STRIPPED_OOZEWOOD_LOG.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .addTag(ModTags.Items.OOZEWOOD_LOGS);

        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(ModBlocks.OOZEWOOD_LEAVES.asItem());

        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.OOZEWOOD_SAPLING.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.OOZEWOOD_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.OOZEWOOD_DOOR.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.OOZEWOOD_FENCE.asItem());

        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks.OOZEWOOD_FENCE_GATE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.OOZEWOOD_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.OOZEWOOD_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.OOZEWOOD_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.OOZEWOOD_TRAPDOOR.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.OOZEWOOD_BUTTON.asItem());

        getOrCreateTagBuilder(ItemTags.SIGNS)
                .add(ModItems.OOZEWOOD_SIGN_ITEM);

        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS)
                .add(ModItems.OOZEWOOD_HANGING_SIGN_ITEM);

        getOrCreateTagBuilder(ItemTags.BOATS)
                .add(ModItems.OOZEWOOD_BOAT);

        getOrCreateTagBuilder(ItemTags.CHEST_BOATS)
                .add(ModItems.OOZEWOOD_CHEST_BOAT);
    }
}
