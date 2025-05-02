package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class BeastMoves5aProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cooldown5a == 0) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld == false && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).InputDelay == 0) {
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5a).equals("Titan Leap")) {
					AbilityTitanLeapProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5a).equals("Claws")) {
					AbilityClawProcedure.execute(world, x, y, z, entity);
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5a).equals("Constant Claws")) {
					AbilityConstantClawsProcedure.execute(entity);
				}
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5a).equals("Drag")) {
					AbilityDragProcedure.execute(entity);
				}
			}
		} else {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld == true) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cAbility On Cooldown!"), true);
			}
		}
	}
}
