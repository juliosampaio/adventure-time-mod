package com.juliosampaio.minecraft.adventuretime.ai.path;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public abstract class AbstractFollower extends Entity implements IFollower {

	public Object returnChestOrInventory;

	public AbstractFollower(World worldIn) {
		super(worldIn);
	}
	
}
