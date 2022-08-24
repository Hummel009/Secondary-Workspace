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
import lotr.common.entity.npc.LOTREntityBanditHarad;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenLostladen extends LOTRBiome {
	private static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(486938207230702L), 1);
	private static NoiseGeneratorPerlin noiseSand = new NoiseGeneratorPerlin(new Random(28507830789060732L), 1);
	private static NoiseGeneratorPerlin noiseStone = new NoiseGeneratorPerlin(new Random(275928960292060726L), 1);
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);
	private WorldGenerator boulderGenSandstone = new LOTRWorldGenBoulder(Blocks.sandstone, 0, 1, 3);

	public LOTRBiomeGenLostladen(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		npcSpawnList.clear();
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_SCRUBLAND);
		this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK, 3.0f);
		decorator.addOre(new WorldGenMinable(Blocks.lapis_ore, 6), 1.0f, 0, 48);
		decorator.treesPerChunk = 0;
		decorator.grassPerChunk = 3;
		decorator.doubleGrassPerChunk = 1;
		decorator.flowersPerChunk = 1;
		decorator.cactiPerChunk = 1;
		decorator.deadBushPerChunk = 2;
		decorator.addTree(LOTRTreeType.OAK_DESERT, 1000);
		decorator.addTree(LOTRTreeType.OAK_DEAD, 200);
		registerHaradFlowers();
		biomeColors.setSky(15592678);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
		setBanditEntityClass(LOTREntityBanditHarad.class);
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.KHANDS, 20).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.KHAND_WARRIORS, 15).setSpawnChance(600));
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(20) == 0) {
			int boulders = 1 + random.nextInt(4);
			for (int l = 0; l < boulders; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				int j1 = world.getHeightValue(i1, k1);
				if (random.nextBoolean()) {
					boulderGen.generate(world, random, i1, j1, k1);
					continue;
				}
				boulderGenSandstone.generate(world, random, i1, j1, k1);
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
		double d1 = noiseDirt.func_151601_a(i * 0.09, k * 0.09);
		double d2 = noiseDirt.func_151601_a(i * 0.4, k * 0.4);
		double d3 = noiseSand.func_151601_a(i * 0.09, k * 0.09);
		double d4 = noiseSand.func_151601_a(i * 0.4, k * 0.4);
		double d5 = noiseStone.func_151601_a(i * 0.09, k * 0.09);
		noiseStone.func_151601_a(i * 0.4, k * 0.4);
		if (d5 + d > 0.3) {
			if (random.nextInt(5) == 0) {
				topBlock = Blocks.gravel;
			} else {
				topBlock = Blocks.stone;
			}
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d3 + d4 > 0.1) {
			if (random.nextInt(5) == 0) {
				topBlock = Blocks.sandstone;
			} else {
				topBlock = Blocks.sand;
			}
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d2 > -0.2) {
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
		return LOTRMusicRegion.NEAR_HARAD.getSubregion("lostladen");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.LOSTLADEN;
	}

	@Override
	public LOTRBiome.GrassBlockAndMeta getRandomGrass(Random random) {
		if (random.nextBoolean()) {
			return new LOTRBiome.GrassBlockAndMeta(LOTRMod.aridGrass, 0);
		}
		return super.getRandomGrass(random);
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.HARAD.setRepair(0.3f);
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.01f;
	}
}
