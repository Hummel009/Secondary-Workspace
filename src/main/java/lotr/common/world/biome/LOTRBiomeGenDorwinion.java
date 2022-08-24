/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  com.google.common.math.IntMath
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import com.google.common.math.IntMath;

import lotr.common.LOTRMod;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenDorwinion extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(LOTRMod.rock, 5, 1, 2);
	private LOTRBiomeSpawnList vineyardSpawnList = new LOTRBiomeSpawnList(this);

	public LOTRBiomeGenDorwinion(int i, boolean major) {
		super(i, major);
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.DALE_MEN, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.DALE_SOLDIERS, 10).setSpawnChance(600));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityKineAraw.class, 6, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 2, 1, 4));
		npcSpawnList.conquestGainRate = 0.75f;
		variantChance = 0.3f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_OLIVE, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_ALMOND, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_PLUM, 0.2f);
		decorator.setTreeCluster(8, 20);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 6;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 2;
		decorator.addTree(LOTRTreeType.OAK, 200);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.BIRCH, 50);
		decorator.addTree(LOTRTreeType.BIRCH_TALL, 50);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 50);
		decorator.addTree(LOTRTreeType.BEECH, 20);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 20);
		decorator.addTree(LOTRTreeType.CYPRESS, 500);
		decorator.addTree(LOTRTreeType.CYPRESS_LARGE, 50);
		decorator.addTree(LOTRTreeType.OAK_SHRUB, 800);
		decorator.addTree(LOTRTreeType.APPLE, 5);
		decorator.addTree(LOTRTreeType.PEAR, 5);
		decorator.addTree(LOTRTreeType.OLIVE, 20);
		decorator.addTree(LOTRTreeType.OLIVE_LARGE, 20);
		decorator.addTree(LOTRTreeType.ALMOND, 10);
		decorator.addTree(LOTRTreeType.PLUM, 10);
		registerRhunPlainsFlowers();
		biomeColors.setGrass(10538541);
		decorator.addRandomStructure(new LOTRWorldGenRuinedHouse(false), 4000);
		decorator.addRandomStructure(new LOTRWorldGenBurntHouse(false), 4000);
		decorator.addRandomStructure(new LOTRWorldGenRottenHouse(false), 4000);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.STONE(1, 4), 1000);
		decorator.addRandomStructure(new LOTRWorldGenDaleWatchtower(false), 500);
		decorator.addRandomStructure(new LOTRWorldGenDaleFortress(false), 800);
		decorator.addRandomStructure(new LOTRWorldGenDaleVillage(false), 400);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 500);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(50) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
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
		boolean vineyard = variant == LOTRBiomeVariant.VINEYARD;
		if (vineyard && !LOTRRoads.isRoadAt(i, k)) {
			for (int j = 128; j >= 0; --j) {
				int index = xzIndex * ySize + j;
				Block above = blocks[index + 1];
				Block block = blocks[index];
				if (block == null || !block.isOpaqueCube() || above != null && above.getMaterial() != Material.air) {
					continue;
				}
				int i1 = IntMath.mod(i, 6);
				int i2 = IntMath.mod(i, 24);
				int k1 = IntMath.mod(k, 32);
				int k2 = IntMath.mod(k, 64);
				if ((i1 == 0 || i1 == 5) && k1 != 0) {
					blocks[index] = Blocks.farmland;
					meta[index] = 0;
					int h = 2;
					if (biomeTerrainNoise.func_151601_a(i, k) > 0.0) {
						++h;
					}
					boolean red = biomeTerrainNoise.func_151601_a(i * 0.01, k * 0.01) > 0.0;
					Block vineBlock = red ? LOTRMod.grapevineRed : LOTRMod.grapevineWhite;
					for (int j1 = 1; j1 <= h; ++j1) {
						blocks[index + j1] = vineBlock;
						meta[index + j1] = 7;
					}
					break;
				}
				if (i1 >= 2 && i1 <= 3) {
					blocks[index] = LOTRMod.dirtPath;
					meta[index] = 0;
					if (i1 != i2 || (i1 != 2 || k2 != 16) && (i1 != 3 || k2 != 48)) {
						break;
					}
					int h = 3;
					for (int j1 = 1; j1 <= h; ++j1) {
						if (j1 == h) {
							blocks[index + j1] = Blocks.torch;
							meta[index + j1] = 5;
							continue;
						}
						blocks[index + j1] = LOTRMod.fence2;
						meta[index + j1] = 10;
					}
					break;
				}
				blocks[index] = topBlock;
				meta[index] = (byte) topBlockMeta;
				break;
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DORWINION.getSubregion("dorwinion");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.DORWINION;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public LOTRBiomeSpawnList getNPCSpawnList(World world, Random random, int i, int j, int k, LOTRBiomeVariant variant) {
		if (variant == LOTRBiomeVariant.VINEYARD) {
			return vineyardSpawnList;
		}
		return super.getNPCSpawnList(world, random, i, j, k, variant);
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
		return LOTRRoadType.DORWINION;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.1f;
	}

	@Override
	public boolean hasDomesticAnimals() {
		return true;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
