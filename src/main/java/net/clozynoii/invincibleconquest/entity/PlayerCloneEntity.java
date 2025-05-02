package net.clozynoii.invincibleconquest.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;      // ← correct import
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LightningBolt;                       // ← correct import
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.network.syncher.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.clozynoii.invincibleconquest.procedures.*;
import net.clozynoii.invincibleconquest.init.InvincibleConquestModEntities;

import javax.annotation.Nullable;
import java.util.UUID;

public class PlayerCloneEntity extends TamableAnimal {
    // === Skin‐sync data ===
    private GameProfile skinProfile;
    public static final EntityDataAccessor<String> SKIN_UUID =
        SynchedEntityData.defineId(PlayerCloneEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> SKIN_NAME =
        SynchedEntityData.defineId(PlayerCloneEntity.class, EntityDataSerializers.STRING);

    public PlayerCloneEntity(EntityType<PlayerCloneEntity> type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(false);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SKIN_UUID, "");
        builder.define(SKIN_NAME, "");
    }

    /** Called on server to assign the player's skin. */
    public void setSkinProfile(GameProfile profile) {
        this.skinProfile = profile;
        if (profile != null) {
            entityData.set(SKIN_UUID, profile.getId().toString());
            entityData.set(SKIN_NAME, profile.getName());
        }
    }

    /** Client reads this after sync. */
    public GameProfile getSkinProfile() {
        return skinProfile;
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        super.onSyncedDataUpdated(key);
        if (key == SKIN_UUID || key == SKIN_NAME) {
            String uuid = entityData.get(SKIN_UUID);
            String name = entityData.get(SKIN_NAME);
            if (!uuid.isEmpty() && !name.isEmpty()) {
                try {
                    skinProfile = new GameProfile(UUID.fromString(uuid), name);
                } catch (IllegalArgumentException e) {
                    skinProfile = null;
                }
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        if (skinProfile != null) {
            tag.putString("SkinUUID", skinProfile.getId().toString());
            tag.putString("SkinName", skinProfile.getName());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("SkinUUID") && tag.contains("SkinName")) {
            try {
                skinProfile = new GameProfile(
                    UUID.fromString(tag.getString("SkinUUID")),
                    tag.getString("SkinName")
                );
            } catch (IllegalArgumentException ignored) {}
        }
    }

    // --- Existing AI & hooks unchanged below ---

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override protected boolean canPerformAttack(LivingEntity e) {
                return isTimeToAttack()
                    && distanceToSqr(e) < (getBbWidth()*getBbWidth() + e.getBbWidth())
                    && getSensing().hasLineOfSight(e);
            }
        });
        goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
        targetSelector.addGoal(3, new HurtByTargetGoal(this));  // ← now compiles
        goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        goalSelector.addGoal(5, new FloatGoal(this));
    }

    @Override
    public Vec3 getPassengerRidingPosition(Entity p) {
        return super.getPassengerRidingPosition(p).add(0, -0.35F, 0);
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
    }

    @Override
    public void thunderHit(ServerLevel world, LightningBolt bolt) {
        super.thunderHit(world, bolt);
        PlayerCloneItIsStruckByLightningProcedure.execute();
    }

    @Override
    public boolean causeFallDamage(float l, float d, DamageSource src) {
        PlayerCloneEntityFallsProcedure.execute();
        return super.causeFallDamage(l, d, src);
    }

    @Override
    public boolean hurt(DamageSource src, float amt) {
        PlayerCloneEntityIsHurtProcedure.execute();
        return super.hurt(src, amt);
    }

    @Override
    public void die(DamageSource src) {
        super.die(src);
        PlayerCloneEntityDiesProcedure.execute();
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor w, DifficultyInstance diff, MobSpawnType reason, @Nullable SpawnGroupData data) {
        SpawnGroupData ret = super.finalizeSpawn(w, diff, reason, data);
        PlayerCloneOnInitialEntitySpawnProcedure.execute();
        return ret;
    }

    @Override
    public InteractionResult mobInteract(Player p, InteractionHand h) {
        InteractionResult res = super.mobInteract(p, h);
        PlayerCloneRightClickedOnEntityProcedure.execute();
        return res;
    }

    @Override
    public void awardKillScore(Entity e, int sc, DamageSource ds) {
        super.awardKillScore(e, sc, ds);
        PlayerCloneThisEntityKillsAnotherOneProcedure.execute();
    }

    @Override
    public void baseTick() {
        super.baseTick();
        PlayerCloneOnEntityTickUpdateProcedure.execute();
    }

    @Override
    public void playerTouch(Player p) {
        super.playerTouch(p);
        PlayerClonePlayerCollidesWithThisEntityProcedure.execute();
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel w, AgeableMob a) {
        PlayerCloneEntity child = InvincibleConquestModEntities.PLAYER_CLONE.get().create(w);
        child.finalizeSpawn(w, w.getCurrentDifficultyAt(child.blockPosition()), MobSpawnType.BREEDING, null);
        return child;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return Ingredient.of().test(stack);
    }

    public static void init(RegisterSpawnPlacementsEvent event) {
        // Your existing spawn rules...
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MOVEMENT_SPEED, 0.3)
            .add(Attributes.MAX_HEALTH, 10)
            .add(Attributes.ARMOR, 0)
            .add(Attributes.ATTACK_DAMAGE, 3)
            .add(Attributes.FOLLOW_RANGE, 16)
            .add(Attributes.STEP_HEIGHT, 0.6);
    }
}
