package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnLockedFighterJetProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).UnlockedSkills.contains("Fighter Jet" + ", ")) {
			return true;
		}
		return false;
	}
}
