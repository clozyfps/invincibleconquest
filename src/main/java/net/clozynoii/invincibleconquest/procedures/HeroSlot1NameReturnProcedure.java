package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class HeroSlot1NameReturnProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).HeroSlot1;
	}
}
