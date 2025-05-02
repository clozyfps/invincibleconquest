package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;

public class ExplosionFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.EXPLOSION.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0);
		if (immediatesourceentity.getPersistentData().getDouble("explosionTimer") == 0) {
			immediatesourceentity.getPersistentData().putDouble("explosionTimer", (Mth.nextInt(RandomSource.create(), 5, 10)));
		}
		if (immediatesourceentity.getPersistentData().getDouble("explosionTimer") > 1) {
			immediatesourceentity.getPersistentData().putDouble("explosionTimer", (immediatesourceentity.getPersistentData().getDouble("explosionTimer") - 1));
		}
		if (immediatesourceentity.getPersistentData().getDouble("explosionTimer") == 1) {
			ExplosionSmallProjectileHitsBlockProcedure.execute(world, x, y, z, entity, immediatesourceentity);
		}
	}
}
