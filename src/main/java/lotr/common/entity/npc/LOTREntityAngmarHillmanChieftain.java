package lotr.common.entity.npc;

import bd.database.BDRegistry;
import lotr.common.*;
import lotr.common.world.spawning.LOTRInvasions;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LOTREntityAngmarHillmanChieftain extends LOTREntityAngmarHillmanWarrior implements LOTRUnitTradeable {
	public LOTREntityAngmarHillmanChieftain(World world) {
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
		return LOTRLevelData.getData(entityplayer).getAlignment(getFaction()) >= 100.0f && isFriendlyAndAligned(entityplayer);
	}

	@Override
	public float getAlignmentBonus() {
		return 5.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (canTradeWith(entityplayer)) {
				return "angmar/hillmanChieftain/friendly";
			}
			return "angmar/hillmanChieftain/neutral";
		}
		return "angmar/hillman/hostile";
	}

	@Override
	public LOTRUnitTradeEntries getUnits() {
		return LOTRUnitTradeEntries.ANGMAR_HILLMAN_CHIEFTAIN;
	}

	@Override
	public LOTRInvasions getWarhorn() {
		return LOTRInvasions.ANGMAR_HILLMEN;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.karndumy_sword));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		setCurrentItemOrArmor(1, new ItemStack(BDRegistry.karndum3_boots));
		setCurrentItemOrArmor(2, new ItemStack(BDRegistry.karndum3_leggings));
		setCurrentItemOrArmor(3, new ItemStack(BDRegistry.karndum3_chestplate));
		setCurrentItemOrArmor(4, null);
		return data;
	}

	@Override
	public void onUnitTrade(EntityPlayer entityplayer) {
		LOTRLevelData.getData(entityplayer).addAchievement(LOTRAchievement.tradeAngmarHillmanChieftain);
	}
}
