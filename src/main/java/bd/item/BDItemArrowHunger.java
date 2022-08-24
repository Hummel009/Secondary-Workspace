/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.block.BlockDispenser
 *  net.minecraft.creativetab.CreativeTabs
 *  net.minecraft.item.Item
 *  net.minecraft.util.IRegistry
 */
package bd.item;

import bd.database.BDCreativeTabs;
import bd.dispence.BDDispenseArrowHunger;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.Item;

public class BDItemArrowHunger extends Item {
	public BDItemArrowHunger() {
		setCreativeTab(BDCreativeTabs.tabCombat);
		BlockDispenser.dispenseBehaviorRegistry.putObject(this, new BDDispenseArrowHunger());
	}
}
