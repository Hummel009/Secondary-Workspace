/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

public class LOTRBiomeGenEasternDesolation extends LOTRBiomeGenNurn {
	public LOTRBiomeGenEasternDesolation(int i, boolean major) {
		super(i, major);
		decorator.clearRandomStructures();
		decorator.treesPerChunk = 5;
	}
}
