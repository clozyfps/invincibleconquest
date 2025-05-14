
package net.clozynoii.invincibleconquest.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.world.inventory.HeroSelectorMenu;
import net.clozynoii.invincibleconquest.procedures.HeroSlot5UseProcedure;
import net.clozynoii.invincibleconquest.procedures.HeroSlot4UseProcedure;
import net.clozynoii.invincibleconquest.procedures.HeroSlot3UseProcedure;
import net.clozynoii.invincibleconquest.procedures.HeroSlot2UseProcedure;
import net.clozynoii.invincibleconquest.procedures.HeroSlot1UseProcedure;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record HeroSelectorButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<HeroSelectorButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "hero_selector_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, HeroSelectorButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, HeroSelectorButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new HeroSelectorButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<HeroSelectorButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final HeroSelectorButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = HeroSelectorMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			HeroSlot1UseProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			HeroSlot2UseProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			HeroSlot3UseProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			HeroSlot4UseProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			HeroSlot5UseProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleConquestMod.addNetworkMessage(HeroSelectorButtonMessage.TYPE, HeroSelectorButtonMessage.STREAM_CODEC, HeroSelectorButtonMessage::handleData);
	}
}
