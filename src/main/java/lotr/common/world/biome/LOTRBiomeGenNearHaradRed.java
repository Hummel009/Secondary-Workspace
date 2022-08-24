/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSand
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.biome.BiomeGenBase
 */
package lotr.common.world.biome;

import net.minecraft.init.Blocks;

public class LOTRBiomeGenNearHaradRed extends LOTRBiomeGenNearHarad {
	public LOTRBiomeGenNearHaradRed(int i, boolean major) {
		super(i, major);
		setDisableRain();
		topBlock = Blocks.sand;
		topBlockMeta = 1;
		fillerBlock = Blocks.sand;
		fillerBlockMeta = 1;
	}
}
