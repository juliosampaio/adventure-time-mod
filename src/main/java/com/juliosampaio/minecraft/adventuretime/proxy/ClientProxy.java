package com.juliosampaio.minecraft.adventuretime.proxy;

import com.juliosampaio.minecraft.adventuretime.item.ItemBase;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerItemRenderer(Item itemBase, int metadata, String location) {
		ModelLoader.setCustomModelResourceLocation(itemBase, metadata,
				new ModelResourceLocation(itemBase.getRegistryName(), location));
	}
}
