package bd.entity;

import bd.database.BDTradeEntries;
import lotr.common.LOTRLevelData;
import lotr.common.entity.npc.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityEregionSmith extends BDEntityEregionElf implements LOTRTradeable.Smith {
	public BDEntityEregionSmith(World world) {
		super(world);
		this.addTargetTasks(false);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 100.0f && isFriendlyAndAligned(entityplayer);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public LOTRTradeEntries getBuyPool() {
		return BDTradeEntries.EREGION_SMITH_BUY;
	}

	@Override
	public LOTRTradeEntries getSellPool() {
		return LOTRTradeEntries.GALADHRIM_SMITH_SELL;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "galadhrim/smith/friendly";
			}
			return "galadhrim/smith/neutral";
		}
		return "galadhrim/smith/hostile";
	}

	@Override
	public void onPlayerTrade(EntityPlayer entityplayer, LOTRTradeEntries.TradeType type, ItemStack itemstack) {
	}

	@Override
	public boolean shouldRenderNPCHair() {
		return false;
	}
}
