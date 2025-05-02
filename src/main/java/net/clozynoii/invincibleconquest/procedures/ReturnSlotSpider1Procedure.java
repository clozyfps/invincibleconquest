package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnSlotSpider1Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Web Shooter")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Web Pull")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Invisibility")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Venom Punch")) {
			return 1;
		}
		return 0;
	}
}
