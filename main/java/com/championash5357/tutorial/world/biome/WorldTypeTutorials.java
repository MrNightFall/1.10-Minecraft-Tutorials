package com.championash5357.tutorial.world.biome;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class WorldTypeTutorials extends WorldType{

	public WorldTypeTutorials(String name) {
		super(name);
	}
	
	public GenLayer getBiomeLayer(long worldSeed, net.minecraft.world.gen.layer.GenLayer parentLayer, String chunkProviderSettingsJson) {
        GenLayer ret = new TutorialsGenLayerBiome(200L, parentLayer, this, chunkProviderSettingsJson);
        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdge(1000L, ret);
        return ret;
    }
}
