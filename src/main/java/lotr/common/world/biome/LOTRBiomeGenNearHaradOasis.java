/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.feature.LOTRTreeType;

public class LOTRBiomeGenNearHaradOasis extends LOTRBiomeGenNearHaradRiverbank {
	public LOTRBiomeGenNearHaradOasis(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.treesPerChunk = 3;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 4;
		decorator.flowersPerChunk = 5;
		decorator.doubleFlowersPerChunk = 2;
		decorator.addTree(LOTRTreeType.DATE_PALM, 2000);
		decorator.addTree(LOTRTreeType.OLIVE, 500);
		decorator.addTree(LOTRTreeType.OLIVE_LARGE, 200);
		decorator.addTree(LOTRTreeType.OAK_SHRUB, 3000);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.NEAR_HARAD.getSubregion("oasis");
	}

	@Override
	protected boolean hasMixedHaradSoils() {
		return false;
	}
}
