package net.clozynoii.invincibleconquest.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModEntities;

import java.util.HashMap;
import java.util.ArrayList;

public class PurchaseTheHammerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Balance >= entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cost) {
			if (new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:Power") ? ((EditBox) guistate.get("text:Power")).getValue() : "") == 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = InvincibleConquestModEntities.HAMMER_SPAWNER.get().spawn(_level, BlockPos.containing(new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:XValue") ? ((EditBox) guistate.get("text:XValue")).getValue() : ""), new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:YValue") ? ((EditBox) guistate.get("text:YValue")).getValue() : ""), new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:ZValue") ? ((EditBox) guistate.get("text:ZValue")).getValue() : "")), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
			} else if (new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:Power") ? ((EditBox) guistate.get("text:Power")).getValue() : "") == 2) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = InvincibleConquestModEntities.HAMMER_SPAWNER_2.get().spawn(_level, BlockPos.containing(new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:XValue") ? ((EditBox) guistate.get("text:XValue")).getValue() : ""), new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:YValue") ? ((EditBox) guistate.get("text:YValue")).getValue() : ""), new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:ZValue") ? ((EditBox) guistate.get("text:ZValue")).getValue() : "")), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
			} else if (new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:Power") ? ((EditBox) guistate.get("text:Power")).getValue() : "") == 3) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = InvincibleConquestModEntities.HAMMER_SPAWNER_3.get().spawn(_level, BlockPos.containing(new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:XValue") ? ((EditBox) guistate.get("text:XValue")).getValue() : ""), new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:YValue") ? ((EditBox) guistate.get("text:YValue")).getValue() : ""), new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:ZValue") ? ((EditBox) guistate.get("text:ZValue")).getValue() : "")), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.Balance = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Balance - entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cost;
				_vars.syncPlayerVariables(entity);
			}
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals("Director")
						|| (entityiterator.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerFactionRank).equals("Deputy Director")) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " Spent \u00A7a$" + new java.text.DecimalFormat("#").format(entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cost))), false);
				}
			}
			{
				InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
				_vars.Cost = 0;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Balance < entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).Cost) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, (float) 0.1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, (float) 0.1, false);
				}
			}
		}
	}
}
