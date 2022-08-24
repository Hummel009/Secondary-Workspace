package bd.entity;

import bd.database.BDTradeEntries;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTRTradeEntries;
import lotr.common.item.LOTRItemHaradRobes;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityKhandMason extends BDEntityKhandMarketTrader {
	public BDEntityKhandMason(World world) {
		super(world);
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return BDTradeEntries.KHAND_MASON_BUY;
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return LOTRTradeEntries.RHUN_MASON_SELL;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(Items.iron_pickaxe));
		npcItemsInv.setIdleItem(new ItemStack(Blocks.stone));
		int robeColor = 10855057;
		ItemStack body = new ItemStack(LOTRMod.bodyKaftan);
		ItemStack legs = new ItemStack(LOTRMod.legsKaftan);
		LOTRItemHaradRobes.setRobesColor(body, robeColor);
		LOTRItemHaradRobes.setRobesColor(legs, robeColor);
		setCurrentItemOrArmor(3, body);
		setCurrentItemOrArmor(2, legs);
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
