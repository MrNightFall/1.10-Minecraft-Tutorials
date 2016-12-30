package com.championash5357.tutorial.render;

import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.entity.EntityFourArms;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEntityFourArms extends RenderLiving{
	
	private static final ResourceLocation EntityFourArmsTextures = new ResourceLocation(Reference.MOD_ID + ":textures/entity/four_arms.png");
	
	public RenderEntityFourArms(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
	}
	
	protected ResourceLocation getEntityTexture(EntityFourArms entity)
    {
        return EntityFourArmsTextures;
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityFourArms)entity);
	}
}
