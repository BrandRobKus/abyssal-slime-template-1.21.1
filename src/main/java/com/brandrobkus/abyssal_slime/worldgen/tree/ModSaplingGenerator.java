package com.brandrobkus.abyssal_slime.worldgen.tree;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.worldgen.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerator {
    public static final SaplingGenerator OOZEWOOD = new SaplingGenerator(AbyssalSlime.MOD_ID + ":oozewood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.OOZEWOOD_TREE_KEY), Optional.empty());
}