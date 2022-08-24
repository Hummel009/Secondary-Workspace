package lotr.common.world.biome;

import java.util.Random;

import lotr.common.*;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenRohan extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(LOTRMod.rock, 2, 1, 4);

	public LOTRBiomeGenRohan(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 30, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 3, 1, 4));
		variantChance = 0.3f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.BOULDERS_ROHAN);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 0.5f);
		decorator.addSoil(new WorldGenMinable(LOTRMod.rock, 2, 60, Blocks.stone), 2.0f, 0, 64);
		decorator.setTreeCluster(12, 30);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 4;
		decorator.grassPerChunk = 15;
		decorator.doubleGrassPerChunk = 5;
		decorator.addTree(LOTRTreeType.OAK, 400);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 800);
		decorator.addTree(LOTRTreeType.BIRCH, 20);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 10);
		decorator.addTree(LOTRTreeType.BEECH, 20);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 10);
		decorator.addTree(LOTRTreeType.PINE, 20);
		decorator.addTree(LOTRTreeType.APPLE, 2);
		decorator.addTree(LOTRTreeType.PEAR, 2);
		registerPlainsFlowers();
		addFlower(LOTRMod.simbelmyne, 0, 2);

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);

	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return false;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(32) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public LOTRAchievement getBiomeAchievement() {
		return LOTRAchievement.enterRohan;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ROHAN.getSubregion("rohan");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.ROHAN;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.ROHAN_MIX.setRepair(0.9f);
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.05f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
