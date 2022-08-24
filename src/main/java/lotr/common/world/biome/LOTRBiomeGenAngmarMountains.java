package lotr.common.world.biome;

import java.util.Random;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.spawning.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class LOTRBiomeGenAngmarMountains extends LOTRBiomeGenAngmar {
	public LOTRBiomeGenAngmarMountains(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		npcSpawnList.newFactionList(20).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.SNOW_TROLLS, 10).setSpawnChance(600));
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		decorator.biomeGemFactor = 0.75f;
	}

	@Override
	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
		int snowHeight = 130 - rockDepth;
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
			blocks[index] = Blocks.stone;
			meta[index] = 0;
		}
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}
