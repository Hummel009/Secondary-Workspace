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
import lotr.common.world.spawning.LOTREventSpawner;
import lotr.common.world.structure2.LOTRWorldGenBlueMountainsHouse;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LOTRBiomeGenBlueMountains extends LOTRBiome {
	public LOTRBiomeGenBlueMountains(int i, boolean major) {
		super(i, major);
		variantChance = 0.2f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.2f);
		decorator.biomeGemFactor = 2.0f;
		decorator.addSoil(new WorldGenMinable(LOTRMod.rock, 3, 60, Blocks.stone), 6.0f, 0, 96);
		decorator.addOre(new WorldGenMinable(Blocks.coal_ore, 8), 10.0f, 0, 128);
		decorator.addOre(new WorldGenMinable(Blocks.iron_ore, 4), 10.0f, 0, 96);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreGlowstone, 4), 8.0f, 0, 48);
		decorator.treesPerChunk = 1;
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 1;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 1;
		decorator.generateWater = false;
		decorator.generateCobwebs = false;
		decorator.addTree(LOTRTreeType.OAK, 300);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.SPRUCE, 500);
		decorator.addTree(LOTRTreeType.BIRCH, 400);
		decorator.addTree(LOTRTreeType.FIR, 500);
		decorator.addTree(LOTRTreeType.PINE, 500);
		registerMountainsFlowers();
		addFlower(LOTRMod.dwarfHerb, 0, 1);
		biomeColors.setSky(7506425);

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);

	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		for (int l = 0; l < 4; ++l) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = 70 + random.nextInt(80);
			int k1 = k + random.nextInt(16) + 8;
			new LOTRWorldGenBlueMountainsHouse(false).generate(world, random, i1, j1, k1);
		}
	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
		int snowHeight = 110 - rockDepth;
		int stoneHeight = snowHeight - 20;
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
			blocks[index] = LOTRMod.rock;
			meta[index] = 3;
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DWARVEN.getSubregion("blueMountains");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.BLUE_MOUNTAINS;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.2f;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.DWARVEN;
	}
}
