package com.brandrobkus.abyssal_slime.entity.custom;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;

import java.util.Arrays;


// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class AbyssalBlazeEntityModel<T extends MobEntity> extends EntityModel<T> {
	private final ModelPart root;
	private final ModelPart[] rods;
	private final ModelPart head;
	private final ModelPart goop;
	public AbyssalBlazeEntityModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("head");
		this.rods = new ModelPart[12];
		Arrays.setAll(this.rods, (index) -> root.getChild(getRodName(index)));
		this.goop = root.getChild("goop");
	}
	private static String getRodName(int index) {
		return "part" + index;
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F), ModelTransform.NONE);
		float f = 0.0F;
		ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F);
		ModelPartData goop = modelPartData.addChild("goop", ModelPartBuilder.create().uv(24, 0).cuboid(-4.5F, -4.5F, -4.5F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F))
		.uv(28, 2).cuboid(-3.5F, -4.5F, -4.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 3).cuboid(-2.5F, -4.5F, -4.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(36, 4).cuboid(-1.5F, -4.5F, -4.5F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(42, 3).cuboid(0.5F, -4.5F, -4.5F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(48, 1).cuboid(2.5F, -4.5F, -4.5F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(56, 3).cuboid(3.5F, -4.5F, -2.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(32, 11).cuboid(3.5F, -4.5F, -1.5F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(38, 11).cuboid(3.5F, -4.5F, 0.5F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F))
		.uv(46, 12).cuboid(3.5F, -4.5F, 3.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(51, 6).cuboid(3.5F, 0.5F, 3.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(51, 6).cuboid(-2.5F, 2.5F, 3.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(51, 6).cuboid(-4.5F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(51, 6).cuboid(3.5F, 1.5F, -4.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 5).cuboid(1.5F, 2.5F, 3.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 5).cuboid(3.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 5).cuboid(-4.5F, 3.5F, -4.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(51, 13).cuboid(2.5F, -4.5F, 3.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(55, 11).cuboid(1.5F, -4.5F, 3.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(36, 16).cuboid(-0.5F, -4.5F, 3.5F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(42, 16).cuboid(-1.5F, -4.5F, 3.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(46, 16).cuboid(-2.5F, -4.5F, 3.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(50, 16).cuboid(-4.5F, -4.5F, 3.5F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(56, 16).cuboid(-4.5F, -4.5F, 1.5F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(59, 18).cuboid(-4.5F, -4.5F, 0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(40, 21).cuboid(-4.5F, -4.5F, -0.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(44, 23).cuboid(-4.5F, -4.5F, -2.5F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 1).cuboid(-4.5F, -4.5F, -3.5F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F))
		.uv(52, 28).cuboid(1.5F, -4.5F, -4.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(52, 28).cuboid(-1.5F, -4.5F, -4.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(52, 28).cuboid(-4.5F, -4.5F, -4.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(52, 28).cuboid(1.5F, -4.5F, -1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(52, 28).cuboid(1.5F, -4.5F, 1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(52, 28).cuboid(-1.5F, -4.5F, -1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(52, 28).cuboid(-4.5F, -4.5F, -1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(52, 28).cuboid(-1.5F, -4.5F, 1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(52, 28).cuboid(-4.5F, -4.5F, 1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F)),
				ModelTransform.NONE);

		for(int i = 0; i < 4; ++i) {
			float g = MathHelper.cos(f) * 9.0F;
			float h = -2.0F + MathHelper.cos((float)(i * 2) * 0.25F);
			float j = MathHelper.sin(f) * 9.0F;
			modelPartData.addChild(getRodName(i), modelPartBuilder, ModelTransform.pivot(g, h, j));
			++f;
		}

		f = ((float)Math.PI / 4F);

		for(int i = 4; i < 8; ++i) {
			float g = MathHelper.cos(f) * 7.0F;
			float h = 2.0F + MathHelper.cos((float)(i * 2) * 0.25F);
			float j = MathHelper.sin(f) * 7.0F;
			modelPartData.addChild(getRodName(i), modelPartBuilder, ModelTransform.pivot(g, h, j));
			++f;
		}

		f = 0.47123894F;

		for(int i = 8; i < 12; ++i) {
			float g = MathHelper.cos(f) * 5.0F;
			float h = 11.0F + MathHelper.cos((float)i * 1.5F * 0.5F);
			float j = MathHelper.sin(f) * 5.0F;
			modelPartData.addChild(getRodName(i), modelPartBuilder, ModelTransform.pivot(g, h, j));
			++f;
		}
		return TexturedModelData.of(modelData, 64, 32);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		head.render(matrices, vertices, light, overlay);
		goop.render(matrices, vertices, light, overlay);
		root.render(matrices, vertices, light, overlay);
	}

	public ModelPart getPart() {
		return this.root;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		float f = animationProgress * (float)Math.PI * -0.1F;

		for(int i = 0; i < 4; ++i) {
			this.rods[i].pivotY = -2.0F + MathHelper.cos(((float)(i * 2) + animationProgress) * 0.25F);
			this.rods[i].pivotX = MathHelper.cos(f) * 9.0F;
			this.rods[i].pivotZ = MathHelper.sin(f) * 9.0F;
			++f;
		}

		f = ((float)Math.PI / 4F) + animationProgress * (float)Math.PI * 0.03F;

		for(int i = 4; i < 8; ++i) {
			this.rods[i].pivotY = 2.0F + MathHelper.cos(((float)(i * 2) + animationProgress) * 0.25F);
			this.rods[i].pivotX = MathHelper.cos(f) * 7.0F;
			this.rods[i].pivotZ = MathHelper.sin(f) * 7.0F;
			++f;
		}

		f = 0.47123894F + animationProgress * (float)Math.PI * -0.05F;

		for(int i = 8; i < 12; ++i) {
			this.rods[i].pivotY = 11.0F + MathHelper.cos(((float)i * 1.5F + animationProgress) * 0.5F);
			this.rods[i].pivotX = MathHelper.cos(f) * 5.0F;
			this.rods[i].pivotZ = MathHelper.sin(f) * 5.0F;
			++f;
		}

		this.head.yaw = headYaw * ((float)Math.PI / 180F);
		this.head.pitch = headPitch * ((float)Math.PI / 180F);
		this.goop.yaw = this.head.yaw;
		this.goop.pitch = this.head.pitch;
	}
}