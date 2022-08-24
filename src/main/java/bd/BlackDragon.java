package bd;

import bd.proxy.BDServerProxy;
import bd.util.BDCommander;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;
import lotr.client.gui.LOTRMapLabels;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.util.ResourceLocation;

@Mod(modid = "bd", version = "Prod. Hummel009", name = "Black Dragon", dependencies = "required-after:lotr")
public class BlackDragon {
	@SidedProxy(serverSide = "bd.proxy.BDServerProxy", clientSide = "bd.proxy.BDClientProxy")
	public static BDServerProxy proxy;
	@Mod.Instance(value = "bd")
	public static BlackDragon instance;

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		BDCommander.setServerMapImage(new ResourceLocation("bd:map/map.png"));
		proxy.onInit(event);
		for (LOTRWaypoint wp: LOTRWaypoint.values()) {
			if (wp.getX() > 2366 || wp.getY() > 2189) {
				BDCommander.disableWaypoint(wp);
			}
		}
		for (LOTRMapLabels lbl: LOTRMapLabels.values()) {
			if (lbl.posX > 2366 || lbl.posY > 2189) {
				BDCommander.removeMapLabel(lbl);
			}
		}
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}
}