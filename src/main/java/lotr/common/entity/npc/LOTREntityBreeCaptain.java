/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package lotr.common.entity.npc;

import bd.database.BDRegistry;
import lotr.common.*;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.world.spawning.LOTRInvasions;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LOTREntityBreeCaptain extends LOTREntityBreeGuard implements LOTRUnitTradeable {
	public LOTREntityBreeCaptain(World world) {
		super(world);
		this.addTargetTasks(false);
	}

	@Override
	protected int addBreeAttackAI(int prio) {
		tasks.addTask(prio, new LOTREntityAIAttackOnCollide(this, 1.5, false));
		return prio;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 100.0f && isFriendlyAndAligned(entityplayer);
	}

	@Override
	public float getAlignmentBonus() {
		return 5.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "bree/captain/friendly";
			}
			return "bree/captain/neutral";
		}
		return "bree/captain/hostile";
	}

	@Override
	public LOTRUnitTradeEntries getUnits() {
		return LOTRUnitTradeEntries.BREE_CAPTAIN;
	}

	@Override
	public LOTRInvasions getWarhorn() {
		return LOTRInvasions.BREE;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		setCurrentItemOrArmor(1, new ItemStack(BDRegistry.eriador3_boots));
		setCurrentItemOrArmor(2, new ItemStack(BDRegistry.eriador3_leggings));
		setCurrentItemOrArmor(3, new ItemStack(BDRegistry.eriador3_chestplate));
		setCurrentItemOrArmor(4, new ItemStack(BDRegistry.eriador3_helmet));
		return data;
	}

	@Override
	public void onUnitTrade(EntityPlayer entityplayer) {
		LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.tradeBreeCaptain);
	}
}
