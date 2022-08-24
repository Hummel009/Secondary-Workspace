/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenFangorn extends LOTRBiome {
	public LOTRBiomeGenFangorn(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 30, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 4, 1, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityCrebain.class, 6, 4, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.ENTS, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.HUORNS, 20).setSpawnChance(600));
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		decorator.treesPerChunk = 12;
		decorator.willowPerChunk = 3;
		decorator.logsPerChunk = 5;
		decorator.flowersPerChunk = 6;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 12;
		decorator.doubleGrassPerChunk = 6;
		decorator.enableFern = true;
		decorator.addTree(LOTRTreeType.DARK_OAK, 400);
		decorator.addTree(LOTRTreeType.OAK, 100);
		decorator.addTree(LOTRTreeType.OAK_TALL, 200);
		decorator.addTree(LOTRTreeType.OAK_TALLER, 200);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.BIRCH, 20);
		decorator.addTree(LOTRTreeType.BIRCH_TALL, 20);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 10);
		decorator.addTree(LOTRTreeType.BEECH, 20);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 10);
		decorator.addTree(LOTRTreeType.OAK_FANGORN, 50);
		decorator.addTree(LOTRTreeType.BEECH_FANGORN, 20);
		decorator.addTree(LOTRTreeType.ASPEN, 50);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 10);
		registerForestFlowers();
		addFlower(LOTRMod.fangornPlant, 0, 1);
		addFlower(LOTRMod.fangornPlant, 1, 1);
		addFlower(LOTRMod.fangornPlant, 2, 1);
		addFlower(LOTRMod.fangornPlant, 3, 1);
		addFlower(LOTRMod.fangornPlant, 4, 1);
		addFlower(LOTRMod.fangornPlant, 5, 1);
		biomeColors.setSky(7774322);
		biomeColors.setFog(3308875);
		biomeColors.setFoggy(true);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int j1;
		int k1;
		int i1;
		super.decorate(world, random, i, k);
		if (random.nextInt(2) == 0) {
			i1 = i + random.nextInt(16) + 8;
			k1 = k + random.nextInt(16) + 8;
			for (j1 = 64 + random.nextInt(64); j1 > 0 && world.getBlock(i1, j1 - 1, k1) == Blocks.air; --j1) {
			}
			new LOTRWorldGenWaterPlant(LOTRMod.fangornRiverweed).generate(world, random, i1, j1, k1);
		}
		if (random.nextInt(10) == 0) {
			i1 = i + random.nextInt(16) + 8;
			k1 = k + random.nextInt(16) + 8;
			j1 = world.getHeightValue(i1, k1);
			new LOTRWorldGenEntJars().generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.FANGORN.getSubregion("fangorn");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.FANGORN;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	public LOTRBiomeGenFangorn setBirchFangorn() {
		decorator.addTree(LOTRTreeType.BIRCH, 2000);
		decorator.addTree(LOTRTreeType.BIRCH_TALL, 2000);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 2000);
		decorator.addTree(LOTRTreeType.BIRCH_FANGORN, 1000);
		return this;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
