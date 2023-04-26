package com.herobrinemod.herobrine.entities.goals;

import com.herobrinemod.herobrine.entities.InfectedHorseEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.NotNull;

public class InfectedHorseAmbientStandGoal extends Goal {
    private final InfectedHorseEntity entity;
    private int cooldown;
    public InfectedHorseAmbientStandGoal(InfectedHorseEntity entity) {
        this.entity = entity;
        this.resetCooldown(entity);
    }

    @Override
    public void start() {
        this.entity.updateAnger();
        this.playAmbientStandSound();
    }

    private void playAmbientStandSound() {
        SoundEvent soundEvent = this.entity.getAmbientStandSound();
        if (soundEvent != null) {
            this.entity.playSoundIfNotSilent(soundEvent);
        }
    }

    @Override
    public boolean shouldContinue() {
        return false;
    }

    @Override
    public boolean canStart() {
        ++this.cooldown;
        if (this.cooldown > 0 && this.entity.getRandom().nextInt(1000) < this.cooldown) {
            this.resetCooldown(this.entity);
            return !this.entity.isImmobile() && this.entity.getRandom().nextInt(10) == 0;
        }
        return false;
    }

    private void resetCooldown(@NotNull InfectedHorseEntity entity) {
        this.cooldown = -entity.getMinAmbientStandDelay();
    }

    @Override
    public boolean shouldRunEveryTick() {
        return true;
    }
}
