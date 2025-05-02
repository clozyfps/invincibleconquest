package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.configuration.InvincibleConfigConfiguration;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

public class DetonateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean gate = false;
		String ability = "";
		double cooldown = 0;
		double magnitude = 0;
		double reduction = 0;
		double targets = 0;
		double outputModifier = 0;
		double stamindaReduction = 0;
		double staminacost = 0;
		stamindaReduction = 50
				* ((((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100) * (double) InvincibleConfigConfiguration.STMDRAIN.get()) / 100);
		staminacost = 50 - stamindaReduction;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina >= staminacost) {
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.PlayerCurrentStamina = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina - staminacost;
				_vars.syncPlayerVariables(entity);
			}
			gate = false;
			reduction = 60
					* ((((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100) * (double) InvincibleConfigConfiguration.FOCCDREDUCE.get())
							/ 100);
			outputModifier = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput / 100;
			cooldown = 500 - reduction;
			targets = 0;
			magnitude = 0;
			ability = "Detonate";
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
				_vars.InputDelay = 10;
				_vars.syncPlayerVariables(entity);
			}
			entity.getPersistentData().putDouble("rexSPLODE", 20);
			InvincibleConquestMod.queueServerWork(20, () -> {
				ExplodeSelfProcedure.execute(world, x, y, z, entity);
				entity.getPersistentData().putDouble("rexSPLODE", 0);
			});
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.PLAYERS, (float) 0.8, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.spawn")), SoundSource.PLAYERS, (float) 0.8, 1, false);
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Not enough Stamina!"), false);
		}
	}
}
