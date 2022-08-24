/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockGrass
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenNurn extends LOTRBiomeGenMordor {
	protected WorldGenerator nurnBoulderGen = new LOTRWorldGenBoulder(LOTRMod.rock, 0, 1, 3);

	public LOTRBiomeGenNurn(int i, boolean major) {
		super(i, major);
		topBlock = Blocks.grass;
		fillerBlock = Blocks.dirt;
		enableRain = true;
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.MORDOR_ORCS, 30).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.MORDOR_WARGS, 5).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.BLACK_URUKS, 2).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.OLOG_HAI, 2).setSpawnChance(600));
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK);
		decorator.setTreeCluster(6, 30);
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 0;
		decorator.doubleFlowersPerChunk = 0;
		decorator.grassPerChunk = 8;
		decorator.dryReedChance = 0.6f;
		decorator.generateWater = true;
		decorator.addTree(LOTRTreeType.OAK, 500);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 100);
		decorator.addTree(LOTRTreeType.OAK_DESERT, 500);
		decorator.addTree(LOTRTreeType.CEDAR, 100);
		decorator.addTree(LOTRTreeType.OAK_DEAD, 200);
		decorator.addTree(LOTRTreeType.CHARRED, 200);
		biomeColors.setGrass(10066237);
		biomeColors.setWater(8877157);
		biomeColors.resetSky();
		biomeColors.resetFog();
		biomeColors.setFoggy(false);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(40) == 0) {
			for (int l = 0; l < 4; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				nurnBoulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.MORDOR.getSubregion("nurn");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.NURN;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.25f;
	}

	@Override
	public boolean isGorgoroth() {
		return false;
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
