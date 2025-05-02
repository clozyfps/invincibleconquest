package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.entity.AtomShieldEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TamedDiesProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof AtomShieldEntity) {
			AtomShieldEntityDiesProcedure.execute(world, x, y, z, entity);
			if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
				if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.STUN, 20, 6, false, false));
			}
		}
	}
}
