package com.brandrobkus.abyssal_slime.entity.custom;


import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class AbyssalCreeperEntityModel<T extends MobEntity> extends EntityModel<T> {
	private final ModelPart head;
	private final ModelPart goop;
	private final ModelPart body;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	public AbyssalCreeperEntityModel(ModelPart root) {
		this.head = root.getChild("head");
		this.goop = root.getChild("goop");
		this.body = root.getChild("body");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head",
				ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData goop = modelPartData.addChild("goop", ModelPartBuilder.create().uv(24, 0).cuboid(-4.5F, -8.5F, -4.5F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F))
				.uv(28, 2).cuboid(-3.5F, -8.5F, -4.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
				.uv(32, 3).cuboid(-2.5F, -8.5F, -4.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
				.uv(36, 4).cuboid(-1.5F, -8.5F, -4.5F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(42, 3).cuboid(0.5F, -8.5F, -4.5F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
				.uv(48, 1).cuboid(2.5F, -8.5F, -4.5F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
				.uv(56, 3).cuboid(3.5F, -8.5F, -2.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
				.uv(32, 11).cuboid(3.5F, -8.5F, -1.5F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(38, 11).cuboid(3.5F, -8.5F, 0.5F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
				.uv(46, 12).cuboid(3.5F, -8.5F, 3.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(51, 6).cuboid(3.5F, -3.5F, 3.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(51, 6).cuboid(-2.5F, -1.5F, 3.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(51, 6).cuboid(-4.5F, -2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(51, 6).cuboid(3.5F, -2.5F, -4.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(50, 5).cuboid(1.5F, -1.5F, 3.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(50, 5).cuboid(3.5F, -4.5F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(50, 5).cuboid(-4.5F, -0.5F, -4.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(51, 13).cuboid(2.5F, -8.5F, 3.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(55, 11).cuboid(1.5F, -8.5F, 3.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
				.uv(36, 16).cuboid(-0.5F, -8.5F, 3.5F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(42, 16).cuboid(-1.5F, -8.5F, 3.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
				.uv(46, 16).cuboid(-2.5F, -8.5F, 3.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
				.uv(50, 16).cuboid(-4.5F, -8.5F, 3.5F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
				.uv(56, 16).cuboid(-4.5F, -8.5F, 1.5F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(59, 18).cuboid(-4.5F, -8.5F, 0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
				.uv(40, 21).cuboid(-4.5F, -8.5F, -0.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
				.uv(44, 23).cuboid(-4.5F, -8.5F, -2.5F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(2, 1).cuboid(-4.5F, -8.5F, -3.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
				.uv(52, 28).cuboid(1.5F, -8.5F, -4.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(52, 28).cuboid(-1.5F, -8.5F, -4.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(52, 28).cuboid(-4.5F, -8.5F, -4.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(52, 28).cuboid(1.5F, -8.5F, -1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(52, 28).cuboid(1.5F, -8.5F, 1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(52, 28).cuboid(-1.5F, -8.5F, -1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(52, 28).cuboid(-4.5F, -8.5F, -1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(52, 28).cuboid(-1.5F, -8.5F, 1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(52, 28).cuboid(-4.5F, -8.5F, 1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData leg1 = modelPartData.addChild("leg1", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 18.0F, 4.0F));

		ModelPartData leg2 = modelPartData.addChild("leg2", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 18.0F, 4.0F));

		ModelPartData leg3 = modelPartData.addChild("leg3", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 18.0F, -4.0F));

		ModelPartData leg4 = modelPartData.addChild("leg4", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 18.0F, -4.0F));
		return TexturedModelData.of(modelData, 64, 32);
	}


	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		head.render(matrices, vertices, light, overlay);
		body.render(matrices, vertices, light, overlay);
		goop.render(matrices, vertices, light, overlay);
		leg1.render(matrices, vertices, light, overlay);
		leg2.render(matrices, vertices, light, overlay);
		leg3.render(matrices, vertices, light, overlay);
		leg4.render(matrices, vertices, light, overlay);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.head.yaw = headYaw * ((float)Math.PI / 180F);
		this.head.pitch = headPitch * ((float)Math.PI / 180F);
		this.goop.yaw = headYaw * ((float)Math.PI / 180F);
		this.goop.pitch = headPitch * ((float)Math.PI / 180F);
		this.leg1.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
		this.leg2.pitch = MathHelper.cos(limbAngle * 0.6662F + (float)Math.PI) * 1.4F * limbDistance;
		this.leg3.pitch = MathHelper.cos(limbAngle * 0.6662F + (float)Math.PI) * 1.4F * limbDistance;
		this.leg4.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
	}
}