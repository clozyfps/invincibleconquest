package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnBalanceProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Balance $" + new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Balance);
	}
}
