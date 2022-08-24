/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.LOTRMod;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.*;
import lotr.common.world.structure2.*;
import lotr.common.world.village.LOTRVillageGenGondor;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenGwathlo extends LOTRBiome {
	public LOTRBiomeGenGwathlo(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 2, 6));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntitySeagull.class, 6, 4, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.GONDOR_MEN, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.GONDOR_SOLDIERS, 2).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.5f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND, 1.0f);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_SCRUBLAND, 1.0f);
		decorator.setTreeCluster(8, 20);
		decorator.willowPerChunk = 1;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 4;
		decorator.generateAthelas = true;
		decorator.addTree(LOTRTreeType.OAK, 1000);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.BIRCH, 100);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 10);
		decorator.addTree(LOTRTreeType.SPRUCE, 200);
		decorator.addTree(LOTRTreeType.BEECH, 20);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 2);
		decorator.addTree(LOTRTreeType.CHESTNUT, 100);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 10);
		decorator.addTree(LOTRTreeType.ASPEN, 50);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 5);
		decorator.addTree(LOTRTreeType.APPLE, 2);
		decorator.addTree(LOTRTreeType.PEAR, 2);
		registerPlainsFlowers();
		addFlower(LOTRMod.lavender, 0, 20);
		addFiefdomStructures();
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
		decorator.addRandomStructure(new LOTRWorldGenGondorRuins(), 600);
		decorator.addRandomStructure(new LOTRWorldGenRuinedGondorTower(false), 1000);
		decorator.addRandomStructure(new LOTRWorldGenGondorObelisk(false), 1000);
		decorator.addRandomStructure(new LOTRWorldGenGondorRuin(false), 1000);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 500);
		decorator.addRandomStructure(new LOTRWorldGenGondorTurret(false), 500);
		decorator.addRandomStructure(new LOTRWorldGenGondorWatchfort(false), 1000);
		decorator.addVillage(new LOTRVillageGenGondor(this, LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 1.0f));
	}

	protected void addFiefdomStructures() {

	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ERIADOR.getSubregion("eriador");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.ERIADOR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.ARNOR.setRepair(0.92f);
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
