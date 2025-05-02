package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class AbilitySlotDisplay1Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 1) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityTable.contains(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a)) {
				return 1;
			}
		} else if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbilityTable.contains(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1b)) {
				return 1;
			}
		}
		return 0;
	}
}
