package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

import java.util.List;
import java.util.Comparator;

public class TimeStopAbilityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(InvincibleConquestModMobEffects.STOPPED_TIME))) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle minecraft:dust 0.263 0.278 0.29 1 ^0 ^1 ^ 1 1 1 0.05 40 force @a");
			if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_DAYLIGHT) == true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"gamerule doDaylightCycle false");
				InvincibleConquestModVariables.MapVariables.get(world).DaylightChanged = true;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			}
			if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_FIRE_DAMAGE) == true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"gamerule fireDamage false");
				InvincibleConquestModVariables.MapVariables.get(world).DaylightChanged = true;
				InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.STOPPED_TIME, 999999, 0, false, false));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator == entity) == false) {
						entityiterator.getPersistentData().putDouble("TimeX", (entityiterator.getDeltaMovement().x()));
						entityiterator.getPersistentData().putDouble("TimeY", (entityiterator.getDeltaMovement().y()));
						entityiterator.getPersistentData().putDouble("TimeZ", (entityiterator.getDeltaMovement().z()));
						entityiterator.getPersistentData().putDouble("LookX",
								(entityiterator.level()
										.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(100)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entityiterator))
										.getBlockPos().getX()));
						entityiterator.getPersistentData().putDouble("LookY",
								(entityiterator.level()
										.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(100)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entityiterator))
										.getBlockPos().getY()));
						entityiterator.getPersistentData().putDouble("LookZ",
								(entityiterator.level()
										.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(100)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entityiterator))
										.getBlockPos().getZ()));
						entityiterator.getPersistentData().putBoolean("InitialStop", true);
					}
				}
			}
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(InvincibleConquestModMobEffects.STOPPED_TIME);
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld == true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"gamerule doDaylightCycle true");
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.KeyHeld = false;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).KeyHeld == true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"gamerule fireDamage true");
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.KeyHeld = false;
					_vars.syncPlayerVariables(entity);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator == entity) == false) {
						entityiterator.setDeltaMovement(new Vec3((entityiterator.getPersistentData().getDouble("TimeX")), (entityiterator.getPersistentData().getDouble("TimeY")), (entityiterator.getPersistentData().getDouble("TimeZ"))));
						entityiterator.getPersistentData().putBoolean("InitialStop", false);
					}
				}
			}
		}
	}
}
