package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class TechJacketArmorHelmetTickEventProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getDamageValue() > 10) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7bRepairing Armor"), true);
			entity.getPersistentData().putDouble("techRepair", (entity.getPersistentData().getDouble("techRepair") + 1));
			if (entity.getPersistentData().getDouble("techRepair") >= 10) {
				entity.getPersistentData().putDouble("techRepair", 0);
				itemstack.setDamageValue((int) (itemstack.getDamageValue() - 10));
			}
		}
	}
}
