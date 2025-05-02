package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

public class MenuAbilityTechJacketWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move1Name = "Energy Projection";
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move2Name = "Tech Blade";
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move3Name = "Machine Gun";
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move4Name = "Tech Cannon";
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move1Cost = 1;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move2Cost = 4;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move3Cost = 7;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Move4Cost = 15;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.ReturnMove1 = 1;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.ReturnMove2 = 1;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.ReturnMove3 = 1;
			_vars.syncPlayerVariables(entity);
		}
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.ReturnMove4 = 1;
			_vars.syncPlayerVariables(entity);
		}
	}
}
