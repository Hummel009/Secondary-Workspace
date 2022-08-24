/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.gen.feature.WorldGenAbstractTree
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenForodwaith extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 2);
	private LOTRWorldGenStalactites stalactiteIceGen = new LOTRWorldGenStalactites(LOTRMod.stalactiteIce);

	public LOTRBiomeGenForodwaith(int i, boolean major) {
		super(i, major);
		setEnableSnow();
		topBlock = Blocks.snow;
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableLOTRAmbientList.clear();
		decorator.addSoil(new WorldGenMinable(Blocks.packed_ice, 16), 40.0f, 32, 256);
		decorator.treesPerChunk = 0;
		decorator.flowersPerChunk = 0;
		decorator.grassPerChunk = 0;
		decorator.generateWater = false;
		biomeColors.setSky(10069160);

		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int k1;
		int i1;
		super.decorate(world, random, i, k);
		if (LOTRFixedStructures.UTUMNO_ENTRANCE.isAt(world, i, k)) {
			new LOTRWorldGenUtumnoEntrance().generate(world, random, i, world.getHeightValue(i, k), k);
		}
		if (random.nextInt(32) == 0) {
			int boulders = 1 + random.nextInt(5);
			for (int l = 0; l < boulders; ++l) {
				int i12 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i12, world.getHeightValue(i12, k1), k1);
			}
		}
		for (int l = 0; l < 2; ++l) {
			i1 = i + random.nextInt(16) + 8;
			int j1 = random.nextInt(60);
			k1 = k + random.nextInt(16) + 8;
			stalactiteIceGen.generate(world, random, i1, j1, k1);
		}
		if (random.nextInt(20000) == 0) {
			LOTRWorldGenMirkOak tree = ((LOTRWorldGenMirkOak) LOTRTreeType.RED_OAK_WEIRWOOD.create(false, random)).disableRestrictions();
			i1 = i + random.nextInt(16) + 8;
			int k12 = k + random.nextInt(16) + 8;
			int j1 = world.getHeightValue(i1, k12);
			tree.generate(world, random, i1, j1, k12);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.FORODWAITH.getSubregion("forodwaith");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.FORODWAITH;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.0f;
	}
}
