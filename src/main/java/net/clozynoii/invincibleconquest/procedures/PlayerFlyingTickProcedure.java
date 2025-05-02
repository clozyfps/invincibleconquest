package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerFlyingTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean creativeFlight = false;
		double flightSpeed = 0;
		double outputModifier = 0;
		outputModifier = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput / 100;
		flightSpeed = 1
				+ ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAgility + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / (100 / (double) InvincibleConfigConfiguration.AGLMOVEMENTSPEED.get())) * 2
						* outputModifier;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFlying == true) {
			if (entity.isSprinting()) {
				if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite") || (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Atom")
						|| (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Tech Jacket")) {
					creativeFlight = false;
					if (entity instanceof Player _plr && !(_plr.isFallFlying())) {
						_plr.startFallFlying();
					}
					if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Tech Jacket")) {
						if (world.isClientSide()) {
							SetupAnimationsProcedure.setAnimationClientside((Player) entity, "fly_fast", true);
						}
						if (!world.isClientSide()) {
							if (entity instanceof Player)
								PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("fly_fast", entity.getId(), true));
						}
					} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Tech Jacket")) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.POOF, x, y, z, 3, 0.1, 0.1, 0.1, 0.2);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.FLAME, x, y, z, 2, 0.1, 0.1, 0.1, 0);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 1, 0.1, 0.1, 0.1, 0.2);
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.ELECTRICITY_SMALL.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0.2);
					}
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Atom")) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"particle dust{color:[0.94,0.58,0.99],scale:2} ~ ~ ~ 0.5 0.5 0.5 0 5");
					}
					if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(InvincibleConquestModMobEffects.DESTRUCTIVE_FLIGHT)) {
						flightSpeed = flightSpeed * 2.25;
					} else {
						if (entity.onGround()) {
							if (entity.getLookAngle().y < -0.75) {
								{
									InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
									_vars.PlayerFlying = false;
									_vars.syncPlayerVariables(entity);
								}
								if (world.isClientSide()) {
									SetupAnimationsProcedure.setAnimationClientside((Player) entity, "", false);
								}
								if (!world.isClientSide()) {
									if (entity instanceof Player)
										PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("", entity.getId(), false));
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.CRATER, 1, 0, false, false));
							}
						}
					}
					if (entity instanceof Player player) {
						player.getAbilities().flying = (creativeFlight == true);
						player.onUpdateAbilities();
						if (player.isFallFlying()) {
							Vec3 lookVec = player.getLookAngle();
							Vec3 flightVelocity = new Vec3(lookVec.x * flightSpeed, lookVec.y * flightSpeed, lookVec.z * flightSpeed);
							player.setDeltaMovement(flightVelocity);
						}
					}
				}
			} else {
				creativeFlight = true;
				if (entity.isShiftKeyDown()) {
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Portal")) {
						if (world.isClientSide()) {
							SetupAnimationsProcedure.setAnimationClientside((Player) entity, "angstromfly", true);
						}
						if (!world.isClientSide()) {
							if (entity instanceof Player)
								PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("angstromfly", entity.getId(), true));
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 5, 0.1, 0.1, 0.1, 0);
					} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Atom")) {
						if (world.isClientSide()) {
							SetupAnimationsProcedure.setAnimationClientside((Player) entity, "fly_down", true);
						}
						if (!world.isClientSide()) {
							if (entity instanceof Player)
								PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("fly_down", entity.getId(), true));
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"particle dust{color:[0.94,0.58,0.99],scale:2} ~ ~ ~ 0.5 0.5 0.5 0 5");
					} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Tech Jacket")) {
						if (world.isClientSide()) {
							SetupAnimationsProcedure.setAnimationClientside((Player) entity, "fly_down", true);
						}
						if (!world.isClientSide()) {
							if (entity instanceof Player)
								PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("fly_down", entity.getId(), true));
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.DIRTY_SMOKE.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0.1);
					}
				} else {
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Portal")) {
						if (world.isClientSide()) {
							SetupAnimationsProcedure.setAnimationClientside((Player) entity, "angstromfly", true);
						}
						if (!world.isClientSide()) {
							if (entity instanceof Player)
								PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("angstromfly", entity.getId(), true));
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 5, 0.1, 0.1, 0.1, 0);
					} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Tech Jacket")) {
						if (world.isClientSide()) {
							SetupAnimationsProcedure.setAnimationClientside((Player) entity, "fly_idle", true);
						}
						if (!world.isClientSide()) {
							if (entity instanceof Player)
								PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("fly_idle", entity.getId(), true));
						}
						world.addParticle(ParticleTypes.POOF, x, y, z, 0, (-0.2), 0);
						world.addParticle(ParticleTypes.FLAME, x, y, z, 0, (-0.1), 0);
						world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 0, (-0.05), 0);
					} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Atom")) {
						if (world.isClientSide()) {
							SetupAnimationsProcedure.setAnimationClientside((Player) entity, "fly_idle", true);
						}
						if (!world.isClientSide()) {
							if (entity instanceof Player)
								PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("fly_idle", entity.getId(), true));
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"particle dust{color:[0.94,0.58,0.99],scale:2} ~ ~ ~ 0.5 0.5 0.5 0 5");
					}
				}
				if (entity instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect(InvincibleConquestModMobEffects.DESTRUCTIVE_FLIGHT)) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(InvincibleConquestModMobEffects.DESTRUCTIVE_FLIGHT);
				}
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.NO_FALL, 40, 0, false, false));
			if (entity instanceof Player _player) {
				_player.getAbilities().flying = (creativeFlight == true);
				_player.onUpdateAbilities();
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().mayfly = (creativeFlight == true);
				_player.onUpdateAbilities();
			}
		} else {
			creativeFlight = false;
		}
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity) || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if (entity instanceof Player _player) {
				_player.getAbilities().flying = (creativeFlight == true);
				_player.onUpdateAbilities();
			}
			if (entity instanceof Player _player) {
				_player.getAbilities().mayfly = (creativeFlight == true);
				_player.onUpdateAbilities();
			}
		}
	}
}
