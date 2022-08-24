/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.world.feature.LOTRWorldGenWebOfUngoliant;
import lotr.common.world.map.LOTRWaypoint;
import lotr.common.world.spawning.*;
import lotr.common.world.structure2.LOTRWorldGenMordorSpiderPit;
import net.minecraft.world.World;

public class LOTRBiomeGenNanUngol extends LOTRBiomeGenMordor {
	public LOTRBiomeGenNanUngol(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.MORDOR_ORCS, 30).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.MORDOR_SPIDERS, 100).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.5f;
		clearBiomeVariants();
		decorator.generateCobwebs = false;
		decorator.addRandomStructure(new LOTRWorldGenMordorSpiderPit(false), 40);
		biomeColors.resetFog();
		biomeColors.setFoggy(false);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		for (int l = 0; l < 4; ++l) {
			int i1 = i + random.nextInt(16) + 8;
			int j1 = random.nextInt(128);
			int k1 = k + random.nextInt(16) + 8;
			new LOTRWorldGenWebOfUngoliant(false, 64).generate(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.MORDOR.getSubregion("nanUngol");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.NAN_UNGOL;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.75f;
	}
}
