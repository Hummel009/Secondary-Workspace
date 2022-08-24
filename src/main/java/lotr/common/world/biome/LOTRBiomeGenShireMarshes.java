package lotr.common.world.biome;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.spawning.LOTREventSpawner;

public class LOTRBiomeGenShireMarshes extends LOTRBiomeGenShire {
	public LOTRBiomeGenShireMarshes(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		variantChance = 1.0f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_SWAMP);
		decorator.sandPerChunk = 0;
		decorator.quagmirePerChunk = 1;
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 1;
		decorator.logsPerChunk = 2;
		decorator.flowersPerChunk = 4;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 6;
		decorator.enableFern = true;
		decorator.waterlilyPerChunk = 4;
		decorator.canePerChunk = 10;
		decorator.reedPerChunk = 4;
		decorator.addTree(LOTRTreeType.OAK_SWAMP, 2000);
		registerSwampFlowers();
		biomeColors.resetGrass();

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.1f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.75f;
	}

	@Override
	public int spawnCountMultiplier() {
		return super.spawnCountMultiplier() * 3;
	}
}
