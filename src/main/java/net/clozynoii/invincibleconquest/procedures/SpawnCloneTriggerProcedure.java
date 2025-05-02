package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.entity.PlayerCloneEntity;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModEntities;

public class SpawnCloneTriggerProcedure {
    /**
     * Spawns a PlayerCloneEntity at (x,y,z) and copies the nearest Player's skin onto it.
     */
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (!(world instanceof ServerLevel _server)) return;

        // Find the nearest player within 16 blocks of the spawn point
        Player player = _server.getNearestPlayer(x, y, z, 16, false);
        if (player == null) return;

        // Create and position the clone
        PlayerCloneEntity clone = InvincibleConquestModEntities.PLAYER_CLONE.get().create(_server);
        if (clone != null) {
            clone.moveTo(x, y, z, player.getYRot(), player.getXRot());
            // Copy the player's skin profile
            clone.setSkinProfile(player.getGameProfile());
            _server.addFreshEntity(clone);
        }
    }
}
