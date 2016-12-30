package com.championash5357.tutorial.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TutorialDimensionHouse extends WorldGenerator{

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int x1 = position.getX();
		int z1 = position.getZ();
		int x = x1  + rand.nextInt(15);
		int z = z1  + rand.nextInt(15);
		int y = worldIn.getChunkFromChunkCoords(x, z).getHeight(new BlockPos(x & 15, 0, z & 15)) - 1;
		if((rand.nextInt(1000) + 1) <= 10) {
			boolean place = true;

			for(int j = 0; j < 6; j++) {
				for(int k = 0; k < 9; k++) {
					for(int i = 0; i < 11; i++) {
						if(worldIn.getBlockState(new BlockPos(i + x, j + y + 1, k + z)).getBlock() != Blocks.AIR) {
							place = false;
						}
					}
				}
			}
			if(place) {
				//Front Porch
				worldIn.setBlockState(new BlockPos(x+1,y+1,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+2,y+1,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+1,y+1,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+2,y+1,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+1,y+1,z+4), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+2,y+1,z+4), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+1,y+1,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+2,y+1,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+1,y+1,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+2,y+1,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x,y+1,z+3), Blocks.OAK_STAIRS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x,y+1,z+4), Blocks.OAK_STAIRS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x,y+1,z+5), Blocks.OAK_STAIRS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+1,y+2,z+2), Blocks.OAK_FENCE.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+1,y+3,z+2), Blocks.OAK_FENCE.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+1,y+4,z+2), Blocks.OAK_FENCE.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+2,y+2,z+2), Blocks.OAK_FENCE.getDefaultState());
				worldIn.setBlockState(new BlockPos(x,y+1,z+5), Blocks.OAK_STAIRS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+1,y+2,z+6), Blocks.OAK_FENCE.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+1,y+3,z+6), Blocks.OAK_FENCE.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+1,y+4,z+6), Blocks.OAK_FENCE.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+2,y+2,z+6), Blocks.OAK_FENCE.getDefaultState());
				//Walls
				worldIn.setBlockState(new BlockPos(x+3,y+1,z+1), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+2,z+1), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+3,z+1), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+4,z+1), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+1,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+1,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+1,z+4), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+1,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+1,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+2,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+2,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+2,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+2,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+3,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+3,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+3,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+3,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+4,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+4,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+4,z+4), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+4,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+4,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+1,z+7), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+2,z+7), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+3,z+7), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+3,y+4,z+7), Blocks.LOG.getStateFromMeta(0));
				ItemDoor.placeDoor(worldIn, new BlockPos(x+3,y+2,z+4), EnumFacing.EAST, Blocks.OAK_DOOR, false);
				worldIn.setBlockState(new BlockPos(x+2,y+3,z+3), Blocks.TORCH.getStateFromMeta(2));
				worldIn.setBlockState(new BlockPos(x+2,y+3,z+5), Blocks.TORCH.getStateFromMeta(2));
				worldIn.setBlockState(new BlockPos(x+4,y+1,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+1,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+6,y+1,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+7,y+1,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+1,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+4,y+2,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+2,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+6,y+2,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+7,y+2,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+2,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+4,y+3,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+3,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+4,y+4,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+4,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+6,y+4,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+7,y+4,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+4,z+1), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+3,z+1), Blocks.GLASS.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+6,y+3,z+1), Blocks.GLASS.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+7,y+3,z+1), Blocks.GLASS.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+4,y+1,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+1,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+6,y+1,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+7,y+1,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+1,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+4,y+2,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+2,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+6,y+2,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+7,y+2,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+2,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+4,y+3,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+3,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+4,y+4,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+4,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+6,y+4,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+7,y+4,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+4,z+7), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+3,z+7), Blocks.GLASS.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+6,y+3,z+7), Blocks.GLASS.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+7,y+3,z+7), Blocks.GLASS.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+9,y+1,z+1), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+2,z+1), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+3,z+1), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+4,z+1), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+1,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+1,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+1,z+4), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+1,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+1,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+2,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+2,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+2,z+4), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+2,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+2,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+3,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+3,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+4,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+4,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+4,z+4), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+4,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+4,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+3,z+3), Blocks.GLASS.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+9,y+3,z+4), Blocks.GLASS.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+9,y+3,z+5), Blocks.GLASS.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+9,y+1,z+7), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+2,z+7), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+3,z+7), Blocks.LOG.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+9,y+4,z+7), Blocks.LOG.getStateFromMeta(0));
				//Floor
				worldIn.setBlockState(new BlockPos(x+4,y+1,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+4,y+1,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+4,y+1,z+4), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+4,y+1,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+4,y+1,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+1,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+1,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+1,z+4), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+1,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+5,y+1,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+6,y+1,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+6,y+1,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+6,y+1,z+4), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+6,y+1,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+6,y+1,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+7,y+1,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+7,y+1,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+7,y+1,z+4), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+7,y+1,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+7,y+1,z+6), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+1,z+2), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+1,z+3), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+1,z+4), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+1,z+5), Blocks.PLANKS.getStateFromMeta(0));
				worldIn.setBlockState(new BlockPos(x+8,y+1,z+6), Blocks.PLANKS.getStateFromMeta(0));
				//Inside
				worldIn.setBlockState(new BlockPos(x+8,y+4,z+2), Blocks.TORCH.getStateFromMeta(2));
				worldIn.setBlockState(new BlockPos(x+8,y+4,z+6), Blocks.TORCH.getStateFromMeta(2));
				worldIn.setBlockState(new BlockPos(x+4,y+4,z+2), Blocks.TORCH.getStateFromMeta(1));
				worldIn.setBlockState(new BlockPos(x+4,y+4,z+6), Blocks.TORCH.getStateFromMeta(1));
				worldIn.setBlockState(new BlockPos(x+7,y+2,z+6), Blocks.FURNACE.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+8,y+2,z+6), Blocks.CRAFTING_TABLE.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+8,y+2,z+2), Blocks.BED.getStateFromMeta(11));
				worldIn.setBlockState(new BlockPos(x+7,y+2,z+2), Blocks.BED.getStateFromMeta(3));
				worldIn.setBlockState(new BlockPos(x+4,y+2,z+2), Blocks.CHEST.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+4,y+2,z+3), Blocks.CHEST.getDefaultState());
				//Roof
				worldIn.setBlockState(new BlockPos(x+1,y+5,z+2), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+1,y+5,z+3), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+1,y+5,z+4), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+1,y+5,z+5), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+1,y+5,z+6), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+2,y+5,z+2), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+2,y+5,z+3), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+2,y+5,z+4), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+2,y+5,z+5), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+2,y+5,z+6), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+3,y+5,z+1), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+3,y+5,z+2), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+3,y+5,z+3), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+3,y+5,z+4), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+3,y+5,z+5), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+3,y+5,z+6), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+3,y+5,z+7), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+4,y+5,z+1), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+4,y+5,z+2), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+4,y+5,z+3), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+4,y+5,z+4), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+4,y+5,z+5), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+4,y+5,z+6), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+4,y+5,z+7), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+5,y+5,z+1), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+5,y+5,z+2), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+5,y+5,z+3), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+5,y+5,z+4), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+5,y+5,z+5), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+5,y+5,z+6), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+5,y+5,z+7), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+6,y+5,z+1), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+6,y+5,z+2), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+6,y+5,z+3), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+6,y+5,z+4), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+6,y+5,z+5), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+6,y+5,z+6), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+6,y+5,z+7), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+7,y+5,z+1), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+7,y+5,z+2), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+7,y+5,z+3), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+7,y+5,z+4), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+7,y+5,z+5), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+7,y+5,z+6), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+7,y+5,z+7), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+8,y+5,z+1), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+8,y+5,z+2), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+8,y+5,z+3), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+8,y+5,z+4), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+8,y+5,z+5), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+8,y+5,z+6), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+8,y+5,z+7), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+9,y+5,z+1), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+9,y+5,z+2), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+9,y+5,z+3), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+9,y+5,z+4), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+9,y+5,z+5), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+9,y+5,z+6), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+9,y+5,z+7), Blocks.WOODEN_SLAB.getDefaultState());
				worldIn.setBlockState(new BlockPos(x+10,y+4,z), Blocks.OAK_STAIRS.getStateFromMeta(1));
				worldIn.setBlockState(new BlockPos(x+10,y+4,z+1), Blocks.OAK_STAIRS.getStateFromMeta(1));
				worldIn.setBlockState(new BlockPos(x+10,y+4,z+2), Blocks.OAK_STAIRS.getStateFromMeta(1));
				worldIn.setBlockState(new BlockPos(x+10,y+4,z+3), Blocks.OAK_STAIRS.getStateFromMeta(1));
				worldIn.setBlockState(new BlockPos(x+10,y+4,z+4), Blocks.OAK_STAIRS.getStateFromMeta(1));
				worldIn.setBlockState(new BlockPos(x+10,y+4,z+5), Blocks.OAK_STAIRS.getStateFromMeta(1));
				worldIn.setBlockState(new BlockPos(x+10,y+4,z+6), Blocks.OAK_STAIRS.getStateFromMeta(1));
				worldIn.setBlockState(new BlockPos(x+10,y+4,z+7), Blocks.OAK_STAIRS.getStateFromMeta(1));
				worldIn.setBlockState(new BlockPos(x+10,y+4,z+8), Blocks.OAK_STAIRS.getStateFromMeta(1));
				worldIn.setBlockState(new BlockPos(x+3,y+4,z), Blocks.OAK_STAIRS.getStateFromMeta(2));
				worldIn.setBlockState(new BlockPos(x+4,y+4,z), Blocks.OAK_STAIRS.getStateFromMeta(2));
				worldIn.setBlockState(new BlockPos(x+5,y+4,z), Blocks.OAK_STAIRS.getStateFromMeta(2));
				worldIn.setBlockState(new BlockPos(x+6,y+4,z), Blocks.OAK_STAIRS.getStateFromMeta(2));
				worldIn.setBlockState(new BlockPos(x+7,y+4,z), Blocks.OAK_STAIRS.getStateFromMeta(2));
				worldIn.setBlockState(new BlockPos(x+8,y+4,z), Blocks.OAK_STAIRS.getStateFromMeta(2));
				worldIn.setBlockState(new BlockPos(x+9,y+4,z), Blocks.OAK_STAIRS.getStateFromMeta(2));
				worldIn.setBlockState(new BlockPos(x+3,y+4,z+8), Blocks.OAK_STAIRS.getStateFromMeta(3));
				worldIn.setBlockState(new BlockPos(x+4,y+4,z+8), Blocks.OAK_STAIRS.getStateFromMeta(3));
				worldIn.setBlockState(new BlockPos(x+5,y+4,z+8), Blocks.OAK_STAIRS.getStateFromMeta(3));
				worldIn.setBlockState(new BlockPos(x+6,y+4,z+8), Blocks.OAK_STAIRS.getStateFromMeta(3));
				worldIn.setBlockState(new BlockPos(x+7,y+4,z+8), Blocks.OAK_STAIRS.getStateFromMeta(3));
				worldIn.setBlockState(new BlockPos(x+8,y+4,z+8), Blocks.OAK_STAIRS.getStateFromMeta(3));
				worldIn.setBlockState(new BlockPos(x+9,y+4,z+8), Blocks.OAK_STAIRS.getStateFromMeta(3));
			}
		}
		return true;
	}
}
