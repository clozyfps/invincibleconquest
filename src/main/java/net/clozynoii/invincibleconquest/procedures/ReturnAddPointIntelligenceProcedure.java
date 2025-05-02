package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnAddPointIntelligenceProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerSkillPoints > 0 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerIntelligence < 100) {
			return true;
		}
		return false;
	}
}
