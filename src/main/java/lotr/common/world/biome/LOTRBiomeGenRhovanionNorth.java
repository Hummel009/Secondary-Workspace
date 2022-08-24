/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.spawning.*;

public class LOTRBiomeGenRhovanionNorth extends LOTRBiomeGenRhovanion {
	public LOTRBiomeGenRhovanionNorth(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.DALE_MEN, 10).setSpawnChance(100), LOTRBiomeSpawnList.entry(LOTRSpawnList.DALE_SOLDIERS, 10).setSpawnChance(100));
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK_SPRUCE);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE);
		decorator.setTreeCluster(6, 8);
		decorator.flowersPerChunk = 2;
		decorator.doubleFlowersPerChunk = 0;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 5;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.OAK_DEAD, 100);
		decorator.addTree(LOTRTreeType.SPRUCE, 300);
		decorator.addTree(LOTRTreeType.SPRUCE_DEAD, 20);
		decorator.addTree(LOTRTreeType.FIR, 200);
		decorator.addTree(LOTRTreeType.PINE, 200);
		registerPlainsFlowers();
		clearTravellingTraders();
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);
	}

	@Override
	public int spawnCountMultiplier() {
		return 1;
	}
}
