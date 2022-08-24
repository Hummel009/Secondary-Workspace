package bd.entity;

import bd.database.BDRegistry;
import lotr.common.entity.ai.LOTREntityAIRangedAttack;
import lotr.common.entity.npc.LOTREntityNPC;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityKhandArcher extends BDEntityKhandWarrior {
	public BDEntityKhandArcher(World world) {
		super(world);
	}

	@Override
	protected EntityAIBase createKHANDAttackAI() {
		return new LOTREntityAIRangedAttack(this, 1.25, 30, 50, 16.0f);
	}

	@Override
	protected void dropFewItems(boolean flag, int i) {
		super.dropFewItems(flag, i);
		dropNPCArrows(i);
	}

	@Override
	public void onAttackModeChange(LOTREntityNPC.AttackMode mode, boolean mounted) {
		if (mode == LOTREntityNPC.AttackMode.IDLE) {
			setCurrentItemOrArmor(0, npcItemsInv.getIdleItem());
		} else {
			setCurrentItemOrArmor(0, npcItemsInv.getRangedWeapon());
		}
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setRangedWeapon(new ItemStack(BDRegistry.khand1_bow));
		npcItemsInv.setIdleItem(npcItemsInv.getRangedWeapon());
		return data;
	}
}
