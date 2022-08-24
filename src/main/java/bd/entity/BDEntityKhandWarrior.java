package bd.entity;

import bd.database.BDRegistry;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityKhandWarrior extends BDEntityKhandLevyman {
	public BDEntityKhandWarrior(World world) {
		super(world);
		this.addTargetTasks(true);
		spawnRidingHorse = rand.nextInt(6) == 0;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(npcRangedAccuracy).setBaseValue(0.75);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		int i = rand.nextInt(10);
		switch (i) {
		case 0:
		case 1:
		case 2:
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.khand1_sword));
			break;
		case 3:
		case 4:
		case 5:
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.khand1_hammer));
			break;
		case 6:
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.khand1_spear));
			break;
		case 7:
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.khand1_dagger));
			break;
		case 8:
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.khand1_dagger_poisoned));
			break;
		case 9:
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.khand1_pike));
			break;
		default:
			break;
		}
		if (rand.nextInt(5) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.khand1_spear));
		}
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(BDRegistry.khand1_boots));
		setCurrentItemOrArmor(2, new ItemStack(BDRegistry.khand1_leggings));
		setCurrentItemOrArmor(3, new ItemStack(BDRegistry.khand1_chestplate));
		setCurrentItemOrArmor(4, null);
		return data;
	}
}
