/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.LOTRMod;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.*;
import lotr.common.world.village.LOTRVillageGenBree;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenEriador extends LOTRBiome {
	public LOTRBiomeGenEriador(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 6, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 4, 1, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.BREE_GUARDS, 10).setSpawnChance(600));
		addBiomeVariantSet(LOTRBiomeVariant.SET_NORMAL_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND, 1.0f);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_SCRUBLAND, 1.0f);
		this.addBiomeVariant(LOTRBiomeVariant.MOUNTAIN);
		this.addBiomeVariant(LOTRBiomeVariant.WASTELAND);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.2f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_MAPLE, 0.2f);
		decorator.setTreeCluster(8, 20);
		decorator.willowPerChunk = 1;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 4;
		decorator.generateAthelas = true;
		decorator.addTree(LOTRTreeType.OAK, 1000);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.BIRCH, 100);
		decorator.addTree(LOTRTreeType.BIRCH_LARGE, 10);
		decorator.addTree(LOTRTreeType.SPRUCE, 200);
		decorator.addTree(LOTRTreeType.BEECH, 20);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 2);
		decorator.addTree(LOTRTreeType.CHESTNUT, 100);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 10);
		decorator.addTree(LOTRTreeType.ASPEN, 50);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 5);
		decorator.addTree(LOTRTreeType.APPLE, 2);
		decorator.addTree(LOTRTreeType.PEAR, 2);
		decorator.addTree(LOTRTreeType.CHERRY, 200);
		registerPlainsFlowers();
		addFlower(LOTRMod.lavender, 0, 20);
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 500);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.STONE(1, 3), 1000);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.ARNOR(1, 3), 1000);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);
		decorator.addVillage(new LOTRVillageGenBree(this, 1.0f));
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ERIADOR.getSubregion("eriador");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.ERIADOR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.ARNOR.setRepair(0.92f);
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.05f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 4;
	}
}
