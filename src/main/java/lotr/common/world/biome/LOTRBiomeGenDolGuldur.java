/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.LOTRMod;
import lotr.common.entity.animal.LOTREntityGorcrow;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenWoodElfTower;
import lotr.common.world.structure2.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LOTRBiomeGenDolGuldur extends LOTRBiomeGenMirkwoodCorrupted {
	public LOTRBiomeGenDolGuldur(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityGorcrow.class, 8, 4, 4));
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.WOOD_ELF_WARRIORS, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.WOOD_ELVES, 5).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.2f;
		decorator.addOre(new WorldGenMinable(LOTRMod.oreMorgulIron, 8), 20.0f, 0, 64);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreGulduril, 8), 8.0f, 0, 32);
		decorator.treesPerChunk = 1;
		decorator.vinesPerChunk = 2;
		decorator.flowersPerChunk = 0;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 1;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.MIRK_OAK, 200);
		decorator.addTree(LOTRTreeType.MIRK_OAK_DEAD, 1000);
		biomeColors.setGrass(3032113);
		biomeColors.setFoliage(3032113);
		biomeColors.setSky(4343633);
		biomeColors.setClouds(2632757);
		biomeColors.setFoggy(true);
		decorator.addRandomStructure(new LOTRWorldGenWoodElfHouse(false), 16);
		decorator.addRandomStructure(new LOTRWorldGenWoodElfTower(false), 100);
		decorator.addRandomStructure(new LOTRWorldGenWoodElvenForge(false), 80);
	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return true;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.MIRKWOOD.getSubregion("dolGuldur");
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}
}
