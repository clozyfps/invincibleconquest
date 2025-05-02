package net.clozynoii.invincibleconquest.client.renderer;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.clozynoii.invincibleconquest.entity.PlayerCloneEntity;

public class PlayerCloneRenderer extends HumanoidMobRenderer<PlayerCloneEntity, HumanoidModel<PlayerCloneEntity>> {
    public PlayerCloneRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(
            this,
            new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
            new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)),
            context.getModelManager()
        ));
    }

    @Override
    public ResourceLocation getTextureLocation(PlayerCloneEntity entity) {
        GameProfile profile = entity.getSkinProfile();
        if (profile != null) {
            SkinManager mgr = Minecraft.getInstance().getSkinManager();
            PlayerSkin skin = mgr.getInsecureSkin(profile);
            if (skin != null) return skin.texture();
        }
        return ResourceLocation.fromNamespaceAndPath(
            "invincible_conquest",
            "textures/entities/clone.png"
        );
    }
}
