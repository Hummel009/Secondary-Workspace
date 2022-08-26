package lp.util;

import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import cpw.mods.fml.common.*;
import cpw.mods.fml.relauncher.*;
import lotr.client.LOTRTextures;
import lotr.client.gui.LOTRMapLabels;
import lotr.common.LOTRDimension;
import lotr.common.fac.LOTRFaction;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import lotr.common.world.map.*;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;

public class LPCommander {
	public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z) {
		return addWaypoint(name, region, faction, x, z, false);
	}

	public static LOTRWaypoint addWaypoint(String name, LOTRWaypoint.Region region, LOTRFaction faction, double x, double z, boolean hidden) {
		Class[] classArr = { LOTRWaypoint.Region.class, LOTRFaction.class, Double.TYPE, Double.TYPE, Boolean.TYPE };
		Object[] args = { region, faction, x, z, hidden };
		return EnumHelper.addEnum(LOTRWaypoint.class, name, classArr, args);
	}

    public static LOTRMapLabels addMapLabel(String enumName, LOTRBiome biomeLabel, int x, int y, float scale, int angle, float zoomMin, float zoomMan) {
        return addMapLabel(enumName, (Object)biomeLabel, x, y, scale, angle, zoomMin, zoomMan);
    }

    public static LOTRMapLabels addMapLabel(String enumName, String stringLabel, int x, int y, float scale, int angle, float zoomMin, float zoomMan) {
        return addMapLabel(enumName, (Object)stringLabel, x, y, scale, angle, zoomMin, zoomMan);
    }

    private static LOTRMapLabels addMapLabel(String enumName, Object label, int x, int y, float scale, int angle, float zoomMin, float zoomMan) {
        Class[] classArr = new Class[]{Object.class, Integer.TYPE, Integer.TYPE, Float.TYPE, Integer.TYPE, Float.TYPE, Float.TYPE};
        Object[] args = new Object[]{label, x, y, Float.valueOf(scale), angle, Float.valueOf(zoomMin), Float.valueOf(zoomMan)};
        return (LOTRMapLabels)EnumHelper.addEnum(LOTRMapLabels.class, (String)enumName, (Class[])classArr, (Object[])args);
    }

	public static LOTRWaypoint.Region addWaypointRegion(String name) {
		Class[] classArr = {};
		Object[] args = {};
		return EnumHelper.addEnum(LOTRWaypoint.Region.class, name, classArr, args);
	}

	public static void clearControlZones(LOTRFaction faction) {
		ReflectionHelper.setPrivateValue(LOTRFaction.class, faction, new ArrayList(), "controlZones");
	}

	public static void clearFaction(LOTRFaction faction) {
		faction.allowPlayer = false;
		faction.hasFixedAlignment = true;
		faction.fixedAlignment = 0;
		if (faction.factionDimension != null) {
			faction.factionDimension.factionList.remove(faction);
		}
		if (faction.factionRegion != null) {
			faction.factionRegion.factionList.remove(faction);
		}
		faction.factionDimension = null;
		faction.factionRegion = null;
		clearControlZones(faction);
	}

	public static void clearRoadDataBase() {
		Object dataBase = findAndInvokeConstructor("lotr.common.world.map.LOTRRoads$RoadPointDatabase");
		ReflectionHelper.setPrivateValue(LOTRRoads.class, null, dataBase, "roadPointDatabase");
	}

	public static void disableWaypoint(LOTRWaypoint wp) {
		ReflectionHelper.setPrivateValue(LOTRWaypoint.class, wp, true, "isHidden");
		ReflectionHelper.setPrivateValue(LOTRWaypoint.class, wp, LOTRFaction.HOSTILE, "faction");
	}

	private static <E> E findAndInvokeConstructor(Object[] args, Class<E> clazz, Class<?>... parameterTypes) {
		Constructor<E> constructor = findConstructor(clazz, parameterTypes);
		constructor.setAccessible(true);
		try {
			return constructor.newInstance(args);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | java.lang.reflect.InvocationTargetException e) {
			return null;
		}
	}

	private static <E> E findAndInvokeConstructor(Object[] args, String className, Class<?>... parameterTypes) {
		try {
			return (E) findAndInvokeConstructor(args, Class.forName(className), parameterTypes);
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	private static <E> E findAndInvokeConstructor(String className, Class<?>... parameterTypes) {
		return findAndInvokeConstructor(new Object[0], className, parameterTypes);
	}

	private static <T, E> T findAndInvokeMethod(Object[] arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		return findAndInvokeMethod(arg, clazz, instance, new String[] { methodName }, methodTypes);
	}

	private static <T, E> T findAndInvokeMethod(Object[] args, Class<? super E> clazz, E instance, String[] methodNames, Class<?>... methodTypes) {
		Method addControlZoneMethod = ReflectionHelper.findMethod(clazz, instance, methodNames, methodTypes);
		try {
			return (T) addControlZoneMethod.invoke(instance, args);
		} catch (IllegalAccessException | IllegalArgumentException | java.lang.reflect.InvocationTargetException e) {
			return null;
		}
	}

	private static <E> Constructor<E> findConstructor(Class<E> clazz, Class<?>... parameterTypes) {
		try {
			return clazz.getDeclaredConstructor(parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			return null;
		}
	}

	private static ModContainer getContainer(ResourceLocation res) {
		ModContainer modContainer = Loader.instance().getIndexedModList().get(res.getResourceDomain());
		if (modContainer == null) {
			throw new IllegalArgumentException("Can't find the mod container for the domain " + res.getResourceDomain());
		}
		return modContainer;
	}

	private static BufferedImage getImage(InputStream in) {
		try {
			return ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
			}
		}
		return null;
	}

	private static InputStream getInputStream(ModContainer container, String path) {
		return container.getClass().getResourceAsStream(path);
	}

	private static InputStream getInputStream(ResourceLocation res) {
		return getInputStream(getContainer(res), getPath(res));
	}

	private static String getPath(ResourceLocation res) {
		return "/assets/" + res.getResourceDomain() + "/" + res.getResourcePath();
	}

	public static void registerRoad(String name, Object... waypoints) {
		findAndInvokeMethod(new Object[] { name, waypoints }, LOTRRoads.class, (LOTRRoads) null, "registerRoad", String.class, Object[].class);
	}

	public static void removeMapLabel(LOTRMapLabels label) {
		ReflectionHelper.setPrivateValue(LOTRMapLabels.class, label, 1.0E-4F, "maxZoom");
		ReflectionHelper.setPrivateValue(LOTRMapLabels.class, label, 0, "minZoom");
	}

	@SideOnly(value = Side.CLIENT)
	public static void setClientMapImage(ResourceLocation res) {
		ResourceLocation sepiaMapTexture;
		ReflectionHelper.setPrivateValue(LOTRTextures.class, null, res, "mapTexture");
		try {
			BufferedImage mapImage = getImage(Minecraft.getMinecraft().getResourceManager().getResource(res).getInputStream());
			sepiaMapTexture = findAndInvokeMethod(new Object[] { mapImage, new ResourceLocation("lotr:map_sepia") }, LOTRTextures.class, null, "convertToSepia", BufferedImage.class, ResourceLocation.class);
		} catch (IOException e) {
			FMLLog.severe("Failed to generate GOT sepia map");
			e.printStackTrace();
			sepiaMapTexture = res;
		}
		ReflectionHelper.setPrivateValue(LOTRTextures.class, null, sepiaMapTexture, "sepiaMapTexture");
	}

	public static void setServerMapImage(ResourceLocation res) {
		BufferedImage img = getImage(getInputStream(res));
		LOTRGenLayerWorld.imageWidth = img.getWidth();
		LOTRGenLayerWorld.imageHeight = img.getHeight();
		int[] colors = img.getRGB(0, 0, LOTRGenLayerWorld.imageWidth, LOTRGenLayerWorld.imageHeight, null, 0, LOTRGenLayerWorld.imageWidth);
		byte[] biomeImageData = new byte[LOTRGenLayerWorld.imageWidth * LOTRGenLayerWorld.imageHeight];
		for (int i = 0; i < colors.length; ++i) {
			int color = colors[i];
			Integer biomeID = LOTRDimension.MIDDLE_EARTH.colorsToBiomeIDs.get(color);
			if (biomeID != null) {
				biomeImageData[i] = (byte) biomeID.intValue();
				continue;
			}
		}
		ReflectionHelper.setPrivateValue(LOTRGenLayerWorld.class, null, biomeImageData, "biomeImageData");
	}
}