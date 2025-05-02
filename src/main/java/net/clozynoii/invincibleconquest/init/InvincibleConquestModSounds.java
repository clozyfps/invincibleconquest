
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.clozynoii.invincibleconquest.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.InvincibleConquestMod;

public class InvincibleConquestModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, InvincibleConquestMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOOD_EXPLOSION = REGISTRY.register("blood_explosion", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("invincible_conquest", "blood_explosion")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BASIC_HIT = REGISTRY.register("basic_hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("invincible_conquest", "basic_hit")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WHOOSH = REGISTRY.register("whoosh", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("invincible_conquest", "whoosh")));
	public static final DeferredHolder<SoundEvent, SoundEvent> STRONGWOOSH = REGISTRY.register("strongwoosh", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("invincible_conquest", "strongwoosh")));
	public static final DeferredHolder<SoundEvent, SoundEvent> THEHAMMER = REGISTRY.register("thehammer", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("invincible_conquest", "thehammer")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HEARTBEAT = REGISTRY.register("heartbeat", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("invincible_conquest", "heartbeat")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EXPLODE = REGISTRY.register("explode", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("invincible_conquest", "explode")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BEAM23 = REGISTRY.register("beam23", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("invincible_conquest", "beam23")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BEAM2 = REGISTRY.register("beam2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("invincible_conquest", "beam2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MACHINEGUN = REGISTRY.register("machinegun", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("invincible_conquest", "machinegun")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CHARGEUP = REGISTRY.register("chargeup", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("invincible_conquest", "chargeup")));
}
