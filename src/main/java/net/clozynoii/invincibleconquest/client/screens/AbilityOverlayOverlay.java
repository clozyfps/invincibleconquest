
package net.clozynoii.invincibleconquest.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.procedures.ReturnBarSlot5Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnBarSlot4Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnBarSlot3Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnBarSlot2Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnBarSlot1Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAbilityBar2Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAbilityBar1Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotViltrumite5Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotViltrumite4Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotViltrumite3Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotViltrumite2Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotViltrumite1Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotTechJacket5Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotTechJacket4Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotTechJacket3Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotTechJacket2Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotTechJacket1Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotSpider5Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotSpider4Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotSpider3Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotSpider2Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotSpider1Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotSpeedster5Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotSpeedster4Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotSpeedster3Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotSpeedster2Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotSpeedster1Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotPortal5Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotPortal4Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotPortal3Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotPortal2Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotPortal1Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotExplode5Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotExplode4Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotExplode3Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotExplode2Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotExplode1Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotCloning5Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotCloning4Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotCloning3Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotCloning2Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotCloning1Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotBeast5Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotBeast4Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotBeast3Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotBeast2Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotBeast1Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotAtom5Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotAtom4Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotAtom3Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotAtom2Procedure;
import net.clozynoii.invincibleconquest.procedures.OverlaySlotAtom1Procedure;
import net.clozynoii.invincibleconquest.procedures.HideOverlayF1Procedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class AbilityOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (HideOverlayF1Procedure.execute()) {
			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_bar.png"), 8, h - 34, 0, 0, 110, 26, 110, 26);

			if (ReturnAbilityBar1Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_bar_selected.png"), 108, h - 30, 0, 0, 7, 10, 7, 10);
			}
			if (ReturnAbilityBar2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_bar_selected.png"), 108, h - 22, 0, 0, 7, 10, 7, 10);
			}

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), 13, h - 29, Mth.clamp((int) ReturnBarSlot1Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), 31, h - 29, Mth.clamp((int) ReturnBarSlot2Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), 49, h - 29, Mth.clamp((int) ReturnBarSlot3Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), 67, h - 29, Mth.clamp((int) ReturnBarSlot4Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), 85, h - 29, Mth.clamp((int) ReturnBarSlot5Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_viltrumite.png"), 13, h - 29, Mth.clamp((int) OverlaySlotViltrumite1Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_viltrumite.png"), 31, h - 29, Mth.clamp((int) OverlaySlotViltrumite2Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_viltrumite.png"), 49, h - 29, Mth.clamp((int) OverlaySlotViltrumite3Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_viltrumite.png"), 67, h - 29, Mth.clamp((int) OverlaySlotViltrumite4Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_viltrumite.png"), 85, h - 29, Mth.clamp((int) OverlaySlotViltrumite5Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_atom.png"), 13, h - 29, Mth.clamp((int) OverlaySlotAtom1Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_atom.png"), 31, h - 29, Mth.clamp((int) OverlaySlotAtom2Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_atom.png"), 49, h - 29, Mth.clamp((int) OverlaySlotAtom3Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_atom.png"), 67, h - 29, Mth.clamp((int) OverlaySlotAtom4Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_atom.png"), 85, h - 29, Mth.clamp((int) OverlaySlotAtom5Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_beast.png"), 13, h - 29, Mth.clamp((int) OverlaySlotBeast1Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_beast.png"), 31, h - 29, Mth.clamp((int) OverlaySlotBeast2Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_beast.png"), 49, h - 29, Mth.clamp((int) OverlaySlotBeast3Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_beast.png"), 67, h - 29, Mth.clamp((int) OverlaySlotBeast4Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_beast.png"), 85, h - 29, Mth.clamp((int) OverlaySlotBeast5Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_portal.png"), 13, h - 29, Mth.clamp((int) OverlaySlotPortal1Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_portal.png"), 31, h - 29, Mth.clamp((int) OverlaySlotPortal2Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_portal.png"), 49, h - 29, Mth.clamp((int) OverlaySlotPortal3Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_portal.png"), 67, h - 29, Mth.clamp((int) OverlaySlotPortal4Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_portal.png"), 85, h - 29, Mth.clamp((int) OverlaySlotPortal5Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_clone.png"), 13, h - 29, Mth.clamp((int) OverlaySlotCloning1Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_clone.png"), 31, h - 29, Mth.clamp((int) OverlaySlotCloning2Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_clone.png"), 49, h - 29, Mth.clamp((int) OverlaySlotCloning3Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_clone.png"), 67, h - 29, Mth.clamp((int) OverlaySlotCloning4Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_clone.png"), 85, h - 29, Mth.clamp((int) OverlaySlotCloning5Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_explode.png"), 13, h - 29, Mth.clamp((int) OverlaySlotExplode1Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_explode.png"), 31, h - 29, Mth.clamp((int) OverlaySlotExplode2Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_explode.png"), 49, h - 29, Mth.clamp((int) OverlaySlotExplode3Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_explode.png"), 67, h - 29, Mth.clamp((int) OverlaySlotExplode4Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_explode.png"), 85, h - 29, Mth.clamp((int) OverlaySlotExplode5Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_techjacket.png"), 13, h - 29, Mth.clamp((int) OverlaySlotTechJacket1Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_techjacket.png"), 31, h - 29, Mth.clamp((int) OverlaySlotTechJacket2Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_techjacket.png"), 49, h - 29, Mth.clamp((int) OverlaySlotTechJacket3Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_techjacket.png"), 67, h - 29, Mth.clamp((int) OverlaySlotTechJacket4Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_techjacket.png"), 85, h - 29, Mth.clamp((int) OverlaySlotTechJacket5Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_speedster.png"), 13, h - 29, Mth.clamp((int) OverlaySlotSpeedster1Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_speedster.png"), 31, h - 29, Mth.clamp((int) OverlaySlotSpeedster2Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_speedster.png"), 49, h - 29, Mth.clamp((int) OverlaySlotSpeedster3Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_speedster.png"), 67, h - 29, Mth.clamp((int) OverlaySlotSpeedster4Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_speedster.png"), 85, h - 29, Mth.clamp((int) OverlaySlotSpeedster5Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_spider.png"), 13, h - 29, Mth.clamp((int) OverlaySlotSpider1Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_spider.png"), 31, h - 29, Mth.clamp((int) OverlaySlotSpider2Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_spider.png"), 49, h - 29, Mth.clamp((int) OverlaySlotSpider3Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_spider.png"), 67, h - 29, Mth.clamp((int) OverlaySlotSpider4Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite_spider.png"), 85, h - 29, Mth.clamp((int) OverlaySlotSpider5Procedure.execute(entity) * 16, 0, 16), 0, 16, 16, 32, 16);

		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
