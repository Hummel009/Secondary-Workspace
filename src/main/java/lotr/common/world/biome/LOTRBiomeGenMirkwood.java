/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 */
package lotr.common.world.biome;

import lotr.common.entity.animal.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenWoodElfTower;
import lotr.common.world.structure2.*;
import net.minecraft.world.biome.BiomeGenBase;

public abstract class LOTRBiomeGenMirkwood extends LOTRBiome {
	public LOTRBiomeGenMirkwood(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityElk.class, 30, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 30, 4, 6));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityButterfly.class, 10, 4, 4));
		registerForestFlowers();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.WOOD_ELVES, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.WOOD_ELF_WARRIORS, 3).setSpawnChance(600));
		decorator.addRandomStructure(new LOTRWorldGenWoodElfHouse(false), 16);
		decorator.addRandomStructure(new LOTRWorldGenWoodElfTower(false), 100);
		decorator.addRandomStructure(new LOTRWorldGenWoodElvenForge(false), 80);
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.MIRKWOOD;
	}

	@Override
	public LOTRRoadType.BridgeType getBridgeBlock() {
		return LOTRRoadType.BridgeType.MIRKWOOD;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.WOOD_ELVEN_RUINED.setRepair(0.6f);
	}
}
