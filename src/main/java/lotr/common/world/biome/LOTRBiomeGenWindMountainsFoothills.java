/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.world.World
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class LOTRBiomeGenWindMountainsFoothills extends LOTRBiomeGenWindMountains {
	public LOTRBiomeGenWindMountainsFoothills(int i, boolean major) {
		super(i, major);
		biomeTerrain.resetXZScale();
		biomeTerrain.resetHeightStretchFactor();
		decorator.biomeGemFactor = 0.75f;
	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
	}
}
