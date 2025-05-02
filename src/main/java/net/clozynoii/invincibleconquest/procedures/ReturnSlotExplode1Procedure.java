package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnSlotExplode1Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Charged Toss")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Scatter Toss")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Firework")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Ignite")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Detonate")) {
			return 1;
		}
		return 0;
	}
}
