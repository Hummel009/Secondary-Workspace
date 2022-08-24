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

import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenDunlendingCampfire;
import lotr.common.world.structure2.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenEnedwaith extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 4);

	public LOTRBiomeGenEnedwaith(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 4, 1, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.DUNLENDINGS, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.DUNLENDING_WARRIORS, 10).setSpawnChance(600));
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK_SPRUCE);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND, 3.0f);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_SCRUBLAND, 1.0f);
		this.addBiomeVariant(LOTRBiomeVariant.MOUNTAIN);
		this.addBiomeVariant(LOTRBiomeVariant.WASTELAND);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.1f);
		decorator.treesPerChunk = 0;
		decorator.setTreeCluster(8, 30);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 1;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 4;
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_TALL, 300);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 200);
		decorator.addTree(LOTRTreeType.SPRUCE, 1000);
		decorator.addTree(LOTRTreeType.CHESTNUT, 1000);
		registerPlainsFlowers();
		decorator.addRandomStructure(new LOTRWorldGenDunlendingHouse(false), 25);
		decorator.addRandomStructure(new LOTRWorldGenDunlendingTavern(false), 100);
		decorator.addRandomStructure(new LOTRWorldGenDunlendingCampfire(false), 40);
		decorator.addRandomStructure(new LOTRWorldGenDunlandHillFort(false), 150);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.STONE(1, 3), 500);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 300);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_COMMON);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int i1;
		super.decorate(world, random, i, k);
		if (random.nextInt(24) == 0) {
			int boulders = 1 + random.nextInt(6);
			for (int l = 0; l < boulders; ++l) {
				i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		for (int l = 0; l < 2; ++l) {
			int k1;
			i1 = i + random.nextInt(16) + 8;
			int j1 = world.getHeightValue(i1, k1 = k + random.nextInt(16) + 8);
			if (j1 <= 75) {
				continue;
			}
			decorator.genTree(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ENEDWAITH.getSubregion("enedwaith");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.ENEDWAITH;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
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
