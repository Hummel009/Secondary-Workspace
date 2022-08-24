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
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenErebor extends LOTRBiome {
	private WorldGenerator ereborBoulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public LOTRBiomeGenErebor(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.biomeGemFactor = 1.0f;
		decorator.addOre(new WorldGenMinable(Blocks.iron_ore, 4), 10.0f, 0, 96);
		decorator.addOre(new WorldGenMinable(Blocks.gold_ore, 4), 2.0f, 0, 48);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreSilver, 4), 2.0f, 0, 48);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreGlowstone, 4), 8.0f, 0, 48);
		decorator.treesPerChunk = 1;
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 1;
		decorator.doubleFlowersPerChunk = 0;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 2;
		decorator.generateWater = false;
		decorator.generateCobwebs = false;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.OAK, 100);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.OAK_DEAD, 500);
		decorator.addTree(LOTRTreeType.SPRUCE, 100);
		decorator.addTree(LOTRTreeType.PINE, 400);
		decorator.addTree(LOTRTreeType.FIR, 400);
		registerMountainsFlowers();
		addFlower(LOTRMod.dwarfHerb, 0, 1);
		clearTravellingTraders();

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);

	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(40) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				ereborBoulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
		int snowHeight = 200 - rockDepth;
		int stoneHeight = snowHeight - 100;
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
		return LOTRMusicRegion.DWARVEN.getSubregion("erebor");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.DALE;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
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
