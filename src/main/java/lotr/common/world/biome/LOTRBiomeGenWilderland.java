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
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenWilderland extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public LOTRBiomeGenWilderland(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 6, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityAurochs.class, 20, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityKineAraw.class, 3, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 6, 1, 4));
		variantChance = 0.7f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK_SPRUCE);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND, 5.0f);
		this.addBiomeVariant(LOTRBiomeVariant.WASTELAND, 3.0f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.2f);
		decorator.setTreeCluster(8, 20);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 14;
		decorator.doubleGrassPerChunk = 8;
		decorator.addTree(LOTRTreeType.OAK, 1000);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.OAK_DEAD, 500);
		decorator.addTree(LOTRTreeType.SPRUCE, 200);
		decorator.addTree(LOTRTreeType.SPRUCE_DEAD, 100);
		decorator.addTree(LOTRTreeType.CHESTNUT, 100);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 10);
		registerRhunPlainsFlowers();

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);

	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(24) == 0) {
			for (int l = 0; l < 4; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DALE.getSubregion("wilderland");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.WILDERLAND;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}

	@Override
	public WorldGenerator getRandomWorldGenForDoubleFlower(Random random) {
		if (random.nextInt(6) == 0) {
			LOTRWorldGenDoubleFlower doubleFlowerGen = new LOTRWorldGenDoubleFlower();
			doubleFlowerGen.setFlowerType(0);
			return doubleFlowerGen;
		}
		return super.getRandomWorldGenForDoubleFlower(random);
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.05f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 2;
	}
}
