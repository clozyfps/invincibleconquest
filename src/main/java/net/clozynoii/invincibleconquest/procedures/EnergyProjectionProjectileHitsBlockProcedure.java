package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;

public class EnergyProjectionProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.LARGE_EXPLOSION.get()), x, y, z, 5, 0.1, 0.1, 0.1, 0);
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, (float) (1 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus / 20), Level.ExplosionInteraction.BLOCK);
	}
}
