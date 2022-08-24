/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenVines
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.LOTRWorldGenStoneRuin;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenFarHaradJungle extends LOTRBiomeGenFarHarad {
	private WorldGenerator obsidianGen = new LOTRWorldGenObsidianGravel();
	protected int obsidianGravelRarity = 20;

	public LOTRBiomeGenFarHaradJungle(int i, boolean major) {
		super(i, major);
		if (isMuddy()) {
			topBlock = LOTRMod.mudGrass;
			fillerBlock = LOTRMod.mud;
		}
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityFlamingo.class, 10, 4, 4));
		spawnableLOTRAmbientList.clear();
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBird.class, 10, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityButterfly.class, 15, 4, 4));
		if (isMuddy()) {
			spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityMidges.class, 10, 4, 4));
		}
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LOTREntityJungleScorpion.class, 30, 4, 4));
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.TAURETHRIM, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.TAURETHRIM_WARRIORS, 30).setSpawnChance(600));
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.MOUNTAIN);
		this.addBiomeVariant(LOTRBiomeVariant.JUNGLE_DENSE);
		if (isMuddy()) {
			decorator.addSoil(new WorldGenMinable(LOTRMod.mud, 32), 80.0f, 0, 256);
			decorator.addSoil(new WorldGenMinable(LOTRMod.mud, 32), 80.0f, 0, 64);
		}
		decorator.addOre(new WorldGenMinable(Blocks.gold_ore, 4), 3.0f, 0, 48);
		decorator.addGem(new WorldGenMinable(LOTRMod.oreGem, 4, 8, Blocks.stone), 3.0f, 0, 48);
		decorator.treesPerChunk = 40;
		decorator.vinesPerChunk = 50;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 4;
		decorator.grassPerChunk = 15;
		decorator.doubleGrassPerChunk = 10;
		decorator.enableFern = true;
		decorator.canePerChunk = 5;
		decorator.cornPerChunk = 10;
		decorator.melonPerChunk = 0.2f;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.JUNGLE, 1000);
		decorator.addTree(LOTRTreeType.JUNGLE_LARGE, 500);
		decorator.addTree(LOTRTreeType.MAHOGANY, 500);
		decorator.addTree(LOTRTreeType.JUNGLE_SHRUB, 1000);
		decorator.addTree(LOTRTreeType.MANGO, 20);
		decorator.addTree(LOTRTreeType.BANANA, 50);
		registerJungleFlowers();
		biomeColors.setGrass(10607421);
		biomeColors.setFoliage(8376636);
		biomeColors.setSky(11977908);
		biomeColors.setFog(11254938);
		biomeColors.setWater(4104311);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.TAUREDAIN(1, 4), 100);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int j1;
		super.decorate(world, random, i, k);
		WorldGenVines vines = new WorldGenVines();
		for (int l = 0; l < 10; ++l) {
			int i1 = i + random.nextInt(16) + 8;
			j1 = 24;
			int k1 = k + random.nextInt(16) + 8;
			vines.generate(world, random, i1, j1, k1);
		}
		if (obsidianGravelRarity > 0 && random.nextInt(obsidianGravelRarity) == 0) {
			int i1 = i + random.nextInt(16) + 8;
			int k1 = k + random.nextInt(16) + 8;
			j1 = world.getTopSolidOrLiquidBlock(i1, k1);
			obsidianGen.generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.FAR_HARAD_JUNGLE.getSubregion("jungle");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.FAR_HARAD_JUNGLE;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public LOTRBiome.GrassBlockAndMeta getRandomGrass(Random random) {
		if (random.nextInt(4) == 0) {
			return new LOTRBiome.GrassBlockAndMeta(LOTRMod.tallGrass, 5);
		}
		return super.getRandomGrass(random);
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.TAUREDAIN.setRepair(0.8f);
	}

	public boolean hasJungleLakes() {
		return true;
	}

	public boolean isMuddy() {
		return true;
	}

	@Override
	protected double modifyStoneNoiseForFiller(double stoneNoise) {
		if (isMuddy()) {
			stoneNoise += 40.0;
		}
		return stoneNoise;
	}
}
