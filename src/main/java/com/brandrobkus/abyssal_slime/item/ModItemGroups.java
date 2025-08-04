package com.brandrobkus.abyssal_slime.item;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ABYSSAL_SLIME_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AbyssalSlime.MOD_ID, "abyssal_slime_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.ABYSSAL_SLIME_BLOCK))
                    .displayName(Text.translatable("itemgroup.abyssal_slime.abyssal_slime_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ABYSSAL_SLIME_CHUNK);
                        entries.add(ModItems.ABYSSAL_POWDER);
                        entries.add(ModItems.ABYSSAL_SLIME_ROD);
                        entries.add(ModItems.ABYSSAL_TORCH_ITEM);
                        entries.add(ModBlocks.ABYSSAL_LANTERN);
                        entries.add(ModItems.ABYSSAL_OOZE_BUCKET);
                        entries.add(ModItems.ABYSSAL_ALLOY);
                        entries.add(ModItems.ABYSSAL_MAUL);
                        entries.add(ModItems.TOTEM_OF_RENEWAL);
                        entries.add(ModItems.ABYSSAL_RELIQUARY);
                        entries.add(ModItems.ABYSSAL_CREEPER_SPAWN_EGG);
                        entries.add(ModItems.ABYSSAL_SLIME_SPAWN_EGG);
                        entries.add(ModItems.ABYSSAL_BLAZE_SPAWN_EGG);

                        entries.add(ModBlocks.ABYSSAL_SLIME_BLOCK);
                        entries.add(ModBlocks.ABYSSAL_SLIMED_STONE_BRICKS);
                        entries.add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME);
                        entries.add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_SLAB);
                        entries.add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS);
                        entries.add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL);
                        entries.add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME);
                        entries.add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_SLAB);
                        entries.add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS);
                        entries.add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL);
                        entries.add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS);
                        entries.add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_SLAB);
                        entries.add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS);
                        entries.add(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL);
                        entries.add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS);
                        entries.add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_SLAB);
                        entries.add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS);
                        entries.add(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL);
                        entries.add(ModBlocks.CRYSTALLIZED_ABYSSAL_SLIME);
                        entries.add(ModBlocks.ABYSSAL_POWDER_BLOCK);
                        entries.add(ModBlocks.ABYSSAL_CONCRETE);
                        entries.add(ModBlocks.ABYSS_BLOCK);
                        entries.add(ModBlocks.ABYSSAL_LECTERN);
                        entries.add(ModBlocks.OOZEWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_OOZEWOOD_LOG);
                        entries.add(ModBlocks.OOZEWOOD);
                        entries.add(ModBlocks.STRIPPED_OOZEWOOD);
                        entries.add(ModBlocks.OOZEWOOD_PLANKS);
                        entries.add(ModBlocks.OOZEWOOD_SLAB);
                        entries.add(ModBlocks.OOZEWOOD_STAIRS);
                        entries.add(ModBlocks.OOZEWOOD_FENCE);
                        entries.add(ModBlocks.OOZEWOOD_FENCE_GATE);
                        entries.add(ModBlocks.OOZEWOOD_DOOR);
                        entries.add(ModBlocks.OOZEWOOD_TRAPDOOR);
                        entries.add(ModBlocks.OOZEWOOD_BUTTON);
                        entries.add(ModBlocks.OOZEWOOD_PRESSURE_PLATE);
                        entries.add(ModItems.OOZEWOOD_SIGN_ITEM);
                        entries.add(ModItems.OOZEWOOD_HANGING_SIGN_ITEM);
                    }).build());


    public static void registerItemGroups() {
        AbyssalSlime.LOGGER.info("Registering Item Groups for " + AbyssalSlime.MOD_ID);
    }
}
