/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSand
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LOTRBiomeGenRhunLandHills extends LOTRBiomeGenRhunLand {
	private static NoiseGeneratorPerlin noiseStone = new NoiseGeneratorPerlin(new Random(528592609698295062L), 1);
	private static NoiseGeneratorPerlin noiseSand = new NoiseGeneratorPerlin(new Random(23849150950915615L), 1);

	public LOTRBiomeGenRhunLandHills(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		decorator.addOre(new WorldGenMinable(Blocks.gold_ore, 4), 2.0f, 0, 48);
		decorator.resetTreeCluster();
		decorator.flowersPerChunk = 2;
		decorator.doubleFlowersPerChunk = 0;
		decorator.grassPerChunk = 5;
		decorator.doubleGrassPerChunk = 1;
		biomeColors.resetGrass();
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		double d = 0;
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = noiseStone.func_151601_a(i * 0.09, k * 0.09);
		double d2 = noiseStone.func_151601_a(i * 0.4, k * 0.4);
		double d3 = noiseSand.func_151601_a(i * 0.09, k * 0.09);
		noiseSand.func_151601_a(i * 0.4, k * 0.4);
		if (d3 + d > 1.1) {
			topBlock = Blocks.sand;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d2 > 0.4) {
			topBlock = Blocks.stone;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		}
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		topBlock = topBlock_pre;
		topBlockMeta = topBlockMeta_pre;
		fillerBlock = fillerBlock_pre;
		fillerBlockMeta = fillerBlockMeta_pre;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}
}
