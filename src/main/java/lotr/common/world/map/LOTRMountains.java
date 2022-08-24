package lotr.common.world.map;

public enum LOTRMountains {
	AMON_EREB(LOTRWaypoint.AMON_EREB.getX(), LOTRWaypoint.AMON_EREB.getY(), 2.0f, 120), BELEGOST(LOTRWaypoint.BELEGOST.getX() - 2, LOTRWaypoint.BELEGOST.getY() - 2, 5.0f, 300), NOGROD(LOTRWaypoint.NOGROD.getX(), LOTRWaypoint.NOGROD.getY() + 2, 5.0f, 300), MOUNT_RERIR(LOTRWaypoint.MOUNT_RERIR.getX(), LOTRWaypoint.MOUNT_RERIR.getY(), 3.0f, 200), MOUNT_DOLMED(LOTRWaypoint.MOUNT_DOLMED.getX(), LOTRWaypoint.MOUNT_DOLMED.getY(), 4.0f, 300), BREE(LOTRWaypoint.BREE.getX() + 5, LOTRWaypoint.BREE.getY(), 2.0f, 500), CARN_DUM(LOTRWaypoint.CARN_DUM.getX(), LOTRWaypoint.CARN_DUM.getY() - 1, 2.5f, 150), MOUNT_GRAM(LOTRWaypoint.MOUNT_GRAM.getX(), LOTRWaypoint.MOUNT_GRAM.getY(), 2.5f, 250), MOUNT_GUNDABAD(LOTRWaypoint.MOUNT_GUNDABAD.getX(), LOTRWaypoint.MOUNT_GUNDABAD.getY(), 2.5f, 250), MOUNT_CELEBDIL(LOTRWaypoint.MOUNT_CELEBDIL.getX(), LOTRWaypoint.MOUNT_CELEBDIL.getY(), 2.5f, 250), MOUNT_CARADHRAS(LOTRWaypoint.MOUNT_CARADHRAS.getX(), LOTRWaypoint.MOUNT_CARADHRAS.getY(), 3.0f, 250), MOUNT_FANUIDHOL(LOTRWaypoint.MOUNT_FANUIDHOL.getX(), LOTRWaypoint.MOUNT_FANUIDHOL.getY(), 2.5f, 250), EREBOR(LOTRWaypoint.EREBOR.getX() - 1, LOTRWaypoint.EREBOR.getY() - 4, 5.0f, 300), WEST_PEAK(LOTRWaypoint.WEST_PEAK.getX() - 1, LOTRWaypoint.WEST_PEAK.getY() - 1, 4.0f, 250), EAST_PEAK(LOTRWaypoint.EAST_PEAK.getX() + 1, LOTRWaypoint.EAST_PEAK.getY() - 1, 4.0f, 250), CERIN_AMROTH(LOTRWaypoint.CERIN_AMROTH.getX(), LOTRWaypoint.CERIN_AMROTH.getY(), 1.0f, 80), CARAS_GALADHON(LOTRWaypoint.CARAS_GALADHON.getX(), LOTRWaypoint.CARAS_GALADHON.getY(), 1.5f, 150), MOUNT_DOOM(LOTRWaypoint.MOUNT_DOOM.getX() + 1, LOTRWaypoint.MOUNT_DOOM.getY() + 2, 5.0f, 250, 25);

	private int xCoord;
	private int zCoord;
	private float height;
	private int range;
	private int lavaRange;

	LOTRMountains(double x, double z, float h, int r) {
		this(x, z, h, r, 0);
	}

	LOTRMountains(double x, double z, float h, int r, int l) {
		xCoord = LOTRWaypoint.mapToWorldX(x);
		zCoord = LOTRWaypoint.mapToWorldZ(z);
		height = h;
		range = r;
		lavaRange = l;
	}

	public float getHeightBoost(int x, int z) {
		double dx = x - xCoord;
		double dz = z - zCoord;
		double distSq = dx * dx + dz * dz;
		double rangeSq = range * range;
		if (distSq < rangeSq) {
			if (lavaRange > 0 && distSq < lavaRange * lavaRange) {
				return getLavaCraterHeight();
			}
			double dist = Math.sqrt(distSq);
			float f = (float) (dist / range);
			return (1.0f - f) * height;
		}
		return 0.0f;
	}

	private float getLavaCraterHeight() {
		return (1.0f - (float) lavaRange / (float) range) * height * 0.4f;
	}

	public static int getLavaHeight(int x, int z) {
		for (LOTRMountains m : values()) {
			if (m.lavaRange > 0) {
				double dx = x - m.xCoord;
				double dz = z - m.zCoord;
				double distSq = dx * dx + dz * dz;
				double lavaRangeSq = (m.lavaRange + 6) * (m.lavaRange + 6);
				if (distSq < lavaRangeSq) {
					return Math.round(m.getLavaCraterHeight() * 110.0F);
				}
			}
		}
		return 0;
	}

	public static float getTotalHeightBoost(int x, int z) {
		float f = 0.0f;
		for (LOTRMountains m : LOTRMountains.values()) {
			f += m.getHeightBoost(x, z);
		}
		return f;
	}

	public static boolean mountainAt(int x, int z) {
		return LOTRMountains.getTotalHeightBoost(x, z) > 0.005f;
	}

	public static boolean mountainNear(int x, int z, int range) {
		for (LOTRMountains m : LOTRMountains.values()) {
			double dx = x - m.xCoord;
			double dz = z - m.zCoord;
			double distSq = dx * dx + dz * dz;
			double mtnRange = range + m.range;
			double rangeSq = mtnRange * mtnRange;
			if (distSq > rangeSq) {
				continue;
			}
			return true;
		}
		return false;
	}
}
