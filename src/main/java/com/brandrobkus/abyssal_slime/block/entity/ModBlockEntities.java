package com.brandrobkus.abyssal_slime.block.entity;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.brandrobkus.abyssal_slime.block.entity.custom.AbyssalLecternBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<AbyssalLecternBlockEntity> ABYSSAL_LECTERN_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(AbyssalSlime.MOD_ID, "abyssal_lectern_be"),
                    BlockEntityType.Builder.create(AbyssalLecternBlockEntity::new, ModBlocks.ABYSSAL_LECTERN).build(null));

    public static void registerBlockEntities(){
        AbyssalSlime.LOGGER.info("Registering Block Entities for " + AbyssalSlime.MOD_ID);
    }
}
