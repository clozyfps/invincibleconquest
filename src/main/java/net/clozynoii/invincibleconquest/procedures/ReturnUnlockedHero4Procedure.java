package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnUnlockedHero4Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).HeroSlot4).isEmpty()) {
			return true;
		}
		return false;
	}
}
