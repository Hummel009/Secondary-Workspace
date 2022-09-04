package bd.structure;

import java.util.Random;

import bd.database.BDRegistry;
import lotr.common.LOTRMod;
import lotr.common.world.structure2.LOTRWorldGenStructureBase2;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public abstract class BDStructureKhandStructure extends LOTRWorldGenStructureBase2 {
	protected Block brickBlock;
	protected int brickMeta;
	protected Block brickSlabBlock;
	protected int brickSlabMeta;
	protected Block brickStairBlock;
	protected Block brickWallBlock;
	protected int brickWallMeta;
	protected Block brick2Block;
	protected int brick2Meta;
	protected Block woodBlock;
	protected int woodMeta;
	protected Block plankBlock;
	protected int plankMeta;
	protected Block plankSlabBlock;
	protected int plankSlabMeta;
	protected Block plankStairBlock;
	protected Block fenceBlock;
	protected int fenceMeta;
	protected Block fenceGateBlock;
	protected Block doorBlock;
	protected Block trapdoorBlock;
	protected Block beamBlock;
	protected int beamMeta;
	protected Block plank2Block;
	protected int plank2Meta;
	protected Block plank2SlabBlock;
	protected int plank2SlabMeta;
	protected Block plank2StairBlock;
	protected Block beam2Block;
	protected int beam2Meta;
	protected Block roofBlock;
	protected int roofMeta;
	protected Block roofSlabBlock;
	protected int roofSlabMeta;
	protected Block roofStairBlock;
	protected Block flagBlock;
	protected int flagMeta;
	protected Block boneBlock;
	protected int boneMeta;
	protected Block boneWallBlock;
	protected int boneWallMeta;
	protected Block bedBlock;

	public BDStructureKhandStructure(boolean flag) {
		super(flag);
	}

	protected boolean canUseRedBrick() {
		return true;
	}

	protected ItemStack getRandomKhandWeapon(Random random) {
		ItemStack[] items = { new ItemStack(BDRegistry.khand1_sword), new ItemStack(BDRegistry.khand1_sword), new ItemStack(BDRegistry.khand1_dagger), new ItemStack(BDRegistry.khand1_spear), new ItemStack(BDRegistry.khand1_hammer) };
		return items[random.nextInt(items.length)].copy();
	}

	@Override
	protected void setupRandomBlocks(Random random) {
		super.setupRandomBlocks(random);
		if (canUseRedBrick() && random.nextInt(3) == 0) {
			brickBlock = LOTRMod.brick3;
			brickMeta = 13;
			brickSlabBlock = LOTRMod.slabSingle7;
			brickSlabMeta = 2;
			brickStairBlock = LOTRMod.stairsNearHaradBrickRed;
			brickWallBlock = LOTRMod.wall3;
			brickWallMeta = 4;
		} else {
			brickBlock = LOTRMod.brick;
			brickMeta = 15;
			brickSlabBlock = LOTRMod.slabSingle4;
			brickSlabMeta = 0;
			brickStairBlock = LOTRMod.stairsNearHaradBrick;
			brickWallBlock = LOTRMod.wall;
			brickWallMeta = 15;
		}
		brick2Block = LOTRMod.brick3;
		brick2Meta = 13;
		if (random.nextInt(5) == 0) {
			woodBlock = LOTRMod.wood9;
			woodMeta = 0;
			plankBlock = LOTRMod.planks3;
			plankMeta = 4;
			plankSlabBlock = LOTRMod.woodSlabSingle5;
			plankSlabMeta = 4;
			plankStairBlock = LOTRMod.stairsDragon;
			fenceBlock = LOTRMod.fence3;
			fenceMeta = 4;
			fenceGateBlock = LOTRMod.fenceGateDragon;
			doorBlock = LOTRMod.doorDragon;
			trapdoorBlock = LOTRMod.trapdoorDragon;
			beamBlock = LOTRMod.woodBeam9;
			beamMeta = 0;
		} else {
			woodBlock = LOTRMod.wood8;
			woodMeta = 3;
			plankBlock = LOTRMod.planks3;
			plankMeta = 3;
			plankSlabBlock = LOTRMod.woodSlabSingle5;
			plankSlabMeta = 3;
			plankStairBlock = LOTRMod.stairsPalm;
			fenceBlock = LOTRMod.fence3;
			fenceMeta = 3;
			fenceGateBlock = LOTRMod.fenceGatePalm;
			doorBlock = LOTRMod.doorPalm;
			trapdoorBlock = LOTRMod.trapdoorPalm;
			beamBlock = LOTRMod.woodBeam8;
			beamMeta = 3;
		}
		int randomWood2 = random.nextInt(3);
		switch (randomWood2) {
		case 0:
			plank2Block = Blocks.planks;
			plank2Meta = 4;
			plank2SlabBlock = Blocks.wooden_slab;
			plank2SlabMeta = 4;
			plank2StairBlock = Blocks.acacia_stairs;
			beam2Block = LOTRMod.woodBeamV2;
			beam2Meta = 0;
			break;
		case 1:
			plank2Block = LOTRMod.planks;
			plank2Meta = 14;
			plank2SlabBlock = LOTRMod.woodSlabSingle2;
			plank2SlabMeta = 6;
			plank2StairBlock = LOTRMod.stairsDatePalm;
			beam2Block = LOTRMod.woodBeam4;
			beam2Meta = 2;
			break;
		case 2:
			plank2Block = LOTRMod.planks3;
			plank2Meta = 4;
			plank2SlabBlock = LOTRMod.woodSlabSingle5;
			plank2SlabMeta = 4;
			plank2StairBlock = LOTRMod.stairsDragon;
			beam2Block = LOTRMod.woodBeam9;
			beam2Meta = 0;
			break;
		default:
			break;
		}
		roofBlock = LOTRMod.thatch;
		roofMeta = 1;
		roofSlabBlock = LOTRMod.slabSingleThatch;
		roofSlabMeta = 1;
		roofStairBlock = LOTRMod.stairsReed;
		flagBlock = Blocks.wool;
		flagMeta = 14;
		boneBlock = LOTRMod.boneBlock;
		boneMeta = 0;
		boneWallBlock = LOTRMod.wallBone;
		boneWallMeta = 0;
		bedBlock = LOTRMod.strawBed;
	}
}
