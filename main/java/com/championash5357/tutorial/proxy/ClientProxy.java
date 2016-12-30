package com.championash5357.tutorial.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.entity.EntityFourArms;
import com.championash5357.tutorial.init.TutorialBlocks;
import com.championash5357.tutorial.init.TutorialItems;
import com.championash5357.tutorial.model.ModelEntityFourArms;
import com.championash5357.tutorial.render.RenderEntityFourArms;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders() {
		TutorialBlocks.registerRenders();
		TutorialItems.registerRenders();
		ModelBakery.registerItemVariants(Item.getItemFromBlock(TutorialBlocks.metadata_block), new ResourceLocation(Reference.MOD_ID + ":" + "white_metadata_block"), new ResourceLocation(Reference.MOD_ID + ":" + "black_metadata_block"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(TutorialBlocks.colored_glowstone), 
				new ResourceLocation(Reference.MOD_ID + ":" + "white_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "orange_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "magenta_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "light_blue_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "yellow_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "lime_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "pink_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "gray_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "light_gray_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "cyan_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "purple_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "blue_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "brown_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "green_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "red_colored_glowstone"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "black_colored_glowstone"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(TutorialBlocks.colored_glowstone_half_slab), 
				new ResourceLocation(Reference.MOD_ID + ":" + "white_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "orange_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "magenta_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "light_blue_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "yellow_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "lime_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "pink_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "gray_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "light_gray_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "cyan_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "purple_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "blue_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "brown_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "green_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "red_colored_glowstone_half_slab"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "black_colored_glowstone_half_slab"),
				new ResourceLocation(Reference.MOD_ID + ":" + "white_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "orange_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "magenta_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "light_blue_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "yellow_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "lime_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "pink_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "gray_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "light_gray_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "cyan_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "purple_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "blue_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "brown_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "green_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "red_colored_glowstone_half_slab_top"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "black_colored_glowstone_half_slab_top"),
				new ResourceLocation(Reference.MOD_ID + ":" + "white_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "orange_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "magenta_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "light_blue_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "yellow_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "lime_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "pink_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "gray_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "light_gray_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "cyan_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "purple_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "blue_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "brown_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "green_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "red_colored_glowstone_half_slab_bottom"), 
				new ResourceLocation(Reference.MOD_ID + ":" + "black_colored_glowstone_half_slab_bottom"));
	}
}
