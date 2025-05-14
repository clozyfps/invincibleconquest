package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnRaceTextProcedure {
	public static String execute() {
		if (!((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null) == null)) {
			if ((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null) instanceof Player) {
				return "Race: " + (Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null).getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility;
			} else if (!((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null) instanceof Player)) {
				return "Race: " + ((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null).getDisplayName().getString());
			}
		}
		return "Race:";
	}
}
