package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnSlotAtom1Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Atomic Blast")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Telekinesis")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Atom Barrier")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Air Density")) {
			return 1;
		}
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals("Atom Creation")) {
			return 1;
		}
		return 0;
	}
}
