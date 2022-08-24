package bd.entity;

import bd.database.BDRegistry;
import lotr.common.LOTRShields;
import net.minecraft.entity.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityKhandGoldWarrior extends BDEntityKhandWarrior {
	public BDEntityKhandGoldWarrior(World world) {
		super(world);
		npcShield = LOTRShields.ALIGNMENT_KHAND;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		setCurrentItemOrArmor(1, new ItemStack(BDRegistry.khand2_boots));
		setCurrentItemOrArmor(2, new ItemStack(BDRegistry.khand2_leggings));
		setCurrentItemOrArmor(3, new ItemStack(BDRegistry.khand2_chestplate));
		setCurrentItemOrArmor(4, new ItemStack(BDRegistry.khand2_helmet));
		return data;
	}
}
