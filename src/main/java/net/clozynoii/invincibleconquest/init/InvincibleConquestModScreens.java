
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.clozynoii.invincibleconquest.client.gui.TheHammerGUIScreen;
import net.clozynoii.invincibleconquest.client.gui.TeleportGUIScreen;
import net.clozynoii.invincibleconquest.client.gui.SpaceshipSlotScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuStatsScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuPlanetTakeoverScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuFactionStatsScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilityViltrumiteScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilityTechJacketScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilitySpiderScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilitySpeedsterScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilitySelectionScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilityRobotScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilityPortalScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilityGDAScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilityExplodeScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilityCloningScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilityBeastScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilityBasicScreen;
import net.clozynoii.invincibleconquest.client.gui.MenuAbilityAtomScreen;
import net.clozynoii.invincibleconquest.client.gui.MENUABILITYBLANKScreen;
import net.clozynoii.invincibleconquest.client.gui.HeroSelectorScreen;
import net.clozynoii.invincibleconquest.client.gui.GalacticMapGUIScreen;
import net.clozynoii.invincibleconquest.client.gui.GDASoldierGUIScreen;
import net.clozynoii.invincibleconquest.client.gui.GDASlotButtonsScreen;
import net.clozynoii.invincibleconquest.client.gui.FigherJetGUIScreen;
import net.clozynoii.invincibleconquest.client.gui.FactionJoinViltrumScreen;
import net.clozynoii.invincibleconquest.client.gui.FactionJoinGDAScreen;
import net.clozynoii.invincibleconquest.client.gui.FactionJoinCOPScreen;
import net.clozynoii.invincibleconquest.client.gui.DimensionSelectorScreen;
import net.clozynoii.invincibleconquest.client.gui.AtomEveCreationScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InvincibleConquestModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(InvincibleConquestModMenus.MENU_STATS.get(), MenuStatsScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_SELECTION.get(), MenuAbilitySelectionScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_BASIC.get(), MenuAbilityBasicScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_VILTRUMITE.get(), MenuAbilityViltrumiteScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_SPEEDSTER.get(), MenuAbilitySpeedsterScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_SPIDER.get(), MenuAbilitySpiderScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_CLONING.get(), MenuAbilityCloningScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_EXPLODE.get(), MenuAbilityExplodeScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_PORTAL.get(), MenuAbilityPortalScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_BEAST.get(), MenuAbilityBeastScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_ATOM.get(), MenuAbilityAtomScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_ROBOT.get(), MenuAbilityRobotScreen::new);
		event.register(InvincibleConquestModMenus.FACTION_JOIN_VILTRUM.get(), FactionJoinViltrumScreen::new);
		event.register(InvincibleConquestModMenus.FACTION_JOIN_GDA.get(), FactionJoinGDAScreen::new);
		event.register(InvincibleConquestModMenus.FACTION_JOIN_COP.get(), FactionJoinCOPScreen::new);
		event.register(InvincibleConquestModMenus.MENU_FACTION_STATS.get(), MenuFactionStatsScreen::new);
		event.register(InvincibleConquestModMenus.MENU_PLANET_TAKEOVER.get(), MenuPlanetTakeoverScreen::new);
		event.register(InvincibleConquestModMenus.GALACTIC_MAP_GUI.get(), GalacticMapGUIScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_TECH_JACKET.get(), MenuAbilityTechJacketScreen::new);
		event.register(InvincibleConquestModMenus.MENUABILITYBLANK.get(), MENUABILITYBLANKScreen::new);
		event.register(InvincibleConquestModMenus.DIMENSION_SELECTOR.get(), DimensionSelectorScreen::new);
		event.register(InvincibleConquestModMenus.ATOM_EVE_CREATION.get(), AtomEveCreationScreen::new);
		event.register(InvincibleConquestModMenus.MENU_ABILITY_GDA.get(), MenuAbilityGDAScreen::new);
		event.register(InvincibleConquestModMenus.GDA_SOLDIER_GUI.get(), GDASoldierGUIScreen::new);
		event.register(InvincibleConquestModMenus.FIGHER_JET_GUI.get(), FigherJetGUIScreen::new);
		event.register(InvincibleConquestModMenus.GDA_SLOT_BUTTONS.get(), GDASlotButtonsScreen::new);
		event.register(InvincibleConquestModMenus.HERO_SELECTOR.get(), HeroSelectorScreen::new);
		event.register(InvincibleConquestModMenus.SPACESHIP_SLOT.get(), SpaceshipSlotScreen::new);
		event.register(InvincibleConquestModMenus.THE_HAMMER_GUI.get(), TheHammerGUIScreen::new);
		event.register(InvincibleConquestModMenus.TELEPORT_GUI.get(), TeleportGUIScreen::new);
	}
}
