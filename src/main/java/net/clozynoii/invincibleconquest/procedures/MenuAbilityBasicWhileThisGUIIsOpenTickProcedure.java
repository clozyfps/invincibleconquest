package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class MenuAbilityBasicWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
			MenuAbilityViltrumiteWhileThisGUIIsOpenTickProcedure.execute(entity);
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Human")) {
			MenuAbilityViltrumiteWhileThisGUIIsOpenTickProcedure.execute(entity);
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Speedster")) {
			MenuAbilitySpeedsterWhileThisGUIIsOpenTickProcedure.execute(entity);
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Spider")) {
			MenuAbilitySpiderWhileThisGUIIsOpenTickProcedure.execute(entity);
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Cloning")) {
			MenuAbilityCloningWhileThisGUIIsOpenTickProcedure.execute(entity);
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Explode")) {
			MenuAbilityExplodeWhileThisGUIIsOpenTickProcedure.execute(entity);
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Portal")) {
			MenuAbilityPortalWhileThisGUIIsOpenTickProcedure.execute(entity);
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Beast")) {
			MenuAbilityBeastWhileThisGUIIsOpenTickProcedure.execute(entity);
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Atom")) {
			MenuAbilityAtomWhileThisGUIIsOpenTickProcedure.execute(entity);
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Robot")) {
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Tech Jacket")) {
			MenuAbilityTechJacketWhileThisGUIIsOpenTickProcedure.execute(entity);
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Human")) {
			MenuAbilityGDAWhileThisGUIIsOpenTickProcedure.execute(entity);
		}
	}
}
