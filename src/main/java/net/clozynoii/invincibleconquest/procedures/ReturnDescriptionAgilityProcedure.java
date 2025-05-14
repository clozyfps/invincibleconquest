package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModGameRules;

public class ReturnDescriptionAgilityProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
			return "\u00A76\u00A7l\u00A7nAgility" + "/n" + "\u00A77\u00A7oAffects the speed of" + "/n" + "\u00A77\u00A7oyour body and reactions" + "/n" + "/n" + "\u00A7e\u00A7l\u00A7nLevel: \u00A7e\u00A7n"
					+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAgility)
					+ (" (+" + new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) + ")") + "/n" + "\u00A7f+"
					+ new java.text.DecimalFormat("##.##").format((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAgility + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
							/ (100 / (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.AGILITY_MOVEMENT_SPEED))))
					+ " \u00A7f\u00A7lMovement Speed" + "/n" + "\u00A7f+"
					+ new java.text.DecimalFormat("##.##").format((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAgility + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
							/ (100 / (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.AGILITY_ATTACK_SPEED))))
					+ " \u00A7f\u00A7lAttack Speed";
		}
		return "\u00A76\u00A7l\u00A7nAgility" + "/n" + "\u00A77\u00A7oAffects the speed of" + "/n" + "\u00A77\u00A7oyour body and reactions" + "/n" + "/n" + "\u00A7e\u00A7l\u00A7nLevel: \u00A7e\u00A7n"
				+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAgility) + "/n" + "\u00A7f+"
				+ new java.text.DecimalFormat("##.##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAgility / (100 / (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.AGILITY_MOVEMENT_SPEED))))
				+ " \u00A7f\u00A7lMovement Speed" + "/n" + "\u00A7f+"
				+ new java.text.DecimalFormat("##.##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAgility / (100 / (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.AGILITY_ATTACK_SPEED))))
				+ " \u00A7f\u00A7lAttack Speed";
	}
}
