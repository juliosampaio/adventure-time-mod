package com.juliosampaio.minecraft.adventuretime.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.juliosampaio.minecraft.adventuretime.AdventureTime;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
	
	public static void registerEntities() {
		registerEntity("centaur", EntityCentaur.class, 120, 50, 11437146, 000000);
		registerEntity("jake", EntityJake.class, 121, 50, 11437146, 000000);
	}

	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range,
			int eggColorPrimary, int eggColorSecondary) {
		EntityRegistry.registerModEntity(new ResourceLocation(AdventureTime.MODID + ":" + name), entity, name, id,
				AdventureTime.instance, range, 1, true, eggColorPrimary, eggColorSecondary);
	}

}
