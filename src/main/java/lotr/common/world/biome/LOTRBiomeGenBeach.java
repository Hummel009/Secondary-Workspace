/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 */
package lotr.common.world.biome;

import lotr.common.entity.animal.LOTREntitySeagull;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenBeach extends LOTRBiomeGenOcean {
	public LOTRBiomeGenBeach(int i, boolean major) {
		super(i, major);
		setMinMaxHeight(0.1f, 0.0f);
		setTemperatureRainfall(0.8f, 0.4f);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableLOTRAmbientList.clear();
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntitySeagull.class, 20, 4, 4));
	}

	public LOTRBiomeGenBeach setBeachBlock(Block block, int meta) {
		topBlock = block;
		topBlockMeta = meta;
		fillerBlock = block;
		fillerBlockMeta = meta;
		return this;
	}
}
