package bd.structure;

import java.util.Random;

import bd.entity.*;
import lotr.common.LOTRMod;
import lotr.common.entity.LOTREntityNPCRespawner;
import lotr.common.entity.npc.LOTRNames;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.map.LOTRRoadType;
import lotr.common.world.structure2.*;
import lotr.common.world.village.*;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BDStructureKhandVillage extends LOTRVillageGen {
	public BDStructureKhandVillage(LOTRBiome biome, float f) {
		super(biome);
		gridScale = 14;
		gridRandomDisplace = 1;
		spawnChance = f;
		villageChunkRadius = 6;
	}

	@Override
	protected LOTRVillageGen.AbstractInstance<?> createVillageInstance(World world, int i, int k, Random random, LocationInfo loc) {
		return new Instance(this, world, i, k, random, loc);
	}

	public static class Instance extends LOTRVillageGen.AbstractInstance<BDStructureKhandVillage> {
		public VillageType villageType;
		public String[] villageName;
		private int numOuterHouses;
		private boolean townWall = true;
		int rTownTower = 90;

		public Instance(BDStructureKhandVillage village, World world, int i, int k, Random random, LocationInfo loc) {
			super(village, world, i, k, random, loc);
		}

		@Override
		protected void addVillageStructures(Random random) {
			if (villageType == VillageType.VILLAGE) {
				setupVillage(random);
			} else if (villageType == VillageType.TOWN) {
				setupTown(random);
			} else if (villageType == VillageType.FORT) {
				setupFort(random);
			}
		}

		@Override
		protected LOTRRoadType getPath(Random random, int i, int k) {
			int dSq;
			int i1 = Math.abs(i);
			int k1 = Math.abs(k);
			if (villageType == VillageType.VILLAGE) {
				dSq = i * i + k * k;
				int imn = 16 - random.nextInt(3);
				int imx = 21 + random.nextInt(3);
				if (dSq > imn * imn && dSq < imx * imx) {
					return LOTRRoadType.PATH;
				}
			}
			if (villageType == VillageType.TOWN) {
				dSq = i * i + k * k;
				if (dSq < 576) {
					return LOTRRoadType.GULF_HARAD;
				}
				if (k1 <= 3 && i1 <= 74 || i1 <= 3 && k <= 74) {
					return LOTRRoadType.GULF_HARAD;
				}
			}
			return null;
		}

		private LOTRWorldGenStructureBase2 getRandomFarm(Random random) {
			if (random.nextBoolean()) {
				return new BDStructureKhandFarm(false);
			}
			return new BDStructureKhandPasture(false);
		}

		private LOTRWorldGenStructureBase2 getRandomHouse(Random random) {
			if (random.nextInt(5) == 0) {
				return new BDStructureKhandSmithy(false);
			}
			return new BDStructureKhandHouse(false);
		}

		@Override
		public boolean isFlat() {
			return false;
		}

		@Override
		public boolean isVillageSpecificSurface(World world, int i, int j, int k) {
			if (villageType == VillageType.TOWN) {
				Block block = world.getBlock(i, j, k);
				int meta = world.getBlockMetadata(i, j, k);
				if ((block == LOTRMod.brick3 && (meta == 13 || meta == 14))) {
					return true;
				}
			}
			return false;
		}

		private void setupFort(Random random) {
			this.addStructure(new LOTRWorldGenNPCRespawner(false) {

				@Override
				public void setupRespawner(LOTREntityNPCRespawner spawner) {
					spawner.setSpawnClass(BDEntityKhandMan.class);
					spawner.setCheckRanges(40, -12, 12, 16);
					spawner.setSpawnRanges(24, -6, 6, 32);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			this.addStructure(new BDStructureKhandWarCamp(false), 0, -15, 0, true);
			int towerX = 36;
			this.addStructure(new BDStructureKhandTower(false), -towerX, -towerX + 4, 2, true);
			this.addStructure(new BDStructureKhandTower(false), towerX, -towerX + 4, 2, true);
			this.addStructure(new BDStructureKhandTower(false), -towerX, towerX - 4, 0, true);
			this.addStructure(new BDStructureKhandTower(false), towerX, towerX - 4, 0, true);
			for (int l = -1; l <= 1; ++l) {
				int i = l * 16;
				int k = 28;
				this.addStructure(getRandomFarm(random), i, k, 0);
				this.addStructure(getRandomFarm(random), -k, i, 1);
				this.addStructure(getRandomFarm(random), k, i, 3);
			}
		}

		private void setupTown(Random random) {
			this.addStructure(new LOTRWorldGenNPCRespawner(false) {

				@Override
				public void setupRespawner(LOTREntityNPCRespawner spawner) {
					spawner.setSpawnClass(BDEntityKhandMan.class);
					spawner.setCheckRanges(80, -12, 12, 100);
					spawner.setSpawnRanges(40, -6, 6, 64);
					spawner.setBlockEnemySpawnRange(60);
				}
			}, 0, 0, 0);
			for (int i1 : new int[] { -40, 40 }) {
				for (int k1 : new int[] { -40, 40 }) {
					this.addStructure(new LOTRWorldGenNPCRespawner(false) {

						@Override
						public void setupRespawner(LOTREntityNPCRespawner spawner) {
							spawner.setSpawnClasses(BDEntityKhandWarrior.class, BDEntityKhandArcher.class);
							spawner.setCheckRanges(64, -12, 12, 20);
							spawner.setSpawnRanges(20, -6, 6, 64);
							spawner.setBlockEnemySpawnRange(64);
						}
					}, i1, k1, 0);
				}
			}
			this.addStructure(new BDStructureKhandPyramid(false), 0, -11, 0, true);
			int lightR = 15;
			this.addStructure(new BDStructureKhandVillageLight(false), -lightR, -lightR, 0, true);
			this.addStructure(new BDStructureKhandVillageLight(false), lightR, -lightR, 0, true);
			this.addStructure(new BDStructureKhandVillageLight(false), -lightR, lightR, 0, true);
			this.addStructure(new BDStructureKhandVillageLight(false), lightR, lightR, 0, true);
			this.addStructure(new BDStructureKhandBazaar(false), -74, 0, 1, true);
			this.addStructure(new BDStructureKhandAltar(false), 74, 0, 3, true);
			this.addStructure(new BDStructureKhandTotem(false), 0, 79, 0, true);
			for (int l = 0; l <= 2; ++l) {
				int i = 5;
				int k = 32 + l * 20;
				this.addStructure(new BDStructureKhandHouse(false), -i, -k, 1, true);
				this.addStructure(new BDStructureKhandHouse(false), i, -k, 3, true);
				this.addStructure(new BDStructureKhandHouse(false), -i, k, 1, true);
				this.addStructure(new BDStructureKhandHouse(false), i, k, 3, true);
				this.addStructure(new BDStructureKhandHouse(false), k, -i, 2, true);
				this.addStructure(new BDStructureKhandHouse(false), k, i, 0, true);
				if (l != 0) {
					continue;
				}
				this.addStructure(new BDStructureKhandSmithy(false), -k - 6, -i, 2, true);
				this.addStructure(new BDStructureKhandTavern(false), -k - 6, i, 0, true);
			}
			int xzTownTower = (int) (rTownTower / Math.sqrt(2.0));
			this.addStructure(new BDStructureKhandTower(false), -xzTownTower, -xzTownTower + 4, 2, true);
			this.addStructure(new BDStructureKhandTower(false), xzTownTower, -xzTownTower + 4, 2, true);
			this.addStructure(new BDStructureKhandTower(false), -xzTownTower, xzTownTower - 4, 0, true);
			this.addStructure(new BDStructureKhandTower(false), xzTownTower, xzTownTower - 4, 0, true);
			int turn = 0;
			int numTurns = 24;
			while (turn <= numTurns) {
				turn++;
				if (turn % 3 == 0) {
					continue;
				}
				float turnF = (float) turn / (float) numTurns;
				float turnR = (float) Math.toRadians(turnF * 360.0f);
				float sin = MathHelper.sin(turnR);
				float cos = MathHelper.cos(turnR);
				int r = 0;
				float turn8 = turnF * 8.0f;
				if (turn8 >= 1.0f && turn8 < 3.0f) {
					r = 0;
				} else if (turn8 >= 3.0f && turn8 < 5.0f) {
					r = 1;
				} else if (turn8 >= 5.0f && turn8 < 7.0f) {
					r = 2;
				} else if (turn8 >= 7.0f || turn8 < 1.0f) {
					r = 3;
				}
				int l = rTownTower - 6;
				int i = Math.round(l * cos);
				int k = Math.round(l * sin);
				if (random.nextInt(3) == 0) {
					this.addStructure(new LOTRWorldGenHayBales(false), i, k, r);
					continue;
				}
				this.addStructure(getRandomFarm(random), i, k, r);
			}
			this.addStructure(new BDStructureKhandVillageSign(false).setSignText(villageName), -5, -96, 0, true);
			this.addStructure(new BDStructureKhandVillageSign(false).setSignText(villageName), 5, -96, 0, true);
			if (townWall) {
				int rSq = 9604;
				int rMax = 99;
				int rSqMax = rMax * rMax;
				for (int i = -98; i <= 98; ++i) {
					for (int k = -98; k <= 98; ++k) {
						int dSq;
						int i1 = Math.abs(i);
						if (i1 <= 6 && k < 0 || (dSq = i * i + k * k) < rSq || dSq >= rSqMax) {
							continue;
						}
						BDStructureKhandTownWall wall = new BDStructureKhandTownWall(false);
						if (i1 == 7 && k < 0) {
							wall.setTall();
						}
						this.addStructure(wall, i, k, 0);
					}
				}
			}
		}

		private void setupVillage(Random random) {
			this.addStructure(new LOTRWorldGenNPCRespawner(false) {

				@Override
				public void setupRespawner(LOTREntityNPCRespawner spawner) {
					spawner.setSpawnClass(BDEntityKhandMan.class);
					spawner.setCheckRanges(64, -12, 12, 24);
					spawner.setSpawnRanges(32, -6, 6, 32);
					spawner.setBlockEnemySpawnRange(64);
				}
			}, 0, 0, 0);
			this.addStructure(new LOTRWorldGenNPCRespawner(false) {

				@Override
				public void setupRespawner(LOTREntityNPCRespawner spawner) {
					spawner.setSpawnClasses(BDEntityKhandWarrior.class, BDEntityKhandArcher.class);
					spawner.setCheckRanges(64, -12, 12, 12);
					spawner.setSpawnRanges(32, -6, 6, 32);
					spawner.setBlockEnemySpawnRange(64);
				}
			}, 0, 0, 0);
			this.addStructure(new BDStructureKhandTotem(false), 0, -2, 0, true);
			this.addStructure(new BDStructureKhandTavern(false), 0, 24, 0, true);
			int rSignsInner = 11;
			this.addStructure(new BDStructureKhandVillageSign(false).setSignText(villageName), -rSignsInner, 0, 1, true);
			this.addStructure(new BDStructureKhandVillageSign(false).setSignText(villageName), rSignsInner, 0, 3, true);
			for (int h = 0; h < numOuterHouses; ++h) {
				float turn = (float) h / (float) (numOuterHouses - 1);
				float turnMin = 0.15f;
				float turnMax = 1.0f - turnMin;
				float turnInRange = turnMin + (turnMax - turnMin) * turn;
				float turnCorrected = (turnInRange + 0.25f) % 1.0f;
				float turnR = (float) Math.toRadians(turnCorrected * 360.0f);
				float sin = MathHelper.sin(turnR);
				float cos = MathHelper.cos(turnR);
				int r = 0;
				float turn8 = turnCorrected * 8.0f;
				if (turn8 >= 1.0f && turn8 < 3.0f) {
					r = 0;
				} else if (turn8 >= 3.0f && turn8 < 5.0f) {
					r = 1;
				} else if (turn8 >= 5.0f && turn8 < 7.0f) {
					r = 2;
				} else if (turn8 >= 7.0f || turn8 < 1.0f) {
					r = 3;
				}
				int l = 24;
				int i = Math.round(l * cos);
				int k = Math.round(l * sin);
				this.addStructure(getRandomHouse(random), i, k, r);
			}
			int numFarms = numOuterHouses * 2;
			float frac = 1.0f / numFarms;
			float turn = 0.0f;
			while (turn < 1.0f) {
				float turnR = (float) Math.toRadians((turn += frac) * 360.0f);
				float sin = MathHelper.sin(turnR);
				float cos = MathHelper.cos(turnR);
				int r = 0;
				float turn8 = turn * 8.0f;
				if (turn8 >= 1.0f && turn8 < 3.0f) {
					r = 0;
				} else if (turn8 >= 3.0f && turn8 < 5.0f) {
					r = 1;
				} else if (turn8 >= 5.0f && turn8 < 7.0f) {
					r = 2;
				} else if (turn8 >= 7.0f || turn8 < 1.0f) {
					r = 3;
				}
				int l = 52;
				int i = Math.round(l * cos);
				int k = Math.round(l * sin);
				if (random.nextInt(3) == 0) {
					this.addStructure(new LOTRWorldGenHayBales(false), i, k, r);
					continue;
				}
				this.addStructure(getRandomFarm(random), i, k, r);
			}
		}

		@Override
		protected void setupVillageProperties(Random random) {
			villageType = random.nextInt(4) == 0 ? VillageType.FORT : random.nextInt(3) == 0 ? VillageType.TOWN : VillageType.VILLAGE;
			villageName = LOTRNames.getHaradVillageName(random);
			numOuterHouses = MathHelper.getRandomIntegerInRange(random, 5, 8);
		}

	}

	public enum VillageType {
		VILLAGE, TOWN, FORT;

	}

}
