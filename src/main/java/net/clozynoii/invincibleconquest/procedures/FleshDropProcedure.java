package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModItems;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FleshDropProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		execute(null, world, x, y, z, damagesource, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity) {
		if (damagesource == null || entity == null)
			return;
		ItemStack flesh = ItemStack.EMPTY;
		if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.CANNIBALISM)) {
			if (damagesource.is(DamageTypes.PLAYER_ATTACK)) {
				flesh = new ItemStack(InvincibleConquestModItems.FLESH.get()).copy();
				if (entity instanceof Player) {
					if (Math.random() < 0.1) {
						if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
							flesh.set(DataComponents.CUSTOM_NAME, Component.literal(("Flesh (" + new java.text.DecimalFormat("#").format(1 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerLevel / 5) + ")")));
						} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Viltrumite")) {
							flesh.set(DataComponents.CUSTOM_NAME, Component.literal(("Flesh (" + new java.text.DecimalFormat("#").format(5 + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerLevel / 5) + ")")));
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, flesh);
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				} else if (entity instanceof Villager) {
					if (Math.random() < 0.1) {
						flesh.set(DataComponents.CUSTOM_NAME, Component.literal((entity.getDisplayName().getString() + "'s Flesh (" + new java.text.DecimalFormat("#").format(1) + ")")));
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, flesh);
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
