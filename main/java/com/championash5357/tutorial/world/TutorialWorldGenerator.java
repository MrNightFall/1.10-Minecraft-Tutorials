package com.championash5357.tutorial.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import com.championash5357.tutorial.init.TutorialBlocks;

public class TutorialWorldGenerator implements IWorldGenerator{
	//@formatter:off
	
	private WorldGenerator gen_purple_glowstone;
	DirtHouse house = new DirtHouse();
	//@formatter:on
	
	public TutorialWorldGenerator() {
		this.gen_purple_glowstone = new WorldGenMinable(TutorialBlocks.purple_glowstone.getDefaultState(), 6, BlockMatcher.forBlock(Blocks.AIR));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {		
		switch (world.provider.getDimension()) {
		case 0: //Overworld
			this.runStructureGrassPlains(world, random, chunkX, chunkZ);
			break;
		case -1: //Nether
			this.runGenerator(this.gen_purple_glowstone, world, random, chunkX, chunkZ, 16, 30, 128);
			break;
		case 1: //End
			
			break;
		}
	}
	
	public void runStructureGrassPlains(World world, Random random, int chunk_X, int chunk_Z) {		
		int x = chunk_X * 16 + random.nextInt(16);
		int z = chunk_Z * 16 + random.nextInt(16);
		int xy = x >> 4;
		int zy = z >> 4;
		int height = world.getChunkFromChunkCoords(xy, zy).getHeight(new BlockPos(x & 15, 0, z & 15));
		int y = height - 1;
		if(world.getBiomeGenForCoords(new BlockPos(x,y,z)).getBiomeClass().equals(BiomePlains.class)) {
			if((random.nextInt(1000) + 1) <= 10) {
				boolean place = true;
			
				for(int j = 0; j < 3; j++) {
					for(int k = 0; k < 3; k++) {
						for(int i = 0; i < 3; i++) {
							if(world.getBlockState(new BlockPos(x + i, y + j + 1, z + k)).getBlock() != Blocks.AIR) {
								place = false;
							}
						}
					}
				}
				if(place) {
					DirtHouse house = new DirtHouse();
					house.generate(world, random, new BlockPos(x,y,z));
				}
			}
		}
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random random, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
		
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunk_X * 16 + random.nextInt(16);
			int y = minHeight + random.nextInt(heightDiff);
			int z = chunk_Z * 16 + random.nextInt(16);
			generator.generate(world, random, new BlockPos(x, y, z));
		}
	}
}
