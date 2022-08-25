package lp;

import java.util.List;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.relauncher.ReflectionHelper;
import lotr.client.gui.LOTRMapLabels;
import lotr.common.fac.LOTRFaction;
import lotr.common.world.map.*;
import lotr.common.world.map.LOTRWaypoint.Region;
import lp.proxy.LPServerProxy;
import lp.util.LPCommander;
import net.minecraft.util.ResourceLocation;

@Mod(modid = "lp", version = "Prod. Hummel009", name = "LOTR Patch", dependencies = "required-after:lotr")
public class LOTRPatcher {
	@SidedProxy(serverSide = "lp.proxy.LPServerProxy", clientSide = "lp.proxy.LPClientProxy")
	public static LPServerProxy proxy;
	@Mod.Instance(value = "lp")
	public static LOTRPatcher instance;

	public static LOTRWaypoint Undmond;
	public static LOTRWaypoint Talsir;
	public static LOTRWaypoint Balost;
	public static LOTRWaypoint Argond;
	public static LOTRWaypoint AnnonBaran;
	public static LOTRWaypoint Gitrenor;
	public static LOTRWaypoint Angsul;
	public static LOTRWaypoint Morkat;
	public static LOTRWaypoint Szeldan;
	public static LOTRWaypoint Kargasz;
	public static LOTRWaypoint Litasz;
	public static LOTRWaypoint Fandar;
	public static LOTRWaypoint DorTalion;
	public static LOTRWaypoint Hojra;
	public static LOTRWaypoint KametBrin;
	public static LOTRWaypoint Ettenmurs;
	public static LOTRWaypoint MorvaTart;
	public static LOTRWaypoint Eldanor;
	@Mod.EventHandler
	public void onInit(FMLInitializationEvent event) {
		LPCommander.setServerMapImage(new ResourceLocation("lp:map/map.png"));
		proxy.onInit(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Undmond = LPCommander.addWaypoint("Undmond", Region.ERIADOR, LOTRFaction.RANGER_NORTH, 936, 906);
		Talsir = LPCommander.addWaypoint("Talsir", Region.ERIADOR, LOTRFaction.RANGER_NORTH, 881, 941);
		Balost = LPCommander.addWaypoint("Balost", Region.ERIADOR, LOTRFaction.RANGER_NORTH, 894, 902);
		Argond = LPCommander.addWaypoint("Argond", Region.ERIADOR, LOTRFaction.RANGER_NORTH, 921, 865);
		AnnonBaran = LPCommander.addWaypoint("AnnonBaran", Region.ERIADOR, LOTRFaction.RANGER_NORTH, 750, 901);
		Gitrenor = LPCommander.addWaypoint("Gitrenor", Region.ERIADOR, LOTRFaction.RANGER_NORTH, 765, 878);
		Angsul = LPCommander.addWaypoint("Angsul", Region.ERIADOR, LOTRFaction.ANGMAR, 1010, 536);
		Morkat = LPCommander.addWaypoint("Morkat", Region.ERIADOR, LOTRFaction.ANGMAR, 1050, 551);
		Szeldan = LPCommander.addWaypoint("Szeldan", Region.ERIADOR, LOTRFaction.ANGMAR, 1093, 569);
		Kargasz = LPCommander.addWaypoint("Kargasz", Region.ERIADOR, LOTRFaction.ANGMAR, 1048, 573);
		Litasz = LPCommander.addWaypoint("Litasz", Region.ERIADOR, LOTRFaction.ANGMAR, 1165, 585);
		Fandar = LPCommander.addWaypoint("Fandar", Region.ERIADOR, LOTRFaction.ANGMAR, 1053, 702);
		DorTalion = LPCommander.addWaypoint("DorTalion", Region.ERIADOR, LOTRFaction.ANGMAR, 1006, 636);
		Hojra = LPCommander.addWaypoint("Hojra", Region.ERIADOR, LOTRFaction.ANGMAR, 1114, 672);
		KametBrin = LPCommander.addWaypoint("KametBrin", Region.ERIADOR, LOTRFaction.ANGMAR, 1138, 682);
		Ettenmurs = LPCommander.addWaypoint("Ettenmurs", Region.ERIADOR, LOTRFaction.ANGMAR, 1133, 639);
		MorvaTart = LPCommander.addWaypoint("MorvaTart", Region.ERIADOR, LOTRFaction.ANGMAR, 1088, 635);
		Eldanor = LPCommander.addWaypoint("Eldanor", Region.ERIADOR, LOTRFaction.ANGMAR, 1048, 594);

		((List) ReflectionHelper.getPrivateValue(LOTRRoads.class, null, "allRoads")).clear();
		((List) ReflectionHelper.getPrivateValue(LOTRRoads.class, null, "displayOnlyRoads")).clear();
		LPCommander.clearRoadDataBase();

		LPCommander.registerRoad("EredLuin", LOTRWaypoint.CARN_DUM, Angsul, Kargasz);

		LPCommander.registerRoad("EredLuin", Szeldan, Litasz);
		LPCommander.registerRoad("EredLuin", Morkat, Szeldan);
		LPCommander.registerRoad("EredLuin", Eldanor, Kargasz, Morkat);
		LPCommander.registerRoad("EredLuin", KametBrin, Hojra);
		LPCommander.registerRoad("EredLuin", Eldanor, MorvaTart, Ettenmurs);
		LPCommander.registerRoad("EredLuin", LOTRWaypoint.LAST_BRIDGE, Hojra, Ettenmurs);
		LPCommander.registerRoad("EredLuin", LOTRWaypoint.LAST_BRIDGE, Fandar, DorTalion);
		LPCommander.registerRoad("EredLuin", LOTRWaypoint.GREENWAY_CROSSROADS, Argond, Undmond);
		LPCommander.registerRoad("EredLuin", Argond, Balost, Talsir);
		LPCommander.registerRoad("EredLuin", LOTRWaypoint.ERYN_VORN, new int[] {811, 921}, Talsir);
		LPCommander.registerRoad("EredLuin", Gitrenor, LOTRWaypoint.SARN_FORD);
		LPCommander.registerRoad("EredLuin", AnnonBaran, Gitrenor);
		LPCommander.registerRoad("EredLuin", Gitrenor, new int[] {700, 921}, LOTRWaypoint.HARLINDON);

		LPCommander.clearFaction(LOTRFaction.TAURETHRIM);
		LPCommander.clearFaction(LOTRFaction.MORWAITH);
		LPCommander.clearFaction(LOTRFaction.HALF_TROLL);
		for (LOTRWaypoint wp : LOTRWaypoint.values()) {
			if (wp.getX() > 2366 || wp.getY() > 2107) {
				LPCommander.disableWaypoint(wp);
			}
		}
		for (LOTRMapLabels lbl : LOTRMapLabels.values()) {
			if (lbl.posX > 2366 || lbl.posY > 1825) {
				LPCommander.removeMapLabel(lbl);
			}
		}
		LPCommander.disableWaypoint(LOTRWaypoint.GREAT_PLAINS_NORTH);
		LPCommander.disableWaypoint(LOTRWaypoint.MOUNT_SAND);

		LPCommander.registerRoad("EredLuin", LOTRWaypoint.NOGROD, LOTRWaypoint.BELEGOST);
		LPCommander.registerRoad("NogrodForlond", LOTRWaypoint.NOGROD, LOTRWaypoint.FORLOND);
		LPCommander.registerRoad("NogrodMithlond", LOTRWaypoint.NOGROD, new int[] { 654, 650 }, LOTRWaypoint.MITHLOND_NORTH);
		LPCommander.registerRoad("Mithlond", LOTRWaypoint.HARLOND, new int[] { 658, 755 }, LOTRWaypoint.MITHLOND_SOUTH, new int[] { 690, 711 }, new int[] { 681, 705 }, LOTRWaypoint.MITHLOND_NORTH, new int[] { 644, 733 }, new int[] { 603, 733 }, new int[] { 554, 715 }, LOTRWaypoint.FORLOND);
		LPCommander.registerRoad("WestEast", LOTRWaypoint.MITHLOND_SOUTH, LOTRWaypoint.TOWER_HILLS, LOTRWaypoint.GREENHOLM, LOTRWaypoint.MICHEL_DELVING, LOTRWaypoint.WAYMEET, LOTRWaypoint.BYWATER, LOTRWaypoint.FROGMORTON, LOTRWaypoint.WHITFURROWS, LOTRWaypoint.BRANDYWINE_BRIDGE, new int[] { 870, 718 }, new int[] { 902, 729 }, LOTRWaypoint.BREE);
		LPCommander.registerRoad("WestEast", LOTRWaypoint.BREE, new double[] { LOTRWaypoint.BREE.getX() + 0.5, LOTRWaypoint.BREE.getY() });
		LPCommander.registerRoad("WestEast", new double[] { LOTRWaypoint.BREE.getX() + 2.0, LOTRWaypoint.BREE.getY() + 1.5 }, new double[] { LOTRWaypoint.STADDLE.getX(), LOTRWaypoint.STADDLE.getY() + 5.0 }, LOTRWaypoint.FORSAKEN_INN, new double[] { LOTRWaypoint.WEATHERTOP.getX(), LOTRWaypoint.WEATHERTOP.getY() + 2.0 }, LOTRWaypoint.LAST_BRIDGE, new int[] { 1132, 723 }, new int[] { 1178, 704 }, LOTRWaypoint.HIGH_PASS, LOTRWaypoint.OLD_FORD, LOTRWaypoint.RIVER_GATE, LOTRWaypoint.DALE_CROSSROADS, LOTRWaypoint.REDWATER_FORD, new int[] { 1785, 775 }, LOTRWaypoint.RHUN_NORTH_FORD, LOTRWaypoint.RHUN_NORTHEAST, LOTRWaypoint.RHUN_ROAD_WAY, LOTRWaypoint.BARAZ_DUM);
		LPCommander.registerRoad("WestEast", new double[] { LOTRWaypoint.BREE.getX() - 0.375, LOTRWaypoint.BREE.getY() - 2.476 }, new double[] { LOTRWaypoint.BREE.getX() + 2.0, LOTRWaypoint.BREE.getY() - 1.5 });
		LPCommander.registerRoad("BywaterRoad", LOTRWaypoint.BYWATER, LOTRWaypoint.HOBBITON);
		LPCommander.registerRoad("Overhill", LOTRWaypoint.HOBBITON, LOTRWaypoint.OVERHILL);
		LPCommander.registerRoad("BucklandRoad", LOTRWaypoint.HAY_GATE, LOTRWaypoint.BUCKLEBURY, LOTRWaypoint.HAYSEND);
		LPCommander.registerRoad("Chetroad", new double[] { LOTRWaypoint.STADDLE.getX(), LOTRWaypoint.STADDLE.getY() + 5.0 }, LOTRWaypoint.STADDLE, LOTRWaypoint.COMBE, LOTRWaypoint.ARCHET);
		LPCommander.registerRoad("Chetroad", LOTRWaypoint.STADDLE, new double[] { LOTRWaypoint.STADDLE.getX() - 0.5, LOTRWaypoint.STADDLE.getY() });
		LPCommander.registerRoad("Chetroad", LOTRWaypoint.COMBE, new double[] { LOTRWaypoint.COMBE.getX() + 0.5, LOTRWaypoint.COMBE.getY() });
		LPCommander.registerRoad("Chetroad", LOTRWaypoint.ARCHET, new double[] { LOTRWaypoint.ARCHET.getX(), LOTRWaypoint.ARCHET.getY() - 0.5 });
		LPCommander.registerRoad("ElfPath", LOTRWaypoint.FOREST_GATE, LOTRWaypoint.ENCHANTED_RIVER, LOTRWaypoint.THRANDUIL_HALLS);
		LPCommander.registerRoad("EreborRoad", LOTRWaypoint.LONG_LAKE, LOTRWaypoint.DALE_CITY, LOTRWaypoint.EREBOR);
		LPCommander.registerRoad("DalePortRoad", LOTRWaypoint.DALE_CITY, LOTRWaypoint.DALE_CROSSROADS, LOTRWaypoint.DALE_PORT);
		LPCommander.registerRoad("DaleSouthRoad", LOTRWaypoint.EAST_RHOVANION_ROAD, LOTRWaypoint.OLD_RHOVANION, LOTRWaypoint.RUNNING_FORD, LOTRWaypoint.DALE_CROSSROADS, LOTRWaypoint.WEST_PEAK);
		LPCommander.registerRoad("IronHills", LOTRWaypoint.WEST_PEAK, new int[] { 1652, 621 }, LOTRWaypoint.EAST_PEAK);
		LPCommander.registerRoad("DorwinionSouthRoad", LOTRWaypoint.DALE_PORT, LOTRWaypoint.DORWINION_CROSSROADS, LOTRWaypoint.DORWINION_COURT, LOTRWaypoint.DORWINION_FORD);
		LPCommander.registerRoad("DorwinionEastRoad", LOTRWaypoint.OLD_RHOVANION, LOTRWaypoint.DORWINION_CROSSROADS, LOTRWaypoint.DORWINION_PORT);
		LPCommander.registerRoad("RhunRoad", LOTRWaypoint.DORWINION_FORD, LOTRWaypoint.BORDER_TOWN, LOTRWaypoint.RHUN_SEA_CITY, LOTRWaypoint.RHUN_CAPITAL, new int[] { 1888, 958 }, LOTRWaypoint.RHUN_NORTH_CITY, LOTRWaypoint.BAZYLAN, LOTRWaypoint.RHUN_NORTHEAST);
		LPCommander.registerRoad("RhunEastRoad", LOTRWaypoint.RHUN_NORTH_CITY, LOTRWaypoint.RHUN_EAST_TOWN, LOTRWaypoint.RHUN_EAST_CITY);
		LPCommander.registerRoad("Nobottle", LOTRWaypoint.TIGHFIELD, LOTRWaypoint.LITTLE_DELVING, LOTRWaypoint.NOBOTTLE, LOTRWaypoint.NEEDLEHOLE);
		LPCommander.registerRoad("Oatbarton", LOTRWaypoint.OATBARTON, LOTRWaypoint.FROGMORTON);
		LPCommander.registerRoad("Stock", LOTRWaypoint.TUCKBOROUGH, LOTRWaypoint.STOCK);
		LPCommander.registerRoad("Deephallow", LOTRWaypoint.SCARY, LOTRWaypoint.WHITFURROWS, LOTRWaypoint.STOCK, LOTRWaypoint.DEEPHALLOW);
		LPCommander.registerRoad("Willowbottom", LOTRWaypoint.WILLOWBOTTOM, LOTRWaypoint.DEEPHALLOW);
		LPCommander.registerRoad("ArnorRoad", LOTRWaypoint.ANNUMINAS, LOTRWaypoint.FORNOST);
		LPCommander.registerRoad("Greenway", LOTRWaypoint.FORNOST, LOTRWaypoint.BREE, LOTRWaypoint.GREENWAY_CROSSROADS);
		LPCommander.registerRoad("ElvenWay", LOTRWaypoint.WEST_GATE, new int[] { 1133, 867 }, new int[] { 1124, 868 }, LOTRWaypoint.OST_IN_EDHIL, new int[] { 1073, 864 }, LOTRWaypoint.OLD_ELF_WAY, new int[] { 1002, 849 }, new int[] { 992, 860 }, LOTRWaypoint.THARBAD, new int[] { 959, 889 }, new int[] { 926, 913 }, new int[] { 902, 942 }, LOTRWaypoint.LOND_DAER);
		LPCommander.registerRoad("BruinenPath", LOTRWaypoint.FORD_BRUINEN, LOTRWaypoint.RIVENDELL);
		LPCommander.registerRoad("NimrodelRoad", LOTRWaypoint.DIMRILL_DALE, LOTRWaypoint.NIMRODEL);
		LPCommander.registerRoad("AnduinRoad", LOTRWaypoint.MORANNON, new int[] { 1428, 1066 }, LOTRWaypoint.EAST_RHOVANION_ROAD, LOTRWaypoint.ANDUIN_CROSSROADS, new int[] { 1325, 820 }, new int[] { 1318, 735 }, LOTRWaypoint.FOREST_GATE);
		LPCommander.registerRoad("DolGuldurRoad", LOTRWaypoint.ANDUIN_CROSSROADS, LOTRWaypoint.DOL_GULDUR);
		LPCommander.registerRoad("Framsburg", LOTRWaypoint.FOREST_GATE, new int[] { 1278, 605 }, LOTRWaypoint.FRAMSBURG, new int[] { 1260, 565 }, LOTRWaypoint.DAINS_HALLS);
		LPCommander.registerRoad("NorthSouth", LOTRWaypoint.LITTLE_DELVING, LOTRWaypoint.WAYMEET, LOTRWaypoint.LONGBOTTOM, LOTRWaypoint.SARN_FORD, LOTRWaypoint.GREENWAY_CROSSROADS, LOTRWaypoint.THARBAD, LOTRWaypoint.ENEDWAITH_ROAD, LOTRWaypoint.FORDS_OF_ISEN, LOTRWaypoint.HELMS_CROSSROADS, LOTRWaypoint.GRIMSLADE, LOTRWaypoint.EDORAS, LOTRWaypoint.ALDBURG, LOTRWaypoint.MERING_STREAM, LOTRWaypoint.AMON_DIN);
		LPCommander.registerRoad("TirithRoad", LOTRWaypoint.AMON_DIN, LOTRWaypoint.MINAS_TIRITH);
		LPCommander.registerRoad("OsgiliathRoad", LOTRWaypoint.MINAS_TIRITH, LOTRWaypoint.OSGILIATH_WEST);
		LPCommander.registerRoad("OsgiliathCrossing", LOTRWaypoint.OSGILIATH_WEST, LOTRWaypoint.OSGILIATH_EAST);
		LPCommander.registerRoad("OsgiliathMorgulRoad", LOTRWaypoint.OSGILIATH_EAST, LOTRWaypoint.CROSSROADS_ITHILIEN, LOTRWaypoint.MINAS_MORGUL);
		LPCommander.registerRoad("GondorSouthRoad", LOTRWaypoint.MINAS_TIRITH, LOTRWaypoint.CROSSINGS_ERUI, new int[] { 1408, 1291 }, LOTRWaypoint.PELARGIR, LOTRWaypoint.LINHIR, new int[] { 1266, 1301 }, LOTRWaypoint.ETHRING, LOTRWaypoint.CALEMBEL, LOTRWaypoint.TARLANG, LOTRWaypoint.ERECH);
		LPCommander.registerRoad("IsengardRoad", LOTRWaypoint.FORDS_OF_ISEN, LOTRWaypoint.ISENGARD);
		LPCommander.registerRoad("IsengardRoad", LOTRWaypoint.ISENGARD, new double[] { LOTRWaypoint.ISENGARD.getX(), LOTRWaypoint.ISENGARD.getY() - 3.5 });
		LPCommander.registerRoad("HelmRoad", LOTRWaypoint.HELMS_CROSSROADS, LOTRWaypoint.HELMS_DEEP);
		LPCommander.registerRoad("WoldRoad", LOTRWaypoint.EDORAS, LOTRWaypoint.ENTWADE, new int[] { 1260, 1060 }, LOTRWaypoint.WOLD);
		LPCommander.registerRoad("DolAmroth", new int[] { 1266, 1301 }, LOTRWaypoint.TARNOST, LOTRWaypoint.EDHELLOND, new int[] { 1185, 1325 }, LOTRWaypoint.DOL_AMROTH);
		LPCommander.registerRoad("Pelargir", LOTRWaypoint.PELARGIR, new int[] { 1394, 1352 });
		LPCommander.registerRoad("Poros", new int[] { 1397, 1355 }, LOTRWaypoint.CROSSINGS_OF_POROS);
		LPCommander.registerRoad("CairAndros", LOTRWaypoint.AMON_DIN, LOTRWaypoint.CAIR_ANDROS, LOTRWaypoint.NORTH_ITHILIEN);
		LPCommander.registerRoad("SauronRoad", LOTRWaypoint.MINAS_MORGUL, LOTRWaypoint.MOUNT_DOOM, LOTRWaypoint.BARAD_DUR, LOTRWaypoint.SEREGOST, new int[] { 1742, 1209 }, new int[] { 1809, 1172 }, LOTRWaypoint.EASTERN_GUARD, LOTRWaypoint.MORDOR_FORD, LOTRWaypoint.RHUN_SOUTH_PASS, new int[] { 1875, 1003 }, new int[] { 1867, 996 }, LOTRWaypoint.RHUN_CAPITAL);
		LPCommander.registerRoad("MorannonRoad", LOTRWaypoint.MORANNON, LOTRWaypoint.UDUN);
		LPCommander.registerRoad("MorannonRhunRoad", LOTRWaypoint.MORANNON, new int[] { 1520, 1130 }, new int[] { 1658, 1140 }, new int[] { 1780, 1115 }, LOTRWaypoint.MORDOR_FORD, LOTRWaypoint.RHUN_SOUTHEAST, LOTRWaypoint.KHAND_NORTH_ROAD, LOTRWaypoint.KHAND_FORD, LOTRWaypoint.HARNEN_BLACK_TOWN, LOTRWaypoint.CROSSINGS_OF_LITHNEN, LOTRWaypoint.HARNEN_ROAD_TOWN, LOTRWaypoint.HARNEN_RIVER_TOWN, LOTRWaypoint.HARNEN_SEA_TOWN, LOTRWaypoint.COAST_FORTRESS, LOTRWaypoint.GATE_FUINUR, LOTRWaypoint.UMBAR_CITY, LOTRWaypoint.GATE_HERUMOR);
		LPCommander.registerRoad("GorgorothRoad", LOTRWaypoint.UDUN, LOTRWaypoint.CARACH_ANGREN, LOTRWaypoint.BARAD_DUR, LOTRWaypoint.THAURBAND);
		LPCommander.registerRoad("HaradRoad", LOTRWaypoint.MORANNON, LOTRWaypoint.NORTH_ITHILIEN, LOTRWaypoint.CROSSROADS_ITHILIEN, LOTRWaypoint.CROSSINGS_OF_POROS, new int[] { 1429, 1394 }, new int[] { 1408, 1432 }, new int[] { 1428, 1470 }, new int[] { 1435, 1526 }, LOTRWaypoint.CROSSINGS_OF_HARAD, LOTRWaypoint.HARNEN_ROAD_TOWN, LOTRWaypoint.DESERT_TOWN);
		LPCommander.registerRoad("UmbarRoad", LOTRWaypoint.UMBAR_CITY, LOTRWaypoint.UMBAR_GATE, LOTRWaypoint.AIN_AL_HARAD, LOTRWaypoint.GARDENS_BERUTHIEL, LOTRWaypoint.FERTILE_VALLEY);
		LPCommander.registerRoad("GulfRoad", LOTRWaypoint.GULF_TRADE_TOWN, LOTRWaypoint.GULF_CITY, LOTRWaypoint.GULF_NORTH_TOWN, new int[] { 1702, 1940 }, LOTRWaypoint.GULF_OF_HARAD, new int[] { 1775, 2002 }, LOTRWaypoint.GULF_EAST_PORT);

	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}
}