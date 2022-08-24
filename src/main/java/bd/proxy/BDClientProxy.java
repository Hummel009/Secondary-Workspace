package bd.proxy;

import bd.util.BDCommander;
import cpw.mods.fml.common.event.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.*;
import net.minecraft.util.ResourceLocation;

public class BDClientProxy extends BDServerProxy implements IResourceManagerReloadListener {
	@Override
	public void onInit(FMLInitializationEvent event) {
		((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new BDClientProxy());
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		BDCommander.setClientMapImage(new ResourceLocation("bd:map/map.png"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
	}
}