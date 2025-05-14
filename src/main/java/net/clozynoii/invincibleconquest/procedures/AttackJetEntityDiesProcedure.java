package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;

public class AttackJetEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.LARGE_EXPLOSION.get()), x, y, z, 25, 3, 3, 3, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, x, y, z, 15, 0.1, 0.1, 0.1, 0.3);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, y, z, 5, 0.1, 0.1, 0.1, 0.3);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.LARGE_SMOKE.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0.3);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0);
	}
}
