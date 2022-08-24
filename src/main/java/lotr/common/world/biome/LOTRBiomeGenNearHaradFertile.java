/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSand
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.entity.animal.*;
import lotr.common.entity.npc.LOTREntityBanditHarad;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenHaradObelisk;
import lotr.common.world.structure2.LOTRWorldGenStoneRuin;
import lotr.common.world.village.LOTRVillageGenSouthron;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenNearHaradFertile extends LOTRBiome {
	protected static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(12960262626062L), 1);
	protected static NoiseGeneratorPerlin noiseSand = new NoiseGeneratorPerlin(new Random(17860128964L), 1);
	protected static NoiseGeneratorPerlin noiseRedSand = new NoiseGeneratorPerlin(new Random(358960629620L), 1);

	public LOTRBiomeGenNearHaradFertile(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityCamel.class, 6, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 15, 4, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.COAST_SOUTHRONS, 20).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.SOUTHRON_WARRIORS, 15).setSpawnChance(600));
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_ORANGE, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_LEMON, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_LIME, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_OLIVE, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_ALMOND, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_PLUM, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_DATE, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND_SAND);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_SCRUBLAND_SAND);
		decorator.addOre(new WorldGenMinable(Blocks.lapis_ore, 6), 1.0f, 0, 48);
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 2;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 1;
		decorator.deadBushPerChunk = 1;
		decorator.cactiPerChunk = 1;
		decorator.addTree(LOTRTreeType.CEDAR, 800);
		decorator.addTree(LOTRTreeType.OAK_DESERT, 500);
		decorator.addTree(LOTRTreeType.DATE_PALM, 50);
		decorator.addTree(LOTRTreeType.CYPRESS, 400);
		decorator.addTree(LOTRTreeType.CYPRESS_LARGE, 50);
		decorator.addTree(LOTRTreeType.PALM, 100);
		decorator.addTree(LOTRTreeType.LEMON, 5);
		decorator.addTree(LOTRTreeType.ORANGE, 5);
		decorator.addTree(LOTRTreeType.LIME, 5);
		decorator.addTree(LOTRTreeType.OLIVE, 5);
		decorator.addTree(LOTRTreeType.OLIVE_LARGE, 10);
		decorator.addTree(LOTRTreeType.ALMOND, 5);
		decorator.addTree(LOTRTreeType.PLUM, 5);
		registerHaradFlowers();
		biomeColors.setGrass(11914805);
		decorator.addRandomStructure(new LOTRWorldGenHaradObelisk(false), 3000);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.NEAR_HARAD(1, 3), 300);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.NUMENOR(1, 3), 4000);
		decorator.addVillage(new LOTRVillageGenSouthron(this, 1.0f));
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
		setBanditEntityClass(LOTREntityBanditHarad.class);
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		if (hasMixedHaradSoils()) {
			double d = 0;
			double d2 = 0;
			double d1 = noiseDirt.func_151601_a(i * 0.002, k * 0.002);
			double d22 = noiseDirt.func_151601_a(i * 0.07, k * 0.07);
			double d3 = noiseDirt.func_151601_a(i * 0.25, k * 0.25);
			double d4 = noiseSand.func_151601_a(i * 0.002, k * 0.002);
			double d5 = noiseSand.func_151601_a(i * 0.07, k * 0.07);
			double d6 = noiseSand.func_151601_a(i * 0.25, k * 0.25);
			double d7 = noiseRedSand.func_151601_a(i * 0.002, k * 0.002);
			noiseRedSand.func_151601_a(i * 0.07, k * 0.07);
			noiseRedSand.func_151601_a(i * 0.25, k * 0.25);
			if (d7 + d2 + d > 1.6) {
				topBlock = Blocks.sand;
				topBlockMeta = 1;
				fillerBlock = topBlock;
				fillerBlockMeta = topBlockMeta;
			} else if (d4 + d5 + d6 > 0.9) {
				topBlock = Blocks.sand;
				topBlockMeta = 0;
				fillerBlock = topBlock;
				fillerBlockMeta = topBlockMeta;
			} else if (d1 + d22 + d3 > 0.4) {
				topBlock = Blocks.dirt;
				topBlockMeta = 1;
			}
		}
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		topBlock = topBlock_pre;
		topBlockMeta = topBlockMeta_pre;
		fillerBlock = fillerBlock_pre;
		fillerBlockMeta = fillerBlockMeta_pre;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.NEAR_HARAD.getSubregion("fertile");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.SOUTHRON_COASTS;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public WorldGenerator getRandomWorldGenForDoubleFlower(Random random) {
		LOTRWorldGenDoubleFlower doubleFlowerGen = new LOTRWorldGenDoubleFlower();
		if (random.nextInt(5) == 0) {
			doubleFlowerGen.setFlowerType(3);
		} else {
			doubleFlowerGen.setFlowerType(2);
		}
		return doubleFlowerGen;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.HARAD_PATH;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.3f;
	}

	protected boolean hasMixedHaradSoils() {
		return true;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
