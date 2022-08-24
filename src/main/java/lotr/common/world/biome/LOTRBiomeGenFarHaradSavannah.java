/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 *  net.minecraft.world.gen.feature.WorldGenDoublePlant
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.*;

import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityBanditHarad;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenFarHaradSavannah extends LOTRBiomeGenFarHarad {
	private static NoiseGeneratorPerlin populatedNoise = new NoiseGeneratorPerlin(new Random(100L), 1);
	protected LOTRBiomeSpawnList populatedSpawnList = new LOTRBiomeSpawnList(this);
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public LOTRBiomeGenFarHaradSavannah(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.MORWAITH, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.MORWAITH_WARRIORS, 5).setSpawnChance(600));
		variantChance = 0.3f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SAVANNAH_BAOBAB, 3.0f);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND, 2.0f);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_SCRUBLAND);
		this.addBiomeVariant(LOTRBiomeVariant.WASTELAND);
		decorator.addSoil(new WorldGenMinable(LOTRMod.redClay, 32, Blocks.dirt), 40.0f, 0, 80);
		decorator.setTreeCluster(3, 60);
		decorator.clayGen = new LOTRWorldGenSand(LOTRMod.redClay, 5, 1);
		decorator.clayPerChunk = 4;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 12;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 1;
		decorator.melonPerChunk = 0.01f;
		decorator.addRandomStructure(new LOTRWorldGenMoredainVillage(false), 200);
		decorator.addRandomStructure(new LOTRWorldGenMoredainCamp(false), 500);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.TAUREDAIN(1, 2), 5000);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
		setBanditEntityClass(LOTREntityBanditHarad.class);
	}

	@Override
	public void addBiomeF3Info(List info, World world, LOTRBiomeVariant variant, int i, int j, int k) {
		super.addBiomeF3Info(info, world, variant, i, j, k);
		boolean populated = LOTRBiomeGenFarHaradSavannah.isBiomePopulated(i, j, k);
		info.add("HaradPopulated: " + populated);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(32) == 0) {
			int boulders = 1 + random.nextInt(4);
			for (int l = 0; l < boulders; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		if (random.nextInt(6) == 0) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = random.nextInt(128);
			int k1 = k + random.nextInt(16) + 8;
			new LOTRWorldGenYams().generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.FAR_HARAD.getSubregion("savannah");
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.75f;
	}

	@Override
	public LOTRBiomeSpawnList getNPCSpawnList(World world, Random random, int i, int j, int k, LOTRBiomeVariant variant) {
		if (LOTRBiomeGenFarHaradSavannah.isBiomePopulated(i, j, k)) {
			return populatedSpawnList;
		}
		return super.getNPCSpawnList(world, random, i, j, k, variant);
	}

	@Override
	public WorldGenerator getRandomWorldGenForDoubleFlower(Random random) {
		if (random.nextInt(6) == 0) {
			WorldGenDoublePlant gen = new WorldGenDoublePlant();
			gen.func_150548_a(0);
			return gen;
		}
		return super.getRandomWorldGenForDoubleFlower(random);
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.1f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}

	public static boolean isBiomePopulated(int i, int j, int k) {
		double scale = 8.0E-4;
		double d = populatedNoise.func_151601_a(i * scale, k * scale);
		return d > 0.5;
	}
}
