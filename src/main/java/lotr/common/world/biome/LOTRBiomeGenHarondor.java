/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSand
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
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
import lotr.common.world.structure.LOTRWorldGenHaradObelisk;
import lotr.common.world.structure2.LOTRWorldGenStoneRuin;
import lotr.common.world.village.LOTRVillageGenSouthron;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenHarondor extends LOTRBiome {
	protected static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(52809698208569676L), 1);
	protected static NoiseGeneratorPerlin noiseSand = new NoiseGeneratorPerlin(new Random(474929905950956L), 1);
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public LOTRBiomeGenHarondor(int i, boolean major) {
		super(i, major);
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.COAST_SOUTHRONS, 20).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.SOUTHRON_WARRIORS, 15).setSpawnChance(600));
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_SCRUBLAND);
		this.addBiomeVariant(LOTRBiomeVariant.WASTELAND);
		decorator.addOre(new WorldGenMinable(Blocks.lapis_ore, 6), 1.0f, 0, 48);
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 1;
		decorator.flowersPerChunk = 4;
		decorator.cactiPerChunk = 1;
		decorator.deadBushPerChunk = 1;
		decorator.addTree(LOTRTreeType.OAK_DESERT, 1000);
		decorator.addTree(LOTRTreeType.CEDAR, 250);
		decorator.addTree(LOTRTreeType.LEMON, 5);
		decorator.addTree(LOTRTreeType.ORANGE, 5);
		decorator.addTree(LOTRTreeType.LIME, 5);
		decorator.addTree(LOTRTreeType.OLIVE, 5);
		decorator.addTree(LOTRTreeType.OLIVE_LARGE, 5);
		decorator.addTree(LOTRTreeType.ALMOND, 5);
		decorator.addTree(LOTRTreeType.PLUM, 5);
		decorator.addVillage(new LOTRVillageGenSouthron(this, 1.0f));
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_COMMON);
		decorator.addRandomStructure(new LOTRWorldGenHaradObelisk(false), 3000);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.NEAR_HARAD(1, 3), 300);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.NUMENOR(1, 3), 4000);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int l;
		int k1;
		int i1;
		super.decorate(world, random, i, k);
		if (random.nextInt(16) == 0) {
			int boulders = 1 + random.nextInt(4);
			for (l = 0; l < boulders; ++l) {
				i1 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		if (random.nextInt(8) == 0) {
			int trees = 1 + random.nextInt(8);
			for (l = 0; l < trees; ++l) {
				i1 = i + random.nextInt(8) + 8;
				k1 = k + random.nextInt(8) + 8;
				int j1 = world.getHeightValue(i1, k1);
				decorator.genTree(world, random, i1, j1, k1);
			}
		}
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		double d = 0;
		double d2 = 0;
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = noiseDirt.func_151601_a(i * 0.09, k * 0.09);
		double d22 = noiseDirt.func_151601_a(i * 0.4, k * 0.4);
		double d3 = noiseSand.func_151601_a(i * 0.002, k * 0.002);
		noiseSand.func_151601_a(i * 0.09, k * 0.09);
		noiseSand.func_151601_a(i * 0.4, k * 0.4);
		if (d3 + d2 + d > 0.7) {
			topBlock = Blocks.sand;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d22 > 0.3) {
			topBlock = Blocks.dirt;
			topBlockMeta = 1;
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
		return LOTRMusicRegion.NEAR_HARAD.getSubregion("harondor");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.HARONDOR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}

	@Override
	public LOTRBiome.GrassBlockAndMeta getRandomGrass(Random random) {
		return random.nextInt(3) == 0 ? new LOTRBiome.GrassBlockAndMeta(LOTRMod.aridGrass, 0) : super.getRandomGrass(random);
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.GONDOR_MIX.setRepair(0.6f);
	}
}
