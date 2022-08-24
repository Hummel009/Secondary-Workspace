package bd.entity;

import lotr.common.entity.npc.LOTRBannerBearer;
import lotr.common.item.LOTRItemBanner;
import net.minecraft.world.World;

public class BDEntityEregionBannerBearer extends BDEntityEregionWarrior implements LOTRBannerBearer {
	public BDEntityEregionBannerBearer(World world) {
		super(world);
	}

	@Override
	public LOTRItemBanner.BannerType getBannerType() {
		return LOTRItemBanner.BannerType.EREGION;
	}
}
