
package net.clozynoii.invincibleconquest.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.clozynoii.invincibleconquest.entity.model.SpaceshipModel;
import net.clozynoii.invincibleconquest.entity.layer.SpaceshipLayer;
import net.clozynoii.invincibleconquest.entity.SpaceshipEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SpaceshipRenderer extends GeoEntityRenderer<SpaceshipEntity> {
	public SpaceshipRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SpaceshipModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new SpaceshipLayer(this));
	}

	@Override
	public RenderType getRenderType(SpaceshipEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, SpaceshipEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}
}
