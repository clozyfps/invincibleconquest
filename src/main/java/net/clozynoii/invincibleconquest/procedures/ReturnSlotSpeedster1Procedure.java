package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnSlotSpeedster1Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Multi Hit")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Flash Time")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Time Stop")) {
			return 1;
		}
		return 0;
	}
}
