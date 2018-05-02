package com.juliosampaio.minecraft.adventuretime.util;

import com.juliosampaio.minecraft.adventuretime.entity.EntityCentaur;
import com.juliosampaio.minecraft.adventuretime.entity.EntityJake;
import com.juliosampaio.minecraft.adventuretime.entity.render.RenderCentaur;
import com.juliosampaio.minecraft.adventuretime.entity.render.RenderJake;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityCentaur.class, new IRenderFactory<EntityCentaur>() {
			@Override
			public Render<? super EntityCentaur> createRenderFor(RenderManager manager) {
				return new RenderCentaur(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityJake.class, new IRenderFactory<EntityJake>() {
			@Override
			public Render<? super EntityJake> createRenderFor(RenderManager manager) {
				return new RenderJake(manager);
			}
		});
	}
}
