package bd.structure;

import java.util.Random;

import lotr.common.item.LOTRItemBanner;
import net.minecraft.world.World;

public class BDStructureKhandTotem extends BDStructureKhandStructure {
	public BDStructureKhandTotem(boolean flag) {
		super(flag);
	}

	@Override
	public boolean generateWithSetRotation(World world, Random random, int i, int j, int k, int rotation) {
		this.setOriginAndRotation(world, i, j, k, rotation, 2);
		setupRandomBlocks(random);
		if (restrictions) {
			for (int i1 = -3; i1 <= 3; ++i1) {
				for (int k1 = -3; k1 <= 3; ++k1) {
					int j1 = getTopBlock(world, i1, k1) - 1;
					if (isSurface(world, i1, j1, k1)) {
						continue;
					}
					return false;
				}
			}
		}
		loadStrScan("khand_totem");
		associateBlockMetaAlias("WOOD", woodBlock, woodMeta);
		associateBlockMetaAlias("FENCE", fenceBlock, fenceMeta);
		associateBlockMetaAlias("FLAG", flagBlock, flagMeta);
		associateBlockMetaAlias("BONE", boneBlock, boneMeta);
		generateStrScan(world, random, 0, 0, 0);
		placeWallBanner(world, 0, 6, -5, LOTRItemBanner.BannerType.KHAND, 2);
		placeWallBanner(world, 0, 6, 5, LOTRItemBanner.BannerType.KHAND, 0);
		placeWallBanner(world, -6, 8, 0, LOTRItemBanner.BannerType.KHAND, 3);
		placeWallBanner(world, 6, 8, 0, LOTRItemBanner.BannerType.KHAND, 1);
		return true;
	}
}
