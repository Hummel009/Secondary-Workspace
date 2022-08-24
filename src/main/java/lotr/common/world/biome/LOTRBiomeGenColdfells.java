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
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.*;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenColdfells extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 2, 4);

	public LOTRBiomeGenColdfells(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 10, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityElk.class, 4, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 6, 1, 4));
		npcSpawnList.newFactionList(80).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.GUNDABAD_ORCS, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.GUNDABAD_WARGS, 2).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.GUNDABAD_URUKS, 1).setSpawnChance(600));
		npcSpawnList.newFactionList(20).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.TROLLS, 10).setSpawnChance(600));
		decorator.biomeGemFactor = 0.75f;
		decorator.treesPerChunk = 2;
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 2;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 2;
		decorator.generateAthelas = true;
		decorator.addTree(LOTRTreeType.FIR, 500);
		decorator.addTree(LOTRTreeType.PINE, 500);
		decorator.addTree(LOTRTreeType.SPRUCE, 400);
		decorator.addTree(LOTRTreeType.SPRUCE_THIN, 200);
		decorator.addTree(LOTRTreeType.OAK, 200);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 30);
		decorator.addTree(LOTRTreeType.LARCH, 300);
		decorator.addTree(LOTRTreeType.MAPLE, 100);
		decorator.addTree(LOTRTreeType.MAPLE_LARGE, 10);
		registerForestFlowers();
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);
		decorator.addRandomStructure(new LOTRWorldGenGundabadCamp(false), 2000);
		decorator.addRandomStructure(new LOTRWorldGenRuinedHouse(false), 2000);
		decorator.addRandomStructure(new LOTRWorldGenBurntHouse(false), 3000);
		decorator.addRandomStructure(new LOTRWorldGenRottenHouse(false), 3000);
		decorator.addRandomStructure(new LOTRWorldGenRangerCamp(false), 1500);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.STONE(1, 3), 800);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.ARNOR(1, 3), 800);
		decorator.addRandomStructure(new LOTRWorldGenRangerWatchtower(false), 2000);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 400);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(3) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ANGMAR.getSubregion("coldfells");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.COLDFELLS;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}
}
