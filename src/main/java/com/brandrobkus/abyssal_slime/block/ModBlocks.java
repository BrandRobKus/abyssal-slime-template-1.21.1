package com.brandrobkus.abyssal_slime.block;


import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.fluid.ModFluids;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.createLogBlock;
import static net.minecraft.block.Blocks.createWoodenButtonBlock;

public class ModBlocks {

    private static Block createStairsBlock(Block base) {
        return new StairsBlock(base.getDefaultState(), AbstractBlock.Settings.copy(base));}

    public static final Block ABYSSAL_SLIME_BLOCK = registerBlock("abyssal_slime_block",
            new Block(AbstractBlock.Settings.create().strength(0f, 1f)
                    .velocityMultiplier(0.75f).sounds(BlockSoundGroup.SLIME).mapColor(MapColor.PURPLE).slipperiness(0.8F).nonOpaque()));

    public static final Block ABYSSAL_SLIMED_STONE_BRICKS = registerBlock("abyssal_slimed_stone_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).
                    requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.STONE)));

    public static final Block CONDENSED_STONE_ABYSSAL_SLIME = registerBlock("condensed_stone_abyssal_slime",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).
                    requiresTool().strength(2.0F, 5.0F).sounds(BlockSoundGroup.STONE)));

    public static final Block CONDENSED_STONE_ABYSSAL_SLIME_SLAB = registerBlock("condensed_stone_abyssal_slime_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).
                    requiresTool().strength(2.0F, 5.0F).sounds(BlockSoundGroup.STONE)));

    public static final Block CONDENSED_STONE_ABYSSAL_SLIME_STAIRS = registerBlock("condensed_stone_abyssal_slime_stairs",
            createStairsBlock(CONDENSED_STONE_ABYSSAL_SLIME));

    public static final Block CONDENSED_STONE_ABYSSAL_SLIME_WALL = registerBlock("condensed_stone_abyssal_slime_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).
                    requiresTool().strength(2.0F, 5.0F).sounds(BlockSoundGroup.STONE)));

    public static final Block CONDENSED_DEEPSLATE_ABYSSAL_SLIME = registerBlock("condensed_deepslate_abyssal_slime",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).
                    requiresTool().strength(3.5F, 5.0F).sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block CONDENSED_DEEPSLATE_ABYSSAL_SLIME_SLAB = registerBlock("condensed_deepslate_abyssal_slime_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).
                    requiresTool().strength(3.5F, 5.0F).sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block CONDENSED_DEEPSLATE_ABYSSAL_SLIME_STAIRS = registerBlock("condensed_deepslate_abyssal_slime_stairs",
            createStairsBlock(CONDENSED_DEEPSLATE_ABYSSAL_SLIME));

    public static final Block CONDENSED_DEEPSLATE_ABYSSAL_SLIME_WALL = registerBlock("condensed_deepslate_abyssal_slime_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).
                    requiresTool().strength(3.5F, 5.0F).sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block CONDENSED_STONE_ABYSSAL_SLIME_BRICKS = registerBlock("condensed_stone_abyssal_slime_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).
                    requiresTool().strength(1.5F, 5.0F).sounds(BlockSoundGroup.STONE)));

    public static final Block CONDENSED_STONE_ABYSSAL_SLIME_BRICK_SLAB = registerBlock("condensed_stone_abyssal_slime_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).
                    requiresTool().strength(1.5F, 5.0F).sounds(BlockSoundGroup.STONE)));

    public static final Block CONDENSED_STONE_ABYSSAL_SLIME_BRICK_STAIRS = registerBlock("condensed_stone_abyssal_slime_brick_stairs",
            createStairsBlock(CONDENSED_STONE_ABYSSAL_SLIME_BRICKS));

    public static final Block CONDENSED_STONE_ABYSSAL_SLIME_BRICK_WALL = registerBlock("condensed_stone_abyssal_slime_brick_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).
                    requiresTool().strength(1.5F, 5.0F).sounds(BlockSoundGroup.STONE)));

    public static final Block CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS = registerBlock("condensed_deepslate_abyssal_slime_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).
                    requiresTool().strength(3.5F, 5.0F).sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));

    public static final Block CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_SLAB = registerBlock("condensed_deepslate_abyssal_slime_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).
                    requiresTool().strength(3.5F, 5.0F).sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));

    public static final Block CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_STAIRS = registerBlock("condensed_deepslate_abyssal_slime_brick_stairs",
            createStairsBlock(CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICKS));

    public static final Block CONDENSED_DEEPSLATE_ABYSSAL_SLIME_BRICK_WALL = registerBlock("condensed_deepslate_abyssal_slime_brick_wall",
            new WallBlock(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).
                    requiresTool().strength(3.5F, 5.0F).sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));

    public static final Block CRYSTALLIZED_ABYSSAL_SLIME = registerBlock("crystallized_abyssal_slime",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).instrument(NoteBlockInstrument.PLING)
                    .strength(0.3F, 1.5f).sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance((state) -> 13).solidBlock(Blocks::never)));

    public static final Block ABYSSAL_CONCRETE = registerBlock("abyssal_concrete",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(50f, 120f).requiresTool().sounds(BlockSoundGroup.NETHER_BRICKS)));

    public static final Block ABYSSAL_POWDER_BLOCK = registerBlock("abyssal_powder_block",
            new AbyssalPowderBlock(ABYSSAL_CONCRETE, AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(50.0f, 120f).requiresTool().sounds(BlockSoundGroup.SOUL_SOIL).dynamicBounds().solidBlock(Blocks::never)));

    public static final Block ABYSS_BLOCK = registerBlock("abyss_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).strength(30.0f, 1200f)
                    .requiresTool().sounds(BlockSoundGroup.SOUL_SAND).velocityMultiplier(1.25f).blockVision((state, world, pos) -> true)));

    public static final Block ABYSSAL_LECTERN = registerBlock("abyssal_lectern",
            new AbyssalLecternBlock(AbstractBlock.Settings.create().mapColor(MapColor.GRAY).strength(1.5f, 5.0f)
                    .requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()));

    public static final Block ABYSSAL_TORCH = registerBlock("abyssal_torch",
            new TorchBlock(ParticleTypes.WARPED_SPORE,
                    AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> 13)
                            .sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY).nonOpaque()));
    public static final Block ABYSSAL_WALL_TORCH = registerBlock("abyssal_wall_torch",
            new WallTorchBlock(ParticleTypes.WARPED_SPORE,
                    AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> 13)
                            .sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY).nonOpaque().dropsLike(ModBlocks.ABYSSAL_TORCH)));
    public static final Block ABYSSAL_LANTERN = registerBlock("abyssal_lantern",
            new LanternBlock(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).solid().requiresTool().strength(3.5F)
                    .sounds(BlockSoundGroup.LANTERN).luminance((state) -> 13).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block ABYSSAL_OOZE_FLUID_BLOCK = registerBlock("abyssal_ooze_fluid_block",
            new FluidBlock(ModFluids.ABYSSAL_OOZE_STILL, AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).replaceable().noCollision().strength(100.0F).pistonBehavior(PistonBehavior.DESTROY).dropsNothing().liquid().sounds(BlockSoundGroup.INTENTIONALLY_EMPTY)));

    public static final Block OOZEWOOD_PLANKS = registerBlock("oozewood_planks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block OOZEWOOD_STAIRS = registerBlock("oozewood_stairs",
            createStairsBlock(OOZEWOOD_PLANKS));
    public static final Block OOZEWOOD_SLAB = registerBlock("oozewood_slab",
            new SlabBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block OOZEWOOD_LOG = registerBlock("oozewood_log",
            createLogBlock(MapColor.PALE_PURPLE, MapColor.PURPLE));
    public static final Block STRIPPED_OOZEWOOD_LOG = registerBlock("stripped_oozewood_log",
            createLogBlock(MapColor.PALE_PURPLE, MapColor.PURPLE));
    public static final Block OOZEWOOD = registerBlock("oozewood",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block STRIPPED_OOZEWOOD = registerBlock("stripped_oozewood",
            new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block OOZEWOOD_SIGN = registerBlock("oozewood_sign",
            new OozewoodSignBlock(WoodType.SPRUCE, AbstractBlock.Settings.create().mapColor(ModBlocks.OOZEWOOD_PLANKS.getDefaultMapColor())
                    .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
    public static final Block OOZEWOOD_WALL_SIGN = registerBlock("oozewood_wall_sign",
            new OozewoodWallSignBlock(WoodType.SPRUCE, AbstractBlock.Settings.create().mapColor(ModBlocks.OOZEWOOD_PLANKS.getDefaultMapColor())
                    .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).dropsLike(ModBlocks.OOZEWOOD_SIGN).burnable()));
    public static final Block OOZEWOOD_HANGING_SIGN = registerBlock("oozewood_hanging_sign",
            new OozewoodhangingSignBlock(WoodType.SPRUCE, AbstractBlock.Settings.create().mapColor(ModBlocks.OOZEWOOD_PLANKS.getDefaultMapColor())
                    .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable()));
    public static final Block OOZEWOOD_WALL_HANGING_SIGN = registerBlock("oozewood_wall_hanging_sign",
            new OozewoodWallHangingSignBlock(WoodType.SPRUCE, AbstractBlock.Settings.create().mapColor(ModBlocks.OOZEWOOD_PLANKS.getDefaultMapColor())
                    .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).dropsLike(ModBlocks.OOZEWOOD_HANGING_SIGN).burnable()));
    public static final Block OOZEWOOD_PRESSURE_PLATE = registerBlock("oozewood_pressure_plate",
            new PressurePlateBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create().mapColor(ModBlocks.OOZEWOOD_PLANKS.getDefaultMapColor())
                    .solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block OOZEWOOD_TRAPDOOR = registerBlock("oozewood_trapdoor",
            new TrapdoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create().mapColor(ModBlocks.OOZEWOOD_PLANKS.getDefaultMapColor())
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable()));
    public static final Block OOZEWOOD_BUTTON = registerBlock("oozewood_button",
            createWoodenButtonBlock(BlockSetType.SPRUCE));
    public static final Block OOZEWOOD_FENCE_GATE = registerBlock("oozewood_fence_gate",
            new FenceGateBlock(WoodType.SPRUCE, AbstractBlock.Settings.create().mapColor(ModBlocks.OOZEWOOD_PLANKS.getDefaultMapColor())
                    .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).burnable()));
    public static final Block OOZEWOOD_FENCE = registerBlock("oozewood_fence",
            new FenceBlock(AbstractBlock.Settings.create().mapColor(ModBlocks.OOZEWOOD_PLANKS.getDefaultMapColor())
                    .solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).burnable()));
    public static final Block OOZEWOOD_DOOR = registerBlock("oozewood_door",
            new DoorBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create().mapColor(ModBlocks.OOZEWOOD_PLANKS.getDefaultMapColor())
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY)));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AbyssalSlime.MOD_ID, name),block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(AbyssalSlime.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        AbyssalSlime.LOGGER.info("Registering Mod Blocks for " + AbyssalSlime.MOD_ID);
    }
}
