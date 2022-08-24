package lotr.common.world.map;

import java.util.*;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Iterators;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.util.StatCollector;

public class LOTRRoads {
	private static List<LOTRRoads> allRoads = new ArrayList<>();
	private static List<LOTRRoads> displayOnlyRoads = new ArrayList<>();
	private static RoadPointDatabase roadPointDatabase = new RoadPointDatabase();
	public RoadPoint[] roadPoints;
	public List<RoadPoint> endpoints = new ArrayList<>();
	public final String roadName;

	private LOTRRoads(String name, RoadPoint... ends) {
		roadName = name;
		Collections.addAll(endpoints, ends);
	}

	public String getDisplayName() {
		return StatCollector.translateToLocal("lotr.road." + roadName);
	}

	public static void createRoads() {
		FMLLog.info("LOTRRoads: Creating roads (reticulating splines)");
		long time = System.nanoTime();
		allRoads.clear();
		displayOnlyRoads.clear();
		roadPointDatabase = new RoadPointDatabase();
		LOTRRoads.registerRoad("WestEast", LOTRWaypoint.MITHLOND_SOUTH, new int[] { 714, 718 }, new int[] { 788, 715 }, LOTRWaypoint.ARCHET, LOTRWaypoint.BRANDYWINE_BRIDGE, new int[] { 877, 719 }, LOTRWaypoint.BREE, new int[] { 923, 736 }, LOTRWaypoint.FORSAKEN_INN, new int[] { 998, 725 }, LOTRWaypoint.LAST_BRIDGE, new int[] { 1132, 723 }, new int[] { 1178, 704 }, LOTRWaypoint.HIGH_PASS, LOTRWaypoint.OLD_FORD, new int[] { 1474, 696 }, LOTRWaypoint.DALE_CROSSROADS, LOTRWaypoint.REDWATER_FORD, new int[] { 1785, 775 }, new int[] { 1905, 771 }, new int[] { 1953, 808 }, LOTRWaypoint.RHUN_NORTHEAST, LOTRWaypoint.RHUN_ROAD_WAY, LOTRWaypoint.BARAZ_DUM);
		LOTRRoads.registerRoad("GwathloRoad", LOTRWaypoint.LOND_DAER, new int[] { 863, 984 }, new int[] { 876, 966 }, new int[] { 897, 958 }, new int[] { 904, 939 }, new int[] { 919, 928 }, new int[] { 929, 911 }, new int[] { 944, 902 }, new int[] { 955, 890 }, LOTRWaypoint.THARBAD);
		LOTRRoads.registerRoad("ElvenWay", LOTRWaypoint.THARBAD, new int[] { 989, 891 }, LOTRWaypoint.ENEDWAITH_ROAD, new int[] { 1018, 902 }, new int[] { 1038, 908 }, LOTRWaypoint.OLD_ELF_WAY, new int[] { 1066, 887 }, new int[] { 1082, 881 }, new int[] { 1100, 877 }, LOTRWaypoint.OST_IN_EDHIL, new int[] { 1133, 867 }, LOTRWaypoint.WEST_GATE);
		LOTRRoads.registerRoad("EnedwaithRoad", LOTRWaypoint.ENEDWAITH_ROAD, new int[] { 994, 925 }, new int[] { 980, 945 }, new int[] { 992, 968 }, new int[] { 997, 982 }, new int[] { 984, 1000 }, new int[] { 978, 1020 }, new int[] { 998, 1052 }, new int[] { 1024, 1068 }, new int[] { 1035, 1087 }, new int[] { 1076, 1088 }, LOTRWaypoint.FORDS_OF_ISEN);
		LOTRRoads.registerRoad("ErynVornRoad", LOTRWaypoint.THARBAD, new int[] { 962, 871 }, new int[] { 955, 853 }, new int[] { 941, 831 }, LOTRWaypoint.GREENWAY_CROSSROADS);
		LOTRRoads.registerRoad("Greenway", LOTRWaypoint.ANNUMINAS, new int[] { 897, 684 }, new int[] { 916, 713 }, LOTRWaypoint.BREE, new int[] { 918, 759 }, new int[] { 914, 791 }, LOTRWaypoint.GREENWAY_CROSSROADS);
		LOTRRoads.registerRoad("Greenway", LOTRWaypoint.ANNUMINAS, LOTRWaypoint.ERFORD);
		LOTRRoads.registerRoad("NorthSouth", LOTRWaypoint.ARCHET, new int[] { 827, 739 }, new int[] { 831, 762 }, new int[] { 841, 773 }, new int[] { 862, 786 }, LOTRWaypoint.SARN_FORD, LOTRWaypoint.GREENWAY_CROSSROADS);
		LOTRRoads.registerRoad("NumenorRoad", LOTRWaypoint.FORDS_OF_ISEN, new int[] { 1136, 1108 }, new int[] { 1153, 1122 }, new int[] { 1190, 1148 }, new int[] { 1223, 1178 }, new int[] { 1276, 1183 }, LOTRWaypoint.MERING_STREAM, new int[] { 1350, 1196 }, new int[] { 1383, 1192 }, new int[] { 1414, 1206 }, new int[] { 1420, 1223 }, LOTRWaypoint.OSGILIATH_WEST);
		LOTRRoads.registerRoad("OsgiliathCrossing", LOTRWaypoint.OSGILIATH_WEST, LOTRWaypoint.OSGILIATH_EAST);
		LOTRRoads.registerRoad("OsgiliathMorgulRoad", LOTRWaypoint.OSGILIATH_EAST, new int[] { 1444, 1242 }, LOTRWaypoint.CROSSROADS_ITHILIEN);
		LOTRRoads.registerRoad("NimrodelRoad", LOTRWaypoint.CERIN_AMROTH, LOTRWaypoint.CARAS_GALADHON, LOTRWaypoint.ANDUIN_CROSSROADS, LOTRWaypoint.FOREST_GATE, new int[] { 1322, 884 }, LOTRWaypoint.FOREST_TOWN);
		LOTRRoads.registerRoad("DaleSouthRoad", LOTRWaypoint.EASTGATE, new int[] { 1195, 878 }, new int[] { 1253, 884 }, LOTRWaypoint.ANDUIN_CROSSROADS, new int[] { 1319, 932 }, new int[] { 1369, 946 }, LOTRWaypoint.EAST_RHOVANION_ROAD, new int[] { 1455, 923 }, new int[] { 1489, 895 }, new int[] { 1498, 864 }, new int[] { 1485, 843 }, LOTRWaypoint.EAST_BIGHT, new int[] { 1478, 802 }, LOTRWaypoint.OLD_RHOVANION, new int[] { 1529, 774 }, LOTRWaypoint.RUNNING_FORD, new int[] { 1545, 705 }, LOTRWaypoint.DALE_CROSSROADS);
		LOTRRoads.registerRoad("EredLuin", LOTRWaypoint.NOGROD, LOTRWaypoint.BELEGOST);
		LOTRRoads.registerRoad("NogrodMithlond", LOTRWaypoint.NOGROD, new int[] { 654, 650 }, LOTRWaypoint.MITHLOND_NORTH);
		LOTRRoads.registerRoad("Mithlond", LOTRWaypoint.HARLOND, new int[] { 658, 755 }, LOTRWaypoint.MITHLOND_SOUTH, new int[] { 690, 711 }, new int[] { 681, 705 }, LOTRWaypoint.MITHLOND_NORTH, new int[] { 644, 733 }, new int[] { 603, 733 }, new int[] { 554, 715 }, LOTRWaypoint.FORLOND);
		LOTRRoads.registerRoad("SauronRoad", LOTRWaypoint.MOUNT_DOOM, LOTRWaypoint.BARAD_DUR, LOTRWaypoint.SEREGOST, new int[] { 1742, 1209 }, new int[] { 1809, 1172 }, LOTRWaypoint.EASTERN_GUARD, LOTRWaypoint.MORDOR_FORD, LOTRWaypoint.RHUN_SOUTH_PASS, new int[] { 1876, 1019 }, new int[] { 1875, 987 }, new int[] { 1883, 974 }, LOTRWaypoint.RHUN_CAPITAL, LOTRWaypoint.BAZYLAN, new int[] { 2004, 834 }, LOTRWaypoint.RHUN_NORTHEAST);
		LOTRRoads.registerRoad("MorannonRhunRoad", LOTRWaypoint.HARNEN_ROAD_TOWN, LOTRWaypoint.HARNEN_RIVER_TOWN, LOTRWaypoint.HARNEN_SEA_TOWN);
		LOTRRoads.registerRoad("HaradRoad", LOTRWaypoint.MORANNON, LOTRWaypoint.NORTH_ITHILIEN, LOTRWaypoint.CROSSROADS_ITHILIEN, LOTRWaypoint.CROSSINGS_OF_POROS, new int[] { 1429, 1394 }, new int[] { 1408, 1432 }, new int[] { 1428, 1470 }, new int[] { 1435, 1526 }, LOTRWaypoint.CROSSINGS_OF_HARAD, LOTRWaypoint.HARNEN_ROAD_TOWN, LOTRWaypoint.DESERT_TOWN);
		LOTRRoads.registerRoad("UmbarRoad", LOTRWaypoint.HARNEN_SEA_TOWN, new int[] { 1320, 1625 }, new int[] { 1271, 1683 }, new int[] { 1275, 1737 }, LOTRWaypoint.GARDENS_BERUTHIEL);
		LOTRRoads.registerRoad("GulfRoad", LOTRWaypoint.TOWN_BONES, new int[] { 1794, 2110 }, LOTRWaypoint.GULF_FORD, LOTRWaypoint.GULF_TRADE_TOWN, LOTRWaypoint.GULF_CITY, LOTRWaypoint.GULF_NORTH_TOWN, new int[] { 1702, 1940 }, LOTRWaypoint.GULF_OF_HARAD, new int[] { 1775, 2002 }, LOTRWaypoint.GULF_EAST_PORT);
		LOTRRoads.registerRoad("JungleNorthRoad", LOTRWaypoint.JUNGLE_CITY_TRADE, LOTRWaypoint.JUNGLE_CITY_OLD, LOTRWaypoint.JUNGLE_CITY_NORTH);
		LOTRRoads.registerRoad("JungleMangroveRoad", LOTRWaypoint.JUNGLE_CITY_NORTH, LOTRWaypoint.JUNGLE_CITY_EAST, LOTRWaypoint.HARADUIN_MOUTH);
		LOTRRoads.registerRoad("JungleDeepRoad", LOTRWaypoint.JUNGLE_CITY_NORTH, LOTRWaypoint.JUNGLE_CITY_CAPITAL, LOTRWaypoint.JUNGLE_CITY_CAVES, LOTRWaypoint.JUNGLE_CITY_DEEP);
		LOTRRoads.registerRoad("JungleWestEastRoad", LOTRWaypoint.JUNGLE_CITY_OLD, LOTRWaypoint.JUNGLE_CITY_STONE, LOTRWaypoint.JUNGLE_CITY_CAPITAL, LOTRWaypoint.JUNGLE_LAKES, LOTRWaypoint.JUNGLE_CITY_WATCH);
		LOTRRoads.registerRoad("JungleLakeRoad", LOTRWaypoint.JUNGLE_LAKES, LOTRWaypoint.JUNGLE_CITY_EAST, LOTRWaypoint.HARADUIN_BRIDGE, LOTRWaypoint.OLD_JUNGLE_RUIN);

		LOTRRoads.registerRoad("New", LOTRWaypoint.OSTINEDHIL, LOTRWaypoint.OST_IN_EDHIL);
		LOTRRoads.registerRoad("New", LOTRWaypoint.OST_IN_EDHIL, linked(LOTRWaypoint.OST_IN_EDHIL, LOTRWaypoint.OSTRADGERNEDIL, -10, -10), LOTRWaypoint.OSTRADGERNEDIL);
		LOTRRoads.registerRoad("New", LOTRWaypoint.OSTRADGERNEDIL, LOTRWaypoint.ELFLAKE);
		LOTRRoads.registerRoad("New", LOTRWaypoint.KARNULBUL, linked(LOTRWaypoint.KARNULBUL, LOTRWaypoint.FORTDREG, -3, -3), LOTRWaypoint.FORTDREG);
		LOTRRoads.registerRoad("New", LOTRWaypoint.FORTDREG, linked(LOTRWaypoint.FORTDREG, LOTRWaypoint.SHOUTINGFJORD, 0, 10), LOTRWaypoint.SHOUTINGFJORD);

		LOTRRoads.registerRoad("New", LOTRWaypoint.ARMENELOS, LOTRWaypoint.ROMENNA);
		LOTRRoads.registerRoad("New", LOTRWaypoint.ANDUNIE, linked(LOTRWaypoint.ANDUNIE, LOTRWaypoint.ONDOSTO, 0, 15), LOTRWaypoint.ONDOSTO);
		LOTRRoads.registerRoad("New", LOTRWaypoint.ONDOSTO, linked(LOTRWaypoint.ONDOSTO, LOTRWaypoint.ARMENELOS, -20, 40), LOTRWaypoint.ARMENELOS);
		LOTRRoads.registerRoad("New", LOTRWaypoint.GREYHILLS, linked(LOTRWaypoint.GREYHILLS, LOTRWaypoint.BURZALBUL, 5, 0), LOTRWaypoint.BURZALBUL);
		LOTRRoads.registerRoad("New", LOTRWaypoint.REDSUBMOUNT, LOTRWaypoint.KINDZDUM);
		LOTRRoads.registerRoad("New", LOTRWaypoint.DALE_CROSSROADS, LOTRWaypoint.NORBURG, LOTRWaypoint.LAKECITY);
		LOTRRoads.registerRoad("New", LOTRWaypoint.SHOUTINGFJORD, linked(LOTRWaypoint.SHOUTINGFJORD, LOTRWaypoint.DRERGROT, 5, 0), LOTRWaypoint.DRERGROT);
		LOTRRoads.registerRoad("New", LOTRWaypoint.SOLTVALE, LOTRWaypoint.VARIAGPASS, LOTRWaypoint.VARIADKHAND, LOTRWaypoint.KHANDPATH);
		LOTRRoads.registerRoad("New", LOTRWaypoint.BAZYLAN, LOTRWaypoint.RHUN_EAST_CITY, LOTRWaypoint.OROMEPASS, LOTRWaypoint.KHANDPATH);
		LOTRRoads.registerRoad("New", LOTRWaypoint.HARNEN_ROAD_TOWN, LOTRWaypoint.SOLTVALE);

		LOTRRoads.registerRoad("New", LOTRWaypoint.CARN_DUM, new int[] { 1110, 519 }, new int[] { 1121, 529 }, LOTRWaypoint.BURZALBUL);

		LOTRRoads.registerRoad("New", LOTRWaypoint.CARN_DUM, new int[] { 1075, 512 }, new int[] { 1034, 504 }, LOTRWaypoint.NORDDUM);

		LOTRRoads.registerRoad("New", LOTRWaypoint.UDESSA, LOTRWaypoint.HATTUSU);
		LOTRRoads.registerRoad("New", LOTRWaypoint.TARSU, LOTRWaypoint.HATTUSU);
		LOTRRoads.registerRoad("New", LOTRWaypoint.TARSU, LOTRWaypoint.SARDO);
		LOTRRoads.registerRoad("New", LOTRWaypoint.KOMUNNI, LOTRWaypoint.SARDO);
		LOTRRoads.registerRoad("New", LOTRWaypoint.KOMUNNI, LOTRWaypoint.RODDUSU);

		LOTRRoads.registerRoad("New", LOTRWaypoint.CHALKPLACE, LOTRWaypoint.VINEPORT);
		LOTRRoads.registerRoad("New", LOTRWaypoint.VINEPORT, linked(LOTRWaypoint.VINEPORT, LOTRWaypoint.KARANODA, 5, 5), LOTRWaypoint.KARANODA);
		LOTRRoads.registerRoad("New", LOTRWaypoint.KARANODA, linked(LOTRWaypoint.KARANODA, LOTRWaypoint.KARNARAS, -5, 5), LOTRWaypoint.KARNARAS);
		LOTRRoads.registerRoad("New", LOTRWaypoint.ERINLOST, linked(LOTRWaypoint.ERINLOST, LOTRWaypoint.ERINERIM, 0, 5), LOTRWaypoint.ERINERIM);
		LOTRRoads.registerRoad("New", LOTRWaypoint.AMUNKHANAR, LOTRWaypoint.VARIADKHAND);
		LOTRRoads.registerRoad("New", LOTRWaypoint.KARNULBUL, linked(LOTRWaypoint.KARNULBUL, LOTRWaypoint.GREYHILLS, 0, 5), LOTRWaypoint.GREYHILLS);

		long newTime = System.nanoTime();
		int roads = allRoads.size();
		int points = 0;
		int dbEntries = 0;
		int dbPoints = 0;
		for (LOTRRoads road : allRoads) {
			points += road.roadPoints.length;
		}
		for (Map.Entry e : roadPointDatabase.pointMap.entrySet()) {
			++dbEntries;
			dbPoints += ((List) e.getValue()).size();
		}
		FMLLog.info("LOTRRoads: Created roads in " + (newTime - time) / 1.0E9 + "s");
		FMLLog.info("LOTRRoads: roads=" + roads + ", points=" + points + ", dbEntries=" + dbEntries + ", dbPoints=" + dbPoints);
	}

