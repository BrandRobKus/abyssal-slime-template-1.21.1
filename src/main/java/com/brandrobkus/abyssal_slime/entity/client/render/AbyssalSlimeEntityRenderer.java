package com.brandrobkus.abyssal_slime.entity.client.render;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.entity.client.ModEntityModelLayers;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalSlimeEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalSlimeEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class AbyssalSlimeEntityRenderer extends MobEntityRenderer<AbyssalSlimeEntity, AbyssalSlimeEntityModel<AbyssalSlimeEntity>> {
    private static final Identifier TEXTURE = Identifier.of(AbyssalSlime.MOD_ID, "textures/mob/abyssal_slime.png");

    public AbyssalSlimeEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AbyssalSlimeEntityModel<>(context.getPart(ModEntityModelLayers.ABYSSAL_SLIME)), 0.25F);
        this.addFeature(new AbyssalSlimeOverlayFeatureRenderer(this, context.getModelLoader()));
    }

    public void render(AbyssalSlimeEntity slimeEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        this.shadowRadius = 0.25F * (float)slimeEntity.getSize();
        super.render(slimeEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    protected void scale(AbyssalSlimeEntity slimeEntity, MatrixStack matrixStack, float f) {
        float g = 0.999F;
        matrixStack.scale(0.999F, 0.999F, 0.999F);
        matrixStack.translate(0.0F, 0.001F, 0.0F);
        float h = (float)slimeEntity.getSize();
        float i = MathHelper.lerp(f, slimeEntity.lastStretch, slimeEntity.stretch) / (h * 0.5F + 1.0F);
        float j = 1.0F / (i + 1.0F);
        matrixStack.scale(j * h, 1.0F / j * h, j * h);
    }

    public Identifier getTexture(AbyssalSlimeEntity slimeEntity) {
        return TEXTURE;
    }
}
