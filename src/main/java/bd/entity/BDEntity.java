package bd.entity;

import lotr.common.entity.LOTREntities;

public class BDEntity {
	public static int id = 3000;

	public static void preInit() {
		LOTREntities.registerCreature(BDEntityEregionElf.class, "EregionElf", id++, 9337185, 15920555);
		LOTREntities.registerCreature(BDEntityEregionWarrior.class, "EregionWarrior", id++, 12697274, 15382870);
		LOTREntities.registerCreature(BDEntityEregionLord.class, "EregionLord", id++, 12697274, 15382870);
		LOTREntities.registerCreature(BDEntityEregionBannerBearer.class, "EregionBannerBearer", id++, 12697274, 15382870);
		LOTREntities.registerCreature(BDEntityEregionSmith.class, "EregionSmith", id++, 9337185, 15920555);
		LOTREntities.registerCreature(BDEntityEregionWarden.class, "EregionWarden", id++, 10527645, 8027255);
		LOTREntities.registerCreature(BDEntityKhandMan.class, "Khand", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandWarrior.class, "KhandWarrior", id++, 7486267, 15251832);
		LOTREntities.registerCreature(BDEntityKhandBannerBearer.class, "KhandBannerBearer", id++, 7486267, 15251832);
		LOTREntities.registerCreature(BDEntityKhandArcher.class, "KhandArcher", id++, 7486267, 15251832);
		LOTREntities.registerCreature(BDEntityKhandBlacksmith.class, "KhandBlacksmith", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandWarlord.class, "KhandWarlord", id++, 14265689, 12004653);
		LOTREntities.registerCreature(BDEntityKhandLevyman.class, "KhandLevyman", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandGoldWarrior.class, "KhandGoldWarrior", id++, 14265689, 12004653);
		LOTREntities.registerCreature(BDEntityKhandLumberman.class, "KhandLumberman", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandMason.class, "KhandMason", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandButcher.class, "KhandButcher", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandBrewer.class, "KhandBrewer", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandFishmonger.class, "KhandFishmonger", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandBaker.class, "KhandBaker", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandHunter.class, "KhandHunter", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandFarmer.class, "KhandFarmer", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandGoldsmith.class, "KhandGoldsmith", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandBartender.class, "KhandBartender", id++, 16093531, 6176050);
		LOTREntities.registerCreature(BDEntityKhandFarmhand.class, "KhandFarmhand", id++, 16093531, 6176050);
		LOTREntities.registerEntity(BDEntityArrowFire.class, "ArrowFire", 2031, 64, 20, false);
		LOTREntities.registerEntity(BDEntityArrowBlindness.class, "ArrowBlindness", 2031, 64, 20, false);
		LOTREntities.registerEntity(BDEntityArrowSlowness.class, "ArrowSlowness", 2031, 64, 20, false);
		LOTREntities.registerEntity(BDEntityArrowHunger.class, "ArrowHunger", 2031, 64, 20, false);
	}
}
