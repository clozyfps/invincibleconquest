
package net.clozynoii.invincibleconquest.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.clozynoii.invincibleconquest.procedures.HeroDisplayConditionProcedure;
import net.clozynoii.invincibleconquest.entity.HeroEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class HeroRenderer extends HumanoidMobRenderer<HeroEntity, HumanoidModel<HeroEntity>> {
	public HeroRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<HeroEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new RenderLayer<HeroEntity, HumanoidModel<HeroEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("invincible_conquest:textures/entities/alex-original.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, HeroEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (HeroDisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(HeroEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/normal-steve-template-on-planetminecraft-com.png");
	}
}
