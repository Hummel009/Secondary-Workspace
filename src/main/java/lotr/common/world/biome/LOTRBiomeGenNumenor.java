package lotr.common.world.biome;

import lotr.common.*;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.*;
import lotr.common.world.structure2.*;
import lotr.common.world.village.LOTRVillageGenGondor;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LOTRBiomeGenNumenor extends LOTRBiome {
	public LOTRBiomeGenNumenor(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 3, 1, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.GONDOR_SOLDIERS, 10).setSpawnChance(600));
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_PLUM, 0.2f);
		decorator.addSoil(new WorldGenMinable(LOTRMod.rock, 1, 60, Blocks.stone), 2.0f, 0, 64);
		decorator.setTreeCluster(10, 30);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 1;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 1;
		decorator.generateAthelas = true;
		decorator.addTree(LOTRTreeType.OAK, 1000);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 300);
		decorator.addTree(LOTRTreeType.BIRCH, 50);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 20);
		decorator.addTree(LOTRTreeType.BEECH, 50);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 20);
		decorator.addTree(LOTRTreeType.APPLE, 5);
		decorator.addTree(LOTRTreeType.PEAR, 5);
		decorator.addTree(LOTRTreeType.PLUM, 5);
		decorator.addTree(LOTRTreeType.OLIVE, 1);
		decorator.addTree(LOTRTreeType.ALMOND, 1);
		registerPlainsFlowers();
		decorator.addVillage(new LOTRVillageGenGondor(this, LOTRWorldGenGondorStructure.GondorFiefdom.GONDOR, 1.0f));
		decorator.addRandomStructure(new LOTRWorldGenGondorRuins(), 600);
		decorator.addRandomStructure(new LOTRWorldGenRuinedGondorTower(false), 1000);
		decorator.addRandomStructure(new LOTRWorldGenGondorObelisk(false), 1000);
		decorator.addRandomStructure(new LOTRWorldGenGondorRuin(false), 1000);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 500);
		decorator.addRandomStructure(new LOTRWorldGenGondorTurret(false), 500);
		decorator.addRandomStructure(new LOTRWorldGenGondorWatchfort(false), 1000);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public LOTRAchievement getBiomeAchievement() {
		return null;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.GONDOR.getSubregion("GONDOR");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.GONDOR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.GONDOR_MIX;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.02f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
