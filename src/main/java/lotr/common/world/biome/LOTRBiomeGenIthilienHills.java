/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;

public class LOTRBiomeGenIthilienHills extends LOTRBiomeGenIthilien {
	public LOTRBiomeGenIthilienHills(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		variantChance = 0.2f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		decorator.treesPerChunk = 0;
		decorator.logsPerChunk = 0;
		decorator.flowersPerChunk = 2;
		decorator.grassPerChunk = 8;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}
}
