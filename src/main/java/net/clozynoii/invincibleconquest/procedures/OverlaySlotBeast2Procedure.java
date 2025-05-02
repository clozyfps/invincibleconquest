package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class OverlaySlotBeast2Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 1) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2a).equals("Titan Leap")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2a).equals("Claws")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2a).equals("Constant Claws")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2a).equals("Drag")) {
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Beast")) {
					return 1;
				}
			}
		} else if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2b).equals("Titan Leap")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2b).equals("Claws")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2b).equals("Constant Claws")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2b).equals("Drag")) {
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Beast")) {
					return 1;
				}
			}
		}
		return 0;
	}
}
