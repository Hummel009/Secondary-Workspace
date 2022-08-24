package lotr.common.fac;

import bd.BlackDragon;

public class LOTRMapRegion {
	public final int mapX;
	public final int mapY;
	public final int radius;

	public LOTRMapRegion(int x, int y, int r) {
		mapX = x + BlackDragon.shift;
		mapY = y;
		radius = r;
	}
}
