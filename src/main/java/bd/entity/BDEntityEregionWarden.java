package bd.entity;

import bd.database.BDRegistry;
import lotr.common.entity.ai.LOTREntityAIRangedAttack;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityEregionWarden extends BDEntityEregionElf {

	public BDEntityEregionWarden(World world) {
		super(world);
		tasks.addTask(2, rangedAttackAI);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
	}

	@Override
	protected EntityAIBase createElfRangedAttackAI() {
		return new LOTREntityAIRangedAttack(this, 1.25, 25, 35, 24.0f);
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
		npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.eregion2_dagger));
		npcItemsInv.setRangedWeapon(new ItemStack(BDRegistry.eregion2_bow));
		npcItemsInv.setIdleItem(npcItemsInv.getRangedWeapon());
		setCurrentItemOrArmor(1, new ItemStack(BDRegistry.eregion2_boots));
		setCurrentItemOrArmor(2, new ItemStack(BDRegistry.eregion2_leggings));
		setCurrentItemOrArmor(3, new ItemStack(BDRegistry.eregion2_chestplate));
		if (rand.nextInt(10) != 0) {
			setCurrentItemOrArmor(4, new ItemStack(BDRegistry.eregion2_helmet));
		}
		return data;
	}
}