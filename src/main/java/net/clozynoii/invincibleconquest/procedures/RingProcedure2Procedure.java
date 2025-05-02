package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class RingProcedure2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double b = 0;
		double Repeating = 0;
		entity.getPersistentData().putDouble("deg", (entity.getYRot() - 90));
		entity.getPersistentData().putDouble("r", 1);
		b = 4;
		Repeating = 0;
		for (int index0 = 0; index0 < 5; index0++) {
			for (int index1 = 0; index1 < 40; index1++) {
				if (entity.getPersistentData().getDouble("r") == 2) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
										new Vec3((x - entity.getPersistentData().getDouble("r") * Math.sin(Math.toRadians(entity.getPersistentData().getDouble("deg")))), (y - 4.5 + b),
												(z + entity.getPersistentData().getDouble("r") * Math.cos(Math.toRadians(entity.getPersistentData().getDouble("deg"))))),
										Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "particle dust{color:[0.94,0.58,0.99],scale:2} ~ ~ ~ 0.1 0.1 0.1 0 1");
					entity.getPersistentData().putDouble("deg", (entity.getPersistentData().getDouble("deg") + 9));
					Repeating = Repeating + 1;
					if (Repeating <= 20) {
						b = b + 0.2;
					} else {
						b = b - 0.2;
					}
				}
			}
			if (entity.getPersistentData().getDouble("r") == 2 || entity.getPersistentData().getDouble("r") == 4) {
				entity.getPersistentData().putDouble("deg", (entity.getYRot() - 81));
			} else {
				entity.getPersistentData().putDouble("deg", (entity.getYRot() - 90));
			}
			entity.getPersistentData().putDouble("r", (entity.getPersistentData().getDouble("r") + 1));
		}
	}
}
