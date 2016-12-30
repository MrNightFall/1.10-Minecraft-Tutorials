package com.championash5357.tutorial.world.dimension;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEndTutorialIsland extends WorldGenerator
{
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        float f = (float)(rand.nextInt(3) + 4);

        for (int i = 0; f > 0.5F; --i)
        {
            for (int j = MathHelper.floor_float(-f); j <= MathHelper.ceiling_float_int(f); ++j)
            {
                for (int k = MathHelper.floor_float(-f); k <= MathHelper.ceiling_float_int(f); ++k)
                {
                    if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, position.add(j, i, k), Blocks.COMMAND_BLOCK.getDefaultState());
                    }
                }
            }

            f = (float)((double)f - ((double)rand.nextInt(2) + 0.5D));
        }

        return true;
    }
}