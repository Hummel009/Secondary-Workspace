package bd.item;

import bd.database.BDCreativeTabs;
import bd.dispence.BDDispenseArrowBlindness;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.Item;

public class BDItemArrowBlindness extends Item {
	public BDItemArrowBlindness() {
		setCreativeTab(BDCreativeTabs.tabCombat);
		BlockDispenser.dispenseBehaviorRegistry.putObject(this, new BDDispenseArrowBlindness());
	}
}
