package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import java.util.List;
import java.util.Comparator;

public class HeroSlot3UseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).HeroSlot3).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(500 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).HeroSlot3).equals(entityiterator.getDisplayName().getString())) {
						{
							Entity _ent = entityiterator;
							_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
						}
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
				}
			}
		}
	}
}
