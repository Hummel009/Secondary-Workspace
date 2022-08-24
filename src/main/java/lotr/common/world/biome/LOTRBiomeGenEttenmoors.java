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
import lotr.common.world.structure2.*;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenEttenmoors extends LOTRBiome {
	private WorldGenerator boulderGenLarge = new LOTRWorldGenBoulder(Blocks.stone, 0, 2, 5);
	private WorldGenerator boulderGenSmall = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 2);

	public LOTRBiomeGenEttenmoors(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 10, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityElk.class, 6, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 6, 1, 4));
		spawnableLOTRAmbientList.clear();
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBird.class, 10, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityButterfly.class, 10, 4, 4));
		npcSpawnList.newFactionList(80).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.GUNDABAD_ORCS, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.GUNDABAD_WARGS, 2).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.GUNDABAD_URUKS, 1).setSpawnChance(600));
		npcSpawnList.newFactionList(20).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.TROLLS, 10).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.75f;
		biomeTerrain.setXZScale(100.0);
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 1.0f);
		decorator.biomeGemFactor = 0.75f;
		decorator.flowersPerChunk = 1;
		decorator.grassPerChunk = 4;
		decorator.doubleGrassPerChunk = 2;
		decorator.generateAthelas = true;
		decorator.addTree(LOTRTreeType.FIR, 400);
		decorator.addTree(LOTRTreeType.PINE, 800);
		decorator.addTree(LOTRTreeType.SPRUCE, 500);
		decorator.addTree(LOTRTreeType.SPRUCE_THIN, 500);
		decorator.addTree(LOTRTreeType.SPRUCE_DEAD, 200);
		decorator.addTree(LOTRTreeType.SPRUCE_MEGA, 100);
		registerTaigaFlowers();
		decorator.addRandomStructure(new LOTRWorldGenRuinedHouse(false), 4000);
		decorator.addRandomStructure(new LOTRWorldGenBurntHouse(false), 4000);
		decorator.addRandomStructure(new LOTRWorldGenRottenHouse(false), 4000);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.STONE(1, 4), 1000);
		decorator.addRandomStructure(new LOTRWorldGenDaleWatchtower(false), 500);
		decorator.addRandomStructure(new LOTRWorldGenDaleFortress(false), 800);
		decorator.addRandomStructure(new LOTRWorldGenDaleVillage(false), 400);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 500);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int i1;
		int k1;
		int l;
		super.decorate(world, random, i, k);
		for (l = 0; l < 3; ++l) {
			i1 = i + random.nextInt(16) + 8;
			int j1 = world.getHeightValue(i1, k1 = k + random.nextInt(16) + 8);
			if (j1 <= 84) {
				continue;
			}
			decorator.genTree(world, random, i1, j1, k1);
		}
		if (random.nextInt(4) == 0) {
			for (l = 0; l < 3; ++l) {
				i1 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				boulderGenLarge.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		for (l = 0; l < 2; ++l) {
			i1 = i + random.nextInt(16) + 8;
			k1 = k + random.nextInt(16) + 8;
			boulderGenSmall.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ANGMAR.getSubregion("ettenmoors");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.ETTENMOORS;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}
}
