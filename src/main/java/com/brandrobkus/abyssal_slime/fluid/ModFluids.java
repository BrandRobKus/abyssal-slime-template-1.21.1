package com.brandrobkus.abyssal_slime.fluid;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid ABYSSAL_OOZE_FLOWING = registerFluid("flowing_abyssal_ooze", new AbyssalOozeFluid.Flowing());
    public static final FlowableFluid ABYSSAL_OOZE_STILL = registerFluid("still_abyssal_ooze", new AbyssalOozeFluid.Still());

    private static FlowableFluid registerFluid(String name, FlowableFluid flowableFluid){
        return Registry.register(Registries.FLUID, Identifier.of(AbyssalSlime.MOD_ID, name), flowableFluid);
    }
    public static void registerModFluids() {
        AbyssalSlime.LOGGER.info("Registering Mod Fluids for " + AbyssalSlime.MOD_ID);
    }
}
