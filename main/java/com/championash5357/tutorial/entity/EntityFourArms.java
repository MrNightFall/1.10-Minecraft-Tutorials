package com.championash5357.tutorial.entity;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import com.championash5357.tutorial.init.TutorialItems;
import com.championash5357.tutorial.init.TutorialSounds;

public class EntityFourArms extends EntityMob{
	
	public EntityFourArms(World worldIn) {
		super(worldIn);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(0, new EntityAITempt(this, 0.5d, TutorialItems.structure_spawner, false));
		this.tasks.addTask(2, new EntityAIWander(this, 2.0d));
		this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 2.0d, true));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityCreeper.class, 100.0f, 2.0d, 5.0d));
		addRandomArmor();
		this.experienceValue = 200;
		this.stepHeight = 100;
	}
	
	public boolean isAIEnabled() {
		return true;
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(128.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(2.0D);
	}
	
	public void addRandomArmor() {
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
		this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
	}
	
	protected Item getDropItem() {
		return TutorialItems.purple_glowstone_dust;
	}
	
	protected void dropRareDrop(int item) {
		this.dropItem(TutorialItems.structure_spawner, 1);
	}
	
	protected SoundEvent getAmbientSound() {
        return TutorialSounds.TutorialLive;
    }

    protected SoundEvent getHurtSound() {
        return TutorialSounds.TutorialHurt;
    }

    protected SoundEvent getDeathSound() {
        return TutorialSounds.TutorialDeath;
    }
    
    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack stack) {
    	if(stack != null && stack.getItem() == Items.SPAWN_EGG) {
    		return super.processInteract(player, hand, stack);
    	} else {
    		if(!this.isBeingRidden()) {
    			if(stack != null && stack.interactWithEntity(player, this, hand)) {
    				return true;
    			} else {
    				this.mountTo(player);
    				Minecraft.getMinecraft().gameSettings.thirdPersonView = 1;
    				return true;
    			}
    		} else {
    			return super.processInteract(player, hand, stack);
    		}
    	}
    }
    
    private void mountTo(EntityPlayer player) {
    	player.rotationYaw = this.rotationYaw;
    	player.rotationPitch = this.rotationPitch;
    	
    	if(!this.worldObj.isRemote) {
    		player.startRiding(this);
    	}
    }
    
    public boolean canBeSteered() {
    	Entity entity = this.getControllingPassenger();
    	return entity instanceof EntityLivingBase;
    }
    
    @Override
    public void moveEntityWithHeading(float strafe, float forward) {
    	if(this.isBeingRidden() && this.canBeSteered()) {
    		EntityLivingBase entitylivingbase = (EntityLivingBase)this.getControllingPassenger();
    		this.rotationYaw = entitylivingbase.rotationYaw;
    		this.prevRotationYaw = this.rotationYaw;
    		this.rotationPitch = entitylivingbase.rotationPitch * 0.5f;
    		this.setRotation(this.rotationYaw, this.rotationPitch);
    		this.renderYawOffset = this.rotationYaw;
    		this.rotationYawHead = this.renderYawOffset;
    		strafe = entitylivingbase.moveStrafing * 0.5f;
    		forward = entitylivingbase.moveForward;
    		
    		if(forward <= 0.0f) {
    			forward *= 0.25f;
    		}
    		
    		this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1f;
    		
    		if(this.canPassengerSteer()) {
    			this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
    			super.moveEntityWithHeading(strafe, forward);
    		} else if (entitylivingbase instanceof EntityPlayer) {
    			this.motionX = 0.0d;
    			this.motionY = 0.0d;
    			this.motionZ = 0.0d;
    		}
    		
    		this.prevLimbSwingAmount = this.limbSwingAmount;
    		double d1 = this.posX - this.prevPosX;
    		double d0 = this.posZ - this.prevPosZ;
    		float f2 = MathHelper.sqrt_double(d1 * d1 + d0 * d0) * 4.0f;
    		
    		if(f2 > 1.0f) {
    			f2 = 1.0f;
    		}
    		
    		this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4f;
    		this.limbSwing += this.limbSwingAmount;
    	} else {
    		this.jumpMovementFactor = 0.02f;
    		super.moveEntityWithHeading(strafe, forward);
    	}
    }
    
    @Nullable
    public Entity getControllingPassenger() {
    	return this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
    }
}
