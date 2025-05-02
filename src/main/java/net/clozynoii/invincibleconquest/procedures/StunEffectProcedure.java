package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

public class StunEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(InvincibleConquestModMobEffects.DESTRUCTIVE_FLIGHT)) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(InvincibleConquestModMobEffects.DESTRUCTIVE_FLIGHT);
			}
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFlying == true) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFlying = false;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(InvincibleConquestModMobEffects.STUN) ? _livEnt.getEffect(InvincibleConquestModMobEffects.STUN).getAmplifier() : 0) >= 9) {
			entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			entity.setDeltaMovement(new Vec3(0, 0, 0));
		}
	}
}
