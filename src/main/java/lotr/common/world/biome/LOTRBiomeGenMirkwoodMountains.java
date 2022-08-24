/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class LOTRBiomeGenMirkwoodMountains extends LOTRBiomeGenMirkwoodCorrupted {
	public LOTRBiomeGenMirkwoodMountains(int i, boolean major) {
		super(i, major);
		decorator.vinesPerChunk = 4;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.GREEN_OAK, 200);
		decorator.addTree(LOTRTreeType.GREEN_OAK_LARGE, 200);
		decorator.addTree(LOTRTreeType.SPRUCE, 300);
		decorator.addTree(LOTRTreeType.FIR, 1000);
		decorator.addTree(LOTRTreeType.PINE, 300);
	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
		int snowHeight = 150 - rockDepth;
		int stoneHeight = snowHeight - 30;
		for (int j = ySize - 1; j >= stoneHeight; --j) {
			int index = xzIndex * ySize + j;
			Block block = blocks[index];
			if (j >= snowHeight && block == topBlock) {
				blocks[index] = Blocks.snow;
				meta[index] = 0;
				continue;
			}
			if (block != topBlock && block != fillerBlock) {
				continue;
			}
			blocks[index] = Blocks.stone;
			meta[index] = 0;
		}
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}