	public static Iterator<LOTRRoads> getAllRoadsForDisplay() {
		return Iterators.concat(allRoads.iterator(), displayOnlyRoads.iterator());
	}

	public static List<LOTRRoads> getAllRoadsInWorld() {
		return allRoads;
	}

	public static boolean isRoadAt(int x, int z) {
		return LOTRRoads.isRoadNear(x, z, 4) >= 0.0f;
	}

	public static float isRoadNear(int x, int z, int width) {
		double widthSq = width * width;
		float leastSqRatio = -1.0f;
		List<RoadPoint> points = roadPointDatabase.getPointsForCoords(x, z);
		for (RoadPoint point : points) {
			double dx = point.x - x;
			double dz = point.z - z;
			double distSq = dx * dx + dz * dz;
			if (distSq >= widthSq) {
				continue;
			}
			float f = (float) (distSq / widthSq);
			if (leastSqRatio == -1.0f) {
				leastSqRatio = f;
				continue;
			}
			if (f >= leastSqRatio) {
				continue;
			}
			leastSqRatio = f;
		}
		return leastSqRatio;
	}

	public static int[] linked(LOTRWaypoint wp1, LOTRWaypoint wp2, int shiftX, int shiftY) {
		return new int[] { (int) ((wp1.getX() + wp2.getX()) / 2) + shiftX, (int) ((wp1.getY() + wp2.getY()) / 2) + shiftY };
	}

