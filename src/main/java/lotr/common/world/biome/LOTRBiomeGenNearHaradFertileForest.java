/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;

public class LOTRBiomeGenNearHaradFertileForest extends LOTRBiomeGenNearHaradFertile {
	public LOTRBiomeGenNearHaradFertileForest(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
		decorator.treesPerChunk = 6;
		decorator.addTree(LOTRTreeType.CEDAR, 6000);
		decorator.addTree(LOTRTreeType.CEDAR_LARGE, 1500);
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 1.0f;
	}

	@Override
	public int spawnCountMultiplier() {
		return super.spawnCountMultiplier() * 2;
	}
}
