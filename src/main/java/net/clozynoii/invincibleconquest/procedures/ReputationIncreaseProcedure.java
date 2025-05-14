package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ReputationIncreaseProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		String previousrank = "";
		if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Viltrum Empire")) {
			previousrank = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank;
			if (!world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.SERVER_REP_LEVELING)) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerReputation = 1 + (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 20;
					_vars.syncPlayerVariables(sourceentity);
				}
			} else {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerReputation = 0.1 + (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 20;
					_vars.syncPlayerVariables(sourceentity);
				}
			}
			if (!(sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals(previousrank)) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A7a\u00A7lRank Promotion! You Are Now " + sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank + "!")), false);
			}
		}
		if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Global Defense Agency")) {
			if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:viltrumite")))) {
				previousrank = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank;
				if (!world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.SERVER_REP_LEVELING)) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.PlayerReputation = 5 + (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 20;
						_vars.syncPlayerVariables(sourceentity);
					}
				} else {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.PlayerReputation = 1 + (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 20;
						_vars.syncPlayerVariables(sourceentity);
					}
				}
				if (!(sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals(previousrank)) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7a\u00A7lRank Promotion! You Are Now " + sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank + "!")), false);
				}
			} else {
				previousrank = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank;
				if (!world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.SERVER_REP_LEVELING)) {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.PlayerReputation = 1 + (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 20;
						_vars.syncPlayerVariables(sourceentity);
					}
				} else {
					{
						InvincibleConquestModVariables.PlayerVariables _vars = sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
						_vars.PlayerReputation = 0.1 + (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 20;
						_vars.syncPlayerVariables(sourceentity);
					}
				}
				if (!(sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals(previousrank)) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7a\u00A7lRank Promotion! You Are Now " + sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank + "!")), false);
				}
			}
		}
	}
}
