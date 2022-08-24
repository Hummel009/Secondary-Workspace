package bd.database;

import bd.entity.*;
import lotr.common.LOTRMod;
import lotr.common.entity.animal.LOTREntityHorse;
import lotr.common.entity.npc.*;

public class BDUnitTradeEntries {
	public static LOTRUnitTradeEntries EREGION_LORD = new LOTRUnitTradeEntries(300.0f, new LOTRUnitTradeEntry(BDEntityEregionElf.class, 30, 0.0f), new LOTRUnitTradeEntry(BDEntityEregionWarden.class, 40, 50.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_ELF), new LOTRUnitTradeEntry(BDEntityEregionWarrior.class, 50, 100.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_ELF), new LOTRUnitTradeEntry(BDEntityEregionWarrior.class, LOTREntityHorse.class, "EregionWarrior_Horse", 70, 200.0f).setMountArmor(LOTRMod.horseArmorGaladhrim).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_ELF), new LOTRUnitTradeEntry(BDEntityEregionBannerBearer.class, 70, 250.0f).setPledgeType(LOTRUnitTradeEntry.PledgeType.ANY_ELF));
	public static LOTRUnitTradeEntries KHAND_WARLORD = new LOTRUnitTradeEntries(150.0f, new LOTRUnitTradeEntry(BDEntityKhandLevyman.class, 20, 0.0f), new LOTRUnitTradeEntry(BDEntityKhandWarrior.class, 30, 50.0f), new LOTRUnitTradeEntry(BDEntityKhandArcher.class, 50, 100.0f), new LOTRUnitTradeEntry(BDEntityKhandGoldWarrior.class, 50, 200.0f).setPledgeExclusive(), new LOTRUnitTradeEntry(BDEntityKhandWarrior.class, LOTREntityHorse.class, "KhandWarrior_Horse", 50, 150.0f), new LOTRUnitTradeEntry(BDEntityKhandArcher.class, LOTREntityHorse.class, "KhandArcher_Horse", 70, 200.0f), new LOTRUnitTradeEntry(BDEntityKhandGoldWarrior.class, LOTREntityHorse.class, "KhandGoldWarrior_Horse", 70, 300.0f).setMountArmor(LOTRMod.horseArmorRhunGold).setPledgeExclusive(), new LOTRUnitTradeEntry(BDEntityKhandBannerBearer.class, 50, 200.0f));
	public static LOTRUnitTradeEntries KHAND_FARMER = new LOTRUnitTradeEntries(0.0f, new LOTRUnitTradeEntry(BDEntityKhandFarmhand.class, 40, 50.0f).setTask(LOTRHiredNPCInfo.Task.FARMER));
}