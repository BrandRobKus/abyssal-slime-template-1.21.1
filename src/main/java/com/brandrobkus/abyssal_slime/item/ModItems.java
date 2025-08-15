package com.brandrobkus.abyssal_slime.item;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.brandrobkus.abyssal_slime.entity.ModEntities;
import com.brandrobkus.abyssal_slime.entity.boat.ModBoats;
import com.brandrobkus.abyssal_slime.fluid.ModFluids;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModItems {

    public static final Item ABYSSAL_SLIME_CHUNK = registerItem("abyssal_slime_chunk", new Item(new Item.Settings()));
    public static final Item ABYSSAL_POWDER = registerItem("abyssal_powder", new Item(new Item.Settings()));
    public static final Item ABYSSAL_SLIME_ROD = registerItem("abyssal_slime_rod", new Item(new Item.Settings()));
    public static final Item ABYSSAL_TORCH_ITEM = registerItem("abyssal_torch",
            new VerticallyAttachableBlockItem(
            ModBlocks.ABYSSAL_TORCH,
            ModBlocks.ABYSSAL_WALL_TORCH, new Item.Settings(), Direction.DOWN));

    public static final Item OOZEWOOD_HANGING_SIGN_ITEM = registerItem("oozewood_hanging_sign",
            new HangingSignItem(
                    ModBlocks.OOZEWOOD_HANGING_SIGN,
                    ModBlocks.OOZEWOOD_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));

    public static final Item OOZEWOOD_SIGN_ITEM = registerItem("oozewood_sign",
            new SignItem(new Item.Settings().maxCount(16),
                    ModBlocks.OOZEWOOD_SIGN,
                    ModBlocks.OOZEWOOD_WALL_SIGN));

    public static final Item OOZEWOOD_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.OOZEWOOD_BOAT_ID,
            ModBoats.OOZEWOOD_BOAT_KEY,
            false);

    public static final Item OOZEWOOD_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.OOZEWOOD_CHEST_BOAT_ID,
            ModBoats.OOZEWOOD_BOAT_KEY,
            true);

    public static final Item ABYSSAL_OOZE_BUCKET = registerItem("abyssal_ooze_bucket",
            new BucketItem(ModFluids.ABYSSAL_OOZE_STILL, new Item.Settings().maxCount(1)));
    public static final Item ABYSSAL_ALLOY = registerItem("abyssal_alloy", new Item((new Item.Settings())));
    public static final Item ABYSSAL_MAUL = registerItem("abyssal_maul",
            new AbyssalMaulItem(ModToolMaterials.ABYSSAL_ALLOY, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ABYSSAL_ALLOY, 10, -3.33f))));
    public static final Item TOTEM_OF_RENEWAL = registerItem("totem_of_renewal",
            new Item(new Item.Settings().maxCount(1)));
    public static final Item ABYSSAL_RELIQUARY = registerItem("abyssal_reliquary",
            new Item(new Item.Settings().maxCount(1)));
    public static final Item ABYSSAL_CREEPER_SPAWN_EGG = registerItem("abyssal_creeper_spawn_egg",
            new SpawnEggItem(ModEntities.ABYSSAL_CREEPER, 0x4f994c, 0x43224a, new Item.Settings()));
    public static final Item ABYSSAL_SLIME_SPAWN_EGG = registerItem("abyssal_slime_spawn_egg",
            new SpawnEggItem(ModEntities.ABYSSAL_SLIME, 0x4d1f50, 0x43224a, new Item.Settings()));
    public static final Item ABYSSAL_BLAZE_SPAWN_EGG = registerItem("abyssal_blaze_spawn_egg",
            new SpawnEggItem(ModEntities.ABYSSAL_BLAZE, 0xd5c782, 0x43224a, new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(AbyssalSlime.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AbyssalSlime.LOGGER.info("Registering Mod Items for " + AbyssalSlime.MOD_ID);

    }
}
