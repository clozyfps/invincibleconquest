package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.MenuProvider;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.world.inventory.GDASlotButtonsMenu;
import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModItems;

import io.netty.buffer.Unpooled;

public class HeroRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double tamechance = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == InvincibleConquestModItems.RECRUITMENT_FORM.get()) {
			if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(InvincibleConquestModMobEffects.PAUSE_DIALOGUE))) {
				if ((sourceentity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES).PlayerAbility).equals("Human")) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.PAUSE_DIALOGUE, 5, 0, false, false));
					(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
					tamechance = Mth.nextInt(RandomSource.create(), 1, 2);
					if (tamechance == 1) {
						if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
							_toTame.tame(_owner);
						sourceentity.getPersistentData().putString("recenthero", (entity.getDisplayName().getString()));
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7l<Hero>\u00A7r Ready for service."), false);
						if (sourceentity instanceof ServerPlayer _ent) {
							BlockPos _bpos = BlockPos.containing(x, y, z);
							_ent.openMenu(new MenuProvider() {
								@Override
								public Component getDisplayName() {
									return Component.literal("GDASlotButtons");
								}

								@Override
								public boolean shouldTriggerClientSideContainerClosingOnOpen() {
									return false;
								}

								@Override
								public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
									return new GDASlotButtonsMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					} else if (tamechance == 2) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7l<Hero>\u00A7r Sorry, no can do."), false);
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7aMust Be A Human."), false);
				}
			}
		}
	}
}
