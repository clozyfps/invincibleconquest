
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.procedures.TitanLeapEffectEffectExpiresProcedure;
import net.clozynoii.invincibleconquest.procedures.MachineGunEffectsEffectExpiresProcedure;
import net.clozynoii.invincibleconquest.procedures.LaserDestructionEffectExpiresProcedure;
import net.clozynoii.invincibleconquest.procedures.CloudCircleEffectExpiresProcedure;
import net.clozynoii.invincibleconquest.procedures.BarrierEffectEffectExpiresProcedure;
import net.clozynoii.invincibleconquest.procedures.AtomControlEffectEffectExpiresProcedure;
import net.clozynoii.invincibleconquest.procedures.AtomAwakeningEffectEffectExpiresProcedure;
import net.clozynoii.invincibleconquest.procedures.ActiveBeamAtomEffectExpiresProcedure;
import net.clozynoii.invincibleconquest.potion.WebActiveMobEffect;
import net.clozynoii.invincibleconquest.potion.TitanLeapEffectMobEffect;
import net.clozynoii.invincibleconquest.potion.TechJacketFollowUpEffectMobEffect;
import net.clozynoii.invincibleconquest.potion.TechJacketBladeEffectMobEffect;
import net.clozynoii.invincibleconquest.potion.StunMobEffect;
import net.clozynoii.invincibleconquest.potion.StrongFlyingStunnedMobEffect;
import net.clozynoii.invincibleconquest.potion.SmokingMobEffect;
import net.clozynoii.invincibleconquest.potion.SmokeCircleMobEffect;
import net.clozynoii.invincibleconquest.potion.SlicingCircleMobEffect;
import net.clozynoii.invincibleconquest.potion.RobotBallControlMobEffect;
import net.clozynoii.invincibleconquest.potion.PostAtomControlMobEffect;
import net.clozynoii.invincibleconquest.potion.PauseDialogueMobEffect;
import net.clozynoii.invincibleconquest.potion.NoFallMobEffect;
import net.clozynoii.invincibleconquest.potion.MachineGunEffectsMobEffect;
import net.clozynoii.invincibleconquest.potion.LaserKnockbackMobEffect;
import net.clozynoii.invincibleconquest.potion.LaserDestructionMobEffect;
import net.clozynoii.invincibleconquest.potion.InstantCratorMobEffect;
import net.clozynoii.invincibleconquest.potion.ImpactFrameEffectMobEffect;
import net.clozynoii.invincibleconquest.potion.GlassBreakMobEffect;
import net.clozynoii.invincibleconquest.potion.FallingBlocksMobEffect;
import net.clozynoii.invincibleconquest.potion.DragMobEffect;
import net.clozynoii.invincibleconquest.potion.DestructiveFlightMobEffect;
import net.clozynoii.invincibleconquest.potion.DamageDestructionMobEffect;
import net.clozynoii.invincibleconquest.potion.CraterMobEffect;
import net.clozynoii.invincibleconquest.potion.CounterEffectMobEffect;
import net.clozynoii.invincibleconquest.potion.ConstantEffectPunchMobEffect;
import net.clozynoii.invincibleconquest.potion.CloudCircleMobEffect;
import net.clozynoii.invincibleconquest.potion.BulletSlamMobEffect;
import net.clozynoii.invincibleconquest.potion.BleedingMobEffect;
import net.clozynoii.invincibleconquest.potion.BeastSlicesMobEffect;
import net.clozynoii.invincibleconquest.potion.BeastMobTimersMobEffect;
import net.clozynoii.invincibleconquest.potion.BarrierEffectMobEffect;
import net.clozynoii.invincibleconquest.potion.BackwardsTumbleMobEffect;
import net.clozynoii.invincibleconquest.potion.AtomControlEffectMobEffect;
import net.clozynoii.invincibleconquest.potion.AtomAwakeningEffectMobEffect;
import net.clozynoii.invincibleconquest.potion.AnissaComboMobEffect;
import net.clozynoii.invincibleconquest.potion.AirDensityEffectMobEffect;
import net.clozynoii.invincibleconquest.potion.ActiveBeamAtomMobEffect;
import net.clozynoii.invincibleconquest.potion.ActiveAirSlamClawMobEffect;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

