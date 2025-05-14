package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.functions.CommandFunction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModGameRules;

import java.util.Optional;
import java.util.List;
import java.util.Comparator;

public class AbilitySlamProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean single = false;
		boolean gate = false;
		String ability = "";
		double cooldown = 0;
		double magnitude = 0;
		double targets = 0;
		double reduction = 0;
		double outputModifier = 0;
		double stamindaReduction = 0;
		double staminacost = 0;
		stamindaReduction = 15 * ((((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100)
				* (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.STM_STAMINA_DRAIN))) / 100);
		staminacost = 15 - stamindaReduction;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina >= staminacost) {
			gate = false;
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.PlayerCurrentStamina = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina - staminacost;
				_vars.syncPlayerVariables(entity);
			}
			reduction = 80 * ((((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100)
					* (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.FOC_COOLDOWN_REDUCTION))) / 100);
			outputModifier = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput / 100;
			cooldown = 80 - reduction;
			single = false;
			targets = 0;
			magnitude = 0;
			ability = "Slam";
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
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.InputDelay = 12;
				_vars.syncPlayerVariables(entity);
			}
			if (world.isClientSide()) {
				SetupAnimationsProcedure.setAnimationClientside((Player) entity, "slam", true);
			}
			if (!world.isClientSide()) {
				if (entity instanceof Player)
					PacketDistributor.sendToPlayersInDimension((ServerLevel) entity.level(), new SetupAnimationsProcedure.InvincibleConquestModAnimationMessage("slam", entity.getId(), true));
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					Optional<CommandFunction<CommandSourceStack>> _fopt = _ent.getServer().getFunctions().get(ResourceLocation.parse("invincible_conquest:slam_function"));
					if (_fopt.isPresent())
						_ent.getServer().getFunctions().execute(_fopt.get(), _ent.createCommandSourceStack());
				}
			}
			entity.push(0, (-0.75), 0);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.NO_FALL, 30, 0, false, false));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("playsound invincible_conquest:whoosh player " + "@a" + " ~ ~ ~ 1 1"));
			{
				final Vec3 _center = new Vec3(
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getX()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getY()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.ANY, entity)).getBlockPos().getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable")))) {
						if (gate == false) {
							entityiterator.invulnerableTime = 0;
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), entity), 4);
							if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:red_blood"))) || entityiterator instanceof Player) {
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entityiterator.getX()), (entityiterator.getY() + 1.25), (entityiterator.getZ()), 35, 0.1, 0.1, 0.1, 0.1);
							} else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:green_blood")))) {
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.GREEN_BLOOD_DRIP.get()), (entityiterator.getX()), (entityiterator.getY() + 1.25), (entityiterator.getZ()), 35, 0.1, 0.1, 0.1, 0.1);
							}
							entityiterator.invulnerableTime = 0;
							if (entityiterator.onGround()) {
								world.levelEvent(2001, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
										Block.getId((world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() - 1, entityiterator.getZ())))));
							}
							entity.invulnerableTime = 10;
							entityiterator.push(0, (-0.75), 0);
							targets = targets + 1;
							if (targets >= 1) {
								gate = true;
							}
						}
						if (single == false) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("playsound invincible_conquest:basic_hit player " + "@a" + " ~ ~ ~ 1 1"));
							single = true;
						}
					}
				}
			}
			if (targets == 0) {
				if (entity.onGround()) {
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId((world.getBlockState(BlockPos.containing(x, y - 1, z)))));
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Not enough Stamina!"), false);
		}
	}
}
