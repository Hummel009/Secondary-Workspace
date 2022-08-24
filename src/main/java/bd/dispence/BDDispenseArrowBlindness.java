package bd.dispence;

import bd.entity.BDEntityArrowBlindness;
import net.minecraft.dispenser.*;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

public class BDDispenseArrowBlindness extends BehaviorProjectileDispense {
	@Override
	protected IProjectile getProjectileEntity(World world, IPosition iposition) {
		BDEntityArrowBlindness arrow = new BDEntityArrowBlindness(world, iposition.getX(), iposition.getY(), iposition.getZ());
		arrow.canBePickedUp = 1;
		return arrow;
	}
}
