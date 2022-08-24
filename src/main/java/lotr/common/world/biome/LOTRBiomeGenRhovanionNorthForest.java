/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 */
package lotr.common.world.biome;

import lotr.common.entity.animal.LOTREntityDeer;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenRhovanionNorthForest extends LOTRBiomeGenRhovanionNorth {
	public LOTRBiomeGenRhovanionNorthForest(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 30, 4, 6));
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
		decorator.treesPerChunk = 6;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 3;
		registerForestFlowers();
	}
}
