/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.*;

public class LOTRBiomeGenOldForest extends LOTRBiome {
	public LOTRBiomeGenOldForest(int i, boolean major) {
		super(i, major);
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.DARK_HUORNS, 10).setSpawnChance(600));
		addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
		decorator.treesPerChunk = 16;
		decorator.willowPerChunk = 2;
		decorator.flowersPerChunk = 1;
		decorator.grassPerChunk = 12;
		decorator.doubleGrassPerChunk = 5;
		decorator.enableFern = true;
		decorator.mushroomsPerChunk = 2;
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_TALL, 1000);
		decorator.addTree(LOTRTreeType.OAK_TALLER, 200);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 500);
		decorator.addTree(LOTRTreeType.DARK_OAK, 1000);
		decorator.addTree(LOTRTreeType.FIR, 500);
		decorator.addTree(LOTRTreeType.PINE, 500);
		registerForestFlowers();
		biomeColors.setGrass(4686398);
		biomeColors.setFoliage(3172394);
		biomeColors.setFog(1651225);
		biomeColors.setFoggy(true);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.OLD_FOREST.getSubregion("oldForest");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.ERIADOR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.0f;
	}
}
