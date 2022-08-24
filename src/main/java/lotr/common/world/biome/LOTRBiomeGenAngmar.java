/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.passive.EntityWolf
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

import lotr.common.LOTRMod;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.*;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenAngmar extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 2);

	public LOTRBiomeGenAngmar(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 10, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 2, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 4, 1, 4));
		spawnableWaterCreatureList.clear();
		spawnableLOTRAmbientList.clear();
		npcSpawnList.newFactionList(80).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.ANGMAR_HILLMEN, 30).setSpawnChance(600));
		npcSpawnList.newFactionList(20).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.TROLLS, 30).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.HILL_TROLLS, 20).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.SNOW_TROLLS, 5).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.5f;
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 1.0f);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreMorgulIron, 8), 20.0f, 0, 64);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreGulduril, 8), 8.0f, 0, 32);
		decorator.flowersPerChunk = 0;
		decorator.grassPerChunk = 4;
		decorator.doubleGrassPerChunk = 1;
		decorator.addTree(LOTRTreeType.SPRUCE_THIN, 100);
		decorator.addTree(LOTRTreeType.SPRUCE, 200);
		decorator.addTree(LOTRTreeType.SPRUCE_DEAD, 150);
		decorator.addTree(LOTRTreeType.CHARRED, 150);
		decorator.addTree(LOTRTreeType.FIR, 100);
		decorator.addTree(LOTRTreeType.PINE, 200);
		biomeColors.setGrass(7896151);
		biomeColors.setSky(5324595);
		biomeColors.setClouds(1644825);
		biomeColors.setFog(1644825);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.ANGMAR(1, 4), 40);
		decorator.addRandomStructure(new LOTRWorldGenBlastedLand(false), 40);
		decorator.addRandomStructure(new LOTRWorldGenAngmarHillmanVillage(false), 400);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 300);
	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return true;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int k1;
		super.decorate(world, random, i, k);
		for (int l = 0; l < 4; ++l) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = world.getHeightValue(i1, k1 = k + random.nextInt(16) + 8);
			if (j1 <= 80) {
				continue;
			}
			decorator.genTree(world, random, i1, j1, k1);
		}
		if (random.nextInt(6) == 0) {
			int i1 = i + random.nextInt(16) + 8;
			k1 = k + random.nextInt(16) + 8;
			boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
		}
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		double d = 0;
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = biomeTerrainNoise.func_151601_a(i * 0.07, k * 0.07);
		biomeTerrainNoise.func_151601_a(i * 0.4, k * 0.4);
		if (d1 + d > 0.5) {
			topBlock = Blocks.stone;
			topBlockMeta = 0;
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
		return LOTRMusicRegion.ANGMAR.getSubregion("angmar");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.ANGMAR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
