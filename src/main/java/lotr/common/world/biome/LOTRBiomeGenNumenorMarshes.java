package lotr.common.world.biome;

import lotr.common.LOTRAchievement;
import lotr.common.entity.animal.LOTREntityGorcrow;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.world.biome.BiomeGenBase;

public class LOTRBiomeGenNumenorMarshes extends LOTRBiomeGenWilderlandNorth {
	public LOTRBiomeGenNumenorMarshes(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityGorcrow.class, 8, 4, 4));
		clearBiomeVariants();
		variantChance = 1.0f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_SWAMP);
		decorator.sandPerChunk = 0;
		decorator.quagmirePerChunk = 2;
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 1;
		decorator.logsPerChunk = 1;
		decorator.flowersPerChunk = 2;
		decorator.grassPerChunk = 10;
		decorator.doubleGrassPerChunk = 10;
		decorator.enableFern = true;
		decorator.waterlilyPerChunk = 4;
		decorator.canePerChunk = 10;
		decorator.reedPerChunk = 6;
		decorator.addTree(LOTRTreeType.OAK_SWAMP, 1000);
		decorator.addTree(LOTRTreeType.GREEN_OAK, 200);
		registerSwampFlowers();
		biomeColors.setSky(13230818);
		biomeColors.setFog(12112325);
		biomeColors.setFoggy(true);
		biomeColors.setWater(8167049);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
	}

	@Override
	public LOTRAchievement getBiomeAchievement() {
		return null;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DALE.getSubregion("forostarMoors");
	}

	@Override
	public int spawnCountMultiplier() {
		return 3;
	}
}
