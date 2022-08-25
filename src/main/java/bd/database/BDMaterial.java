package bd.database;

import java.lang.reflect.*;

import bd.util.BDCommander;
import lotr.common.LOTRMod;
import lotr.common.item.LOTRMaterial;
import lotr.common.util.LOTRLog;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.*;

public class BDMaterial {
	public static LOTRMaterial khand3 = newLOTRMaterial("khand3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial sibata3 = newLOTRMaterial("sibata3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial rhun3 = newLOTRMaterial("rhun3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial nandor3 = newLOTRMaterial("nandor3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial sindar3 = newLOTRMaterial("sindar3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial eregion3 = newLOTRMaterial("eregion3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial enedwaith3 = newLOTRMaterial("enedwaith3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial karndum3 = newLOTRMaterial("karndum3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial numenor3 = newLOTRMaterial("numenor3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial mordor3 = newLOTRMaterial("mordor3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial red_dwarven3 = newLOTRMaterial("red_dwarven3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial rhovanion3 = newLOTRMaterial("rhovanion3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial eriador3 = newLOTRMaterial("eriador3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial noldor3 = newLOTRMaterial("noldor3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial north3 = newLOTRMaterial("north3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial harad3 = newLOTRMaterial("harad3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial khazad3 = newLOTRMaterial("khazad3", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial guardian = newLOTRMaterial("guardian", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial darkgrove = newLOTRMaterial("darkgrove", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial light = newLOTRMaterial("light", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial dark = newLOTRMaterial("dark", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial ultraviolet = newLOTRMaterial("ultraviolet", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);

	public static LOTRMaterial sibata2 = newLOTRMaterial("sibata2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial khand2 = newLOTRMaterial("khand2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial nandor2 = newLOTRMaterial("nandor2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial sindar2 = newLOTRMaterial("sindar2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial enedwaith2 = newLOTRMaterial("enedwaith2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial eregion2 = newLOTRMaterial("eregion2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial karndum2 = newLOTRMaterial("karndum2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial noldor2 = newLOTRMaterial("noldor2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial eriador2 = newLOTRMaterial("eriador2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial north2 = newLOTRMaterial("north2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial rhovanion2 = newLOTRMaterial("rhovanion2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial harad2 = newLOTRMaterial("harad2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial numenor2 = newLOTRMaterial("numenor2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial mordor2 = newLOTRMaterial("mordor2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial red_dwarven2 = newLOTRMaterial("red_dwarven2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial rhun2 = newLOTRMaterial("rhun2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);
	public static LOTRMaterial khazad2 = newLOTRMaterial("khazad2", 700, 3.0f, 0.73f, 7.0f, 3, 10, null);

	public static LOTRMaterial sibata1 = newLOTRMaterial("sibata1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);
	public static LOTRMaterial khand1 = newLOTRMaterial("khand1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);
	public static LOTRMaterial sindar1 = newLOTRMaterial("sindar1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);
	public static LOTRMaterial noldor1 = newLOTRMaterial("noldor1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);
	public static LOTRMaterial nandor1 = newLOTRMaterial("nandor1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);
	public static LOTRMaterial khazad1 = newLOTRMaterial("khazad1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);
	public static LOTRMaterial eregion1 = newLOTRMaterial("eregion1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);
	public static LOTRMaterial eriador1 = newLOTRMaterial("eriador1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);
	public static LOTRMaterial numenor1 = newLOTRMaterial("numenor1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);
	public static LOTRMaterial karndum1 = newLOTRMaterial("karndum1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);
	public static LOTRMaterial enedwaith1 = newLOTRMaterial("enedwaith1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);
	public static LOTRMaterial rhovanion1 = newLOTRMaterial("rhovanion1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);
	public static LOTRMaterial red_dwarven1 = newLOTRMaterial("red_dwarven1", 700, 3.0f, 0.712f, 7.0f, 3, 10, null);

	public static LOTRMaterial ENEDWAITHDONAT  = newLOTRMaterial("enedwaithdonat", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);
	public static LOTRMaterial RHOVANIONDONAT  = newLOTRMaterial("rhovaniondonat", 2400, 5.0f, 0.75f, 9.0f, 4, 8, null);

	private static boolean setup = false;
	private static Constructor<LOTRMaterial> constructor;
	private static Method setUses;
	private static Method setDamage;
	private static Method setProtection;
	private static Method setSpeed;
	private static Method setHarvestLevel;
	private static Method setEnchantibility;
	private static Method setCraftingMaterial;
	private static Method setUndamageable;
	private static Method setManFlesh;

	private static LOTRMaterial editLOTRMaterial(LOTRMaterial material, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterialTool, Item craftingMaterialArmor, boolean manFlesh, boolean undamageable) {
		BDMaterial.setup();
		try {
			if (uses != -1) {
				setUses.invoke(material, uses);
			}
			if (damage != -1.0f) {
				setDamage.invoke(material, Float.valueOf(damage));
			}
			if (protection != -1.0f) {
				setProtection.invoke(material, Float.valueOf(protection));
			}
			if (speed != -1.0f) {
				setSpeed.invoke(material, Float.valueOf(speed));
			}
			if (harvestLevel != -1) {
				setHarvestLevel.invoke(material, harvestLevel);
			}
			if (enchantability != -1) {
				setEnchantibility.invoke(material, enchantability);
			}
			if (craftingMaterialTool != null && craftingMaterialArmor != null) {
				setCraftingMaterial.invoke(material, craftingMaterialTool, craftingMaterialArmor);
			}
			if (undamageable) {
				setUndamageable.invoke(material);
			}
			if (manFlesh) {
				setManFlesh.invoke(material);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOTRLog.logger.error("Failed to edit LOTRMaterial " + material.toString(), e);
		}
		return material;
	}

	public static ItemArmor.ArmorMaterial getFullArmorMaterial(EntityLivingBase entity) {
		ItemArmor.ArmorMaterial material = null;
		for (int i = 1; i <= 4; ++i) {
			ItemStack item = entity.getEquipmentInSlot(i);
			if (item == null || !(item.getItem() instanceof ItemArmor)) {
				return null;
			}
			ItemArmor.ArmorMaterial itemMaterial = ((ItemArmor) item.getItem()).getArmorMaterial();
			if (material != null && itemMaterial != material) {
				return null;
			}
			material = itemMaterial;
		}
		return material;
	}

    public static void changeLOTRMaterials() {
        editLOTRMaterial(LOTRMaterial.MORDOR, 700, 3.0f, 0.712f, 7.0f, 3, 10, null, null, true, false);
        editLOTRMaterial(LOTRMaterial.NEAR_HARAD, 700, 3.0f, 0.712f, 7.0f, 3, 10, null, null, false, false);
        editLOTRMaterial(LOTRMaterial.ANGMAR, 700, 3.0f, 0.712f, 7.0f, 3, 10, null, null, true, false);
        editLOTRMaterial(LOTRMaterial.GUNDABAD_URUK, 700, 3.0f, 0.712f, 7.0f, 3, 10, null, null, true, false);
        editLOTRMaterial(LOTRMaterial.DUNLENDING, 700, 3.0f, 0.712f, 7.0f, 3, 10, null, null, false, false);
        editLOTRMaterial(LOTRMaterial.RHUN, 700, 3.0f, 0.712f, 7.0f, 3, 10, null, null, false, false);
        editLOTRMaterial(LOTRMaterial.BLUE_DWARVEN, 700, 3.0f, 0.712f, 7.0f, 3, 10, null, null, false, false);
        editLOTRMaterial(LOTRMaterial.GALADHRIM, 700, 3.0f, 0.712f, 7.0f, 3, 10, null, null, false, false);
        editLOTRMaterial(LOTRMaterial.HIGH_ELVEN, 700, 3.0f, 0.712f, 7.0f, 3, 10, null, null, false, false);
        editLOTRMaterial(LOTRMaterial.DALE, 700, 3.0f, 0.712f, 7.0f, 3, 10, null, null, false, false);
        editLOTRMaterial(LOTRMaterial.DWARVEN, 700, 3.0f, 0.712f, 7.0f, 3, 10, null, null, false, false);
        editLOTRMaterial(LOTRMaterial.WOOD_ELVEN, 700, 3.0f, 0.712f, 7.0f, 3, 10, null, null, false, false);

        editLOTRMaterial(LOTRMaterial.RHUN_GOLD, 700, 3.0f, 0.73f, 7.0f, 3, 10, null, null, false, false);
    }

	private static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterial) {
		return BDMaterial.newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, false);
	}

	private static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterial, boolean manFlesh) {
		return BDMaterial.newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, craftingMaterial, manFlesh, false);
	}

	private static LOTRMaterial newLOTRMaterial(String name, int uses, float damage, float protection, float speed, int harvestLevel, int enchantability, Item craftingMaterialTool, Item craftingMaterialArmor, boolean manFlesh, boolean undamageable) {
		BDMaterial.setup();
		LOTRMaterial material = null;
		try {
			material = constructor.newInstance(name);
		} catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException e) {
			LOTRLog.logger.error("Failed to create LOTRMaterial " + name, e);
		}
		return BDMaterial.editLOTRMaterial(material, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterialTool, craftingMaterialArmor, manFlesh, undamageable);
	}

	public static void onInit() {
		BDCommander.setMaterialCraftingItem(khand3, BDRegistry.coin_khand);
		BDCommander.setMaterialCraftingItem(khand2, Items.iron_ingot);
		BDCommander.setMaterialCraftingItem(khand1, Items.iron_ingot);

		BDCommander.setMaterialCraftingItem(eregion3, BDRegistry.coin_eregion);
		BDCommander.setMaterialCraftingItem(eregion2, LOTRMod.elfSteel);
		BDCommander.setMaterialCraftingItem(eregion1, LOTRMod.elfSteel);

		BDCommander.setMaterialCraftingItem(eriador3, BDRegistry.coin_eriador);
		BDCommander.setMaterialCraftingItem(eriador2, LOTRMod.elfSteel);
		BDCommander.setMaterialCraftingItem(eriador1, LOTRMod.elfSteel);

		BDCommander.setMaterialCraftingItem(khazad3, BDRegistry.coin_dwarf);
		BDCommander.setMaterialCraftingItem(khazad2, LOTRMod.dwarfSteel);
		BDCommander.setMaterialCraftingItem(khazad1, LOTRMod.dwarfSteel);
        setExistingCraftingItem(LOTRMaterial.DWARVEN, LOTRMod.dwarfSteel);

		BDCommander.setMaterialCraftingItem(rhovanion3, BDRegistry.coin_rhovanion);
		BDCommander.setMaterialCraftingItem(rhovanion2, Items.iron_ingot);
		BDCommander.setMaterialCraftingItem(rhovanion1, Items.iron_ingot);
        setExistingCraftingItem(LOTRMaterial.DALE, Items.iron_ingot);

		BDCommander.setMaterialCraftingItem(sindar3, BDRegistry.coin_sindar);
		BDCommander.setMaterialCraftingItem(sindar2, LOTRMod.elfSteel);
		BDCommander.setMaterialCraftingItem(sindar1, LOTRMod.elfSteel);
        setExistingCraftingItem(LOTRMaterial.GALADHRIM, LOTRMod.elfSteel);

		BDCommander.setMaterialCraftingItem(enedwaith3, BDRegistry.coin_enedwaith);
		BDCommander.setMaterialCraftingItem(enedwaith2, Items.iron_ingot);
		BDCommander.setMaterialCraftingItem(enedwaith1, Items.iron_ingot);
        setExistingCraftingItem(LOTRMaterial.DUNLENDING, Items.iron_ingot);

		BDCommander.setMaterialCraftingItem(nandor3, BDRegistry.coin_nandor);
		BDCommander.setMaterialCraftingItem(nandor2, LOTRMod.elfSteel);
		BDCommander.setMaterialCraftingItem(nandor1, LOTRMod.elfSteel);
        setExistingCraftingItem(LOTRMaterial.WOOD_ELVEN, LOTRMod.elfSteel);

		BDCommander.setMaterialCraftingItem(noldor3, BDRegistry.coin_noldor);
		BDCommander.setMaterialCraftingItem(noldor2, LOTRMod.elfSteel);
		BDCommander.setMaterialCraftingItem(noldor1, LOTRMod.elfSteel);
        setExistingCraftingItem(LOTRMaterial.HIGH_ELVEN, LOTRMod.elfSteel);

		BDCommander.setMaterialCraftingItem(harad3, BDRegistry.coin_harad);
		BDCommander.setMaterialCraftingItem(harad2, Items.iron_ingot);
        setExistingCraftingItem(LOTRMaterial.NEAR_HARAD, Items.iron_ingot);

		BDCommander.setMaterialCraftingItem(karndum3, BDRegistry.coin_karndum);
		BDCommander.setMaterialCraftingItem(karndum2, LOTRMod.orcSteel);
        setExistingCraftingItem(LOTRMaterial.ANGMAR, LOTRMod.orcSteel);

		BDCommander.setMaterialCraftingItem(red_dwarven3, BDRegistry.coin_red_mountains);
		BDCommander.setMaterialCraftingItem(red_dwarven2, LOTRMod.blueDwarfSteel);
		BDCommander.setMaterialCraftingItem(red_dwarven1, LOTRMod.blueDwarfSteel);
        setExistingCraftingItem(LOTRMaterial.BLUE_DWARVEN, LOTRMod.blueDwarfSteel);

		BDCommander.setMaterialCraftingItem(north3, BDRegistry.coin_north);
		BDCommander.setMaterialCraftingItem(north2, LOTRMod.orcSteel);
        setExistingCraftingItem(LOTRMaterial.GUNDABAD_URUK, LOTRMod.orcSteel);

		BDCommander.setMaterialCraftingItem(mordor3, BDRegistry.coin_mordor);
		BDCommander.setMaterialCraftingItem(mordor2, LOTRMod.orcSteel);
        setExistingCraftingItem(LOTRMaterial.MORDOR, LOTRMod.orcSteel);
        setExistingCraftingItem(LOTRMaterial.BLACK_URUK, LOTRMod.orcSteel);

		BDCommander.setMaterialCraftingItem(numenor3, BDRegistry.coin_numenor);
		BDCommander.setMaterialCraftingItem(numenor2, Items.iron_ingot);
		BDCommander.setMaterialCraftingItem(numenor1, Items.iron_ingot);
        setExistingCraftingItem(LOTRMaterial.GONDOR, Items.iron_ingot);

		BDCommander.setMaterialCraftingItem(rhun3, BDRegistry.coin_rhun);
		BDCommander.setMaterialCraftingItem(rhun2, Items.iron_ingot);
        setExistingCraftingItem(LOTRMaterial.RHUN, Items.iron_ingot);
        setExistingCraftingItem(LOTRMaterial.RHUN_GOLD, Items.iron_ingot);
	}

    private static void setExistingCraftingItem(LOTRMaterial material, Item item) {
        setExistingCraftingItem(material, new ItemStack(item), item);
    }

    private static void setExistingCraftingItem(LOTRMaterial material, ItemStack toolItem, Item armorItem) {
        BDCommander.setToolMaterialRepairItem(material.toToolMaterial(), toolItem);
        material.toArmorMaterial().customCraftingMaterial = armorItem;
    }

	private static void setup() {
		if (setup) {
			return;
		}
		try {
			Class<LOTRMaterial> clazz = LOTRMaterial.class;
			constructor = clazz.getDeclaredConstructor(String.class);
			constructor.setAccessible(true);
			setUses = clazz.getDeclaredMethod("setUses", Integer.TYPE);
			setUses.setAccessible(true);
			setDamage = clazz.getDeclaredMethod("setDamage", Float.TYPE);
			setDamage.setAccessible(true);
			setProtection = clazz.getDeclaredMethod("setProtection", Float.TYPE);
			setProtection.setAccessible(true);
			setSpeed = clazz.getDeclaredMethod("setSpeed", Float.TYPE);
			setSpeed.setAccessible(true);
			setHarvestLevel = clazz.getDeclaredMethod("setHarvestLevel", Integer.TYPE);
			setHarvestLevel.setAccessible(true);
			setEnchantibility = clazz.getDeclaredMethod("setEnchantability", Integer.TYPE);
			setEnchantibility.setAccessible(true);
			setCraftingMaterial = clazz.getDeclaredMethod("setCraftingItems", Item.class, Item.class);
			setCraftingMaterial.setAccessible(true);
			setUndamageable = clazz.getDeclaredMethod("setUndamageable");
			setUndamageable.setAccessible(true);
			setManFlesh = clazz.getDeclaredMethod("setManFlesh");
			setManFlesh.setAccessible(true);
			setup = true;
		} catch (NoSuchMethodException | SecurityException e) {
			LOTRLog.logger.error("Failed to setup LOTRMaterials.", e);
		}
	}
}
