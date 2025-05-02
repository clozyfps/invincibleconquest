package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnSlotViltrumite1Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Strong Punch")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Sonic Clap")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Drag")) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
				return 1;
			}
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Chop")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Bullet Slam")) {
			return 1;
		}
		return 0;
	}
}