	private static void registerRoad(String name, Object... waypoints) {
		LOTRRoads.registerRoadToList(allRoads, name, waypoints);
	}

	private static void registerRoadToList(List<LOTRRoads> targetList, String name, Object... waypoints) {
		ArrayList<RoadPoint> points = new ArrayList<>();
		for (Object obj : waypoints) {
			if (obj instanceof LOTRWaypoint) {
				LOTRWaypoint wp = (LOTRWaypoint) obj;
				points.add(new RoadPoint(wp.getXCoord(), wp.getZCoord(), true));
				continue;
			}
			if (obj instanceof int[]) {
				int[] coords = (int[]) obj;
				if (coords.length == 2) {
					points.add(new RoadPoint(LOTRWaypoint.mapToWorldX(coords[0]), LOTRWaypoint.mapToWorldZ(coords[1]), false));
					continue;
				}
				throw new IllegalArgumentException("Coords length must be 2!");
			}
			if (obj instanceof double[]) {
				double[] coords = (double[]) obj;
				if (coords.length == 2) {
					points.add(new RoadPoint(LOTRWaypoint.mapToWorldX(coords[0]), LOTRWaypoint.mapToWorldZ(coords[1]), false));
					continue;
				}
				throw new IllegalArgumentException("Coords length must be 2!");
			}
			throw new IllegalArgumentException("Wrong road parameter!");
		}
		RoadPoint[] array = points.toArray(new RoadPoint[0]);
		LOTRRoads[] roads = BezierCurves.getSplines(name, array);
		targetList.addAll(Arrays.asList(roads));
	}

