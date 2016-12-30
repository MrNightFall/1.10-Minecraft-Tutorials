package com.championash5357.tutorial.block;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.championash5357.tutorial.client.Tutorial;
import com.championash5357.tutorial.enums.ColoredGlowstoneType;
import com.championash5357.tutorial.init.TutorialBlocks;
import com.championash5357.tutorial.interfaces.IMetaBlockName;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockColoredGlowstoneSlab extends BlockSlab implements IMetaBlockName{
	
	public static final PropertyEnum<ColoredGlowstoneType> VARIANT = PropertyEnum.<ColoredGlowstoneType>create("variant", ColoredGlowstoneType.class);
	
	public BlockColoredGlowstoneSlab() {
		super(Material.GLASS);
		IBlockState state = this.blockState.getBaseState();
		if(!this.isDouble()) {
			state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}
		this.useNeighborBrightness = !this.isDouble();
		this.setHardness(0.3f);
		this.setLightLevel(0.9375f);
		this.setLightOpacity(16);
		this.setResistance(1.5f);
		this.setSoundType(SoundType.GLASS);
		if(!this.isDouble())
			this.setCreativeTab(Tutorial.tabTutorial);
		this.setDefaultState(state.withProperty(VARIANT, ColoredGlowstoneType.WHITE));
	}
	
	@Override
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(TutorialBlocks.colored_glowstone_half_slab);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(TutorialBlocks.colored_glowstone_half_slab, 1, ((ColoredGlowstoneType)state.getValue(VARIANT)).getMetadata());
	}
	
	@Override
	public IProperty<?> getVariantProperty() {
		return VARIANT;
	}
	
	public Object getVariant(ItemStack stack) {
		return ColoredGlowstoneType.values()[stack.getMetadata() & 15];
	}
	
	@Override
	public String getUnlocalizedName(int meta) {
		return this.getUnlocalizedName();
	}
	
	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return ColoredGlowstoneType.values()[stack.getMetadata() & 15];
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		if(itemIn != Item.getItemFromBlock(TutorialBlocks.colored_glowstone_double_slab))
			for(ColoredGlowstoneType type : ColoredGlowstoneType.values())
				list.add(new ItemStack(itemIn, 1, type.getMetadata()));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState().withProperty(VARIANT, ColoredGlowstoneType.values()[meta & 15]);
		if(!this.isDouble())
			state = state.withProperty(HALF, (meta & 8) == 0 ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
		return state;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((ColoredGlowstoneType)state.getValue(VARIANT)).getMetadata();
		if(!this.isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP)
			i |= 8;
		return i;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return this.isDouble() ? (new BlockStateContainer(this, new IProperty[] {VARIANT})) : (new BlockStateContainer(this, new IProperty[] {HALF, VARIANT}));
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return ((ColoredGlowstoneType)state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	public String getSpecialName(ItemStack stack) {
		return ColoredGlowstoneType.values()[stack.getItemDamage()].getName();
	}
}
