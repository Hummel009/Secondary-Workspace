package bd.dispence;

import bd.entity.BDEntityArrowHunger;
import net.minecraft.dispenser.*;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

public class BDDispenseArrowHunger extends BehaviorProjectileDispense {
	@Override
	protected IProjectile getProjectileEntity(World world, IPosition iposition) {
		BDEntityArrowHunger arrow = new BDEntityArrowHunger(world, iposition.getX(), iposition.getY(), iposition.getZ());
		arrow.canBePickedUp = 1;
		return arrow;
	}
}
