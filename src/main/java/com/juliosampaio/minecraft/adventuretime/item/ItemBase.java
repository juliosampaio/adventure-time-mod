package com.juliosampaio.minecraft.adventuretime.item;

import com.juliosampaio.minecraft.adventuretime.AdventureTime;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
	
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		AdventureTime.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
