/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenFlowers
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenDorEnErnil extends LOTRBiome {
	public LOTRBiomeGenDorEnErnil(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 30, 2, 6));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntitySwan.class, 20, 4, 8));
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.DENSEFOREST_BIRCH);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_ORANGE, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_LEMON, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_LIME, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_OLIVE, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_ALMOND, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_PLUM, 0.1f);
		decorator.addSoil(new WorldGenMinable(LOTRMod.rock, 1, 60, Blocks.stone), 2.0f, 0, 64);
		decorator.treesPerChunk = 0;
		decorator.setTreeCluster(10, 30);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 4;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 4;
		decorator.generateAthelas = true;
		decorator.whiteSand = true;
		decorator.addTree(LOTRTreeType.BIRCH, 200);
		decorator.addTree(LOTRTreeType.BIRCH_TALL, 200);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 200);
		decorator.addTree(LOTRTreeType.OAK, 100);
		decorator.addTree(LOTRTreeType.OAK_TALL, 100);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.CEDAR, 100);
		decorator.addTree(LOTRTreeType.CYPRESS, 50);
		decorator.addTree(LOTRTreeType.CYPRESS_LARGE, 10);
		decorator.addTree(LOTRTreeType.APPLE, 5);
		decorator.addTree(LOTRTreeType.PEAR, 5);
		decorator.addTree(LOTRTreeType.LEMON, 5);
		decorator.addTree(LOTRTreeType.ORANGE, 5);
		decorator.addTree(LOTRTreeType.LIME, 5);
		decorator.addTree(LOTRTreeType.OLIVE, 5);
		decorator.addTree(LOTRTreeType.OLIVE_LARGE, 2);
		decorator.addTree(LOTRTreeType.ALMOND, 5);
		decorator.addTree(LOTRTreeType.PLUM, 5);
		registerPlainsFlowers();

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);

	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(24) == 0) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = random.nextInt(128);
			int k1 = k + random.nextInt(16) + 8;
			new WorldGenFlowers(LOTRMod.pipeweedPlant).generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.GONDOR.getSubregion("dolAmroth");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.DOR_EN_ERNIL;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.DOL_AMROTH;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.03f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 4;
	}
}
