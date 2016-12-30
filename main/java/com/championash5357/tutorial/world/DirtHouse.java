package com.championash5357.tutorial.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DirtHouse extends WorldGenerator{

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		world.setBlockState(new BlockPos(position.getX(), position.getY()+1, position.getZ()), Blocks.DIRT.getDefaultState());
		world.setBlockState(new BlockPos(position.getX()+1, position.getY()+1, position.getZ()), Blocks.DIRT.getDefaultState());
		world.setBlockState(new BlockPos(position.getX()+1, position.getY()+2, position.getZ()), Blocks.DIRT.getDefaultState());
		world.setBlockState(new BlockPos(position.getX(), position.getY()+2, position.getZ()), Blocks.DIRT.getDefaultState());
		world.setBlockState(new BlockPos(position.getX(), position.getY()+1, position.getZ()+2), Blocks.DIRT.getDefaultState());
		world.setBlockState(new BlockPos(position.getX()+1, position.getY()+1, position.getZ()+2), Blocks.DIRT.getDefaultState());
		world.setBlockState(new BlockPos(position.getX(), position.getY()+2, position.getZ()+2), Blocks.DIRT.getDefaultState());
		world.setBlockState(new BlockPos(position.getX()+1, position.getY()+2, position.getZ()+2), Blocks.DIRT.getDefaultState());
		world.setBlockState(new BlockPos(position.getX()+2, position.getY()+1, position.getZ()+1), Blocks.DIRT.getDefaultState());
		world.setBlockState(new BlockPos(position.getX()+2, position.getY()+2, position.getZ()+1), Blocks.DIRT.getDefaultState());
		world.setBlockState(new BlockPos(position.getX(), position.getY()+3, position.getZ()+1), Blocks.DIRT.getDefaultState());
		world.setBlockState(new BlockPos(position.getX()+1, position.getY()+3, position.getZ()+1), Blocks.DIRT.getDefaultState());
		ItemDoor.placeDoor(world, new BlockPos(position.getX(), position.getY()+1, position.getZ()+1), EnumFacing.EAST, Blocks.OAK_DOOR, false);
		return true;
	}
}
