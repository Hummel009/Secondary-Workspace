/*
 * Decompiled with CFR 0.148.
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRRoadType;

public class LOTRBiomeGenFarHaradJungleEdge extends LOTRBiomeGenFarHaradJungle {
	public LOTRBiomeGenFarHaradJungleEdge(int i, boolean major) {
		super(i, major);
		obsidianGravelRarity = 200;
		clearBiomeVariants();
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		decorator.treesPerChunk = 4;
		decorator.vinesPerChunk = 10;
		decorator.melonPerChunk = 0.03f;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.JUNGLE, 200);
		decorator.addTree(LOTRTreeType.JUNGLE_LARGE, 50);
		decorator.addTree(LOTRTreeType.MAHOGANY, 50);
		decorator.addTree(LOTRTreeType.JUNGLE_SHRUB, 1000);
		decorator.addTree(LOTRTreeType.MANGO, 5);
		biomeColors.resetSky();
		biomeColors.resetFog();

	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.FAR_HARAD_JUNGLE.getSubregion("edge");
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.TAUREDAIN.setRepair(0.5f);
	}

	@Override
	public boolean hasJungleLakes() {
		return false;
	}

	@Override
	public boolean isMuddy() {
		return false;
	}
}
