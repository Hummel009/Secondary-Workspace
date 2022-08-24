/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSand
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.entity.animal.*;
import lotr.common.entity.npc.LOTREntityBanditHarad;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenHaradObelisk;
import lotr.common.world.structure2.LOTRWorldGenStoneRuin;
import lotr.common.world.village.LOTRVillageGenSouthron;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenUmbar extends LOTRBiome {
	protected static NoiseGeneratorPerlin noiseDirt = new NoiseGeneratorPerlin(new Random(7849067306796L), 1);
	protected static NoiseGeneratorPerlin noiseSand = new NoiseGeneratorPerlin(new Random(628602597026L), 1);

	public LOTRBiomeGenUmbar(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityCamel.class, 4, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityHorse.class, 5, 4, 4));
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.GONDOR_MEN, 30).setSpawnChance(600), LOTRBiomeSpawnList.entry(LOTRSpawnList.GONDOR_SOLDIERS, 10).setSpawnChance(600));
		npcSpawnList.conquestGainRate = 0.2f;
		variantChance = 0.3f;
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS_FOREST);
		this.addBiomeVariant(LOTRBiomeVariant.SHRUBLAND_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_ORANGE, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_LEMON, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_LIME, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_OLIVE, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_ALMOND, 0.1f);
		this.addBiomeVariant(LOTRBiomeVariant.ORCHARD_PLUM, 0.1f);
		decorator.addOre(new WorldGenMinable(Blocks.lapis_ore, 6), 1.0f, 0, 48);
		decorator.grassPerChunk = 6;
		decorator.doubleGrassPerChunk = 1;
		decorator.flowersPerChunk = 3;
		decorator.doubleFlowersPerChunk = 1;
		decorator.addTree(LOTRTreeType.OAK_DESERT, 1000);
		decorator.addTree(LOTRTreeType.CEDAR, 300);
		decorator.addTree(LOTRTreeType.CYPRESS, 500);
		decorator.addTree(LOTRTreeType.CYPRESS_LARGE, 50);
		decorator.addTree(LOTRTreeType.PALM, 100);
		decorator.addTree(LOTRTreeType.DATE_PALM, 5);
		decorator.addTree(LOTRTreeType.LEMON, 2);
		decorator.addTree(LOTRTreeType.ORANGE, 2);
		decorator.addTree(LOTRTreeType.LIME, 2);
		decorator.addTree(LOTRTreeType.OLIVE, 5);
		decorator.addTree(LOTRTreeType.OLIVE_LARGE, 5);
		decorator.addTree(LOTRTreeType.PLUM, 2);
		registerHaradFlowers();
		biomeColors.setGrass(11914805);
		decorator.addRandomStructure(new LOTRWorldGenHaradObelisk(false), 3000);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.NEAR_HARAD(1, 3), 300);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.NUMENOR(1, 3), 4000);
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
		setBanditEntityClass(LOTREntityBanditHarad.class);
		decorator.addVillage(new LOTRVillageGenSouthron(this, 1.0f));
	}

	@Override
	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		double d = 0;
		double d2 = 0;
		Block topBlock_pre = topBlock;
		int topBlockMeta_pre = topBlockMeta;
		Block fillerBlock_pre = fillerBlock;
		int fillerBlockMeta_pre = fillerBlockMeta;
		double d1 = noiseDirt.func_151601_a(i * 0.002, k * 0.002);
		double d22 = noiseDirt.func_151601_a(i * 0.07, k * 0.07);
		double d3 = noiseDirt.func_151601_a(i * 0.25, k * 0.25);
		double d4 = noiseSand.func_151601_a(i * 0.002, k * 0.002);
		noiseSand.func_151601_a(i * 0.07, k * 0.07);
		noiseSand.func_151601_a(i * 0.25, k * 0.25);
		if (d4 + d2 + d > 1.1) {
			topBlock = Blocks.sand;
			topBlockMeta = 0;
			fillerBlock = topBlock;
			fillerBlockMeta = topBlockMeta;
		} else if (d1 + d22 + d3 > 0.6) {
			topBlock = Blocks.dirt;
			topBlockMeta = 1;
		}
		super.generateBiomeTerrain(world, random, blocks, meta, i, k, stoneNoise, height, variant);
		topBlock = topBlock_pre;
		topBlockMeta = topBlockMeta_pre;
		fillerBlock = fillerBlock_pre;
		fillerBlockMeta = fillerBlockMeta_pre;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.NEAR_HARAD.getSubregion("umbar");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.UMBAR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.05f;
	}

	@Override
	public WorldGenerator getRandomWorldGenForDoubleFlower(Random random) {
		LOTRWorldGenDoubleFlower doubleFlowerGen = new LOTRWorldGenDoubleFlower();
		if (random.nextInt(5) == 0) {
			doubleFlowerGen.setFlowerType(3);
		} else {
			doubleFlowerGen.setFlowerType(2);
		}
		return doubleFlowerGen;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.UMBAR;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.15f;
	}

	@Override
	public int spawnCountMultiplier() {
		return 2;
	}
}
