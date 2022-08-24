package bd.entity;

import bd.database.*;
import lotr.common.LOTRLevelData;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import lotr.common.entity.npc.*;
import lotr.common.world.spawning.LOTRInvasions;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityKhandWarlord extends BDEntityKhandGoldWarrior implements LOTRUnitTradeable {
	public BDEntityKhandWarlord(World world) {
		super(world);
		this.addTargetTasks(false);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 150.0f && isFriendlyAndAligned(entityplayer);
	}

	@Override
	protected EntityAIBase createKHANDAttackAI() {
		return new LOTREntityAIAttackOnCollide(this, 1.6, true);
	}

	@Override
	public float getAlignmentBonus() {
		return 5.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "rhun/warlord/friendly";
			}
			return "rhun/warlord/neutral";
		}
		return "rhun/warrior/hostile";
	}

	@Override
	public LOTRUnitTradeEntries getUnits() {
		return BDUnitTradeEntries.KHAND_WARLORD;
	}

	@Override
	public LOTRInvasions getWarhorn() {
		return BDInvasions.KHAND;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.khand2_hammer));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(BDRegistry.khand2_boots));
		setCurrentItemOrArmor(2, new ItemStack(BDRegistry.khand2_leggings));
		setCurrentItemOrArmor(3, new ItemStack(BDRegistry.khand2_chestplate));
		setCurrentItemOrArmor(4, new ItemStack(BDRegistry.khand2_helmet));
		return data;
	}

	@Override
	public void onUnitTrade(EntityPlayer entityplayer) {
	}
}
