package com.github.alexmaclean.herobrine.entities;

import com.github.alexmaclean.herobrine.HerobrineMod;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FakeHerobrineMageEntity extends HerobrineEntity {
    private int lifeTimer;
    public FakeHerobrineMageEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 0;
        this.lifeTimer = 200;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 0.6, false));
        this.goalSelector.add(2, new ActiveTargetGoal<>(this, IllagerEntity.class, false));
        this.goalSelector.add(3, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        //this.goalSelector.add(4, new ActiveTargetGoal<>(this, SurvivorEntity.class, false));
        this.goalSelector.add(5, new ActiveTargetGoal<>(this, GolemEntity.class, false));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.4));
        this.goalSelector.add(7, new LookAtEntityGoal(this, IllagerEntity.class, 0.8f));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 0.8f));
        //this.goalSelector.add(9, new LookAtEntityGoal(this, SurvivorEntity.class, 0.8f));
        this.goalSelector.add(10, new LookAtEntityGoal(this, GolemEntity.class, 0.8f));
        this.goalSelector.add(11, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder registerAttributes() {
        return HerobrineEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.0)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("LifeTimer", this.lifeTimer);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.lifeTimer = nbt.getInt("LifeTimer");
    }

    @Override
    public void mobTick() {
        if(this.lifeTimer < 1) {
            this.world.sendEntityStatus(this, (byte) 4);
            this.remove(RemovalReason.DISCARDED);
        }

        this.lifeTimer --;
        super.mobTick();
    }

    @Override
    public void handleStatus(byte status) {
        if(status == 4) {
            if(this.world.isClient) {
                if (!this.isSilent()) {
                    this.world.playSound(this.getX(), this.getEyeY(), this.getZ(), SoundEvents.ITEM_FIRECHARGE_USE, this.getSoundCategory(), 1.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                }

                for (int i = 0; i < 20; ++i) {
                    double vX = this.random.nextGaussian() * 0.02;
                    double vY = this.random.nextGaussian() * 0.02;
                    double vZ = this.random.nextGaussian() * 0.02;
                    this.world.addParticle(ParticleTypes.POOF, this.getParticleX(1.0), this.getRandomBodyY(), this.getParticleZ(1.0), vX, vY, vZ);
                }
            }
        }
        super.handleStatus(status);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.setPersistent();
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    @Override
    public Identifier getLootTableId() {
        return null;
    }
}
