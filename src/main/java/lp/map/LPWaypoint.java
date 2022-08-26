package lp.map;

import lotr.common.fac.LOTRFaction;
import lotr.common.world.map.LOTRWaypoint;
import lp.util.LPCommander;

public class LPWaypoint {

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

	public static void preInit() {
		for (LOTRWaypoint wp : LOTRWaypoint.values()) {
			if (wp.getX() > 2366 || wp.getY() > 2107) {
				LPCommander.disableWaypoint(wp);
			}
		}
		LPCommander.disableWaypoint(LOTRWaypoint.GREAT_PLAINS_NORTH);
		LPCommander.disableWaypoint(LOTRWaypoint.MOUNT_SAND);
		Undmond = LPCommander.addWaypoint("Undmond", Region.CARDOLAN, LOTRFaction.RANGER_NORTH, 936, 906);
		Talsir = LPCommander.addWaypoint("Talsir", Region.CARDOLAN, LOTRFaction.RANGER_NORTH, 881, 941);
		Balost = LPCommander.addWaypoint("Balost", Region.CARDOLAN, LOTRFaction.RANGER_NORTH, 894, 902);
		Argond = LPCommander.addWaypoint("Argond", Region.CARDOLAN, LOTRFaction.RANGER_NORTH, 921, 865);
		AnnonBaran = LPCommander.addWaypoint("AnnonBaran", Region.CARDOLAN, LOTRFaction.RANGER_NORTH, 750, 901);
		Gitrenor = LPCommander.addWaypoint("Gitrenor", Region.CARDOLAN, LOTRFaction.RANGER_NORTH, 765, 878);
		Angsul = LPCommander.addWaypoint("Angsul", LOTRWaypoint.Region.ANGMAR, LOTRFaction.ANGMAR, 1010, 536);
		Morkat = LPCommander.addWaypoint("Morkat", LOTRWaypoint.Region.ANGMAR, LOTRFaction.ANGMAR, 1050, 551);
		Szeldan = LPCommander.addWaypoint("Szeldan", LOTRWaypoint.Region.ANGMAR, LOTRFaction.ANGMAR, 1093, 569);
		Kargasz = LPCommander.addWaypoint("Kargasz", LOTRWaypoint.Region.ANGMAR, LOTRFaction.ANGMAR, 1048, 573);
		Litasz = LPCommander.addWaypoint("Litasz", LOTRWaypoint.Region.ANGMAR, LOTRFaction.ANGMAR, 1165, 585);
		Fandar = LPCommander.addWaypoint("Fandar", Region.RHUDAUR, LOTRFaction.ANGMAR, 1053, 702);
		DorTalion = LPCommander.addWaypoint("DorTalion", Region.RHUDAUR, LOTRFaction.ANGMAR, 1006, 636);
		Hojra = LPCommander.addWaypoint("Hojra", Region.RHUDAUR, LOTRFaction.ANGMAR, 1114, 672);
		KametBrin = LPCommander.addWaypoint("KametBrin", Region.RHUDAUR, LOTRFaction.ANGMAR, 1138, 682);
		Ettenmurs = LPCommander.addWaypoint("Ettenmurs", Region.RHUDAUR, LOTRFaction.ANGMAR, 1133, 639);
		MorvaTart = LPCommander.addWaypoint("MorvaTart", Region.RHUDAUR, LOTRFaction.ANGMAR, 1088, 635);
		Eldanor = LPCommander.addWaypoint("Eldanor", Region.RHUDAUR, LOTRFaction.ANGMAR, 1048, 594);
	}

	public static class Region {
		public static LOTRWaypoint.Region RHUDAUR;
		public static LOTRWaypoint.Region ARTHEDAIN;
		public static LOTRWaypoint.Region CARDOLAN;

		public static void preInit() {
			RHUDAUR = LPCommander.addWaypointRegion("RHUDAUR");
			ARTHEDAIN = LPCommander.addWaypointRegion("ARTHEDAIN");
			CARDOLAN = LPCommander.addWaypointRegion("ANGBAND");
		}
	}
}