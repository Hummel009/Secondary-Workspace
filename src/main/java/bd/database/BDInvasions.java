package bd.database;

import bd.entity.*;
import bd.util.BDCommander;
import lotr.common.fac.LOTRFaction;
import lotr.common.world.spawning.LOTRInvasions;
import lotr.common.world.spawning.LOTRInvasions.InvasionSpawnEntry;

public class BDInvasions {
	public static LOTRInvasions KHAND;
	public static LOTRInvasions EREGION;

	private static void addInvasionIcons() {
		BDCommander.changeInvasionIcon(KHAND, BDRegistry.khand1_sword);
		BDCommander.changeInvasionIcon(EREGION, BDRegistry.eregion1_sword);
	}

	private static void addInvasionMobs() {
		BDInvasions.KHAND.invasionMobs.add(new InvasionSpawnEntry(BDEntityKhandLevyman.class, 5));
		BDInvasions.KHAND.invasionMobs.add(new InvasionSpawnEntry(BDEntityKhandWarrior.class, 10));
		BDInvasions.KHAND.invasionMobs.add(new InvasionSpawnEntry(BDEntityKhandArcher.class, 5));
		BDInvasions.KHAND.invasionMobs.add(new InvasionSpawnEntry(BDEntityKhandGoldWarrior.class, 5));
		BDInvasions.KHAND.invasionMobs.add(new InvasionSpawnEntry(BDEntityKhandBannerBearer.class, 5));

		BDInvasions.EREGION.invasionMobs.add(new InvasionSpawnEntry(BDEntityEregionWarrior.class, 15));
		BDInvasions.EREGION.invasionMobs.add(new InvasionSpawnEntry(BDEntityEregionBannerBearer.class, 2));
	}

	public static void onInit() {
		BDInvasions.setupInvasions();
		BDInvasions.addInvasionIcons();
		BDInvasions.addInvasionMobs();
	}

	private static void setupInvasions() {
		KHAND = BDCommander.addInvasion("KHAND", LOTRFaction.KHAND);
		EREGION = BDCommander.addInvasion("EREGION", LOTRFaction.EREGION);
	}
}
