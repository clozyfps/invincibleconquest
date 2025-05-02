package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnLockAirDensityProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean gate = false;
		if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Air Density" + ", ")) {
			return true;
		}
		return false;
	}
}
