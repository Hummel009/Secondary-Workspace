/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;

public class LOTRBiomeGenLamedonHills extends LOTRBiomeGenLamedon {
	public LOTRBiomeGenLamedonHills(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		variantChance = 0.5f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		decorator.treesPerChunk = 1;
		biomeColors.resetGrass();
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public int spawnCountMultiplier() {
		return super.spawnCountMultiplier() * 2;
	}
}