	private static class BezierCurves {
		private static int roadLengthFactor = 1;

		private BezierCurves() {
		}

		private static RoadPoint bezier(RoadPoint a, RoadPoint b, RoadPoint c, RoadPoint d, double t) {
			RoadPoint ab = BezierCurves.lerp(a, b, t);
			RoadPoint bc = BezierCurves.lerp(b, c, t);
			RoadPoint cd = BezierCurves.lerp(c, d, t);
			RoadPoint abbc = BezierCurves.lerp(ab, bc, t);
			RoadPoint bccd = BezierCurves.lerp(bc, cd, t);
			return BezierCurves.lerp(abbc, bccd, t);
		}

		private static double[][] getControlPoints(double[] src) {
			int i;
			int length = src.length - 1;
			double[] p1 = new double[length];
			double[] p2 = new double[length];
			double[] a = new double[length];
			double[] b = new double[length];
			double[] c = new double[length];
			double[] r = new double[length];
			a[0] = 0.0;
			b[0] = 2.0;
			c[0] = 1.0;
			r[0] = src[0] + 2.0 * src[1];
			for (i = 1; i < length - 1; ++i) {
				a[i] = 1.0;
				b[i] = 4.0;
				c[i] = 1.0;
				r[i] = 4.0 * src[i] + 2.0 * src[i + 1];
			}
			a[length - 1] = 2.0;
			b[length - 1] = 7.0;
			c[length - 1] = 0.0;
			r[length - 1] = 8.0 * src[length - 1] + src[length];
			for (i = 1; i < length; ++i) {
				double m = a[i] / b[i - 1];
				b[i] = b[i] - m * c[i - 1];
				r[i] = r[i] - m * r[i - 1];
			}
			p1[length - 1] = r[length - 1] / b[length - 1];
			for (i = length - 2; i >= 0; --i) {
				p1[i] = (r[i] - c[i] * p1[i + 1]) / b[i];
			}
			for (i = 0; i < length - 1; ++i) {
				p2[i] = 2.0 * src[i + 1] - p1[i + 1];
			}
			p2[length - 1] = 0.5 * (src[length] + p1[length - 1]);
			return new double[][] { p1, p2 };
		}

