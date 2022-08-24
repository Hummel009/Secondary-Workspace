/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LOTRBiomeGenKhazadDum extends LOTRBiome {
	public LOTRBiomeGenKhazadDum(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableLOTRAmbientList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.DWARVES, 10).setSpawnChance(600));
		variantChance = 0.1f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.3f);
		decorator.biomeGemFactor = 1.0f;
		decorator.addOre(new WorldGenMinable(LOTRMod.oreMithril, 6), 0.5f, 0, 16);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreGlowstone, 4), 8.0f, 0, 48);
		decorator.flowersPerChunk = 1;
		decorator.grassPerChunk = 3;
		decorator.doubleGrassPerChunk = 1;
		decorator.generateWater = false;
		decorator.addTree(LOTRTreeType.SPRUCE, 400);
		decorator.addTree(LOTRTreeType.SPRUCE_THIN, 400);
		decorator.addTree(LOTRTreeType.LARCH, 300);
		decorator.addTree(LOTRTreeType.SPRUCE_MEGA, 100);
		decorator.addTree(LOTRTreeType.SPRUCE_MEGA_THIN, 20);
		decorator.addTree(LOTRTreeType.FIR, 500);
		decorator.addTree(LOTRTreeType.PINE, 500);
		registerMountainsFlowers();
		biomeColors.setSky(12241873);
		decorator.addRandomStructure(new LOTRWorldGenDwarvenTower(false), 400);
		decorator.addRandomStructure(new LOTRWorldGenDwarfSmithy(false), 400);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		for (int count = 0; count < 2; ++count) {
			int k1;
			int i1 = i + random.nextInt(16) + 8;
			int j1 = world.getHeightValue(i1, k1 = k + random.nextInt(16) + 8);
			if (j1 >= 100) {
				continue;
			}
			decorator.genTree(world, random, i1, j1, k1);
		}
	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
		int snowHeight = 120 - rockDepth;
		int stoneHeight = snowHeight - 30;
		for (int j = ySize - 1; j >= stoneHeight; --j) {
			int index = xzIndex * ySize + j;
			Block block = blocks[index];
			if (j >= snowHeight && block == topBlock) {
				blocks[index] = Blocks.snow;
				meta[index] = 0;
				continue;
			}
			if (block != topBlock && block != fillerBlock) {
				continue;
			}
			blocks[index] = Blocks.stone;
			meta[index] = 0;
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.MISTY_MOUNTAINS.getSubregion("mistyMountains");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.ERIADOR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.0f;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.DWARVEN;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.05f;
	}
}
