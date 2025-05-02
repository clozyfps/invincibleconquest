package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.TheHammerEntity;

public class TheHammerModel extends GeoModel<TheHammerEntity> {
	@Override
	public ResourceLocation getAnimationResource(TheHammerEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/the_hammer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TheHammerEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/the_hammer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TheHammerEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
