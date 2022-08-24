/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.item.Item
 */
package lotr.common.block;

import java.util.*;

import bd.database.BDRegistry;
import lotr.common.LOTRMod;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class LOTRBlockLeaves3 extends LOTRBlockLeavesBase {
	public LOTRBlockLeaves3() {
		setLeafNames("maple", "larch", "datePalm", "mangrove");
	}

	@Override
	protected void addSpecialLeafDrops(ArrayList drops, World world, int i, int j, int k, int meta, int fortune) {
		if ((meta & 3) == 0 && world.rand.nextInt(calcFortuneModifiedDropChance(20, fortune)) == 0) {
			drops.add(new ItemStack(LOTRMod.chestnut));
		}
	}

	@Override
	public Item getItemDropped(int i, Random random, int j) {
		return Item.getItemFromBlock(LOTRMod.sapling3);
	}

	@Override
	protected int getSaplingChance(int meta) {
		if (meta == 2) {
			return 15;
		}
		return super.getSaplingChance(meta);
	}

	@Override
	public void updateTick(World world, int i, int j, int k, Random random) {
		super.updateTick(world, i, j, k, random);
		if (!world.isRemote && world.getBlock(i, j, k) == this) {
			boolean playerPlaced;
			int meta = world.getBlockMetadata(i, j, k);
			int leafType = meta & 3;
			playerPlaced = (meta & 4) != 0;
			if (leafType == 0 && !playerPlaced && world.isAirBlock(i, j - 1, k) && random.nextInt(300) == 0) {
				double d = i + random.nextDouble();
				double d1 = j - 0.2;
				double d2 = k + random.nextDouble();
				EntityItem conker = new EntityItem(world, d, d1, d2, new ItemStack(BDRegistry.maple_leaf));
				conker.delayBeforeCanPickup = 10;
				conker.motionZ = 0.0;
				conker.motionY = 0.0;
				conker.motionX = 0.0;
				world.spawnEntityInWorld(conker);
			}
		}
	}
}
