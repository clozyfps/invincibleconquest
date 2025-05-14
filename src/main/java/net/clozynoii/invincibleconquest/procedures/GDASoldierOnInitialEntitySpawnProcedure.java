package net.clozynoii.invincibleconquest.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.clozynoii.invincibleconquest.init.InvincibleConquestModMobEffects;

public class GDASoldierOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String randomnamestring = "";
		double randomnameinteger = 0;
		double randomrankinteger = 0;
		randomnameinteger = Mth.nextInt(RandomSource.create(), 1, 20);
		randomrankinteger = Mth.nextInt(RandomSource.create(), 1, 5);
		if (randomrankinteger == 1) {
			randomnamestring = "Private ";
		} else if (randomrankinteger == 2) {
			randomnamestring = "Commander ";
		} else if (randomrankinteger == 3) {
			randomnamestring = "General ";
		} else if (randomrankinteger == 4) {
			randomnamestring = "Lieutenant ";
		} else if (randomrankinteger == 5) {
			randomnamestring = "Conscript ";
		}
		if (randomnameinteger == 1) {
			randomnamestring = randomnamestring + "John";
		} else if (randomnameinteger == 2) {
			randomnamestring = randomnamestring + "Bob";
		} else if (randomnameinteger == 3) {
			randomnamestring = randomnamestring + "Lewis";
		} else if (randomnameinteger == 4) {
			randomnamestring = randomnamestring + "Ron";
		} else if (randomnameinteger == 5) {
			randomnamestring = randomnamestring + "Gay";
		} else if (randomnameinteger == 6) {
			randomnamestring = randomnamestring + "Bored";
		} else if (randomnameinteger == 7) {
			randomnamestring = randomnamestring + "Jason";
		} else if (randomnameinteger == 8) {
			randomnamestring = randomnamestring + "Brenden";
		} else if (randomnameinteger == 8) {
			randomnamestring = randomnamestring + "Thomas";
		} else if (randomnameinteger == 9) {
			randomnamestring = randomnamestring + "Timmy";
		} else if (randomnameinteger == 10) {
			randomnamestring = randomnamestring + "Nolan";
		} else if (randomnameinteger == 11) {
			randomnamestring = randomnamestring + "Mark";
		} else if (randomnameinteger == 12) {
			randomnamestring = randomnamestring + "Naylen";
		} else if (randomnameinteger == 13) {
			randomnamestring = randomnamestring + "Chris";
		} else if (randomnameinteger == 14) {
			randomnamestring = randomnamestring + "Billy";
		} else if (randomnameinteger == 15) {
			randomnamestring = randomnamestring + "Debbie";
		} else if (randomnameinteger == 16) {
			randomnamestring = randomnamestring + "Allen";
		} else if (randomnameinteger == 17) {
			randomnamestring = randomnamestring + "Allen";
		} else if (randomnameinteger == 18) {
			randomnamestring = randomnamestring + "Liam";
		} else if (randomnameinteger == 19) {
			randomnamestring = randomnamestring + "Anthony";
		} else if (randomnameinteger == 20) {
			randomnamestring = randomnamestring + "Oliver";
		}
		entity.setCustomName(Component.literal(randomnamestring));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(InvincibleConquestModMobEffects.PATROL, 999999, 0, false, false));
	}
}
