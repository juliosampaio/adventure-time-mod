package com.juliosampaio.minecraft.adventuretime.ai.path;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IFollower{
	
	Object returnChestOrInventory = null;
	EntityPlayer getTarget();
	AIPathNavigate getNavigator();
	int getFollowRange();
	double getDistanceSqToEntity(Entity master2);
	void setWorking(boolean b);
	public boolean isFollowingMaster();
	public boolean isReturningGoods();

}
