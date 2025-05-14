package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.SavagePlanetEntity;

public class SavagePlanetModel extends GeoModel<SavagePlanetEntity> {
	@Override
	public ResourceLocation getAnimationResource(SavagePlanetEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/planet_earthlike.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SavagePlanetEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/planet_earthlike.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SavagePlanetEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
