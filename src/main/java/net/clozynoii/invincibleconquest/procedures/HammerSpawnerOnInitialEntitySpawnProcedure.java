package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModEntities;
import net.clozynoii.invincibleconquest.entity.TheHammerEntity;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import java.util.Comparator;

public class HammerSpawnerOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("hammerspawnertimer", 50);
		InvincibleConquestMod.queueServerWork(50, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = InvincibleConquestModEntities.THE_HAMMER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (!world.getEntitiesOfClass(TheHammerEntity.class, AABB.ofSize(new Vec3(x, y, z), 99999, 99999, 99999), e -> true).isEmpty()) {
				if (((Entity) world.getEntitiesOfClass(TheHammerEntity.class, AABB.ofSize(new Vec3(x, y, z), 99999, 99999, 99999), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.EXPLOSION_LEVEL, 99999, 1, false, false));
			}
		});
	}
}
