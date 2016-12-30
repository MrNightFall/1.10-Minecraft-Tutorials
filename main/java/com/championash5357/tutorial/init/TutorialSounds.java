package com.championash5357.tutorial.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.championash5357.tutorial.client.Reference;

public class TutorialSounds {
	
	public static SoundEvent Doctor;
	public static SoundEvent TutorialLive;
	public static SoundEvent TutorialHurt;
	public static SoundEvent TutorialDeath;
	
	public static void registerSounds() {
		Doctor = registerSound("Doctor");
		TutorialLive = registerSound("TutorialLive");
		TutorialHurt = registerSound("TutorialHurt");
		TutorialDeath = registerSound("TutorialDeath");
	}
	
	private static SoundEvent registerSound(String soundName) {
		final ResourceLocation id = new ResourceLocation(Reference.MOD_ID, soundName);
		return GameRegistry.register(new SoundEvent(id).setRegistryName(id));
	}
}
