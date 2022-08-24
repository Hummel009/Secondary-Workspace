/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.World
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.world.feature.*;
import lotr.common.world.spawning.*;
import net.minecraft.world.World;

public class LOTRBiomeGenFangornWasteland extends LOTRBiome {
	public LOTRBiomeGenFangornWasteland(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.ENTS, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.HUORNS, 20).setSpawnChance(600));
		decorator.treesPerChunk = 1;
		decorator.willowPerChunk = 0;
		decorator.logsPerChunk = 3;
		decorator.flowersPerChunk = 1;
		decorator.grassPerChunk = 5;
		decorator.doubleGrassPerChunk = 3;
		decorator.enableFern = true;
		decorator.addTree(LOTRTreeType.CHARRED, 500);
		decorator.addTree(LOTRTreeType.OAK_DEAD, 300);
		decorator.addTree(LOTRTreeType.BEECH_DEAD, 100);
		decorator.addTree(LOTRTreeType.BIRCH_DEAD, 20);
		decorator.addTree(LOTRTreeType.CHARRED_FANGORN, 50);
		decorator.addTree(LOTRTreeType.OAK_FANGORN_DEAD, 30);
		decorator.addTree(LOTRTreeType.BEECH_FANGORN_DEAD, 10);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);
	}

	@Override
	public boolean canSpawnHostilesInDay() {
		return true;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(60) == 0) {
			int i1 = i + random.nextInt(16) + 8;
			int k1 = k + random.nextInt(16) + 8;
			new LOTRWorldGenBlastedLand(true).generate(world, random, i1, world.getHeightValue(i1, k1), k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ISENGARD.getSubregion("fangorn");
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
