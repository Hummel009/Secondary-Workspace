/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenAbstractTree
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenMirkwoodCorrupted extends LOTRBiomeGenMirkwood {
	public LOTRBiomeGenMirkwoodCorrupted(int i, boolean major) {
		super(i, major);
		spawnableWaterCreatureList.clear();
		spawnableLOTRAmbientList.clear();
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityButterfly.class, 10, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityGorcrow.class, 6, 4, 4));
		variantChance = 0.2f;
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		decorator.treesPerChunk = 8;
		decorator.willowPerChunk = 1;
		decorator.vinesPerChunk = 20;
		decorator.logsPerChunk = 3;
		decorator.flowersPerChunk = 0;
		decorator.grassPerChunk = 12;
		decorator.doubleGrassPerChunk = 6;
		decorator.enableFern = true;
		decorator.mushroomsPerChunk = 4;
		decorator.addTree(LOTRTreeType.GREEN_OAK_LARGE, 1000);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 300);
		decorator.addTree(LOTRTreeType.SPRUCE, 200);
		decorator.addTree(LOTRTreeType.FIR, 200);
		decorator.addTree(LOTRTreeType.PINE, 400);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);

	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (decorator.treesPerChunk > 2) {
			for (int l = 0; l < decorator.treesPerChunk / 2; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				int j1 = world.getTopSolidOrLiquidBlock(i1, k1);
				LOTRTreeType.GREEN_OAK.create(false, random).generate(world, random, i1, j1, k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.MIRKWOOD.getSubregion("mirkwood");
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}
}
