package bd.entity;

import bd.database.*;
import lotr.common.entity.npc.*;
import lotr.common.fac.LOTRFaction;
import lotr.common.world.biome.LOTRBiomeGenEregion;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BDEntityEregionElf extends LOTREntityHighElf {
	public BDEntityEregionElf(World world) {
		super(world);
	}

	@Override
	public boolean canElfSpawnHere() {
		int i = MathHelper.floor_double(posX);
		int j = MathHelper.floor_double(boundingBox.minY);
		int k = MathHelper.floor_double(posZ);
		BiomeGenBase biome = worldObj.getBiomeGenForCoords(i, k);
		return j > 62 && worldObj.getBlock(i, j - 1, k) == biome.topBlock;
	}

	@Override
	protected void dropElfItems(boolean flag, int i) {
		super.dropElfItems(flag, i);
		if (rand.nextInt(6) == 0) {
			dropChestContents(BDChestContents.EREGION_HALL, 1, 1 + i);
		}
	}

	@Override
	public float getAlignmentBonus() {
		return 1.0f;
	}

	@Override
	public float getBlockPathWeight(int i, int j, int k) {
		float f = 0.0f;
		BiomeGenBase biome = worldObj.getBiomeGenForCoords(i, k);
		if (biome instanceof LOTRBiomeGenEregion) {
			f += 20.0f;
		}
		return f;
	}

	@Override
	public LOTRFaction getFaction() {
		return LOTRFaction.EREGION;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "galadhrim/elf/hired";
			}
			return "galadhrim/elf/friendly";
		}
		return "galadhrim/elf/hostile";
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(BDRegistry.eregion1_dagger));
		npcItemsInv.setRangedWeapon(new ItemStack(BDRegistry.eregion1_bow));
		npcItemsInv.setIdleItem(null);
		return data;
	}

	@Override
	public void setupNPCName() {
		familyInfo.setName(LOTRNames.getSindarinOrQuenyaName(rand, familyInfo.isMale()));
	}
}