package com.championash5357.tutorial.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.championash5357.tutorial.interfaces.IMetaBlockName;

public class ItemBlockColoredGlowstone extends ItemBlock{

	public ItemBlockColoredGlowstone(Block block) {
		super(block);
		if(!(block instanceof IMetaBlockName))
			throw new IllegalArgumentException(String.format("The given block, %s" + ", is not an instance of IMetaBlockName.", block.getUnlocalizedName()));
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "." + ((IMetaBlockName)this.block).getSpecialName(stack);
	}
}
