package bd.entity;

import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTRTradeEntries;
import lotr.common.item.LOTRItemHaradRobes;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityKhandLumberman extends BDEntityKhandMarketTrader {
	public BDEntityKhandLumberman(World world) {
		super(world);
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return LOTRTradeEntries.RHUN_LUMBERMAN_BUY;
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return LOTRTradeEntries.RHUN_LUMBERMAN_SELL;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(Items.iron_axe));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		int robeColor = 8538153;
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
