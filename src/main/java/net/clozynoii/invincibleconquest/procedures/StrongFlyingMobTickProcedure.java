package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.entity.AnissaEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class StrongFlyingMobTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double vecZ = 0;
		double vecY = 0;
		double vecX = 0;
		double magnitude = 0;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:strongflying")))) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(InvincibleConquestModMobEffects.CONSTANT_EFFECT_PUNCH) || entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(InvincibleConquestModMobEffects.ANISSA_COMBO)
					|| entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(InvincibleConquestModMobEffects.DRAG) || entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(InvincibleConquestModMobEffects.STRONG_FLYING_STUNNED))) {
				if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entityiterator)) {
								if (entity instanceof AnissaEntity) {
									if (entity instanceof AnissaEntity) {
										((AnissaEntity) entity).setAnimation("fly");
									}
								}
							}
						}
					}
					entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) / 1),
							(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY()) / 1), (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) / 1)));
					entity.getPersistentData().putDouble("strongflyingtimer", (entity.getPersistentData().getDouble("strongflyingtimer") + 1));
					if (entity.getPersistentData().getDouble("strongflyingtimer") >= 30) {
						entity.getPersistentData().putDouble("strongflyingtimer", 0);
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get()), x, (y + 1), z, 1, 0.1, 0.1, 0.1, 0);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.sonic_boom")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.sonic_boom")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) / 1),
								(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY()) / 1), (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) / 1)));
					}
				}
			}
		}
	}
}
