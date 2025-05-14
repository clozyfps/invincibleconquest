package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.entity.BombEntity;

import java.util.List;
import java.util.Comparator;

public class InstantCratorOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof BombEntity)) {
			entity.getPersistentData().putDouble("shatterexpand", (entity.getPersistentData().getDouble("shatterexpand") + 1));
			int horizontalRadiusHemiTop = (int) (entity.getPersistentData().getDouble("shatterexpand")) - 1;
			int verticalRadiusHemiTop = (int) (entity.getPersistentData().getDouble("shatterexpand"));
			int yIterationsHemiTop = verticalRadiusHemiTop;
			for (int i = 0; i < yIterationsHemiTop; i++) {
				if (i == verticalRadiusHemiTop) {
					continue;
				}
				for (int xi = -horizontalRadiusHemiTop; xi <= horizontalRadiusHemiTop; xi++) {
					for (int zi = -horizontalRadiusHemiTop; zi <= horizontalRadiusHemiTop; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiTop * horizontalRadiusHemiTop) + (i * i) / (double) (verticalRadiusHemiTop * verticalRadiusHemiTop)
								+ (zi * zi) / (double) (horizontalRadiusHemiTop * horizontalRadiusHemiTop);
						if (distanceSq <= 1.0) {
							if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("minecraft:glass")))) {
								world.destroyBlock(BlockPos.containing(x + xi, y + i, z + zi), false);
							}
						}
					}
				}
			}
			int horizontalRadiusHemiBot = (int) (entity.getPersistentData().getDouble("shatterexpand") / 5) - 1;
			int verticalRadiusHemiBot = (int) 1;
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
							if (!(world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("invincible_conquest:unbreakable")))) {
								if (world instanceof ServerLevel _level)
									FallingBlockEntity.fall(_level, BlockPos.containing(x + xi, y + i, z + zi), (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))));
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("shatterexpand")) / 2d), e -> true).stream()
						.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entity == entityiterator)) {
						if (entityiterator instanceof FallingBlockEntity) {
							entityiterator.push(0, 0.2, 0);
						}
					}
				}
			}
			if (entity.getPersistentData().getDouble("shatterexpand") >= 20) {
				entity.getPersistentData().putDouble("shatterexpand", 0);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(InvincibleConquestModMobEffects.INSTANT_CRATOR);
			}
		} else {
			int horizontalRadiusSphere = (int) 10 - 1;
			int verticalRadiusSphere = (int) 10 - 1;
			int yIterationsSphere = verticalRadiusSphere;
			for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
				for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
					for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
								+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
						if (distanceSq <= 1.0) {
							if (!(world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("invincible_conquest:unbreakable")))) {
								world.destroyBlock(BlockPos.containing(x + xi, y + i, z + zi), false);
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.LARGE_EXPLOSION.get()), x, y, z, 25, 5, 5, 5, 0);
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.DIRTY_SMOKE.get()), x, y, z, 3, 5, 5, 5, 0.1);
								if (!entity.level().isClientSide())
									entity.discard();
							}
						}
					}
				}
			}
		}
	}
}
