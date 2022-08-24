/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class LOTRBiomeGenGreyMountains extends LOTRBiome {
	public LOTRBiomeGenGreyMountains(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.2f);
		decorator.biomeGemFactor = 1.0f;
		decorator.flowersPerChunk = 0;
		decorator.grassPerChunk = 0;
		decorator.doubleGrassPerChunk = 0;
		decorator.addTree(LOTRTreeType.SPRUCE, 400);
		decorator.addTree(LOTRTreeType.SPRUCE_THIN, 400);
		decorator.addTree(LOTRTreeType.SPRUCE_MEGA, 50);
		decorator.addTree(LOTRTreeType.SPRUCE_MEGA_THIN, 10);
		decorator.addTree(LOTRTreeType.LARCH, 500);
		decorator.addTree(LOTRTreeType.FIR, 500);
		decorator.addTree(LOTRTreeType.PINE, 500);
		registerMountainsFlowers();
		biomeColors.setSky(10862798);

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);

	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int count;
		int i1;
		super.decorate(world, random, i, k);
		for (count = 0; count < 3; ++count) {
			int k1;
			i1 = i + random.nextInt(16) + 8;
			int j1 = world.getHeightValue(i1, k1 = k + random.nextInt(16) + 8);
			if (j1 >= 100) {
				continue;
			}
			decorator.genTree(world, random, i1, j1, k1);
		}
		for (count = 0; count < 2; ++count) {
			i1 = i + random.nextInt(16) + 8;
			int j1 = random.nextInt(128);
			int k1 = k + random.nextInt(16) + 8;
			if (j1 >= 100) {
				continue;
			}
			getRandomWorldGenForGrass(random).generate(world, random, i1, j1, k1);
		}
	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
		int snowHeight = 150 - rockDepth;
		int stoneHeight = snowHeight - 40;
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
		return LOTRMusicRegion.GREY_MOUNTAINS.getSubregion("greyMountains");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.GREY_MOUNTAINS;
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
	public float getTreeIncreaseChance() {
		return 0.0f;
	}
}
