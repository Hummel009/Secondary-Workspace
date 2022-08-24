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
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenHighElvenHall;
import lotr.common.world.structure2.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LOTRBiomeGenLindon extends LOTRBiome {
	public LOTRBiomeGenLindon(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 2, 6));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntitySeagull.class, 6, 4, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.LINDON_ELVES, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.LINDON_WARRIORS, 2).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.5f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.DENSEFOREST_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.DENSEFOREST_BIRCH);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 1.0f);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreQuendite, 6), 6.0f, 0, 48);
		decorator.setTreeCluster(10, 20);
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 3;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 1;
		decorator.whiteSand = true;
		decorator.addTree(LOTRTreeType.OAK, 100);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 25);
		decorator.addTree(LOTRTreeType.BIRCH, 500);
		decorator.addTree(LOTRTreeType.BIRCH_TALL, 500);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 200);
		decorator.addTree(LOTRTreeType.BIRCH_PARTY, 50);
		decorator.addTree(LOTRTreeType.BEECH, 100);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 25);
		decorator.addTree(LOTRTreeType.CHESTNUT, 40);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 10);
		decorator.addTree(LOTRTreeType.ASPEN, 300);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 100);
		decorator.addTree(LOTRTreeType.APPLE, 2);
		decorator.addTree(LOTRTreeType.PEAR, 2);
		registerPlainsFlowers();
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
		decorator.addRandomStructure(new LOTRWorldGenHighElfHouse(false), 300);
		decorator.addRandomStructure(new LOTRWorldGenHighElvenHall(false), 600);
		decorator.addRandomStructure(new LOTRWorldGenHighElvenForge(false), 1000);
		decorator.addRandomStructure(new LOTRWorldGenHighElvenTower(false), 900);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.LINDON.getSubregion("lindon");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.LINDON;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.HIGH_ELVEN;
	}

	@Override
	public boolean hasSeasonalGrass() {
		return false;
	}

	@Override
	public int spawnCountMultiplier() {
		return 5;
	}
}
