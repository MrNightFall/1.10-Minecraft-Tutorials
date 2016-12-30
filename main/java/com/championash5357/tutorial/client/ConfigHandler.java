package com.championash5357.tutorial.client;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static Configuration config;
	
	//Settings
	public static int tutorialIslandBiomeId;
	public static int tutorialBiomeId;
	
	public static int tutorialDimensionId;
	public static int tutorialEndId;
	
	public static void init(File file) {
		config = new Configuration(file);
		syncConfig();
	}
	
	public static void syncConfig() {
		String category;
		
		category = "Biome";
		config.addCustomCategoryComment(category, "Biome Settings");
		tutorialIslandBiomeId = config.getInt("tutorialIslandBiomeId", category, 40, 40, 126, "The biome id of Tutorial Island.");
		tutorialBiomeId = config.getInt("tutorialBiomeId", category, 41, 40, 126, "The biome id of Tutorial.");
		
		category = "Dimension";
		config.addCustomCategoryComment(category, "Dimension Settings");
		tutorialDimensionId = config.getInt("tutorialDimensionId", category, 2, 2, 100, "The dimension id of Tutorial Dimension.");
		tutorialEndId = config.getInt("tutorialEndId", category, 3, 2, 100, "The id for the Tutorial End Dimension");
		
		config.save();
	}
}
