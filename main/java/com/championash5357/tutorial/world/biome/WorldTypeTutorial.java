package com.championash5357.tutorial.world.biome;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class WorldTypeTutorial extends WorldType{
	
	public WorldTypeTutorial(String name) {
		super(name);
	}
	
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, String chunkProviderSettingsJson)
    {
        GenLayer ret = new TutorialGenLayerBiome(200L, parentLayer, this, chunkProviderSettingsJson);
        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdge(1000L, ret);
        return ret;
    }
}
