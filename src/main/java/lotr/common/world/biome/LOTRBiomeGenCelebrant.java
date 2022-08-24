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
import lotr.common.world.structure2.LOTRWorldGenGaladhrimForge;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenCelebrant extends LOTRBiome {
	public LOTRBiomeGenCelebrant(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 4, 6));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.GALADHRIM, 5).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.GALADHRIM_WARRIORS, 1).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.GALADHRIM_WARDENS, 20).setSpawnChance(600));
		variantChance = 0.3f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		decorator.treesPerChunk = 0;
		decorator.setTreeCluster(6, 50);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 16;
		decorator.doubleFlowersPerChunk = 3;
		decorator.grassPerChunk = 12;
		decorator.doubleGrassPerChunk = 3;
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.BIRCH, 500);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 100);
		decorator.addTree(LOTRTreeType.BEECH, 500);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 100);
		decorator.addTree(LOTRTreeType.LARCH, 700);
		decorator.addTree(LOTRTreeType.CHESTNUT, 200);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 40);
		decorator.addTree(LOTRTreeType.APPLE, 5);
		decorator.addTree(LOTRTreeType.PEAR, 5);
		registerPlainsFlowers();
		biomeColors.setGrass(9751852);
		decorator.addRandomStructure(new LOTRWorldGenGaladhrimForge(false), 120);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DALE.getSubregion("celebrant");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.VALES_OF_ANDUIN;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 5;
	}
}
