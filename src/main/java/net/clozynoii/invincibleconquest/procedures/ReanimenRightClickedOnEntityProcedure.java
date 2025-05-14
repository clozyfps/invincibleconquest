package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModItems;
import net.clozynoii.invincibleconquest.entity.ReanimenEntity;

public class ReanimenRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.ROTTEN_FLESH
				|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == InvincibleConquestModItems.FLESH.get()) {
			(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7aReanimen Power Level Increased From " + (entity instanceof ReanimenEntity _datEntI ? _datEntI.getEntityData().get(ReanimenEntity.DATA_Strength) : 0) + " > "
						+ ((entity instanceof ReanimenEntity _datEntI ? _datEntI.getEntityData().get(ReanimenEntity.DATA_Strength) : 0) + 1))), false);
			if (entity instanceof ReanimenEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ReanimenEntity.DATA_Strength, (int) ((entity instanceof ReanimenEntity _datEntI ? _datEntI.getEntityData().get(ReanimenEntity.DATA_Strength) : 0) + 1));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, x, (y + 1), z, 5, 0.1, 0.1, 0.1, 0.3);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, (y + 1), z, 15, 0.1, 0.1, 0.1, 0.3);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 99999, (int) (entity instanceof ReanimenEntity _datEntI ? _datEntI.getEntityData().get(ReanimenEntity.DATA_Strength) : 0), false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 99999, (int) ((entity instanceof ReanimenEntity _datEntI ? _datEntI.getEntityData().get(ReanimenEntity.DATA_Strength) : 0) / 15), false, false));
		} else {
			GDASoldierRightClickedOnEntityProcedure.execute(entity, sourceentity);
		}
	}
}