		private static LOTRRoads[] getSplines(String name, RoadPoint[] waypoints) {
			if (waypoints.length == 2) {
				RoadPoint p1 = waypoints[0];
				RoadPoint p2 = waypoints[1];
				LOTRRoads road = new LOTRRoads(name, p1, p2);
				double dx = p2.x - p1.x;
				double dz = p2.z - p1.z;
				int roadLength = (int) Math.round(Math.sqrt(dx * dx + dz * dz));
				int points = roadLength * roadLengthFactor;
				road.roadPoints = new RoadPoint[points];
				for (int l = 0; l < points; ++l) {
					RoadPoint point;
					double t = (double) l / (double) points;
					road.roadPoints[l] = point = new RoadPoint(p1.x + dx * t, p1.z + dz * t, false);
					roadPointDatabase.add(point);
				}
				return new LOTRRoads[] { road };
			}
			int length = waypoints.length;
			double[] x = new double[length];
			double[] z = new double[length];
			for (int i = 0; i < length; ++i) {
				x[i] = waypoints[i].x;
				z[i] = waypoints[i].z;
			}
			double[][] controlX = BezierCurves.getControlPoints(x);
			double[][] controlZ = BezierCurves.getControlPoints(z);
			int controlPoints = controlX[0].length;
			RoadPoint[] controlPoints1 = new RoadPoint[controlPoints];
			RoadPoint[] controlPoints2 = new RoadPoint[controlPoints];
			for (int i = 0; i < controlPoints; ++i) {
				RoadPoint p1 = new RoadPoint(controlX[0][i], controlZ[0][i], false);
				RoadPoint p2 = new RoadPoint(controlX[1][i], controlZ[1][i], false);
				controlPoints1[i] = p1;
				controlPoints2[i] = p2;
			}
			LOTRRoads[] roads = new LOTRRoads[length - 1];
			for (int i = 0; i < roads.length; ++i) {
				LOTRRoads road;
				RoadPoint p1 = waypoints[i];
				RoadPoint p2 = waypoints[i + 1];
				RoadPoint cp1 = controlPoints1[i];
				RoadPoint cp2 = controlPoints2[i];
				roads[i] = road = new LOTRRoads(name, p1, p2);
				double dx = p2.x - p1.x;
				double dz = p2.z - p1.z;
				int roadLength = (int) Math.round(Math.sqrt(dx * dx + dz * dz));
				int points = roadLength * roadLengthFactor;
				road.roadPoints = new RoadPoint[points];
				for (int l = 0; l < points; ++l) {
					RoadPoint point;
					double t = (double) l / (double) points;
					road.roadPoints[l] = point = BezierCurves.bezier(p1, cp1, cp2, p2, t);
					roadPointDatabase.add(point);
				}
			}
			return roads;
		}

