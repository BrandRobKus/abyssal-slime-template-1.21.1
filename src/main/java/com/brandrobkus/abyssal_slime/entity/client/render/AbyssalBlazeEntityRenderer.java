package com.brandrobkus.abyssal_slime.entity.client.render;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.entity.client.ModEntityModelLayers;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalBlazeEntity;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalBlazeEntityModel;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalCreeperEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class AbyssalBlazeEntityRenderer extends MobEntityRenderer<AbyssalBlazeEntity, AbyssalBlazeEntityModel<AbyssalBlazeEntity>> {
    private static final Identifier TEXTURE = Identifier.of(AbyssalSlime.MOD_ID, "textures/mob/abyssal_blaze.png");

    public AbyssalBlazeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AbyssalBlazeEntityModel(context.getPart(ModEntityModelLayers.ABYSSAL_BLAZE)), 0.5F);
    }

    protected int getBlockLight(AbyssalBlazeEntity blazeEntity, BlockPos blockPos) {
        return 13;
    }

    public Identifier getTexture(AbyssalBlazeEntity blazeEntity) {
        return TEXTURE;
    }

    @Override
    protected RenderLayer getRenderLayer(AbyssalBlazeEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
        return RenderLayer.getEntityTranslucent(getTexture(entity));
    }

}
