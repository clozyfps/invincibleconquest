package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

public class FlashTimeAbilityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean gate = false;
		String ability = "";
		double cooldown = 0;
		double magnitude = 0;
		double reduction = 0;
		double targets = 0;
		double outputModifier = 0;
		if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Flash Time")) {
			if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(InvincibleConquestModMobEffects.FLASH_TIME))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.FLASH_TIME, 99999, 0, false, false));
			} else if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(InvincibleConquestModMobEffects.FLASH_TIME)) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(InvincibleConquestModMobEffects.FLASH_TIME);
			}
		}
	}
}
