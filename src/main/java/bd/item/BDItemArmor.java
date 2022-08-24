package bd.item;

import bd.database.BDCreativeTabs;
import bd.util.BDCommander;
import lotr.common.item.*;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.*;
import net.minecraft.item.ItemStack;

public class BDItemArmor extends LOTRItemArmor {
	public BDItemArmor(LOTRMaterial material, int slotType) {
		super(material, slotType);
		setCreativeTab(BDCreativeTabs.tabCombat);
	}

	public BDItemArmor(LOTRMaterial material, int slotType, String textureSuffix) {
		super(material, slotType, textureSuffix);
		setCreativeTab(BDCreativeTabs.tabCombat);
	}

	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		ModelBiped customModel = getCustomModel(entityLiving, itemStack, armorSlot);
		if (customModel != null) {
			customModel.isRiding = entityLiving.isRiding();
			customModel.isSneak = entityLiving.isSneaking();
		}
		return customModel;
	}

	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		StringBuilder texture = new StringBuilder("bd:armor/").append(BDCommander.getArmorName(this));
		if (type != null) {
			texture.append("_").append(type);
		}
		return texture.append(".png").toString();
	}

	public ModelBiped getCustomModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		return null;
	}
}
