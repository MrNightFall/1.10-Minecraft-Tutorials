package com.championash5357.tutorial.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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
import com.championash5357.tutorial.enums.ColoredGlowstoneType;
import com.championash5357.tutorial.enums.ColoredGlowstoneType;
import com.championash5357.tutorial.interfaces.IMetaBlockName;

public class BlockColoredGlowstone extends Block implements IMetaBlockName{
	
	public static final PropertyEnum<ColoredGlowstoneType> TYPE = PropertyEnum.<ColoredGlowstoneType>create("type", ColoredGlowstoneType.class);
	
	public BlockColoredGlowstone() {
		super(Material.GLASS);
		this.setCreativeTab(Tutorial.tabTutorial);
		this.setHardness(0.3f);
		this.setLightLevel(0.9375f);
		this.setLightOpacity(16);
		this.setResistance(1.5f);
		this.setSoundType(SoundType.GLASS);
		this.setUnlocalizedName("colored_glowstone");
		this.setRegistryName("BlockColoredGlowstone");
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, ColoredGlowstoneType.WHITE));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {TYPE});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if(meta == 0)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.WHITE);
		if(meta == 1)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.ORANGE);
		if(meta == 2)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.MAGENTA);
		if(meta == 3)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.LIGHT_BLUE);
		if(meta == 4)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.YELLOW);
		if(meta == 5)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.LIME);
		if(meta == 6)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.PINK);
		if(meta == 7)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.GRAY);
		if(meta == 8)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.LIGHT_GRAY);
		if(meta == 9)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.CYAN);
		if(meta == 10)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.PURPLE);
		if(meta == 11)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.BLUE);
		if(meta == 12)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.BROWN);
		if(meta == 13)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.GREEN);
		if(meta == 14)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.RED);
		if(meta == 15)
			return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.BLACK);
		return this.getDefaultState().withProperty(TYPE, ColoredGlowstoneType.WHITE);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((ColoredGlowstoneType)state.getValue(TYPE)).getMetadata();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for(ColoredGlowstoneType type : ColoredGlowstoneType.values())
			list.add(new ItemStack(itemIn, 1, type.getMetadata()));
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		if(stack.getItemDamage() == 0)
			return "white";
		if(stack.getItemDamage() == 1)
			return "orange";
		if(stack.getItemDamage() == 2)
			return "magenta";
		if(stack.getItemDamage() == 3)
			return "light_blue";
		if(stack.getItemDamage() == 4)
			return "yellow";
		if(stack.getItemDamage() == 5)
			return "lime";
		if(stack.getItemDamage() == 6)
			return "pink";
		if(stack.getItemDamage() == 7)
			return "gray";
		if(stack.getItemDamage() == 8)
			return "light_gray";
		if(stack.getItemDamage() == 9)
			return "cyan";
		if(stack.getItemDamage() == 10)
			return "purple";
		if(stack.getItemDamage() == 11)
			return "blue";
		if(stack.getItemDamage() == 12)
			return "brown";
		if(stack.getItemDamage() == 13)
			return "green";
		if(stack.getItemDamage() == 14)
			return "red";
		if(stack.getItemDamage() == 15)
			return "black";
		return "white";
	}
}
