package bd.dispence;

import bd.entity.BDEntityArrowSlowness;
import net.minecraft.dispenser.*;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

public class BDDispenseArrowSlowness extends BehaviorProjectileDispense {
	@Override
	protected IProjectile getProjectileEntity(World world, IPosition iposition) {
		BDEntityArrowSlowness arrow = new BDEntityArrowSlowness(world, iposition.getX(), iposition.getY(), iposition.getZ());
		arrow.canBePickedUp = 1;
		return arrow;
	}
}
