package com.championash5357.tutorial.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemFood;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

import com.championash5357.tutorial.client.Tutorial;

public class ItemStrawberry extends ItemFood{
	
	public ItemStrawberry(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName("strawberry");
		this.setCreativeTab(Tutorial.tabTutorial);
	}
}
