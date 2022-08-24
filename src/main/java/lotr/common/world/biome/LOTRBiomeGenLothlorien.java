/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
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
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.*;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LOTRBiomeGenLothlorien extends LOTRBiome {
	public LOTRBiomeGenLothlorien(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 20, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 30, 4, 6));
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.GALADHRIM, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.GALADHRIM_WARRIORS, 2).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.GALADHRIM_WARDENS, 1).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.2f;
		spawnableLOTRAmbientList.clear();
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityButterfly.class, 10, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBird.class, 10, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityRabbit.class, 6, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntitySwan.class, 15, 4, 8));
		variantChance = 0.7f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT, 2.0f);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.CLEARING, 0.5f);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreQuendite, 6), 6.0f, 0, 48);
		enablePodzol = false;
		decorator.treesPerChunk = 3;
		decorator.willowPerChunk = 2;
		decorator.flowersPerChunk = 6;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 2;
		decorator.generateCobwebs = false;
		decorator.whiteSand = true;
		decorator.addTree(LOTRTreeType.OAK, 300);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 50);
		decorator.addTree(LOTRTreeType.LARCH, 200);
		decorator.addTree(LOTRTreeType.BEECH, 100);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 20);
		decorator.addTree(LOTRTreeType.MALLORN, 300);
		decorator.addTree(LOTRTreeType.MALLORN_BOUGHS, 600);
		decorator.addTree(LOTRTreeType.MALLORN_PARTY, 100);
		decorator.addTree(LOTRTreeType.MALLORN_EXTREME, 30);
		decorator.addTree(LOTRTreeType.ASPEN, 100);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 20);
		decorator.addTree(LOTRTreeType.LAIRELOSSE, 50);
		registerForestFlowers();
		addFlower(LOTRMod.elanor, 0, 30);
		addFlower(LOTRMod.niphredil, 0, 20);
		biomeColors.setGrass(11527451);
		biomeColors.setFog(16770660);
		decorator.addRandomStructure(new LOTRWorldGenGaladhrimForge(false), 120);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		for (int l = 0; l < 120; ++l) {
			int j1;
			int k1;
			int i1 = i + random.nextInt(16) + 8;
			if (!world.isAirBlock(i1, (j1 = 60 + random.nextInt(50)) - 1, k1 = k + random.nextInt(16) + 8) || !world.isAirBlock(i1, j1, k1) || !world.isAirBlock(i1, j1 + 1, k1)) {
				continue;
			}
			Block torchBlock = LOTRWorldGenElfHouse.getRandomTorch(random);
			if (world.getBlock(i1 - 1, j1, k1) == LOTRMod.wood && world.getBlockMetadata(i1 - 1, j1, k1) == 1 && world.isAirBlock(i1 - 1, j1, k1 - 1) && world.isAirBlock(i1 - 1, j1, k1 + 1)) {
				world.setBlock(i1, j1, k1, torchBlock, 1, 2);
				continue;
			}
			if (world.getBlock(i1 + 1, j1, k1) == LOTRMod.wood && world.getBlockMetadata(i1 + 1, j1, k1) == 1 && world.isAirBlock(i1 + 1, j1, k1 - 1) && world.isAirBlock(i1 + 1, j1, k1 + 1)) {
				world.setBlock(i1, j1, k1, torchBlock, 2, 2);
				continue;
			}
			if (world.getBlock(i1, j1, k1 - 1) == LOTRMod.wood && world.getBlockMetadata(i1, j1, k1 - 1) == 1 && world.isAirBlock(i1 - 1, j1, k1 - 1) && world.isAirBlock(i1 + 1, j1, k1 - 1)) {
				world.setBlock(i1, j1, k1, torchBlock, 3, 2);
				continue;
			}
			if (world.getBlock(i1, j1, k1 + 1) != LOTRMod.wood || world.getBlockMetadata(i1, j1, k1 + 1) != 1 || !world.isAirBlock(i1 - 1, j1, k1 + 1) || !world.isAirBlock(i1 + 1, j1, k1 + 1)) {
				continue;
			}
			world.setBlock(i1, j1, k1, torchBlock, 4, 2);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.LOTHLORIEN.getSubregion("lothlorien");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.LOTHLORIEN;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.GALADHRIM;
	}

	@Override
	public boolean hasSeasonalGrass() {
		return false;
	}
}
