package com.championash5357.tutorial.block.metadata;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import com.championash5357.tutorial.client.Tutorial;
import com.championash5357.tutorial.enums.BlockMetadataType;
import com.championash5357.tutorial.interfaces.IMetaBlockName;

public class BlockMetadataBlock extends Block implements IMetaBlockName{
	
	public static final PropertyEnum<BlockMetadataType> TYPE = PropertyEnum.<BlockMetadataType>create("type", BlockMetadataType.class);
	
	public BlockMetadataBlock(String unlocalizedNmae) {
		super(Material.ROCK);
		this.setUnlocalizedName(unlocalizedNmae);
		this.setCreativeTab(Tutorial.tabTutorial);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, BlockMetadataType.WHITE));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {TYPE});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if(meta == 0)
			return this.getDefaultState().withProperty(TYPE, BlockMetadataType.WHITE);
		if(meta == 1)
			return this.getDefaultState().withProperty(TYPE, BlockMetadataType.BLACK);
		return this.getDefaultState().withProperty(TYPE, BlockMetadataType.WHITE);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		BlockMetadataType type = (BlockMetadataType)state.getValue(TYPE);
		return type.getMetadata();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		list.add(new ItemStack(itemIn, 1, 0));
		list.add(new ItemStack(itemIn, 1, 1));
	}
	
	@Override
	public String getSpecialName(ItemStack stack) {
		if(stack.getItemDamage() == 0)
			return "white";
		if(stack.getItemDamage() == 1)
			return "black";
		return "white";
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
}
