package net.clozynoii.invincibleconquest.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.world.inventory.GDASoldierGUIMenu;
import net.clozynoii.invincibleconquest.procedures.CostDisplayProcedure;
import net.clozynoii.invincibleconquest.procedures.BudgetDisplayProcedure;
import net.clozynoii.invincibleconquest.network.GDASoldierGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GDASoldierGUIScreen extends AbstractContainerScreen<GDASoldierGUIMenu> {
	private final static HashMap<String, Object> guistate = GDASoldierGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox gdasoldieramount;
	Button button_purchase;

	public GDASoldierGUIScreen(GDASoldierGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/gda_soldier_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		gdasoldieramount.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/gda-export.png"), this.leftPos + -214, this.topPos + -37, 0, 0, 427, 240, 427, 240);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (gdasoldieramount.isFocused())
			return gdasoldieramount.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String gdasoldieramountValue = gdasoldieramount.getValue();
		super.resize(minecraft, width, height);
		gdasoldieramount.setValue(gdasoldieramountValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				BudgetDisplayProcedure.execute(entity), -68, 63, -11277229, false);
		guiGraphics.drawString(this.font,

				CostDisplayProcedure.execute(entity), 17, 63, -3407872, false);
	}

	@Override
	public void init() {
		super.init();
		gdasoldieramount = new EditBox(this.font, this.leftPos + -61, this.topPos + 84, 118, 18, Component.translatable("gui.invincible_conquest.gda_soldier_gui.gdasoldieramount")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.gda_soldier_gui.gdasoldieramount").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.gda_soldier_gui.gdasoldieramount").getString());
				else
					setSuggestion(null);
			}
		};
		gdasoldieramount.setMaxLength(32767);
		gdasoldieramount.setSuggestion(Component.translatable("gui.invincible_conquest.gda_soldier_gui.gdasoldieramount").getString());
		guistate.put("text:gdasoldieramount", gdasoldieramount);
		this.addWidget(this.gdasoldieramount);
		button_purchase = Button.builder(Component.translatable("gui.invincible_conquest.gda_soldier_gui.button_purchase"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new GDASoldierGUIButtonMessage(0, x, y, z));
				GDASoldierGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -35, this.topPos + 121, 67, 20).build();
		guistate.put("button:button_purchase", button_purchase);
		this.addRenderableWidget(button_purchase);
	}
}
