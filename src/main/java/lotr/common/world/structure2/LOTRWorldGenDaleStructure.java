package lotr.common.world.structure2;

import java.util.Random;

import bd.database.WOTRMCNewBlocks;
import lotr.common.LOTRMod;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public abstract class LOTRWorldGenDaleStructure extends LOTRWorldGenStructureBase2 {
	protected Block brickBlock;
	protected int brickMeta;
	protected Block brickSlabBlock;
	protected int brickSlabMeta;
	protected Block brickStairBlock;
	protected Block brickWallBlock;
	protected int brickWallMeta;
	protected Block pillarBlock;
	protected int pillarMeta;
	protected Block floorBlock;
	protected int floorMeta;
	protected Block plankBlock;
	protected int plankMeta;
	protected Block plankSlabBlock;
	protected int plankSlabMeta;
	protected Block plankStairBlock;
	protected Block fenceBlock;
	protected int fenceMeta;
	protected Block fenceGateBlock;
	protected Block woodBlock;
	protected int woodMeta;
	protected Block woodBeamBlock;
	protected int woodBeamMeta;
	protected Block doorBlock;
	protected Block trapdoorBlock;
	protected Block roofBlock;
	protected int roofMeta;
	protected Block roofSlabBlock;
	protected int roofSlabMeta;
	protected Block roofStairBlock;
	protected Block barsBlock;
	protected Block plateBlock;

	public LOTRWorldGenDaleStructure(boolean flag) {
		super(flag);
	}

	@Override
	protected void setupRandomBlocks(Random random) {
		brickBlock = WOTRMCNewBlocks.dalebrickaligned;
		brickMeta = 0;
		brickSlabBlock = LOTRMod.slabSingle9;
		brickSlabMeta = 6;
		brickStairBlock = WOTRMCNewBlocks.dalebrickalignedStairs;
		brickWallBlock = LOTRMod.wall3;
		brickWallMeta = 9;
		pillarBlock = LOTRMod.pillar2;
		pillarMeta = 5;
		floorBlock = Blocks.cobblestone;
		floorMeta = 0;
		int randomWood = random.nextInt(3);
		switch (randomWood) {
		case 0:
			plankBlock = Blocks.planks;
			plankMeta = 1;
			plankSlabBlock = Blocks.wooden_slab;
			plankSlabMeta = 1;
			plankStairBlock = Blocks.spruce_stairs;
			fenceBlock = Blocks.fence;
			fenceMeta = 0;
			fenceGateBlock = Blocks.fence_gate;
			woodBlock = Blocks.log;
			woodMeta = 0;
			woodBeamBlock = LOTRMod.woodBeamV1;
			woodBeamMeta = 0;
			doorBlock = LOTRMod.doorSpruce;
			trapdoorBlock = LOTRMod.trapdoorSpruce;
			break;
		case 1:
			plankBlock = LOTRMod.planks2;
			plankMeta = 4;
			plankSlabBlock = LOTRMod.woodSlabSingle3;
			plankSlabMeta = 4;
			plankStairBlock = LOTRMod.stairsPine;
			fenceBlock = LOTRMod.fence2;
			fenceMeta = 4;
			fenceGateBlock = LOTRMod.fenceGatePine;
			woodBlock = LOTRMod.wood5;
			woodMeta = 0;
			woodBeamBlock = LOTRMod.woodBeam5;
			woodBeamMeta = 0;
			doorBlock = LOTRMod.doorPine;
			trapdoorBlock = LOTRMod.trapdoorPine;
			break;
		case 2:
			plankBlock = LOTRMod.planks2;
			plankMeta = 3;
			plankSlabBlock = LOTRMod.woodSlabSingle3;
			plankSlabMeta = 3;
			plankStairBlock = LOTRMod.stairsFir;
			fenceBlock = LOTRMod.fence2;
			fenceMeta = 3;
			fenceGateBlock = LOTRMod.fenceGateFir;
			woodBlock = LOTRMod.wood4;
			woodMeta = 3;
			woodBeamBlock = LOTRMod.woodBeam4;
			woodBeamMeta = 3;
			doorBlock = LOTRMod.doorFir;
			trapdoorBlock = LOTRMod.trapdoorFir;
			break;
		default:
			break;
		}
		int randomClay = random.nextInt(4);
		if (randomClay == 0) {
			roofBlock = LOTRMod.clayTileDyed;
			roofMeta = 1;
			roofSlabBlock = LOTRMod.slabClayTileDyedSingle;
			roofSlabMeta = 1;
			roofStairBlock = LOTRMod.stairsClayTileDyedOrange;
		} else if (randomClay == 1) {
			roofBlock = LOTRMod.clayTileDyed;
			roofMeta = 14;
			roofSlabBlock = LOTRMod.slabClayTileDyedSingle2;
			roofSlabMeta = 6;
			roofStairBlock = LOTRMod.stairsClayTileDyedRed;
		} else if (randomClay == 2) {
			roofBlock = LOTRMod.clayTileDyed;
			roofMeta = 12;
			roofSlabBlock = LOTRMod.slabClayTileDyedSingle2;
			roofSlabMeta = 4;
			roofStairBlock = LOTRMod.stairsClayTileDyedBrown;
		} else if (randomClay == 3) {
			roofBlock = LOTRMod.clayTileDyed;
			roofMeta = 11;
			roofSlabBlock = LOTRMod.slabClayTileDyedSingle2;
			roofSlabMeta = 3;
			roofStairBlock = LOTRMod.stairsClayTileDyedBlue;
		}
		barsBlock = random.nextInt(3) == 0 ? Blocks.iron_bars : LOTRMod.bronzeBars;
		plateBlock = random.nextBoolean() ? random.nextBoolean() ? LOTRMod.plateBlock : LOTRMod.ceramicPlateBlock : LOTRMod.woodPlateBlock;
	}
}