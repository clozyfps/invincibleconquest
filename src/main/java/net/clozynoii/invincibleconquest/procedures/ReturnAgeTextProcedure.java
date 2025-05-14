package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class ReturnAgeTextProcedure {
	public static String execute() {
		if (!((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null) == null)) {
			if ((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null).getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAge > 0) {
				return "Age: " + (new java.text.DecimalFormat("#")
						.format((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null).getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength));
			} else {
				return "Age: " + (new java.text.DecimalFormat("#")
						.format((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null) instanceof AgeableMob _ageable5 ? _ageable5.getAge() : 0));
			}
		}
		return "Age:";
	}
}
