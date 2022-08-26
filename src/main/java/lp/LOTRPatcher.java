package lp;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;
import lotr.common.fac.LOTRFaction;
import lp.biome.LPBiome;
import lp.map.*;
import lp.proxy.LPServerProxy;
import lp.util.LPCommander;
import net.minecraft.util.ResourceLocation;

@Mod(modid = "lp", version = "Prod. Hummel009", name = "LOTR Patch", dependencies = "required-after:lotr")
public class LOTRPatcher {
	@SidedProxy(serverSide = "lp.proxy.LPServerProxy", clientSide = "lp.proxy.LPClientProxy")
	public static LPServerProxy proxy;
	@Mod.Instance(value = "lp")
	public static LOTRPatcher instance;

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		LPCommander.setServerMapImage(new ResourceLocation("lp:map/map.png"));
		proxy.onInit(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LPCommander.clearFaction(LOTRFaction.TAURETHRIM);
		LPCommander.clearFaction(LOTRFaction.MORWAITH);
		LPCommander.clearFaction(LOTRFaction.HALF_TROLL);
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LPWaypoint.Region.preInit();
		LPWaypoint.preInit();
		LPRoads.preInit();
		LPBiome.preInit();
		LPMapLabels.preInit();
		proxy.preInit(event);
	}
}