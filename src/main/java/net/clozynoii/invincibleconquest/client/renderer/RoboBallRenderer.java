
package net.clozynoii.invincibleconquest.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.clozynoii.invincibleconquest.entity.RoboBallEntity;
import net.clozynoii.invincibleconquest.client.model.Modelrobo_ball;

public class RoboBallRenderer extends MobRenderer<RoboBallEntity, Modelrobo_ball<RoboBallEntity>> {
	public RoboBallRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelrobo_ball<RoboBallEntity>(context.bakeLayer(Modelrobo_ball.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(RoboBallEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/robot_ball.png");
	}
}
