package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class AddPointFocusProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double leftover_points = 0;
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("(WIP)"), false);
	}
}
