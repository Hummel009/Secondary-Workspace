package bd.database;

import bd.util.BDCommander;
import lotr.common.LOTRCreativeTabs;
import net.minecraft.item.ItemStack;

public class BDCreativeTabs {
	public static LOTRCreativeTabs tabCombat;
	public static LOTRCreativeTabs tabTools;
	public static LOTRCreativeTabs tabMaterials;
	public static LOTRCreativeTabs tabBlocks;
	public static LOTRCreativeTabs tabAnus;
	public static LOTRCreativeTabs tabFood;

	public static void onInit() {
		tabAnus.theIcon = new ItemStack(BDRegistry.ametamy);
	}

	public static void preInit() {
		tabCombat = BDCommander.getLOTRCreativeTab("tabCombat");
		tabTools = BDCommander.getLOTRCreativeTab("tabTools");
		tabMaterials = BDCommander.getLOTRCreativeTab("tabMaterials");
		tabBlocks = BDCommander.getLOTRCreativeTab("tabBlock");
		tabFood = BDCommander.getLOTRCreativeTab("tabFood");
		tabAnus = new LOTRCreativeTabs("amogus");
	}
}