package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.entity.SpaceshipEntity;

import java.util.List;
import java.util.Comparator;

public class EnterMoonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entity == entityiterator)) {
					if (entityiterator.isPassenger()) {
						if ((entityiterator.getVehicle()) instanceof SpaceshipEntity) {
							entityiterator.getPersistentData().putDouble("oldfuel", ((entityiterator.getVehicle()) instanceof SpaceshipEntity _datEntI ? _datEntI.getEntityData().get(SpaceshipEntity.DATA_Fuel) : 0));
							entityiterator.getPersistentData().putDouble("oldhealth", ((entityiterator.getVehicle()) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.TAMED_SPACE_EFFECTG, 30, 1, false, false));
							if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:moon_world"));
								if (_player.level().dimension() == destinationType)
									return;
								ServerLevel nextLevel = _player.server.getLevel(destinationType);
								if (nextLevel != null) {
									_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
									_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
									for (MobEffectInstance _effectinstance : _player.getActiveEffects())
										_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
									_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
							{
								Entity _ent = entityiterator;
								_ent.teleportTo(0, 200, 0);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(0, 200, 0, _ent.getYRot(), _ent.getXRot());
							}
						}
					} else {
						if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:moon_world"));
							if (_player.level().dimension() == destinationType)
								return;
							ServerLevel nextLevel = _player.server.getLevel(destinationType);
							if (nextLevel != null) {
								_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
								_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
								for (MobEffectInstance _effectinstance : _player.getActiveEffects())
									_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
								_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
		}
	}
}
