package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModGameRules;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import java.util.List;
import java.util.Comparator;

public class ChopAbilityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		double stamindaReduction = 0;
		double staminacost = 0;
		double cooldown = 0;
		double reduction = 0;
		double outputModifier = 0;
		boolean gate = false;
		String ability = "";
		stamindaReduction = 25 * ((((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100)
				* (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.STM_STAMINA_DRAIN))) / 100);
		staminacost = 25 - stamindaReduction;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina >= staminacost) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.PlayerCurrentStamina = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina - staminacost;
				_vars.syncPlayerVariables(entity);
			}
			reduction = 60 * ((((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100)
					* (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.FOC_COOLDOWN_REDUCTION))) / 100);
			outputModifier = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput / 100;
			cooldown = 60 - reduction;
			ability = "Chop";
			if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).NoCooldowns == false) {
				if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 1 || entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AbilityBar == 2) {
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1a).equals(ability)) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.Cooldown1a = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2a).equals(ability)) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.Cooldown2a = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3a).equals(ability)) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.Cooldown3a = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4a).equals(ability)) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.Cooldown4a = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5a).equals(ability)) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.Cooldown5a = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability1b).equals(ability)) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.Cooldown1b = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability2b).equals(ability)) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.Cooldown2b = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability3b).equals(ability)) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.Cooldown3b = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability4b).equals(ability)) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.Cooldown4b = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Ability5b).equals(ability)) {
						{
							InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
							_vars.Cooldown5b = cooldown;
							_vars.syncPlayerVariables(entity);
						}
					}
				}
			}
			if (world.isClientSide()) {
				SetupAnimationsProcedure.setAnimationClientside((Player) entity, "chop", true);
			}
			if (!world.isClientSide()) {
				if (entity instanceof Player)
					PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("chop", entity.getId(), true));
			}
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			InvincibleConquestMod.queueServerWork(5, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1, (float) 0.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1, (float) 0.5, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.shoot")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.shoot")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				entity.getPersistentData().putDouble("deg", (entity.getYRot() - 90));
				entity.getPersistentData().putDouble("r", 1);
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable")))) {
								if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:red_blood"))) || entityiterator instanceof Player) {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entityiterator.getX()), (entityiterator.getY() + 1.25), (entityiterator.getZ()), 35, 0.1, 0.1, 0.1, 0.1);
								} else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:green_blood")))) {
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.GREEN_BLOOD_DRIP.get()), (entityiterator.getX()), (entityiterator.getY() + 1.25), (entityiterator.getZ()), 35, 0.1, 0.1, 0.1, 0.1);
								}
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), entity), (float) (10 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 3));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:blood_explosion")),
												SoundSource.PLAYERS, 1, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:blood_explosion")),
												SoundSource.PLAYERS, 1, 1, false);
									}
								}
							}
						}
					}
				}
				for (int index0 = 0; index0 < 5; index0++) {
					for (int index1 = 0; index1 < 11; index1++) {
						entity.getPersistentData().putDouble("yslice", (entity.getPersistentData().getDouble("yslice") + 0.1));
						if (entity.getPersistentData().getDouble("r") == 2 || entity.getPersistentData().getDouble("r") == 3) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.POOF, (x - entity.getPersistentData().getDouble("r") * Math.sin(Math.toRadians(entity.getPersistentData().getDouble("deg")))), (y + entity.getPersistentData().getDouble("yslice")),
										(z + entity.getPersistentData().getDouble("r") * Math.cos(Math.toRadians(entity.getPersistentData().getDouble("deg")))), 2, 0.1, 0.1, 0.1, 0.1);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.SWEEP_ATTACK, (x - entity.getPersistentData().getDouble("r") * Math.sin(Math.toRadians(entity.getPersistentData().getDouble("deg")))),
										(y + entity.getPersistentData().getDouble("yslice")), (z + entity.getPersistentData().getDouble("r") * Math.cos(Math.toRadians(entity.getPersistentData().getDouble("deg")))), 1, 0.1, 0.1, 0.1, 0.1);
							entity.getPersistentData().putDouble("deg", (entity.getPersistentData().getDouble("deg") + 18));
						}
					}
					if (entity.getPersistentData().getDouble("r") == 2 || entity.getPersistentData().getDouble("r") == 4) {
						entity.getPersistentData().putDouble("deg", (entity.getYRot() - 81));
					} else {
						entity.getPersistentData().putDouble("deg", (entity.getYRot() - 90));
					}
					entity.getPersistentData().putDouble("r", (entity.getPersistentData().getDouble("r") + 1));
				}
				entity.getPersistentData().putDouble("yslice", 0);
			});
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Not enough Stamina!"), false);
		}
	}
}
