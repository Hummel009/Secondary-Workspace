package lotr.common.world.biome;

import lotr.common.*;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lotr.common.world.spawning.LOTREventSpawner;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LOTRBiomeGenNisimaldar extends LOTRBiome {
	public LOTRBiomeGenNisimaldar(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 20, 4, 6));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 30, 4, 6));
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableLOTRAmbientList.clear();
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityButterfly.class, 10, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBird.class, 10, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityRabbit.class, 6, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntitySwan.class, 15, 4, 8));
		variantChance = 0.7f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT, 2.0f);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.CLEARING, 0.5f);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreQuendite, 6), 6.0f, 0, 48);
		enablePodzol = false;
		decorator.treesPerChunk = 3;
		decorator.willowPerChunk = 2;
		decorator.flowersPerChunk = 6;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 2;
		decorator.generateLava = false;
		decorator.generateCobwebs = false;
		decorator.whiteSand = true;
		decorator.addTree(LOTRTreeType.OAK, 300);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 50);
		decorator.addTree(LOTRTreeType.LARCH, 200);
		decorator.addTree(LOTRTreeType.BEECH, 100);
		decorator.addTree(LOTRTreeType.BEECH_LARGE, 20);
		decorator.addTree(LOTRTreeType.MALLORN, 300);
		decorator.addTree(LOTRTreeType.ASPEN, 100);
		decorator.addTree(LOTRTreeType.ASPEN_LARGE, 20);
		decorator.addTree(LOTRTreeType.LAIRELOSSE, 50);
		registerForestFlowers();
		addFlower(LOTRMod.elanor, 0, 30);
		addFlower(LOTRMod.niphredil, 0, 20);
		biomeColors.setGrass(11527451);
		biomeColors.setFog(16770660);
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
	}

	@Override
	public LOTRAchievement getBiomeAchievement() {
		return null;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.GONDOR.getSubregion("nisimaldar");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.GONDOR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.GONDOR_MIX;
	}

	@Override
	public boolean hasSeasonalGrass() {
		return false;
	}
}
