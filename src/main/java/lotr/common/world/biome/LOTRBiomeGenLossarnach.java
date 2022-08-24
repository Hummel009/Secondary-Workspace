/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.World
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.world.World;

public class LOTRBiomeGenLossarnach extends LOTRBiomeGenGondor {
	public LOTRBiomeGenLossarnach(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.DENSEFOREST_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 3.0f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_PLUM, 2.0f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_OLIVE, 1.0f);
		decorator.treesPerChunk = 0;
		decorator.flowersPerChunk = 12;
		decorator.doubleFlowersPerChunk = 4;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 2;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.DARK_OAK, 400);
		decorator.addTree(LOTRTreeType.BIRCH, 300);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 100);
		decorator.addTree(LOTRTreeType.BEECH, 50);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 10);
		decorator.addTree(LOTRTreeType.MAPLE, 50);
		decorator.addTree(LOTRTreeType.MAPLE_LARGE, 10);
		decorator.addTree(LOTRTreeType.CHESTNUT, 50);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 10);
		decorator.addTree(LOTRTreeType.APPLE, 40);
		decorator.addTree(LOTRTreeType.PEAR, 40);
		decorator.addTree(LOTRTreeType.PLUM, 20);
		decorator.addTree(LOTRTreeType.OLIVE, 5);
		decorator.addTree(LOTRTreeType.OLIVE_LARGE, 10);
		decorator.addTree(LOTRTreeType.ALMOND, 5);
		decorator.addTree(LOTRTreeType.OAK_SHRUB, 600);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		for (int l = 0; l < 3; ++l) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = random.nextInt(128);
			int k1 = k + random.nextInt(16) + 8;
			new LOTRWorldGenBerryBush().generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.GONDOR.getSubregion("lossarnach");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.LOSSARNACH;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.4f;
	}
}
