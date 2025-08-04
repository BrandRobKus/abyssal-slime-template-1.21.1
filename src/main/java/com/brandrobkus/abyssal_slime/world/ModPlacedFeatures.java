package com.brandrobkus.abyssal_slime.world;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ABYSSAL_CAVE_PLACED =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(AbyssalSlime.MOD_ID, "abyssal_cave"));

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        var configuredFeatureHolder = configuredFeatureLookup.getOrThrow(ModConfiguredFeatures.ABYSSAL_CAVE_KEY);

        context.register(ABYSSAL_CAVE_PLACED, new PlacedFeature(configuredFeatureHolder, List.of(SquarePlacementModifier.of())));
    }
}
