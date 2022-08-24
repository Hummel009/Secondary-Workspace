/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenAndrast extends LOTRBiomeGenGondor {
	protected static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(285939985023633003L), 1);
	protected static NoiseGeneratorPerlin noiseStone = new NoiseGeneratorPerlin(new Random(4148990259960304L), 1);
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 4);
	private WorldGenerator boulderGenGondor = new LOTRWorldGenBoulder(LOTRMod.rock, 1, 1, 4);

	public LOTRBiomeGenAndrast(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		variantChance = 0.5f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND, 3.0f);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_SCRUBLAND);
		this.addBiomeVariant(LOTRBiomeVariant.WASTELAND, 3.0f);
		decorator.setTreeCluster(10, 30);
		decorator.treesPerChunk = 0;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 12;
		decorator.doubleGrassPerChunk = 4;
		decorator.addTree(LOTRTreeType.OAK, 400);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 200);
		decorator.addTree(LOTRTreeType.BIRCH, 50);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 20);
		decorator.addTree(LOTRTreeType.BEECH, 50);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 20);
		decorator.addTree(LOTRTreeType.DARK_OAK, 500);
		decorator.addTree(LOTRTreeType.FIR, 200);
		decorator.addTree(LOTRTreeType.PINE, 200);
		decorator.addTree(LOTRTreeType.SPRUCE, 200);
		decorator.addTree(LOTRTreeType.LARCH, 200);
		decorator.addTree(LOTRTreeType.APPLE, 5);
		decorator.addTree(LOTRTreeType.PEAR, 5);
		decorator.addTree(LOTRTreeType.PLUM, 5);
		decorator.addTree(LOTRTreeType.OAK_SHRUB, 1500);
		registerPlainsFlowers();
		biomeColors.setGrass(10202470);
		clearTravellingTraders();
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(5) == 0) {
			for (int l = 0; l < 4; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				if (random.nextBoolean()) {
					boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
					continue;
				}
				boulderGenGondor.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
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
		double d1 = noiseDirt.func_151601_a(i * 0.07, k * 0.07);
		double d2 = noiseDirt.func_151601_a(i * 0.3, k * 0.3);
		double d3 = noiseStone.func_151601_a(i * 0.07, k * 0.07);
		noiseStone.func_151601_a(i * 0.3, k * 0.3);
		if (d3 + d > 1.1) {
			topBlock = Blocks.stone;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d2 > 0.6) {
			topBlock = Blocks.dirt;
			topBlockMeta = 1;
		}
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		topBlock = topBlock_pre;
		topBlockMeta = topBlockMeta_pre;
		fillerBlock = fillerBlock_pre;
		fillerBlockMeta = fillerBlockMeta_pre;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.PUKEL.getSubregion("andrast");
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.5f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 1;
	}
}
