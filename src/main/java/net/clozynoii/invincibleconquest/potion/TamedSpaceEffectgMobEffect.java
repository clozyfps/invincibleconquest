
package net.clozynoii.invincibleconquest.potion;

import net.neoforged.neoforge.common.EffectCure;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

import java.util.Set;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TamedSpaceEffectgMobEffect extends MobEffect {
	public TamedSpaceEffectgMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, InvincibleConquestModMobEffects.TAMED_SPACE_EFFECTG.get());
	}
}
