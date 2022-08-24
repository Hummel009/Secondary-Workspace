/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.map.LOTRWaypoint;

public class LOTRBiomeGenRhunIsland extends LOTRBiomeGenRhunLand {
	public LOTRBiomeGenRhunIsland(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK);
		clearTravellingTraders();
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.TOL_RHUNAER;
	}
}
