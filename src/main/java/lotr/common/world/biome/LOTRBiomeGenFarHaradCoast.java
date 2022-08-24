/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.block.BlockSand
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.entity.animal.*;
import lotr.common.entity.npc.LOTREntityBanditHarad;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

public class LOTRBiomeGenFarHaradCoast extends LOTRBiomeGenFarHaradSavannah {
	protected static NoiseGeneratorPerlin noiseGrass = new NoiseGeneratorPerlin(new Random(75796728360672L), 1);
	protected static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(63275968906L), 1);
	protected static NoiseGeneratorPerlin noiseSand = new NoiseGeneratorPerlin(new Random(127425276902L), 1);
	protected static NoiseGeneratorPerlin noiseSandstone = new NoiseGeneratorPerlin(new Random(267215026920L), 1);

	public LOTRBiomeGenFarHaradCoast(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityLion.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityLioness.class, 4, 2, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityZebra.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityRhino.class, 8, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityGemsbok.class, 8, 4, 8));
		topBlock = Blocks.stone;
		topBlockMeta = 0;
		fillerBlock = topBlock;
		fillerBlockMeta = topBlockMeta;
		biomeTerrain.setXZScale(30.0);
		clearBiomeVariants();
		decorator.addTree(LOTRTreeType.PALM, 4000);
		decorator.treesPerChunk = 1;
		clearTravellingTraders();
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_COMMON);
		setBanditEntityClass(LOTREntityBanditHarad.class);
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		double d = 0;
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = noiseGrass.func_151601_a(i * 0.06, k * 0.06);
		double d2 = noiseGrass.func_151601_a(i * 0.47, k * 0.47);
		double d3 = noiseDirt.func_151601_a(i * 0.06, k * 0.06);
		double d4 = noiseDirt.func_151601_a(i * 0.47, k * 0.47);
		double d5 = noiseSand.func_151601_a(i * 0.06, k * 0.06);
		double d6 = noiseSand.func_151601_a(i * 0.47, k * 0.47);
		double d7 = noiseSandstone.func_151601_a(i * 0.06, k * 0.06);
		noiseSandstone.func_151601_a(i * 0.47, k * 0.47);
		if (d7 + d > 0.8) {
			topBlock = Blocks.sandstone;
			topBlockMeta = 0;
			fillerBlock = Blocks.sand;
			fillerBlockMeta = 0;
		} else if (d5 + d6 > 0.6) {
			topBlock = Blocks.sand;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d3 + d4 > 0.5) {
			topBlock = Blocks.dirt;
			topBlockMeta = 1;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d2 > 0.4) {
			topBlock = Blocks.grass;
			topBlockMeta = 0;
			fillerBlock = Blocks.dirt;
			fillerBlockMeta = 0;
		}
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		topBlock = topBlock_pre;
		topBlockMeta = topBlockMeta_pre;
		fillerBlock = fillerBlock_pre;
		fillerBlockMeta = fillerBlockMeta_pre;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}
}
