package com.championash5357.tutorial.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.championash5357.tutorial.init.TutorialBlocks;
import com.championash5357.tutorial.world.biome.BiomeTutorial;
import com.championash5357.tutorial.world.dimension.TutorialDimensionRegistry;

public class TutorialStructureGenerator implements IWorldGenerator{
	//@formatter:off
	
	House house = new House();
	
	//@formatter:on
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
		case 0: //Overworld
			this.runHouseGenerator(world, random, chunkX, chunkZ);
			break;
		case -1: //Nether
			
			break;
		case 1: //End
			
			break;
		}
	}
	
	public void runHouseGenerator(World world, Random random, int chunkX, int chunkZ) {
		int x = chunkX * 16 + random.nextInt(16);
		int z = chunkZ * 16 + random.nextInt(16);
		int xy = x >> 4;
		int zy = z >> 4;
		int height = world.getChunkFromChunkCoords(xy, zy).getHeight(new BlockPos(x & 15, 0, z & 15));
		int y = height - 1;
		if(world.getBlockState(new BlockPos(x,y,z)).getBlock() == Blocks.GRASS || world.getBlockState(new BlockPos(x,y,z)).getBlock() == TutorialBlocks.purple_glowstone) {
			if(world.getBiomeGenForCoords(new BlockPos(x,y,z)).getBiomeClass().equals(BiomePlains.class) || world.getBiomeGenForCoords(new BlockPos(x,y,z)).getBiomeClass().equals(BiomeTutorial.class)) {
				if((random.nextInt(1000) + 1) <= 10) {
					boolean place = true;
		
					for(int j = 0; j < 6; j++) {
						for(int k = 0; k < 9; k++) {
							for(int i = 0; i < 11; i++) {
								if(world.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock() != Blocks.AIR) {
									place = false;
								}
							}
						}
					}
					if(place) {
						house.generate(world, random, new BlockPos(x,y,z));
					}
				}
			}
		}
	}
}
