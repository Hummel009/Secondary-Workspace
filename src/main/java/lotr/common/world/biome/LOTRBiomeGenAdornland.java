/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenDunlendingCampfire;
import lotr.common.world.structure2.*;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenAdornland extends LOTRBiome {
	private WorldGenerator boulderGenStone = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 4);
	private WorldGenerator boulderGenRohan = new LOTRWorldGenBoulder(LOTRMod.rock, 2, 1, 4);

	public LOTRBiomeGenAdornland(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 10, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 4, 1, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityCrebain.class, 10, 4, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.DUNLENDINGS, 20).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.DUNLENDING_WARRIORS, 5).setSpawnChance(600));
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.BOULDERS_ROHAN);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 0.5f);
		decorator.addSoil(new WorldGenMinable(LOTRMod.rock, 2, 60, Blocks.stone), 2.0f, 0, 64);
		decorator.setTreeCluster(12, 30);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 2;
		decorator.grassPerChunk = 12;
		decorator.doubleGrassPerChunk = 3;
		decorator.addTree(LOTRTreeType.OAK, 300);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 300);
		decorator.addTree(LOTRTreeType.SPRUCE, 300);
		decorator.addTree(LOTRTreeType.BIRCH, 20);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 10);
		decorator.addTree(LOTRTreeType.BEECH, 20);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 10);
		decorator.addTree(LOTRTreeType.CHESTNUT, 50);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 10);
		decorator.addTree(LOTRTreeType.FIR, 300);
		decorator.addTree(LOTRTreeType.PINE, 300);
		decorator.addTree(LOTRTreeType.APPLE, 2);
		decorator.addTree(LOTRTreeType.PEAR, 2);
		registerPlainsFlowers();
		addFlower(LOTRMod.simbelmyne, 0, 1);
		decorator.addRandomStructure(new LOTRWorldGenDunlendingHouse(false), 25);
		decorator.addRandomStructure(new LOTRWorldGenDunlendingTavern(false), 100);
		decorator.addRandomStructure(new LOTRWorldGenDunlendingCampfire(false), 40);
		decorator.addRandomStructure(new LOTRWorldGenDunlandHillFort(false), 150);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.STONE(1, 3), 500);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 300);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_COMMON);
	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return false;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int i1;
		int k1;
		int l;
		super.decorate(world, random, i, k);
		if (random.nextInt(60) == 0) {
			for (l = 0; l < 3; ++l) {
				i1 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				boulderGenStone.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		if (random.nextInt(60) == 0) {
			for (l = 0; l < 3; ++l) {
				i1 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				boulderGenRohan.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DUNLAND.getSubregion("adorn");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.ROHAN;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.75f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.ROHAN;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.15f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
