
package net.clozynoii.invincibleconquest.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.invincibleconquest.entity.model.StealthGDASoldierModel;
import net.clozynoii.invincibleconquest.entity.StealthGDASoldierEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class StealthGDASoldierRenderer extends GeoEntityRenderer<StealthGDASoldierEntity> {
	public StealthGDASoldierRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new StealthGDASoldierModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(StealthGDASoldierEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, StealthGDASoldierEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}
}
