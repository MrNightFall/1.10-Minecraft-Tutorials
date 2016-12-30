package com.championash5357.tutorial.init;

import com.championash5357.tutorial.block.BlockColoredGlowstone;
import com.championash5357.tutorial.block.BlockColoredGlowstoneDoubleSlab;
import com.championash5357.tutorial.block.BlockColoredGlowstoneHalfSlab;
import com.championash5357.tutorial.block.BlockEndTutorialPortal;
import com.championash5357.tutorial.block.BlockPurpleGlowstone;
import com.championash5357.tutorial.block.BlockStrawberry;
import com.championash5357.tutorial.block.BlockTable;
import com.championash5357.tutorial.block.BlockTutorialPortal;
import com.championash5357.tutorial.block.ItemBlockColoredGlowstone;
import com.championash5357.tutorial.block.ItemBlockColoredGlowstoneSlab;
import com.championash5357.tutorial.block.metadata.BlockMetadataBlock;
import com.championash5357.tutorial.block.metadata.ItemBlockMetadataBlock;
import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.enums.BlockMetadataType;
import com.championash5357.tutorial.enums.ColoredGlowstoneType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class TutorialBlocks {
	
	public static Block purple_glowstone;
	public static Block table;
	public static Block strawberry_crop;
	public static BlockTutorialPortal tutorial_portal_block;
	public static BlockEndTutorialPortal tutorial_end_portal_block;
	public static Block metadata_block;
	public static Block colored_glowstone;
	public static BlockSlab colored_glowstone_half_slab;
	public static BlockSlab colored_glowstone_double_slab;
	
	public static void init() {
		colored_glowstone = new BlockColoredGlowstone();
		colored_glowstone_half_slab = (BlockSlab) new BlockColoredGlowstoneHalfSlab().setUnlocalizedName("colored_glowstone_half_slab").setRegistryName("BlockColoredGlowstoneHalfSlab");
		colored_glowstone_double_slab = (BlockSlab) new BlockColoredGlowstoneDoubleSlab().setUnlocalizedName("colored_glowstone_half_slab").setRegistryName("BlockColoredGlowstoneDoubleSlab");
	}
	
	public static void register() {
		GameRegistry.registerBlock(purple_glowstone = new BlockPurpleGlowstone(Material.GLASS), purple_glowstone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(table = new BlockTable(Material.WOOD), table.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(strawberry_crop = new BlockStrawberry(), strawberry_crop.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tutorial_portal_block = new BlockTutorialPortal(), tutorial_portal_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tutorial_end_portal_block = new BlockEndTutorialPortal(), tutorial_end_portal_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(metadata_block = new BlockMetadataBlock("metadata_block"), ItemBlockMetadataBlock.class, metadata_block.getUnlocalizedName().substring(5));
		GameRegistry.register(colored_glowstone);
		ItemBlock itemcg = new ItemBlockColoredGlowstone(colored_glowstone);
		itemcg.setRegistryName(colored_glowstone.getRegistryName());
		GameRegistry.register(itemcg);
		OreDictionary.registerOre("logWood", table);
		registerSlabBlock(colored_glowstone_half_slab);
		registerSlabBlock(colored_glowstone_double_slab);
	}
	
	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	private static void registerSlabBlock(Block block) {
		GameRegistry.register(block);
		ItemBlock item = new ItemBlockColoredGlowstoneSlab(block, colored_glowstone_half_slab, colored_glowstone_double_slab);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRenders() {
		registerRender(purple_glowstone);
		registerRender(table);
		registerRender(strawberry_crop);
		registerRender(tutorial_portal_block);
		registerRender(tutorial_end_portal_block);
		
		for(int i = 0; i < BlockMetadataType.values().length; i++) {
			registerRender(metadata_block, i, BlockMetadataType.values()[i].getName() + "_" + metadata_block.getUnlocalizedName().substring(5));
		}
		
		for(int i = 0; i < ColoredGlowstoneType.values().length; i++)
			registerRender(colored_glowstone, i, ColoredGlowstoneType.values()[i].getName() + "_" + colored_glowstone.getUnlocalizedName().substring(5));
		
		for(int i = 0; i < ColoredGlowstoneType.values().length; i++) {
			registerRender(colored_glowstone_half_slab, i, ColoredGlowstoneType.values()[i].getName() + "_" + colored_glowstone_half_slab.getUnlocalizedName().substring(5));
			registerRender(colored_glowstone_half_slab, i, ColoredGlowstoneType.values()[i].getName() + "_" + colored_glowstone_half_slab.getUnlocalizedName().substring(5) + "_top");
			registerRender(colored_glowstone_half_slab, i, ColoredGlowstoneType.values()[i].getName() + "_" + colored_glowstone_half_slab.getUnlocalizedName().substring(5) + "_bottom");
		}
		
		for(int i = 0; i < ColoredGlowstoneType.values().length; i++)
			registerRender(colored_glowstone_double_slab, i, ColoredGlowstoneType.values()[i].getName() + "_" + colored_glowstone.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerRender(Block block, int meta, String file) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + file, "inventory"));
	}
}
