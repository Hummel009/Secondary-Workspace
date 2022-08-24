package bd.entity;

import lotr.common.LOTRMod;
import lotr.common.entity.ai.LOTREntityAIFarm;
import lotr.common.entity.npc.LOTRFarmhand;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class BDEntityKhandFarmhand extends BDEntityKhandMan implements LOTRFarmhand {
	public Item seedsItem;

	public BDEntityKhandFarmhand(World world) {
		super(world);
		tasks.addTask(3, new LOTREntityAIFarm(this, 1.0, 1.0f));
		targetTasks.taskEntries.clear();
		this.addTargetTasks(false);
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
			return "rhun/farmhand/hired";
		}
		return super.getSpeechBank(entityplayer);
	}

	@Override
	public IPlantable getUnhiredSeeds() {
		if (seedsItem == null) {
			return (IPlantable) Items.wheat_seeds;
		}
		return (IPlantable) seedsItem;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(LOTRMod.hoeBronze));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		return data;
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		Item item;
		super.readEntityFromNBT(nbt);
		if (nbt.hasKey("SeedsID") && (item = Item.getItemById(nbt.getInteger("SeedsID"))) != null && item instanceof IPlantable) {
			seedsItem = item;
		}
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);
		if (seedsItem != null) {
			nbt.setInteger("SeedsID", Item.getIdFromItem(seedsItem));
		}
	}
}
