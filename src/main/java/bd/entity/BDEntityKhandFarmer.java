package bd.entity;

import bd.database.BDUnitTradeEntries;
import lotr.common.*;
import lotr.common.entity.npc.*;
import lotr.common.item.LOTRItemHaradRobes;
import lotr.common.world.spawning.LOTRInvasions;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityKhandFarmer extends BDEntityKhandMan implements LOTRTradeable, LOTRUnitTradeable {
	public BDEntityKhandFarmer(World world) {
		super(world);
		this.addTargetTasks(false);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 0.0f && isFriendlyAndAligned(entityplayer);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return LOTRTradeEntries.RHUN_FARMER_BUY;
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return LOTRTradeEntries.RHUN_FARMER_SELL;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			return "khand/farmer/friendly";
		}
		return "khand/farmer/hostile";
	}

	@Override
	public LOTRUnitTradeEntries getUnits() {
		return BDUnitTradeEntries.KHAND_FARMER;
	}

	@Override
	public LOTRInvasions getWarhorn() {
		return null;
	}

	@Override
	public void onPlayerTrade(EntityPlayer entityplayer, LOTRTradeEntries.TradeType type, ItemStack itemstack) {
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(LOTRMod.hoeBronze));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		int robeColor = 7577646;
		ItemStack body = new ItemStack(LOTRMod.bodyKaftan);
		ItemStack legs = new ItemStack(LOTRMod.legsKaftan);
		LOTRItemHaradRobes.setRobesColor(body, robeColor);
		LOTRItemHaradRobes.setRobesColor(legs, robeColor);
		setCurrentItemOrArmor(3, body);
		setCurrentItemOrArmor(2, legs);
		return data;
	}

	@Override
	public void onUnitTrade(EntityPlayer entityplayer) {
	}
}
