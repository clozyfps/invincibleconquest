package net.clozynoii.invincibleconquest.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelangstrom_clothes<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("invincible_conquest", "modelangstrom_clothes"), "main");
	public final ModelPart Head;
	public final ModelPart Body;
	public final ModelPart cape;
	public final ModelPart cape_left;
	public final ModelPart cape_right;
	public final ModelPart LeftArm;
	public final ModelPart RightArm;
	public final ModelPart LeftLeg;
	public final ModelPart RightLeg;
	public final ModelPart RightShoe;
	public final ModelPart LeftShoe;

	public Modelangstrom_clothes(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.cape = this.Body.getChild("cape");
		this.cape_left = this.cape.getChild("cape_left");
		this.cape_right = this.cape.getChild("cape_right");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
		this.RightShoe = root.getChild("RightShoe");
		this.LeftShoe = root.getChild("LeftShoe");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 74).addBox(4.0F, -4.75F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(32, 74).mirror()
				.addBox(-5.0F, -4.75F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(44, 28).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.51F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Body = partdefinition
				.addOrReplaceChild(
						"Body", CubeListBuilder.create().texOffs(44, 57).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(0, 58).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.51F))
								.texOffs(44, 44).addBox(-5.0F, -0.5F, -3.0F, 10.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(32, 16).addBox(-4.5F, -0.75F, -4.5F, 9.0F, 3.0F, 9.0F, new CubeDeformation(0.25F)),
						PartPose.offset(0.0F, 12.0F, 0.0F));
		PartDefinition cape = Body.addOrReplaceChild("cape", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -1.25F, -5.0F, 10.0F, 23.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.75F, 2.75F));
		PartDefinition cape_left = cape.addOrReplaceChild("cape_left", CubeListBuilder.create().texOffs(0, 29).addBox(-0.6F, -1.25F, -5.0F, 5.0F, 23.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offset(5.0F, 0.0F, 0.0F));
		PartDefinition cape_right = cape.addOrReplaceChild("cape_right", CubeListBuilder.create().texOffs(22, 29).addBox(-4.4F, -1.25F, -5.0F, 5.0F, 23.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offset(-5.0F, 0.0F, 0.0F));
		PartDefinition torso_r1 = cape_right.addOrReplaceChild("torso_r1", CubeListBuilder.create().texOffs(68, 16).addBox(-3.5F, -1.5F, -2.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.3F)),
				PartPose.offsetAndRotation(-2.5F, -0.5F, -3.25F, 0.0F, 0.0F, -0.1309F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(24, 58).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(40, 73).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)),
				PartPose.offset(5.0F, 14.0F, 0.0F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(24, 58).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).mirror(false).texOffs(40, 73).mirror()
				.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(-5.0F, 14.0F, 0.0F));
		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(64, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(68, 57).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));
		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).mirror(false).texOffs(68, 57).mirror()
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));
		PartDefinition RightShoe = partdefinition.addOrReplaceChild("RightShoe",
				CubeListBuilder.create().texOffs(0, 74).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(16, 74).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)),
				PartPose.offset(-2.0F, 12.0F, 0.0F));
		PartDefinition LeftShoe = partdefinition.addOrReplaceChild("LeftShoe", CubeListBuilder.create().texOffs(0, 74).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).mirror(false).texOffs(16, 74).mirror()
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		RightShoe.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LeftShoe.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
