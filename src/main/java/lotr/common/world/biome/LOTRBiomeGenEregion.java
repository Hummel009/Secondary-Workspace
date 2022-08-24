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
import lotr.common.entity.animal.LOTREntityHorse;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LOTRBiomeGenEregion extends LOTRBiome {
	public LOTRBiomeGenEregion(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 2, 6));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.EREGION_ELVES, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.EREGION_WARRIORS, 2).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.2f;
		variantChance = 0.3f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreQuendite, 6), 6.0f, 0, 48);
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 5;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 1;
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 200);
		decorator.addTree(LOTRTreeType.HOLLY, 500);
		decorator.addTree(LOTRTreeType.HOLLY_LARGE, 200);
		decorator.addTree(LOTRTreeType.BIRCH, 200);
		decorator.addTree(LOTRTreeType.BIRCH_TALL, 100);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 50);
		decorator.addTree(LOTRTreeType.CHESTNUT, 50);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 10);
		decorator.addTree(LOTRTreeType.ASPEN, 50);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 20);
		decorator.addTree(LOTRTreeType.APPLE, 2);
		decorator.addTree(LOTRTreeType.PEAR, 2);
		registerPlainsFlowers();
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.RIVENDELL.getSubregion("rivendell");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.EREGION;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.HIGH_ELVEN;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}

	@Override
	public boolean hasSeasonalGrass() {
		return false;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
