package bd.block;

import bd.BlackDragon;
import cpw.mods.fml.relauncher.*;
import lotr.common.LOTRLevelData;
import lotr.common.block.LOTRBlockCraftingTable;
import lotr.common.fac.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BDBlockCraftingTable extends LOTRBlockCraftingTable {
	public int tableGUIID;
	@SideOnly(value = Side.CLIENT)
	public IIcon[] tableIcons;

	public BDBlockCraftingTable(Material material, LOTRFaction faction, int guiID) {
		super(material, faction, guiID);
	}

	@SideOnly(value = Side.CLIENT)
	@Override
	public IIcon getIcon(int i, int j) {
		if (i == 1) {
			return tableIcons[1];
		}
		if (i == 0) {
			return Blocks.planks.getIcon(0, 0);
		}
		return tableIcons[0];
	}

	@Override
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int side, float f, float f1, float f2) {
		boolean hasRequiredAlignment;
		hasRequiredAlignment = LOTRLevelData.getData(entityplayer).getAlignment(tableFaction) >= 1.0f;
		if (hasRequiredAlignment) {
			if (!world.isRemote) {
				entityplayer.openGui(BlackDragon.instance, tableGUIID, world, i, j, k);
			}
		} else {
			for (int l = 0; l < 8; ++l) {
				double d = i + world.rand.nextFloat();
				double d1 = j + 1.0;
				double d2 = k + world.rand.nextFloat();
				world.spawnParticle("smoke", d, d1, d2, 0.0, 0.0, 0.0);
			}
			if (!world.isRemote) {
				LOTRAlignmentValues.notifyAlignmentNotHighEnough(entityplayer, 1.0f, tableFaction);
			}
		}
		return true;
	}

	@SideOnly(value = Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconregister) {
		tableIcons = new IIcon[2];
		tableIcons[0] = iconregister.registerIcon(getTextureName() + "_side");
		tableIcons[1] = iconregister.registerIcon(getTextureName() + "_top");
	}
}
