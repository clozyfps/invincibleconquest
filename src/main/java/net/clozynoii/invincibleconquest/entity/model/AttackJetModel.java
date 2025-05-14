package net.clozynoii.invincibleconquest.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.clozynoii.invincibleconquest.entity.AttackJetEntity;

public class AttackJetModel extends GeoModel<AttackJetEntity> {
	@Override
	public ResourceLocation getAnimationResource(AttackJetEntity entity) {
		return ResourceLocation.parse("invincible_conquest:animations/jet.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AttackJetEntity entity) {
		return ResourceLocation.parse("invincible_conquest:geo/jet.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AttackJetEntity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/" + entity.getTexture() + ".png");
	}

}
