/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenNindalf extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 2, 4);

	public LOTRBiomeGenNindalf(int i, boolean major) {
		super(i, major);
		spawnableWaterCreatureList.clear();
		spawnableLOTRAmbientList.clear();
		clearBiomeVariants();
		variantChance = 1.0f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_SWAMP);
		decorator.sandPerChunk = 0;
		decorator.quagmirePerChunk = 2;
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 0;
		decorator.logsPerChunk = 2;
		decorator.flowersPerChunk = 0;
		decorator.grassPerChunk = 12;
		decorator.doubleGrassPerChunk = 8;
		decorator.enableFern = true;
		decorator.canePerChunk = 10;
		decorator.reedPerChunk = 2;
		decorator.waterlilyPerChunk = 3;
		decorator.addTree(LOTRTreeType.OAK, 1000);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.OAK_DEAD, 500);
		decorator.addTree(LOTRTreeType.SPRUCE, 1000);
		decorator.addTree(LOTRTreeType.SPRUCE_DEAD, 500);
		registerSwampFlowers();
		biomeColors.setGrass(7106635);
		biomeColors.setFoliage(7041093);
		biomeColors.setSky(9013080);
		biomeColors.setClouds(8224100);
		biomeColors.setFog(6579288);
		biomeColors.setWater(3159334);

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);

	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(24) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DEAD_MARSHES.getSubregion("nindalf");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.MORDOR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.5f;
	}
}
