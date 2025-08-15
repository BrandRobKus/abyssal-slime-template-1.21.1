package com.brandrobkus.abyssal_slime.entity.boat;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.brandrobkus.abyssal_slime.item.ModItems;
import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {

    public static final Identifier OOZEWOOD_BOAT_ID = AbyssalSlime.id("oozewood_boat");
    public static final Identifier OOZEWOOD_CHEST_BOAT_ID = AbyssalSlime.id("oozewood_chest_boat");

    public static final RegistryKey<TerraformBoatType> OOZEWOOD_BOAT_KEY = TerraformBoatTypeRegistry.createKey(OOZEWOOD_BOAT_ID);

    public static final  TerraformBoatType OOZEWOOD_TYPE = register(OOZEWOOD_BOAT_KEY, new TerraformBoatType.Builder()
            .item(ModItems.OOZEWOOD_BOAT)
            .chestItem(ModItems.OOZEWOOD_CHEST_BOAT)
            .planks(ModBlocks.OOZEWOOD_PLANKS.asItem())
            .build());

    public static TerraformBoatType register(RegistryKey<TerraformBoatType> key, TerraformBoatType type){
        return Registry.register(TerraformBoatTypeRegistry.INSTANCE, key, type);
    }

    public static void registerModBoats() {
        AbyssalSlime.LOGGER.info("Registering Mod Boats for " + AbyssalSlime.MOD_ID);
    }
}
