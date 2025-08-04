package com.brandrobkus.abyssal_slime.entity.client.render;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.entity.client.ModEntityModelLayers;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalSlimeEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AbyssalSlimeOverlayFeatureRenderer<T extends LivingEntity> extends FeatureRenderer<T, AbyssalSlimeEntityModel<T>> {
    private final EntityModel<T> model;

    public AbyssalSlimeOverlayFeatureRenderer(FeatureRendererContext<T, AbyssalSlimeEntityModel<T>> context, EntityModelLoader loader) {
        super(context);
        this.model = new AbyssalSlimeEntityModel(loader.getModelPart(ModEntityModelLayers.ABYSSAL_SLIME_OUTER));
    }

    private static final Identifier OUTER_TEXTURE = Identifier.of(AbyssalSlime.MOD_ID, "textures/mob/abyssal_slime_outer.png");

    @Override
    public Identifier getTexture(T entity) {
        return OUTER_TEXTURE;
    }


    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        boolean bl = minecraftClient.hasOutline(livingEntity) && livingEntity.isInvisible();
        if (!livingEntity.isInvisible() || bl) {
            VertexConsumer vertexConsumer;
            if (bl) {
                vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getOutline(this.getTexture(livingEntity)));
            } else {
                vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntityTranslucent(this.getTexture(livingEntity)));
            }

            ((AbyssalSlimeEntityModel)this.getContextModel()).copyStateTo(this.model);
            this.model.animateModel(livingEntity, f, g, h);
            this.model.setAngles(livingEntity, f, g, j, k, l);
            this.model.render(matrixStack, vertexConsumer, i, LivingEntityRenderer.getOverlay(livingEntity, 0.0F));
        }
    }
}
