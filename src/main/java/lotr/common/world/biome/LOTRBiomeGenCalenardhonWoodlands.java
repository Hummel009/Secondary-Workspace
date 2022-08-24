/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenCalenardhonWoodlands extends LOTRBiomeGenCalenardhon {
	public LOTRBiomeGenCalenardhonWoodlands(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 8, 4, 8));
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
		decorator.treesPerChunk = 5;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 1;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 3;
		decorator.addTree(LOTRTreeType.BIRCH, 50);
		registerForestFlowers();
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.75f;
	}

	@Override
	public int spawnCountMultiplier() {
		return super.spawnCountMultiplier() * 2;
	}
}
