package com.juliosampaio.minecraft.adventuretime.util;

import com.juliosampaio.minecraft.adventuretime.entity.ModEntities;
import com.juliosampaio.minecraft.adventuretime.item.IHasModel;
import com.juliosampaio.minecraft.adventuretime.item.ModItems;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Item item : ModItems.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel) item).registerModels();
			}
		}
	}
	
	public static void preInitRegistries() {
		ModEntities.registerEntities();
		RenderHandler.registerEntityRenders();
	}
	
	public static void initRegistries() {
		
	}
	
	public static void postInitRegistries() {
		
	}
}
