package net.clozynoii.invincibleconquest.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import net.clozynoii.invincibleconquest.network.InvincibleConquestModVariables;

import java.util.HashMap;

public class FigherJetGUIWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			InvincibleConquestModVariables.PlayerVariables _vars = entity.getData(InvincibleConquestModVariables.PLAYER_VARIABLES);
			_vars.Cost = 100 + (new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:XValue") ? ((EditBox) guistate.get("text:XValue")).getValue() : "") + new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:ZValue") ? ((EditBox) guistate.get("text:ZValue")).getValue() : "")) - (entity.getX() + entity.getZ());
			_vars.syncPlayerVariables(entity);
		}
	}
}
