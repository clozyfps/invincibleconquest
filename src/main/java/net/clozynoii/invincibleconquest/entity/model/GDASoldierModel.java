package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.GDASoldierEntity;

public class GDASoldierModel extends GeoModel<GDASoldierEntity> {
	@Override
	public ResourceLocation getAnimationResource(GDASoldierEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/gda_soldier.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GDASoldierEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/gda_soldier.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GDASoldierEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
