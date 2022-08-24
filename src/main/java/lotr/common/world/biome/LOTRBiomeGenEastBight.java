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

import lotr.common.entity.animal.LOTREntityHorse;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenEastBight extends LOTRBiome {
	public LOTRBiomeGenEastBight(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 2, 6));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.DALE_SOLDIERS, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.DALE_MEN, 2).setSpawnChance(600));
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE_BARREN);
		decorator.logsPerChunk = 2;
		decorator.flowersPerChunk = 2;
		decorator.doubleFlowersPerChunk = 0;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 6;
		decorator.addTree(LOTRTreeType.OAK_DEAD, 500);
		decorator.addTree(LOTRTreeType.SPRUCE_DEAD, 500);
		decorator.addTree(LOTRTreeType.BEECH_DEAD, 500);
		registerPlainsFlowers();
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
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		double d = 0;
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = biomeTerrainNoise.func_151601_a(i * 0.09, k * 0.09);
		biomeTerrainNoise.func_151601_a(i * 0.4, k * 0.4);
		if (d1 + d > 0.3) {
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
		return LOTRMusicRegion.DALE.getSubregion("wilderland");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.WILDERLAND;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.05f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.05f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 4;
	}
}
