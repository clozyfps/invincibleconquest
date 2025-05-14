package net.clozynoii.invincibleconquest.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import java.util.HashMap;

public class GDASoldierGUIWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Cost = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:gdasoldieramount") ? ((EditBox) guistate.get("text:gdasoldieramount")).getValue() : "") * 150;
			_vars.syncPlayerVariables(entity);
		}
		if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:gdasoldieramount") ? ((EditBox) guistate.get("text:gdasoldieramount")).getValue() : "") > 100) {
			if (guistate.get("text:gdasoldieramount") instanceof EditBox _tf)
				_tf.setValue("100");
		}
	}
}
