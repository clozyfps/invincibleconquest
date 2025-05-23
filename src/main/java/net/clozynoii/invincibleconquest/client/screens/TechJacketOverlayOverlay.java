
package net.clozynoii.invincibleconquest.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.procedures.TechJacketHUDDisplayOverlayIngameProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnRaceTextProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnNameTextProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnHeartsProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAgeTextProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class TechJacketOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
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
		if (TechJacketHUDDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().blit(ResourceLocation.parse("invincible_conquest:textures/screens/techjacketdisplay2.png"), 0, 0, 0, 0, w, h, w, h);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnRaceTextProcedure.execute(), 3, h / 2 + -22, -10045719, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnAgeTextProcedure.execute(), 3, h / 2 + -8, -10045719, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnNameTextProcedure.execute(), 3, h / 2 + 6, -10045719, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnHeartsProcedure.execute(), 3, h / 2 + 20, -10045719, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
