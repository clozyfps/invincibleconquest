package net.clozynoii.invincibleconquest.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.clozynoii.invincibleconquest.world.inventory.MenuAbilityBasicMenu;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockUppercutProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockSlamProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockHeavyAttackProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockGrabProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockDashProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnUnlockBarrageProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSlot9Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSlot8Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSlot7Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSlot6Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSlot5Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSlot4Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSlot3Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSlot2Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSlot1Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnSlot10Procedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockUppercutProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockSlamProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockHeavyAttackProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockGrabProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockDashProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnLockBarrageProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnHasAbilityProcedure;
import net.clozynoii.invincibleconquest.procedures.ReturnAbilityTabNameProcedure;
import net.clozynoii.invincibleconquest.network.MenuAbilityBasicButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MenuAbilityBasicScreen extends AbstractContainerScreen<MenuAbilityBasicMenu> {
	private final static HashMap<String, Object> guistate = MenuAbilityBasicMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_tab_top_unselected;
	ImageButton imagebutton_tab_bottom_unselected;
	ImageButton imagebutton_blank16x;
	ImageButton imagebutton_blank16x1;
	ImageButton imagebutton_blank16x2;
	ImageButton imagebutton_blank16x3;
	ImageButton imagebutton_blank16x4;
	ImageButton imagebutton_blank16x5;
	ImageButton imagebutton_blank16x6;
	ImageButton imagebutton_blank16x7;
	ImageButton imagebutton_blank16x8;
	ImageButton imagebutton_blank16x9;
	ImageButton imagebutton_blank22x;
	ImageButton imagebutton_blank22x1;
	ImageButton imagebutton_blank22x2;
	ImageButton imagebutton_blank22x3;
	ImageButton imagebutton_blank22x4;
	ImageButton imagebutton_blank22x5;

	public MenuAbilityBasicScreen(MenuAbilityBasicMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("invincible_conquest:textures/screens/menu_ability_basic.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -88 && mouseX < leftPos + -64 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_stat_menu"), mouseX, mouseY);
		if (mouseX > leftPos + -63 && mouseX < leftPos + -39 && mouseY > topPos + -107 && mouseY < topPos + -83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_ability_menu"), mouseX, mouseY);
		if (mouseX > leftPos + -88 && mouseX < leftPos + -64 && mouseY > topPos + 83 && mouseY < topPos + 107)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_basic_abilities"), mouseX, mouseY);
		if (ReturnHasAbilityProcedure.execute(entity))
			if (mouseX > leftPos + -63 && mouseX < leftPos + -39 && mouseY > topPos + 83 && mouseY < topPos + 107)
				guiGraphics.renderTooltip(font, Component.literal(ReturnAbilityTabNameProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 94 && mouseX < leftPos + 112 && mouseY > topPos + -44 && mouseY < topPos + -26)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_slot_1"), mouseX, mouseY);
		if (mouseX > leftPos + 94 && mouseX < leftPos + 112 && mouseY > topPos + -23 && mouseY < topPos + -5)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_slot_2"), mouseX, mouseY);
		if (mouseX > leftPos + 94 && mouseX < leftPos + 112 && mouseY > topPos + -2 && mouseY < topPos + 16)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_slot_3"), mouseX, mouseY);
		if (mouseX > leftPos + 94 && mouseX < leftPos + 112 && mouseY > topPos + 19 && mouseY < topPos + 37)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_slot_4"), mouseX, mouseY);
		if (mouseX > leftPos + 94 && mouseX < leftPos + 112 && mouseY > topPos + 40 && mouseY < topPos + 58)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_slot_5"), mouseX, mouseY);
		if (mouseX > leftPos + 115 && mouseX < leftPos + 133 && mouseY > topPos + -33 && mouseY < topPos + -15)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_slot_6"), mouseX, mouseY);
		if (mouseX > leftPos + 115 && mouseX < leftPos + 133 && mouseY > topPos + -12 && mouseY < topPos + 6)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_slot_7"), mouseX, mouseY);
		if (mouseX > leftPos + 115 && mouseX < leftPos + 133 && mouseY > topPos + 9 && mouseY < topPos + 27)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_slot_8"), mouseX, mouseY);
		if (mouseX > leftPos + 115 && mouseX < leftPos + 133 && mouseY > topPos + 30 && mouseY < topPos + 48)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_slot_9"), mouseX, mouseY);
		if (mouseX > leftPos + 115 && mouseX < leftPos + 133 && mouseY > topPos + 51 && mouseY < topPos + 69)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_slot_10"), mouseX, mouseY);
		if (mouseX > leftPos + -78 && mouseX < leftPos + -56 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_heavy_attack"), mouseX, mouseY);
		if (mouseX > leftPos + -52 && mouseX < leftPos + -30 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_barrage"), mouseX, mouseY);
		if (mouseX > leftPos + -26 && mouseX < leftPos + -4 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_uppercut"), mouseX, mouseY);
		if (mouseX > leftPos + 1 && mouseX < leftPos + 23 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_slam"), mouseX, mouseY);
		if (mouseX > leftPos + 27 && mouseX < leftPos + 49 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_dash"), mouseX, mouseY);
		if (mouseX > leftPos + 53 && mouseX < leftPos + 75 && mouseY > topPos + -47 && mouseY < topPos + -25)
			guiGraphics.renderTooltip(font, Component.translatable("gui.invincible_conquest.menu_ability_basic.tooltip_grab_1_sp"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/menu_empty.png"), this.leftPos + -214, this.topPos + -120, 0, 0, 427, 240, 427, 240);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/tab_top_fill.png"), this.leftPos + -89, this.topPos + -109, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/tab_top_middle.png"), this.leftPos + -64, this.topPos + -111, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/slot_abilities.png"), this.leftPos + 89, this.topPos + -49, 0, 0, 49, 123, 49, 123);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/tab_bottom_edge.png"), this.leftPos + -89, this.topPos + 79, 0, 0, 26, 32, 26, 32);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + -78, this.topPos + -47, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + -52, this.topPos + -47, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + -26, this.topPos + -47, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + 1, this.topPos + -47, 0, 0, 22, 22, 22, 22);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + 27, this.topPos + -47, 0, 0, 22, 22, 22, 22);

		if (ReturnUnlockHeavyAttackProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_heavy.png"), this.leftPos + -75, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockBarrageProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_barrage.png"), this.leftPos + -49, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockUppercutProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_uppercut.png"), this.leftPos + -23, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockSlamProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_slam.png"), this.leftPos + 4, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnUnlockDashProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_dash.png"), this.leftPos + 30, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnLockHeavyAttackProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_lock.png"), this.leftPos + -72, this.topPos + -43, 0, 0, 10, 14, 10, 14);
		}
		if (ReturnLockBarrageProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_lock.png"), this.leftPos + -46, this.topPos + -43, 0, 0, 10, 14, 10, 14);
		}
		if (ReturnLockUppercutProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_lock.png"), this.leftPos + -20, this.topPos + -43, 0, 0, 10, 14, 10, 14);
		}
		if (ReturnLockSlamProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_lock.png"), this.leftPos + 7, this.topPos + -43, 0, 0, 10, 14, 10, 14);
		}
		if (ReturnLockDashProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_lock.png"), this.leftPos + 33, this.topPos + -43, 0, 0, 10, 14, 10, 14);
		}

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/blank_slot.png"), this.leftPos + 53, this.topPos + -47, 0, 0, 22, 22, 22, 22);

		if (ReturnUnlockGrabProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_grab.png"), this.leftPos + 56, this.topPos + -44, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnLockGrabProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/ability_lock.png"), this.leftPos + 59, this.topPos + -43, 0, 0, 10, 14, 10, 14);
		}

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), this.leftPos + 95, this.topPos + -43, Mth.clamp((int) ReturnSlot1Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), this.leftPos + 95, this.topPos + -22, Mth.clamp((int) ReturnSlot2Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), this.leftPos + 95, this.topPos + -1, Mth.clamp((int) ReturnSlot3Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), this.leftPos + 95, this.topPos + 20, Mth.clamp((int) ReturnSlot4Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), this.leftPos + 95, this.topPos + 41, Mth.clamp((int) ReturnSlot5Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), this.leftPos + 116, this.topPos + -32, Mth.clamp((int) ReturnSlot6Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), this.leftPos + 116, this.topPos + -11, Mth.clamp((int) ReturnSlot7Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), this.leftPos + 116, this.topPos + 10, Mth.clamp((int) ReturnSlot8Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), this.leftPos + 116, this.topPos + 31, Mth.clamp((int) ReturnSlot9Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

		guiGraphics.blit(ResourceLocation.parse("invincible_conquest:textures/screens/abilities_sprite.png"), this.leftPos + 116, this.topPos + 52, Mth.clamp((int) ReturnSlot10Procedure.execute(entity) * 16, 0, 96), 0, 16, 16, 112, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.invincible_conquest.menu_ability_basic.label_basic_abilities1"), -77, -68, -11252677, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.invincible_conquest.menu_ability_basic.label_basic_abilities"), -78, -69, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_tab_top_unselected = new ImageButton(this.leftPos + -89, this.topPos + -109, 26, 32,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/tab_top_unselected.png"), ResourceLocation.parse("invincible_conquest:textures/screens/tab_top_unselected.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(0, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_top_unselected", imagebutton_tab_top_unselected);
		this.addRenderableWidget(imagebutton_tab_top_unselected);
		imagebutton_tab_bottom_unselected = new ImageButton(this.leftPos + -64, this.topPos + 80, 26, 32,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/tab_bottom_unselected.png"), ResourceLocation.parse("invincible_conquest:textures/screens/tab_bottom_unselected.png")), e -> {
					if (ReturnHasAbilityProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(1, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReturnHasAbilityProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tab_bottom_unselected", imagebutton_tab_bottom_unselected);
		this.addRenderableWidget(imagebutton_tab_bottom_unselected);
		imagebutton_blank16x = new ImageButton(this.leftPos + 95, this.topPos + -43, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(2, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x", imagebutton_blank16x);
		this.addRenderableWidget(imagebutton_blank16x);
		imagebutton_blank16x1 = new ImageButton(this.leftPos + 95, this.topPos + -22, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(3, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x1", imagebutton_blank16x1);
		this.addRenderableWidget(imagebutton_blank16x1);
		imagebutton_blank16x2 = new ImageButton(this.leftPos + 95, this.topPos + -1, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(4, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x2", imagebutton_blank16x2);
		this.addRenderableWidget(imagebutton_blank16x2);
		imagebutton_blank16x3 = new ImageButton(this.leftPos + 95, this.topPos + 20, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(5, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x3", imagebutton_blank16x3);
		this.addRenderableWidget(imagebutton_blank16x3);
		imagebutton_blank16x4 = new ImageButton(this.leftPos + 95, this.topPos + 41, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(6, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x4", imagebutton_blank16x4);
		this.addRenderableWidget(imagebutton_blank16x4);
		imagebutton_blank16x5 = new ImageButton(this.leftPos + 116, this.topPos + -32, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(7, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x5", imagebutton_blank16x5);
		this.addRenderableWidget(imagebutton_blank16x5);
		imagebutton_blank16x6 = new ImageButton(this.leftPos + 116, this.topPos + -11, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(8, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x6", imagebutton_blank16x6);
		this.addRenderableWidget(imagebutton_blank16x6);
		imagebutton_blank16x7 = new ImageButton(this.leftPos + 116, this.topPos + 10, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(9, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x7", imagebutton_blank16x7);
		this.addRenderableWidget(imagebutton_blank16x7);
		imagebutton_blank16x8 = new ImageButton(this.leftPos + 116, this.topPos + 31, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(10, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x8", imagebutton_blank16x8);
		this.addRenderableWidget(imagebutton_blank16x8);
		imagebutton_blank16x9 = new ImageButton(this.leftPos + 116, this.topPos + 52, 16, 16,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank16x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(11, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank16x9", imagebutton_blank16x9);
		this.addRenderableWidget(imagebutton_blank16x9);
		imagebutton_blank22x = new ImageButton(this.leftPos + -78, this.topPos + -47, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(12, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x", imagebutton_blank22x);
		this.addRenderableWidget(imagebutton_blank22x);
		imagebutton_blank22x1 = new ImageButton(this.leftPos + -52, this.topPos + -47, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(13, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x1", imagebutton_blank22x1);
		this.addRenderableWidget(imagebutton_blank22x1);
		imagebutton_blank22x2 = new ImageButton(this.leftPos + -26, this.topPos + -47, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(14, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 14, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x2", imagebutton_blank22x2);
		this.addRenderableWidget(imagebutton_blank22x2);
		imagebutton_blank22x3 = new ImageButton(this.leftPos + 1, this.topPos + -47, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(15, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 15, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x3", imagebutton_blank22x3);
		this.addRenderableWidget(imagebutton_blank22x3);
		imagebutton_blank22x4 = new ImageButton(this.leftPos + 27, this.topPos + -47, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(16, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 16, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x4", imagebutton_blank22x4);
		this.addRenderableWidget(imagebutton_blank22x4);
		imagebutton_blank22x5 = new ImageButton(this.leftPos + 53, this.topPos + -47, 22, 22,
				new WidgetSprites(ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png"), ResourceLocation.parse("invincible_conquest:textures/screens/blank22x.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new MenuAbilityBasicButtonMessage(17, x, y, z));
						MenuAbilityBasicButtonMessage.handleButtonAction(entity, 17, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_blank22x5", imagebutton_blank22x5);
		this.addRenderableWidget(imagebutton_blank22x5);
	}
}
