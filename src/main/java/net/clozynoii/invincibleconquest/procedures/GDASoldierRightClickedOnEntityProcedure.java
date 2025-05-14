package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

public class GDASoldierRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(InvincibleConquestModMobEffects.PAUSE_DIALOGUE))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.PAUSE_DIALOGUE, 5, 0, false, false));
				if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(InvincibleConquestModMobEffects.PATROL)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(InvincibleConquestModMobEffects.PATROL);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7aStatus: Follow"), false);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.FOLLOW, 99999, 0, false, false));
				} else if (entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(InvincibleConquestModMobEffects.FOLLOW)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(InvincibleConquestModMobEffects.FOLLOW);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7aStatus: Hold"), false);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.HOLD, 99999, 0, false, false));
				} else if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(InvincibleConquestModMobEffects.HOLD)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(InvincibleConquestModMobEffects.HOLD);
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7aStatus: Patrol"), false);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.PATROL, 99999, 0, false, false));
				}
			}
		}
	}
}
