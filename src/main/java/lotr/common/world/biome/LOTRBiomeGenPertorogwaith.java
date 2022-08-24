/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
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
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenPertorogwaith extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);
	private WorldGenerator clayBoulderGen = new LOTRWorldGenBoulder(Blocks.hardened_clay, 0, 1, 3);
	private WorldGenerator deadMoundGen = new LOTRWorldGenBoulder(LOTRMod.wasteBlock, 0, 1, 3);

	public LOTRBiomeGenPertorogwaith(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityRhino.class, 8, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityGemsbok.class, 4, 4, 4));
		spawnableLOTRAmbientList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.HALF_TROLLS, 10).setSpawnChance(600));
		variantChance = 0.6f;
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND, 3.0f);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_SCRUBLAND, 2.0f);
		this.addBiomeVariant(LOTRBiomeVariant.WASTELAND, 4.0f);
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 4;
		decorator.flowersPerChunk = 0;
		decorator.canePerChunk = 10;
		decorator.addTree(LOTRTreeType.OAK_DESERT, 50);
		decorator.addTree(LOTRTreeType.OAK_DEAD, 100);
		decorator.addTree(LOTRTreeType.ACACIA, 100);
		decorator.addTree(LOTRTreeType.ACACIA_DEAD, 200);
		decorator.addTree(LOTRTreeType.BAOBAB, 10);
		registerHaradFlowers();
		decorator.addRandomStructure(new LOTRWorldGenHalfTrollHouse(false), 40);
		decorator.addRandomStructure(new LOTRWorldGenHalfTrollWarlordHouse(false), 200);
		biomeColors.setSky(8551538);
		biomeColors.setClouds(7500401);
		biomeColors.setFog(7500401);
		biomeColors.setWater(9080439);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return true;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int l;
		int k1;
		int i1;
		int boulders;
		super.decorate(world, random, i, k);
		if (random.nextInt(6) == 0) {
			boulders = 1 + random.nextInt(4);
			for (l = 0; l < boulders; ++l) {
				i1 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		if (random.nextInt(12) == 0) {
			boulders = 1 + random.nextInt(4);
			for (l = 0; l < boulders; ++l) {
				i1 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				clayBoulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		if (random.nextInt(40) == 0) {
			for (int l2 = 0; l2 < 3; ++l2) {
				int i12 = i + random.nextInt(16) + 8;
				int k12 = k + random.nextInt(16) + 8;
				int j1 = world.getHeightValue(i12, k12);
				deadMoundGen.generate(world, random, i12, j1, k12);
				new LOTRWorldGenSkullPile().generate(world, random, i12, j1, k12);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.PERDOROGWAITH.getSubregion("pertorogwaith");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.PERTOROGWAITH;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.05f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 2;
	}
}
