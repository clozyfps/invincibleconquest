package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModEntities;
import net.clozynoii.invincibleconquest.entity.DimensionalPortalEntity;

import java.util.List;
import java.util.Comparator;

public class SelectDimensionDesertProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:desert_wasteland")))) {
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).DimensionList.contains("Desert" + ", ")) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = InvincibleConquestModEntities.DIMENSIONAL_PORTAL.get().spawn(_level,
							BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1,
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
							MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && entityiterator instanceof DimensionalPortalEntity) {
							if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
								_toTame.tame(_owner);
							if (entityiterator instanceof DimensionalPortalEntity _datEntSetS)
								_datEntSetS.getEntityData().set(DimensionalPortalEntity.DATA_TargetDimension, "Desert");
						}
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You haven't been to that dimension"), true);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You can not open a portal here"), true);
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
