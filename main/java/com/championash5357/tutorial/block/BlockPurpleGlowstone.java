package com.championash5357.tutorial.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;

import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.client.Tutorial;
import com.championash5357.tutorial.init.TutorialItems;

public class BlockPurpleGlowstone extends Block{

	public BlockPurpleGlowstone(Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName("purple_glowstone");
		this.setCreativeTab(Tutorial.tabTutorial);
		this.setHardness(0.3f);
		this.setLightLevel(0.9375f);
		this.setLightOpacity(16);
		this.setResistance(1.5f);
		this.setSoundType(SoundType.GLASS);
	}
	
	public int quantityDroppedWithBonus(int fortune, Random random) {
        return MathHelper.clamp_int(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 4);
    }

    public int quantityDropped(Random random) {
        return 2 + random.nextInt(3);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return TutorialItems.purple_glowstone_dust;
    }
	
	public MapColor getMapColor(IBlockState state) {
        return MapColor.PURPLE;
    }
}
