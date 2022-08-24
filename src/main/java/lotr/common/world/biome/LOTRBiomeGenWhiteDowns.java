package lotr.common.world.biome;

import java.util.Random;

import lotr.common.*;
import lotr.common.world.biome.variant.LOTRBiomeVariant;
import lotr.common.world.feature.LOTRWorldGenBoulder;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class LOTRBiomeGenWhiteDowns extends LOTRBiomeGenShire {
	private WorldGenerator chalkBoulder = new LOTRWorldGenBoulder(LOTRMod.rock, 5, 1, 3);

	public LOTRBiomeGenWhiteDowns(int i, boolean major) {
		super(i, major);
		fillerBlock = LOTRMod.rock;
		fillerBlockMeta = 5;
		clearBiomeVariants();
		this.addBiomeVariant(LOTRBiomeVariant.FLOWERS);
		this.addBiomeVariant(LOTRBiomeVariant.FOREST_LIGHT);
		biomeColors.resetGrass();

	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		super.decorate(world, random, i, k);
		if (random.nextInt(80) == 0) {
			for (int l = 0; l < 3; ++l) {
				int i1 = i + random.nextInt(16) + 8;
				int k1 = k + random.nextInt(16) + 8;
				chalkBoulder.generate(world, random, i1, world.getHeightValue(i1, k1), k1);
			}
		}
	}

	@Override
	public LOTRAchievement getBiomeAchievement() {
		return LOTRAchievement.enterWhiteDowns;
	}

	@Override
	public LOTRMusicRegion.Sub getBiomeMusic() {
		return LOTRMusicRegion.SHIRE.getSubregion("whiteDowns");
	}

	@Override
	public LOTRWaypoint.Region getBiomeWaypoints() {
		return LOTRWaypoint.Region.SHIRE;
	}

	@Override
	public int spawnCountMultiplier() {
		return 5;
	}
}
