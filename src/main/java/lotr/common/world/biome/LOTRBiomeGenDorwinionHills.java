/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.LOTRMod;
import lotr.common.world.biome.variant.LOTRBiomeVariant;

public class LOTRBiomeGenDorwinionHills extends LOTRBiomeGenDorwinion {
	public LOTRBiomeGenDorwinionHills(int i, boolean major) {
		super(i, major);
		fillerBlock = LOTRMod.rock;
		fillerBlockMeta = 5;
		biomeTerrain.setXZScale(50.0);
		clearBiomeVariants();
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		decorator.flowersPerChunk = 3;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 5;

	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}

	@Override
	public boolean hasDomesticAnimals() {
		return false;
	}

	@Override
	public int spawnCountMultiplier() {
		return super.spawnCountMultiplier() * 3;
	}
}
