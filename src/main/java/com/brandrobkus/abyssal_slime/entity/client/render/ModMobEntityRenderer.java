package com.brandrobkus.abyssal_slime.entity.client.render;

import com.brandrobkus.abyssal_slime.entity.ModEntities;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

public class ModMobEntityRenderer <T extends MobEntity, M extends EntityModel<T>> extends LivingEntityRenderer<T, M> {
    public ModMobEntityRenderer(EntityRendererFactory.Context context, M entityModel, float f) {
        super(context, entityModel, f);
    }

    protected boolean hasLabel(T mobEntity) {
        return super.hasLabel(mobEntity) && (mobEntity.shouldRenderName() || mobEntity.hasCustomName() && mobEntity == this.dispatcher.targetedEntity);
    }

    @Override
    public Identifier getTexture(T entity) {
        return null;
    }

    protected float getShadowRadius(T mobEntity) {
        return super.getShadowRadius(mobEntity) * mobEntity.getScaleFactor();
    }

    public static void registerRenderers() {
        EntityRendererRegistry.register(ModEntities.ABYSSAL_CREEPER, AbyssalCreeperEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.ABYSSAL_SLIME, AbyssalSlimeEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.ABYSSAL_BLAZE, AbyssalBlazeEntityRenderer::new);

    }
}