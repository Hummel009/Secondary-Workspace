/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockFlower
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenDoublePlant
 *  net.minecraft.world.gen.feature.WorldGenFlowers
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
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenIthilien extends LOTRBiome {
	public LOTRBiomeGenIthilien(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 10, 4, 6));
		variantChance = 0.7f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK_NOSTEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT, 4.0f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST, 2.0f);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK, 4.0f);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND, 3.0f);
		this.addBiomeVariant(LOTRBiomeVariant.DENSEFOREST_LEBETHRON);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_PLUM, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_OLIVE, 0.1f);
		decorator.addSoil(new WorldGenMinable(LOTRMod.rock, 1, 60, Blocks.stone), 2.0f, 0, 64);
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 2;
		decorator.logsPerChunk = 1;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 4;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 4;
		decorator.waterlilyPerChunk = 2;
		decorator.generateAthelas = true;
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_TALL, 100);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 200);
		decorator.addTree(LOTRTreeType.LEBETHRON, 100);
		decorator.addTree(LOTRTreeType.LEBETHRON_LARGE, 50);
		decorator.addTree(LOTRTreeType.BIRCH, 150);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 50);
		decorator.addTree(LOTRTreeType.CEDAR, 200);
		decorator.addTree(LOTRTreeType.CHESTNUT, 100);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 50);
		decorator.addTree(LOTRTreeType.PINE, 100);
		decorator.addTree(LOTRTreeType.CYPRESS, 100);
		decorator.addTree(LOTRTreeType.CYPRESS_LARGE, 10);
		decorator.addTree(LOTRTreeType.APPLE, 5);
		decorator.addTree(LOTRTreeType.PEAR, 5);
		decorator.addTree(LOTRTreeType.OLIVE, 5);
		decorator.addTree(LOTRTreeType.OLIVE_LARGE, 5);
		decorator.addTree(LOTRTreeType.ALMOND, 15);
		registerForestFlowers();
		addFlower(LOTRMod.asphodel, 0, 10);
		addFlower(Blocks.red_flower, 2, 5);

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);

	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int j1;
		int i1;
		int k1;
		super.decorate(world, random, i, k);
		if (random.nextInt(3) == 0) {
			i1 = i + random.nextInt(16) + 8;
			j1 = random.nextInt(128);
			k1 = k + random.nextInt(16) + 8;
			WorldGenDoublePlant doubleFlowerGen = new WorldGenDoublePlant();
			doubleFlowerGen.func_150548_a(0);
			doubleFlowerGen.generate(world, random, i1, j1, k1);
		}
		if (random.nextInt(24) == 0) {
			i1 = i + random.nextInt(16) + 8;
			j1 = random.nextInt(128);
			k1 = k + random.nextInt(16) + 8;
			new WorldGenFlowers(LOTRMod.pipeweedPlant).generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.GONDOR.getSubregion("ithilien");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.ITHILIEN;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.GONDOR_MIX.setRepair(0.7f);
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.4f;
	}
}
