package com.juliosampaio.minecraft.adventuretime.entity;

import net.minecraft.entity.Entity;

public interface IAdventureTimeEntity<T extends Entity> {
	
	public String getEntityName();

	public int getId();

	public int getRange();

	public int getEggColorPrimary();

	public int getEggColorSecondary();
	
	public T getInstance();
}
