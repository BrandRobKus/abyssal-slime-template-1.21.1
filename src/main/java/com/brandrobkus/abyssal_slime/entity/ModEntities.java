package com.brandrobkus.abyssal_slime.entity;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalBlazeEntity;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalCreeperEntity;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalSlimeEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModEntities {

    public static final EntityType<AbyssalCreeperEntity> ABYSSAL_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(AbyssalSlime.MOD_ID, "abyssal_creeper"),
            EntityType.Builder.create(AbyssalCreeperEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1f,2f).build());

    public static final EntityType<AbyssalSlimeEntity> ABYSSAL_SLIME = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(AbyssalSlime.MOD_ID, "abyssal_slime"),
            EntityType.Builder.create(AbyssalSlimeEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.52f,0.52f).build());

    public static final EntityType<AbyssalBlazeEntity> ABYSSAL_BLAZE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(AbyssalSlime.MOD_ID, "abyssal_blaze"),
            EntityType.Builder.create(AbyssalBlazeEntity::new, SpawnGroup.MISC)
                    .dimensions(1f,2f).build());

    public static void registerModEntities(){
        AbyssalSlime.LOGGER.info("Registering Mod Entities for " + AbyssalSlime.MOD_ID);

        FabricDefaultAttributeRegistry.register(ABYSSAL_CREEPER, AbyssalCreeperEntity.createAbyssalCreeperAttributes());
        FabricDefaultAttributeRegistry.register(ABYSSAL_SLIME, AbyssalSlimeEntity.createAbyssalSlimeAttributes());
        FabricDefaultAttributeRegistry.register(ABYSSAL_BLAZE, AbyssalBlazeEntity.createBlazeAttributes());

    }
}
