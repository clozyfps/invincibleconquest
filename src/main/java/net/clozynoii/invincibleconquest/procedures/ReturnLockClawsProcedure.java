package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnLockClawsProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Claws" + ", ")) {
			return true;
		}
		return false;
	}
}
