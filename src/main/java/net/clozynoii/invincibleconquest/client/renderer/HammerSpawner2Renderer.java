
package net.clozynoii.invincibleconquest.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.clozynoii.invincibleconquest.entity.HammerSpawner2Entity;

public class HammerSpawner2Renderer extends HumanoidMobRenderer<HammerSpawner2Entity, HumanoidModel<HammerSpawner2Entity>> {
	public HammerSpawner2Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<HammerSpawner2Entity>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(HammerSpawner2Entity entity) {
		return ResourceLocation.parse("invincible_conquest:textures/entities/blank.png");
	}
}
