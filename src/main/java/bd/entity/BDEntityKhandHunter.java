package bd.entity;

import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTRTradeEntries;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityKhandHunter extends BDEntityKhandMarketTrader {
	public BDEntityKhandHunter(World world) {
		super(world);
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return LOTRTradeEntries.RHUN_HUNTER_BUY;
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return LOTRTradeEntries.RHUN_HUNTER_SELL;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(LOTRMod.spearBronze));
		npcItemsInv.setIdleItem(new ItemStack(LOTRMod.fur));
		setCurrentItemOrArmor(1, new ItemStack(Items.leather_boots));
		setCurrentItemOrArmor(2, new ItemStack(Items.leather_leggings));
		setCurrentItemOrArmor(3, new ItemStack(Items.leather_chestplate));
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
