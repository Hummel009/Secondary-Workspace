/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.entity.animal.LOTREntitySwan;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.spawning.*;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenSwanfleet extends LOTRBiomeGenEriador {
	public LOTRBiomeGenSwanfleet(int i, boolean major) {
		super(i, major);
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntitySwan.class, 20, 4, 8));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.EREGION_ELVES, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.EREGION_WARRIORS, 2).setSpawnChance(600));
		clearBiomeVariants();
		variantChance = 1.0f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_SWAMP);
		decorator.sandPerChunk = 0;
		decorator.quagmirePerChunk = 1;
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 1;
		decorator.logsPerChunk = 1;
		decorator.flowersPerChunk = 4;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 8;
		decorator.enableFern = true;
		decorator.waterlilyPerChunk = 4;
		decorator.canePerChunk = 10;
		decorator.reedPerChunk = 3;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.OAK_TALL, 500);
		decorator.addTree(LOTRTreeType.OAK_SWAMP, 500);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 300);
		decorator.addTree(LOTRTreeType.BIRCH, 200);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 100);
		registerSwampFlowers();
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ERIADOR.getSubregion("swanfleet");
	}
}
