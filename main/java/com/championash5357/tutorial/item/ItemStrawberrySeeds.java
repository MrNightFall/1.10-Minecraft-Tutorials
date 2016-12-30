package com.championash5357.tutorial.item;

import com.championash5357.tutorial.client.Tutorial;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemStrawberrySeeds extends Item implements IPlantable{
	
	private final Block crops;
    private final Block soilBlockID;
	
	public ItemStrawberrySeeds(Block crops, Block soil){
		this.crops = crops;
		this.soilBlockID = soil;
		this.setCreativeTab(Tutorial.tabTutorial);
		this.setUnlocalizedName("strawberry_seeds");
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
        if (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos.offset(facing), facing, stack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up()))
        {
            worldIn.setBlockState(pos.up(), this.crops.getDefaultState());
            --stack.stackSize;
            return EnumActionResult.SUCCESS;
        }
        else
        {
            return EnumActionResult.FAIL;
        }
    }
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return this.crops.getDefaultState();
	}
}
