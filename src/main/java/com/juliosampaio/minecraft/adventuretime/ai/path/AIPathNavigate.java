package com.juliosampaio.minecraft.adventuretime.ai.path;

import net.minecraft.entity.EntityLiving;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.world.World;

public abstract class AIPathNavigate extends PathNavigate {
	
	public AIPathNavigate(EntityLiving entityIn, World worldIn) {
		super(entityIn, worldIn);
	}

	public abstract boolean getAvoidsWater();

	public abstract void setAvoidsWater(boolean avoids);

	public void clearPathEntity() {
		// TODO Auto-generated method stub
		
	}
}
