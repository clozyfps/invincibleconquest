package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

public class BombOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(0, (-1.5), 0));
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.DIRTY_SMOKE.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0.2);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.POOF, x, y, z, 5, 0.1, 0.1, 0.1, 0);
		int horizontalRadiusHemiBot = (int) 2 - 1;
		int verticalRadiusHemiBot = (int) 2;
		int yIterationsHemiBot = verticalRadiusHemiBot;
		for (int i = -yIterationsHemiBot; i <= 0; i++) {
			if (i == -verticalRadiusHemiBot) {
				continue;
			}
			for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
				for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
							+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
					if (distanceSq <= 1.0) {
						if (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)).canOcclude()) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.INSTANT_CRATOR, 1, 0, false, false));
						}
					}
				}
			}
		}
	}
}
