package bd.structure;

import java.util.Random;

import bd.database.WOTRMCNewBlocks;
import bd.entity.*;
import lotr.common.*;
import lotr.common.entity.LOTREntityNPCRespawner;
import lotr.common.item.LOTRItemBanner;
import lotr.common.world.structure2.LOTRWorldGenStructureBase2;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BDStructureEregionTower extends LOTRWorldGenStructureBase2 {
	protected Block brickBlock = LOTRMod.brick3;
	protected int brickMeta = 2;
	protected Block brickSlabBlock = LOTRMod.slabSingle5;
	protected int brickSlabMeta = 5;
	protected Block brickStairBlock = WOTRMCNewBlocks.avariSquareStairs;
	protected Block brickWallBlock = LOTRMod.wall2;
	protected int brickWallMeta = 11;
	protected Block pillarBlock = LOTRMod.pillar;
	protected int pillarMeta = 10;
	protected Block floorBlock = Blocks.double_stone_slab;
	protected int floorMeta = 0;
	protected Block roofBlock = LOTRMod.clayTileDyed;
	protected int roofMeta = 5;
	protected Block roofSlabBlock = LOTRMod.slabClayTileDyedSingle;
	protected int roofSlabMeta = 5;
	protected Block roofStairBlock = LOTRMod.stairsClayTileDyedLime;
	protected Block plankBlock = Blocks.planks;
	protected int plankMeta = 2;
	protected Block plankSlabBlock = Blocks.wooden_slab;
	protected int plankSlabMeta = 2;
	protected Block plankStairBlock = Blocks.birch_stairs;
	protected Block fenceBlock = Blocks.fence;
	protected int fenceMeta = 2;
	protected Block plateBlock = LOTRMod.plateBlock;
	protected Block leafBlock = Blocks.leaves;
	protected int leafMeta = 6;

	public BDStructureEregionTower(boolean flag) {
		super(flag);
	}

	@Override
	public boolean generateWithSetRotation(World world, Random random, int i, int j, int k, int rotation) {
		int i1;
		int k1;
		int i12;
		int k12;
		int k132;
		int i2;
		int j1;
		int k2;
		int j12;
		int i13;
		int k14;
		int i14;
		int i15;
		int distSq;
		int i22;
		int k15;
		int i16;
		int radius = 7;
		int radiusPlusOne = radius + 1;
		int sections = 2 + random.nextInt(3);
		int sectionHeight = 8;
		this.setOriginAndRotation(world, i, j, k, rotation, radius + 3);
		double radiusD = radius - 0.5;
		double radiusDPlusOne = radiusD + 1.0;
		int wallThresholdMin = (int) (radiusD * radiusD);
		int wallThresholdMax = (int) (radiusDPlusOne * radiusDPlusOne);
		if (restrictions) {
			int minHeight = 0;
			int maxHeight = 0;
			for (int i17 = -radiusPlusOne; i17 <= radiusPlusOne; ++i17) {
				for (k132 = -radiusPlusOne; k132 <= radiusPlusOne; ++k132) {
					distSq = i17 * i17 + k132 * k132;
					if (distSq >= wallThresholdMax) {
						continue;
					}
					j12 = getTopBlock(world, i17, k132) - 1;
					if (!isSurface(world, i17, j12, k132)) {
						return false;
					}
					if (j12 < minHeight) {
						minHeight = j12;
					}
					if (j12 > maxHeight) {
						maxHeight = j12;
					}
					if (maxHeight - minHeight <= 16) {
						continue;
					}
					return false;
				}
			}
		}
		for (i15 = -radius; i15 <= radius; ++i15) {
			for (k1 = -radius; k1 <= radius; ++k1) {
				i22 = Math.abs(i15);
				k2 = Math.abs(k1);
				distSq = i15 * i15 + k1 * k1;
				if (distSq >= wallThresholdMax) {
					continue;
				}
				layFoundation(world, i15, k1);
				if (distSq >= wallThresholdMin) {
					setBlockAndMetadata(world, i15, 1, k1, pillarBlock, pillarMeta);
					for (j12 = 2; j12 <= 6; ++j12) {
						if (i22 == 5 && k2 == 5 || i22 == radius && k2 == 2 || k2 == radius && i22 == 2) {
							setBlockAndMetadata(world, i15, j12, k1, pillarBlock, pillarMeta);
							continue;
						}
						setBlockAndMetadata(world, i15, j12, k1, brickBlock, brickMeta);
					}
					setBlockAndMetadata(world, i15, 7, k1, pillarBlock, pillarMeta);
					continue;
				}
				setBlockAndMetadata(world, i15, 1, k1, brickBlock, brickMeta);
				for (j12 = 2; j12 <= 6; ++j12) {
					setAir(world, i15, j12, k1);
				}
				setBlockAndMetadata(world, i15, 7, k1, brickBlock, brickMeta);
			}
		}
		for (i15 = -4; i15 <= 4; ++i15) {
			for (k1 = -4; k1 <= 4; ++k1) {
				i22 = Math.abs(i15);
				k2 = Math.abs(k1);
				if (i22 == 4 || k2 == 4) {
					setBlockAndMetadata(world, i15, 1, k1, floorBlock, floorMeta);
					continue;
				}
				setBlockAndMetadata(world, i15, 1, k1, pillarBlock, pillarMeta);
			}
		}
		for (i15 = -1; i15 <= 1; ++i15) {
			for (int j13 = 2; j13 <= 4; ++j13) {
				setBlockAndMetadata(world, i15, j13, -radius, LOTRMod.gateHighElven, 2);
			}
			for (k1 = -radius; k1 <= -4; ++k1) {
				setBlockAndMetadata(world, i15, 1, k1, pillarBlock, pillarMeta);
			}
		}
		for (int k16 = -6; k16 <= -5; ++k16) {
			setBlockAndMetadata(world, -2, 1, k16, floorBlock, floorMeta);
			setBlockAndMetadata(world, 2, 1, k16, floorBlock, floorMeta);
		}
		setBlockAndMetadata(world, 0, 1, -radius - 1, brickBlock, brickMeta);
		layFoundation(world, 0, -radius - 1);
		setBlockAndMetadata(world, 0, 1, -radius - 2, brickStairBlock, 2);
		setBlockAndMetadata(world, -1, 1, -radius - 1, brickStairBlock, 2);
		setBlockAndMetadata(world, 1, 1, -radius - 1, brickStairBlock, 2);
		layFoundation(world, 0, -radius - 2);
		layFoundation(world, -1, -radius - 1);
		layFoundation(world, 1, -radius - 1);
		setBlockAndMetadata(world, -2, 1, -radius - 1, brickStairBlock, 1);
		setBlockAndMetadata(world, -1, 1, -radius - 2, brickStairBlock, 1);
		setBlockAndMetadata(world, 1, 1, -radius - 2, brickStairBlock, 0);
		setBlockAndMetadata(world, 2, 1, -radius - 1, brickStairBlock, 0);
		layFoundation(world, -2, -radius - 1);
		layFoundation(world, -1, -radius - 2);
		layFoundation(world, 1, -radius - 2);
		layFoundation(world, 2, -radius - 1);
		for (int i18 : new int[] { -radius + 1, radius - 1 }) {
			setBlockAndMetadata(world, i18, 2, -2, plankStairBlock, 7);
			setBlockAndMetadata(world, i18, 2, 2, plankStairBlock, 6);
			for (int k17 = -1; k17 <= 1; ++k17) {
				setBlockAndMetadata(world, i18, 2, k17, plankSlabBlock, plankSlabMeta | 8);
			}
		}
		setBlockAndMetadata(world, -2, 2, radius - 1, plankStairBlock, 4);
		setBlockAndMetadata(world, 2, 2, radius - 1, plankStairBlock, 5);
		for (int i19 = -1; i19 <= 1; ++i19) {
			setBlockAndMetadata(world, i19, 2, radius - 1, plankSlabBlock, plankSlabMeta | 8);
		}
		for (int i18 : new int[] { -radius + 2, radius - 2 }) {
			setBlockAndMetadata(world, i18, 2, -4, plankStairBlock, 7);
			setBlockAndMetadata(world, i18, 2, -3, plankStairBlock, 6);
			setBlockAndMetadata(world, i18, 2, 3, plankStairBlock, 7);
			setBlockAndMetadata(world, i18, 2, 4, plankStairBlock, 6);
		}
		int[] i19 = { -radius + 2, radius - 2 };
		k1 = i19.length;
		for (i22 = 0; i22 < k1; ++i22) {
			k132 = i19[i22];
			setBlockAndMetadata(world, -4, 2, k132, plankStairBlock, 4);
			setBlockAndMetadata(world, -3, 2, k132, plankStairBlock, 5);
			setBlockAndMetadata(world, 3, 2, k132, plankStairBlock, 4);
			setBlockAndMetadata(world, 4, 2, k132, plankStairBlock, 5);
		}
		for (i14 = -radius; i14 <= radius; ++i14) {
			for (k1 = -radius; k1 <= radius; ++k1) {
				i22 = Math.abs(i14);
				k2 = Math.abs(k1);
				if ((i22 == radius - 1 && k2 <= 2 || k1 == radius - 1 && i22 <= 2 || i22 == radius - 2 && k2 >= 3 && k2 <= 4 || k2 == radius - 2 && i22 >= 3 && i22 <= 4) && random.nextInt(3) == 0) {
					if (random.nextInt(3) == 0) {
						this.placeMug(world, random, i14, 3, k1, random.nextInt(4), LOTRFoods.ELF_DRINK);
					} else {
						placePlate(world, random, i14, 3, k1, plateBlock, LOTRFoods.ELF);
					}
				}
				if (k1 == -radius + 1 && i22 == 2) {
					for (int j14 = 2; j14 <= 4; ++j14) {
						setBlockAndMetadata(world, i14, j14, k1, brickWallBlock, brickWallMeta);
					}
					setBlockAndMetadata(world, i14, 5, k1, LOTRMod.highElvenTorch, 5);
				}
				if (i22 == radius && k2 == 0 || k1 == radius && i22 == 0) {
					setBlockAndMetadata(world, i14, 3, k1, LOTRMod.highElfWoodBars, 0);
					setBlockAndMetadata(world, i14, 4, k1, LOTRMod.highElfWoodBars, 0);
				}
				if ((i22 != radius - 1 || k2 != 1) && (k1 != radius - 1 || i22 != 1)) {
					continue;
				}
				setBlockAndMetadata(world, i14, 4, k1, fenceBlock, fenceMeta);
				setBlockAndMetadata(world, i14, 5, k1, LOTRMod.highElvenTorch, 5);
			}
		}
		for (i14 = -2; i14 <= 2; ++i14) {
			setBlockAndMetadata(world, i14, 6, -radius + 1, brickStairBlock, 7);
			setBlockAndMetadata(world, i14, 6, radius - 1, brickStairBlock, 6);
		}
		for (int k18 = -2; k18 <= 2; ++k18) {
			setBlockAndMetadata(world, -radius + 1, 6, k18, brickStairBlock, 4);
			setBlockAndMetadata(world, radius - 1, 6, k18, brickStairBlock, 5);
		}
		for (i14 = -4; i14 <= -3; ++i14) {
			setBlockAndMetadata(world, i14, 6, -radius + 2, brickStairBlock, 7);
			setBlockAndMetadata(world, i14, 6, radius - 2, brickStairBlock, 6);
		}
		for (i14 = 3; i14 <= 4; ++i14) {
			setBlockAndMetadata(world, i14, 6, -radius + 2, brickStairBlock, 7);
			setBlockAndMetadata(world, i14, 6, radius - 2, brickStairBlock, 6);
		}
		setBlockAndMetadata(world, -radius + 2, 6, -4, brickStairBlock, 7);
		setBlockAndMetadata(world, -radius + 2, 6, -3, brickStairBlock, 4);
		setBlockAndMetadata(world, radius - 2, 6, -4, brickStairBlock, 7);
		setBlockAndMetadata(world, radius - 2, 6, -3, brickStairBlock, 5);
		setBlockAndMetadata(world, -radius + 2, 6, 3, brickStairBlock, 4);
		setBlockAndMetadata(world, -radius + 2, 6, 4, brickStairBlock, 6);
		setBlockAndMetadata(world, radius - 2, 6, 3, brickStairBlock, 5);
		setBlockAndMetadata(world, radius - 2, 6, 4, brickStairBlock, 6);
		for (int k1321 : new int[] { -radius + 2, radius - 2 }) {
			setBlockAndMetadata(world, -2, 6, k1321, brickStairBlock, 4);
			setBlockAndMetadata(world, 2, 6, k1321, brickStairBlock, 5);
		}
		for (int i18 : new int[] { -radius + 2, radius - 2 }) {
			setBlockAndMetadata(world, i18, 6, -2, brickStairBlock, 7);
			setBlockAndMetadata(world, i18, 6, 2, brickStairBlock, 6);
		}
		for (int k1321 : new int[] { -4, 4 }) {
			setBlockAndMetadata(world, -4, 6, k1321, brickStairBlock, 4);
			setBlockAndMetadata(world, 4, 6, k1321, brickStairBlock, 5);
		}
		for (i12 = -2; i12 <= 2; ++i12) {
			setBlockAndMetadata(world, i12, 8, -radius, roofStairBlock, 2);
			setBlockAndMetadata(world, i12, 8, radius, roofStairBlock, 3);
		}
		for (int k19 = -2; k19 <= 2; ++k19) {
			setBlockAndMetadata(world, -radius, 8, k19, roofStairBlock, 1);
			setBlockAndMetadata(world, radius, 8, k19, roofStairBlock, 0);
		}
		for (i12 = -4; i12 <= -3; ++i12) {
			setBlockAndMetadata(world, i12, 8, -radius + 1, roofStairBlock, 2);
			setBlockAndMetadata(world, i12, 8, radius - 1, roofStairBlock, 3);
		}
		for (i12 = 3; i12 <= 4; ++i12) {
			setBlockAndMetadata(world, i12, 8, -radius + 1, roofStairBlock, 2);
			setBlockAndMetadata(world, i12, 8, radius - 1, roofStairBlock, 3);
		}
		setBlockAndMetadata(world, -radius + 1, 8, -3, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius + 1, 8, 3, roofStairBlock, 1);
		setBlockAndMetadata(world, radius - 1, 8, -3, roofStairBlock, 0);
		setBlockAndMetadata(world, radius - 1, 8, 3, roofStairBlock, 0);
		setBlockAndMetadata(world, -radius + 1, 8, -2, roofStairBlock, 2);
		setBlockAndMetadata(world, -radius + 1, 8, -4, roofStairBlock, 2);
		setBlockAndMetadata(world, -radius + 2, 8, -5, roofStairBlock, 2);
		setBlockAndMetadata(world, radius - 1, 8, -2, roofStairBlock, 2);
		setBlockAndMetadata(world, radius - 1, 8, -4, roofStairBlock, 2);
		setBlockAndMetadata(world, radius - 2, 8, -5, roofStairBlock, 2);
		setBlockAndMetadata(world, -radius + 1, 8, 2, roofStairBlock, 3);
		setBlockAndMetadata(world, -radius + 1, 8, 4, roofStairBlock, 3);
		setBlockAndMetadata(world, -radius + 2, 8, 5, roofStairBlock, 3);
		setBlockAndMetadata(world, radius - 1, 8, 2, roofStairBlock, 3);
		setBlockAndMetadata(world, radius - 1, 8, 4, roofStairBlock, 3);
		setBlockAndMetadata(world, radius - 2, 8, 5, roofStairBlock, 3);
		setBlockAndMetadata(world, -radius + 2, 8, -4, roofStairBlock, 1);
		setBlockAndMetadata(world, -4, 8, -radius + 2, roofStairBlock, 1);
		setBlockAndMetadata(world, -2, 8, -radius + 1, roofStairBlock, 1);
		setBlockAndMetadata(world, radius - 2, 8, -4, roofStairBlock, 0);
		setBlockAndMetadata(world, 4, 8, -radius + 2, roofStairBlock, 0);
		setBlockAndMetadata(world, 2, 8, -radius + 1, roofStairBlock, 0);
		setBlockAndMetadata(world, -radius + 2, 8, 4, roofStairBlock, 1);
		setBlockAndMetadata(world, -4, 8, radius - 2, roofStairBlock, 1);
		setBlockAndMetadata(world, -2, 8, radius - 1, roofStairBlock, 1);
		setBlockAndMetadata(world, radius - 2, 8, 4, roofStairBlock, 0);
		setBlockAndMetadata(world, 4, 8, radius - 2, roofStairBlock, 0);
		setBlockAndMetadata(world, 2, 8, radius - 1, roofStairBlock, 0);
		int sRadius = radius - 1;
		double sRadiusD = sRadius - 0.7;
		double sRadiusDPlusOne = sRadiusD + 1.0;
		int sWallThresholdMin = (int) (sRadiusD * sRadiusD);
		int sWallThresholdMax = (int) (sRadiusDPlusOne * sRadiusDPlusOne);
		for (int l = 0; l < sections; ++l) {
			int i110;
			int sectionBase = 7 + l * sectionHeight;
			for (i110 = -sRadius; i110 <= sRadius; ++i110) {
				for (k15 = -sRadius; k15 <= sRadius; ++k15) {
					int i23 = Math.abs(i110);
					int k22 = Math.abs(k15);
					int distSq2 = i110 * i110 + k15 * k15;
					if (distSq2 < sWallThresholdMax) {
						for (int j15 = sectionBase + 1; j15 <= sectionBase + sectionHeight; ++j15) {
							if (distSq2 >= sWallThresholdMin) {
								if (i23 == 4 && k22 == 4 || i23 == sRadius && k22 == 1 || k22 == sRadius && i23 == 1) {
									setBlockAndMetadata(world, i110, j15, k15, pillarBlock, pillarMeta);
									continue;
								}
								setBlockAndMetadata(world, i110, j15, k15, brickBlock, brickMeta);
								continue;
							}
							if (j15 == sectionBase + sectionHeight) {
								setBlockAndMetadata(world, i110, j15, k15, brickBlock, brickMeta);
								continue;
							}
							setAir(world, i110, j15, k15);
						}
					}
					if (i23 == 0 && k22 == sRadius || k22 == 0 && i23 == sRadius) {
						setBlockAndMetadata(world, i110, sectionBase + 1, k15, pillarBlock, pillarMeta);
						setBlockAndMetadata(world, i110, sectionBase + 3, k15, LOTRMod.highElfWoodBars, 0);
						setBlockAndMetadata(world, i110, sectionBase + 4, k15, LOTRMod.highElfWoodBars, 0);
						setBlockAndMetadata(world, i110, sectionBase + 6, k15, pillarBlock, pillarMeta);
					}
					if (i23 == 1 && k22 == sRadius - 1 || k22 == 1 && i23 == sRadius - 1) {
						setBlockAndMetadata(world, i110, sectionBase + 4, k15, fenceBlock, fenceMeta);
						setBlockAndMetadata(world, i110, sectionBase + 5, k15, LOTRMod.highElvenTorch, 5);
					}
					if ((i23 != 3 || k22 != 4) && (k22 != 3 || i23 != 4)) {
						continue;
					}
					setBlockAndMetadata(world, i110, sectionBase + 1, k15, plankBlock, plankMeta);
					if (random.nextInt(4) == 0) {
						if (random.nextBoolean()) {
							this.placeMug(world, random, i110, sectionBase + 2, k15, random.nextInt(4), LOTRFoods.ELF_DRINK);
						} else {
							placePlate(world, random, i110, sectionBase + 2, k15, plateBlock, LOTRFoods.ELF);
						}
					}
					setBlockAndMetadata(world, i110, sectionBase + 6, k15, fenceBlock, fenceMeta);
					setBlockAndMetadata(world, i110, sectionBase + 7, k15, leafBlock, leafMeta);
				}
			}
			for (i110 = -1; i110 <= 1; ++i110) {
				setBlockAndMetadata(world, i110, sectionBase + 1, -sRadius + 1, brickStairBlock, 3);
				setBlockAndMetadata(world, i110, sectionBase + 1, sRadius - 1, brickStairBlock, 2);
				setBlockAndMetadata(world, i110, sectionBase + 7, -sRadius + 1, plankStairBlock, 7);
				setBlockAndMetadata(world, i110, sectionBase + 7, sRadius - 1, plankStairBlock, 6);
			}
			for (int k110 = -1; k110 <= 1; ++k110) {
				setBlockAndMetadata(world, -sRadius + 1, sectionBase + 1, k110, brickStairBlock, 0);
				setBlockAndMetadata(world, sRadius - 1, sectionBase + 1, k110, brickStairBlock, 1);
				setBlockAndMetadata(world, -sRadius + 1, sectionBase + 7, k110, plankStairBlock, 4);
				setBlockAndMetadata(world, sRadius - 1, sectionBase + 7, k110, plankStairBlock, 5);
			}
			setBlockAndMetadata(world, -sRadius, sectionBase + 2, 0, brickStairBlock, 0);
			setBlockAndMetadata(world, sRadius, sectionBase + 2, 0, brickStairBlock, 1);
			setBlockAndMetadata(world, 0, sectionBase + 2, -sRadius, brickStairBlock, 3);
			setBlockAndMetadata(world, 0, sectionBase + 2, sRadius, brickStairBlock, 2);
			setBlockAndMetadata(world, -sRadius, sectionBase + 5, 0, brickStairBlock, 4);
			setBlockAndMetadata(world, sRadius, sectionBase + 5, 0, brickStairBlock, 5);
			setBlockAndMetadata(world, 0, sectionBase + 5, -sRadius, brickStairBlock, 7);
			setBlockAndMetadata(world, 0, sectionBase + 5, sRadius, brickStairBlock, 6);
			BDEntityEregionWarrior warrior = new BDEntityEregionWarrior(world);
			warrior.spawnRidingHorse = false;
			spawnNPCAndSetHome(warrior, world, 3, sectionBase + 1, 0, 16);
		}
		int sectionTopHeight = 7 + sections * sectionHeight;
		for (int j16 = 2; j16 <= sectionTopHeight; ++j16) {
			int j2;
			int i111;
			setBlockAndMetadata(world, 0, j16, 0, pillarBlock, pillarMeta);
			int step = (j16 + 2) % 4;
			switch (step) {
			case 0:
				for (i111 = -2; i111 <= -1; ++i111) {
					setBlockAndMetadata(world, i111, j16, 0, brickSlabBlock, brickSlabMeta);
					setBlockAndMetadata(world, i111, j16, 1, brickSlabBlock, brickSlabMeta | 8);
					setBlockAndMetadata(world, i111, j16, 2, brickSlabBlock, brickSlabMeta | 8);
					for (j2 = j16 + 1; j2 <= j16 + 3; ++j2) {
						setAir(world, i111, j2, 0);
						setAir(world, i111, j2, 1);
						setAir(world, i111, j2, 2);
					}
				}
				setBlockAndMetadata(world, 0, j16, 1, LOTRMod.highElvenTorch, 3);
				continue;
			case 1:
				for (k15 = 1; k15 <= 2; ++k15) {
					setBlockAndMetadata(world, 0, j16, k15, brickSlabBlock, brickSlabMeta);
					setBlockAndMetadata(world, 1, j16, k15, brickSlabBlock, brickSlabMeta | 8);
					setBlockAndMetadata(world, 2, j16, k15, brickSlabBlock, brickSlabMeta | 8);
					for (j2 = j16 + 1; j2 <= j16 + 3; ++j2) {
						setAir(world, 0, j2, k15);
						setAir(world, 1, j2, k15);
						setAir(world, 2, j2, k15);
					}
				}
				continue;
			case 2:
				for (i111 = 1; i111 <= 2; ++i111) {
					setBlockAndMetadata(world, i111, j16, 0, brickSlabBlock, brickSlabMeta);
					setBlockAndMetadata(world, i111, j16, -1, brickSlabBlock, brickSlabMeta | 8);
					setBlockAndMetadata(world, i111, j16, -2, brickSlabBlock, brickSlabMeta | 8);
					for (j2 = j16 + 1; j2 <= j16 + 3; ++j2) {
						setAir(world, i111, j2, 0);
						setAir(world, i111, j2, -1);
						setAir(world, i111, j2, -2);
					}
				}
				setBlockAndMetadata(world, 0, j16, -1, LOTRMod.highElvenTorch, 4);
				continue;
			default:
				break;
			}
			if (step != 3) {
				continue;
			}
			for (k15 = -2; k15 <= -1; ++k15) {
				setBlockAndMetadata(world, 0, j16, k15, brickSlabBlock, brickSlabMeta);
				setBlockAndMetadata(world, -1, j16, k15, brickSlabBlock, brickSlabMeta | 8);
				setBlockAndMetadata(world, -2, j16, k15, brickSlabBlock, brickSlabMeta | 8);
				for (j2 = j16 + 1; j2 <= j16 + 3; ++j2) {
					setAir(world, 0, j2, k15);
					setAir(world, -1, j2, k15);
					setAir(world, -2, j2, k15);
				}
			}
		}
		for (i13 = -radius; i13 <= radius; ++i13) {
			for (int k111 = -radius; k111 <= radius; ++k111) {
				int j17;
				i2 = Math.abs(i13);
				int k23 = Math.abs(k111);
				int distSq3 = i13 * i13 + k111 * k111;
				if (distSq3 >= wallThresholdMax) {
					continue;
				}
				if (distSq3 >= wallThresholdMin) {
					setBlockAndMetadata(world, i13, sectionTopHeight + 1, k111, pillarBlock, pillarMeta);
					for (j17 = sectionTopHeight + 2; j17 <= sectionTopHeight + 5; ++j17) {
						if (i2 == 5 && k23 == 5 || i2 == radius && k23 == 2 || k23 == radius && i2 == 2) {
							setBlockAndMetadata(world, i13, j17, k111, pillarBlock, pillarMeta);
							continue;
						}
						setBlockAndMetadata(world, i13, j17, k111, brickBlock, brickMeta);
					}
					setBlockAndMetadata(world, i13, sectionTopHeight + 6, k111, pillarBlock, pillarMeta);
					setBlockAndMetadata(world, i13, sectionTopHeight + 7, k111, roofBlock, roofMeta);
					setBlockAndMetadata(world, i13, sectionTopHeight + 8, k111, roofBlock, roofMeta);
				} else {
					for (j17 = sectionTopHeight + 1; j17 <= sectionTopHeight + 6; ++j17) {
						setAir(world, i13, j17, k111);
					}
				}
				if (i2 == 2 && k23 == radius - 1 || k23 == 2 && i2 == radius - 1) {
					setBlockAndMetadata(world, i13, sectionTopHeight + 4, k111, fenceBlock, fenceMeta);
					setBlockAndMetadata(world, i13, sectionTopHeight + 5, k111, LOTRMod.highElvenTorch, 5);
				}
				if ((((i2 > 1) || (k23 != radius - 1)) && ((k23 > 1) || (i2 != radius - 1)) && ((i2 < 3) || (i2 > 4) || (k23 != radius - 2))) && (k23 < 3 || k23 > 4 || i2 != radius - 2)) {
					continue;
				}
				setBlockAndMetadata(world, i13, sectionTopHeight + 6, k111, fenceBlock, fenceMeta);
				setBlockAndMetadata(world, i13, sectionTopHeight + 7, k111, leafBlock, leafMeta);
			}
		}
		setBlockAndMetadata(world, 0, sectionTopHeight + 1, 0, pillarBlock, pillarMeta);
		setBlockAndMetadata(world, 0, sectionTopHeight + 2, 0, pillarBlock, pillarMeta);
		setBlockAndMetadata(world, 0, sectionTopHeight + 3, 0, roofSlabBlock, roofSlabMeta);
		for (i13 = -2; i13 <= 2; ++i13) {
			setBlockAndMetadata(world, i13, sectionTopHeight, -radius, roofStairBlock, 6);
			setBlockAndMetadata(world, i13, sectionTopHeight, radius, roofStairBlock, 7);
		}
		for (k14 = -2; k14 <= 2; ++k14) {
			setBlockAndMetadata(world, -radius, sectionTopHeight, k14, roofStairBlock, 5);
			setBlockAndMetadata(world, radius, sectionTopHeight, k14, roofStairBlock, 4);
		}
		for (i13 = -4; i13 <= -3; ++i13) {
			setBlockAndMetadata(world, i13, sectionTopHeight, -radius + 1, roofStairBlock, 6);
			setBlockAndMetadata(world, i13, sectionTopHeight, radius - 1, roofStairBlock, 7);
		}
		for (i13 = 3; i13 <= 4; ++i13) {
			setBlockAndMetadata(world, i13, sectionTopHeight, -radius + 1, roofStairBlock, 6);
			setBlockAndMetadata(world, i13, sectionTopHeight, radius - 1, roofStairBlock, 7);
		}
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight, -3, roofStairBlock, 5);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight, 3, roofStairBlock, 5);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight, -3, roofStairBlock, 4);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight, 3, roofStairBlock, 4);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight, -2, roofStairBlock, 6);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight, -4, roofStairBlock, 6);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight, -5, roofStairBlock, 6);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight, -2, roofStairBlock, 6);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight, -4, roofStairBlock, 6);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight, -5, roofStairBlock, 6);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight, 2, roofStairBlock, 7);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight, 4, roofStairBlock, 7);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight, 5, roofStairBlock, 7);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight, 2, roofStairBlock, 7);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight, 4, roofStairBlock, 7);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight, 5, roofStairBlock, 7);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight, -4, roofStairBlock, 5);
		setBlockAndMetadata(world, -4, sectionTopHeight, -radius + 2, roofStairBlock, 5);
		setBlockAndMetadata(world, -2, sectionTopHeight, -radius + 1, roofStairBlock, 5);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight, -4, roofStairBlock, 4);
		setBlockAndMetadata(world, 4, sectionTopHeight, -radius + 2, roofStairBlock, 4);
		setBlockAndMetadata(world, 2, sectionTopHeight, -radius + 1, roofStairBlock, 4);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight, 4, roofStairBlock, 5);
		setBlockAndMetadata(world, -4, sectionTopHeight, radius - 2, roofStairBlock, 5);
		setBlockAndMetadata(world, -2, sectionTopHeight, radius - 1, roofStairBlock, 5);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight, 4, roofStairBlock, 4);
		setBlockAndMetadata(world, 4, sectionTopHeight, radius - 2, roofStairBlock, 4);
		setBlockAndMetadata(world, 2, sectionTopHeight, radius - 1, roofStairBlock, 4);
		for (i13 = -2; i13 <= 2; ++i13) {
			setBlockAndMetadata(world, i13, sectionTopHeight + 1, -radius + 1, brickStairBlock, 3);
			setBlockAndMetadata(world, i13, sectionTopHeight + 1, radius - 1, brickStairBlock, 2);
		}
		for (k14 = -2; k14 <= 2; ++k14) {
			setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 1, k14, brickStairBlock, 0);
			setBlockAndMetadata(world, radius - 1, sectionTopHeight + 1, k14, brickStairBlock, 1);
		}
		for (i13 = -4; i13 <= -3; ++i13) {
			setBlockAndMetadata(world, i13, sectionTopHeight + 1, -radius + 2, brickStairBlock, 3);
			setBlockAndMetadata(world, i13, sectionTopHeight + 1, radius - 2, brickStairBlock, 2);
		}
		for (i13 = 3; i13 <= 4; ++i13) {
			setBlockAndMetadata(world, i13, sectionTopHeight + 1, -radius + 2, brickStairBlock, 3);
			setBlockAndMetadata(world, i13, sectionTopHeight + 1, radius - 2, brickStairBlock, 2);
		}
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 1, -4, brickStairBlock, 3);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 1, -3, brickStairBlock, 0);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 1, -4, brickStairBlock, 3);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 1, -3, brickStairBlock, 1);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 1, 3, brickStairBlock, 0);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 1, 4, brickStairBlock, 2);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 1, 3, brickStairBlock, 1);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 1, 4, brickStairBlock, 2);
		for (int k112 : new int[] { -radius + 2, radius - 2 }) {
			setBlockAndMetadata(world, -2, sectionTopHeight + 1, k112, brickStairBlock, 0);
			setBlockAndMetadata(world, 2, sectionTopHeight + 1, k112, brickStairBlock, 1);
		}
		for (int i112 : new int[] { -radius + 2, radius - 2 }) {
			setBlockAndMetadata(world, i112, sectionTopHeight + 1, -2, brickStairBlock, 3);
			setBlockAndMetadata(world, i112, sectionTopHeight + 1, 2, brickStairBlock, 2);
		}
		int[] i113 = { -4, 4 };
		int k111 = i113.length;
		for (i2 = 0; i2 < k111; ++i2) {
			int k112;
			k112 = i113[i2];
			setBlockAndMetadata(world, -4, sectionTopHeight + 1, k112, brickStairBlock, 0);
			setBlockAndMetadata(world, 4, sectionTopHeight + 1, k112, brickStairBlock, 1);
		}
		for (i16 = -1; i16 <= 1; ++i16) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 2, -radius, brickStairBlock, 3);
			setBlockAndMetadata(world, i16, sectionTopHeight + 3, -radius, LOTRMod.highElfWoodBars, 0);
			setBlockAndMetadata(world, i16, sectionTopHeight + 4, -radius, LOTRMod.highElfWoodBars, 0);
			setBlockAndMetadata(world, i16, sectionTopHeight + 5, -radius, brickStairBlock, 7);
			setBlockAndMetadata(world, i16, sectionTopHeight + 2, radius, brickStairBlock, 2);
			setBlockAndMetadata(world, i16, sectionTopHeight + 3, radius, LOTRMod.highElfWoodBars, 0);
			setBlockAndMetadata(world, i16, sectionTopHeight + 4, radius, LOTRMod.highElfWoodBars, 0);
			setBlockAndMetadata(world, i16, sectionTopHeight + 5, radius, brickStairBlock, 6);
		}
		for (k12 = -1; k12 <= 1; ++k12) {
			setBlockAndMetadata(world, -radius, sectionTopHeight + 2, k12, brickStairBlock, 0);
			setBlockAndMetadata(world, -radius, sectionTopHeight + 3, k12, LOTRMod.highElfWoodBars, 0);
			setBlockAndMetadata(world, -radius, sectionTopHeight + 4, k12, LOTRMod.highElfWoodBars, 0);
			setBlockAndMetadata(world, -radius, sectionTopHeight + 5, k12, brickStairBlock, 4);
			setBlockAndMetadata(world, radius, sectionTopHeight + 2, k12, brickStairBlock, 1);
			setBlockAndMetadata(world, radius, sectionTopHeight + 3, k12, LOTRMod.highElfWoodBars, 0);
			setBlockAndMetadata(world, radius, sectionTopHeight + 4, k12, LOTRMod.highElfWoodBars, 0);
			setBlockAndMetadata(world, radius, sectionTopHeight + 5, k12, brickStairBlock, 5);
		}
		placeWallBanner(world, -radius + 1, sectionTopHeight + 4, -4, LOTRItemBanner.BannerType.EREGION, 1);
		placeWallBanner(world, -radius + 1, sectionTopHeight + 4, 4, LOTRItemBanner.BannerType.EREGION, 1);
		placeWallBanner(world, radius - 1, sectionTopHeight + 4, -4, LOTRItemBanner.BannerType.EREGION, 3);
		placeWallBanner(world, radius - 1, sectionTopHeight + 4, 4, LOTRItemBanner.BannerType.EREGION, 3);
		for (i16 = -3; i16 <= 3; ++i16) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 7, -radius - 1, roofStairBlock, 2);
			setBlockAndMetadata(world, i16, sectionTopHeight + 7, radius + 1, roofStairBlock, 3);
		}
		for (k12 = -3; k12 <= 3; ++k12) {
			setBlockAndMetadata(world, -radius - 1, sectionTopHeight + 7, k12, roofStairBlock, 1);
			setBlockAndMetadata(world, radius + 1, sectionTopHeight + 7, k12, roofStairBlock, 0);
		}
		setBlockAndMetadata(world, -radius, sectionTopHeight + 7, -3, roofStairBlock, 2);
		setBlockAndMetadata(world, -radius, sectionTopHeight + 7, -4, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius, sectionTopHeight + 7, -radius + 2, roofStairBlock, 2);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 7, -radius + 2, roofStairBlock, 2);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 7, -radius + 1, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 7, -radius + 1, roofStairBlock, 2);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 7, -radius, roofStairBlock, 1);
		setBlockAndMetadata(world, -4, sectionTopHeight + 7, -radius, roofStairBlock, 2);
		setBlockAndMetadata(world, -3, sectionTopHeight + 7, -radius, roofStairBlock, 1);
		setBlockAndMetadata(world, radius, sectionTopHeight + 7, -3, roofStairBlock, 2);
		setBlockAndMetadata(world, radius, sectionTopHeight + 7, -4, roofStairBlock, 0);
		setBlockAndMetadata(world, radius, sectionTopHeight + 7, -radius + 2, roofStairBlock, 2);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 7, -radius + 2, roofStairBlock, 2);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 7, -radius + 1, roofStairBlock, 0);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 7, -radius + 1, roofStairBlock, 2);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 7, -radius, roofStairBlock, 0);
		setBlockAndMetadata(world, 4, sectionTopHeight + 7, -radius, roofStairBlock, 2);
		setBlockAndMetadata(world, 3, sectionTopHeight + 7, -radius, roofStairBlock, 0);
		setBlockAndMetadata(world, -radius, sectionTopHeight + 7, 3, roofStairBlock, 3);
		setBlockAndMetadata(world, -radius, sectionTopHeight + 7, 4, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius, sectionTopHeight + 7, radius - 2, roofStairBlock, 3);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 7, radius - 2, roofStairBlock, 3);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 7, radius - 1, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 7, radius - 1, roofStairBlock, 3);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 7, radius, roofStairBlock, 1);
		setBlockAndMetadata(world, -4, sectionTopHeight + 7, radius, roofStairBlock, 3);
		setBlockAndMetadata(world, -3, sectionTopHeight + 7, radius, roofStairBlock, 1);
		setBlockAndMetadata(world, radius, sectionTopHeight + 7, 3, roofStairBlock, 3);
		setBlockAndMetadata(world, radius, sectionTopHeight + 7, 4, roofStairBlock, 0);
		setBlockAndMetadata(world, radius, sectionTopHeight + 7, radius - 2, roofStairBlock, 3);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 7, radius - 2, roofStairBlock, 3);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 7, radius - 1, roofStairBlock, 0);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 7, radius - 1, roofStairBlock, 3);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 7, radius, roofStairBlock, 0);
		setBlockAndMetadata(world, 4, sectionTopHeight + 7, radius, roofStairBlock, 3);
		setBlockAndMetadata(world, 3, sectionTopHeight + 7, radius, roofStairBlock, 0);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, -4, roofBlock, roofMeta);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 8, -2, roofBlock, roofMeta);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 8, 2, roofBlock, roofMeta);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, 4, roofBlock, roofMeta);
		setBlockAndMetadata(world, -4, sectionTopHeight + 8, radius - 2, roofBlock, roofMeta);
		setBlockAndMetadata(world, -2, sectionTopHeight + 8, radius - 1, roofBlock, roofMeta);
		setBlockAndMetadata(world, 2, sectionTopHeight + 8, radius - 1, roofBlock, roofMeta);
		setBlockAndMetadata(world, 4, sectionTopHeight + 8, radius - 2, roofBlock, roofMeta);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, 4, roofBlock, roofMeta);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 8, 2, roofBlock, roofMeta);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 8, -2, roofBlock, roofMeta);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, -4, roofBlock, roofMeta);
		setBlockAndMetadata(world, 4, sectionTopHeight + 8, -radius + 2, roofBlock, roofMeta);
		setBlockAndMetadata(world, 2, sectionTopHeight + 8, -radius + 1, roofBlock, roofMeta);
		setBlockAndMetadata(world, -2, sectionTopHeight + 8, -radius + 1, roofBlock, roofMeta);
		setBlockAndMetadata(world, -4, sectionTopHeight + 8, -radius + 2, roofBlock, roofMeta);
		setBlockAndMetadata(world, -1, sectionTopHeight + 8, -radius + 1, roofStairBlock, 7);
		setBlockAndMetadata(world, 0, sectionTopHeight + 8, -radius + 1, roofStairBlock, 7);
		setBlockAndMetadata(world, 1, sectionTopHeight + 8, -radius + 1, roofStairBlock, 7);
		setBlockAndMetadata(world, 1, sectionTopHeight + 8, -radius + 2, roofStairBlock, 5);
		setBlockAndMetadata(world, 2, sectionTopHeight + 8, -radius + 2, roofStairBlock, 7);
		setBlockAndMetadata(world, 3, sectionTopHeight + 8, -radius + 2, roofStairBlock, 5);
		setBlockAndMetadata(world, 3, sectionTopHeight + 8, -4, roofStairBlock, 7);
		setBlockAndMetadata(world, 4, sectionTopHeight + 8, -4, roofStairBlock, 5);
		setBlockAndMetadata(world, 4, sectionTopHeight + 8, -3, roofStairBlock, 7);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, -3, roofStairBlock, 5);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, -2, roofStairBlock, 5);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, -1, roofStairBlock, 7);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 8, -1, roofStairBlock, 5);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 8, 0, roofStairBlock, 5);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 8, 1, roofStairBlock, 5);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, 1, roofStairBlock, 6);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, 2, roofStairBlock, 5);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 8, 3, roofStairBlock, 6);
		setBlockAndMetadata(world, 4, sectionTopHeight + 8, 3, roofStairBlock, 5);
		setBlockAndMetadata(world, 4, sectionTopHeight + 8, 4, roofStairBlock, 6);
		setBlockAndMetadata(world, 3, sectionTopHeight + 8, 4, roofStairBlock, 5);
		setBlockAndMetadata(world, 3, sectionTopHeight + 8, radius - 2, roofStairBlock, 6);
		setBlockAndMetadata(world, 2, sectionTopHeight + 8, radius - 2, roofStairBlock, 6);
		setBlockAndMetadata(world, 1, sectionTopHeight + 8, radius - 2, roofStairBlock, 5);
		setBlockAndMetadata(world, 1, sectionTopHeight + 8, radius - 1, roofStairBlock, 6);
		setBlockAndMetadata(world, 0, sectionTopHeight + 8, radius - 1, roofStairBlock, 6);
		setBlockAndMetadata(world, -1, sectionTopHeight + 8, radius - 1, roofStairBlock, 6);
		setBlockAndMetadata(world, -1, sectionTopHeight + 8, radius - 2, roofStairBlock, 4);
		setBlockAndMetadata(world, -2, sectionTopHeight + 8, radius - 2, roofStairBlock, 6);
		setBlockAndMetadata(world, -3, sectionTopHeight + 8, radius - 2, roofStairBlock, 4);
		setBlockAndMetadata(world, -3, sectionTopHeight + 8, 4, roofStairBlock, 6);
		setBlockAndMetadata(world, -4, sectionTopHeight + 8, 4, roofStairBlock, 4);
		setBlockAndMetadata(world, -4, sectionTopHeight + 8, 3, roofStairBlock, 6);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, 3, roofStairBlock, 4);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, 2, roofStairBlock, 4);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, 1, roofStairBlock, 6);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 8, 1, roofStairBlock, 4);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 8, 0, roofStairBlock, 4);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 8, -1, roofStairBlock, 4);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, -1, roofStairBlock, 7);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, -2, roofStairBlock, 4);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 8, -3, roofStairBlock, 7);
		setBlockAndMetadata(world, -4, sectionTopHeight + 8, -3, roofStairBlock, 4);
		setBlockAndMetadata(world, -4, sectionTopHeight + 8, -4, roofStairBlock, 7);
		setBlockAndMetadata(world, -3, sectionTopHeight + 8, -4, roofStairBlock, 4);
		setBlockAndMetadata(world, -3, sectionTopHeight + 8, -radius + 2, roofStairBlock, 7);
		setBlockAndMetadata(world, -2, sectionTopHeight + 8, -radius + 2, roofStairBlock, 7);
		setBlockAndMetadata(world, -1, sectionTopHeight + 8, -radius + 2, roofStairBlock, 4);
		for (i16 = -2; i16 <= 2; ++i16) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 9, -radius, roofStairBlock, 2);
			setBlockAndMetadata(world, i16, sectionTopHeight + 9, radius, roofStairBlock, 3);
		}
		for (k12 = -2; k12 <= 2; ++k12) {
			setBlockAndMetadata(world, -radius, sectionTopHeight + 9, k12, roofStairBlock, 1);
			setBlockAndMetadata(world, radius, sectionTopHeight + 9, k12, roofStairBlock, 0);
		}
		for (i16 = -4; i16 <= -3; ++i16) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 9, -radius + 1, roofStairBlock, 2);
			setBlockAndMetadata(world, i16, sectionTopHeight + 9, radius - 1, roofStairBlock, 3);
		}
		for (i16 = 3; i16 <= 4; ++i16) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 9, -radius + 1, roofStairBlock, 2);
			setBlockAndMetadata(world, i16, sectionTopHeight + 9, radius - 1, roofStairBlock, 3);
		}
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 9, -3, roofStairBlock, 1);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 9, -3, roofStairBlock, 0);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 9, 3, roofStairBlock, 1);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 9, 3, roofStairBlock, 0);
		setBlockAndMetadata(world, -2, sectionTopHeight + 9, -radius + 1, roofStairBlock, 1);
		setBlockAndMetadata(world, 2, sectionTopHeight + 9, -radius + 1, roofStairBlock, 0);
		setBlockAndMetadata(world, -2, sectionTopHeight + 9, radius - 1, roofStairBlock, 1);
		setBlockAndMetadata(world, 2, sectionTopHeight + 9, radius - 1, roofStairBlock, 0);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 9, -2, roofStairBlock, 2);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 9, 2, roofStairBlock, 3);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 9, -2, roofStairBlock, 2);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 9, 2, roofStairBlock, 3);
		setBlockAndMetadata(world, -4, sectionTopHeight + 9, -radius + 2, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 9, -radius + 2, roofStairBlock, 2);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 9, -4, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 9, -4, roofStairBlock, 2);
		setBlockAndMetadata(world, 4, sectionTopHeight + 9, -radius + 2, roofStairBlock, 0);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 9, -radius + 2, roofStairBlock, 2);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 9, -4, roofStairBlock, 0);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 9, -4, roofStairBlock, 2);
		setBlockAndMetadata(world, -4, sectionTopHeight + 9, radius - 2, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 9, radius - 2, roofStairBlock, 3);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 9, 4, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 9, 4, roofStairBlock, 3);
		setBlockAndMetadata(world, 4, sectionTopHeight + 9, radius - 2, roofStairBlock, 0);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 9, radius - 2, roofStairBlock, 3);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 9, 4, roofStairBlock, 0);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 9, 4, roofStairBlock, 3);
		for (j1 = sectionTopHeight + 9; j1 <= sectionTopHeight + 10; ++j1) {
			for (i1 = -1; i1 <= 1; ++i1) {
				setBlockAndMetadata(world, i1, j1, -radius + 1, roofBlock, roofMeta);
				setBlockAndMetadata(world, i1, j1, radius - 1, roofBlock, roofMeta);
			}
			for (k111 = -1; k111 <= 1; ++k111) {
				setBlockAndMetadata(world, -radius + 1, j1, k111, roofBlock, roofMeta);
				setBlockAndMetadata(world, radius - 1, j1, k111, roofBlock, roofMeta);
			}
			for (i1 = -3; i1 <= 3; ++i1) {
				setBlockAndMetadata(world, i1, j1, -radius + 2, roofBlock, roofMeta);
				setBlockAndMetadata(world, i1, j1, radius - 2, roofBlock, roofMeta);
			}
			for (k111 = -3; k111 <= 3; ++k111) {
				setBlockAndMetadata(world, -radius + 2, j1, k111, roofBlock, roofMeta);
				setBlockAndMetadata(world, radius - 2, j1, k111, roofBlock, roofMeta);
			}
			setBlockAndMetadata(world, -4, j1, -3, roofBlock, roofMeta);
			setBlockAndMetadata(world, -4, j1, -4, roofBlock, roofMeta);
			setBlockAndMetadata(world, -3, j1, -4, roofBlock, roofMeta);
			setBlockAndMetadata(world, 4, j1, -3, roofBlock, roofMeta);
			setBlockAndMetadata(world, 4, j1, -4, roofBlock, roofMeta);
			setBlockAndMetadata(world, 3, j1, -4, roofBlock, roofMeta);
			setBlockAndMetadata(world, -4, j1, 3, roofBlock, roofMeta);
			setBlockAndMetadata(world, -4, j1, 4, roofBlock, roofMeta);
			setBlockAndMetadata(world, -3, j1, 4, roofBlock, roofMeta);
			setBlockAndMetadata(world, 4, j1, 3, roofBlock, roofMeta);
			setBlockAndMetadata(world, 4, j1, 4, roofBlock, roofMeta);
			setBlockAndMetadata(world, 3, j1, 4, roofBlock, roofMeta);
		}
		for (i16 = -2; i16 <= 2; ++i16) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 10, -4, roofStairBlock, 7);
			setBlockAndMetadata(world, i16, sectionTopHeight + 10, 4, roofStairBlock, 6);
		}
		for (k12 = -1; k12 <= 1; ++k12) {
			setBlockAndMetadata(world, -4, sectionTopHeight + 10, k12, roofStairBlock, 4);
			setBlockAndMetadata(world, 4, sectionTopHeight + 10, k12, roofStairBlock, 5);
		}
		setBlockAndMetadata(world, -2, sectionTopHeight + 10, -3, roofStairBlock, 4);
		setBlockAndMetadata(world, -3, sectionTopHeight + 10, -3, roofStairBlock, 7);
		setBlockAndMetadata(world, -3, sectionTopHeight + 10, -2, roofStairBlock, 4);
		setBlockAndMetadata(world, -4, sectionTopHeight + 10, -2, roofStairBlock, 7);
		setBlockAndMetadata(world, 2, sectionTopHeight + 10, -3, roofStairBlock, 5);
		setBlockAndMetadata(world, 3, sectionTopHeight + 10, -3, roofStairBlock, 7);
		setBlockAndMetadata(world, 3, sectionTopHeight + 10, -2, roofStairBlock, 5);
		setBlockAndMetadata(world, 4, sectionTopHeight + 10, -2, roofStairBlock, 7);
		setBlockAndMetadata(world, -2, sectionTopHeight + 10, 3, roofStairBlock, 4);
		setBlockAndMetadata(world, -3, sectionTopHeight + 10, 3, roofStairBlock, 6);
		setBlockAndMetadata(world, -3, sectionTopHeight + 10, 2, roofStairBlock, 4);
		setBlockAndMetadata(world, -4, sectionTopHeight + 10, 2, roofStairBlock, 6);
		setBlockAndMetadata(world, 2, sectionTopHeight + 10, 3, roofStairBlock, 5);
		setBlockAndMetadata(world, 3, sectionTopHeight + 10, 3, roofStairBlock, 6);
		setBlockAndMetadata(world, 3, sectionTopHeight + 10, 2, roofStairBlock, 5);
		setBlockAndMetadata(world, 4, sectionTopHeight + 10, 2, roofStairBlock, 6);
		setBlockAndMetadata(world, 0, sectionTopHeight + 11, -radius + 1, roofStairBlock, 2);
		setBlockAndMetadata(world, 1, sectionTopHeight + 11, -radius + 1, roofStairBlock, 0);
		setBlockAndMetadata(world, 1, sectionTopHeight + 11, -radius + 2, roofStairBlock, 2);
		setBlockAndMetadata(world, 2, sectionTopHeight + 11, -radius + 2, roofStairBlock, 2);
		setBlockAndMetadata(world, 3, sectionTopHeight + 11, -radius + 2, roofStairBlock, 0);
		setBlockAndMetadata(world, 3, sectionTopHeight + 11, -4, roofStairBlock, 2);
		setBlockAndMetadata(world, 4, sectionTopHeight + 11, -4, roofStairBlock, 0);
		setBlockAndMetadata(world, 4, sectionTopHeight + 11, -3, roofStairBlock, 2);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, -3, roofStairBlock, 0);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, -2, roofStairBlock, 0);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, -1, roofStairBlock, 2);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 11, -1, roofStairBlock, 2);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 11, 0, roofStairBlock, 0);
		setBlockAndMetadata(world, radius - 1, sectionTopHeight + 11, 1, roofStairBlock, 3);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, 1, roofStairBlock, 3);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, 2, roofStairBlock, 0);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, 3, roofStairBlock, 0);
		setBlockAndMetadata(world, 4, sectionTopHeight + 11, 3, roofStairBlock, 3);
		setBlockAndMetadata(world, 4, sectionTopHeight + 11, 4, roofStairBlock, 0);
		setBlockAndMetadata(world, 3, sectionTopHeight + 11, 4, roofStairBlock, 3);
		setBlockAndMetadata(world, 3, sectionTopHeight + 11, radius - 2, roofStairBlock, 0);
		setBlockAndMetadata(world, 2, sectionTopHeight + 11, radius - 2, roofStairBlock, 3);
		setBlockAndMetadata(world, 1, sectionTopHeight + 11, radius - 2, roofStairBlock, 3);
		setBlockAndMetadata(world, 1, sectionTopHeight + 11, radius - 1, roofStairBlock, 0);
		setBlockAndMetadata(world, 0, sectionTopHeight + 11, radius - 1, roofStairBlock, 3);
		setBlockAndMetadata(world, -1, sectionTopHeight + 11, radius - 1, roofStairBlock, 1);
		setBlockAndMetadata(world, -1, sectionTopHeight + 11, radius - 2, roofStairBlock, 3);
		setBlockAndMetadata(world, -2, sectionTopHeight + 11, radius - 2, roofStairBlock, 3);
		setBlockAndMetadata(world, -3, sectionTopHeight + 11, radius - 2, roofStairBlock, 1);
		setBlockAndMetadata(world, -3, sectionTopHeight + 11, 4, roofStairBlock, 3);
		setBlockAndMetadata(world, -4, sectionTopHeight + 11, 4, roofStairBlock, 1);
		setBlockAndMetadata(world, -4, sectionTopHeight + 11, 3, roofStairBlock, 3);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, 3, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, 2, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, 1, roofStairBlock, 3);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 11, 1, roofStairBlock, 3);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 11, 0, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius + 1, sectionTopHeight + 11, -1, roofStairBlock, 2);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, -1, roofStairBlock, 2);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, -2, roofStairBlock, 1);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, -3, roofStairBlock, 1);
		setBlockAndMetadata(world, -4, sectionTopHeight + 11, -3, roofStairBlock, 2);
		setBlockAndMetadata(world, -4, sectionTopHeight + 11, -4, roofStairBlock, 1);
		setBlockAndMetadata(world, -3, sectionTopHeight + 11, -4, roofStairBlock, 2);
		setBlockAndMetadata(world, -3, sectionTopHeight + 11, -radius + 2, roofStairBlock, 1);
		setBlockAndMetadata(world, -2, sectionTopHeight + 11, -radius + 2, roofStairBlock, 2);
		setBlockAndMetadata(world, -1, sectionTopHeight + 11, -radius + 2, roofStairBlock, 2);
		setBlockAndMetadata(world, -1, sectionTopHeight + 11, -radius + 1, roofStairBlock, 1);
		for (j1 = sectionTopHeight + 11; j1 <= sectionTopHeight + 12; ++j1) {
			for (i1 = -2; i1 <= 2; ++i1) {
				setBlockAndMetadata(world, i1, j1, -4, roofBlock, roofMeta);
				setBlockAndMetadata(world, i1, j1, 4, roofBlock, roofMeta);
			}
			for (k111 = -2; k111 <= 2; ++k111) {
				setBlockAndMetadata(world, -4, j1, k111, roofBlock, roofMeta);
				setBlockAndMetadata(world, 4, j1, k111, roofBlock, roofMeta);
			}
			setBlockAndMetadata(world, -3, j1, -2, roofBlock, roofMeta);
			setBlockAndMetadata(world, -3, j1, -3, roofBlock, roofMeta);
			setBlockAndMetadata(world, -2, j1, -3, roofBlock, roofMeta);
			setBlockAndMetadata(world, 3, j1, -2, roofBlock, roofMeta);
			setBlockAndMetadata(world, 3, j1, -3, roofBlock, roofMeta);
			setBlockAndMetadata(world, 2, j1, -3, roofBlock, roofMeta);
			setBlockAndMetadata(world, -3, j1, 2, roofBlock, roofMeta);
			setBlockAndMetadata(world, -3, j1, 3, roofBlock, roofMeta);
			setBlockAndMetadata(world, -2, j1, 3, roofBlock, roofMeta);
			setBlockAndMetadata(world, 3, j1, 2, roofBlock, roofMeta);
			setBlockAndMetadata(world, 3, j1, 3, roofBlock, roofMeta);
			setBlockAndMetadata(world, 2, j1, 3, roofBlock, roofMeta);
		}
		setBlockAndMetadata(world, 0, sectionTopHeight + 11, -radius + 2, roofBlock, roofMeta);
		setBlockAndMetadata(world, 0, sectionTopHeight + 12, -radius + 2, roofSlabBlock, roofSlabMeta);
		setBlockAndMetadata(world, 0, sectionTopHeight + 11, radius - 2, roofBlock, roofMeta);
		setBlockAndMetadata(world, 0, sectionTopHeight + 12, radius - 2, roofSlabBlock, roofSlabMeta);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 11, 0, roofBlock, roofMeta);
		setBlockAndMetadata(world, -radius + 2, sectionTopHeight + 12, 0, roofSlabBlock, roofSlabMeta);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 11, 0, roofBlock, roofMeta);
		setBlockAndMetadata(world, radius - 2, sectionTopHeight + 12, 0, roofSlabBlock, roofSlabMeta);
		setBlockAndMetadata(world, 0, sectionTopHeight + 12, -3, roofStairBlock, 7);
		setBlockAndMetadata(world, 1, sectionTopHeight + 12, -3, roofStairBlock, 7);
		setBlockAndMetadata(world, 1, sectionTopHeight + 12, -2, roofStairBlock, 5);
		setBlockAndMetadata(world, 2, sectionTopHeight + 12, -2, roofStairBlock, 7);
		setBlockAndMetadata(world, 2, sectionTopHeight + 12, -1, roofStairBlock, 5);
		setBlockAndMetadata(world, 3, sectionTopHeight + 12, -1, roofStairBlock, 7);
		setBlockAndMetadata(world, 3, sectionTopHeight + 12, 0, roofStairBlock, 5);
		setBlockAndMetadata(world, 3, sectionTopHeight + 12, 1, roofStairBlock, 6);
		setBlockAndMetadata(world, 2, sectionTopHeight + 12, 1, roofStairBlock, 5);
		setBlockAndMetadata(world, 2, sectionTopHeight + 12, 2, roofStairBlock, 6);
		setBlockAndMetadata(world, 1, sectionTopHeight + 12, 2, roofStairBlock, 5);
		setBlockAndMetadata(world, 1, sectionTopHeight + 12, 3, roofStairBlock, 6);
		setBlockAndMetadata(world, 0, sectionTopHeight + 12, 3, roofStairBlock, 6);
		setBlockAndMetadata(world, -1, sectionTopHeight + 12, 3, roofStairBlock, 6);
		setBlockAndMetadata(world, -1, sectionTopHeight + 12, 2, roofStairBlock, 4);
		setBlockAndMetadata(world, -2, sectionTopHeight + 12, 2, roofStairBlock, 6);
		setBlockAndMetadata(world, -2, sectionTopHeight + 12, 1, roofStairBlock, 4);
		setBlockAndMetadata(world, -3, sectionTopHeight + 12, 1, roofStairBlock, 6);
		setBlockAndMetadata(world, -3, sectionTopHeight + 12, 0, roofStairBlock, 4);
		setBlockAndMetadata(world, -3, sectionTopHeight + 12, -1, roofStairBlock, 7);
		setBlockAndMetadata(world, -2, sectionTopHeight + 12, -1, roofStairBlock, 4);
		setBlockAndMetadata(world, -2, sectionTopHeight + 12, -2, roofStairBlock, 7);
		setBlockAndMetadata(world, -1, sectionTopHeight + 12, -2, roofStairBlock, 4);
		setBlockAndMetadata(world, -1, sectionTopHeight + 12, -3, roofStairBlock, 7);
		for (i16 = -2; i16 <= 2; ++i16) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 13, -4, roofStairBlock, 2);
			setBlockAndMetadata(world, i16, sectionTopHeight + 13, 4, roofStairBlock, 3);
		}
		for (k12 = -1; k12 <= 1; ++k12) {
			setBlockAndMetadata(world, -4, sectionTopHeight + 13, k12, roofStairBlock, 1);
			setBlockAndMetadata(world, 4, sectionTopHeight + 13, k12, roofStairBlock, 0);
		}
		setBlockAndMetadata(world, -2, sectionTopHeight + 13, -3, roofStairBlock, 1);
		setBlockAndMetadata(world, -3, sectionTopHeight + 13, -3, roofStairBlock, 2);
		setBlockAndMetadata(world, -3, sectionTopHeight + 13, -2, roofStairBlock, 1);
		setBlockAndMetadata(world, -4, sectionTopHeight + 13, -2, roofStairBlock, 2);
		setBlockAndMetadata(world, 2, sectionTopHeight + 13, -3, roofStairBlock, 0);
		setBlockAndMetadata(world, 3, sectionTopHeight + 13, -3, roofStairBlock, 2);
		setBlockAndMetadata(world, 3, sectionTopHeight + 13, -2, roofStairBlock, 0);
		setBlockAndMetadata(world, 4, sectionTopHeight + 13, -2, roofStairBlock, 2);
		setBlockAndMetadata(world, -2, sectionTopHeight + 13, 3, roofStairBlock, 1);
		setBlockAndMetadata(world, -3, sectionTopHeight + 13, 3, roofStairBlock, 3);
		setBlockAndMetadata(world, -3, sectionTopHeight + 13, 2, roofStairBlock, 1);
		setBlockAndMetadata(world, -4, sectionTopHeight + 13, 2, roofStairBlock, 3);
		setBlockAndMetadata(world, 2, sectionTopHeight + 13, 3, roofStairBlock, 0);
		setBlockAndMetadata(world, 3, sectionTopHeight + 13, 3, roofStairBlock, 3);
		setBlockAndMetadata(world, 3, sectionTopHeight + 13, 2, roofStairBlock, 0);
		setBlockAndMetadata(world, 4, sectionTopHeight + 13, 2, roofStairBlock, 3);
		for (j1 = sectionTopHeight + 13; j1 <= sectionTopHeight + 14; ++j1) {
			for (i1 = -1; i1 <= 1; ++i1) {
				setBlockAndMetadata(world, i1, j1, -3, roofBlock, roofMeta);
				setBlockAndMetadata(world, i1, j1, 3, roofBlock, roofMeta);
			}
			for (i1 = -2; i1 <= 2; ++i1) {
				setBlockAndMetadata(world, i1, j1, -2, roofBlock, roofMeta);
				setBlockAndMetadata(world, i1, j1, 2, roofBlock, roofMeta);
			}
			for (k111 = -1; k111 <= 1; ++k111) {
				setBlockAndMetadata(world, -3, j1, k111, roofBlock, roofMeta);
				setBlockAndMetadata(world, -2, j1, k111, roofBlock, roofMeta);
				setBlockAndMetadata(world, 2, j1, k111, roofBlock, roofMeta);
				setBlockAndMetadata(world, 3, j1, k111, roofBlock, roofMeta);
			}
		}
		for (i16 = -1; i16 <= 1; ++i16) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 14, -1, roofStairBlock, 7);
			setBlockAndMetadata(world, i16, sectionTopHeight + 14, 1, roofStairBlock, 6);
		}
		setBlockAndMetadata(world, -1, sectionTopHeight + 14, 0, roofStairBlock, 4);
		setBlockAndMetadata(world, 1, sectionTopHeight + 14, 0, roofStairBlock, 5);
		for (i16 = -1; i16 <= 1; ++i16) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 15, -3, roofStairBlock, 2);
			setBlockAndMetadata(world, i16, sectionTopHeight + 15, 3, roofStairBlock, 3);
		}
		setBlockAndMetadata(world, -1, sectionTopHeight + 15, -2, roofStairBlock, 1);
		setBlockAndMetadata(world, -2, sectionTopHeight + 15, -2, roofStairBlock, 2);
		setBlockAndMetadata(world, -2, sectionTopHeight + 15, -1, roofStairBlock, 1);
		setBlockAndMetadata(world, -3, sectionTopHeight + 15, -1, roofStairBlock, 2);
		setBlockAndMetadata(world, -3, sectionTopHeight + 15, 0, roofStairBlock, 1);
		setBlockAndMetadata(world, -3, sectionTopHeight + 15, 1, roofStairBlock, 3);
		setBlockAndMetadata(world, -2, sectionTopHeight + 15, 1, roofStairBlock, 1);
		setBlockAndMetadata(world, -2, sectionTopHeight + 15, 2, roofStairBlock, 3);
		setBlockAndMetadata(world, -1, sectionTopHeight + 15, 2, roofStairBlock, 1);
		setBlockAndMetadata(world, 1, sectionTopHeight + 15, -2, roofStairBlock, 0);
		setBlockAndMetadata(world, 2, sectionTopHeight + 15, -2, roofStairBlock, 2);
		setBlockAndMetadata(world, 2, sectionTopHeight + 15, -1, roofStairBlock, 0);
		setBlockAndMetadata(world, 3, sectionTopHeight + 15, -1, roofStairBlock, 2);
		setBlockAndMetadata(world, 3, sectionTopHeight + 15, 0, roofStairBlock, 0);
		setBlockAndMetadata(world, 3, sectionTopHeight + 15, 1, roofStairBlock, 3);
		setBlockAndMetadata(world, 2, sectionTopHeight + 15, 1, roofStairBlock, 0);
		setBlockAndMetadata(world, 2, sectionTopHeight + 15, 2, roofStairBlock, 3);
		setBlockAndMetadata(world, 1, sectionTopHeight + 15, 2, roofStairBlock, 0);
		for (j1 = sectionTopHeight + 15; j1 <= sectionTopHeight + 16; ++j1) {
			for (i1 = -1; i1 <= 1; ++i1) {
				for (k15 = -1; k15 <= 1; ++k15) {
					setBlockAndMetadata(world, i1, j1, k15, roofBlock, roofMeta);
				}
			}
		}
		setBlockAndMetadata(world, 0, sectionTopHeight + 15, -2, roofBlock, roofMeta);
		setBlockAndMetadata(world, 0, sectionTopHeight + 16, -2, roofSlabBlock, roofSlabMeta);
		setBlockAndMetadata(world, 0, sectionTopHeight + 15, 2, roofBlock, roofMeta);
		setBlockAndMetadata(world, 0, sectionTopHeight + 16, 2, roofSlabBlock, roofSlabMeta);
		setBlockAndMetadata(world, -2, sectionTopHeight + 15, 0, roofBlock, roofMeta);
		setBlockAndMetadata(world, -2, sectionTopHeight + 16, 0, roofSlabBlock, roofSlabMeta);
		setBlockAndMetadata(world, 2, sectionTopHeight + 15, 0, roofBlock, roofMeta);
		setBlockAndMetadata(world, 2, sectionTopHeight + 16, 0, roofSlabBlock, roofSlabMeta);
		for (i16 = -1; i16 <= 1; ++i16) {
			setBlockAndMetadata(world, i16, sectionTopHeight + 17, -1, roofStairBlock, 2);
			setBlockAndMetadata(world, i16, sectionTopHeight + 17, 1, roofStairBlock, 3);
		}
		setBlockAndMetadata(world, -1, sectionTopHeight + 17, 0, roofStairBlock, 1);
		setBlockAndMetadata(world, 1, sectionTopHeight + 17, 0, roofStairBlock, 0);
		setBlockAndMetadata(world, 0, sectionTopHeight + 17, 0, roofBlock, roofMeta);
		setBlockAndMetadata(world, 0, sectionTopHeight + 18, 0, roofSlabBlock, roofSlabMeta);
		for (j1 = sectionTopHeight + 10; j1 <= sectionTopHeight + 14; ++j1) {
			setBlockAndMetadata(world, 0, j1, 0, Blocks.fence, 2);
		}
		for (i16 = -2; i16 <= 2; ++i16) {
			for (k111 = -2; k111 <= 2; ++k111) {
				if (i16 == 0 || k111 == 0) {
					setBlockAndMetadata(world, i16, sectionTopHeight + 10, k111, Blocks.fence, 2);
				}
				if ((i16 != 0 || Math.abs(k111) != 2) && (k111 != 0 || Math.abs(i16) != 2)) {
					continue;
				}
				setBlockAndMetadata(world, i16, sectionTopHeight + 9, k111, LOTRMod.chandelier, 10);
			}
		}
		setBlockAndMetadata(world, -1, sectionTopHeight + 1, 6, Blocks.crafting_table, 0);
		setBlockAndMetadata(world, 0, sectionTopHeight + 1, 6, brickBlock, brickMeta);
		setBlockAndMetadata(world, 1, sectionTopHeight + 1, 6, LOTRMod.highElvenTable, 0);
		setBlockAndMetadata(world, 0, sectionTopHeight + 1, -4, LOTRMod.commandTable, 0);
		BDEntityEregionLord elfLord = new BDEntityEregionLord(world);
		elfLord.spawnRidingHorse = false;
		spawnNPCAndSetHome(elfLord, world, 0, sectionTopHeight + 1, 1, 16);
		LOTREntityNPCRespawner respawner = new LOTREntityNPCRespawner(world);
		respawner.setSpawnClass(BDEntityEregionWarrior.class);
		respawner.setCheckRanges(12, -16, 50, 12);
		respawner.setSpawnRanges(6, 0, 20, 16);
		placeNPCRespawner(respawner, world, 0, 0, 0);
		return true;
	}

	private void layFoundation(World world, int i, int k) {
		for (int j = 0; (((j == 0) || !isOpaque(world, i, j, k)) && (getY(j) >= 0)); --j) {
			setBlockAndMetadata(world, i, j, k, brickBlock, brickMeta);
			setGrassToDirt(world, i, j - 1, k);
		}
	}
}
