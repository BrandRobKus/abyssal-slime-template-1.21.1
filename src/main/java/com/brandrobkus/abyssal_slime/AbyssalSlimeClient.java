package com.brandrobkus.abyssal_slime;

import com.brandrobkus.abyssal_slime.block.ModBlocks;
import com.brandrobkus.abyssal_slime.block.entity.ModBlockEntities;
import com.brandrobkus.abyssal_slime.block.entity.renderer.AbyssalLecternBlockEntityRenderer;

import com.brandrobkus.abyssal_slime.entity.boat.ModBoats;
import com.brandrobkus.abyssal_slime.entity.client.ModEntityModelLayers;
import com.brandrobkus.abyssal_slime.entity.client.render.ModMobEntityRenderer;
import com.brandrobkus.abyssal_slime.fluid.ModFluids;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class AbyssalSlimeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ABYSSAL_SLIME_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OOZEWOOD_LEAVES, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ABYSSAL_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ABYSSAL_WALL_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ABYSSAL_LANTERN, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.OOZEWOOD_DOOR, ModBlocks.OOZEWOOD_SAPLING, ModBlocks.OOZEWOOD_LEAVES, ModBlocks.OOZEWOOD_TRAPDOOR);

        TerraformBoatClientHelper.registerModelLayers(ModBoats.OOZEWOOD_BOAT_ID, false);

        BlockEntityRendererFactories.register(ModBlockEntities.ABYSSAL_LECTERN_BE, AbyssalLecternBlockEntityRenderer::new);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.ABYSSAL_OOZE_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0x593e68));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.ABYSSAL_OOZE_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 0x593e68));

        ModMobEntityRenderer.registerRenderers();
        ModEntityModelLayers.registerModelLayers();

    }
}
