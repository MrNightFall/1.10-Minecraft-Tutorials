package com.championash5357.tutorial.block.metadata;

import com.championash5357.tutorial.interfaces.IMetaBlockName;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMetadataBlock extends ItemBlock{

	public ItemBlockMetadataBlock(Block block) {
		super(block);
		if(!(block instanceof IMetaBlockName))
			throw new IllegalArgumentException(String.format("The given block %s is not an instance of IMetaBlockName", block.getUnlocalizedName()));
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	public int getMetadata(int damage) {
		return damage;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "." + ((IMetaBlockName)this.block).getSpecialName(stack);
	}
}
