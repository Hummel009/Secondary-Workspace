/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.material.Material
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 *  net.minecraft.world.gen.feature.WorldGenFlowers
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.spawning.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LOTRBiomeGenMorgulVale extends LOTRBiomeGenMordor {
	private NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(1860286702860L), 1);
	private NoiseGeneratorPerlin noiseGravel = new NoiseGeneratorPerlin(new Random(8903486028509023054L), 1);
	private NoiseGeneratorPerlin noiseRock = new NoiseGeneratorPerlin(new Random(769385178389572607L), 1);

	public LOTRBiomeGenMorgulVale(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.MORDOR_ORCS, 15).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.MORDOR_WARGS, 2).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.BLACK_URUKS, 2).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.OLOG_HAI, 2).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.5f;
		topBlock = Blocks.grass;
		fillerBlock = Blocks.dirt;
		decorator.addOre(new WorldGenMinable(LOTRMod.oreGulduril, 1, 8, LOTRMod.rock), 10.0f, 0, 60);
		decorator.treesPerChunk = 0;
		decorator.grassPerChunk = 3;
		decorator.dryReedChance = 1.0f;
		decorator.addTree(LOTRTreeType.OAK, 200);
		decorator.addTree(LOTRTreeType.OAK_DESERT, 500);
		decorator.addTree(LOTRTreeType.OAK_DEAD, 500);
		decorator.addTree(LOTRTreeType.CHARRED, 500);
		biomeColors.resetFog();
		biomeColors.setFoggy(false);
		biomeColors.setGrass(6054733);
		biomeColors.setFoliage(4475954);
		biomeColors.setSky(7835270);
		biomeColors.setClouds(5860197);
		biomeColors.setFog(6318950);
		biomeColors.setWater(3563598);
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		double d = 0;
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = noiseDirt.func_151601_a(i * 0.06, k * 0.06);
		double d2 = noiseDirt.func_151601_a(i * 0.3, k * 0.3);
		double d3 = noiseGravel.func_151601_a(i * 0.06, k * 0.06);
		double d4 = noiseGravel.func_151601_a(i * 0.3, k * 0.3);
		double d5 = noiseRock.func_151601_a(i * 0.06, k * 0.06);
		noiseRock.func_151601_a(i * 0.3, k * 0.3);
		if (d5 + d > 1.1) {
			topBlock = LOTRMod.rock;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d3 + d4 > 0.7) {
			topBlock = LOTRMod.mordorGravel;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d2 > 0.7) {
			topBlock = LOTRMod.mordorDirt;
			topBlockMeta = 1;
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
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.MORDOR.getSubregion("morgulVale");
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.2f;
	}

	@Override
	protected boolean hasMordorSoils() {
		return false;
	}

	@Override
	public boolean isGorgoroth() {
		return false;
	}
}
