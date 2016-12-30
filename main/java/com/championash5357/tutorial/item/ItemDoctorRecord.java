package com.championash5357.tutorial.item;

import com.championash5357.tutorial.client.Reference;
import com.championash5357.tutorial.client.Tutorial;
import com.championash5357.tutorial.init.TutorialSounds;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ItemDoctorRecord extends ItemRecord{

	public ItemDoctorRecord() {
		super("Doctor", TutorialSounds.Doctor);
		this.maxStackSize = 1;
		this.setCreativeTab(Tutorial.tabTutorial);
	}
	
	@Override
	public ResourceLocation getRecordResource(String name) {
		return new ResourceLocation(Reference.MOD_ID + ":" + name);
	}
}
