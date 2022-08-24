package lotr.client.gui;

import bd.BlackDragon;
import lotr.common.world.biome.LOTRBiome;
import net.minecraft.util.StatCollector;

public enum LOTRMapLabels {
	NEAR_HARAD("nearHarad", 1590, 1685, 8.0f, -2, -4.5f, -0.5f), HARNEDOR(LOTRBiome.harnedor, 1440, 1580, 3.0f, -3, -2.5f, 1.5f), LITHNEN("lithnen", 1615, 1615, 1.5f, -15, -1.5f, 1.5f), UMBAR(LOTRBiome.umbar, 1160, 1685, 4.0f, -15, -3.5f, 1.5f), LOSTLADEN("lostladen", 1685, 1470, 2.0f, -5, -2.5f, 1.5f), SOUTHRON_COASTS(LOTRBiome.nearHaradFertile, 1125, 1790, 3.0f, -20, -2.5f, 0.5f), GULF_HARAD(LOTRBiome.gulfHarad, 1930, 2165, 4.0f, 40, -4.5f, 1.5f), KHAND("khand", 1940, 1420, 4.0f, 5, -3.5f, 0.5f), FAR_HARAD("farHarad", 1350, 2500, 15.0f, 5, -5.5f, -1.5f), FAR_HARAD_HILLS("farHaradHills", 1200, 2050, 3.0f, 25, -2.5f, 0.5f), GREAT_PLAINS("greatPlains", 1370, 2280, 7.5f, 2, -2.5f, -0.5f), FORESTS_SOUTH("forestsSouth", 1300, 3000, 6.0f, 2, -2.5f, -0.5f), HARAD_MOUNTAINS(LOTRBiome.haradMountains, 850, 2280, 5.0f, 80, -2.5f, 0.5f), PERTOROGWAITH(LOTRBiome.pertorogwaith, 1920, 2560, 5.0f, -10, -2.5f, 0.5f), FOREST_TROLLS(LOTRBiome.halfTrollForest, 1740, 2530, 2.0f, 5, -2.0f, 1.5f);

	public final int posX;
	public final int posY;
	public final float scale;
	public final int angle;
	public final float minZoom;
	public final float maxZoom;
	private LOTRBiome biome;
	private String labelName;

	LOTRMapLabels(Object label, int x, int y, float f, int r, float z1, float z2) {
		posX = x + BlackDragon.shift;
		posY = y;
		scale = f;
		angle = r;
		minZoom = z1;
		maxZoom = z2;
		if (label instanceof LOTRBiome) {
			biome = (LOTRBiome) label;
		} else {
			labelName = (String) label;
		}
	}

	public String getDisplayName() {
		if (labelName != null) {
			return StatCollector.translateToLocal("lotr.map." + labelName);
		}
		return biome.getBiomeDisplayName();
	}

	public static LOTRMapLabels[] allMapLabels() {
		return LOTRMapLabels.values();
	}
}
