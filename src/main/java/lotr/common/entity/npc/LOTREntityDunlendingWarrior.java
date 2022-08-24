/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package lotr.common.entity.npc;

import bd.database.BDRegistry;
import lotr.common.*;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LOTREntityDunlendingWarrior extends LOTREntityDunlending {
	public LOTREntityDunlendingWarrior(World world) {
		super(world);
		npcShield = LOTRShields.ALIGNMENT_DUNLAND;
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public EntityAIBase getDunlendingAttackAI() {
		return new LOTREntityAIAttackOnCollide(this, 1.6, false);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		int i = rand.nextInt(2);
		if (i == 1) {
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.enedwaith1_pike));
		} else if (i == 0) {
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.enedwaith1_sword));
		}
		if (rand.nextInt(5) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.enedwaith1_spear));
		}
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(LOTRMod.bootsDunlending));
		setCurrentItemOrArmor(2, new ItemStack(LOTRMod.legsDunlending));
		setCurrentItemOrArmor(3, new ItemStack(LOTRMod.bodyDunlending));
		if (rand.nextInt(10) != 0) {
			setCurrentItemOrArmor(4, new ItemStack(LOTRMod.helmetDunlending));
		}
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
