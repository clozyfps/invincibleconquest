package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.SpaceshipEntity;

public class SpaceshipModel extends GeoModel<SpaceshipEntity> {
	@Override
	public ResourceLocation getAnimationResource(SpaceshipEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/stuoid.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SpaceshipEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/stuoid.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SpaceshipEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
