package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModItems;

public class TechJacketHUDDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == InvincibleConquestModItems.TECH_JACKET_ARMOR_HELMET.get()) {
			return true;
		}
		return false;
	}
}
