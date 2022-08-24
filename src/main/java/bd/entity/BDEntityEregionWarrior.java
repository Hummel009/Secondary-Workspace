package bd.entity;

import bd.database.BDRegistry;
import lotr.common.LOTRShields;
import lotr.common.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityEregionWarrior extends BDEntityEregionElf {
	public BDEntityEregionWarrior(World world) {
		super(world);
		tasks.addTask(2, meleeAttackAI);
		spawnRidingHorse = rand.nextInt(4) == 0;
		npcShield = LOTRShields.ALIGNMENT_EREGION;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
	}

	@Override
	protected EntityAIBase createElfMeleeAttackAI() {
		return new LOTREntityAIAttackOnCollide(this, 1.4, false);
	}

	@Override
	protected EntityAIBase createElfRangedAttackAI() {
		return new LOTREntityAIRangedAttack(this, 1.25, 30, 40, 24.0f);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "galadhrim/elf/hired";
			}
			return "galadhrim/warrior/friendly";
		}
		return "galadhrim/warrior/hostile";
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		int i = rand.nextInt(6);
		if (i == 0) {
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.eregion1_polearm));
		} else if (i == 1) {
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.eregion1_spear));
		} else {
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.eregion1_sword));
		}
		npcItemsInv.setRangedWeapon(new ItemStack(BDRegistry.eregion1_bow));
		if (rand.nextInt(5) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.eregion1_spear));
		}
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(BDRegistry.eregion1_boots));
		setCurrentItemOrArmor(2, new ItemStack(BDRegistry.eregion1_leggings));
		setCurrentItemOrArmor(3, new ItemStack(BDRegistry.eregion1_chestplate));
		if (rand.nextInt(10) != 0) {
			setCurrentItemOrArmor(4, new ItemStack(BDRegistry.eregion1_helmet));
		}
		return data;
	}
}
