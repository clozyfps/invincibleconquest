package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModGameRules;

public class ReturnDescriptionDurabilityProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
			return "\u00A76\u00A7l\u00A7nDurability" + "/n" + "\u00A77\u00A7oAffects the toughness" + "/n" + "\u00A77\u00A7oand resistance of your body" + "/n" + "/n" + "\u00A7e\u00A7l\u00A7nLevel: \u00A7e\u00A7n"
					+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability)
					+ (" (+" + new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) + ")") + "/n" + "\u00A7f+"
					+ new java.text.DecimalFormat("##").format((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
							/ (100 / (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.DURABILITY_DAMAGE_RESISTANCE))))
					+ " \u00A7f\u00A7lDamage Resistance" + "/n" + "\u00A7f+"
					+ new java.text.DecimalFormat("##.##").format((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost)
							/ (100 / (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.DURABILITY_KNOCKBACK_RESISTANCE))))
					+ " \u00A7f\u00A7lKnockback Resistance";
		}
		return "\u00A76\u00A7l\u00A7nDurability" + "/n" + "\u00A77\u00A7oAffects the toughness" + "/n" + "\u00A77\u00A7oand resistance of your body" + "/n" + "/n" + "\u00A7e\u00A7l\u00A7nLevel: \u00A7e\u00A7n"
				+ new java.text.DecimalFormat("##").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability) + "/n" + "\u00A7f+"
				+ new java.text.DecimalFormat("##")
						.format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability / (100 / (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.DURABILITY_DAMAGE_RESISTANCE))))
				+ " \u00A7f\u00A7lDamage Resistance" + "/n" + "\u00A7f+"
				+ new java.text.DecimalFormat("##.##")
						.format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerDurability / (100 / (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.DURABILITY_KNOCKBACK_RESISTANCE))))
				+ " \u00A7f\u00A7lKnockback Resistance";
	}
}
