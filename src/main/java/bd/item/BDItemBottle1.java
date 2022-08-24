package bd.item;

import bd.database.BDCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.world.World;

public class BDItemBottle1 extends Item {
	public BDItemBottle1() {
		setMaxDamage(2);
		setCreativeTab(BDCreativeTabs.tabCombat);
		maxStackSize = 1;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack itemstack) {
		return EnumAction.bow;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemstack) {
		return 40;
	}

	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		entityplayer.heal(2);
		entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 40, 1));
		entityplayer.swingItem();
		itemstack.damageItem(2, entityplayer);
		return itemstack;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		entityplayer.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
		return itemstack;
	}
}
