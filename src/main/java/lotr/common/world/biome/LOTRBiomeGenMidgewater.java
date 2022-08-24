/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.entity.animal.LOTREntityMidges;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenMidgewater extends LOTRBiome {
	public LOTRBiomeGenMidgewater(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableLOTRAmbientList.clear();
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityMidges.class, 10, 4, 4));
		clearBiomeVariants();
		variantChance = 1.0f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_SWAMP);
		decorator.sandPerChunk = 0;
		decorator.quagmirePerChunk = 1;
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 1;
		decorator.logsPerChunk = 3;
		decorator.flowersPerChunk = 0;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 8;
		decorator.enableFern = true;
		decorator.mushroomsPerChunk = 3;
		decorator.waterlilyPerChunk = 3;
		decorator.canePerChunk = 10;
		decorator.reedPerChunk = 5;
		decorator.generateAthelas = true;
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_TALL, 500);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 500);
		decorator.addTree(LOTRTreeType.OAK_SWAMP, 1500);
		registerSwampFlowers();
		biomeColors.setGrass(8553036);
		biomeColors.setFoliage(8546875);
		biomeColors.setWater(5656380);

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);

	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ERIADOR.getSubregion("midgewater");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.MIDGEWATER;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}
}
