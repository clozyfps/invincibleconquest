package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

public class CheckFollowGDAProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(InvincibleConquestModMobEffects.FOLLOW)) {
			return true;
		}
		return false;
	}
}
