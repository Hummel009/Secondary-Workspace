package bd.entity;

import bd.database.*;
import lotr.common.LOTRLevelData;
import lotr.common.entity.npc.*;
import lotr.common.world.spawning.LOTRInvasions;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityEregionLord extends BDEntityEregionWarrior implements LOTRUnitTradeable {
	public BDEntityEregionLord(World world) {
		super(world);
		this.addTargetTasks(false);
	}

	@Override
	public boolean canTradeWith(EntityPlayer entityplayer) {
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 300.0f && isFriendlyAndAligned(entityplayer);
	}

	@Override
	public float getAlignmentBonus() {
		return 5.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "galadhrim/lord/friendly";
			}
			return "galadhrim/lord/neutral";
		}
		return "galadhrim/warrior/hostile";
	}

	@Override
	public LOTRUnitTradeEntries getUnits() {
		return BDUnitTradeEntries.EREGION_LORD;
	}

	@Override
	public LOTRInvasions getWarhorn() {
		return BDInvasions.EREGION;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.eregion1_sword));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(BDRegistry.eregion1_boots));
		setCurrentItemOrArmor(2, new ItemStack(BDRegistry.eregion1_leggings));
		setCurrentItemOrArmor(3, new ItemStack(BDRegistry.eregion1_chestplate));
		setCurrentItemOrArmor(4, null);
		return data;
	}

	@Override
	public void onUnitTrade(EntityPlayer arg0) {
	}
}
