/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.LOTRAchievement;
import lotr.common.world.map.LOTRWaypoint;

public class LOTRBiomeGenMordorMountains extends LOTRBiomeGenMordor {
	public LOTRBiomeGenMordorMountains(int i, boolean major) {
		super(i, major);
	}

	@Override
	public LOTRAchievement getBiomeAchievement() {
		return null;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.MORDOR.getSubregion("mountains");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return null;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}
}
