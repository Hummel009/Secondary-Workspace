/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 */
package lotr.common.world.biome;

import lotr.common.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRWaypoint;

public class LOTRBiomeGenRivendellHills extends LOTRBiomeGenRivendell {
	public LOTRBiomeGenRivendellHills(int i, boolean major) {
		super(i, major);
		fillerBlock = LOTRMod.rock;
		fillerBlockMeta = 5;
		clearBiomeVariants();
		variantChance = 0.4f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		decorator.treesPerChunk = 3;
		decorator.flowersPerChunk = 2;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 2;
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.PINE, 1000);
		decorator.addTree(LOTRTreeType.PINE_SHRUB, 200);
		decorator.addTree(LOTRTreeType.FIR, 100);
		decorator.addTree(LOTRTreeType.SPRUCE, 100);
		decorator.addTree(LOTRTreeType.ASPEN, 100);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 50);
		decorator.addTree(LOTRTreeType.OAK, 100);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 50);
		biomeColors.resetGrass();

	}

	@Override
	public LOTRAchievement getBiomeAchievement() {
		return LOTRBiome.loneLands.getBiomeAchievement();
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRBiome.loneLands.getBiomeMusic();
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRBiome.loneLands.getBiomeWaypoints();
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 1.0f;
	}

	@Override
	public boolean hasSeasonalGrass() {
		return true;
	}

	@Override
	public int spawnCountMultiplier() {
		return 1;
	}
}
