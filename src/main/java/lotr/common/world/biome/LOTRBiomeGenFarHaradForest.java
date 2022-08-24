/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;

public class LOTRBiomeGenFarHaradForest extends LOTRBiomeGenFarHaradSavannah {
	public LOTRBiomeGenFarHaradForest(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		variantChance = 0.4f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
		decorator.treesPerChunk = 7;
		decorator.vinesPerChunk = 10;
		decorator.logsPerChunk = 3;
		decorator.grassPerChunk = 8;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 3;
		decorator.melonPerChunk = 0.08f;
		biomeColors.setGrass(11659848);
		biomeColors.setFoliage(8376636);
	}
}
