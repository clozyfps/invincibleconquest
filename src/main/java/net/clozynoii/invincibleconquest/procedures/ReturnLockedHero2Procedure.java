package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnLockedHero2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).HeroSlot2).isEmpty()) {
			return true;
		}
		return false;
	}
}
