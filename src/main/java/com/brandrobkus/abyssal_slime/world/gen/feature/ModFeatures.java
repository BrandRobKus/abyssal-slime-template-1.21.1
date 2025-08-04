package com.brandrobkus.abyssal_slime.world.gen.feature;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class ModFeatures {
    public static final Feature<DefaultFeatureConfig> ABYSSAL_CAVE =
            new AbyssalCaveFeature(DefaultFeatureConfig.CODEC);

    public static void register() {
        Registry.register(Registries.FEATURE, Identifier.of(AbyssalSlime.MOD_ID, "abyssal_cave"), ABYSSAL_CAVE);
    }
}