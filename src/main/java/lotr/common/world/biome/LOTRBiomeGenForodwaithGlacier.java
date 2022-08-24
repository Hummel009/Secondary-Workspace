/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 */
package lotr.common.world.biome;

import net.minecraft.init.Blocks;

public class LOTRBiomeGenForodwaithGlacier extends LOTRBiomeGenForodwaithMountains {
	public LOTRBiomeGenForodwaithGlacier(int i, boolean major) {
		super(i, major);
		topBlock = Blocks.ice;
		fillerBlock = Blocks.ice;
	}
}
