package com.championash5357.tutorial.enums;

import net.minecraft.util.IStringSerializable;

public enum BlockMetadataType implements IStringSerializable{
	
	WHITE(0, "white"),
	BLACK(1, "black");

	private int meta;
	private String name;
	
	private BlockMetadataType(int meta, String name) {
		this.meta = meta;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMetadata() {
		return meta;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
