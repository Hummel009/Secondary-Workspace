package bd.proxy;

import bd.block.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BDServerProxy implements IGuiHandler {

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer entityplayer, World world, int i, int j, int k) {
		switch (ID) {
		case 2:
			return new BDBlockTableKhand.Gui(entityplayer.inventory, world, i, j, k);
		case 3:
			return new BDBlockTableEregion.Gui(entityplayer.inventory, world, i, j, k);
		default:
			break;
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer entityplayer, World world, int i, int j, int k) {
		switch (ID) {
		case 2:
			return new BDBlockTableKhand.Container(entityplayer.inventory, world, i, j, k);
		case 3:
			return new BDBlockTableEregion.Container(entityplayer.inventory, world, i, j, k);
		default:
			break;
		}
		return null;
	}

	public void onInit(FMLInitializationEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}
}