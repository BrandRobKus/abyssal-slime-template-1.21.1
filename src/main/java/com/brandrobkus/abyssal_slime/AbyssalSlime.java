package com.brandrobkus.abyssal_slime;

import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.brandrobkus.abyssal_slime.block.ModWoodType;
import com.brandrobkus.abyssal_slime.block.entity.ModBlockEntities;
import com.brandrobkus.abyssal_slime.effect.ModEffects;
import com.brandrobkus.abyssal_slime.entity.ModEntities;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalCreeperEntity;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalSlimeEntity;
import com.brandrobkus.abyssal_slime.fluid.ModFluids;
import com.brandrobkus.abyssal_slime.item.ModItemGroups;
import com.brandrobkus.abyssal_slime.item.ModItems;
import com.brandrobkus.abyssal_slime.potion.ModPotions;
import com.brandrobkus.abyssal_slime.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potions;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.Heightmap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AbyssalSlime implements ModInitializer {
	public static final String MOD_ID = "abyssal_slime";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	private static final Map<UUID, Integer> oozeTicks = new HashMap<>();

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModBlockEntities.registerBlockEntities();
		ModFluids.registerModFluids();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModItemGroups.registerItemGroups();
		ModEntities.registerModEntities();
		ModPotions.registerPotions();
		ModWoodType.registerWoodType();

		FuelRegistry.INSTANCE.add(ModItems.ABYSSAL_SLIME_CHUNK, 80);

		SpawnRestriction.register(
				ModEntities.ABYSSAL_CREEPER,
				SpawnLocationTypes.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				AbyssalCreeperEntity::canSpawn);

		SpawnRestriction.register(
				ModEntities.ABYSSAL_SLIME,
				SpawnLocationTypes.ON_GROUND,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				AbyssalSlimeEntity::canSpawn);

		BiomeModifications.addSpawn(
				BiomeSelectors.foundInOverworld(),
				SpawnGroup.MONSTER,
				ModEntities.ABYSSAL_CREEPER,
				400, 1, 2);

		BiomeModifications.addSpawn(
				BiomeSelectors.foundInOverworld(),
				SpawnGroup.MONSTER,
				ModEntities.ABYSSAL_SLIME,
				400, 1, 2);

		StrippableBlockRegistry.register(ModBlocks.OOZEWOOD_LOG, ModBlocks.STRIPPED_OOZEWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.OOZEWOOD, ModBlocks.STRIPPED_OOZEWOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OOZEWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OOZEWOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_OOZEWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_OOZEWOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.OOZEWOOD_PLANKS, 5, 20);

		ServerTickEvents.END_WORLD_TICK.register(world -> {
			if (!(world instanceof ServerWorld serverWorld)) return;

			for (PlayerEntity player : serverWorld.getPlayers()) {
				UUID uuid = player.getUuid();

				FluidState fluidState = serverWorld.getFluidState(player.getBlockPos());
				boolean inOoze = fluidState.getFluid() == ModFluids.ABYSSAL_OOZE_STILL ||
						fluidState.getFluid() == ModFluids.ABYSSAL_OOZE_FLOWING;
				boolean hasTotem = false;
				boolean hasReliquary = false;

				for (Hand hand : Hand.values()) {
					ItemStack stack = player.getStackInHand(hand);
					if (stack.isOf(ModItems.TOTEM_OF_RENEWAL)) {
						hasTotem = true;
						break;

					}
					if (stack.isOf(ModItems.ABYSSAL_RELIQUARY)) {
						hasReliquary = true;
						break;
					}
				}
				if (inOoze) {
					if(!hasReliquary) {
						player.addStatusEffect(new StatusEffectInstance(
								ModEffects.ABYSSAL_LEECH, 100, 0, true, true));
					}
					if(!player.hasStatusEffect(ModEffects.ABYSSAL_SICKNESS)) {
						int ticks = oozeTicks.getOrDefault(uuid, 0) + 1;
						oozeTicks.put(uuid, ticks);
						if (ticks >= 200 && !player.hasStatusEffect(ModEffects.RENEWED)) {
							for (Hand hand : Hand.values()) {
								ItemStack stack = player.getStackInHand(hand);
								if (stack.isOf(ModItems.TOTEM_OF_RENEWAL)) {
									hasTotem = true;
									stack.decrement(1);
									break;
								}
								if (stack.isOf(ModItems.ABYSSAL_RELIQUARY)) {
									hasReliquary = true;
									stack.decrement(1);
									break;
								}
							}
							if (hasTotem) {
								player.addStatusEffect(new StatusEffectInstance(
										ModEffects.RENEWED, 12000, 0, true, true
								));
								player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(),
										SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.PLAYERS, 1.0F, 1.0F);
							}
							if (hasReliquary) {
								player.addStatusEffect(new StatusEffectInstance(
										ModEffects.RENEWED, 72000, 0, true, true
								));
								player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(),
										SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.PLAYERS, 1.0F, 1.0F);
							}
						}
					}
				} else {
					oozeTicks.remove(uuid);
				}
			}
		});

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> builder.registerPotionRecipe(Potions.THICK, ModItems.ABYSSAL_SLIME_CHUNK, ModPotions.ABYSSAL_LEECH_POTION));
	}
}