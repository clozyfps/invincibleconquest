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

import net.clozynoii.invincibleconquest.world.inventory.FigherJetGUIMenu;
import net.clozynoii.invincibleconquest.procedures.CostDisplayProcedure;
import net.clozynoii.invincibleconquest.procedures.BudgetDisplayProcedure;
import net.clozynoii.invincibleconquest.network.FigherJetGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FigherJetGUIScreen extends AbstractContainerScreen<FigherJetGUIMenu> {
	private final static HashMap<String, Object> guistate = FigherJetGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox XValue;
	EditBox ZValue;
	Button button_purchase;

	public FigherJetGUIScreen(FigherJetGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/figher_jet_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		XValue.render(guiGraphics, mouseX, mouseY, partialTicks);
		ZValue.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String XValueValue = XValue.getValue();
		String ZValueValue = ZValue.getValue();
		super.resize(minecraft, width, height);
		XValue.setValue(XValueValue);
		ZValue.setValue(ZValueValue);
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
		XValue = new EditBox(this.font, this.leftPos + -40, this.topPos + 82, 21, 18, Component.translatable("gui.invincible_conquest.figher_jet_gui.XValue")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.figher_jet_gui.XValue").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.figher_jet_gui.XValue").getString());
				else
					setSuggestion(null);
			}
		};
		XValue.setMaxLength(32767);
		XValue.setSuggestion(Component.translatable("gui.invincible_conquest.figher_jet_gui.XValue").getString());
		guistate.put("text:XValue", XValue);
		this.addWidget(this.XValue);
		ZValue = new EditBox(this.font, this.leftPos + 17, this.topPos + 82, 20, 18, Component.translatable("gui.invincible_conquest.figher_jet_gui.ZValue")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.figher_jet_gui.ZValue").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.invincible_conquest.figher_jet_gui.ZValue").getString());
				else
					setSuggestion(null);
			}
		};
		ZValue.setMaxLength(32767);
		ZValue.setSuggestion(Component.translatable("gui.invincible_conquest.figher_jet_gui.ZValue").getString());
		guistate.put("text:ZValue", ZValue);
		this.addWidget(this.ZValue);
		button_purchase = Button.builder(Component.translatable("gui.invincible_conquest.figher_jet_gui.button_purchase"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FigherJetGUIButtonMessage(0, x, y, z));
				FigherJetGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -35, this.topPos + 121, 67, 20).build();
		guistate.put("button:button_purchase", button_purchase);
		this.addRenderableWidget(button_purchase);
	}
}
