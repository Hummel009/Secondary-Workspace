/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenWoodElfTower;
import lotr.common.world.structure2.*;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenWoodlandRealm extends LOTRBiome {
	public LOTRBiomeGenWoodlandRealm(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityElk.class, 30, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 20, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 2, 1, 4));
		spawnableCaveCreatureList.clear();
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityButterfly.class, 10, 4, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.WOOD_ELVES, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.WOOD_ELF_WARRIORS, 3).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.2f;
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BEECH, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_BIRCH, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_ASPEN, 0.1f);
		variantChance = 0.3f;
		decorator.treesPerChunk = 1;
		decorator.willowPerChunk = 2;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 4;
		decorator.doubleGrassPerChunk = 1;
		decorator.enableFern = true;
		decorator.generateCobwebs = false;
		decorator.addTree(LOTRTreeType.GREEN_OAK, 500);
		decorator.addTree(LOTRTreeType.GREEN_OAK_LARGE, 50);
		decorator.addTree(LOTRTreeType.RED_OAK, 40);
		decorator.addTree(LOTRTreeType.RED_OAK_LARGE, 20);
		decorator.addTree(LOTRTreeType.OAK, 50);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.SPRUCE, 100);
		decorator.addTree(LOTRTreeType.CHESTNUT, 50);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 50);
		decorator.addTree(LOTRTreeType.BEECH, 50);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 100);
		decorator.addTree(LOTRTreeType.LARCH, 100);
		decorator.addTree(LOTRTreeType.FIR, 200);
		decorator.addTree(LOTRTreeType.PINE, 200);
		decorator.addTree(LOTRTreeType.ASPEN, 50);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 10);
		registerForestFlowers();
		decorator.addRandomStructure(new LOTRWorldGenWoodElfHouse(false), 16);
		decorator.addRandomStructure(new LOTRWorldGenWoodElfTower(false), 100);
		decorator.addRandomStructure(new LOTRWorldGenWoodElvenForge(false), 80);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.WOODLAND_REALM.getSubregion("woodlandRealm");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.WOODLAND_REALM;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.WOOD_ELVEN;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
