/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;

public class LOTRBiomeGenLothlorienEdge extends LOTRBiomeGenLothlorien {
	public LOTRBiomeGenLothlorienEdge(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
		decorator.treesPerChunk = 3;
		decorator.flowersPerChunk = 2;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 1;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.OAK, 300);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 50);
		decorator.addTree(LOTRTreeType.LARCH, 200);
		decorator.addTree(LOTRTreeType.BEECH, 100);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 20);
		decorator.addTree(LOTRTreeType.MALLORN, 100);
		decorator.addTree(LOTRTreeType.MALLORN_BOUGHS, 50);
		decorator.addTree(LOTRTreeType.MALLORN_PARTY, 5);
		decorator.addTree(LOTRTreeType.ASPEN, 100);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 20);

	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.LOTHLORIEN.getSubregion("edge");
	}

	@Override
	public int spawnCountMultiplier() {
		return super.spawnCountMultiplier() * 4;
	}
}
