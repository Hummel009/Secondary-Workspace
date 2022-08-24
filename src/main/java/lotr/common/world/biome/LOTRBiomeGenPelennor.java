/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.world.map.LOTRRoadType;
import lotr.common.world.spawning.LOTREventSpawner;

public class LOTRBiomeGenPelennor extends LOTRBiomeGenGondor {
	public LOTRBiomeGenPelennor(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		decorator.setTreeCluster(8, 32);
		decorator.flowersPerChunk = 6;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 1;
		registerPlainsFlowers();

		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.GONDOR.getSubregion("pelennor");
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.GONDOR;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.02f;
	}

	@Override
	public boolean hasDomesticAnimals() {
		return true;
	}

	@Override
	public int spawnCountMultiplier() {
		return 2;
	}
}
