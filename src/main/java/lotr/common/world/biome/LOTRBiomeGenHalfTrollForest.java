/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.*;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenHalfTrollForest extends LOTRBiomeGenFarHarad {
	private WorldGenerator deadMoundGen = new LOTRWorldGenBoulder(LOTRMod.wasteBlock, 0, 1, 2);

	public LOTRBiomeGenHalfTrollForest(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityRhino.class, 8, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityGemsbok.class, 4, 4, 4));
		spawnableLOTRAmbientList.clear();
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.HALF_TROLLS, 10).setSpawnChance(600));
		clearBiomeVariants();
		variantChance = 0.7f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.CLEARING);
		this.addBiomeVariant(LOTRBiomeVariant.WASTELAND);
		decorator.treesPerChunk = 3;
		decorator.vinesPerChunk = 4;
		decorator.logsPerChunk = 2;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 10;
		decorator.flowersPerChunk = 1;
		decorator.doubleFlowersPerChunk = 1;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.ACACIA, 600);
		decorator.addTree(LOTRTreeType.OAK_DESERT, 200);
		decorator.addTree(LOTRTreeType.BAOBAB, 20);
		decorator.addTree(LOTRTreeType.ACACIA_DEAD, 300);
		decorator.addTree(LOTRTreeType.OAK_DEAD, 100);
		decorator.addRandomStructure(new LOTRWorldGenHalfTrollHouse(false), 40);
		decorator.addRandomStructure(new LOTRWorldGenHalfTrollWarlordHouse(false), 200);
		biomeColors.setSky(12698028);
		biomeColors.setClouds(14869216);
		biomeColors.setFog(8885125);
		biomeColors.setFoggy(true);
		biomeColors.setWater(10923394);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return true;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(40) == 0) {
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
		return LOTRMusicRegion.PERDOROGWAITH.getSubregion("pertorogwaith");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.PERTOROGWAITH_FOREST;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.05f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.5f;
	}
}
