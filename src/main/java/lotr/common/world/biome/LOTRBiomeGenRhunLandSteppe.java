/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.spawning.*;
import lotr.common.world.village.LOTRVillageGenRhun;

public class LOTRBiomeGenRhunLandSteppe extends LOTRBiomeGenRhunLand {
	public LOTRBiomeGenRhunLandSteppe(int i, boolean major) {
		super(i, major);
		rhunBoulders = false;
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.EASTERLINGS, 20).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.EASTERLING_WARRIORS, 20).setSpawnChance(600));
		clearBiomeVariants();
		variantChance = 0.3f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_SCRUBLAND);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.3f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.3f);
		decorator.resetTreeCluster();
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 0;
		decorator.grassPerChunk = 12;
		decorator.doubleGrassPerChunk = 8;
		decorator.addTree(LOTRTreeType.PINE_SHRUB, 2000);
		biomeColors.setGrass(13946702);
		decorator.addVillage(new LOTRVillageGenRhun(this, 1.0f, true));
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.05f;
	}
}
