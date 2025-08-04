package com.brandrobkus.abyssal_slime.item;

import com.brandrobkus.abyssal_slime.effect.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AbyssalMaulItem extends ToolItem {

    public AbyssalMaulItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings.component(DataComponentTypes.TOOL, createToolComponent()));
    }

    private static ToolComponent createToolComponent() {
        return null;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!(attacker instanceof PlayerEntity player)) {
            return super.postHit(stack, target, attacker);
        }

        World world = attacker.getWorld();

        if (!world.isClient) {
            if (!player.getItemCooldownManager().isCoolingDown(this)) {
                target.addStatusEffect(new StatusEffectInstance(ModEffects.ABYSSAL_LEECH, 100, 0));
                target.addStatusEffect(new StatusEffectInstance(ModEffects.CONCUSSED, 100, 0));
                player.getItemCooldownManager().set(this, 33);
            }
        }

        return super.postHit(stack, target, attacker);
    }
}
