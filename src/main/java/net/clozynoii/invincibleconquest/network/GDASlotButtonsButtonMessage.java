
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

import net.clozynoii.invincibleconquest.world.inventory.GDASlotButtonsMenu;
import net.clozynoii.invincibleconquest.procedures.SelectHeroSlot5Procedure;
import net.clozynoii.invincibleconquest.procedures.SelectHeroSlot4Procedure;
import net.clozynoii.invincibleconquest.procedures.SelectHeroSlot3Procedure;
import net.clozynoii.invincibleconquest.procedures.SelectHeroSlot2Procedure;
import net.clozynoii.invincibleconquest.procedures.SelectHeroSlot1Procedure;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record GDASlotButtonsButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<GDASlotButtonsButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "gda_slot_buttons_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, GDASlotButtonsButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, GDASlotButtonsButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new GDASlotButtonsButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<GDASlotButtonsButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final GDASlotButtonsButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = GDASlotButtonsMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SelectHeroSlot1Procedure.execute(entity);
		}
		if (buttonID == 1) {

			SelectHeroSlot2Procedure.execute(entity);
		}
		if (buttonID == 2) {

			SelectHeroSlot3Procedure.execute(entity);
		}
		if (buttonID == 3) {

			SelectHeroSlot4Procedure.execute(entity);
		}
		if (buttonID == 4) {

			SelectHeroSlot5Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleConquestMod.addNetworkMessage(GDASlotButtonsButtonMessage.TYPE, GDASlotButtonsButtonMessage.STREAM_CODEC, GDASlotButtonsButtonMessage::handleData);
	}
}
