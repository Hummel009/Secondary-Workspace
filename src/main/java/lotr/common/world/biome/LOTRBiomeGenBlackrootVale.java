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

import lotr.common.LOTRMod;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenBlackrootVale extends LOTRBiomeGenGondor {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 2);

	public LOTRBiomeGenBlackrootVale(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		variantChance = 0.3f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.DENSEFOREST_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_PLUM, 0.5f);
		decorator.setTreeCluster(8, 20);
		decorator.treesPerChunk = 0;
		decorator.flowersPerChunk = 8;
		decorator.doubleFlowersPerChunk = 2;
		decorator.grassPerChunk = 12;
		decorator.doubleGrassPerChunk = 3;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.DARK_OAK, 500);
		decorator.addTree(LOTRTreeType.FIR, 300);
		decorator.addTree(LOTRTreeType.LARCH, 300);
		decorator.addTree(LOTRTreeType.ASPEN, 100);
		decorator.addTree(LOTRTreeType.BIRCH, 50);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 10);
		decorator.addTree(LOTRTreeType.CHESTNUT, 200);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 50);
		decorator.addTree(LOTRTreeType.APPLE, 5);
		decorator.addTree(LOTRTreeType.PEAR, 5);
		decorator.addTree(LOTRTreeType.PLUM, 5);
		decorator.addTree(LOTRTreeType.OLIVE, 1);
		decorator.addTree(LOTRTreeType.ALMOND, 1);
		addFlower(LOTRMod.blackroot, 0, 60);
		biomeColors.setGrass(7704878);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(30) == 0) {
			for (int l = 0; l < 5; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.GONDOR.getSubregion("blackroot");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.BLACKROOT_VALE;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.2f;
	}
}
