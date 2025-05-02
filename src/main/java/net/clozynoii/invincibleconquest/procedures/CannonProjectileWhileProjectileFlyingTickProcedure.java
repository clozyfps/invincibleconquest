package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

public class CannonProjectileWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get()), x, (y + 1), z, 1, 0.1, 0.1, 0.1, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 25, 0.1, 0.1, 0.1, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, (y + 1), z, 3, 0.1, 0.1, 0.1, 0.3);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.ELECTRICITY_SMALL.get()), x, (y + 1), z, 5, 0.1, 0.1, 0.1, 0.3);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FIREWORK, x, (y + 1), z, 10, 0.1, 0.1, 0.1, 0.4);
		immediatesourceentity.setNoGravity(true);
		InvincibleConquestMod.queueServerWork(60, () -> {
			if (immediatesourceentity.isAlive()) {
				CannonProjectileProjectileHitsLivingEntityProcedure.execute(world, immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ(), entity);
			}
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
	}
}
