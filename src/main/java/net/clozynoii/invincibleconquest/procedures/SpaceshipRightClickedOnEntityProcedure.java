package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.entity.SpaceshipEntity;

public class SpaceshipRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.COAL) {
			(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (entity instanceof SpaceshipEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SpaceshipEntity.DATA_Fuel, (int) ((entity instanceof SpaceshipEntity _datEntI ? _datEntI.getEntityData().get(SpaceshipEntity.DATA_Fuel) : 0) + 1));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, x, y, z, 6, 3, 3, 3, 0.2);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.extinguish_fire")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.extinguish_fire")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7aAdded Fuel: " + (entity instanceof SpaceshipEntity _datEntI ? _datEntI.getEntityData().get(SpaceshipEntity.DATA_Fuel) : 0))), false);
		} else if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.COAL)) {
			if (sourceentity.isPassenger()) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7a--STATUS--"), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7a\u00A7lSHIP HEALTH: \u00A7c" + (new java.text.DecimalFormat("#").format(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)))), false);
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7a\u00A7lSHIP HEALTH: \u00A7r" + (new java.text.DecimalFormat("#").format(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)))), false);
				}
				if ((entity instanceof SpaceshipEntity _datEntI ? _datEntI.getEntityData().get(SpaceshipEntity.DATA_Fuel) : 0) < 10) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7a\u00A7lSHIP FUEL (CRITICAL): \u00A7c" + (entity instanceof SpaceshipEntity _datEntI ? _datEntI.getEntityData().get(SpaceshipEntity.DATA_Fuel) : 0))), false);
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A7a\u00A7lSHIP FUEL: \u00A7r" + (entity instanceof SpaceshipEntity _datEntI ? _datEntI.getEntityData().get(SpaceshipEntity.DATA_Fuel) : 0))), false);
				}
			}
		}
	}
}
