package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

public class ReturnNameTextProcedure {
	public static String execute() {
		if (!((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null) == null)) {
			return "Name: " + ((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null).getDisplayName().getString());
		}
		return "Name:";
	}
}
