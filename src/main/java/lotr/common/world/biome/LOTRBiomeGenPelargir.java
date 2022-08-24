/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenPelargir extends LOTRBiomeGenGondor {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(LOTRMod.whiteSandstone, 0, 1, 3);

	public LOTRBiomeGenPelargir(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		variantChance = 0.3f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_OLIVE, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_ALMOND, 0.5f);
		decorator.setTreeCluster(6, 50);
		decorator.treesPerChunk = 0;
		decorator.flowersPerChunk = 4;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 4;
		decorator.whiteSand = true;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.BIRCH, 100);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 50);
		decorator.addTree(LOTRTreeType.CYPRESS, 500);
		decorator.addTree(LOTRTreeType.CYPRESS_LARGE, 100);
		decorator.addTree(LOTRTreeType.CEDAR, 400);
		decorator.addTree(LOTRTreeType.CEDAR_LARGE, 50);
		decorator.addTree(LOTRTreeType.OLIVE, 10);
		decorator.addTree(LOTRTreeType.OLIVE_LARGE, 10);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(24) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		double d = 0;
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = biomeTerrainNoise.func_151601_a(i * 0.02, k * 0.08);
		biomeTerrainNoise.func_151601_a(i * 0.3, k * 0.7);
		if (d1 + d > 0.7) {
			topBlock = LOTRMod.whiteSand;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		}
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		topBlock = topBlock_pre;
		topBlockMeta = topBlockMeta_pre;
		fillerBlock = fillerBlock_pre;
		fillerBlockMeta = fillerBlockMeta_pre;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.GONDOR.getSubregion("pelargir");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.LEBENNIN;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.05f;
	}
}
