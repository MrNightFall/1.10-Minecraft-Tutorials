package com.championash5357.tutorial.world.biome;

import com.championash5357.tutorial.client.ConfigHandler;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class TutorialBiomeRegistry {
	
	public static void MainRegistry() {
		initializeBiome();
		registerBiome();
	}
	
	public static Biome tutorial_biome;
	public static final int biomeID = ConfigHandler.tutorialIslandBiomeId;
	
	public static Biome tutorial;
	public static final int tutorialBiomeID = ConfigHandler.tutorialBiomeId;
	
	public static void initializeBiome() {
		tutorial_biome = new BiomeTutorial(new BiomeProperties("Tutorial Island").setTemperature(1.2f).setRainfall(0.9f).setWaterColor(16720774).setBaseHeight(1.5f).setHeightVariation(1.0f));
		Biome.registerBiome(biomeID, "Tutorial Island", tutorial_biome);
		tutorial = new BiomeTutorialBiome(new BiomeProperties("Tutorial").setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
		Biome.registerBiome(tutorialBiomeID, "Tutorial", tutorial);
	}
	
	public static void registerBiome() {
		BiomeDictionary.registerBiomeType(tutorial_biome, Type.MOUNTAIN);
		BiomeManager.addSpawnBiome(tutorial_biome);
		BiomeDictionary.registerBiomeType(tutorial, Type.MESA);
		BiomeManager.addSpawnBiome(tutorial);
	}
	
}