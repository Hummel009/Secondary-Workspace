/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class LOTRBiomeGenFarHaradJungleMountains extends LOTRBiomeGenFarHaradJungle {
	public LOTRBiomeGenFarHaradJungleMountains(int i, boolean major) {
		super(i, major);
		obsidianGravelRarity = 5;
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		decorator.biomeGemFactor = 1.0f;
		decorator.treesPerChunk = 0;
		biomeColors.setSky(10659994);
		biomeColors.setFog(9805451);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int k1;
		int j1;
		int i1;
		int l;
		super.decorate(world, random, i, k);
		for (l = 0; l < 3; ++l) {
			int craters = 1 + random.nextInt(3);
			for (int l1 = 0; l1 < craters; ++l1) {
				i1 = i + random.nextInt(16) + 8;
				int j12 = world.getHeightValue(i1, k1 = k + random.nextInt(16) + 8);
				if (j12 <= 110) {
					continue;
				}
				new LOTRWorldGenVolcanoCrater().generate(world, random, i1, j12, k1);
			}
		}
		for (l = 0; l < 12; ++l) {
			int k12;
			int i12 = i + random.nextInt(16) + 8;
			j1 = world.getHeightValue(i12, k12 = k + random.nextInt(16) + 8);
			if (j1 >= 120 && random.nextInt(20) != 0) {
				continue;
			}
			decorator.genTree(world, random, i12, j1, k12);
		}
		LOTRWorldGenStreams lavaGen = new LOTRWorldGenStreams(Blocks.flowing_lava);
		for (int l2 = 0; l2 < 5; ++l2) {
			i1 = i + random.nextInt(16) + 8;
			j1 = 140 + random.nextInt(50);
			k1 = k + random.nextInt(16) + 8;
			lavaGen.generate(world, random, i1, j1, k1);
		}
	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
		double d = 0;
		int stoneHeight = 120 - rockDepth;
		boolean generateMud = false;
		int muds = 0;
		double d1 = biomeTerrainNoise.func_151601_a(i * 0.09, k * 0.09);
		biomeTerrainNoise.func_151601_a(i * 0.4, k * 0.4);
		if (d1 + d > 0.4) {
			generateMud = true;
		}
		for (int j = ySize - 1; j >= stoneHeight; --j) {
			int index = xzIndex * ySize + j;
			Block block = blocks[index];
			if (block != topBlock && block != fillerBlock || generateMud && muds < 4 + random.nextInt(2)) {
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

	@Override
	public boolean hasJungleLakes() {
		return false;
	}
}
