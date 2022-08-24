/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;

public class LOTRBiomeGenGulfHaradForest extends LOTRBiomeGenGulfHarad {
	public LOTRBiomeGenGulfHaradForest(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
		decorator.treesPerChunk = 5;
		decorator.addTree(LOTRTreeType.DRAGONBLOOD, 1000);
		decorator.addTree(LOTRTreeType.DRAGONBLOOD_LARGE, 400);
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
