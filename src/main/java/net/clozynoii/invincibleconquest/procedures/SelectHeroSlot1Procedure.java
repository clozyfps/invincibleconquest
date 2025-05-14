package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class SelectHeroSlot1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.HeroSlot1 = entity.getPersistentData().getString("recenthero");
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
