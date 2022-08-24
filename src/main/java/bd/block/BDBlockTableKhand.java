package bd.block;

import bd.database.*;
import cpw.mods.fml.relauncher.*;
import lotr.client.gui.LOTRGuiCraftingTable;
import lotr.common.fac.LOTRFaction;
import lotr.common.inventory.LOTRContainerCraftingTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

public class BDBlockTableKhand extends BDBlockCraftingTable {
	public BDBlockTableKhand() {
		super(Material.wood, LOTRFaction.KHAND, 2);
		setStepSound(Block.soundTypeWood);
	}

	public static class Container extends LOTRContainerCraftingTable {
		public Container(InventoryPlayer inv, World world, int i, int j, int k) {
			super(inv, world, i, j, k, BDRecipe.khand, BDRegistry.table_khand);
		}
	}

	@SideOnly(value = Side.CLIENT)
	public static class Gui extends LOTRGuiCraftingTable {
		public Gui(InventoryPlayer inv, World world, int i, int j, int k) {
			super(new Container(inv, world, i, j, k), "khand");
		}
	}
}