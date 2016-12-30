package com.championash5357.tutorial.world.biome;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import com.championash5357.tutorial.entity.EntityFourArms;
import com.championash5357.tutorial.init.TutorialBlocks;

public class BiomeTutorial extends Biome {

	public BiomeTutorial(BiomeProperties properties) {
		super(properties);
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 5;
		this.theBiomeDecorator.flowersPerChunk = 2;
		this.theBiomeDecorator.cactiPerChunk = 1;
		this.theBiomeDecorator.clayPerChunk = 1;
		this.theBiomeDecorator.deadBushPerChunk = 5;
		this.theBiomeDecorator.mushroomsPerChunk = 2;
		
		this.topBlock = TutorialBlocks.purple_glowstone.getDefaultState();
		this.fillerBlock = Blocks.AIR.getDefaultState();
		this.spawnableCaveCreatureList.removeAll(spawnableCaveCreatureList);
		this.spawnableMonsterList.removeAll(spawnableMonsterList);
		this.spawnableWaterCreatureList.removeAll(spawnableWaterCreatureList);
		this.spawnableCreatureList.removeAll(spawnableCreatureList);
		this.spawnableCreatureList.add(new SpawnListEntry(EntityFourArms.class, 5, 1, 2));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDragon.class, 1, 1, 1));
	}
}
