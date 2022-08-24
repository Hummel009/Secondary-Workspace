package lotr.common.item;

import bd.database.BDCreativeTabs;
import lotr.common.dispenser.LOTRDispenseCrossbowBolt;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.Item;

public class LOTRItemCrossbowBolt extends Item {
	public boolean isPoisoned = false;
	public boolean isBlindness = false;
	public boolean isFire = false;
	public boolean isSlowness = false;
	public boolean isHunger = false;

	public LOTRItemCrossbowBolt() {
		setCreativeTab(BDCreativeTabs.tabCombat);
		BlockDispenser.dispenseBehaviorRegistry.putObject(this, new LOTRDispenseCrossbowBolt(this));
	}

	public LOTRItemCrossbowBolt setBlindness() {
		isBlindness = true;
		return this;
	}

	public LOTRItemCrossbowBolt setFire() {
		isFire = true;
		return this;
	}

	public LOTRItemCrossbowBolt setHunger() {
		isHunger = true;
		return this;
	}

	public LOTRItemCrossbowBolt setPoisoned() {
		isPoisoned = true;
		return this;
	}

	public LOTRItemCrossbowBolt setSlowness() {
		isSlowness = true;
		return this;
	}
}
