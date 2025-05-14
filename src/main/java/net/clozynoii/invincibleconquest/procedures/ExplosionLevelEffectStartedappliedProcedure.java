package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.entity.TheHammerEntity;

public class ExplosionLevelEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(InvincibleConquestModMobEffects.EXPLOSION_LEVEL) ? _livEnt.getEffect(InvincibleConquestModMobEffects.EXPLOSION_LEVEL).getAmplifier() : 0) == 1) {
			if (entity instanceof TheHammerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(TheHammerEntity.DATA_Despawn, 40);
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(InvincibleConquestModMobEffects.EXPLOSION_LEVEL) ? _livEnt.getEffect(InvincibleConquestModMobEffects.EXPLOSION_LEVEL).getAmplifier() : 0) == 2) {
			if (entity instanceof TheHammerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(TheHammerEntity.DATA_Despawn, 60);
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(InvincibleConquestModMobEffects.EXPLOSION_LEVEL) ? _livEnt.getEffect(InvincibleConquestModMobEffects.EXPLOSION_LEVEL).getAmplifier() : 0) == 3) {
			if (entity instanceof TheHammerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(TheHammerEntity.DATA_Despawn, 70);
		}
	}
}
