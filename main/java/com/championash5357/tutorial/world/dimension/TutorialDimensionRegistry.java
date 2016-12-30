package com.championash5357.tutorial.world.dimension;

import com.championash5357.tutorial.client.ConfigHandler;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class TutorialDimensionRegistry {
	
	public static void MainRegistry() {
		registerDimension();
	}
	
	public static final int tutorialDimensionID = ConfigHandler.tutorialDimensionId;
	public static final DimensionType TUTORIAL = DimensionType.register("Tutorial", "_tutorial", tutorialDimensionID, DimensionTypeTutorial.class, false);
	public static final int tutorialEndDimensionID = ConfigHandler.tutorialEndId;
	public static final DimensionType TUTORIALEND = DimensionType.register("Tutorial End", "_tutorialend", tutorialEndDimensionID, DimensionTypeTutorialEnd.class, false);
	
	public static void registerDimension() {
		DimensionManager.registerDimension(tutorialDimensionID, TUTORIAL);
		DimensionManager.registerDimension(tutorialEndDimensionID, TUTORIALEND);
	}
}
