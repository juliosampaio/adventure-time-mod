package com.juliosampaio.minecraft.adventuretime.ai.path;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class AIFollowTarget extends EntityAIBase {

	private final IFollower follower;
	private final float followSpeed;
	private final AIPathNavigate petPathfinder;
	private final float maxDist;
	private final float minDist;
	private boolean isAvoidingWater;

	private int updateTicker;
	private final double followRangeSq;

	public AIFollowTarget(IFollower follower, float movespeed, float min, float max) {
		this.follower = follower;
		this.followSpeed = movespeed;
		this.petPathfinder = follower.getNavigator();
		this.minDist = min;
		this.maxDist = max;
		this.setMutexBits(3);
		this.followRangeSq = follower.getFollowRange() * follower.getFollowRange();
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	@Override
	public boolean shouldExecute() {
		return follower.getTarget() != null
				&& follower.getDistanceSqToEntity(follower.getTarget()) > (double) (this.minDist * this.minDist)
				&& shouldFollowMaster();
	}

	@Override
	public boolean shouldContinueExecuting() {
		return !this.petPathfinder.noPath()
				&& this.follower.getDistanceSqToEntity(follower.getTarget()) > (double) (this.maxDist * this.maxDist)
				&& shouldFollowMaster();
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	@Override
	public void startExecuting() {
		this.updateTicker = 0;
		this.isAvoidingWater = this.follower.getNavigator().getAvoidsWater();
		this.follower.getNavigator().setAvoidsWater(false);
		follower.setWorking(false);
	}

	/**
	 * Resets the task
	 */
	@Override
	public void resetTask() {
		this.petPathfinder.clearPathEntity();
		this.follower.getNavigator().setAvoidsWater(this.isAvoidingWater);
	}

	/**
	 * Updates the task
	 */
	@Override
	public void updateTask() {

		((Entity)follower).applyOrientationToEntity(follower.getTarget());

		if (shouldFollowMaster()) {
			if (--updateTicker <= 0) {
				updateTicker = 30;

				if (!petPathfinder.tryMoveToEntityLiving(follower.getTarget(), followSpeed)) {
					if (follower.getDistanceSqToEntity(follower.getTarget()) >= followRangeSq) {
						int x = MathHelper.floor(follower.getTarget().posX) - 2;
						int z = MathHelper.floor(follower.getTarget().posZ) - 2;
						int y = MathHelper.floor(follower.getTarget().getEntityBoundingBox().minY);

						for (int xIter = 0; xIter <= 4; ++xIter) {
							for (int zIter = 0; zIter <= 4; ++zIter) {
								if ((xIter < 1 || zIter < 1 || xIter > 3 || zIter > 3)
										&& ((Entity)follower).world.getBlockState(new BlockPos(x + xIter, y - 1, z + zIter))
												.isNormalCube()
										&& !((Entity)follower).world.getBlockState(new BlockPos(x + xIter, y, z + zIter))
												.isNormalCube()
										&& !((Entity)follower).world.getBlockState(new BlockPos(x + xIter, y + 1, z + zIter))
												.isNormalCube()) {
									((Entity)follower).setLocationAndAngles((double) (x + xIter) + 0.5D, (double) y,
											(double) (z + zIter) + 0.5D, ((Entity)follower).rotationYaw, ((Entity)follower).rotationPitch);
									petPathfinder.clearPathEntity();
									return;
								}
							}
						}
					}
				}
			}
		}
	}

	private boolean shouldFollowMaster() {
		return follower.isFollowingMaster() || (follower.isReturningGoods() && follower.returnChestOrInventory == null);
	}
}
