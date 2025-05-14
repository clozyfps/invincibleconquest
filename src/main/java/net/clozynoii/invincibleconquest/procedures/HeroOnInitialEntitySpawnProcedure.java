package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModItems;
import net.clozynoii.invincibleconquest.entity.HeroEntity;

public class HeroOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String randomnamestring = "";
		double randomrankinteger = 0;
		double randomnameinteger = 0;
		double randomhelmet = 0;
		double randomchest = 0;
		double randomlegs = 0;
		double randomboots = 0;
		randomnameinteger = Mth.nextInt(RandomSource.create(), 1, 20);
		randomrankinteger = Mth.nextInt(RandomSource.create(), 1, 10);
		randomhelmet = Mth.nextInt(RandomSource.create(), 1, 10);
		randomchest = Mth.nextInt(RandomSource.create(), 1, 11);
		randomlegs = Mth.nextInt(RandomSource.create(), 1, 11);
		randomboots = Mth.nextInt(RandomSource.create(), 1, 11);
		if (randomhelmet == 1) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(InvincibleConquestModItems.REX_SPLODE_SUIT_HELMET.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(InvincibleConquestModItems.REX_SPLODE_SUIT_HELMET.get()));
				}
			}
		}
		if (randomhelmet == 2) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_DARK_HELMET.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_DARK_HELMET.get()));
				}
			}
		}
		if (randomhelmet == 3) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_SINISTER_HELMET.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_SINISTER_HELMET.get()));
				}
			}
		}
		if (randomhelmet == 4) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(InvincibleConquestModItems.SPACE_HELMET_HELMET.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(InvincibleConquestModItems.SPACE_HELMET_HELMET.get()));
				}
			}
		}
		if (randomhelmet == 5) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(InvincibleConquestModItems.OMNIVINCIBLE_SUIT_HELMET.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(InvincibleConquestModItems.OMNIVINCIBLE_SUIT_HELMET.get()));
				}
			}
		}
		if (randomhelmet == 6) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(InvincibleConquestModItems.ANGSTROM_OUTFIT_HELMET.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(InvincibleConquestModItems.ANGSTROM_OUTFIT_HELMET.get()));
				}
			}
		}
		if (randomhelmet == 7) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(InvincibleConquestModItems.TECH_JACKET_ARMOR_HELMET.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(InvincibleConquestModItems.TECH_JACKET_ARMOR_HELMET.get()));
				}
			}
		}
		if (randomhelmet == 8) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(Items.DIAMOND_HELMET));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
				}
			}
		}
		if (randomhelmet == 9) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(Blocks.CARVED_PUMPKIN));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.CARVED_PUMPKIN));
				}
			}
		}
		if (randomhelmet == 10) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(Blocks.JACK_O_LANTERN));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.JACK_O_LANTERN));
				}
			}
		}
		if (randomhelmet == 10) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_VEIL_HELMET.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_VEIL_HELMET.get()));
				}
			}
		}
		if (randomrankinteger == 1) {
			randomnamestring = "Greatest ";
		} else if (randomrankinteger == 2) {
			randomnamestring = "The ";
		} else if (randomrankinteger == 3) {
			randomnamestring = "Home ";
		} else if (randomrankinteger == 4) {
			randomnamestring = "Powerful ";
		} else if (randomrankinteger == 5) {
			randomnamestring = "Super ";
		} else if (randomrankinteger == 6) {
			randomnamestring = "The Almighty ";
		} else if (randomrankinteger == 7) {
			randomnamestring = "The Amazing ";
		} else if (randomrankinteger == 8) {
			randomnamestring = "Black ";
		} else if (randomrankinteger == 9) {
			randomnamestring = "Captain ";
		} else if (randomrankinteger == 10) {
			randomnamestring = "Mr ";
		}
		if (randomnameinteger == 1) {
			randomnamestring = randomnamestring + "Man";
		} else if (randomnameinteger == 2) {
			randomnamestring = randomnamestring + "Riot";
		} else if (randomnameinteger == 3) {
			randomnamestring = randomnamestring + "Weaver";
		} else if (randomnameinteger == 4) {
			randomnamestring = randomnamestring + "Lander";
		} else if (randomnameinteger == 5) {
			randomnamestring = randomnamestring + "America";
		} else if (randomnameinteger == 6) {
			randomnamestring = randomnamestring + "Bobblesmack";
		} else if (randomnameinteger == 7) {
			randomnamestring = randomnamestring + "Destroyer";
		} else if (randomnameinteger == 8) {
			randomnamestring = randomnamestring + "Hero";
		} else if (randomnameinteger == 8) {
			randomnamestring = randomnamestring + "Ninja";
		} else if (randomnameinteger == 9) {
			randomnamestring = randomnamestring + "Goat";
		} else if (randomnameinteger == 10) {
			randomnamestring = randomnamestring + "Rocker";
		} else if (randomnameinteger == 11) {
			randomnamestring = randomnamestring + "Packer";
		} else if (randomnameinteger == 12) {
			randomnamestring = randomnamestring + "Buster";
		} else if (randomnameinteger == 13) {
			randomnamestring = randomnamestring + "Magician";
		} else if (randomnameinteger == 14) {
			randomnamestring = randomnamestring + "Saviour";
		} else if (randomnameinteger == 15) {
			randomnamestring = randomnamestring + "Union";
		} else if (randomnameinteger == 16) {
			randomnamestring = randomnamestring + "Valor";
		} else if (randomnameinteger == 17) {
			randomnamestring = randomnamestring + "Warden";
		} else if (randomnameinteger == 18) {
			randomnamestring = randomnamestring + "Banner";
		} else if (randomnameinteger == 19) {
			randomnamestring = randomnamestring + "Justice";
		} else if (randomnameinteger == 20) {
			randomnamestring = randomnamestring + "Liberty";
		}
		if (randomchest == 1) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_CHESTPLATE.get()));
				}
			}
		} else if (randomchest == 2) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(InvincibleConquestModItems.REX_SPLODE_SUIT_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(InvincibleConquestModItems.REX_SPLODE_SUIT_CHESTPLATE.get()));
				}
			}
		} else if (randomchest == 3) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(InvincibleConquestModItems.TECH_JACKET_ARMOR_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(InvincibleConquestModItems.TECH_JACKET_ARMOR_CHESTPLATE.get()));
				}
			}
		} else if (randomchest == 4) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(InvincibleConquestModItems.DUPLI_KATE_SUIT_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(InvincibleConquestModItems.DUPLI_KATE_SUIT_CHESTPLATE.get()));
				}
			}
		} else if (randomchest == 5) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(InvincibleConquestModItems.MULTI_PAUL_SUIT_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(InvincibleConquestModItems.MULTI_PAUL_SUIT_CHESTPLATE.get()));
				}
			}
		} else if (randomchest == 6) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(InvincibleConquestModItems.ATOM_EVE_SUIT_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(InvincibleConquestModItems.ATOM_EVE_SUIT_CHESTPLATE.get()));
				}
			}
		} else if (randomchest == 7) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(InvincibleConquestModItems.OMNI_MAN_SUIT_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(InvincibleConquestModItems.OMNI_MAN_SUIT_CHESTPLATE.get()));
				}
			}
		} else if (randomchest == 8) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(InvincibleConquestModItems.MAULER_TWIN_SUIT_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(InvincibleConquestModItems.MAULER_TWIN_SUIT_CHESTPLATE.get()));
				}
			}
		} else if (randomchest == 9) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(InvincibleConquestModItems.FLAXAN_ARMOR_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(InvincibleConquestModItems.FLAXAN_ARMOR_CHESTPLATE.get()));
				}
			}
		} else if (randomchest == 10) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(InvincibleConquestModItems.ANGSTROM_OUTFIT_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(InvincibleConquestModItems.ANGSTROM_OUTFIT_CHESTPLATE.get()));
				}
			}
		} else if (randomchest == 11) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_VEIL_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_VEIL_CHESTPLATE.get()));
				}
			}
		}
		if (randomlegs == 1) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(InvincibleConquestModItems.OMNIVINCIBLE_SUIT_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(InvincibleConquestModItems.OMNIVINCIBLE_SUIT_LEGGINGS.get()));
				}
			}
		} else if (randomlegs == 2) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(InvincibleConquestModItems.TECH_JACKET_ARMOR_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(InvincibleConquestModItems.TECH_JACKET_ARMOR_LEGGINGS.get()));
				}
			}
		} else if (randomlegs == 3) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_DARK_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_DARK_LEGGINGS.get()));
				}
			}
		} else if (randomlegs == 4) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_SINISTER_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_SINISTER_LEGGINGS.get()));
				}
			}
		} else if (randomlegs == 5) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(InvincibleConquestModItems.MULTI_PAUL_SUIT_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(InvincibleConquestModItems.MULTI_PAUL_SUIT_LEGGINGS.get()));
				}
			}
		} else if (randomlegs == 6) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(InvincibleConquestModItems.REX_SPLODE_SUIT_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(InvincibleConquestModItems.REX_SPLODE_SUIT_LEGGINGS.get()));
				}
			}
		} else if (randomlegs == 7) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(InvincibleConquestModItems.ATOM_EVE_SUIT_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(InvincibleConquestModItems.ATOM_EVE_SUIT_LEGGINGS.get()));
				}
			}
		} else if (randomlegs == 8) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_BLUE_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_BLUE_LEGGINGS.get()));
				}
			}
		} else if (randomlegs == 9) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(Items.DIAMOND_LEGGINGS));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
				}
			}
		} else if (randomlegs == 10) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(Items.NETHERITE_LEGGINGS));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
				}
			}
		} else if (randomlegs == 11) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(Items.IRON_LEGGINGS));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
				}
			}
		}
		if (randomboots == 1) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(InvincibleConquestModItems.ATOM_EVE_SUIT_BOOTS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(InvincibleConquestModItems.ATOM_EVE_SUIT_BOOTS.get()));
				}
			}
		} else if (randomboots == 2) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_BOOTS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_BOOTS.get()));
				}
			}
		} else if (randomboots == 3) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(InvincibleConquestModItems.ANGSTROM_OUTFIT_BOOTS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(InvincibleConquestModItems.ANGSTROM_OUTFIT_BOOTS.get()));
				}
			}
		} else if (randomboots == 4) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_MOHAWK_BOOTS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(InvincibleConquestModItems.INVINCIBLE_SUIT_MOHAWK_BOOTS.get()));
				}
			}
		} else if (randomboots == 5) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(InvincibleConquestModItems.REX_SPLODE_SUIT_BOOTS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(InvincibleConquestModItems.REX_SPLODE_SUIT_BOOTS.get()));
				}
			}
		} else if (randomboots == 6) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(InvincibleConquestModItems.OMNIVINCIBLE_SUIT_BOOTS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(InvincibleConquestModItems.OMNIVINCIBLE_SUIT_BOOTS.get()));
				}
			}
		} else if (randomboots == 7) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(InvincibleConquestModItems.ATOM_EVE_SUIT_BOOTS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(InvincibleConquestModItems.ATOM_EVE_SUIT_BOOTS.get()));
				}
			}
		} else if (randomboots == 8) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(InvincibleConquestModItems.TECH_JACKET_ARMOR_BOOTS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(InvincibleConquestModItems.TECH_JACKET_ARMOR_BOOTS.get()));
				}
			}
		} else if (randomboots == 9) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(Items.DIAMOND_BOOTS));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
				}
			}
		} else if (randomboots == 10) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(Items.IRON_BOOTS));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
				}
			}
		} else if (randomboots == 11) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(Items.GOLDEN_BOOTS));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.GOLDEN_BOOTS));
				}
			}
		}
		entity.setCustomName(Component.literal(randomnamestring));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 999999, Mth.nextInt(RandomSource.create(), 1, 20), false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 999999, Mth.nextInt(RandomSource.create(), 1, 9), false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 999999, Mth.nextInt(RandomSource.create(), 1, 6), false, false));
		if (entity instanceof HeroEntity _datEntSetI)
			_datEntSetI.getEntityData().set(HeroEntity.DATA_skin, Mth.nextInt(RandomSource.create(), 1, 2));
	}
}
