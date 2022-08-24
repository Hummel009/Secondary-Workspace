/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 */
package lotr.common.world.biome;

import net.minecraft.init.Blocks;

public class LOTRBiomeGenLindonCoast extends LOTRBiomeGenLindon {
	public LOTRBiomeGenLindonCoast(int i, boolean major) {
		super(i, major);
		topBlock = Blocks.stone;
		topBlockMeta = 0;
		fillerBlock = topBlock;
		fillerBlockMeta = topBlockMeta;
		biomeTerrain.setXZScale(30.0);
		clearBiomeVariants();
	}
}
