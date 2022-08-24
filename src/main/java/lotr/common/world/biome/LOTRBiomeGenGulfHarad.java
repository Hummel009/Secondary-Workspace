/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSand
 *  net.minecraft.entity.passive.EntityChicken
 *  net.minecraft.entity.passive.EntitySheep
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
import net.minecraft.entity.passive.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenGulfHarad extends LOTRBiome {
	protected static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(8359286029006L), 1);
	protected static NoiseGeneratorPerlin noiseSand = new NoiseGeneratorPerlin(new Random(473689270272L), 1);
	protected static NoiseGeneratorPerlin noiseRedSand = new NoiseGeneratorPerlin(new Random(3528569078920702727L), 1);
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public LOTRBiomeGenGulfHarad(int i, boolean major) {
		super(i, major);
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.COAST_SOUTHRONS, 20).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.SOUTHRON_WARRIORS, 15).setSpawnChance(600));
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySheep.class, 12, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityWildBoar.class, 10, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityChicken.class, 8, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityAurochs.class, 6, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityWhiteOryx.class, 12, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityCamel.class, 2, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 10, 4, 4));
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
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 2;
		decorator.flowersPerChunk = 1;
		decorator.doubleFlowersPerChunk = 1;
		decorator.deadBushPerChunk = 1;
		decorator.cactiPerChunk = 1;
		decorator.addTree(LOTRTreeType.PALM, 500);
		decorator.addTree(LOTRTreeType.ACACIA, 300);
		decorator.addTree(LOTRTreeType.OAK_DESERT, 400);
		decorator.addTree(LOTRTreeType.DRAGONBLOOD, 200);
		decorator.addTree(LOTRTreeType.DRAGONBLOOD_LARGE, 10);
		decorator.addTree(LOTRTreeType.DATE_PALM, 50);
		decorator.addTree(LOTRTreeType.LEMON, 5);
		decorator.addTree(LOTRTreeType.ORANGE, 5);
		decorator.addTree(LOTRTreeType.LIME, 5);
		decorator.addTree(LOTRTreeType.OLIVE, 5);
		decorator.addTree(LOTRTreeType.OLIVE_LARGE, 10);
		decorator.addTree(LOTRTreeType.ALMOND, 5);
		decorator.addTree(LOTRTreeType.PLUM, 5);
		registerHaradFlowers();
		decorator.addRandomStructure(new LOTRWorldGenHaradObelisk(false), 3000);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.NEAR_HARAD(1, 3), 300);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.NUMENOR(1, 3), 4000);

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
		setBanditEntityClass(LOTREntityBanditHarad.class);
		decorator.addVillage(new LOTRVillageGenSouthron(this, 1.0f));
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(20) == 0) {
			int boulders = 1 + random.nextInt(3);
			for (int l = 0; l < boulders; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				int j1 = world.getHeightValue(i1, k1);
				boulderGen.generate(world, random, i1, j1, k1);
			}
		}
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
			if (d7 + d2 + d > 0.9) {
				topBlock = Blocks.sand;
				topBlockMeta = 1;
				fillerBlock = topBlock;
				fillerBlockMeta = topBlockMeta;
			} else if (d4 + d5 + d6 > 1.2) {
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
		return LOTRMusicRegion.NEAR_HARAD.getSubregion("gulf");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.GULF_HARAD;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public WorldGenerator getRandomWorldGenForDoubleFlower(Random random) {
		LOTRWorldGenDoubleFlower doubleFlowerGen = new LOTRWorldGenDoubleFlower();
		if (random.nextInt(3) != 0) {
			doubleFlowerGen.setFlowerType(3);
		} else {
			doubleFlowerGen.setFlowerType(2);
		}
		return doubleFlowerGen;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.GULF_HARAD;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.2f;
	}

	protected boolean hasMixedHaradSoils() {
		return true;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
