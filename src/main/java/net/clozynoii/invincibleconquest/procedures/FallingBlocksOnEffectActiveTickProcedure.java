package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import java.util.List;
import java.util.Comparator;

public class FallingBlocksOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof FallingBlockEntity) {
					magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
					vecX = entity.getLookAngle().x / magnitude;
					vecY = entity.getLookAngle().y / magnitude;
					vecZ = entity.getLookAngle().z / magnitude;
					vecX = vecX * Mth.nextInt(RandomSource.create(), -1, 1);
					vecY = vecY * 0.25;
					vecZ = vecZ * Mth.nextInt(RandomSource.create(), -1, 1);
					entityiterator.push(vecX, 0.5, vecZ);
				}
			}
		}
	}
}
