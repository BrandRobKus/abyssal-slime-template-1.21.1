package com.brandrobkus.abyssal_slime.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.EnumSet;

public class AbyssalBlazeEntity extends HostileEntity {
    private float eyeOffset = 0.5F;
    private int eyeOffsetCooldown;
    private static final TrackedData<Byte> BLAZE_FLAGS;

    public AbyssalBlazeEntity(EntityType<? extends AbyssalBlazeEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
        this.setPathfindingPenalty(PathNodeType.LAVA, 8.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0F);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0F);
        this.experiencePoints = 10;
    }

    protected void initGoals() {
        this.goalSelector.add(8, new ShootFireballGoal(this));
        this.goalSelector.add(5, new GoToWalkTargetGoal(this, 1.0F));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0F, 0.0F));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[0]));
        this.targetSelector.add(4, new ActiveTargetGoal(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createBlazeAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0F).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35F).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0F);
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(BLAZE_FLAGS, (byte)0);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BLAZE_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_BLAZE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BLAZE_DEATH;
    }

    public float getBrightnessAtEyes() {
        return 1.0F;
    }

    public void tickMovement() {
        if (!this.isOnGround() && this.getVelocity().y < 0.0F) {
            this.setVelocity(this.getVelocity().multiply(1.0F, 0.6, 1.0F));
        }

        if (this.getWorld().isClient) {
            if (this.random.nextInt(24) == 0 && !this.isSilent()) {
                this.getWorld().playSound(this.getX() + 0.5F, this.getY() + 0.5F, this.getZ() + 0.5F, SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
            }

            for(int i = 0; i < 2; ++i) {
                this.getWorld().addParticle(ParticleTypes.FALLING_OBSIDIAN_TEAR, this.getParticleX(0.5F), this.getRandomBodyY(), this.getParticleZ(0.5F), 0.0F, 0.0F, 0.0F);
            }
        }

        super.tickMovement();
    }

    public boolean hurtByWater() {
        return true;
    }

    protected void mobTick() {
        --this.eyeOffsetCooldown;
        if (this.eyeOffsetCooldown <= 0) {
            this.eyeOffsetCooldown = 100;
            this.eyeOffset = (float)this.random.nextTriangular(0.5F, 6.891);
        }

        LivingEntity livingEntity = this.getTarget();
        if (livingEntity != null && livingEntity.getEyeY() > this.getEyeY() + this.eyeOffset && this.canTarget(livingEntity)) {
            Vec3d vec3d = this.getVelocity();
            this.setVelocity(this.getVelocity().add(0.0F, (0.3F - vec3d.y) * 0.3F, 0.0F));
            this.velocityDirty = true;
        }

        super.mobTick();
    }

    public boolean isOnFire() {
        return this.isFireActive();
    }

    private boolean isFireActive() {
        return (this.dataTracker.get(BLAZE_FLAGS) & 1) != 0;
    }

    void setFireActive(boolean fireActive) {
        byte b = this.dataTracker.get(BLAZE_FLAGS);
        if (fireActive) {
            b = (byte)(b | 1);
        } else {
            b = (byte)(b & -2);
        }

        this.dataTracker.set(BLAZE_FLAGS, b);
    }

    static {
        BLAZE_FLAGS = DataTracker.registerData(AbyssalBlazeEntity.class, TrackedDataHandlerRegistry.BYTE);
    }

    static class ShootFireballGoal extends Goal {
        private final AbyssalBlazeEntity blaze;
        private int fireballsFired;
        private int fireballCooldown;
        private int targetNotVisibleTicks;

        public ShootFireballGoal(AbyssalBlazeEntity blaze) {
            this.blaze = blaze;
            this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
        }

        public boolean canStart() {
            LivingEntity livingEntity = this.blaze.getTarget();
            return livingEntity != null && livingEntity.isAlive() && this.blaze.canTarget(livingEntity);
        }

        public void start() {
            this.fireballsFired = 0;
        }

        public void stop() {
            this.blaze.setFireActive(false);
            this.targetNotVisibleTicks = 0;
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            --this.fireballCooldown;
            LivingEntity livingEntity = this.blaze.getTarget();
            if (livingEntity != null) {
                boolean bl = this.blaze.getVisibilityCache().canSee(livingEntity);
                if (bl) {
                    this.targetNotVisibleTicks = 0;
                } else {
                    ++this.targetNotVisibleTicks;
                }

                double d = this.blaze.squaredDistanceTo(livingEntity);
                if (d < 4.0F) {
                    if (!bl) {
                        return;
                    }

                    if (this.fireballCooldown <= 0) {
                        this.fireballCooldown = 4;
                        this.blaze.tryAttack(livingEntity);
                    }

                    this.blaze.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 1.0F);
                } else if (d < this.getFollowRange() * this.getFollowRange() && bl) {
                    double e = livingEntity.getX() - this.blaze.getX();
                    double f = livingEntity.getBodyY(0.5F) - this.blaze.getBodyY(0.5F);
                    double g = livingEntity.getZ() - this.blaze.getZ();
                    if (this.fireballCooldown <= 0) {
                        ++this.fireballsFired;
                        if (this.fireballsFired == 0) {
                            this.fireballCooldown = 60;
                            this.blaze.setFireActive(true);
                        } else {
                            this.fireballCooldown = 4;
                        }

                        if (this.fireballsFired >= 10) {
                            this.fireballsFired = 0;
                            this.blaze.setFireActive(false);
                        }

                        if (this.fireballsFired > 1) {
                            double h = Math.sqrt(Math.sqrt(d)) * 0.5F;
                            if (!this.blaze.isSilent()) {
                                this.blaze.getWorld().syncWorldEvent(null, 1018, this.blaze.getBlockPos(), 0);
                            }

                            for(int i = 0; i < 1; ++i) {
                                Vec3d vec3d = new Vec3d(this.blaze.getRandom().nextTriangular(e, 2.297 * h), f, this.blaze.getRandom().nextTriangular(g, 2.297 * h));
                                SmallFireballEntity smallFireballEntity = new SmallFireballEntity(this.blaze.getWorld(), this.blaze, vec3d.normalize());
                                smallFireballEntity.setPosition(smallFireballEntity.getX(), this.blaze.getBodyY(0.5F) + 0.5F, smallFireballEntity.getZ());
                                this.blaze.getWorld().spawnEntity(smallFireballEntity);
                            }
                        }
                    }

                    this.blaze.getLookControl().lookAt(livingEntity, 10.0F, 10.0F);
                } else if (this.targetNotVisibleTicks < 5) {
                    this.blaze.getMoveControl().moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), 1.0F);
                }

                super.tick();
            }
        }

        private double getFollowRange() {
            return this.blaze.getAttributeValue(EntityAttributes.GENERIC_FOLLOW_RANGE);
        }
    }

    @Override
    public int getSafeFallDistance() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

}
