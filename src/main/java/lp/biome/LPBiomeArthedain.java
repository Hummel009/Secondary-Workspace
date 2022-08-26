package lp.biome;

import java.util.Random;

import lotr.common.world.biome.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lp.map.LPWaypoint;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDoublePlant;

public class LPBiomeArthedain extends LOTRBiome {
	public LPBiomeArthedain(int i, boolean major) {
		super(i, major);
		variantChance = 0.25f;
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_SHIRE, 1.0f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_PLUM, 0.3f);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 6;
		decorator.generateLava = false;
		decorator.addTree(LOTRTreeType.OAK, 1000);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 400);
		decorator.addTree(LOTRTreeType.OAK_PARTY, 10);
		decorator.addTree(LOTRTreeType.CHESTNUT, 250);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 100);
		decorator.addTree(LOTRTreeType.BIRCH, 25);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 10);
		decorator.addTree(LOTRTreeType.ASPEN, 50);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 10);
		decorator.addTree(LOTRTreeType.APPLE, 5);
		decorator.addTree(LOTRTreeType.PEAR, 5);
		decorator.addTree(LOTRTreeType.CHERRY, 2);
		decorator.addTree(LOTRTreeType.PLUM, 5);
		registerPlainsFlowers();
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int i1;
		int k1;
		int j1;
		super.decorate(world, random, i, k);
		for (int l = 0; l < decorator.grassPerChunk / 2; ++l) {
			int i12 = i + random.nextInt(16) + 8;
			int j12 = random.nextInt(128);
			int k12 = k + random.nextInt(16) + 8;
			new LOTRWorldGenClover().generate(world, random, i12, j12, k12);
		}
		if (decorator.doubleFlowersPerChunk > 0 && random.nextInt(6) == 0) {
			i1 = i + random.nextInt(16) + 8;
			j1 = random.nextInt(128);
			k1 = k + random.nextInt(16) + 8;
			WorldGenDoublePlant doubleFlowerGen = new WorldGenDoublePlant();
			doubleFlowerGen.func_150548_a(0);
			doubleFlowerGen.generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ERIADOR.getSubregion("arthedain");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LPWaypoint.Region.ARTHEDAIN;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.ARNOR;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.5f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}