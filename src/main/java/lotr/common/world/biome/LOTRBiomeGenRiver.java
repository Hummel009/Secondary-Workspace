/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.spawning.LOTREventSpawner;

public class LOTRBiomeGenRiver extends LOTRBiome {
	public LOTRBiomeGenRiver(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		npcSpawnList.clear();
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return null;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.5f;
	}

	@Override
	public boolean isRiver() {
		return true;
	}
}
