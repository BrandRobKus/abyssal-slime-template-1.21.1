package com.brandrobkus.abyssal_slime.entity.client;

import com.brandrobkus.abyssal_slime.entity.custom.AbyssalBlazeEntityModel;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalCreeperEntityModel;
import com.brandrobkus.abyssal_slime.entity.custom.AbyssalSlimeEntityModel;
import com.google.common.collect.Sets;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.block.WoodType;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import java.util.Set;
import java.util.stream.Stream;

@Environment(EnvType.CLIENT)
public class ModEntityModelLayers {
    private static final String MAIN = "main";
    private static final Set<EntityModelLayer> LAYERS = Sets.newHashSet();
    public static final EntityModelLayer ABYSSAL_CREEPER = registerMain("abyssal_creeper");
    public static final EntityModelLayer ABYSSAL_SLIME_OUTER = registerMain("abyssal_slime_outer");
    public static final EntityModelLayer ABYSSAL_SLIME = registerMain("abyssal_slime");
    public static final EntityModelLayer ABYSSAL_BLAZE = registerMain("abyssal_blaze");

    private static EntityModelLayer registerMain(String id) {
        return register(id, "main");
    }

    private static EntityModelLayer register(String id, String layer) {
        EntityModelLayer entityModelLayer = create(id, layer);
        if (!LAYERS.add(entityModelLayer)) {
            throw new IllegalStateException("Duplicate registration for " + String.valueOf(entityModelLayer));
        } else {
            return entityModelLayer;
        }
    }

    private static EntityModelLayer create(String id, String layer) {
        return new EntityModelLayer(Identifier.ofVanilla(id), layer);
    }

    public static EntityModelLayer createHangingSign(WoodType type) {
        return create("hanging_sign/" + type.name(), "main");
    }

    public static Stream<EntityModelLayer> getLayers() {
        return LAYERS.stream();
    }

    public static void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ABYSSAL_CREEPER, AbyssalCreeperEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ABYSSAL_SLIME_OUTER, AbyssalSlimeEntityModel::getOuterTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ABYSSAL_SLIME, AbyssalSlimeEntityModel::getInnerTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.ABYSSAL_BLAZE, AbyssalBlazeEntityModel::getTexturedModelData);

    }
}
