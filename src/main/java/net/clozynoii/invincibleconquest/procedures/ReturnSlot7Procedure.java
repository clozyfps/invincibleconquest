package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnSlot7Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2b).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move1Name)) {
			return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move1Cost;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2b).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move2Name)) {
			return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move2Cost;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2b).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move3Name)) {
			return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move3Cost;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2b).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move4Name)) {
			return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move4Cost;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2b).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move5Name)) {
			return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move5Cost;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2b).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move6Name)) {
			return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move6Cost;
		}
		return 0;
	}
}
