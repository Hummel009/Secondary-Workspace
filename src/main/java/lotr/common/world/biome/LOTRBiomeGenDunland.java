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
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenDunland extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public LOTRBiomeGenDunland(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 4, 1, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityCrebain.class, 10, 4, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.DUNLENDINGS, 3).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.DUNLENDING_WARRIORS, 1).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.5f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.4f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.4f);
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 1;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 1;
		decorator.addTree(LOTRTreeType.SPRUCE, 500);
		decorator.addTree(LOTRTreeType.OAK_TALL, 200);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 20);
		decorator.addTree(LOTRTreeType.CHESTNUT, 50);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 10);
		decorator.addTree(LOTRTreeType.FIR, 500);
		decorator.addTree(LOTRTreeType.PINE, 500);
		registerForestFlowers();
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_COMMON);
		decorator.addRandomStructure(new LOTRWorldGenDunlendingHouse(false), 25);
		decorator.addRandomStructure(new LOTRWorldGenDunlendingTavern(false), 100);
		decorator.addRandomStructure(new LOTRWorldGenDunlendingCampfire(false), 40);
		decorator.addRandomStructure(new LOTRWorldGenDunlandHillFort(false), 150);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.STONE(1, 3), 500);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 300);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int i1;
		int k1;
		super.decorate(world, random, i, k);
		for (int count = 0; count < 6; ++count) {
			i1 = i + random.nextInt(16) + 8;
			int j1 = world.getHeightValue(i1, k1 = k + random.nextInt(16) + 8);
			if (j1 <= 85) {
				continue;
			}
			decorator.genTree(world, random, i1, j1, k1);
		}
		if (random.nextInt(8) == 0) {
			for (int l = 0; l < 4; ++l) {
				i1 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DUNLAND.getSubregion("dunland");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.DUNLAND;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.75f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 2;
	}
}
