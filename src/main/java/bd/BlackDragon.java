package bd;

import bd.command.BDCommandSwitchLocation;
import bd.database.*;
import bd.entity.BDEntity;
import bd.proxy.BDServerProxy;
import bd.util.*;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import lotr.common.world.map.LOTRWaypoint;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@Mod(modid = "bd", version = "Prod. Hummel009", name = "Black Dragon", dependencies = "required-after:lotr")
public class BlackDragon {
	@SidedProxy(serverSide = "bd.proxy.BDServerProxy", clientSide = "bd.proxy.BDClientProxy")
	public static BDServerProxy proxy;
	@Mod.Instance(value = "bd")
	public static BlackDragon instance;
	public static BDEventHandler event_handler;
	public static int shift = 1000;

	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		BDCreativeTabs.onInit();
		BDMaterial.onInit();
		BDInvasions.onInit();
		BDSpeech.onInit();
		BDCommander.setServerMapImage(new ResourceLocation("bd:map/map.png"));
		BDWeaponStats.setupAndOverrideStats();
		proxy.onInit(event);
		BDCommander.disableWaypoint(LOTRWaypoint.FERTILE_VALLEY);
		BDCommander.addBrewingRecipe(new ItemStack(BDRegistry.mug_maple, 16), BDRegistry.maple_leaf, BDRegistry.maple_leaf, BDRegistry.maple_leaf, BDRegistry.maple_leaf, BDRegistry.maple_leaf, BDRegistry.maple_leaf);
	}

	@Mod.EventHandler
	public void onServerStarting(FMLServerStartingEvent event) {
		event.registerServerCommand(new BDCommandSwitchLocation());
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		BDCreativeTabs.preInit();
		BDRegistry.preInit();
		BDEntity.preInit();
		BDRecipe.preInit();
		event_handler = new BDEventHandler();
		proxy.preInit(event);
	}

    static {
        BDMaterial.changeLOTRMaterials();
    }
}