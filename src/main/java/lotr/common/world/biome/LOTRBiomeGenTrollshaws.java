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
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenTrollshaws extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 2, 6);

	public LOTRBiomeGenTrollshaws(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 8, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 10, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 20, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityElk.class, 6, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 10, 1, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.TROLLS, 10).setSpawnChance(600));
		addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
		decorator.treesPerChunk = 1;
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 2;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 2;
		decorator.generateAthelas = true;
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_TALL, 500);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 200);
		decorator.addTree(LOTRTreeType.BEECH, 500);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 200);
		decorator.addTree(LOTRTreeType.SPRUCE, 100);
		decorator.addTree(LOTRTreeType.FIR, 100);
		decorator.addTree(LOTRTreeType.PINE, 100);
		decorator.addTree(LOTRTreeType.MAPLE, 50);
		decorator.addTree(LOTRTreeType.MAPLE_LARGE, 20);
		decorator.addTree(LOTRTreeType.ASPEN, 100);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 20);
		registerForestFlowers();
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_COMMON);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int i1;
		int k1;
		int l;
		super.decorate(world, random, i, k);
		if (random.nextInt(8) == 0) {
			for (l = 0; l < 3; ++l) {
				i1 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
		for (l = 0; l < 10; ++l) {
			i1 = i + random.nextInt(16) + 8;
			int j1 = world.getHeightValue(i1, k1 = k + random.nextInt(16) + 8);
			if (j1 >= 82) {
				continue;
			}
			decorator.genTree(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ERIADOR.getSubregion("trollshaws");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.TROLLSHAWS;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.ARNOR.setRepair(0.7f);
	}
}
