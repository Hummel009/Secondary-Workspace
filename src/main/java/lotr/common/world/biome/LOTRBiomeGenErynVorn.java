/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 */
package lotr.common.world.biome;

import lotr.common.entity.animal.LOTREntityBear;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.*;
import lotr.common.world.village.LOTRVillageGenBree;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenErynVorn extends LOTRBiomeGenEriador {
	public LOTRBiomeGenErynVorn(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 10, 1, 4));
		npcSpawnList.newFactionList(10).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.BREE_MEN, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.BREE_GUARDS, 10).setSpawnChance(600));
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
		decorator.treesPerChunk = 10;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 1;
		decorator.doubleGrassPerChunk = 2;
		decorator.addTree(LOTRTreeType.PINE, 1000);
		decorator.addTree(LOTRTreeType.FIR, 200);
		decorator.addTree(LOTRTreeType.SPRUCE, 200);
		registerForestFlowers();
		decorator.addRandomStructure(new LOTRWorldGenSmallStoneRuin(false), 500);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.STONE(1, 3), 1000);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.ARNOR(1, 3), 1000);
		decorator.addVillage(new LOTRVillageGenBree(this, 1.0f));
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.ERIADOR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}
}
