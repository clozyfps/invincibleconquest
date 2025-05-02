package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnSlot2Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2a).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move1Name)) {
			return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).ReturnMove1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2a).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move2Name)) {
			return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).ReturnMove2;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2a).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move3Name)) {
			return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).ReturnMove3;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2a).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move4Name)) {
			return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).ReturnMove4;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2a).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move5Name)) {
			return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).ReturnMove5;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2a).equals(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move6Name)) {
			return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).ReturnMove6;
		}
		return 0;
	}
}
