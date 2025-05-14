package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ReputationTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation < 50) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Global Defense Agency")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "Soldier";
					_vars.syncPlayerVariables(entity);
				}
			} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Viltrum Empire")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "Soldier";
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation >= 50 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation < 100) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Global Defense Agency")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "Agent";
					_vars.syncPlayerVariables(entity);
				}
			} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Viltrum Empire")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "Warrior";
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation >= 100 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation < 250) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Global Defense Agency")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "Specialist";
					_vars.syncPlayerVariables(entity);
				}
			} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Viltrum Empire")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "Enforcer";
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation >= 250 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation < 400) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Global Defense Agency")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "Commander";
					_vars.syncPlayerVariables(entity);
				}
			} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Viltrum Empire")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "Commander";
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation >= 400 && entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation < 500) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Global Defense Agency")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "Deputy Director";
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerAbility = "Human";
					_vars.syncPlayerVariables(entity);
				}
			} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Viltrum Empire")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "High Commander";
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerReputation >= 500) {
			if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Global Defense Agency")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "Director";
					_vars.syncPlayerVariables(entity);
				}
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerAbility = "Human";
					_vars.syncPlayerVariables(entity);
				}
			} else if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction).equals("Viltrum Empire")) {
				{
					InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
					_vars.PlayerFactionRank = "Grand Regent";
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
