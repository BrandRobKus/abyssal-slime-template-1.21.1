package com.brandrobkus.abyssal_slime.datagen;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.brandrobkus.abyssal_slime.item.ModItems;
import com.brandrobkus.abyssal_slime.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        List<ItemConvertible> ABYSS_BLOCK_SMELTABLES = List.of(ModBlocks.ABYSSAL_POWDER_BLOCK);
        List<ItemConvertible> ABYSS_CONCRETE_SMELTABLES = List.of(ModBlocks.ABYSSAL_CONCRETE);

        //List<ItemConvertible> OOZEWOOD_LOGS = List.of(ModBlocks.OOZEWOOD, ModBlocks.OOZEWOOD_LOG, ModBlocks.STRIPPED_OOZEWOOD, ModBlocks.STRIPPED_OOZEWOOD_LOG);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ABYSSAL_SLIME_BLOCK)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.ABYSSAL_SLIME_CHUNK)
                .criterion(hasItem(ModItems.ABYSSAL_SLIME_CHUNK), conditionsFromItem(ModItems.ABYSSAL_SLIME_CHUNK))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ABYSSAL_SLIME_CHUNK, 4)
                .input(ModBlocks.ABYSSAL_SLIME_BLOCK)
                .criterion(hasItem(ModBlocks.ABYSSAL_SLIME_BLOCK), conditionsFromItem(ModBlocks.ABYSSAL_SLIME_BLOCK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME,4)
                .pattern("SC")
                .pattern("CS")
                .input('S', ModBlocks.ABYSSAL_SLIME_BLOCK)
                .input('C', Blocks.COBBLESTONE)
                .criterion(hasItem(ModBlocks.ABYSSAL_SLIME_BLOCK), conditionsFromItem(ModBlocks.ABYSSAL_SLIME_BLOCK))
                .criterion(hasItem(Blocks.COBBLESTONE), conditionsFromItem(Blocks.COBBLESTONE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME,4)
                .pattern("SC")
                .pattern("CS")
                .input('S', ModBlocks.ABYSSAL_SLIME_BLOCK)
                .input('C', Blocks.COBBLED_DEEPSLATE)
                .criterion(hasItem(ModBlocks.ABYSSAL_SLIME_BLOCK), conditionsFromItem(ModBlocks.ABYSSAL_SLIME_BLOCK))
                .criterion(hasItem(Blocks.COBBLED_DEEPSLATE), conditionsFromItem(Blocks.COBBLED_DEEPSLATE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CRYSTALLIZED_ABYSSAL_SLIME)
                .pattern(" S ")
                .pattern("SGS")
                .pattern(" S ")
                .input('S', ModItems.ABYSSAL_SLIME_CHUNK)
                .input('G', Blocks.GLOWSTONE)
                .criterion(hasItem(ModItems.ABYSSAL_SLIME_CHUNK), conditionsFromItem(ModItems.ABYSSAL_SLIME_CHUNK))
                .criterion(hasItem(Blocks.GLOWSTONE), conditionsFromItem(Blocks.GLOWSTONE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ABYSSAL_POWDER_BLOCK)
                .pattern(" S ")
                .pattern("SGS")
                .pattern(" S ")
                .input('S', ModItems.ABYSSAL_POWDER)
                .input('G', Blocks.OBSIDIAN)
                .criterion(hasItem(ModItems.ABYSSAL_POWDER), conditionsFromItem(ModItems.ABYSSAL_POWDER))
                .criterion(hasItem(Blocks.OBSIDIAN), conditionsFromItem(Blocks.OBSIDIAN))
                .offerTo(recipeExporter);

        offerSmelting(recipeExporter, ABYSS_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.ABYSS_BLOCK, 0.75f, 200, "abyss_block");
        offerSmelting(recipeExporter, ABYSS_CONCRETE_SMELTABLES, RecipeCategory.MISC, ModBlocks.ABYSSAL_POWDER_BLOCK, 0.5f, 200, "abyssal_concrete");


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ABYSSAL_LECTERN)
                .pattern("BBB")
                .pattern(" E ")
                .pattern("CSC")
                .input('S', ModBlocks.ABYSSAL_SLIME_BLOCK)
                .input('E', Blocks.ENCHANTING_TABLE)
                .input('B', Blocks.STONE_SLAB)
                .input('C', ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME)
                .criterion(hasItem(ModBlocks.ABYSSAL_SLIME_BLOCK), conditionsFromItem(ModBlocks.ABYSSAL_SLIME_BLOCK))
                .criterion(hasItem(Blocks.ENCHANTING_TABLE), conditionsFromItem(Blocks.ENCHANTING_TABLE))
                .criterion(hasItem(Blocks.STONE_SLAB), conditionsFromItem(Blocks.STONE_SLAB))
                .criterion(hasItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME), conditionsFromItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ABYSSAL_SLIMED_STONE_BRICKS)
                .pattern("SC")
                .input('S', ModItems.ABYSSAL_SLIME_CHUNK)
                .input('C', Blocks.STONE_BRICKS)
                .criterion(hasItem(ModItems.ABYSSAL_SLIME_CHUNK), conditionsFromItem(ModItems.ABYSSAL_SLIME_CHUNK))
                .criterion(hasItem(Blocks.STONE_BRICKS), conditionsFromItem(Blocks.STONE_BRICKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ABYSSAL_TORCH_ITEM,4)
                .pattern("S")
                .pattern("T")
                .input('S', ModItems.ABYSSAL_SLIME_CHUNK)
                .input('T', Items.STICK)
                .criterion(hasItem(ModItems.ABYSSAL_SLIME_CHUNK), conditionsFromItem(ModItems.ABYSSAL_SLIME_CHUNK))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ABYSSAL_LANTERN)
                .pattern("III")
                .pattern("ITI")
                .pattern("III")
                .input('T', ModItems.ABYSSAL_TORCH_ITEM)
                .input('I', Items.IRON_NUGGET)
                .criterion(hasItem(ModItems.ABYSSAL_TORCH_ITEM), conditionsFromItem(ModItems.ABYSSAL_TORCH_ITEM))
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ABYSSAL_ALLOY)
                .input(ModItems.ABYSSAL_POWDER, 4)
                .input(Items.NETHERITE_SCRAP, 4)
                .criterion(hasItem(ModItems.ABYSSAL_POWDER), conditionsFromItem(ModItems.ABYSSAL_POWDER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.OOZEWOOD_LOG, 8)
                .pattern("PPP")
                .pattern("PTP")
                .pattern("PPP")
                .input('P', Blocks.OAK_LOG)
                .input('T', ModItems.ABYSSAL_SLIME_CHUNK)
                .criterion(hasItem(Blocks.OAK_LOG), conditionsFromItem(Blocks.OAK_LOG))
                .criterion(hasItem(ModItems.ABYSSAL_SLIME_CHUNK), conditionsFromItem(ModItems.ABYSSAL_SLIME_CHUNK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STRIPPED_OOZEWOOD_LOG, 8)
                .pattern("PPP")
                .pattern("PTP")
                .pattern("PPP")
                .input('P', Blocks.STRIPPED_OAK_LOG)
                .input('T', ModItems.ABYSSAL_SLIME_CHUNK)
                .criterion(hasItem(Blocks.STRIPPED_OAK_LOG), conditionsFromItem(Blocks.STRIPPED_OAK_LOG))
                .criterion(hasItem(ModItems.ABYSSAL_SLIME_CHUNK), conditionsFromItem(ModItems.ABYSSAL_SLIME_CHUNK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ABYSSAL_OOZE_BUCKET)
                .pattern("S")
                .pattern("B")
                .input('S', ModBlocks.ABYSSAL_SLIME_BLOCK)
                .input('B', Items.BUCKET)
                .criterion(hasItem(ModBlocks.ABYSSAL_SLIME_BLOCK), conditionsFromItem(ModBlocks.ABYSSAL_SLIME_BLOCK))
                .criterion(hasItem(Items.BUCKET), conditionsFromItem(Items.BUCKET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ABYSSAL_MAUL)
                .pattern("ISI")
                .pattern(" R ")
                .pattern(" R ")
                .input('I', ModItems.ABYSSAL_ALLOY)
                .input('S', Items.NETHER_STAR)
                .input('R', ModItems.ABYSSAL_SLIME_ROD)
                .criterion(hasItem(ModItems.ABYSSAL_ALLOY), conditionsFromItem(ModItems.ABYSSAL_ALLOY))
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .criterion(hasItem(ModItems.ABYSSAL_SLIME_ROD), conditionsFromItem(ModItems.ABYSSAL_SLIME_ROD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOTEM_OF_RENEWAL)
                .pattern(" P ")
                .pattern("PTP")
                .pattern(" P ")
                .input('P', ModItems.ABYSSAL_POWDER)
                .input('T', Items.TOTEM_OF_UNDYING)
                .criterion(hasItem(ModItems.ABYSSAL_POWDER), conditionsFromItem(ModItems.ABYSSAL_POWDER))
                .criterion(hasItem(Items.TOTEM_OF_UNDYING), conditionsFromItem(Items.TOTEM_OF_UNDYING))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ABYSSAL_RELIQUARY)
                .pattern("RGR")
                .pattern("GSG")
                .pattern("RTR")
                .input('R', ModItems.ABYSSAL_SLIME_ROD)
                .input('T', ModItems.TOTEM_OF_RENEWAL)
                .input('S', Items.WITHER_SKELETON_SKULL)
                .input('G', Blocks.GLASS_PANE)
                .criterion(hasItem(ModItems.ABYSSAL_SLIME_ROD), conditionsFromItem(ModItems.ABYSSAL_SLIME_ROD))
                .criterion(hasItem(ModItems.TOTEM_OF_RENEWAL), conditionsFromItem(ModItems.TOTEM_OF_RENEWAL))
                .criterion(hasItem(Items.WITHER_SKELETON_SKULL), conditionsFromItem(Items.WITHER_SKELETON_SKULL))
                .criterion(hasItem(Blocks.GLASS_PANE), conditionsFromItem(Blocks.GLASS_PANE))
                .offerTo(recipeExporter);

        //Oozewood
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OOZEWOOD_PLANKS, 4)
                .input(Ingredient.fromTag(ModTags.Items.OOZEWOOD_LOGS))
                .criterion(hasTag(ModTags.Items.OOZEWOOD_LOGS), conditionsFromTag(ModTags.Items.OOZEWOOD_LOGS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OOZEWOOD_SLAB, 6)
                .input('T', ModBlocks.OOZEWOOD_PLANKS)
                .pattern("TTT")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OOZEWOOD_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OOZEWOOD_STAIRS, 4)
                .input('T', ModBlocks.OOZEWOOD_PLANKS)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OOZEWOOD_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OOZEWOOD_FENCE, 3)
                .input('T', ModBlocks.OOZEWOOD_PLANKS)
                .input('S', ConventionalItemTags.WOODEN_RODS)
                .pattern("TST")
                .pattern("TST")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OOZEWOOD_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                .criterion(hasTag(ConventionalItemTags.WOODEN_RODS), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.WOODEN_RODS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OOZEWOOD_FENCE_GATE)
                .input('T', ModBlocks.OOZEWOOD_PLANKS)
                .input('S', ConventionalItemTags.WOODEN_RODS)
                .pattern("STT")
                .pattern("STT")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OOZEWOOD_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                .criterion(hasTag(ConventionalItemTags.WOODEN_RODS), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.WOODEN_RODS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OOZEWOOD_DOOR, 3)
                .input('T', ModBlocks.OOZEWOOD_PLANKS)
                .pattern("TT")
                .pattern("TT")
                .pattern("TT")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OOZEWOOD_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OOZEWOOD_TRAPDOOR, 2)
                .input('T', ModBlocks.OOZEWOOD_PLANKS)
                .pattern("TT")
                .pattern("TT")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OOZEWOOD_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.OOZEWOOD_BUTTON)
                .input(ModBlocks.OOZEWOOD_PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OOZEWOOD_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.OOZEWOOD_PRESSURE_PLATE)
                .input('T', ModBlocks.OOZEWOOD_PLANKS)
                .pattern("TT")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OOZEWOOD_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.OOZEWOOD_SIGN_ITEM, 3)
                .input('T', ModBlocks.OOZEWOOD_PLANKS)
                .input('S', ConventionalItemTags.WOODEN_RODS)
                .pattern("TTT")
                .pattern("TTT")
                .pattern(" S ")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OOZEWOOD_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                .criterion(hasTag(ConventionalItemTags.WOODEN_RODS), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.WOODEN_RODS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.OOZEWOOD_HANGING_SIGN_ITEM, 6)
                .input('T', ModBlocks.OOZEWOOD_PLANKS)
                .input('C', ConventionalItemTags.CHAINS)
                .pattern("C C")
                .pattern("TTT")
                .pattern("TTT")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OOZEWOOD_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                .criterion(hasTag(ConventionalItemTags.CHAINS), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.CHAINS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.OOZEWOOD_BOAT)
                .input('T', ModBlocks.OOZEWOOD_PLANKS)
                .pattern("T T")
                .pattern("TTT")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.OOZEWOOD_PLANKS), FabricRecipeProvider.conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.OOZEWOOD_CHEST_BOAT)
                .input(ModItems.OOZEWOOD_BOAT)
                .input(ConventionalItemTags.WOODEN_CHESTS)
                .criterion(FabricRecipeProvider.hasItem(ModItems.OOZEWOOD_BOAT), FabricRecipeProvider.conditionsFromItem(ModItems.OOZEWOOD_BOAT))
                .criterion(hasTag(ConventionalItemTags.WOODEN_CHESTS), FabricRecipeProvider.conditionsFromTag(ConventionalItemTags.WOODEN_CHESTS))
                .offerTo(recipeExporter, Identifier.of(AbyssalSlime.MOD_ID, "oozewood_chest_boat"));

        var oozewoodfamily = new BlockFamily.Builder(ModBlocks.OOZEWOOD_PLANKS)
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

        generateFamily(recipeExporter, oozewoodfamily, FeatureSet.empty());

        //bricks
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS,4)
                    .pattern("RR")
                    .pattern("RR")
                    .input('R', ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME)
                    .criterion(hasItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME), conditionsFromItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS,4)
                    .pattern("RR")
                    .pattern("RR")
                    .input('R', ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME)
                    .criterion(hasItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME), conditionsFromItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME))
                    .offerTo(recipeExporter);

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS);

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS);
        }

        //slabs
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_SLAB,6)
                    .pattern("III")
                    .input('I', ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME)
                    .criterion(hasItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME), conditionsFromItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_SLAB,6)
                    .pattern("III")
                    .input('I', ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME)
                    .criterion(hasItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME), conditionsFromItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_SLAB,6)
                    .pattern("III")
                    .input('I', ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS)
                    .criterion(hasItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS), conditionsFromItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_SLAB,6)
                    .pattern("III")
                    .input('I', ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS)
                    .criterion(hasItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS), conditionsFromItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS))
                    .offerTo(recipeExporter);

            /*
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.OOZEWOOD_SLAB,6)
                    .pattern("III")
                    .input('I', ModBlocks.OOZEWOOD_PLANKS)
                    .criterion(hasItem(ModBlocks.OOZEWOOD_PLANKS), conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                    .offerTo(recipeExporter);
             */

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_SLAB,2);

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_SLAB,2);

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_SLAB,2);

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_SLAB,2);
        }

        //stairs
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS,4)
                    .pattern("I  ")
                    .pattern("II ")
                    .pattern("III")
                    .input('I', ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME)
                    .criterion(hasItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME), conditionsFromItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS,4)
                    .pattern("I  ")
                    .pattern("II ")
                    .pattern("III")
                    .input('I', ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME)
                    .criterion(hasItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME), conditionsFromItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS,4)
                    .pattern("I  ")
                    .pattern("II ")
                    .pattern("III")
                    .input('I', ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS)
                    .criterion(hasItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS), conditionsFromItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS,4)
                    .pattern("I  ")
                    .pattern("II ")
                    .pattern("III")
                    .input('I', ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS)
                    .criterion(hasItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS), conditionsFromItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS))
                    .offerTo(recipeExporter);

            /*
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.OOZEWOOD_STAIRS,4)
                    .pattern("I  ")
                    .pattern("II ")
                    .pattern("III")
                    .input('I', ModBlocks.OOZEWOOD_PLANKS)
                    .criterion(hasItem(ModBlocks.OOZEWOOD_PLANKS), conditionsFromItem(ModBlocks.OOZEWOOD_PLANKS))
                    .offerTo(recipeExporter);

             */

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_STAIRS);

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS);

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS);

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS);
        }

        //walls
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL,4)
                    .pattern("III")
                    .pattern("III")
                    .input('I', ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME)
                    .criterion(hasItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME), conditionsFromItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL,4)
                    .pattern("III")
                    .pattern("III")
                    .input('I', ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME)
                    .criterion(hasItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME), conditionsFromItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL,4)
                    .pattern("III")
                    .pattern("III")
                    .input('I', ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS)
                    .criterion(hasItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS), conditionsFromItem(ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS))
                    .offerTo(recipeExporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL,4)
                    .pattern("III")
                    .pattern("III")
                    .input('I', ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS)
                    .criterion(hasItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS), conditionsFromItem(ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS))
                    .offerTo(recipeExporter);

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_WALL);

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL);

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICKS,
                    ModBlocks.CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL);

            offerStonecuttingRecipe(recipeExporter,
                    RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS,
                    ModBlocks.CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL);
        }
    }
    private static @NotNull String hasTag(@NotNull TagKey<Item> tag) {
        return "has_" + tag.id().toString();
    }
}