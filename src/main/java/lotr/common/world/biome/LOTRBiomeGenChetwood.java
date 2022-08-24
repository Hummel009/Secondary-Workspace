/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 */
package lotr.common.world.biome;

import lotr.common.entity.animal.LOTREntityDeer;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenChetwood extends LOTRBiomeGenBreeland {
	public LOTRBiomeGenChetwood(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 4, 2, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 20, 4, 6));
		clearBiomeVariants();
		addBiomeVariantSet(LOTRBiomeVariant.SET_FOREST);
		decorator.treesPerChunk = 4;
		decorator.flowersPerChunk = 4;
		decorator.doubleFlowersPerChunk = 2;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 1;
		registerForestFlowers();
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.BREE.getSubregion("chetwood");
	}
}
