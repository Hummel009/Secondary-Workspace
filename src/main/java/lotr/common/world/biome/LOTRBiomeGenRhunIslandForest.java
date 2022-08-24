/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.map.LOTRWaypoint;

public class LOTRBiomeGenRhunIslandForest extends LOTRBiomeGenRhunRedForest {
	public LOTRBiomeGenRhunIslandForest(int i, boolean major) {
		super(i, major);
		decorator.treesPerChunk = 10;
		biomeColors.setFog(6132078);
		clearTravellingTraders();
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.TOL_RHUNAER;
	}
}
