package com.championash5357.tutorial.world.biome;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeTutorialBiome extends Biome {

	public BiomeTutorialBiome(BiomeProperties properties) {
		super(properties);
		this.topBlock = Blocks.COMMAND_BLOCK.getDefaultState();
		this.fillerBlock = Blocks.BRICK_BLOCK.getDefaultState();
		
		this.theBiomeDecorator.dirtGen = new WorldGenMinable(Blocks.DIRT.getDefaultState(), 16);
		this.theBiomeDecorator.sandGen = new WorldGenMinable(Blocks.SAND.getDefaultState(), 16);
		this.theBiomeDecorator.cactiPerChunk = 2;
		this.theBiomeDecorator.grassPerChunk = 16;
		this.theBiomeDecorator.clayPerChunk = 5;
		this.theBiomeDecorator.treesPerChunk = 1;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityWither.class, 95, 1, 1));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDragon.class, 95, 1, 1));
	}
}
