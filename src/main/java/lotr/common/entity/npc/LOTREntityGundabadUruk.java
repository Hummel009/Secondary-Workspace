/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package lotr.common.entity.npc;

import bd.database.BDRegistry;
import lotr.common.*;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LOTREntityGundabadUruk extends LOTREntityGundabadOrc {
	public LOTREntityGundabadUruk(World world) {
		super(world);
		setSize(0.6f, 1.8f);
		isWeakOrc = false;
		npcShield = LOTRShields.ALIGNMENT_GUNDABAD;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
		getEntityAttribute(npcRangedAccuracy).setBaseValue(0.75);
	}

	@Override
	public EntityAIBase createOrcAttackAI() {
		return new LOTREntityAIAttackOnCollide(this, 1.5, false);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	protected LOTRAchievement getKillAchievement() {
		return LOTRAchievement.killGundabadUruk;
	}

	@Override
	protected float getSoundPitch() {
		return super.getSoundPitch() * 0.75f;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.northy_sword));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(BDRegistry.north3_boots));
		setCurrentItemOrArmor(2, new ItemStack(BDRegistry.north3_leggings));
		setCurrentItemOrArmor(3, new ItemStack(BDRegistry.north3_chestplate));
		setCurrentItemOrArmor(4, new ItemStack(BDRegistry.north3_helmet));
		return data;
	}
}
