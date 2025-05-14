package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

public class ReturnHeartsProcedure {
	public static String execute() {
		if (!((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null) == null)) {
			return "Hearts: " + (new java.text.DecimalFormat("#")
					.format(((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) / 2));
		}
		return "Name:";
	}
}
