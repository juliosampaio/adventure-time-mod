package com.juliosampaio.minecraft.adventuretime.entity.render;

import com.juliosampaio.minecraft.adventuretime.AdventureTime;
import com.juliosampaio.minecraft.adventuretime.entity.EntityCentaur;
import com.juliosampaio.minecraft.adventuretime.entity.model.ModelCentaur;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCentaur extends RenderLiving<EntityCentaur> {
	private static final ResourceLocation TEXTURES = new ResourceLocation(
			AdventureTime.MODID + ":textures/entity/centaur.png");

	public RenderCentaur(RenderManager manager) {
		super(manager, new ModelCentaur(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCentaur entity) {
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntityCentaur entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
