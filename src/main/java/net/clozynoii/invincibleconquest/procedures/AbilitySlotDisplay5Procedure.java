package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class AbilitySlotDisplay5Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 1) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5a).equals("Heavy Attack")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5a).equals("Barrage")) {
				return 2;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5a).equals("Uppercut")) {
				return 3;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5a).equals("Dash")) {
				return 4;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5a).equals("Slam")) {
				return 5;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5a).equals("Grab")) {
				return 6;
			}
		} else if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5b).equals("Heavy Attack")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5b).equals("Barrage")) {
				return 2;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5b).equals("Uppercut")) {
				return 3;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5b).equals("Dash")) {
				return 4;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5b).equals("Slam")) {
				return 5;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5b).equals("Grab")) {
				return 6;
			}
		}
		return 0;
	}
}
