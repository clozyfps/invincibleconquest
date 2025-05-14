package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class FleshItemInHandTickProcedure {
	public static void execute(ItemStack itemstack) {
		if (!(itemstack.getDisplayName().getString()).contains("(")) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("Flesh (1)"));
		}
	}
}
