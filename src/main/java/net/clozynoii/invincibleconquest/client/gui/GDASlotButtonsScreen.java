package net.clozynoii.invincibleconquest.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.clozynoii.invincibleconquest.world.inventory.GDASlotButtonsMenu;
import net.clozynoii.invincibleconquest.network.GDASlotButtonsButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GDASlotButtonsScreen extends AbstractContainerScreen<GDASlotButtonsMenu> {
	private final static HashMap<String, Object> guistate = GDASlotButtonsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_blank_slot;
	ImageButton imagebutton_blank_slot1;
	ImageButton imagebutton_blank_slot2;
	ImageButton imagebutton_blank_slot3;
	ImageButton imagebutton_blank_slot4;

	public GDASlotButtonsScreen(GDASlotButtonsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/gda_slot_buttons.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.invincible_conquest.gda_slot_buttons.label_select_which_slot_to_equip"), -70, 63, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.invincible_conquest.gda_slot_buttons.label_empty"), -70, 62, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_blank_slot = new ImageButton(this.leftPos + -77, this.topPos + 84, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GDASlotButtonsButtonMessage(0, x, y, z));
						GDASlotButtonsButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank_slot", imagebutton_blank_slot);
		this.addRenderableWidget(imagebutton_blank_slot);
		imagebutton_blank_slot1 = new ImageButton(this.leftPos + -45, this.topPos + 84, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GDASlotButtonsButtonMessage(1, x, y, z));
						GDASlotButtonsButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank_slot1", imagebutton_blank_slot1);
		this.addRenderableWidget(imagebutton_blank_slot1);
		imagebutton_blank_slot2 = new ImageButton(this.leftPos + -13, this.topPos + 84, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GDASlotButtonsButtonMessage(2, x, y, z));
						GDASlotButtonsButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank_slot2", imagebutton_blank_slot2);
		this.addRenderableWidget(imagebutton_blank_slot2);
		imagebutton_blank_slot3 = new ImageButton(this.leftPos + 20, this.topPos + 84, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GDASlotButtonsButtonMessage(3, x, y, z));
						GDASlotButtonsButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank_slot3", imagebutton_blank_slot3);
		this.addRenderableWidget(imagebutton_blank_slot3);
		imagebutton_blank_slot4 = new ImageButton(this.leftPos + 53, this.topPos + 84, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GDASlotButtonsButtonMessage(4, x, y, z));
						GDASlotButtonsButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank_slot4", imagebutton_blank_slot4);
		this.addRenderableWidget(imagebutton_blank_slot4);
	}
}
