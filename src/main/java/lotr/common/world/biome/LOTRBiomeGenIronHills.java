/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.BiomeGenBase
 *  net.minecraft.world.biome.BiomeGenBase$SpawnListEntry
 *  net.minecraft.world.gen.feature.WorldGenMinable
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.LOTRMod;
import lotr.common.entity.animal.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class LOTRBiomeGenIronHills extends LOTRBiome {
	public LOTRBiomeGenIronHills(int i, boolean major) {
		super(i, major);
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityWildBoar.class, 50, 4, 4));
		spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBear.class, 8, 1, 4));
		variantChance = 0.3f;
		addBiomeVariantSet(LOTRBiomeVariant.SET_MOUNTAINS);
		decorator.biomeGemFactor = 0.75f;
		decorator.addOre(new WorldGenMinable(Blocks.iron_ore, 4), 20.0f, 0, 96);
		decorator.addOre(new WorldGenMinable(Blocks.gold_ore, 4), 2.0f, 0, 48);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreSilver, 4), 2.0f, 0, 48);
		decorator.addOre(new WorldGenMinable(LOTRMod.oreGlowstone, 4), 8.0f, 0, 48);
		decorator.treesPerChunk = 0;
		decorator.flowersPerChunk = 1;
		decorator.grassPerChunk = 8;
		decorator.doubleGrassPerChunk = 1;
		decorator.generateWater = false;
		decorator.generateCobwebs = false;
		decorator.addTree(LOTRTreeType.SPRUCE, 500);
		decorator.addTree(LOTRTreeType.SPRUCE_MEGA, 200);
		decorator.addTree(LOTRTreeType.SPRUCE_MEGA_THIN, 50);
		decorator.addTree(LOTRTreeType.FIR, 400);
		decorator.addTree(LOTRTreeType.PINE, 400);
		registerMountainsFlowers();
		addFlower(LOTRMod.dwarfHerb, 0, 1);
		npcSpawnList.newFactionList(100).add(LOTRBiomeSpawnList.entry(LOTRSpawnList.DWARVES, 10).setSpawnChance(600));
		setBanditChance(LOTREventSpawner.EventChance.BANDIT_RARE);

	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		for (int l = 0; l < 8; ++l) {
			int k1;
			int i1 = i + random.nextInt(16) + 8;
			int j1 = world.getHeightValue(i1, k1 = k + random.nextInt(16) + 8);
			if (j1 <= 80) {
				continue;
			}
			decorator.genTree(world, random, i1, j1, k1);
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.DWARVEN.getSubregion("ironHills");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.IRON_HILLS;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.25f;
	}

	@Override
	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.PATH;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.1f;
	}
}
