package com.brandrobkus.abyssal_slime.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModBiomeModification {
    public static void load() {
        BiomeModifications.addFeature(
                BiomeSelectors.all(),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.OOZEWOOD_TREE_KEY
        );
    }
}
