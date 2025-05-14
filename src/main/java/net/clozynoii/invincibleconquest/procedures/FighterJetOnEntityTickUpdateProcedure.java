package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModEntities;
import net.clozynoii.invincibleconquest.entity.FighterJetEntity;

public class FighterJetOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			if ((entity instanceof FighterJetEntity _datEntI ? _datEntI.getEntityData().get(FighterJetEntity.DATA_XTarget) : 0) - entity.getX() <= 10
					&& (entity instanceof FighterJetEntity _datEntI ? _datEntI.getEntityData().get(FighterJetEntity.DATA_ZTarget) : 0) - entity.getZ() <= 10) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = InvincibleConquestModEntities.BOMB.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
				if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7a<GDA Jet> Bomb Succesfully Dropped."), false);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, y, z, 3, 0.1, 0.1, 0.1, 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, y, z, 3, 0.1, 0.1, 0.1, 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 2, 0.1, 0.1, 0.1, 0.3);
			entity.getPersistentData().putDouble("jetbursttimer", (entity.getPersistentData().getDouble("jetbursttimer") + 1));
			if (entity.getPersistentData().getDouble("jetbursttimer") >= 10) {
				entity.setDeltaMovement(new Vec3((((entity instanceof FighterJetEntity _datEntI ? _datEntI.getEntityData().get(FighterJetEntity.DATA_XTarget) : 0) - entity.getX()) / 3), (entity.getDeltaMovement().y()),
						(((entity instanceof FighterJetEntity _datEntI ? _datEntI.getEntityData().get(FighterJetEntity.DATA_ZTarget) : 0) - entity.getZ()) / 3)));
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get()), x, y, z, 1, 1, 1, 1, 0);
				entity.getPersistentData().putDouble("jetbursttimer", 0);
			}
		}
	}
}
