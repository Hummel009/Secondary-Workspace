/*
 * Decompiled with CFR 0.148.

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
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenBarrowDowns extends LOTRBiome {
	public static final int WIGHT_SKY = 9674385;
	public static final int WIGHT_CLOUDS = 11842740;
	public static final int WIGHT_FOG = 10197915;

	public LOTRBiomeGenBarrowDowns(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 8, 2, 6));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.BARROW_WIGHTS, 10).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.2f;
		variantChance = 0.2f;
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK);
		decorator.willowPerChunk = 1;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 6;
		decorator.generateAthelas = true;
		decorator.addTree(LOTRTreeType.OAK, 1000);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 200);
		decorator.addTree(LOTRTreeType.OAK_DEAD, 1500);
		decorator.addTree(LOTRTreeType.SPRUCE, 500);
		decorator.addTree(LOTRTreeType.BIRCH, 150);
		registerPlainsFlowers();
		decorator.addRandomStructure(new LOTRWorldGenBDBarrow(false), 10);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.STONE(2, 7), 30);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.ARNOR(2, 7), 30);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 200);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.BARROW_DOWNS.getSubregion("barrowDowns");
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
	public float getTreeIncreaseChance() {
		return 0.1f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 6;
	}
}
