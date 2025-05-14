package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModParticleTypes;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModGameRules;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModBlocks;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModItems;

import java.util.List;
import java.util.Comparator;

public class DestructiveFlightBreakProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null) return;

        double outputModifier = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerOutput / 100;

        if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_DESTRUCTION)) {
            int horizontalRadiusSquare = Math.max(2, (int) ((2 + (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength / 180.0)) * outputModifier));
            int verticalRadiusSquare = horizontalRadiusSquare;

            for (int i = -verticalRadiusSquare; i <= verticalRadiusSquare; i++) {
                for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
                    for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
                        BlockPos pos = entity.blockPosition().offset(xi, i, zi);

                        if (!world.getBlockState(pos).is(BlockTags.create(ResourceLocation.parse("invincible_conquest:unbreakable")))) {
                            world.levelEvent(2001, pos, Block.getId(world.getBlockState(pos)));
                        }
                    }
                }
            }
        }

        int horizontalRadiusSphere = Math.max(2, (int) ((4 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 60.0)) * outputModifier));
        int verticalRadiusSphere = horizontalRadiusSphere;

        for (int i = -verticalRadiusSphere; i <= verticalRadiusSphere; i++) {
            for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
                for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
                    double distSq = (xi * xi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere)
                            + (i * i) / (double)(verticalRadiusSphere * verticalRadiusSphere)
                            + (zi * zi) / (double)(horizontalRadiusSphere * horizontalRadiusSphere);

                    if (distSq <= 1.0) {
                        BlockPos pos = entity.blockPosition().offset(xi, i, zi);
                        Block block = world.getBlockState(pos).getBlock();

                        if (Math.random() > 0.75) {
                            if (block == Blocks.DIRT) {
                                world.addParticle(InvincibleConquestModParticleTypes.DIRTY_SMOKE.get(), pos.getX(), pos.getY(), pos.getZ(), 0, 0.05, 0);
                            } else if (block == Blocks.SAND) {
                                world.addParticle(InvincibleConquestModParticleTypes.SANDY_SMOKE.get(), pos.getX(), pos.getY(), pos.getZ(), 0, 0.05, 0);
                            } else if (block == Blocks.WATER) {
                                world.addParticle(InvincibleConquestModParticleTypes.STEAM_SMOKE.get(), pos.getX(), pos.getY(), pos.getZ(), 0, 0.05, 0);
                            } else if (block == Blocks.LAVA) {
                                world.addParticle(InvincibleConquestModParticleTypes.LARGE_EXPLOSION.get(), pos.getX(), pos.getY(), pos.getZ(), 0, 0.05, 0);
                            } else if (block == Blocks.RED_SAND) {
                                world.addParticle(InvincibleConquestModParticleTypes.RED_SAND_SMOKE.get(), pos.getX(), pos.getY(), pos.getZ(), 0, 0.05, 0);
                            } else if (block == InvincibleConquestModBlocks.MOON_SAND.get()) {
                                world.addParticle(InvincibleConquestModParticleTypes.STEAM_SMOKE.get(), pos.getX(), pos.getY(), pos.getZ(), 0, 0.05, 0);
                            }
                        }

                        if (!world.getBlockState(pos).is(BlockTags.create(ResourceLocation.parse("invincible_conquest:unbreakable")))) {
                            if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_BLOCK_DROP)) {
                                if (world instanceof ServerLevel _level) {
                                    ItemEntity drop = new ItemEntity(_level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(world.getBlockState(pos).getBlock()));
                                    drop.setPickUpDelay(10);
                                    _level.addFreshEntity(drop);
                                }
                            }

                            if (world.getLevelData().getGameRules().getBoolean(InvincibleConquestModGameRules.INVINCIBLE_ABILITY_DESTRUCTION)) {
                                world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                            }

                            if (!InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover.isEmpty()) {
                                String currentFaction = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFaction;
                                String invadingFaction = InvincibleConquestModVariables.MapVariables.get(world).InvadingFaction;
                                if (currentFaction.equals(invadingFaction)) {
                                    if (!world.getBlockState(pos).is(BlockTags.create(ResourceLocation.parse("invincible_conquest:natural")))) {
                                        String takeover = InvincibleConquestModVariables.MapVariables.get(world).PlanetTakeover;
                                        ResourceKey<Level> dim = entity.level().dimension();

                                        boolean match = (takeover.equals("Earth") && dim == Level.OVERWORLD)
                                                || (takeover.equals("Moon") && dim.equals(ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:moon_world"))))
                                                || (takeover.equals("Mars") && dim.equals(ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:mars_world"))))
                                                || (takeover.equals("Viltrum") && dim.equals(ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:viltrum_world"))))
                                                || (takeover.equals("Talescria") && dim.equals(ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("invincible_conquest:talescria_world"))));

                                        if (match) {
                                            InvincibleConquestModVariables.MapVariables.get(world).HOSTILEBlocksBroken++;
                                            InvincibleConquestModVariables.MapVariables.get(world).syncData(world);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (entity.getPersistentData().getDouble("flyParticle") > 0) {
    entity.getPersistentData().putDouble("flyParticle", entity.getPersistentData().getDouble("flyParticle") - 1);
} else if (entity.getPersistentData().getDouble("flyParticle") == 0) {
    if (world instanceof ServerLevel _level) {
        String ability = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility;

        if ("Atom".equals(ability)) {
            _level.sendParticles(InvincibleConquestModParticleTypes.PINK_BURST_CIRCLE.get(), x, y, z, 1, 0.1, 0.1, 0.1, 0);
        } else if ("Tech Jacket".equals(ability)) {
            _level.sendParticles(InvincibleConquestModParticleTypes.BLUE_BURST.get(), x, y, z, 1, 0.1, 0.1, 0.1, 0);
            _level.sendParticles(InvincibleConquestModParticleTypes.LARGE_EXPLOSION.get(), x, y, z, 1, 0.1, 0.1, 0.1, 0);
        } else {
            _level.sendParticles(InvincibleConquestModParticleTypes.BURST_CIRCLE_LARGE.get(), x, y, z, 1, 0.1, 0.1, 0.1, 0);
        }
    }
    entity.getPersistentData().putDouble("flyParticle", 20);
}

final Vec3 center = new Vec3(x, y, z);
List<Entity> nearbyEntities = world.getEntitiesOfClass(Entity.class, new AABB(center, center).inflate(1.5), e -> true)
    .stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(center))).toList();

for (Entity target : nearbyEntities) {
    if (target != entity && !target.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable")))) {
        target.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), entity),
                (float)(3 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength
                + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100.0) * outputModifier));

        if (target instanceof LivingEntity _living && !_living.level().isClientSide()) {
            _living.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.BLEEDING, 20, 0));
        }
    }
}

double radius = (4 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength
        + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 25.0) * outputModifier) / 2d;

List<Entity> nearbyEntitiesSecondary = world.getEntitiesOfClass(Entity.class, new AABB(center, center).inflate(radius), e -> true)
    .stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(center))).toList();

for (Entity target : nearbyEntitiesSecondary) {
    if (target != entity && !target.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("invincible_conquest:non_targetable")))) {
        target.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), entity),
                (float)(1 + ((entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerStrength
                + entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).AgeBoost) / 100.0) * outputModifier));
    }
}
    }
}
