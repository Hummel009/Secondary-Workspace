package lp.proxy;

import cpw.mods.fml.common.event.*;
import lp.util.LPCommander;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.*;
import net.minecraft.util.ResourceLocation;

public class LPClientProxy extends LPServerProxy implements IResourceManagerReloadListener {
	@Override
	public void onInit(FMLInitializationEvent event) {
		((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new LPClientProxy());
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		LPCommander.setClientMapImage(new ResourceLocation("lp:map/map.png"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
	}
}