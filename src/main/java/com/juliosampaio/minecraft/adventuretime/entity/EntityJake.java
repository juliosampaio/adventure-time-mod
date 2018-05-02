package com.juliosampaio.minecraft.adventuretime.entity;

import com.juliosampaio.minecraft.adventuretime.ai.path.AIFollowTarget;
import com.juliosampaio.minecraft.adventuretime.ai.path.AIPathNavigate;
import com.juliosampaio.minecraft.adventuretime.ai.path.IFollower;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityJake extends EntityMob implements IFollower {

	public EntityJake(World worldIn) {
		super(worldIn);
		this.setSize(1, 1);
	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		//TODO: change the follow approach for: https://www.spigotmc.org/threads/pets-that-spawn-by-player-and-follow-them.33874/
		this.tasks.addTask(2, new AIFollowTarget(this, 1.2F, 10.0F, 2.0F));
		this.tasks.addTask(6, new EntityAIWander(this, 0.3D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	}

	@Override
	public EntityPlayer getTarget() {
		
		return this.world.playerEntities.get(0);
	}

	@Override
	public AIPathNavigate getNavigator() {
		// TODO Auto-generated method stub
		return ((EntityMob)this).getNavigator();
	}

	@Override
	public int getFollowRange() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWorking(boolean b) {

	}

	@Override
	public boolean isFollowingMaster() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isReturningGoods() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getDistanceSqToEntity(Entity master2) {
		return 100;
	}

}
