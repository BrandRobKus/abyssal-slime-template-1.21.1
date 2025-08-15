package com.brandrobkus.abyssal_slime.worldgen.tree;

import com.brandrobkus.abyssal_slime.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.all(),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.OOZEWOOD_TREE_KEY);
    }
}