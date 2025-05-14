package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.entity.player.AnvilRepairEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FleshRenameProcedure {
	@SubscribeEvent
	public static void onEventTriggered(AnvilRepairEvent event) {
		execute(event, event.getEntity(), event.getLeft(), event.getOutput(), event.getRight());
	}

	public static void execute(Entity entity, ItemStack leftItem, ItemStack output, ItemStack rightItem) {
		execute(null, entity, leftItem, output, rightItem);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack leftItem, ItemStack output, ItemStack rightItem) {
		if (entity == null)
			return;
		if (output.getItem() == InvincibleConquestModItems.FLESH.get() || rightItem.getItem() == InvincibleConquestModItems.FLESH.get() || leftItem.getItem() == InvincibleConquestModItems.FLESH.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(InvincibleConquestModItems.FLESH.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 100, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
