package com.championash5357.tutorial.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TutorialTab extends CreativeTabs{

	public TutorialTab(int index, String label) {
		super(index, label);
		this.setBackgroundImageName("tutorial.png");
	}
	
	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(TutorialBlocks.purple_glowstone);
	}
}
