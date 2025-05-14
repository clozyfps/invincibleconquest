package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class TestItemItemInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("#").format(InvincibleConquestModVariables.MapVariables.get(world).WaveTimer))), true);
	}
}
