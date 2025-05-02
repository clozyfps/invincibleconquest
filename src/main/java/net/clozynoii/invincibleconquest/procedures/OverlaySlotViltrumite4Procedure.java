package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class OverlaySlotViltrumite4Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 1) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4a).equals("Strong Punch")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4a).equals("Sonic Clap")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4a).equals("Drag")) {
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
					return 1;
				}
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4a).equals("Chop")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4a).equals("Bullet Slam")) {
				return 1;
			}
		} else if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4b).equals("Strong Punch")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4b).equals("Sonic Clap")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4b).equals("Drag")) {
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
					return 1;
				}
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4b).equals("Chop")) {
				return 1;
			}
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4b).equals("Bullet Slam")) {
				return 1;
			}
		}
		return 0;
	}
}
