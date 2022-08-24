/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockTallGrass
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.spawning.*;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenRhunRedForest extends LOTRBiomeGenRhunLand {
	public LOTRBiomeGenRhunRedForest(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 16, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 20, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 10, 1, 4));
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.EASTERLING_WARRIORS, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.EASTERLING_WARRIORS, 8).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.5f;
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
		decorator.treesPerChunk = 6;
		decorator.logsPerChunk = 1;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 2;
		decorator.enableFern = true;
		decorator.addTree(LOTRTreeType.REDWOOD, 10000);
		decorator.addTree(LOTRTreeType.REDWOOD_2, 10000);
		decorator.addTree(LOTRTreeType.REDWOOD_3, 5000);
		decorator.addTree(LOTRTreeType.REDWOOD_4, 5000);
		decorator.addTree(LOTRTreeType.REDWOOD_5, 2000);
		registerForestFlowers();
		biomeColors.resetGrass();
		biomeColors.setGrass(8951356);
		biomeColors.setFog(11259063);
		biomeColors.setFoggy(true);
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		int chunkX = i & 0xF;
		int chunkZ = k & 0xF;
		int xzIndex = chunkX * 16 + chunkZ;
		int ySize = blocks.length / 256;
		if (variant.treeFactor >= 1.0f) {
			double d = 0;
			double d2 = 0;
			biomeTerrainNoise.func_151601_a(i * 0.05, k * 0.05);
			biomeTerrainNoise.func_151601_a(i * 0.4, k * 0.4);
			if (d2 + d > -0.8) {
				int index = xzIndex * ySize + height;
				if (random.nextFloat() < 0.75f) {
					blocks[index] = Blocks.dirt;
					meta[index] = 2;
				}
			}
		}
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public LOTRBiome.GrassBlockAndMeta getRandomGrass(Random random) {
		if (random.nextFloat() < 0.7f) {
			return new LOTRBiome.GrassBlockAndMeta(Blocks.tallgrass, 2);
		}
		return super.getRandomGrass(random);
	}
}
