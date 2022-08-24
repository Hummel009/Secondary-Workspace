/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenAbstractTree
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenRohanUruk extends LOTRBiomeGenCalenardhon {
	private WorldGenerator deadMoundGen = new LOTRWorldGenBoulder(LOTRMod.wasteBlock, 0, 1, 3);

	public LOTRBiomeGenRohanUruk(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK);
		decorator.resetTreeCluster();
		decorator.willowPerChunk = 0;
		decorator.flowersPerChunk = 1;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 1;
		clearTravellingTraders();
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);
	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return true;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(30) == 0) {
			WorldGenAbstractTree treeGen = random.nextInt(3) == 0 ? LOTRTreeType.OAK_DEAD.create(false, random) : LOTRTreeType.CHARRED.create(false, random);
			int trees = 3 + random.nextInt(5);
			for (int l = 0; l < trees; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				treeGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		if (random.nextInt(32) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				int j1 = world.getHeightValue(i1, k1);
				deadMoundGen.generate(world, random, i1, j1, k1);
				new LOTRWorldGenSkullPile().generate(world, random, i1, j1, k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ISENGARD.getSubregion("rohan");
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
