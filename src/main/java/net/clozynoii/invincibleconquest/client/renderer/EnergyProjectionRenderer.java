package net.clozynoii.invincibleconquest.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.invincibleconquest.entity.EnergyProjectionEntity;
import net.clozynoii.invincibleconquest.client.model.Modelbeamblock;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class EnergyProjectionRenderer extends EntityRenderer<EnergyProjectionEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/entities/techbeamtexture.png");
	private final Modelbeamblock model;

	public EnergyProjectionRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelbeamblock(context.bakeLayer(Modelbeamblock.LAYER_LOCATION));
	}

	@Override
	public void render(EnergyProjectionEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(EnergyProjectionEntity entity) {
		return texture;
	}
}
