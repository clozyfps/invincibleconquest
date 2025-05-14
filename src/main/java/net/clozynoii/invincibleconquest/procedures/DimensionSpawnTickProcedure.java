package net.clozynoii.invincibleconquest.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.entity.ViltrumiteMaleEntity;
import net.clozynoii.invincibleconquest.entity.ViltrumiteFemaleEntity;
import net.clozynoii.invincibleconquest.entity.SpaceshipEntity;
import net.clozynoii.invincibleconquest.entity.RognarrEntity;
import net.clozynoii.invincibleconquest.entity.MartianSpearmanEntity;
import net.clozynoii.invincibleconquest.entity.MartianEntity;
import net.clozynoii.invincibleconquest.entity.HeroEntity;
import net.clozynoii.invincibleconquest.entity.FlaxanPortalEntity;
import net.clozynoii.invincibleconquest.entity.FlaxanGunmanEntity;
import net.clozynoii.invincibleconquest.entity.FlaxanEntity;
import net.clozynoii.invincibleconquest.entity.DinosaurEntity;
import net.clozynoii.invincibleconquest.entity.DimensionalPortalEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DimensionSpawnTickProcedure {
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
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:flaxan_dimension"))) {
			if (!(entity instanceof Player || entity instanceof FlaxanEntity || entity instanceof FlaxanGunmanEntity || entity instanceof FlaxanPortalEntity || entity instanceof DimensionalPortalEntity
					|| entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable"))) || entity instanceof SpaceshipEntity)) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:mars_world"))) {
			if (!(entity instanceof Player || entity instanceof MartianEntity || entity instanceof MartianSpearmanEntity || entity instanceof FlaxanPortalEntity || entity instanceof DimensionalPortalEntity
					|| entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable"))) || entity instanceof SpaceshipEntity)) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:savage_world"))) {
			if (entity instanceof HeroEntity) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:pre_historic"))) {
			if (entity instanceof DinosaurEntity) {
				if ((world.getBlockState(BlockPos.containing(x, entity.getY() + 1, z))).getBlock() == Blocks.STONE) {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			}
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:savage_world"))) {
			if (entity instanceof RognarrEntity) {
				if ((world.getBlockState(BlockPos.containing(x, entity.getY() + 1, z))).getBlock() == Blocks.STONE) {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			}
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:mars_world"))) {
			if (entity instanceof MartianEntity || entity instanceof MartianSpearmanEntity) {
				if ((world.getBlockState(BlockPos.containing(x, entity.getY() + 1, z))).getBlock() == Blocks.STONE) {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			}
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:viltrum"))) {
				if (entity instanceof ViltrumiteFemaleEntity || entity instanceof ViltrumiteMaleEntity) {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CAVE_AIR) {
						if (!entity.level().isClientSide())
							entity.discard();
					}
				}
			}
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:apocalypse_dimension"))) {
			if (entity instanceof Zombie || entity instanceof Husk) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CAVE_AIR) {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			}
		}
	}
}
