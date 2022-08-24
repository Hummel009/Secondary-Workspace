package bd.entity;

import bd.database.BDTradeEntries;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTRTradeEntries;
import lotr.common.item.LOTRItemHaradRobes;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityKhandGoldsmith extends BDEntityKhandMarketTrader {
	public BDEntityKhandGoldsmith(World world) {
		super(world);
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return BDTradeEntries.KHAND_GOLDSMITH_BUY;
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return LOTRTradeEntries.RHUN_GOLDSMITH_SELL;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setIdleItem(new ItemStack(LOTRMod.goldRing));
		int robeColor = 16237060;
		ItemStack body = new ItemStack(LOTRMod.bodyKaftan);
		ItemStack legs = new ItemStack(LOTRMod.legsKaftan);
		LOTRItemHaradRobes.setRobesColor(body, robeColor);
		LOTRItemHaradRobes.setRobesColor(legs, robeColor);
		setCurrentItemOrArmor(3, body);
		setCurrentItemOrArmor(2, legs);
		return data;
	}
}
