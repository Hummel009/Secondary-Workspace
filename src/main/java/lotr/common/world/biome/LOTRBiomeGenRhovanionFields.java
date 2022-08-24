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

import lotr.common.entity.animal.LOTREntityHorse;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenRhovanionFields extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public LOTRBiomeGenRhovanionFields(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 2, 6));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.DALE_SOLDIERS, 10).setSpawnChance(600));
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK_SPRUCE);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.4f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.4f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.4f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_PLUM, 0.5f);
		decorator.setTreeCluster(8, 20);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 2;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 5;
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.OAK_DEAD, 10);
		decorator.addTree(LOTRTreeType.SPRUCE, 200);
		decorator.addTree(LOTRTreeType.SPRUCE_DEAD, 10);
		decorator.addTree(LOTRTreeType.CHESTNUT, 100);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 20);
		decorator.addTree(LOTRTreeType.MAPLE, 200);
		decorator.addTree(LOTRTreeType.PINE, 200);
		decorator.addTree(LOTRTreeType.FIR, 200);
		decorator.addTree(LOTRTreeType.APPLE, 5);
		decorator.addTree(LOTRTreeType.PEAR, 5);
		decorator.addTree(LOTRTreeType.PLUM, 5);
		registerPlainsFlowers();
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(60) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DALE.getSubregion("dale");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.DALE;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.DALE;
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
