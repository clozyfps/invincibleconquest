
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
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.clozynoii.invincibleconquest.world.inventory.MenuAbilityBeastMenu;
import net.clozynoii.invincibleconquest.procedures.UnlockTitanLeapProcedure;
import net.clozynoii.invincibleconquest.procedures.UnlockDragProcedure;
import net.clozynoii.invincibleconquest.procedures.UnlockConstantClawsProcedure;
import net.clozynoii.invincibleconquest.procedures.UnlockClawsProcedure;
import net.clozynoii.invincibleconquest.procedures.OpenGUIAbilityBasicProcedure;
import net.clozynoii.invincibleconquest.procedures.MenuAbilityBeastWhileThisGUIIsOpenTickProcedure;
import net.clozynoii.invincibleconquest.procedures.KeybindStatMenuProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot5bProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot5aProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot4bProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot4aProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot3bProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot3aProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot2bProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot2aProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot1bProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISkillSlot1aProcedure;
import net.clozynoii.invincibleconquest.procedures.GUISelectedResetProcedure;
import net.clozynoii.invincibleconquest.InvincibleConquestMod;

import java.util.Map;
import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record MenuAbilityBeastButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) implements CustomPacketPayload {

	public static final Type<MenuAbilityBeastButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InvincibleConquestMod.MODID, "menu_ability_beast_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MenuAbilityBeastButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, MenuAbilityBeastButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		writeTextState(message.textstate, buffer);
	}, (RegistryFriendlyByteBuf buffer) -> new MenuAbilityBeastButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), readTextState(buffer)));
	@Override
	public Type<MenuAbilityBeastButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final MenuAbilityBeastButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				HashMap<String, String> textstate = message.textstate;
				handleButtonAction(entity, buttonID, x, y, z, textstate);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
		Level world = entity.level();
		HashMap guistate = MenuAbilityBeastMenu.guistate;
		// connect EditBox and CheckBox to guistate
		for (Map.Entry<String, String> entry : textstate.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			guistate.put(key, value);
		}
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == -1) {

			MenuAbilityBeastWhileThisGUIIsOpenTickProcedure.execute(entity);
		}
		if (buttonID == -2) {

			GUISelectedResetProcedure.execute(entity);
		}
		if (buttonID == 0) {

			KeybindStatMenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenGUIAbilityBasicProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			GUISkillSlot1aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			GUISkillSlot2aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			GUISkillSlot3aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			GUISkillSlot4aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			GUISkillSlot5aProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			GUISkillSlot1bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			GUISkillSlot2bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			GUISkillSlot3bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			GUISkillSlot4bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			GUISkillSlot5bProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			UnlockTitanLeapProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			UnlockClawsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			UnlockConstantClawsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 15) {

			UnlockDragProcedure.execute(world, x, y, z, entity);
		}
	}

	private static void writeTextState(HashMap<String, String> map, RegistryFriendlyByteBuf buffer) {
		buffer.writeInt(map.size());
		for (Map.Entry<String, String> entry : map.entrySet()) {
			writeComponent(buffer, Component.literal(entry.getKey()));
			writeComponent(buffer, Component.literal(entry.getValue()));
		}
	}

	private static HashMap<String, String> readTextState(RegistryFriendlyByteBuf buffer) {
		int size = buffer.readInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < size; i++) {
			String key = readComponent(buffer).getString();
			String value = readComponent(buffer).getString();
			map.put(key, value);
		}
		return map;
	}

	private static Component readComponent(RegistryFriendlyByteBuf buffer) {
		return ComponentSerialization.TRUSTED_STREAM_CODEC.decode(buffer);
	}

	private static void writeComponent(RegistryFriendlyByteBuf buffer, Component component) {
		ComponentSerialization.TRUSTED_STREAM_CODEC.encode(buffer, component);
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InvincibleConquestMod.addNetworkMessage(MenuAbilityBeastButtonMessage.TYPE, MenuAbilityBeastButtonMessage.STREAM_CODEC, MenuAbilityBeastButtonMessage::handleData);
	}
}
