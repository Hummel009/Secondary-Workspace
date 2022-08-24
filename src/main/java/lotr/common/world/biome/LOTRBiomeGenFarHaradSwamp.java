/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;

public class LOTRBiomeGenFarHaradSwamp extends LOTRBiomeGenFarHarad {
	public LOTRBiomeGenFarHaradSwamp(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableLOTRAmbientList.clear();
		clearBiomeVariants();
		variantChance = 1.0f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_SWAMP);
		decorator.sandPerChunk = 0;
		decorator.quagmirePerChunk = 1;
		decorator.treesPerChunk = 0;
		decorator.vinesPerChunk = 20;
		decorator.logsPerChunk = 3;
		decorator.flowersPerChunk = 0;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 8;
		decorator.enableFern = true;
		decorator.mushroomsPerChunk = 3;
		decorator.waterlilyPerChunk = 3;
		decorator.canePerChunk = 10;
		decorator.reedPerChunk = 3;
		decorator.addTree(LOTRTreeType.OAK_SWAMP, 1000);
		registerSwampFlowers();
		biomeColors.setWater(5607038);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.FAR_HARAD.getSubregion("swamp");
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}
}
