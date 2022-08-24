/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenGladdenFields extends LOTRBiomeGenAnduin {
	public LOTRBiomeGenGladdenFields(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		variantChance = 1.0f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_SWAMP);
		decorator.sandPerChunk = 0;
		decorator.quagmirePerChunk = 1;
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 1;
		decorator.flowersPerChunk = 2;
		decorator.doubleFlowersPerChunk = 10;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 8;
		decorator.waterlilyPerChunk = 4;
		decorator.canePerChunk = 10;
		decorator.reedPerChunk = 3;
		decorator.addTree(LOTRTreeType.OAK_SWAMP, 1000);
		registerSwampFlowers();

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_UNCOMMON);

	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DALE.getSubregion("gladden");
	}

	@Override
	public WorldGenerator getRandomWorldGenForDoubleFlower(Random random) {
		if (random.nextInt(3) != 0) {
			LOTRWorldGenDoubleFlower doubleFlowerGen = new LOTRWorldGenDoubleFlower();
			doubleFlowerGen.setFlowerType(1);
			return doubleFlowerGen;
		}
		return super.getRandomWorldGenForDoubleFlower(random);
	}

	@Override
	public int spawnCountMultiplier() {
		return 2;
	}
}
