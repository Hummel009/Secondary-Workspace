/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.village.LOTRVillageGenRhun;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenRhunWest extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);
	private WorldGenerator boulderGenSandstone = new LOTRWorldGenBoulder(Blocks.sandstone, 0, 1, 3);
	protected boolean rhunBoulders = true;

	public LOTRBiomeGenRhunWest(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityKineAraw.class, 6, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 4, 1, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.EASTERLINGS, 20).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.EASTERLING_WARRIORS, 20).setSpawnChance(600));
		variantChance = 0.3f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_OLIVE, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_DATE, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_POMEGRANATE, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_ALMOND, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_PLUM, 0.1f);
		decorator.setTreeCluster(8, 20);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 6;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 4;
		decorator.addTree(LOTRTreeType.OAK, 100);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 50);
		decorator.addTree(LOTRTreeType.BIRCH, 50);
		decorator.addTree(LOTRTreeType.BIRCH_TALL, 50);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 20);
		decorator.addTree(LOTRTreeType.BEECH, 50);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 10);
		decorator.addTree(LOTRTreeType.MAPLE, 50);
		decorator.addTree(LOTRTreeType.MAPLE_LARGE, 10);
		decorator.addTree(LOTRTreeType.CYPRESS, 400);
		decorator.addTree(LOTRTreeType.CYPRESS_LARGE, 50);
		decorator.addTree(LOTRTreeType.OAK_SHRUB, 600);
		decorator.addTree(LOTRTreeType.APPLE, 2);
		decorator.addTree(LOTRTreeType.PEAR, 2);
		decorator.addTree(LOTRTreeType.ALMOND, 5);
		decorator.addTree(LOTRTreeType.PLUM, 5);
		decorator.addTree(LOTRTreeType.OLIVE, 20);
		decorator.addTree(LOTRTreeType.OLIVE_LARGE, 20);
		decorator.addTree(LOTRTreeType.DATE_PALM, 25);
		decorator.addTree(LOTRTreeType.POMEGRANATE, 25);
		registerRhunPlainsFlowers();
		biomeColors.setGrass(14538041);
		decorator.addVillage(new LOTRVillageGenRhun(this, 1.0f, true));
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (rhunBoulders && random.nextInt(50) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				int j1 = world.getHeightValue(i1, k1);
				if (random.nextInt(3) == 0) {
					boulderGenSandstone.generate(world, random, i1, j1, k1);
					continue;
				}
				boulderGen.generate(world, random, i1, j1, k1);
			}
		}
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		int chunkX = i & 0xF;
		int chunkZ = k & 0xF;
		int xzIndex = chunkX * 16 + chunkZ;
		int ySize = blocks.length / 256;
		double d1 = biomeTerrainNoise.func_151601_a(i * 0.08, k * 0.08);
		double d2 = biomeTerrainNoise.func_151601_a(i * 0.4, k * 0.4);
		if (d1 + d2 > 0.1) {
			int minHeight = height - 8 - random.nextInt(6);
			for (int j = height - 1; j >= minHeight; --j) {
				int index = xzIndex * ySize + j;
				Block block = blocks[index];
				if (block != Blocks.stone) {
					continue;
				}
				blocks[index] = Blocks.sandstone;
				meta[index] = 0;
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.RHUN.getSubregion("rhudel");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.RHUN_KHAGANATE;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public WorldGenerator getRandomWorldGenForDoubleFlower(Random random) {
		if (random.nextInt(3) == 0) {
			LOTRWorldGenDoubleFlower doubleFlowerGen = new LOTRWorldGenDoubleFlower();
			doubleFlowerGen.setFlowerType(0);
			return doubleFlowerGen;
		}
		return super.getRandomWorldGenForDoubleFlower(random);
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.RHUN;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.1f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
