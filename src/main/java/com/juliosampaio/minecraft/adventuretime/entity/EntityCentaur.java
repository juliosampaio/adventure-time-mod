package com.juliosampaio.minecraft.adventuretime.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCentaur extends EntityCow implements IAdventureTimeEntity<EntityCow>{

	public EntityCentaur(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public EntityCow createChild(EntityAgeable ageable) {
		return new EntityCentaur(world);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		// TODO Auto-generated method stub
		return super.getAmbientSound();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		// TODO Auto-generated method stub
		return super.getHurtSound(damageSourceIn);
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		// TODO Auto-generated method stub
		return super.getDeathSound();
	}
	
	@Override
	public String getEntityName() {
		return "centaur";
	}

	@Override
	public int getId() {
		return 120;
	}

	@Override
	public int getRange() {
		return 50;
	}

	@Override
	public int getEggColorPrimary() {
		return 11437146;
	}

	@Override
	public int getEggColorSecondary() {
		return 0;
	}

	@Override
	public EntityCow getInstance() {
		return this;
	}


}
