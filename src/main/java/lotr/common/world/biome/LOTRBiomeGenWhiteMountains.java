/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class LOTRBiomeGenWhiteMountains extends LOTRBiomeGenGondor {
	public LOTRBiomeGenWhiteMountains(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		clearBiomeVariants();
		variantChance = 0.2f;
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.3f);
		decorator.biomeGemFactor = 1.0f;
		decorator.treesPerChunk = 1;
		decorator.flowersPerChunk = 2;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 2;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.OAK, 100);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 50);
		decorator.addTree(LOTRTreeType.BIRCH, 20);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 5);
		decorator.addTree(LOTRTreeType.BEECH, 20);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 5);
		decorator.addTree(LOTRTreeType.SPRUCE, 300);
		decorator.addTree(LOTRTreeType.LARCH, 300);
		decorator.addTree(LOTRTreeType.FIR, 500);
		decorator.addTree(LOTRTreeType.PINE, 500);
		decorator.addTree(LOTRTreeType.APPLE, 5);
		decorator.addTree(LOTRTreeType.PEAR, 5);
		registerMountainsFlowers();

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);

	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
		int stoneHeight = 100 - rockDepth;
		for (int j = ySize - 1; j >= stoneHeight; --j) {
			int index = xzIndex * ySize + j;
			Block block = blocks[index];
			if (block != topBlock && block != fillerBlock) {
				continue;
			}
			blocks[index] = LOTRMod.rock;
			meta[index] = 1;
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.GONDOR.getSubregion("whiteMountains");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.WHITE_MOUNTAINS;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public int spawnCountMultiplier() {
		return 2;
	}
}
