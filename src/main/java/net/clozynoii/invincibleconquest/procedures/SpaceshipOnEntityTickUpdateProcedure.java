package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.entity.SpaceshipEntity;

import java.util.Comparator;

public class SpaceshipOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof SpaceshipEntity _datEntI ? _datEntI.getEntityData().get(SpaceshipEntity.DATA_Fuel) : 0) <= 0) {
			if (entity.isVehicle()) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).stopRiding();
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 15) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, (y + 1), z, 3, 0.1, 0.1, 0.1, 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.DIRTY_SMOKE.get()), x, (y + 1), z, 3, 0.1, 0.1, 0.1, 0.2);
			entity.push((entity.getDeltaMovement().x()), (-0.5), (entity.getDeltaMovement().z()));
		}
	}
}
