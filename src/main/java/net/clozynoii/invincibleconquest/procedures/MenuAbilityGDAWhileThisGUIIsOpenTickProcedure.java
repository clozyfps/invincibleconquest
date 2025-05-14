package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class MenuAbilityGDAWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move1Name = "Soldiers";
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move2Name = "Stealth Soldiers";
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move3Name = "Heroes";
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move4Name = "Fighter Jet";
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move5Name = "The Hammer";
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move6Name = "Teleport";
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move1Cost = 10;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move2Cost = 15;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move3Cost = 20;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move4Cost = 25;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move5Cost = 30;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move6Cost = 35;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.ReturnMove1 = 1;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.ReturnMove2 = 2;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.ReturnMove3 = 3;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.ReturnMove4 = 4;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.ReturnMove5 = 5;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.ReturnMove6 = 6;
			_vars.syncPlayerVariables(entity);
		}
	}
}
