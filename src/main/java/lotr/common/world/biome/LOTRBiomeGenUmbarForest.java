/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;

public class LOTRBiomeGenUmbarForest extends LOTRBiomeGenUmbar {
	public LOTRBiomeGenUmbarForest(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
		decorator.treesPerChunk = 7;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 12;
		decorator.doubleGrassPerChunk = 4;
		registerForestFlowers();
	}

	@Override
	public int spawnCountMultiplier() {
		return super.spawnCountMultiplier() * 2;
	}
}
