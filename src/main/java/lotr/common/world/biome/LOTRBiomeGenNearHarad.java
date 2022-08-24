/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockDeadBush
 *  net.minecraft.block.BlockSand
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.NoiseGeneratorPerlin
 *  net.minecraft.world.gen.feature.WorldGenCactus
 *  net.minecraft.world.gen.feature.WorldGenDeadBush
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.entity.animal.*;
import lotr.common.entity.npc.LOTREntityBanditHarad;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import lotr.common.world.structure.LOTRWorldGenHaradObelisk;
import lotr.common.world.structure2.LOTRWorldGenStoneRuin;
import lotr.common.world.village.LOTRVillageGenSouthron;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.*;

public class LOTRBiomeGenNearHarad extends LOTRBiome {
	private static NoiseGeneratorPerlin noiseAridGrass = new NoiseGeneratorPerlin(new Random(62926025827260L), 1);
	private WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);
	private WorldGenerator boulderGenSandstone = new LOTRWorldGenBoulder(Blocks.sandstone, 0, 1, 3);

	public LOTRBiomeGenNearHarad(int i, boolean major) {
		super(i, major);
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.COAST_SOUTHRONS, 20).setSpawnChance(100), LOTRBiomeSpawnList.entry(LOTRSpawnList.SOUTHRON_WARRIORS, 15).setSpawnChance(100));
		setDisableRain();
		topBlock = Blocks.sand;
		fillerBlock = Blocks.sand;
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityCamel.class, 10, 2, 6));
		spawnableLOTRAmbientList.clear();
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDesertScorpion.class, 10, 4, 4));
		variantChance = 0.8f;
		this.addBiomeVariant(LOTRBiomeVariant.DUNES, 0.5f);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.BOULDERS_RED);
		this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.SCRUBLAND_SAND);
		decorator.addOre(new WorldGenMinable(Blocks.lapis_ore, 6), 1.0f, 0, 48);
		decorator.grassPerChunk = 0;
		decorator.doubleGrassPerChunk = 0;
		decorator.cactiPerChunk = 0;
		decorator.deadBushPerChunk = 0;
		decorator.addTree(LOTRTreeType.OAK_DEAD, 800);
		decorator.addTree(LOTRTreeType.OAK_DESERT, 200);
		registerHaradFlowers();
		biomeColors.setFog(16180681);
		decorator.addRandomStructure(new LOTRWorldGenHaradObelisk(false), 3000);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.NEAR_HARAD(1, 3), 300);
		decorator.addRandomStructure(new LOTRWorldGenStoneRuin.NUMENOR(1, 3), 4000);
		decorator.addVillage(new LOTRVillageGenSouthron(this, 0.1f));
		clearTravellingTraders();
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);
		setBanditEntityClass(LOTREntityBanditHarad.class);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		int l;
		int preGrasses;
		int k1;
		int i12;
		int j1;
		int j12;
		int k12;
		int i1;
		int grasses = preGrasses = decorator.grassPerChunk;
		double d1 = noiseAridGrass.func_151601_a(i * 0.002, k * 0.002);
		if (d1 > 0.5) {
			++grasses;
		}
		decorator.grassPerChunk = grasses;
		super.decorate(world, random, i, k);
		decorator.grassPerChunk = preGrasses;
		if (random.nextInt(50) == 0) {
			i1 = i + random.nextInt(16) + 8;
			k12 = k + random.nextInt(16) + 8;
			j12 = world.getHeightValue(i1, k12);
			new WorldGenCactus().generate(world, random, i1, j12, k12);
		}
		if (random.nextInt(16) == 0) {
			i1 = i + random.nextInt(16) + 8;
			k12 = k + random.nextInt(16) + 8;
			j12 = world.getHeightValue(i1, k12);
			new WorldGenDeadBush(Blocks.deadbush).generate(world, random, i1, j12, k12);
		}
		if (random.nextInt(120) == 0) {
			int boulders = 1 + random.nextInt(4);
			for (l = 0; l < boulders; ++l) {
				i12 = i + random.nextInt(16) + 8;
				k1 = k + random.nextInt(16) + 8;
				j1 = world.getHeightValue(i12, k1);
				if (random.nextBoolean()) {
					boulderGen.generate(world, random, i12, j1, k1);
					continue;
				}
				boulderGenSandstone.generate(world, random, i12, j1, k1);
			}
		}
		if (random.nextInt(2000) == 0) {
			int trees = 1 + random.nextInt(4);
			for (l = 0; l < trees; ++l) {
				i12 = i + random.nextInt(8) + 8;
				k1 = k + random.nextInt(8) + 8;
				j1 = world.getHeightValue(i12, k1);
				decorator.genTree(world, random, i12, j1, k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.NEAR_HARAD.getSubregion("desert");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.HARAD_DESERT;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.05f;
	}

	@Override
	public boolean getEnableRiver() {
		return false;
	}

	@Override
	public LOTRBiome.GrassBlockAndMeta getRandomGrass(Random random) {
		return new LOTRBiome.GrassBlockAndMeta(LOTRMod.aridGrass, 0);
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.HARAD.setRepair(0.5f);
	}

	@Override
	public float getTreeIncreaseChance() {
		return 5.0E-4f;
	}

	public interface ImmuneToHeat {
	}

}
