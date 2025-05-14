package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.FighterJetEntity;

public class FighterJetModel extends GeoModel<FighterJetEntity> {
	@Override
	public ResourceLocation getAnimationResource(FighterJetEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/jet.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FighterJetEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/jet.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FighterJetEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
