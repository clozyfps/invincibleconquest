package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ReturnShowHealthProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == 0 || !entity.isAlive()) {
			return false;
		}
		return true;
	}
}
