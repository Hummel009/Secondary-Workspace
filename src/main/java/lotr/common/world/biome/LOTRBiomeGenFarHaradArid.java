/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSand
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

public class LOTRBiomeGenFarHaradArid extends LOTRBiomeGenFarHaradSavannah {
	protected static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(35952060662L), 1);
	protected static NoiseGeneratorPerlin noiseSand = new NoiseGeneratorPerlin(new Random(5925366672L), 1);

	public LOTRBiomeGenFarHaradArid(int i, boolean major) {
		super(i, major);
		decorator.flowersPerChunk = 1;
		decorator.doubleFlowersPerChunk = 1;
		spawnableLOTRAmbientList.clear();
		biomeColors.setGrass(14073692);
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		double d = 0;
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = noiseDirt.func_151601_a(i * 0.07, k * 0.07);
		double d2 = noiseDirt.func_151601_a(i * 0.15, k * 0.15);
		double d3 = noiseSand.func_151601_a(i * 0.07, k * 0.07);
		noiseSand.func_151601_a(i * 0.15, k * 0.15);
		if (d3 + d > 0.6) {
			topBlock = Blocks.sand;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d2 > 0.1) {
			topBlock = Blocks.dirt;
			topBlockMeta = 1;
		}
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		topBlock = topBlock_pre;
		topBlockMeta = topBlockMeta_pre;
		fillerBlock = fillerBlock_pre;
		fillerBlockMeta = fillerBlockMeta_pre;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return super.getChanceToSpawnAnimals() * 0.5f;
	}

	@Override
	public LOTRBiome.GrassBlockAndMeta getRandomGrass(Random random) {
		return random.nextBoolean() ? new LOTRBiome.GrassBlockAndMeta(LOTRMod.aridGrass, 0) : super.getRandomGrass(random);
	}
}
