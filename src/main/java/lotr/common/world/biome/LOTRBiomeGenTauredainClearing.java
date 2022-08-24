/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 */
package lotr.common.world.biome;

import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.map.LOTRRoadType;
import lotr.common.world.spawning.*;
import lotr.common.world.village.LOTRVillageGenTauredain;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenTauredainClearing extends LOTRBiomeGenFarHaradJungle {
	public LOTRBiomeGenTauredainClearing(int i, boolean major) {
		super(i, major);
		obsidianGravelRarity = 500;
		spawnableMonsterList.clear();
		spawnableLOTRAmbientList.clear();
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBird.class, 10, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityButterfly.class, 15, 4, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.TAURETHRIM, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.TAURETHRIM_WARRIORS, 4).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.TAURETHRIM_WARRIORS, 10).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.5f;
		clearBiomeVariants();
		variantChance = 0.1f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		decorator.setTreeCluster(16, 40);
		decorator.treesPerChunk = 0;
		decorator.vinesPerChunk = 0;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 6;
		decorator.addVillage(new LOTRVillageGenTauredain(this, 1.0f));
		biomeColors.setSky(11590117);
		biomeColors.setFog(12705243);
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.TAUREDAIN;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.1f;
	}

	@Override
	public boolean hasJungleLakes() {
		return false;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
