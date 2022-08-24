/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenFlowers
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenDeadMarshes extends LOTRBiome {
	public LOTRBiomeGenDeadMarshes(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableLOTRAmbientList.clear();
		decorator.addOre(new WorldGenMinable(LOTRMod.remains, 6, Blocks.dirt), 5.0f, 55, 65);
		clearBiomeVariants();
		variantChance = 1.0f;
		this.addBiomeVariant(LOTRBiomeVariant.SWAMP_LOWLAND);
		decorator.sandPerChunk = 0;
		decorator.clayPerChunk = 0;
		decorator.quagmirePerChunk = 1;
		decorator.treesPerChunk = 0;
		decorator.logsPerChunk = 2;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 8;
		decorator.flowersPerChunk = 0;
		decorator.enableFern = true;
		decorator.enableSpecialGrasses = false;
		decorator.canePerChunk = 10;
		decorator.reedPerChunk = 2;
		decorator.dryReedChance = 1.0f;
		decorator.addTree(LOTRTreeType.OAK_DEAD, 1000);
		flowers.clear();
		addFlower(LOTRMod.deadPlant, 0, 10);
		biomeColors.setGrass(8348751);
		biomeColors.setSky(5657394);
		biomeColors.setClouds(10525542);
		biomeColors.setFog(4210724);
		biomeColors.setWater(1316367);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);

	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int k1;
		int j1;
		int i1;
		int l;
		super.decorate(world, random, i, k);
		for (l = 0; l < 6; ++l) {
			i1 = i + random.nextInt(16) + 8;
			k1 = k + random.nextInt(16) + 8;
			j1 = random.nextInt(128);
			new WorldGenFlowers(LOTRMod.deadPlant).generate(world, random, i1, j1, k1);
		}
		for (l = 0; l < 4; ++l) {
			i1 = i + random.nextInt(16) + 8;
			k1 = k + random.nextInt(16) + 8;
			for (j1 = 128; j1 > 0 && world.isAirBlock(i1, j1 - 1, k1); --j1) {
			}
			new LOTRWorldGenMarshLights().generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DEAD_MARSHES.getSubregion("deadMarshes");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.MORDOR;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}
}
