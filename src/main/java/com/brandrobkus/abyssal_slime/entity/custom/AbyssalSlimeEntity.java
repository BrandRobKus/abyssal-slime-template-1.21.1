package com.brandrobkus.abyssal_slime.entity.custom;

import com.brandrobkus.abyssal_slime.effect.ModEffects;
import com.brandrobkus.abyssal_slime.entity.ModEntities;
import com.google.common.annotations.VisibleForTesting;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.ChunkRandom;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class AbyssalSlimeEntity extends HostileEntity implements Monster {
    private static final TrackedData<Integer> SLIME_SIZE;
    public static final int MIN_SIZE = 1;
    public static final int MAX_SIZE = 127;
    public static final int field_50136 = 3;
    public float targetStretch;
    public float stretch;
    public float lastStretch;
    private boolean onGroundLastTick;
    private int growthTimer = 0;
    private static final int GROWTH_TIME_TICKS = 600;

    public static DefaultAttributeContainer.Builder createAbyssalSlimeAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0);
    }

    public AbyssalSlimeEntity(EntityType<? extends AbyssalSlimeEntity> entityType, World world) {
        super(entityType, world);
        this.reinitDimensions();
        this.moveControl = new AbyssalSlimeEntity.SlimeMoveControl(this);
    }

    protected void initGoals() {
        this.goalSelector.add(1, new AbyssalSlimeEntity.SwimmingGoal(this));
        this.goalSelector.add(2, new AbyssalSlimeEntity.FaceTowardTargetGoal(this));
        this.goalSelector.add(3, new AbyssalSlimeEntity.RandomLookGoal(this));
        this.goalSelector.add(5, new AbyssalSlimeEntity.MoveGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class,
                10, true, false,
                (LivingEntity livingEntity) -> Math.abs(livingEntity.getY() - this.getY()) <= 4.0F));
        this.targetSelector.add(3, new ActiveTargetGoal(this, IronGolemEntity.class, true));
    }

    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(SLIME_SIZE, 1);
    }

    @VisibleForTesting
    public void setSize(int size, boolean heal) {
        int i = MathHelper.clamp(size, 1, 3);
        this.dataTracker.set(SLIME_SIZE, i);
        this.refreshPosition();
        this.calculateDimensions();
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue((i * i));
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue((0.2F + 0.1F * (float)i));
        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(i);
        if (heal) {
            this.setHealth(this.getMaxHealth());
        }

        this.experiencePoints = i;
    }

    public int getSize() {
        return this.dataTracker.get(SLIME_SIZE);
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Size", this.getSize() - 1);
        nbt.putBoolean("wasOnGround", this.onGroundLastTick);
        nbt.putInt("GrowthTimer", this.growthTimer);
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        this.setSize(nbt.getInt("Size") + 1, false);
        super.readCustomDataFromNbt(nbt);
        this.onGroundLastTick = nbt.getBoolean("wasOnGround");
        this.growthTimer = nbt.getInt("GrowthTimer");
    }

    public boolean isSmall() {
        return this.getSize() <= 1;
    }

    protected ParticleEffect getParticles() {
        return ParticleTypes.LANDING_OBSIDIAN_TEAR;
    }

    protected boolean isDisallowedInPeaceful() {
        return this.getSize() > 0;
    }

    public void tick() {
        this.stretch += (this.targetStretch - this.stretch) * 0.5F;
        this.lastStretch = this.stretch;
        super.tick();
        if (this.isOnGround() && !this.onGroundLastTick) {
            float f = this.getDimensions(this.getPose()).width() * 2.0F;
            float g = f / 2.0F;

            for(int i = 0; (float)i < f * 16.0F; ++i) {
                float h = this.random.nextFloat() * ((float)Math.PI * 2F);
                float j = this.random.nextFloat() * 0.5F + 0.5F;
                float k = MathHelper.sin(h) * g * j;
                float l = MathHelper.cos(h) * g * j;
                this.getWorld().addParticle(this.getParticles(), this.getX() + k, this.getY(), this.getZ() + l, 0.0F, 0.0F, 0.0F);
            }

            this.playSound(this.getSquishSound(), this.getSoundVolume(), ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            this.targetStretch = -0.5F;
        } else if (!this.isOnGround() && this.onGroundLastTick) {
            this.targetStretch = 1.0F;
        }

        this.onGroundLastTick = this.isOnGround();
        this.updateStretch();

        if (!this.getWorld().isClient) {
            if (this.getSize() < 3) {
                this.growthTimer++;

                if (this.growthTimer >= GROWTH_TIME_TICKS) {
                    this.setSize(this.getSize() + 1, true);
                    this.growthTimer = 0;
                    this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.AMBIENT_UNDERWATER_ENTER, SoundCategory.HOSTILE, 1.0F, 1.0F);
                    ((ServerWorld)this.getWorld()).spawnParticles(ParticleTypes.SQUID_INK, this.getX(), this.getY(), this.getZ(), 10, 0.3, 0.3, 0.3, 0.1);
                }
            }
        }

        boolean bl = this.burnsInDaylight() && this.isAffectedByDaylight();
        if (bl) {
            ItemStack itemStack = this.getEquippedStack(EquipmentSlot.HEAD);
            if (!itemStack.isEmpty()) {
                if (itemStack.isDamageable()) {
                    Item item = itemStack.getItem();
                    itemStack.setDamage(itemStack.getDamage() + this.random.nextInt(2));
                    if (itemStack.getDamage() >= itemStack.getMaxDamage()) {
                        this.sendEquipmentBreakStatus(item, EquipmentSlot.HEAD);
                        this.equipStack(EquipmentSlot.HEAD, ItemStack.EMPTY);
                    }
                }

                bl = false;
            }

            if (bl) {
                this.setOnFireFor(8.0F);
            }
        }
    }

    protected boolean burnsInDaylight() {
        return true;
    }

    protected void updateStretch() {
        this.targetStretch *= 0.6F;
    }

    protected int getTicksUntilNextJump() {
        return this.random.nextInt(20) + 10;
    }

    public void calculateDimensions() {
        double d = this.getX();
        double e = this.getY();
        double f = this.getZ();
        super.calculateDimensions();
        this.setPosition(d, e, f);
    }

    public void onTrackedDataSet(TrackedData<?> data) {
        if (SLIME_SIZE.equals(data)) {
            this.calculateDimensions();
            this.setYaw(this.headYaw);
            this.bodyYaw = this.headYaw;
            if (this.isTouchingWater() && this.random.nextInt(20) == 0) {
                this.onSwimmingStart();
            }
        }

        super.onTrackedDataSet(data);
    }

    public EntityType<? extends AbyssalSlimeEntity> getType() {
        return (EntityType<? extends AbyssalSlimeEntity>) super.getType();
    }

    @Override
    public void remove(RemovalReason reason) {
        int size = this.getSize();
        if (!this.getWorld().isClient && this.isDead() && reason == RemovalReason.KILLED && size > 1) {
            int count = this.random.nextInt(2) + 3;

            for (int i = 0; i < count; ++i) {
                float offsetX = ((i % 2) - 0.5F) * size / 4.0F;
                float offsetZ = ((i / 2) - 0.5F) * size / 4.0F;

                AbyssalSlimeEntity child = ModEntities.ABYSSAL_SLIME.create(this.getWorld());
                if (child != null) {
                    child.setSize(size - 1, true);
                    child.setPosition(this.getX() + offsetX, this.getY() + 0.5D, this.getZ() + offsetZ);
                    child.setAiDisabled(this.isAiDisabled());

                    if (this.hasCustomName()) {
                        child.setCustomName(this.getCustomName());
                        child.setCustomNameVisible(this.isCustomNameVisible());
                    }

                    this.getWorld().spawnEntity(child);
                }
            }
        }

        super.remove(reason);
    }

    public void pushAwayFrom(Entity entity) {
        super.pushAwayFrom(entity);
        if (entity instanceof IronGolemEntity && this.canAttack()) {
            this.damage((LivingEntity)entity);
        }

    }

    public void onPlayerCollision(PlayerEntity player) {
        if (this.canAttack()) {
            this.damage(player);
        }

    }

    protected void damage(LivingEntity target) {
        if (this.isAlive() && this.isInAttackRange(target) && this.canSee(target)) {
            DamageSource damageSource = this.getDamageSources().mobAttack(this);
            if (target.damage(damageSource, this.getDamageAmount())) {
                this.playSound(SoundEvents.ENTITY_SLIME_ATTACK, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                World var4 = this.getWorld();
                if (var4 instanceof ServerWorld) {
                    ServerWorld serverWorld = (ServerWorld)var4;
                    EnchantmentHelper.onTargetDamaged(serverWorld, target, damageSource);
                }if (target instanceof LivingEntity livingTarget) {
                    int size = this.getSize();
                    if (size >= 3) {
                        livingTarget.addStatusEffect(new StatusEffectInstance(ModEffects.ABYSSAL_SICKNESS, 200, 0));
                        livingTarget.addStatusEffect(new StatusEffectInstance(ModEffects.ABYSSAL_LEECH, 100, 0));
                    } else {
                        livingTarget.addStatusEffect(new StatusEffectInstance(ModEffects.ABYSSAL_LEECH, 100, 0));
                    }
                }


            }
        }

    }

    protected Vec3d getPassengerAttachmentPos(Entity passenger, EntityDimensions dimensions, float scaleFactor) {
        return new Vec3d(0.0F, dimensions.height() - 0.015625F * this.getSize() * scaleFactor, 0.0F);
    }

    protected boolean canAttack() {
        return !this.isSmall() && this.canMoveVoluntarily();
    }

    protected float getDamageAmount() {
        return (float)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return this.isSmall() ? SoundEvents.ENTITY_SLIME_HURT_SMALL : SoundEvents.ENTITY_SLIME_HURT;
    }

    protected SoundEvent getDeathSound() {
        return this.isSmall() ? SoundEvents.ENTITY_SLIME_DEATH_SMALL : SoundEvents.ENTITY_SLIME_DEATH;
    }

    protected SoundEvent getSquishSound() {
        return this.isSmall() ? SoundEvents.ENTITY_SLIME_SQUISH_SMALL : SoundEvents.ENTITY_SLIME_SQUISH;
    }

    public static boolean canSpawn(EntityType<AbyssalSlimeEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return pos.getY() >= -60 && pos.getY() <= -30 && HostileEntity.canSpawnIgnoreLightLevel(type, world, spawnReason, pos, random);
    }

    protected float getSoundVolume() {
        return 0.4F * (float)this.getSize();
    }

    public int getMaxLookPitchChange() {
        return 0;
    }

    protected boolean makesJumpSound() {
        return this.getSize() > 0;
    }

    public void jump() {
        Vec3d vec3d = this.getVelocity();
        this.setVelocity(vec3d.x, this.getJumpVelocity(), vec3d.z);
        this.velocityDirty = true;
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        Random random = world.getRandom();
        int i = random.nextInt(3);
        if (i < 2 && random.nextFloat() < 0.5F * difficulty.getClampedLocalDifficulty()) {
            ++i;
        }

        int j = 1 << i;
        this.setSize(j, true);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    float getJumpSoundPitch() {
        float f = this.isSmall() ? 1.4F : 0.8F;
        return ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F) * f;
    }

    protected SoundEvent getJumpSound() {
        return this.isSmall() ? SoundEvents.ENTITY_SLIME_JUMP_SMALL : SoundEvents.ENTITY_SLIME_JUMP;
    }

    public EntityDimensions getBaseDimensions(EntityPose pose) {
        return super.getBaseDimensions(pose).scaled((float)this.getSize());
    }

    static {
        SLIME_SIZE = DataTracker.registerData(AbyssalSlimeEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }

    static class SlimeMoveControl extends MoveControl {
        private float targetYaw;
        private int ticksUntilJump;
        private final AbyssalSlimeEntity slime;
        private boolean jumpOften;

        public SlimeMoveControl(AbyssalSlimeEntity slime) {
            super(slime);
            this.slime = slime;
            this.targetYaw = 180.0F * slime.getYaw() / (float)Math.PI;
        }

        public void look(float targetYaw, boolean jumpOften) {
            this.targetYaw = targetYaw;
            this.jumpOften = jumpOften;
        }

        public void move(double speed) {
            this.speed = speed;
            this.state = State.MOVE_TO;
        }

        public void tick() {
            this.entity.setYaw(this.wrapDegrees(this.entity.getYaw(), this.targetYaw, 90.0F));
            this.entity.headYaw = this.entity.getYaw();
            this.entity.bodyYaw = this.entity.getYaw();
            if (this.state != State.MOVE_TO) {
                this.entity.setForwardSpeed(0.0F);
            } else {
                this.state = State.WAIT;
                if (this.entity.isOnGround()) {
                    this.entity.setMovementSpeed((float)(this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)));
                    if (this.ticksUntilJump-- <= 0) {
                        this.ticksUntilJump = this.slime.getTicksUntilNextJump();
                        if (this.jumpOften) {
                            this.ticksUntilJump /= 3;
                        }

                        this.slime.getJumpControl().setActive();
                        if (this.slime.makesJumpSound()) {
                            this.slime.playSound(this.slime.getJumpSound(), this.slime.getSoundVolume(), this.slime.getJumpSoundPitch());
                        }
                    } else {
                        this.slime.sidewaysSpeed = 0.0F;
                        this.slime.forwardSpeed = 0.0F;
                        this.entity.setMovementSpeed(0.0F);
                    }
                } else {
                    this.entity.setMovementSpeed((float)(this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)));
                }

            }
        }
    }

    static class FaceTowardTargetGoal extends Goal {
        private final AbyssalSlimeEntity slime;
        private int ticksLeft;

        public FaceTowardTargetGoal(AbyssalSlimeEntity slime) {
            this.slime = slime;
            this.setControls(EnumSet.of(Control.LOOK));
        }

        public boolean canStart() {
            LivingEntity livingEntity = this.slime.getTarget();
            if (livingEntity == null) {
                return false;
            } else {
                return !this.slime.canTarget(livingEntity) ? false : this.slime.getMoveControl() instanceof AbyssalSlimeEntity.SlimeMoveControl;
            }
        }

        public void start() {
            this.ticksLeft = toGoalTicks(300);
            super.start();
        }

        public boolean shouldContinue() {
            LivingEntity livingEntity = this.slime.getTarget();
            if (livingEntity == null) {
                return false;
            } else if (!this.slime.canTarget(livingEntity)) {
                return false;
            } else {
                return --this.ticksLeft > 0;
            }
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity livingEntity = this.slime.getTarget();
            if (livingEntity != null) {
                this.slime.lookAtEntity(livingEntity, 10.0F, 10.0F);
            }

            MoveControl var3 = this.slime.getMoveControl();
            if (var3 instanceof AbyssalSlimeEntity.SlimeMoveControl slimeMoveControl) {
                slimeMoveControl.look(this.slime.getYaw(), this.slime.canAttack());
            }

        }
    }

    static class RandomLookGoal extends Goal {
        private final AbyssalSlimeEntity slime;
        private float targetYaw;
        private int timer;

        public RandomLookGoal(AbyssalSlimeEntity slime) {
            this.slime = slime;
            this.setControls(EnumSet.of(Control.LOOK));
        }

        public boolean canStart() {
            return this.slime.getTarget() == null && (this.slime.isOnGround() || this.slime.isTouchingWater() || this.slime.isInLava() || this.slime.hasStatusEffect(StatusEffects.LEVITATION)) && this.slime.getMoveControl() instanceof AbyssalSlimeEntity.SlimeMoveControl;
        }

        public void tick() {
            if (--this.timer <= 0) {
                this.timer = this.getTickCount(40 + this.slime.getRandom().nextInt(60));
                this.targetYaw = (float)this.slime.getRandom().nextInt(360);
            }

            MoveControl var2 = this.slime.getMoveControl();
            if (var2 instanceof AbyssalSlimeEntity.SlimeMoveControl slimeMoveControl) {
                slimeMoveControl.look(this.targetYaw, false);
            }

        }
    }

    static class SwimmingGoal extends Goal {
        private final AbyssalSlimeEntity slime;

        public SwimmingGoal(AbyssalSlimeEntity slime) {
            this.slime = slime;
            this.setControls(EnumSet.of(Control.JUMP, Control.MOVE));
            slime.getNavigation().setCanSwim(true);
        }

        public boolean canStart() {
            return (this.slime.isTouchingWater() || this.slime.isInLava()) && this.slime.getMoveControl() instanceof AbyssalSlimeEntity.SlimeMoveControl;
        }

        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick() {
            if (this.slime.getRandom().nextFloat() < 0.8F) {
                this.slime.getJumpControl().setActive();
            }

            MoveControl var2 = this.slime.getMoveControl();
            if (var2 instanceof AbyssalSlimeEntity.SlimeMoveControl slimeMoveControl) {
                slimeMoveControl.move(1.2);
            }

        }
    }

    static class MoveGoal extends Goal {
        private final AbyssalSlimeEntity slime;

        public MoveGoal(AbyssalSlimeEntity slime) {
            this.slime = slime;
            this.setControls(EnumSet.of(Control.JUMP, Control.MOVE));
        }

        public boolean canStart() {
            return !this.slime.hasVehicle();
        }

        public void tick() {
            MoveControl var2 = this.slime.getMoveControl();
            if (var2 instanceof AbyssalSlimeEntity.SlimeMoveControl slimeMoveControl) {
                slimeMoveControl.move(1.0F);
            }

        }
    }
}
