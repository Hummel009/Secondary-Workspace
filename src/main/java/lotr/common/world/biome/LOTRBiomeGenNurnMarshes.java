/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;

public class LOTRBiomeGenNurnMarshes extends LOTRBiomeGenNurn {
	public LOTRBiomeGenNurnMarshes(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		variantChance = 1.0f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_SWAMP);
		decorator.sandPerChunk = 0;
		decorator.quagmirePerChunk = 1;
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 1;
		decorator.logsPerChunk = 2;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 10;
		decorator.enableFern = true;
		decorator.canePerChunk = 10;
		decorator.reedPerChunk = 4;
	}
}
