package lotr.common.world.biome;

import java.util.Random;

import bd.structure.BDStructureKhandVillage;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityBanditHarad;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenHaradObelisk;
import lotr.common.world.structure2.LOTRWorldGenStoneRuin;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class LOTRBiomeGenNearHaradKhand extends LOTRBiomeGenNearHarad {
	public LOTRBiomeGenNearHaradKhand(int i, boolean major) {
		super(i, major);
		npcSpawnList.clear();
		decorator.clearVillages();
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.KHANDS, 20).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.KHAND_WARRIORS, 15).setSpawnChance(600));
		clearBiomeVariants();
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK);
		decorator.clearTrees();
		decorator.addTree(LOTRTreeType.OAK_DEAD, 500);
		decorator.addTree(LOTRTreeType.OAK_DESERT, 500);
		decorator.grassPerChunk = 5;
		decorator.doubleGrassPerChunk = 0;
		decorator.cactiPerChunk = 1;
		decorator.deadBushPerChunk = 1;

		decorator.addRandomStructure(new LOTRWorldGenHaradObelisk(false), 3000);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.NEAR_HARAD(1, 3), 300);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.NUMENOR(1, 3), 4000);

		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
		setBanditEntityClass(LOTREntityBanditHarad.class);
		decorator.addVillage(new BDStructureKhandVillage(this, 1.0f));
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int j1;
		int k1;
		int i1;
		super.decorate(world, random, i, k);
		if (random.nextInt(20) == 0 && world.getBlock(i1 = i + random.nextInt(16) + 8, j1 = world.getHeightValue(i1, k1 = k + random.nextInt(16) + 8) - 1, k1) == Blocks.sand) {
			world.setBlock(i1, j1, k1, Blocks.dirt);
			LOTRTreeType treeType = LOTRTreeType.OAK_DESERT;
			WorldGenAbstractTree tree = treeType.create(false, random);
			if (!tree.generate(world, random, i1, j1 + 1, k1)) {
				world.setBlock(i1, j1, k1, Blocks.sand);
			}
		}
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		double d = 0;
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = biomeTerrainNoise.func_151601_a(i * 0.08, k * 0.08);
		biomeTerrainNoise.func_151601_a(i * 0.3, k * 0.3);
		if (d1 + d > 0.3) {
			topBlock = Blocks.dirt;
			topBlockMeta = 1;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		}
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		topBlock = topBlock_pre;
		topBlockMeta = topBlockMeta_pre;
		fillerBlock = fillerBlock_pre;
		fillerBlockMeta = fillerBlockMeta_pre;
	}

	@Override
	public LOTRBiome.GrassBlockAndMeta getRandomGrass(Random random) {
		return new LOTRBiome.GrassBlockAndMeta(LOTRMod.aridGrass, 0);
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.05f;
	}
}
