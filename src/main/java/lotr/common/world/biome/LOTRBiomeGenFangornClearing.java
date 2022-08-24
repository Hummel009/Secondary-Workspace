/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.spawning.*;

public class LOTRBiomeGenFangornClearing extends LOTRBiomeGenFangorn {
	public LOTRBiomeGenFangornClearing(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.ENTS, 10).setSpawnChance(600));
		clearBiomeVariants();
		decorator.treesPerChunk = 0;
		decorator.flowersPerChunk = 4;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 8;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.1f;
	}
}
