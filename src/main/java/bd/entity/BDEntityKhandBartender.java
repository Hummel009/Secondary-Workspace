package bd.entity;

import lotr.common.*;
import lotr.common.entity.npc.*;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityKhandBartender extends BDEntityKhandMan implements LOTRTradeable.Bartender {
	public BDEntityKhandBartender(World world) {
		super(world);
		this.addTargetTasks(false);
		npcLocationName = "entity.lotr.KhandBartender.locationName";
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return isFriendlyAndAligned(entityplayer);
	}

	@Override
	public void dropFewItems(boolean flag, int i) {
		super.dropFewItems(flag, i);
		int drinks = 1 + rand.nextInt(4) + i;
		for (int l = 0; l < drinks; ++l) {
			ItemStack drink = LOTRFoods.RHUN_DRINK.getRandomFood(rand);
			entityDropItem(drink, 0.0f);
		}
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return LOTRTradeEntries.RHUN_BARTENDER_BUY;
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return LOTRTradeEntries.RHUN_BARTENDER_SELL;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			return "rhun/bartender/friendly";
		}
		return "rhun/bartender/hostile";
	}

	@Override
	public void onPlayerTrade(EntityPlayer entityplayer, LOTRTradeEntries.TradeType type, ItemStack itemstack) {
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setIdleItem(new ItemStack(LOTRMod.mug));
		return data;
	}
}
