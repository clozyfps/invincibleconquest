package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.entity.HeroEntity;

public class HeroDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof HeroEntity _datEntI ? _datEntI.getEntityData().get(HeroEntity.DATA_skin) : 0) == 2) {
			return true;
		}
		return false;
	}
}
