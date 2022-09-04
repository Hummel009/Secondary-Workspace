package bd.structure;

import bd.database.WOTRMCNewBlocks;
import bd.entity.BDEntityEregionSmith;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityElf;
import lotr.common.world.structure2.LOTRWorldGenElvenForge;
import net.minecraft.world.World;

public class BDStructureEregionForge extends LOTRWorldGenElvenForge {
	public BDStructureEregionForge(boolean flag) {
		super(flag);
		brickBlock = WOTRMCNewBlocks.avariBlock2;
		brickMeta = 0;
		pillarBlock = LOTRMod.pillar;
		pillarMeta = 10;
		slabBlock = LOTRMod.slabSingle5;
		slabMeta = 5;
		carvedBrickBlock = LOTRMod.brick2;
		carvedBrickMeta = 13;
		wallBlock = LOTRMod.wall2;
		wallMeta = 11;
		stairBlock = WOTRMCNewBlocks.avariSquareStairs;
		torchBlock = LOTRMod.highElvenTorch;
		tableBlock = LOTRMod.highElvenTable;
		barsBlock = LOTRMod.highElfBars;
		woodBarsBlock = LOTRMod.highElfWoodBars;
		roofBlock = LOTRMod.clayTileDyed;
		roofMeta = 5;
		roofStairBlock = LOTRMod.stairsClayTileDyedLime;
	}

	@Override
	protected LOTREntityElf getElf(World world) {
		return new BDEntityEregionSmith(world);
	}
}