package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ViltrumitePunchesProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, damagesource, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite") || (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Beast")
				|| (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Tech Jacket")) {
			if (damagesource.is(DamageTypes.PLAYER_ATTACK)) {
				if (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput >= 100) {
					if (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength >= 10) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(InvincibleConquestModMobEffects.STUN);
						if (sourceentity instanceof LivingEntity _entity)
							_entity.removeEffect(InvincibleConquestModMobEffects.STUN);
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_SMALL.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.1, 1, 0.1, 0);
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 10, 0.1, 0.1, 0.1, 0.1);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.POOF, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 0.01, 0.01, 0.01, 0);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.DAMAGE_DESTRUCTION, 50, 0, false, false));
						world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(Blocks.REDSTONE_BLOCK.defaultBlockState()));
						if (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength >= 25) {
							if (Math.random() < 0.8) {
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.1, 1, 0.1, 0);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.EXPLOSION, (entity.getX()), (entity.getY()), (entity.getZ()), 1, 0.1, 1, 0.1, 0);
								if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.GLASS_BREAK, 1, 0, false, false));
							}
						}
						if (entity instanceof Player) {
							if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFlying) {
								{
									InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
									_vars.PlayerFlying = false;
									_vars.syncPlayerVariables(entity);
								}
								InvincibleConquestMod.queueServerWork(10, () -> {
									{
										InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
										_vars.PlayerFlying = true;
										_vars.syncPlayerVariables(entity);
									}
								});
							}
							entity.getPersistentData().putString("enemytype", "player");
							StrongPunchPlayerKnockbackProcedure.execute(entity, sourceentity);
						} else if (!(entity instanceof Player)) {
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entity.getX()), (entity.getY()), (entity.getZ()),
										(int) (sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength - (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 5), 0.1, 0.1, 0.1, 0);
							entity.getPersistentData().putString("enemytype", "mob");
							StrongPunchMobKnockbackProcedure.execute(entity, sourceentity);
						}
						if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:basic_hit")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:basic_hit")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						} else if (Mth.nextInt(RandomSource.create(), 1, 2) == 2) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:basic_hit")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("invincible_conquest:basic_hit")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
						entity.getPersistentData().putString("target", (sourceentity.getDisplayName().getString()));
					}
				} else {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BLOOD_DRIP.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 10, 0.01, 0.1, 0.01, 0.2);
				}
			}
		}
	}
}
