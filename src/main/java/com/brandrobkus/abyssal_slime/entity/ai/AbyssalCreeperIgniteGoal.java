package com.brandrobkus.abyssal_slime.entity.ai;

import com.brandrobkus.abyssal_slime.entity.custom.AbyssalCreeperEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class AbyssalCreeperIgniteGoal extends Goal {
    private final AbyssalCreeperEntity creeper;
    @Nullable
    private LivingEntity target;

    public AbyssalCreeperIgniteGoal(AbyssalCreeperEntity creeper) {
        this.creeper = creeper;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.creeper.getTarget();
        return this.creeper.getFuseSpeed() > 0 || livingEntity != null && this.creeper.squaredDistanceTo(livingEntity) < (double)9.0F;
    }

    public void start() {
        this.creeper.getNavigation().stop();
        this.target = this.creeper.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public boolean shouldRunEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target == null) {
            this.creeper.setFuseSpeed(-1);
        } else if (this.creeper.squaredDistanceTo(this.target) > (double)25.0F) {
            this.creeper.setFuseSpeed(-1);
        } else if (!this.creeper.getVisibilityCache().canSee(this.target)) {
            this.creeper.setFuseSpeed(-1);
        } else {
            this.creeper.setFuseSpeed(1);
        }
    }
}
