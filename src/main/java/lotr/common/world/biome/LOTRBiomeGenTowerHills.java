/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenHighElvenHall;
import lotr.common.world.structure2.*;

public class LOTRBiomeGenTowerHills extends LOTRBiomeGenLindon {
	public LOTRBiomeGenTowerHills(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.LINDON_ELVES, 10).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.LINDON_WARRIORS, 2).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.5f;
		clearBiomeVariants();
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		decorator.addRandomStructure(new LOTRWorldGenHighElfHouse(false), 300);
		decorator.addRandomStructure(new LOTRWorldGenHighElvenHall(false), 600);
		decorator.addRandomStructure(new LOTRWorldGenHighElvenForge(false), 1000);
		decorator.addRandomStructure(new LOTRWorldGenHighElvenTower(false), 900);

	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.LINDON.getSubregion("towerHills");
	}
}
