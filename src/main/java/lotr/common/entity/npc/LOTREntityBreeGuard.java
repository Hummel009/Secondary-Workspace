/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package lotr.common.entity.npc;

import bd.database.BDRegistry;
import lotr.common.*;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LOTREntityBreeGuard extends LOTREntityBreeMan {
	private static final ItemStack[] guardWeapons = { new ItemStack(Items.iron_sword), new ItemStack(Items.iron_sword), new ItemStack(LOTRMod.pikeIron) };

	public LOTREntityBreeGuard(World world) {
		super(world);
		this.addTargetTasks(true);
		npcShield = LOTRShields.ALIGNMENT_BREE;
	}

	@Override
	protected int addBreeAttackAI(int prio) {
		tasks.addTask(prio, new LOTREntityAIAttackOnCollide(this, 1.45, false));
		return prio;
	}

	@Override
	protected void addBreeAvoidAI(int prio) {
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "bree/guard/hired";
			}
			return "bree/guard/friendly";
		}
		return "bree/guard/hostile";
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		int i = rand.nextInt(guardWeapons.length);
		npcItemsInv.setMeleeWeapon(guardWeapons[i].copy());
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(BDRegistry.eriador1_boots));
		setCurrentItemOrArmor(2, new ItemStack(BDRegistry.eriador1_leggings));
		setCurrentItemOrArmor(3, new ItemStack(BDRegistry.eriador1_chestplate));
		setCurrentItemOrArmor(4, new ItemStack(BDRegistry.eriador1_helmet));
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
