package com.championash5357.tutorial.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.championash5357.tutorial.client.Tutorial;
import com.championash5357.tutorial.util.MathHandler;

public class BlockTable extends Block{
	
	protected static final AxisAlignedBB LEG_1 = new AxisAlignedBB(0, 0, 0, MathHandler.pixelConversion(2), MathHandler.pixelConversion(12), MathHandler.pixelConversion(2));
	protected static final AxisAlignedBB LEG_2 = new AxisAlignedBB(MathHandler.pixelConversion(14), 0, 0, 1, MathHandler.pixelConversion(12), MathHandler.pixelConversion(2));
	protected static final AxisAlignedBB LEG_3 = new AxisAlignedBB(MathHandler.pixelConversion(14), 0, MathHandler.pixelConversion(14), 1, MathHandler.pixelConversion(12), 1);
	protected static final AxisAlignedBB LEG_4 = new AxisAlignedBB(0, 0, MathHandler.pixelConversion(14), MathHandler.pixelConversion(2), MathHandler.pixelConversion(12), 1);
	protected static final AxisAlignedBB TOP = new AxisAlignedBB(0, MathHandler.pixelConversion(12), 0, 1, MathHandler.pixelConversion(14), 1);
	
	public BlockTable(Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName("table");
		this.setCreativeTab(Tutorial.tabTutorial);
		this.setHardness(10.0f);
		this.setResistance(1.5f);
		this.setSoundType(SoundType.WOOD);
	}
	
	public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return TOP;
    }
    
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn) {
    	addCollisionBoxToList(pos, entityBox, collidingBoxes, LEG_1);
    	addCollisionBoxToList(pos, entityBox, collidingBoxes, LEG_2);
    	addCollisionBoxToList(pos, entityBox, collidingBoxes, LEG_3);
    	addCollisionBoxToList(pos, entityBox, collidingBoxes, LEG_4);
    	addCollisionBoxToList(pos, entityBox, collidingBoxes, TOP);
    }
}