		private static RoadPoint lerp(RoadPoint a, RoadPoint b, double t) {
			double x = a.x + (b.x - a.x) * t;
			double z = a.z + (b.z - a.z) * t;
			return new RoadPoint(x, z, false);
		}
	}

	public static class RoadPoint {
		public final double x;
		public final double z;
		public final boolean isWaypoint;

		public RoadPoint(double i, double j, boolean flag) {
			x = i;
			z = j;
			isWaypoint = flag;
		}
	}

	private static class RoadPointDatabase {
		private Map<Pair<Integer, Integer>, List<RoadPoint>> pointMap = new HashMap<>();

		private RoadPointDatabase() {
		}

		public void add(RoadPoint point) {
			int x = (int) Math.round(point.x / 1000.0);
			int z = (int) Math.round(point.z / 1000.0);
			int overlap = 1;
			for (int i = -overlap; i <= overlap; ++i) {
				for (int k = -overlap; k <= overlap; ++k) {
					int xKey = x + i;
					int zKey = z + k;
					getRoadList(xKey, zKey, true).add(point);
				}
			}
		}

		public List<RoadPoint> getPointsForCoords(int x, int z) {
			int x1 = x / 1000;
			int z1 = z / 1000;
			return getRoadList(x1, z1, false);
		}

		private List<RoadPoint> getRoadList(int xKey, int zKey, boolean addToMap) {
			Pair key = Pair.of((Object) xKey, (Object) zKey);
			List<RoadPoint> list = pointMap.get(key);
			if (list == null) {
				list = new ArrayList<>();
				if (addToMap) {
					pointMap.put(key, list);
				}
			}
			return list;
		}
	}
}
