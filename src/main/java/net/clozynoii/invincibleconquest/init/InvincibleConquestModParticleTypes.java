
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.clozynoii.invincibleconquest.InvincibleConquestMod;

public class InvincibleConquestModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, InvincibleConquestMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BURST_CIRCLE_SMALL = REGISTRY.register("burst_circle_small", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LARGE_SMOKE = REGISTRY.register("large_smoke", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOOD_DRIP = REGISTRY.register("blood_drip", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOOD_LAND = REGISTRY.register("blood_land", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SANDY_SMOKE = REGISTRY.register("sandy_smoke", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STEAM_SMOKE = REGISTRY.register("steam_smoke", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DIRTY_SMOKE = REGISTRY.register("dirty_smoke", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GREEN_BLOOD_DRIP = REGISTRY.register("green_blood_drip", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GREEN_BLOOD_LAND = REGISTRY.register("green_blood_land", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> RED_SAND_SMOKE = REGISTRY.register("red_sand_smoke", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> EXPLOSION = REGISTRY.register("explosion", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LARGE_EXPLOSION = REGISTRY.register("large_explosion", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CIRCLE_SMALL = REGISTRY.register("circle_small", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CIRCLE_MEDIUM = REGISTRY.register("circle_medium", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CIRCLE_LARGE = REGISTRY.register("circle_large", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CIRCLE_BARRAGE = REGISTRY.register("circle_barrage", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BURST_CIRCLE_LARGE = REGISTRY.register("burst_circle_large", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ELECTRICITY = REGISTRY.register("electricity", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> RED_ELECTRICTY = REGISTRY.register("red_electricty", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PINK_BURST_CIRCLE = REGISTRY.register("pink_burst_circle", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PINK_SMOKE = REGISTRY.register("pink_smoke", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PINK_ELECTRICITY = REGISTRY.register("pink_electricity", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SINGULAR_PINK_CIRCLE = REGISTRY.register("singular_pink_circle", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PRESSURE_PARTICLE = REGISTRY.register("pressure_particle", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ELECTRICITY_SMALL = REGISTRY.register("electricity_small", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLUE_BURST = REGISTRY.register("blue_burst", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SMALL_EXPLOSION = REGISTRY.register("small_explosion", () -> new SimpleParticleType(false));
}
