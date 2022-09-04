package bd.util;

import bd.item.BDItemStructureSpawner;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.*;

public class BDTickHandlerServer {
	public BDTickHandlerServer() {
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		World world = event.world;
		if (event.phase == TickEvent.Phase.END && world == DimensionManager.getWorld(0) && BDItemStructureSpawner.lastStructureSpawnTick > 0) {
			--BDItemStructureSpawner.lastStructureSpawnTick;
		}
	}

}
