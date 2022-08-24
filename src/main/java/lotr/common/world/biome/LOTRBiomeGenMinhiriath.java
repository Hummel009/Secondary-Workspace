/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.init.Blocks
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 */
package lotr.common.world.biome;

import java.util.Random;

import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.*;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenMinhiriath extends LOTRBiomeGenEriador {
	protected WorldGenerator boulderGen = new LOTRWorldGenBoulder(Blocks.stone, 0, 1, 3);

	public LOTRBiomeGenMinhiriath(int i, boolean major) {
		super(i, major);
		clearBiomeVariants();
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE);
		this.addBiomeVariant(LOTRBiomeVariant.STEPPE_BARREN);
		this.addBiomeVariant(LOTRBiomeVariant.HILLS);
		this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK);
		this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_SPRUCE);
		this.addBiomeVariant(LOTRBiomeVariant.DEADFOREST_OAK_SPRUCE);
		decorator.grassPerChunk = 5;
		decorator.doubleGrassPerChunk = 3;
		decorator.addTree(LOTRTreeType.OAK_DEAD, 1000);
		decorator.addTree(LOTRTreeType.SPRUCE_DEAD, 300);
		decorator.addTree(LOTRTreeType.BEECH_DEAD, 100);
		decorator.addTree(LOTRTreeType.BIRCH_DEAD, 50);
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(16) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				boulderGen.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.ERIADOR.getSubregion("minhiriath");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.ERIADOR;
	}

	@Override
	public float getChanceToSpawnAnimals() {
		return 0.05f;
	}

	@Override
	public float getTreeIncreaseChance() {
		return 0.1f;
	}
}
