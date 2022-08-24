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
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 */
package lotr.common.entity.npc;

import bd.database.BDRegistry;
import lotr.common.LOTRCapes;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LOTREntityDunlendingBerserker extends LOTREntityDunlendingWarrior {
	public LOTREntityDunlendingBerserker(World world) {
		super(world);
		npcShield = null;
		npcCape = LOTRCapes.DUNLENDING_BERSERKER;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0);
		getEntityAttribute(npcAttackDamageExtra).setBaseValue(2.0);
	}

	@Override
	public void dropNPCEquipment(boolean flag, int i) {
	}

	@Override
	public EntityAIBase getDunlendingAttackAI() {
		return new LOTREntityAIAttackOnCollide(this, 1.7, false);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.enedwaith2_hammer));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(BDRegistry.enedwaith2_boots));
		setCurrentItemOrArmor(2, new ItemStack(BDRegistry.enedwaith2_leggings));
		setCurrentItemOrArmor(3, new ItemStack(BDRegistry.enedwaith2_chestplate));
		setCurrentItemOrArmor(4, new ItemStack(BDRegistry.enedwaith2_helmet));
		return data;
	}
}
