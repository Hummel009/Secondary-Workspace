package lotr.common.world.map;

import java.util.*;

import bd.BlackDragon;
import lotr.common.*;
import lotr.common.fac.LOTRFaction;
import lotr.common.world.genlayer.LOTRGenLayerWorld;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public enum LOTRWaypoint implements LOTRAbstractWaypoint {
	BALCARAS(Region.RHUN, LOTRFaction.UNALIGNED, 2231.0, 1058.0), HIMLING(Region.OCEAN, LOTRFaction.UNALIGNED, 485.0, 523.0), TOL_FUIN(Region.OCEAN, LOTRFaction.UNALIGNED, 357.0, 542.0), TOL_MORWEN(Region.OCEAN, LOTRFaction.UNALIGNED, 87.0, 698.0), FORLOND(Region.LINDON, LOTRFaction.HIGH_ELF, 526.0, 718.0), HARLOND(Region.LINDON, LOTRFaction.HIGH_ELF, 605.0, 783.0), MITHLOND_NORTH(Region.LINDON, LOTRFaction.HIGH_ELF, 669.0, 717.0), MITHLOND_SOUTH(Region.LINDON, LOTRFaction.HIGH_ELF, 679.0, 729.0), TOWER_HILLS(Region.LINDON, LOTRFaction.HIGH_ELF, 710.0, 742.0), AMON_EREB(Region.LINDON, LOTRFaction.HIGH_ELF, 500.0, 708.0), BELEGOST(Region.BLUE_MOUNTAINS, LOTRFaction.UNALIGNED, 622.0, 600.0), NOGROD(Region.BLUE_MOUNTAINS, LOTRFaction.UNALIGNED, 626.0, 636.0), MOUNT_RERIR(Region.BLUE_MOUNTAINS, LOTRFaction.UNALIGNED, 592.0, 525.0), MOUNT_DOLMED(Region.BLUE_MOUNTAINS, LOTRFaction.UNALIGNED, 599.0, 627.0), ARCHET(Region.ERIADOR, LOTRFaction.UNALIGNED, 810.0, 726.0), BRANDYWINE_BRIDGE(Region.ERIADOR, LOTRFaction.UNALIGNED, 853.0, 725.0), SARN_FORD(Region.ERIADOR, LOTRFaction.UNALIGNED, 878.0, 805.0), FORSAKEN_INN(Region.ERIADOR, LOTRFaction.UNALIGNED, 950.0, 743.0), ANNUMINAS(Region.ERIADOR, LOTRFaction.UNALIGNED, 893.0, 666.0), FORNOST(Region.ERIADOR, LOTRFaction.UNALIGNED, 828.0, 641.0), BREE(Region.BREE_LAND, LOTRFaction.UNALIGNED, 909.0, 732.0), STADDLE(Region.BREE_LAND, LOTRFaction.UNALIGNED, 923.0, 736.0), GREENWAY_CROSSROADS(Region.SHIRE, LOTRFaction.UNALIGNED, 920.0, 814.0), LOND_DAER(Region.SHIRE, LOTRFaction.UNALIGNED, 855.0, 1004.0), THARBAD(Region.SHIRE, LOTRFaction.UNALIGNED, 971.0, 883.0), ENEDWAITH_ROAD(Region.ENEDWAITH, LOTRFaction.UNALIGNED, 998.0, 905.0), WULFBURG(Region.DUNLAND, LOTRFaction.UNALIGNED, 1032.0, 948.0), FRECA_HOLD(Region.DUNLAND, LOTRFaction.UNALIGNED, 1046.0, 1007.0), OLD_ELF_WAY(Region.EREGION, LOTRFaction.UNALIGNED, 1057.0, 897.0), OST_IN_EDHIL(Region.EREGION, LOTRFaction.UNALIGNED, 1112.0, 870.0), LAST_BRIDGE(Region.LONE_LANDS, LOTRFaction.UNALIGNED, 1088.0, 714.0), EREBOR(Region.DALE, LOTRFaction.DURINS_FOLK, 1463.0, 609.0), MOUNT_CARADHRAS(Region.MISTY_MOUNTAINS, LOTRFaction.UNALIGNED, 1166.0, 845.0), MOUNT_CELEBDIL(Region.MISTY_MOUNTAINS, LOTRFaction.UNALIGNED, 1158.0, 864.0), MOUNT_FANUIDHOL(Region.MISTY_MOUNTAINS, LOTRFaction.UNALIGNED, 1191.0, 854.0), CARN_DUM(Region.ANGMAR, LOTRFaction.UNALIGNED, 1101, 509), NORDDUM(Region.ANGMAR, LOTRFaction.UNALIGNED, 1006.0, 512.0), WEST_GATE(Region.EREGION, LOTRFaction.UNALIGNED, 1134.0, 873.0), DIMRILL_DALE(Region.ERIADOR, LOTRFaction.UNALIGNED, 1177, 854), FORDS_OF_ISEN(Region.DUNLAND, LOTRFaction.UNALIGNED, 1102.0, 1087.0), MOUTHS_ISEN(Region.ENEDWAITH, LOTRFaction.UNALIGNED, 871.0, 1127.0), CAPE_OF_FOROCHEL(Region.FORODWAITH, LOTRFaction.UNALIGNED, 786.0, 390.0), SOUTH_FOROCHEL(Region.FORODWAITH, LOTRFaction.UNALIGNED, 825.0, 459.0), WITHERED_HEATH(Region.FORODWAITH, LOTRFaction.UNALIGNED, 1441.0, 556.0), MOUNT_GUNDABAD(Region.MISTY_MOUNTAINS, LOTRFaction.UNALIGNED, 1195.0, 592.0), MOUNT_GRAM(Region.MISTY_MOUNTAINS, LOTRFaction.UNALIGNED, 1106.0, 589.0), HIGH_PASS(Region.MISTY_MOUNTAINS, LOTRFaction.UNALIGNED, 1222.0, 706.0), GOBLIN_TOWN(Region.MISTY_MOUNTAINS, LOTRFaction.UNALIGNED, 1220.0, 696.0), OLD_FORD(Region.VALES_OF_ANDUIN, LOTRFaction.UNALIGNED, 1284.0, 702.0), FOREST_GATE(Region.WOODLAND_REALM, LOTRFaction.UNALIGNED, 1307.0, 894.0), FOREST_TOWN(Region.WOODLAND_REALM, LOTRFaction.UNALIGNED, 1339.0, 884.0), ANDUIN_CROSSROADS(Region.VALES_OF_ANDUIN, LOTRFaction.UNALIGNED, 1285.0, 905.0), AMON_LANK(Region.WOODLAND_REALM, LOTRFaction.WOOD_ELF, 1356.0, 893.0), EAST_RHOVANION_ROAD(Region.VALES_OF_ANDUIN, LOTRFaction.UNALIGNED, 1403.0, 943.0), EAST_BIGHT(Region.DALE, LOTRFaction.UNALIGNED, 1466.0, 827.0), OLD_RHOVANION(Region.DALE, LOTRFaction.UNALIGNED, 1511.0, 791.0), RUNNING_FORD(Region.DALE, LOTRFaction.UNALIGNED, 1534.0, 749.0), REDWATER_FORD(Region.DALE, LOTRFaction.UNALIGNED, 1651.0, 690.0), DALE_CROSSROADS(Region.DALE, LOTRFaction.UNALIGNED, 1567.0, 680.0), WEST_PEAK(Region.IRON_HILLS, LOTRFaction.UNALIGNED, 1588.0, 608.0), EAST_PEAK(Region.IRON_HILLS, LOTRFaction.UNALIGNED, 1729.0, 610.0), CARAS_GALADHON(Region.LOTHLORIEN, LOTRFaction.LOTHLORIEN, 1242.0, 902.0), CERIN_AMROTH(Region.LOTHLORIEN, LOTRFaction.LOTHLORIEN, 1230.0, 897.0), MERING_STREAM(Region.ROHAN, LOTRFaction.UNALIGNED, 1322.0, 1183.0), DUNHARROW(Region.WHITE_MOUNTAINS, LOTRFaction.UNALIGNED, 1175.0, 1154.0), RAS_MORTHIL(Region.WHITE_MOUNTAINS, LOTRFaction.UNALIGNED, 845.0, 1332.0), MINDOLLUIN(Region.WHITE_MOUNTAINS, LOTRFaction.UNALIGNED, 1416.0, 1247.0), OSGILIATH_WEST(Region.GONDOR, LOTRFaction.UNALIGNED, 1428.0, 1246.0), OSGILIATH_EAST(Region.ITHILIEN, LOTRFaction.UNALIGNED, 1435.0, 1246.0), CROSSROADS_ITHILIEN(Region.ITHILIEN, LOTRFaction.UNALIGNED, 1450.0, 1236.0), NORTH_ITHILIEN(Region.ITHILIEN, LOTRFaction.UNALIGNED, 1447.0, 1151.0), CROSSINGS_OF_POROS(Region.ITHILIEN, LOTRFaction.UNALIGNED, 1442.0, 1370.0), EDHELLOND(Region.DOR_EN_ERNIL, LOTRFaction.UNALIGNED, 1189.0, 1293.0), TOLFALAS_ISLAND(Region.TOLFALAS, LOTRFaction.UNALIGNED, 1240.0, 1414.0), MORANNON(Region.ITHILIEN, LOTRFaction.UNALIGNED, 1470.0, 1131.0), MOUNT_DOOM(Region.MORDOR, LOTRFaction.MORDOR, 1533.0, 1204.0), BARAD_DUR(Region.MORDOR, LOTRFaction.MORDOR, 1573.0, 1196.0), MINAS_MORGUL(Region.MORDOR, LOTRFaction.MORDOR, 1461.0, 1239.0), MORIGOST(Region.MORDOR, LOTRFaction.MORDOR, 1558.0, 1286.0), NARGROTH(Region.MORDOR, LOTRFaction.MORDOR, 1640.0, 1248.0), AMON_ANGREN(Region.MORDOR, LOTRFaction.MORDOR, 1663.0, 1245.0), SEREGOST(Region.MORDOR, LOTRFaction.MORDOR, 1682.0, 1214.0), EASTERN_GUARD(Region.MORDOR, LOTRFaction.MORDOR, 1840.0, 1137.0), THAURBAND(Region.NURN, LOTRFaction.MORDOR, 1643.0, 1354.0), RHUN_ROAD_WAY(Region.RHUN, LOTRFaction.UNALIGNED, 2228.0, 835.0), RHUN_CAPITAL(Region.RHUN_KHAGANATE, LOTRFaction.RHUDEL, 1898.0, 926.0), MORDOR_FORD(Region.RHUN_KHAGANATE, LOTRFaction.RHUDEL, 1834.0, 1112.0), BAZYLAN(Region.RHUN_KHAGANATE, LOTRFaction.RHUDEL, 1941.0, 912.0), RHUN_NORTHEAST(Region.RHUN_KHAGANATE, LOTRFaction.UNALIGNED, 2045.0, 815.0), RHUN_SOUTH_PASS(Region.RHUN_KHAGANATE, LOTRFaction.RHUDEL, 1869.0, 1055.0), RHUN_EAST_CITY(Region.RHUN_KHAGANATE, LOTRFaction.RHUDEL, 2010.0, 962.0), BARAZ_DUM(Region.RED_MOUNTAINS, LOTRFaction.UNALIGNED, 2326.0, 800.0), CROSSINGS_OF_HARAD(Region.HARONDOR, LOTRFaction.UNALIGNED, 1503.0, 1544.0), HARNEN_SEA_TOWN(Region.HARNEDOR, LOTRFaction.NEAR_HARAD, 1343.0, 1561.0), HARNEN_ROAD_TOWN(Region.HARNEDOR, LOTRFaction.NEAR_HARAD, 1518.0, 1563.0), HARNEN_RIVER_TOWN(Region.HARNEDOR, LOTRFaction.NEAR_HARAD, 1447.0, 1558.0), UMBAR_CITY(Region.UMBAR, LOTRFaction.NEAR_HARAD, 1176.0, 1681.0), CEDAR_ROAD(Region.SOUTHRON_COASTS, LOTRFaction.UNALIGNED, 1034.0, 1848.0), FERTILE_VALLEY(Region.SOUTHRON_COASTS, LOTRFaction.NEAR_HARAD, 1169.0, 1821.0), GARDENS_BERUTHIEL(Region.SOUTHRON_COASTS, LOTRFaction.NEAR_HARAD, 1245.0, 1781.0), COAST_RIVER_TOWN(Region.SOUTHRON_COASTS, LOTRFaction.UNALIGNED, 1080.0, 1837.0), COAST_CITY(Region.SOUTHRON_COASTS, LOTRFaction.NEAR_HARAD, 1165.0, 1742.0), DESERT_TOWN(Region.HARAD_DESERT, LOTRFaction.UNALIGNED, 1563.0, 1611.0), SOUTH_DESERT_TOWN(Region.HARAD_DESERT, LOTRFaction.UNALIGNED, 1141.0, 1976.0), DESERT_RIVER_TOWN(Region.HARAD_DESERT, LOTRFaction.UNALIGNED, 1191.0, 1984.0), GULF_OF_HARAD(Region.GULF_HARAD, LOTRFaction.NEAR_HARAD, 1724.0, 1982.0), GULF_CITY(Region.GULF_HARAD, LOTRFaction.NEAR_HARAD, 1640.0, 1922.0), GULF_FORD(Region.GULF_HARAD, LOTRFaction.UNALIGNED, 1686.0, 2032.0), GULF_TRADE_TOWN(Region.GULF_HARAD, LOTRFaction.UNALIGNED, 1692.0, 2001.0), GULF_NORTH_TOWN(Region.GULF_HARAD, LOTRFaction.NEAR_HARAD, 1626.0, 1874.0), GULF_EAST_BAY(Region.GULF_HARAD, LOTRFaction.UNALIGNED, 2036.0, 2081.0), GULF_EAST_PORT(Region.GULF_HARAD, LOTRFaction.UNALIGNED, 1847.0, 2049.0), MOUNT_SAND(Region.HARAD_MOUNTAINS, LOTRFaction.UNALIGNED, 959.0, 1899.0), MOUNT_GREEN(Region.HARAD_MOUNTAINS, LOTRFaction.UNALIGNED, 884.0, 2372.0), MOUNT_THUNDER(Region.HARAD_MOUNTAINS, LOTRFaction.UNALIGNED, 1019.0, 2590.0), GREAT_PLAINS_NORTH(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 1308.0, 2067.0), GREAT_PLAINS_SOUTH(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 1462.0, 2452.0), GREAT_PLAINS_WEST(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 1048.0, 2215.0), GREAT_PLAINS_EAST(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 1637.0, 2176.0), GREEN_VALLEY(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 1557.0, 2622.0), HARAD_LAKES(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 1774.0, 2310.0), LAKE_HARAD(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 1100.0, 2592.0), HARADUIN_MOUTH(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 1846.0, 2838.0), ISLE_MIST(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 1533.0, 3573.0), TAURELONDE(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 901.0, 2613.0), HARAD_HORN(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 1105.0, 3778.0), TOWN_BONES(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 1832.0, 2188.0), HARADUIN_BRIDGE(Region.FAR_HARAD, LOTRFaction.UNALIGNED, 1621.0, 2673.0), JUNGLE_CITY_TRADE(Region.FAR_HARAD_JUNGLE, LOTRFaction.UNALIGNED, 952.0, 2656.0), JUNGLE_CITY_OLD(Region.FAR_HARAD_JUNGLE, LOTRFaction.UNALIGNED, 1084.0, 2670.0), JUNGLE_CITY_NORTH(Region.FAR_HARAD_JUNGLE, LOTRFaction.TAURETHRIM, 1419.0, 2604.0), JUNGLE_CITY_EAST(Region.FAR_HARAD_JUNGLE, LOTRFaction.TAURETHRIM, 1594.0, 2766.0), JUNGLE_CITY_CAPITAL(Region.FAR_HARAD_JUNGLE, LOTRFaction.TAURETHRIM, 1380.0, 2861.0), JUNGLE_CITY_DEEP(Region.FAR_HARAD_JUNGLE, LOTRFaction.UNALIGNED, 1184.0, 3237.0), JUNGLE_CITY_WATCH(Region.FAR_HARAD_JUNGLE, LOTRFaction.UNALIGNED, 1590.0, 2940.0), JUNGLE_CITY_CAVES(Region.FAR_HARAD_JUNGLE, LOTRFaction.TAURETHRIM, 1257.0, 3054.0), JUNGLE_CITY_STONE(Region.FAR_HARAD_JUNGLE, LOTRFaction.TAURETHRIM, 1236.0, 2787.0), JUNGLE_LAKES(Region.FAR_HARAD_JUNGLE, LOTRFaction.UNALIGNED, 1550.0, 2856.0), TROLL_ISLAND(Region.PERTOROGWAITH, LOTRFaction.UNALIGNED, 1966.0, 2342.0), BLACK_COAST(Region.PERTOROGWAITH, LOTRFaction.UNALIGNED, 1936.0, 2496.0),
	BLOOD_RIVER(Region.PERTOROGWAITH, LOTRFaction.UNALIGNED, 1897.0, 2605.0), SHADOW_POINT(Region.PERTOROGWAITH, LOTRFaction.UNALIGNED, 1952.0, 2863),

	DUNHWOLD(Region.DUNLAND, LOTRFaction.DUNLAND, 950.0, 938.0), FORTDREG(Region.ERIADOR, LOTRFaction.GUNDABAD, 1062, 576.0), GREYHILLS(Region.ANGMAR, LOTRFaction.ANGMAR, 1118.0, 567.0), BURZALBUL(Region.ANGMAR, LOTRFaction.ANGMAR, 1129, 544.0), TROLLFOREST(Region.ERIADOR, LOTRFaction.GUNDABAD, 1129.0, 698.0), DRERGROT(Region.ERIADOR, LOTRFaction.GUNDABAD, 1177.0, 642.0), SHOUTINGFJORD(Region.ERIADOR, LOTRFaction.GUNDABAD, 1187.0, 622.0), CHALKPLACE(Region.RHUN, LOTRFaction.RHUDEL, 1763.0, 1009.0), VARIAGPASS(Region.RHUN, LOTRFaction.KHAND, 1780.0, 1438.0), VINEPORT(Region.RHUN, LOTRFaction.RHUDEL, 1785.0, 981.0), ERINLOST(Region.RHUN, LOTRFaction.RHUDEL, 1883.0, 842.0), VARIADKHAND(Region.RHUN, LOTRFaction.KHAND, 1946.0, 1381.0), KHANDPATH(Region.RHUN, LOTRFaction.KHAND, 1995, 1352), OROMEPASS(Region.RHUN, LOTRFaction.KHAND, 2051, 1176), REDSUBMOUNT(Region.RHUN, LOTRFaction.BLUE_MOUNTAINS, 2354.0, 575.0), KINDZDUM(Region.RHUN, LOTRFaction.BLUE_MOUNTAINS, 2400.0, 521.0), MRODDUM(Region.RHUN, LOTRFaction.BLUE_MOUNTAINS, 2422.0, 987.0), SIGINMOUTH(Region.RHUN, LOTRFaction.BLUE_MOUNTAINS, 2474.0, 920.0), ULJARDUM(Region.RHUN, LOTRFaction.BLUE_MOUNTAINS, 2572.0, 1290.0), KELEBRANTMOUTH(Region.LOTHLORIEN, LOTRFaction.LOTHLORIEN, 1203.0, 895.0), ELKLIMIT(Region.WOODLAND_REALM, LOTRFaction.WOOD_ELF, 1389.0, 905.0), ARMENELOS(Region.GONDOR, LOTRFaction.GONDOR, 861.0 - 1000, 2090.0), ELDALONDE(Region.GONDOR, LOTRFaction.GONDOR, 708.0 - 1000, 2113.0), ONDOSTO(Region.GONDOR, LOTRFaction.GONDOR, 765.0 - 1000, 1997.0), ANDUNIE(Region.GONDOR, LOTRFaction.GONDOR, 630.0 - 1000, 2007.0), NINDAMOS(Region.GONDOR, LOTRFaction.GONDOR, 858.0 - 1000, 2201.0), ROMENNA(Region.GONDOR, LOTRFaction.GONDOR, 930.0 - 1000, 2071.0), SORONTIL(Region.GONDOR, LOTRFaction.GONDOR, 866.0 - 1000, 1873.0), REDWATERPASS(Region.DALE, LOTRFaction.DALE, 1656.0, 767.0), NORBURG(Region.DALE, LOTRFaction.DALE, 1514.0, 640.0), NORTHGATE(Region.DALE, LOTRFaction.DALE, 1474.0, 695.0), OSTINEDHIL(Region.EREGION, LOTRFaction.EREGION, 1112.0, 877.0), OSTRADGERNEDIL(Region.EREGION, LOTRFaction.EREGION, 1146.0, 826.0), ELFLAKE(Region.EREGION, LOTRFaction.EREGION, 1125.0, 808.0), ERFORD(Region.VALES_OF_ANDUIN, LOTRFaction.UNALIGNED, 847, 679), FISHLIMIT(Region.VALES_OF_ANDUIN, LOTRFaction.UNALIGNED, 738, 977), NORTHANDUIN(Region.VALES_OF_ANDUIN, LOTRFaction.UNALIGNED, 1253, 592), NORTHGREENFOREST(Region.WOODLAND_REALM, LOTRFaction.UNALIGNED, 1420, 630), CENTERKALENANDOR(Region.WOODLAND_REALM, LOTRFaction.UNALIGNED, 1301, 1129), LAKECITY(Region.DALE, LOTRFaction.UNALIGNED, 1461, 632), YELLOWHILL(Region.DALE, LOTRFaction.UNALIGNED, 2017, 1467), SOLTVALE(Region.RHUN, LOTRFaction.UNALIGNED, 1575, 1471), EASTROAD(Region.RHUN, LOTRFaction.UNALIGNED, 1400, 697), KARNULBUL(Region.RHUN, LOTRFaction.UNALIGNED, 1069, 565), AMUNKHANAR(Region.RHUN, LOTRFaction.UNALIGNED, 1854, 1347),

	DIRTYHILL(Region.ANGMAR, LOTRFaction.UNALIGNED, 1068, 608),

	ERINERIM(Region.RHUN_KHAGANATE, LOTRFaction.RHUDEL, 1836, 852), KARANODA(Region.RHUN_KHAGANATE, LOTRFaction.RHUDEL, 1831, 948), KARNARAS(Region.RHUN_KHAGANATE, LOTRFaction.RHUDEL, 1877, 987), LASTPLACE(Region.RHUN_KHAGANATE, LOTRFaction.RHUDEL, 1783, 856), GREENSEA(Region.OCEAN, LOTRFaction.UNALIGNED, 1298, 789),

	NUMENOR(Region.AMOGUS, LOTRFaction.HOSTILE, 748 - 1000, 2197), KHAND(Region.AMOGUS, LOTRFaction.HOSTILE, 1862, 1453), MORDOR(Region.AMOGUS, LOTRFaction.HOSTILE, 1629, 1176), REDMOUNT(Region.AMOGUS, LOTRFaction.HOSTILE, 2358, 729), RHOVANION(Region.AMOGUS, LOTRFaction.HOSTILE, 1535, 640), RHUNAERIM(Region.AMOGUS, LOTRFaction.HOSTILE, 1920, 958), NANDOR(Region.AMOGUS, LOTRFaction.HOSTILE, 1381, 929), SINDAR(Region.AMOGUS, LOTRFaction.HOSTILE, 1219, 915), KHAZAD(Region.AMOGUS, LOTRFaction.HOSTILE, 1168, 812), EREGION(Region.AMOGUS, LOTRFaction.HOSTILE, 1062, 868), ENEDWAITH(Region.AMOGUS, LOTRFaction.HOSTILE, 1052, 970), ERIADOR(Region.AMOGUS, LOTRFaction.HOSTILE, 798, 685), NOLDOR(Region.AMOGUS, LOTRFaction.HOSTILE, 487, 641), NORTHORC(Region.AMOGUS, LOTRFaction.HOSTILE, 1114, 635), KARNDUM(Region.AMOGUS, LOTRFaction.HOSTILE, 1015, 530), NEARHARAD(Region.AMOGUS, LOTRFaction.HOSTILE, 1424, 1634),

	MENELTARMA_SUMMIT(Region.AMOGUS, LOTRFaction.HOSTILE, 0, 0, true),

	EASTGATE(Region.ERIADOR, LOTRFaction.UNALIGNED, 1173, 852),

	CLOUDPEAK(Region.RHUN, LOTRFaction.UNALIGNED, 2398, 1581), KHANDPEAK(Region.RHUN, LOTRFaction.UNALIGNED, 2249, 1551), BAELDUN(Region.RHUN, LOTRFaction.UNALIGNED, 2642, 1489), TRAELDUN(Region.RHUN, LOTRFaction.UNALIGNED, 2759, 1399), RODDUSU(Region.RHUN, LOTRFaction.UNALIGNED, 2702, 1641), KOMUNNI(Region.RHUN, LOTRFaction.UNALIGNED, 2655, 1690), SARDO(Region.RHUN, LOTRFaction.UNALIGNED, 2594, 1698), TARSU(Region.RHUN, LOTRFaction.UNALIGNED, 2555, 1751), HATTUSU(Region.RHUN, LOTRFaction.UNALIGNED, 2481, 1802), UDESSA(Region.RHUN, LOTRFaction.UNALIGNED, 2487, 1861), MECASUR(Region.RHUN, LOTRFaction.UNALIGNED, 2466, 2199), ARMAWURRY(Region.RHUN, LOTRFaction.UNALIGNED, 3705, 1593),

	OLD_JUNGLE_RUIN(Region.PERTOROGWAITH_FOREST, LOTRFaction.UNALIGNED, 1834.0, 2523.0);

	private Region region;
	public LOTRFaction faction;
	private double imgX;
	private double imgY;
	private int xCoord;
	private int zCoord;
	private boolean isHidden;

	LOTRWaypoint(Region r, LOTRFaction f, double x, double y) {
		this(r, f, x, y, false);
	}

	LOTRWaypoint(Region r, LOTRFaction f, double x, double y, boolean hide) {
		region = r;
		region.waypoints.add(this);
		faction = f;
		imgX = x;
		imgY = y;
		xCoord = mapToWorldX(x);
		zCoord = mapToWorldZ(y);
		isHidden = hide;
	}

	@Override
	public String getCodeName() {
		return name();
	}

	@Override
	public String getDisplayName() {
		return StatCollector.translateToLocal("lotr.waypoint." + getCodeName());
	}

	@Override
	public int getID() {
		return ordinal();
	}

	@Override
	public LOTRAbstractWaypoint.WaypointLockState getLockState(EntityPlayer entityplayer) {
		if (hasPlayerUnlocked(entityplayer)) {
			return isUnlockedByConquest(entityplayer) ? LOTRAbstractWaypoint.WaypointLockState.STANDARD_UNLOCKED_CONQUEST : LOTRAbstractWaypoint.WaypointLockState.STANDARD_UNLOCKED;
		}
		return LOTRAbstractWaypoint.WaypointLockState.STANDARD_LOCKED;
	}

	@Override
	public String getLoreText(EntityPlayer entityplayer) {
		StringBuilder key = new StringBuilder("lotr.waypoint.").append(getCodeName()).append(".info");
		if (this == FERTILE_VALLEY && LOTRLevelData.clientside_thisServer_commemorateEmpressShamiir) {
			key.append(".shamiir");
		}
		return StatCollector.translateToLocal(key.toString());
	}

	@Override
	public double getX() {
		return imgX;
	}

	@Override
	public int getXCoord() {
		return xCoord;
	}

	@Override
	public double getY() {
		return imgY;
	}

	@Override
	public int getYCoord(World world, int i, int k) {
		return LOTRMod.getTrueTopBlock(world, i, k);
	}

	@Override
	public int getYCoordSaved() {
		return 64;
	}

	@Override
	public int getZCoord() {
		return zCoord;
	}

	@Override
	public boolean hasPlayerUnlocked(EntityPlayer entityplayer) {
		LOTRPlayerData pd = LOTRLevelData.getData(entityplayer);
		if (pd.isFTRegionUnlocked(region)) {
			if (isCompatibleAlignment(entityplayer)) {
				return true;
			}
			if (isConquestUnlockable(entityplayer)) {
				return isConquered(entityplayer);
			}
		}
		return false;
	}

	public boolean isCompatibleAlignment(EntityPlayer entityplayer) {
		if (faction == LOTRFaction.UNALIGNED) {
			return true;
		}
		LOTRPlayerData pd = LOTRLevelData.getData(entityplayer);
		if (pd.getAlignment(faction) >= 0.0F) {
			return true;
		}
		return false;
	}

	private boolean isConquered(EntityPlayer entityplayer) {
		LOTRPlayerData pd = LOTRLevelData.getData(entityplayer);
		World world = entityplayer.worldObj;
		LOTRConquestZone zone = LOTRConquestGrid.getZoneByWorldCoords(getXCoord(), getZCoord());
		LOTRFaction pledgeFac = pd.getPledgeFaction();
		return pledgeFac != null && zone.getConquestStrength(pledgeFac, world) >= 500.0F;
	}

	public boolean isConquestUnlockable(EntityPlayer entityplayer) {
		LOTRPlayerData pd = LOTRLevelData.getData(entityplayer);
		World world = entityplayer.worldObj;
		LOTRConquestZone zone = LOTRConquestGrid.getZoneByWorldCoords(getXCoord(), getZCoord());
		LOTRFaction pledgeFac = pd.getPledgeFaction();
		if (pledgeFac != null && pledgeFac.isBadRelation(faction) && LOTRConquestGrid.getConquestEffectIn(world, zone, pledgeFac) == LOTRConquestGrid.ConquestEffective.EFFECTIVE) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isHidden() {
		return isHidden;
	}

	public boolean isUnlockedByConquest(EntityPlayer entityplayer) {
		return !isCompatibleAlignment(entityplayer) && isConquestUnlockable(entityplayer) && isConquered(entityplayer);
	}

	public static List<LOTRAbstractWaypoint> listAllWaypoints() {
		return new ArrayList<>(Arrays.asList((LOTRAbstractWaypoint[]) values()));
	}

	public static int mapToWorldR(double r) {
		return (int) Math.round(r * LOTRGenLayerWorld.scale);
	}

	public static int mapToWorldX(double x) {
		return (int) Math.round((x + BlackDragon.shift - 810.0 + 0.5) * LOTRGenLayerWorld.scale);
	}

	public static int mapToWorldZ(double z) {
		return (int) Math.round((z - 730.0 + 0.5) * LOTRGenLayerWorld.scale);
	}

	public static Region regionForID(int id) {
		for (Region region : Region.values()) {
			if (region.ordinal() == id) {
				return region;
			}
		}
		return null;
	}

	public static Region regionForName(String name) {
		for (Region region : Region.values()) {
			if (region.name().equals(name)) {
				return region;
			}
		}
		return null;
	}

	public static LOTRWaypoint waypointForName(String name) {
		for (LOTRWaypoint wp : values()) {
			if (wp.getCodeName().equals(name)) {
				return wp;
			}
		}
		return null;
	}

	public static int worldToMapR(double r) {
		return (int) Math.round(r / LOTRGenLayerWorld.scale);
	}

	public static int worldToMapX(double x) {
		return (int) Math.round(x / LOTRGenLayerWorld.scale - 0.5 + 810.0) + BlackDragon.shift;
	}

	public static int worldToMapZ(double z) {
		return (int) Math.round(z / LOTRGenLayerWorld.scale - 0.5 + 730.0);
	}

	public enum Region {
		OCEAN, MENELTARMA, SHIRE, OLD_FOREST, LINDON, BLUE_MOUNTAINS, ERIADOR, BREE_LAND, MIDGEWATER, LONE_LANDS, RIVENDELL_VALE, TROLLSHAWS, COLDFELLS, ETTENMOORS, ANGMAR, EREGION, DUNLAND, ENEDWAITH, NAN_CURUNIR, FORODWAITH, MISTY_MOUNTAINS, GREY_MOUNTAINS, VALES_OF_ANDUIN, WOODLAND_REALM, MIRKWOOD, WILDERLAND, DALE, IRON_HILLS, LOTHLORIEN, FANGORN, ROHAN, WHITE_MOUNTAINS, PUKEL, GONDOR, ITHILIEN, LEBENNIN, LOSSARNACH, LAMEDON, BLACKROOT_VALE, PINNATH_GELIN, DOR_EN_ERNIL, TOLFALAS, EMYN_MUIL, NINDALF, BROWN_LANDS, DAGORLAD, MORDOR, NURN, NAN_UNGOL, DORWINION, RHUN, RHUN_KHAGANATE, TOL_RHUNAER, RED_MOUNTAINS, HARONDOR, HARNEDOR, LOSTLADEN, UMBAR, SOUTHRON_COASTS, HARAD_DESERT, GULF_HARAD, HARAD_MOUNTAINS, FAR_HARAD, FAR_HARAD_JUNGLE, PERTOROGWAITH, PERTOROGWAITH_FOREST, AMOGUS;

		public List<LOTRWaypoint> waypoints;

		Region() {
			waypoints = new ArrayList<>();
		}
	}
}
