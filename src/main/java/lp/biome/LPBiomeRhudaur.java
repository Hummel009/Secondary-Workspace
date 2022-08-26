package lp.biome;

import java.util.Random;

import lotr.common.entity.animal.LOTREntityBear;
import lotr.common.world.biome.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lp.map.LPWaypoint;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LPBiomeRhudaur extends LOTRBiome {
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public LPBiomeRhudaur(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 8, 4, 8));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 4, 1, 4));
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LARCH, 0.4f);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_PINE, 0.4f);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		decorator.treesPerChunk = 0;
		decorator.willowPerChunk = 1;
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 1;
		decorator.addTree(LOTRTreeType.SPRUCE, 500);
		decorator.addTree(LOTRTreeType.OAK_TALL, 200);
		decorator.addTree(LOTRTreeType.OAK_LARGE, 20);
		decorator.addTree(LOTRTreeType.CHESTNUT, 50);
		decorator.addTree(LOTRTreeType.CHESTNUT_LARGE, 10);
		decorator.addTree(LOTRTreeType.FIR, 500);
		decorator.addTree(LOTRTreeType.PINE, 500);
		registerForestFlowers();
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int i1;
		int k1;
		super.decorate(world, random, i, k);
		for (int count = 0; count < 6; ++count) {
			i1 = i + random.nextInt(16) + 8;
			int j1 = world.getHeightValue(i1, k1 = k + random.nextInt(16) + 8);
			if (j1 <= 85) {
				continue;
			}
			decorator.genTree(world, random, i1, j1, k1);
		}
		if (random.nextInt(8) == 0) {
			for (int l = 0; l < 4; ++l) {
				i1 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ERIADOR.getSubregion("rhudaur");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LPWaypoint.Region.RHUDAUR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.5f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.ARNOR;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.75f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 2;
	}
}