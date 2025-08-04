package com.brandrobkus.abyssal_slime.entity.client.render;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import com.brandrobkus.abyssal_slime.entity.client.ModEntityModelLayers;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalCreeperEntity;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalCreeperEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class AbyssalCreeperEntityRenderer extends MobEntityRenderer<AbyssalCreeperEntity, AbyssalCreeperEntityModel<AbyssalCreeperEntity>> {
    private static final Identifier TEXTURE = Identifier.of(AbyssalSlime.MOD_ID, "textures/mob/abyssal_creeper.png");

    public AbyssalCreeperEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new AbyssalCreeperEntityModel(context.getPart(ModEntityModelLayers.ABYSSAL_CREEPER)), 0.5F);
    }

    protected void scale(AbyssalCreeperEntity creeperEntity, MatrixStack matrixStack, float f) {
        float g = creeperEntity.getClientFuseTime(f);
        float h = 1.0F + MathHelper.sin(g * 100.0F) * g * 0.01F;
        g = MathHelper.clamp(g, 0.0F, 1.0F);
        g *= g;
        g *= g;
        float i = (1.0F + g * 0.4F) * h;
        float j = (1.0F + g * 0.1F) / h;
        matrixStack.scale(i, j, i);
    }

    protected float getAnimationCounter(AbyssalCreeperEntity creeperEntity, float f) {
        float g = creeperEntity.getClientFuseTime(f);
        return (int)(g * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(g, 0.5F, 1.0F);
    }

    public Identifier getTexture(AbyssalCreeperEntity creeperEntity) {
        return TEXTURE;
    }

    @Override
    protected RenderLayer getRenderLayer(AbyssalCreeperEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
        return RenderLayer.getEntityTranslucent(getTexture(entity));
    }

}
