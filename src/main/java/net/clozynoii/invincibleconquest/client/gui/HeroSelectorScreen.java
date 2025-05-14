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

import net.clozynoii.invincibleconquest.world.inventory.HeroSelectorMenu;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockedHero5Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockedHero4Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockedHero3Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockedHero2Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockedHero1Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockedHero5Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockedHero3Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockedHero2Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockedHero1Procedure;
import net.clozynoii.invincibleconquest.procedures.HeroSlot5NameReturnProcedure;
import net.clozynoii.invincibleconquest.procedures.HeroSlot4NameReturnProcedure;
import net.clozynoii.invincibleconquest.procedures.HeroSlot3NameReturnProcedure;
import net.clozynoii.invincibleconquest.procedures.HeroSlot2NameReturnProcedure;
import net.clozynoii.invincibleconquest.procedures.HeroSlot1NameReturnProcedure;
import net.clozynoii.invincibleconquest.network.HeroSelectorButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class HeroSelectorScreen extends AbstractContainerScreen<HeroSelectorMenu> {
	private final static HashMap<String, Object> guistate = HeroSelectorMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_blank16x;
	ImageButton imagebutton_blank22x;
	ImageButton imagebutton_blank22x1;
	ImageButton imagebutton_blank22x2;
	ImageButton imagebutton_blank22x3;

	public HeroSelectorScreen(HeroSelectorMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/hero_selector.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -26 && mouseX < leftPos + -2 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.literal(HeroSlot3NameReturnProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 0 && mouseX < leftPos + 24 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.literal(HeroSlot4NameReturnProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 26 && mouseX < leftPos + 50 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.literal(HeroSlot5NameReturnProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + -78 && mouseX < leftPos + -54 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.literal(HeroSlot1NameReturnProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + -52 && mouseX < leftPos + -28 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.literal(HeroSlot2NameReturnProcedure.execute(entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/menu_empty.png"), this.leftPos + -213, this.topPos + -37, 0, 0, 427, 240, 427, 240);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + -77, this.topPos + 37, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + -51, this.topPos + 37, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + -25, this.topPos + 37, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + 1, this.topPos + 37, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + 27, this.topPos + 37, 0, 0, 22, 22, 22, 22);

		if (ReturnLockedHero2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + -48, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnLockedHero1Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + -74, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnLockedHero3Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + -22, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockedHero4Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + 4, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnLockedHero5Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/icon_question.png"), this.leftPos + 30, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockedHero2Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_gda_hero.png"), this.leftPos + -48, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockedHero3Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_gda_hero.png"), this.leftPos + -22, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockedHero4Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_gda_hero.png"), this.leftPos + 4, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockedHero5Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_gda_hero.png"), this.leftPos + 30, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockedHero1Procedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_gda_hero.png"), this.leftPos + -74, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.invincible_conquest.hero_selector.label_dimension_seleciton"), -75, 15, -11252677, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.invincible_conquest.hero_selector.label_dimension_selection"), -76, 14, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_blank16x = new ImageButton(this.leftPos + -77, this.topPos + 37, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new HeroSelectorButtonMessage(0, x, y, z));
						HeroSelectorButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x", imagebutton_blank16x);
		this.addRenderableWidget(imagebutton_blank16x);
		imagebutton_blank22x = new ImageButton(this.leftPos + -51, this.topPos + 36, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new HeroSelectorButtonMessage(1, x, y, z));
						HeroSelectorButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x", imagebutton_blank22x);
		this.addRenderableWidget(imagebutton_blank22x);
		imagebutton_blank22x1 = new ImageButton(this.leftPos + -25, this.topPos + 37, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new HeroSelectorButtonMessage(2, x, y, z));
						HeroSelectorButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x1", imagebutton_blank22x1);
		this.addRenderableWidget(imagebutton_blank22x1);
		imagebutton_blank22x2 = new ImageButton(this.leftPos + 1, this.topPos + 37, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new HeroSelectorButtonMessage(3, x, y, z));
						HeroSelectorButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x2", imagebutton_blank22x2);
		this.addRenderableWidget(imagebutton_blank22x2);
		imagebutton_blank22x3 = new ImageButton(this.leftPos + 27, this.topPos + 36, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new HeroSelectorButtonMessage(4, x, y, z));
						HeroSelectorButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x3", imagebutton_blank22x3);
		this.addRenderableWidget(imagebutton_blank22x3);
	}
}
