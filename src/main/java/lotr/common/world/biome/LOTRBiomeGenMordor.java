/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 *  net.minecraft.world.gen.feature.WorldGenAbstractTree
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenMordorTower;
import lotr.common.world.structure2.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenMordor extends LOTRBiome {
	protected static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(389502092662L), 1);
	protected static NoiseGeneratorPerlin noiseGravel = new NoiseGeneratorPerlin(new Random(1379468206L), 1);
	protected WorldGenerator boulderGen = new LOTRWorldGenBoulder(LOTRMod.rock, 0, 2, 8);
	protected boolean enableMordorBoulders = true;

	public LOTRBiomeGenMordor(int i, boolean major) {
		super(i, major);
		topBlock = LOTRMod.rock;
		topBlockMeta = 0;
		fillerBlock = LOTRMod.rock;
		fillerBlockMeta = 0;
		if (isGorgoroth()) {
			setDisableRain();
		}
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableLOTRAmbientList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.MORDOR_ORCS, 30).setSpawnChance(60), LOTRBiomeSpawnList.entry(LOTRSpawnList.MORDOR_ORCS, 5).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.MORDOR_WARGS, 30).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.OLOG_HAI, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.BLACK_URUKS, 7).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.5f;
		decorator.clearOres();
		decorator.addSoil(new WorldGenMinable(LOTRMod.mordorDirt, 0, 60, LOTRMod.rock), 10.0f, 0, 60);
		decorator.addSoil(new WorldGenMinable(LOTRMod.mordorGravel, 0, 32, LOTRMod.rock), 10.0f, 0, 60);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreNaurite, 12, LOTRMod.rock), 20.0f, 0, 64);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreMorgulIron, 1, 8, LOTRMod.rock), 20.0f, 0, 64);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreGulduril, 1, 8, LOTRMod.rock), 6.0f, 0, 32);
		enableRocky = false;
		if (isGorgoroth()) {
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 1;
			decorator.generateWater = false;
			decorator.sandPerChunk = 0;
			decorator.clayPerChunk = 0;
			decorator.dryReedChance = 1.0f;
			decorator.addTree(LOTRTreeType.CHARRED, 1000);
			biomeColors.setGrass(5980459);
			biomeColors.setFoliage(6508333);
			biomeColors.setSky(6700595);
			biomeColors.setClouds(4924185);
			biomeColors.setFog(3154711);
			biomeColors.setWater(2498845);
		} else {
			decorator.treesPerChunk = 1;
			decorator.grassPerChunk = 7;
			biomeColors.setGrass(10066237);
			biomeColors.setFoliage(7042874);
			biomeColors.setSky(10526098);
			biomeColors.resetClouds();
			biomeColors.resetFog();
			biomeColors.setWater(8877157);
			decorator.setTreeCluster(6, 30);
			decorator.willowPerChunk = 1;
			decorator.flowersPerChunk = 0;
			decorator.doubleFlowersPerChunk = 0;
			decorator.grassPerChunk = 8;
			decorator.dryReedChance = 0.6f;
			decorator.generateWater = true;
			decorator.addTree(LOTRTreeType.OAK, 500);
			decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
			decorator.addTree(LOTRTreeType.OAK_DESERT, 500);
			decorator.addTree(LOTRTreeType.CEDAR, 100);
			decorator.addTree(LOTRTreeType.OAK_DEAD, 200);
			decorator.addTree(LOTRTreeType.CHARRED, 200);
			biomeColors.setFoggy(true);
			biomeColors.setFog(6132078);
		}
		decorator.addTree(LOTRTreeType.CHARRED, 1000);
		decorator.addRandomStructure(new LOTRWorldGenMordorCamp(false), 100);
		decorator.addRandomStructure(new LOTRWorldGenMordorWargPit(false), 300);
		decorator.addRandomStructure(new LOTRWorldGenMordorTower(false), 500);
		decorator.addRandomStructure(new LOTRWorldGenBlackUrukFort(false), 2000);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return true;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int k1;
		int j1;
		int i1;
		super.decorate(world, random, i, k);
		if (isGorgoroth()) {
			int k12;
			int l;
			int j12;
			int i12;
			if (enableMordorBoulders && random.nextInt(24) == 0) {
				for (l = 0; l < 6; ++l) {
					i12 = i + random.nextInt(16) + 8;
					k12 = k + random.nextInt(16) + 8;
					boulderGen.generate(world, random, i12, world.getHeightValue(i12, k12), k12);
				}
			}
			if (random.nextInt(60) == 0) {
				for (l = 0; l < 8; ++l) {
					i12 = i + random.nextInt(16) + 8;
					k12 = k + random.nextInt(16) + 8;
					j12 = world.getHeightValue(i12, k12);
					decorator.genTree(world, random, i12, j12, k12);
				}
			}
			if (decorator.grassPerChunk > 0) {
				if (random.nextInt(20) == 0) {
					for (l = 0; l < 6; ++l) {
						i12 = i + random.nextInt(6) + 8;
						if (!world.isAirBlock(i12, j12 = world.getHeightValue(i12, k12 = k + random.nextInt(6) + 8), k12) || !LOTRMod.mordorThorn.canBlockStay(world, i12, j12, k12)) {
							continue;
						}
						world.setBlock(i12, j12, k12, LOTRMod.mordorThorn, 0, 2);
					}
				}
				if (random.nextInt(20) == 0 && world.isAirBlock(i1 = i + random.nextInt(16) + 8, j1 = world.getHeightValue(i1, k1 = k + random.nextInt(16) + 8), k1) && LOTRMod.mordorMoss.canBlockStay(world, i1, j1, k1)) {
					new LOTRWorldGenMordorMoss().generate(world, random, i1, j1, k1);
				}
			}
		}
		if (LOTRFixedStructures.MORDOR_CHERRY_TREE.isAt(world, i, k)) {
			i1 = i + 8;
			k1 = k + 8;
			j1 = world.getHeightValue(i1, k1);
			LOTRTreeType.CHERRY_MORDOR.create(false, random).generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		if (!isGorgoroth() && hasMordorSoils()) {
			double d = 0;
			double d1 = noiseDirt.func_151601_a(i * 0.08, k * 0.08);
			double d2 = noiseDirt.func_151601_a(i * 0.4, k * 0.4);
			double d3 = noiseGravel.func_151601_a(i * 0.08, k * 0.08);
			noiseGravel.func_151601_a(i * 0.4, k * 0.4);
			if (d3 + d > 0.8) {
				topBlock = LOTRMod.mordorGravel;
				topBlockMeta = 0;
				fillerBlock = topBlock;
				fillerBlockMeta = topBlockMeta;
			} else if (d1 + d2 > 0.5) {
				topBlock = LOTRMod.mordorDirt;
				topBlockMeta = 0;
				fillerBlock = topBlock;
				fillerBlockMeta = topBlockMeta;
			}
		}
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		topBlock = topBlock_pre;
		topBlockMeta = topBlockMeta_pre;
		fillerBlock = fillerBlock_pre;
		fillerBlockMeta = fillerBlockMeta_pre;
	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
		for (int j = ySize - 1; j >= 0; --j) {
			int index = xzIndex * ySize + j;
			Block block = blocks[index];
			if (block != Blocks.stone) {
				continue;
			}
			blocks[index] = LOTRMod.rock;
			meta[index] = 0;
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.MORDOR.getSubregion("mordor");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.MORDOR;
	}

	@Override
	public LOTRRoadType.BridgeType getBridgeBlock() {
		return LOTRRoadType.BridgeType.CHARRED;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.0f;
	}

	@Override
	public LOTRBiome.GrassBlockAndMeta getRandomGrass(Random random) {
		if (isGorgoroth()) {
			return new LOTRBiome.GrassBlockAndMeta(LOTRMod.mordorGrass, 0);
		}
		return super.getRandomGrass(random);
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.MORDOR;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 1.0f;
	}

	protected boolean hasMordorSoils() {
		return true;
	}

	@Override
	public boolean hasSky() {
		return !isGorgoroth();
	}

	public boolean isGorgoroth() {
		return false;
	}

	public static boolean isSurfaceMordorBlock(World world, int i, int j, int k) {
		Block block = world.getBlock(i, j, k);
		int meta = world.getBlockMetadata(i, j, k);
		return block == LOTRMod.rock && meta == 0 || block == LOTRMod.mordorDirt || block == LOTRMod.mordorGravel;
	}
}
