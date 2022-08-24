package bd.entity;

import lotr.common.entity.npc.LOTRBannerBearer;
import lotr.common.item.LOTRItemBanner;
import net.minecraft.world.World;

public class BDEntityKhandBannerBearer extends BDEntityKhandWarrior implements LOTRBannerBearer {
	public BDEntityKhandBannerBearer(World world) {
		super(world);
	}

	@Override
	public LOTRItemBanner.BannerType getBannerType() {
		return LOTRItemBanner.BannerType.KHAND;
	}
}