@EventBusSubscriber
public class InvincibleConquestModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, InvincibleConquestMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> STUN = REGISTRY.register("stun", () -> new StunMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> NO_FALL = REGISTRY.register("no_fall", () -> new NoFallMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SMOKE_CIRCLE = REGISTRY.register("smoke_circle", () -> new SmokeCircleMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DESTRUCTIVE_FLIGHT = REGISTRY.register("destructive_flight", () -> new DestructiveFlightMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CRATER = REGISTRY.register("crater", () -> new CraterMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> GLASS_BREAK = REGISTRY.register("glass_break", () -> new GlassBreakMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FALLING_BLOCKS = REGISTRY.register("falling_blocks", () -> new FallingBlocksMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DAMAGE_DESTRUCTION = REGISTRY.register("damage_destruction", () -> new DamageDestructionMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LASER_DESTRUCTION = REGISTRY.register("laser_destruction", () -> new LaserDestructionMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> IMPACT_FRAME_EFFECT = REGISTRY.register("impact_frame_effect", () -> new ImpactFrameEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LASER_KNOCKBACK = REGISTRY.register("laser_knockback", () -> new LaserKnockbackMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BEAST_SLICES = REGISTRY.register("beast_slices", () -> new BeastSlicesMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DRAG = REGISTRY.register("drag", () -> new DragMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BEAST_MOB_TIMERS = REGISTRY.register("beast_mob_timers", () -> new BeastMobTimersMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ACTIVE_AIR_SLAM_CLAW = REGISTRY.register("active_air_slam_claw", () -> new ActiveAirSlamClawMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CLOUD_CIRCLE = REGISTRY.register("cloud_circle", () -> new CloudCircleMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SLICING_CIRCLE = REGISTRY.register("slicing_circle", () -> new SlicingCircleMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TITAN_LEAP_EFFECT = REGISTRY.register("titan_leap_effect", () -> new TitanLeapEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BULLET_SLAM = REGISTRY.register("bullet_slam", () -> new BulletSlamMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> INSTANT_CRATOR = REGISTRY.register("instant_crator", () -> new InstantCratorMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ROBOT_BALL_CONTROL = REGISTRY.register("robot_ball_control", () -> new RobotBallControlMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SMOKING = REGISTRY.register("smoking", () -> new SmokingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BACKWARDS_TUMBLE = REGISTRY.register("backwards_tumble", () -> new BackwardsTumbleMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> WEB_ACTIVE = REGISTRY.register("web_active", () -> new WebActiveMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ATOM_CONTROL_EFFECT = REGISTRY.register("atom_control_effect", () -> new AtomControlEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> POST_ATOM_CONTROL = REGISTRY.register("post_atom_control", () -> new PostAtomControlMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ACTIVE_BEAM_ATOM = REGISTRY.register("active_beam_atom", () -> new ActiveBeamAtomMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> AIR_DENSITY_EFFECT = REGISTRY.register("air_density_effect", () -> new AirDensityEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ANISSA_COMBO = REGISTRY.register("anissa_combo", () -> new AnissaComboMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> CONSTANT_EFFECT_PUNCH = REGISTRY.register("constant_effect_punch", () -> new ConstantEffectPunchMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PAUSE_DIALOGUE = REGISTRY.register("pause_dialogue", () -> new PauseDialogueMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BARRIER_EFFECT = REGISTRY.register("barrier_effect", () -> new BarrierEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> COUNTER_EFFECT = REGISTRY.register("counter_effect", () -> new CounterEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ATOM_AWAKENING_EFFECT = REGISTRY.register("atom_awakening_effect", () -> new AtomAwakeningEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MACHINE_GUN_EFFECTS = REGISTRY.register("machine_gun_effects", () -> new MachineGunEffectsMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TECH_JACKET_BLADE_EFFECT = REGISTRY.register("tech_jacket_blade_effect", () -> new TechJacketBladeEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> TECH_JACKET_FOLLOW_UP_EFFECT = REGISTRY.register("tech_jacket_follow_up_effect", () -> new TechJacketFollowUpEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> STRONG_FLYING_STUNNED = REGISTRY.register("strong_flying_stunned", () -> new StrongFlyingStunnedMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(LASER_DESTRUCTION)) {
			LaserDestructionEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(CLOUD_CIRCLE)) {
			CloudCircleEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(SLICING_CIRCLE)) {
			CloudCircleEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(TITAN_LEAP_EFFECT)) {
			TitanLeapEffectEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(ATOM_CONTROL_EFFECT)) {
			AtomControlEffectEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(ACTIVE_BEAM_ATOM)) {
			ActiveBeamAtomEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(BARRIER_EFFECT)) {
			BarrierEffectEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		} else if (effectInstance.getEffect().is(ATOM_AWAKENING_EFFECT)) {
			AtomAwakeningEffectEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(MACHINE_GUN_EFFECTS)) {
			MachineGunEffectsEffectExpiresProcedure.execute(entity.level(), entity);
		}
	}
}
