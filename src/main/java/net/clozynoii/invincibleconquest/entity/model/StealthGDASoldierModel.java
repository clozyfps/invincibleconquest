package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.StealthGDASoldierEntity;

public class StealthGDASoldierModel extends GeoModel<StealthGDASoldierEntity> {
	@Override
	public ResourceLocation getAnimationResource(StealthGDASoldierEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/gda_soldier.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StealthGDASoldierEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/gda_soldier.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StealthGDASoldierEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
