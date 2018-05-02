package com.juliosampaio.minecraft.adventuretime.entity.render;

import com.juliosampaio.minecraft.adventuretime.AdventureTime;
import com.juliosampaio.minecraft.adventuretime.entity.EntityJake;
import com.juliosampaio.minecraft.adventuretime.entity.model.ModelJake;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderJake extends RenderLiving<EntityJake> {

	private static final ResourceLocation TEXTURES = new ResourceLocation(
			AdventureTime.MODID + ":textures/entity/jake.png");

	public RenderJake(RenderManager manager) {
		super(manager, new ModelJake(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityJake entity) {
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityJake entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
