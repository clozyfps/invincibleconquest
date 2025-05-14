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

import net.clozynoii.invincibleconquest.world.inventory.TeleportGUIMenu;
import net.clozynoii.invincibleconquest.procedures.CostDisplayProcedure;
import net.clozynoii.invincibleconquest.procedures.BudgetDisplayProcedure;
import net.clozynoii.invincibleconquest.network.TeleportGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TeleportGUIScreen extends AbstractContainerScreen<TeleportGUIMenu> {
	private final static HashMap<String, Object> guistate = TeleportGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox XValue;
	EditBox ZValue;
	EditBox YValue;
	Button button_purchase;

	public TeleportGUIScreen(TeleportGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/teleport_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		XValue.render(guiGraphics, mouseX, mouseY, partialTicks);
		ZValue.render(guiGraphics, mouseX, mouseY, partialTicks);
		YValue.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (XValue.isFocused())
			return XValue.keyPressed(key, b, c);
		if (ZValue.isFocused())
			return ZValue.keyPressed(key, b, c);
		if (YValue.isFocused())
			return YValue.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String XValueValue = XValue.getValue();
		String ZValueValue = ZValue.getValue();
		String YValueValue = YValue.getValue();
		super.resize(minecraft, width, height);
		XValue.setValue(XValueValue);
		ZValue.setValue(ZValueValue);
		YValue.setValue(YValueValue);
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
		XValue = new EditBox(this.font, this.leftPos + -60, this.topPos + 82, 21, 18, Component.translatable("gui.invincible_conquest.teleport_gui.XValue")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.teleport_gui.XValue").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.teleport_gui.XValue").getString());
				else
					setSuggestion(null);
			}
		};
		XValue.setMaxLength(32767);
		XValue.setSuggestion(Component.translatable("gui.invincible_conquest.teleport_gui.XValue").getString());
		guistate.put("text:XValue", XValue);
		this.addWidget(this.XValue);
		ZValue = new EditBox(this.font, this.leftPos + 34, this.topPos + 82, 20, 18, Component.translatable("gui.invincible_conquest.teleport_gui.ZValue")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.teleport_gui.ZValue").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.teleport_gui.ZValue").getString());
				else
					setSuggestion(null);
			}
		};
		ZValue.setMaxLength(32767);
		ZValue.setSuggestion(Component.translatable("gui.invincible_conquest.teleport_gui.ZValue").getString());
		guistate.put("text:ZValue", ZValue);
		this.addWidget(this.ZValue);
		YValue = new EditBox(this.font, this.leftPos + -12, this.topPos + 82, 20, 18, Component.translatable("gui.invincible_conquest.teleport_gui.YValue")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.teleport_gui.YValue").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.teleport_gui.YValue").getString());
				else
					setSuggestion(null);
			}
		};
		YValue.setMaxLength(32767);
		YValue.setSuggestion(Component.translatable("gui.invincible_conquest.teleport_gui.YValue").getString());
		guistate.put("text:YValue", YValue);
		this.addWidget(this.YValue);
		button_purchase = Button.builder(Component.translatable("gui.invincible_conquest.teleport_gui.button_purchase"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new TeleportGUIButtonMessage(0, x, y, z));
				TeleportGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -35, this.topPos + 121, 67, 20).build();
		guistate.put("button:button_purchase", button_purchase);
		this.addRenderableWidget(button_purchase);
	}
}
