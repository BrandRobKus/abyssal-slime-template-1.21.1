package com.brandrobkus.abyssal_slime.world;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.world.gen.feature.ModFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

public class ModConfiguredFeatures {

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        context.register(ABYSSAL_CAVE_KEY,
                new ConfiguredFeature<>(ModFeatures.ABYSSAL_CAVE, new DefaultFeatureConfig()));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> ABYSSAL_CAVE_KEY =
        RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(AbyssalSlime.MOD_ID, "abyssal_cave"));
}