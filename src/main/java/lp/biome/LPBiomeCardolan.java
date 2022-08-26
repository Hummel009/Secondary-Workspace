package lp.biome;

import lotr.common.entity.animal.LOTREntityHorse;
import lotr.common.world.biome.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lp.map.LPWaypoint;
import net.minecraft.world.biome.BiomeGenBase;

public class LPBiomeCardolan extends LOTRBiome {
	public LPBiomeCardolan(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 2, 6));
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST, 5.0f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT, 5.0f);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.DENSEFOREST_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.DENSEFOREST_BIRCH);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_APPLE_PEAR, 1.0f);
		decorator.setTreeCluster(10, 20);
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 3;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 1;
		decorator.whiteSand = true;
		decorator.addTree(LOTRTreeType.OAK, 100);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 25);
		decorator.addTree(LOTRTreeType.BIRCH, 500);
		decorator.addTree(LOTRTreeType.BIRCH_TALL, 500);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 200);
		decorator.addTree(LOTRTreeType.BIRCH_PARTY, 50);
		decorator.addTree(LOTRTreeType.BEECH, 100);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 25);
		decorator.addTree(LOTRTreeType.CHESTNUT, 40);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 10);
		decorator.addTree(LOTRTreeType.ASPEN, 300);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 100);
		decorator.addTree(LOTRTreeType.APPLE, 2);
		decorator.addTree(LOTRTreeType.PEAR, 2);
		registerPlainsFlowers();
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ERIADOR.getSubregion("cardolan");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LPWaypoint.Region.CARDOLAN;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.ARNOR;
	}

	@Override
	public int spawnCountMultiplier() {
		return 5;
	}
}