package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class OverlaySlotGDA3Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 1) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3a).equals("Soldiers")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3a).equals("Stealth Soldiers")) {
				return 2;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3a).equals("Heroes")) {
				return 3;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3a).equals("Fighter Jet")) {
				return 4;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3a).equals("The Hammer")) {
				return 5;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3a).equals("Teleport")) {
				return 6;
			}
		} else if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3b).equals("Soldiers")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3b).equals("Stealth Soldiers")) {
				return 2;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3b).equals("Heroes")) {
				return 3;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3b).equals("Fighter Jet")) {
				return 4;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3b).equals("The Hammer")) {
				return 5;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3b).equals("Teleport")) {
				return 6;
			}
		}
		return 0;
	}
}
