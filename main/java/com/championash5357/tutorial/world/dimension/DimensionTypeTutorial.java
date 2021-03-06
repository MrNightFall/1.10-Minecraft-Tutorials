package com.championash5357.tutorial.world.dimension;

import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.championash5357.tutorial.world.biome.TutorialBiomeRegistry;

public class DimensionTypeTutorial extends WorldProvider{
	
	@Override
	public void createBiomeProvider() {
		this.biomeProvider = new BiomeProviderSingle(TutorialBiomeRegistry.tutorial_biome);
		this.isHellWorld = true;
		this.hasNoSky = true;
	}
	
	@Override
	public DimensionType getDimensionType() {
		return TutorialDimensionRegistry.TUTORIAL;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(float par1, float par2) {
		return new Vec3d(0.6D, 0.0D, 0.6D);
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new TutorialChunkProvider(worldObj, worldObj.getSeed());
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}
	
	@Override
	public boolean canCoordinateBeSpawn(int par1, int par2) {
		return false;
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean doesXZShowFog(int par1, int par2) {
		return false;
	}

}
