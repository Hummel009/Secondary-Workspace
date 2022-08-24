/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.entity.animal.LOTREntityCamel;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenNearHaradRiverbank extends LOTRBiomeGenNearHaradFertile {
	public LOTRBiomeGenNearHaradRiverbank(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityCamel.class, 20, 4, 4));
		clearBiomeVariants();
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		variantChance = 0.3f;
		decorator.treesPerChunk = 0;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 3;
		decorator.flowersPerChunk = 1;
		decorator.doubleFlowersPerChunk = 1;
		clearTravellingTraders();

	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.HARAD_DESERT;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}
}
