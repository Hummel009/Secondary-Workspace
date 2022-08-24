/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.entity.animal.LOTREntityHorse;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.*;
import lotr.common.world.village.LOTRVillageGenBree;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenBreeland extends LOTRBiome {
	public LOTRBiomeGenBreeland(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 8, 2, 6));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.BREE_MEN, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.BREE_GUARDS, 10).setSpawnChance(600));
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 1.0f);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 2;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 1;
		decorator.generateAthelas = true;
		decorator.addTree(LOTRTreeType.OAK, 1000);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 300);
		decorator.addTree(LOTRTreeType.BEECH, 300);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 75);
		decorator.addTree(LOTRTreeType.MAPLE, 200);
		decorator.addTree(LOTRTreeType.MAPLE_LARGE, 50);
		decorator.addTree(LOTRTreeType.CHESTNUT, 300);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 75);
		decorator.addTree(LOTRTreeType.BIRCH, 50);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 20);
		decorator.addTree(LOTRTreeType.ASPEN, 50);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 10);
		decorator.addTree(LOTRTreeType.APPLE, 3);
		decorator.addTree(LOTRTreeType.PEAR, 3);
		registerPlainsFlowers();
		registerPlainsFlowers();
		decorator.addVillage(new LOTRVillageGenBree(this, 1.0f));
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 500);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.STONE(1, 3), 1000);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.ARNOR(1, 3), 1000);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.BREE.getSubregion("bree");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.BREE_LAND;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.05f;
	}

	@Override
	public boolean hasDomesticAnimals() {
		return true;
	}
}
