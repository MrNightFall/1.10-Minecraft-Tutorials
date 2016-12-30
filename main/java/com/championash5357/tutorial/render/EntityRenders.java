package com.championash5357.tutorial.render;

import com.championash5357.tutorial.entity.EntityFourArms;
import com.championash5357.tutorial.model.ModelEntityFourArms;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityRenders {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityFourArms.class, new IRenderFactory<EntityFourArms>() {

			@Override
			public Render<? super EntityFourArms> createRenderFor(RenderManager manager) {
				return new RenderEntityFourArms(manager, new ModelEntityFourArms(), 1);
			}
		});
	}
}
