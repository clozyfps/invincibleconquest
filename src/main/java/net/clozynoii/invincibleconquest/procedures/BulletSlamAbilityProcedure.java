package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModGameRules;

public class BulletSlamAbilityProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean gate = false;
		String ability = "";
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		double cooldown = 0;
		double reduction = 0;
		double targets = 0;
		double outputModifier = 0;
		double stamindaReduction = 0;
		double staminacost = 0;
		stamindaReduction = 20 * ((((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStamina + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100)
				* (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.STM_STAMINA_DRAIN))) / 100);
		staminacost = 20 - stamindaReduction;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina >= staminacost) {
			gate = false;
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.PlayerCurrentStamina = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerCurrentStamina - staminacost;
				_vars.syncPlayerVariables(entity);
			}
			reduction = 60 * ((((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFocus + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100)
					* (world.getLevelData().getGameRules().getInt(InvincibleConquestModGameRules.FOC_COOLDOWN_REDUCTION))) / 100);
			outputModifier = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput / 100;
			cooldown = 60 - reduction;
			targets = 0;
			magnitude = 0;
			ability = "Bullet Slam";
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
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.BULLET_SLAM, 40, 0, false, false));
			magnitude = Math.sqrt(entity.getLookAngle().x * entity.getLookAngle().x + entity.getLookAngle().y * entity.getLookAngle().y + entity.getLookAngle().z * entity.getLookAngle().z);
			vecX = entity.getLookAngle().x / magnitude;
			vecY = entity.getLookAngle().y / magnitude;
			vecZ = entity.getLookAngle().z / magnitude;
			vecX = vecX * 25;
			vecY = vecY;
			vecZ = vecZ * 25;
			entity.push(0, (-25), 0);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Not enough Stamina!"), false);
		}
	}
}
