package com.championash5357.tutorial.entity;

import java.util.BitSet;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.championash5357.tutorial.client.Tutorial;

public class TutorialEntity {
	
	private static final TutorialEntity INSTANCE = new TutorialEntity();
	private BitSet availableIndicies;
	
	public static TutorialEntity instance() {
        return INSTANCE;
    }
	
	private TutorialEntity() {
		availableIndicies = new BitSet(256);
		availableIndicies.set(1,255);
		for (Object id : EntityList.ID_TO_CLASS.keySet()) {
			availableIndicies.clear((Integer)id);
		}
	}
	
	public static int findGlobalUniqueEntityId()
    {
        int res = instance().availableIndicies.nextSetBit(0);
        if (res < 0)
        {
            throw new RuntimeException("No more entity indicies left");
        }
        return res;
    }
	
	public static void registerEntity() {
		createEntity(EntityFourArms.class, "Four Arms", 0xa62323, 0xed1515);
	}
	
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {
		int randomId = findGlobalUniqueEntityId();
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, Tutorial.modInstance, 64, 1, true, solidColor, spotColor);
	}
}
