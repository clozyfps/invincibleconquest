package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnUnlockHeavyAttackProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).UnlockedSkills.contains(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Move1Name + ", ")) {
			return true;
		}
		return false;
	}
}
