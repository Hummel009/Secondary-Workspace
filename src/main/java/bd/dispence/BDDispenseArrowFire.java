package bd.dispence;

import bd.entity.BDEntityArrowFire;
import net.minecraft.dispenser.*;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

public class BDDispenseArrowFire extends BehaviorProjectileDispense {
	@Override
	protected IProjectile getProjectileEntity(World world, IPosition iposition) {
		BDEntityArrowFire arrow = new BDEntityArrowFire(world, iposition.getX(), iposition.getY(), iposition.getZ());
		arrow.canBePickedUp = 1;
		return arrow;
	}
}
