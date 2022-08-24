package lotr.common.world.biome;

import java.awt.Color;
import java.util.*;

import cpw.mods.fml.relauncher.*;
import lotr.client.LOTRTickHandlerClient;
import lotr.common.*;
import lotr.common.entity.animal.*;
import lotr.common.entity.npc.*;
import lotr.common.world.LOTRWorldChunkManager;
import lotr.common.world.biome.variant.*;
import lotr.common.world.feature.LOTRTreeType;
import lotr.common.world.map.*;
import lotr.common.world.spawning.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.common.util.EnumHelper;

public abstract class LOTRBiome extends BiomeGenBase {
	private static Class[][] correctCreatureTypeParams = { { EnumCreatureType.class, Class.class, Integer.TYPE, Material.class, Boolean.TYPE, Boolean.TYPE } };
	public static EnumCreatureType creatureType_LOTRAmbient = EnumHelper.addEnum(correctCreatureTypeParams, EnumCreatureType.class, "LOTRAmbient", LOTRAmbientCreature.class, 45, Material.air, true, false);
	public static LOTRBiome river;
	public static LOTRBiome rohan;
	public static LOTRBiome mistyMountains;
	public static LOTRBiome shire;
	public static LOTRBiome shireWoodlands;
	public static LOTRBiome mordor;
	public static LOTRBiome mordorMountains;
	public static LOTRBiome gondor;
	public static LOTRBiome whiteMountains;
	public static LOTRBiome lothlorien;
	public static LOTRBiome celebrant;
	public static LOTRBiome ironHills;
	public static LOTRBiome deadMarshes;
	public static LOTRBiome trollshaws;
	public static LOTRBiome woodlandRealm;
	public static LOTRBiome mirkwoodCorrupted;
	public static LOTRBiome rohanUrukHighlands;
	public static LOTRBiome emynMuil;
	public static LOTRBiome ithilien;
	public static LOTRBiome pelargir;
	public static LOTRBiome loneLands;
	public static LOTRBiome loneLandsHills;
	public static LOTRBiome dunland;
	public static LOTRBiome fangorn;
	public static LOTRBiome angle;
	public static LOTRBiome ettenmoors;
	public static LOTRBiome oldForest;
	public static LOTRBiome harondor;
	public static LOTRBiome eriador;
	public static LOTRBiome eriadorDowns;
	public static LOTRBiome erynVorn;
	public static LOTRBiome greyMountains;
	public static LOTRBiome midgewater;
	public static LOTRBiome brownLands;
	public static LOTRBiome ocean;
	public static LOTRBiome anduinHills;
	public static LOTRBiome meneltarma;
	public static LOTRBiome gladdenFields;
	public static LOTRBiome lothlorienEdge;
	public static LOTRBiome forodwaith;
	public static LOTRBiome enedwaith;
	public static LOTRBiome angmar;
	public static LOTRBiome eregion;
	public static LOTRBiome lindon;
	public static LOTRBiome lindonWoodlands;
	public static LOTRBiome eastBight;
	public static LOTRBiome blueMountains;
	public static LOTRBiome mirkwoodMountains;
	public static LOTRBiome wilderland;
	public static LOTRBiome dagorlad;
	public static LOTRBiome nurn;
	public static LOTRBiome nurnen;
	public static LOTRBiome nurnMarshes;
	public static LOTRBiome angmarMountains;
	public static LOTRBiome anduinMouth;
	public static LOTRBiome entwashMouth;
	public static LOTRBiome dorEnErnil;
	public static LOTRBiome dorEnErnilHills;
	public static LOTRBiome fangornWasteland;
	public static LOTRBiome rohanWoodlands;
	public static LOTRBiome gondorWoodlands;
	public static LOTRBiome lake;
	public static LOTRBiome lindonCoast;
	public static LOTRBiome barrowDowns;
	public static LOTRBiome longMarshes;
	public static LOTRBiome fangornClearing;
	public static LOTRBiome ithilienHills;
	public static LOTRBiome ithilienWasteland;
	public static LOTRBiome nindalf;
	public static LOTRBiome coldfells;
	public static LOTRBiome nanCurunir;
	public static LOTRBiome adornland;
	public static LOTRBiome whiteDowns;
	public static LOTRBiome swanfleet;
	public static LOTRBiome pelennor;
	public static LOTRBiome minhiriath;
	public static LOTRBiome erebor;
	public static LOTRBiome mirkwoodNorth;
	public static LOTRBiome woodlandRealmHills;
	public static LOTRBiome nanUngol;
	public static LOTRBiome pinnathGelin;
	public static LOTRBiome island;
	public static LOTRBiome forodwaithMountains;
	public static LOTRBiome mistyMountainsFoothills;
	public static LOTRBiome greyMountainsFoothills;
	public static LOTRBiome blueMountainsFoothills;
	public static LOTRBiome tundra;
	public static LOTRBiome taiga;
	public static LOTRBiome breeland;
	public static LOTRBiome chetwood;
	public static LOTRBiome forodwaithGlacier;
	public static LOTRBiome whiteMountainsFoothills;
	public static LOTRBiome beach;
	public static LOTRBiome beachGravel;
	public static LOTRBiome nearHarad;
	public static LOTRBiome farHarad;
	public static LOTRBiome haradMountains;
	public static LOTRBiome umbar;
	public static LOTRBiome farHaradJungle;
	public static LOTRBiome umbarHills;
	public static LOTRBiome nearHaradHills;
	public static LOTRBiome farHaradJungleLake;
	public static LOTRBiome lostladen;
	public static LOTRBiome farHaradForest;
	public static LOTRBiome nearHaradFertile;
	public static LOTRBiome pertorogwaith;
	public static LOTRBiome umbarForest;
	public static LOTRBiome farHaradJungleEdge;
	public static LOTRBiome tauredainClearing;
	public static LOTRBiome gulfHarad;
	public static LOTRBiome dorwinionHills;
	public static LOTRBiome tolfalas;
	public static LOTRBiome lebennin;
	public static LOTRBiome rhun;
	public static LOTRBiome rhunForest;
	public static LOTRBiome redMountains;
	public static LOTRBiome redMountainsFoothills;
	public static LOTRBiome dolGuldur;
	public static LOTRBiome nearHaradSemiDesert;
	public static LOTRBiome farHaradArid;
	public static LOTRBiome farHaradAridHills;
	public static LOTRBiome farHaradSwamp;
	public static LOTRBiome farHaradCloudForest;
	public static LOTRBiome farHaradBushland;
	public static LOTRBiome farHaradBushlandHills;
	public static LOTRBiome farHaradMangrove;
	public static LOTRBiome nearHaradFertileForest;
	public static LOTRBiome anduinVale;
	public static LOTRBiome wold;
	public static LOTRBiome shireMoors;
	public static LOTRBiome shireMarshes;
	public static LOTRBiome nearHaradRedDesert;
	public static LOTRBiome farHaradVolcano;
	public static LOTRBiome udun;
	public static LOTRBiome gorgoroth;
	public static LOTRBiome morgulVale;
	public static LOTRBiome easternDesolation;
	public static LOTRBiome dale;
	public static LOTRBiome dorwinion;
	public static LOTRBiome towerHills;
	public static LOTRBiome gulfHaradForest;
	public static LOTRBiome wilderlandNorth;
	public static LOTRBiome forodwaithCoast;
	public static LOTRBiome farHaradCoast;
	public static LOTRBiome nearHaradRiverbank;
	public static LOTRBiome lossarnach;
	public static LOTRBiome imlothMelui;
	public static LOTRBiome nearHaradOasis;
	public static LOTRBiome beachWhite;
	public static LOTRBiome harnedor;
	public static LOTRBiome lamedon;
	public static LOTRBiome lamedonHills;
	public static LOTRBiome blackrootVale;
	public static LOTRBiome andrast;
	public static LOTRBiome pukel;
	public static LOTRBiome rhunLand;
	public static LOTRBiome rhunLandSteppe;
	public static LOTRBiome rhunLandHills;
	public static LOTRBiome rhunRedForest;
	public static LOTRBiome rhunIsland;
	public static LOTRBiome rhunIslandForest;
	public static LOTRBiome lastDesert;
	public static LOTRBiome windMountains;
	public static LOTRBiome windMountainsFoothills;
	public static LOTRBiome rivendell;
	public static LOTRBiome rivendellHills;
	public static LOTRBiome farHaradJungleMountains;
	public static LOTRBiome halfTrollForest;
	public static LOTRBiome farHaradKanuka;
	public static LOTRBiome utumno;
	public static NoiseGeneratorPerlin biomeTerrainNoise;
	protected static Random terrainRand;
	private static Color waterColorNorth;
	private static Color waterColorSouth;
	private static int waterLimitNorth;
	private static int waterLimitSouth;
	public static LOTRBiome ocean1;
	public static LOTRBiome ocean2;
	public static LOTRBiome ocean3;
	public static LOTRBiome lake1;
	public static LOTRBiome celebrantForest;
	public static LOTRBiome nurnen1;
	public static LOTRBiome nurnen2;
	public static LOTRBiome harlindon;
	public static LOTRBiome rhovanion;
	public static LOTRBiome eregionForest;
	public static LOTRBiome rhunLandWest;
	public static LOTRBiome anfalas;
	public static LOTRBiome gondorWest;
	public static LOTRBiome calenardhonWest;
	public static LOTRBiome calenardhonWoodlands;
	public static LOTRBiome rhovanionFields;
	public static LOTRBiome khazadDum;
	public static LOTRBiome rhovanionNorth;
	public static LOTRBiome wilderlandForest;
	public static LOTRBiome rhovanionFieldsForest;
	public static LOTRBiome calenardhon;
	public static LOTRBiome rhovanionNorthForest;
	public static LOTRBiome eriadorForest;
	public static LOTRBiome gundabad;
	public static LOTRBiome khazadDumFoothills;
	public static LOTRBiome gwathlo;
	public static LOTRBiome enedwaithForest;
	public static LOTRBiome forostarMoors;
	public static LOTRBiome numenorWoodlands;
	public static LOTRBiome forostar;
	public static LOTRBiome mittalmar;
	public static LOTRBiome emeriyo;
	public static LOTRBiome hyarnustar;
	public static LOTRBiome orrostar;
	public static LOTRBiome hyarrostar;
	public static LOTRBiome andustar;
	public static LOTRBiome anduniyoHills;
	public static LOTRBiome numenorHills;
	public static LOTRBiome hyarrostarWoodlands;
	public static LOTRBiome mouthSiril;
	public static LOTRBiome nisimaldar;
	public static LOTRBiome meneltarm;
	public static LOTRBiome meneltarmFoothills;
	public static LOTRBiome arandor;
	public static LOTRBiome khand;

	static {
		biomeTerrainNoise = new NoiseGeneratorPerlin(new Random(1955L), 1);
		terrainRand = new Random();
		waterColorNorth = new Color(602979);
		waterColorSouth = new Color(4973293);
		waterLimitNorth = -40000;
		waterLimitSouth = 160000;
	}
	public LOTRDimension biomeDimension;
	public LOTRBiomeDecorator decorator;
	public int topBlockMeta = 0;
	public int fillerBlockMeta = 0;
	public float heightBaseParameter;
	protected boolean enablePodzol = true;
	protected boolean enableRocky = true;
	private LOTRBiomeVariantList biomeVariantsSmall = new LOTRBiomeVariantList();
	private LOTRBiomeVariantList biomeVariantsLarge = new LOTRBiomeVariantList();
	public float variantChance = 0.4f;
	public LOTRBiomeSpawnList npcSpawnList = new LOTRBiomeSpawnList(this);
	protected List spawnableLOTRAmbientList = new ArrayList();
	private List spawnableTraders = new ArrayList();
	private LOTREventSpawner.EventChance banditChance;
	private Class<? extends LOTREntityBandit> banditEntityClass;
	public final LOTRBiomeInvasionSpawns invasionSpawns;
	public BiomeColors biomeColors = new BiomeColors(this);
	public BiomeTerrain biomeTerrain = new BiomeTerrain(this);
	private boolean initDwarven = false;
	private boolean isDwarven;

	public LOTRBiome(int i, boolean major) {
		this(i, major, LOTRDimension.MIDDLE_EARTH);
	}

	public LOTRBiome(int i, boolean major, LOTRDimension dim) {
		super(i, false);
		biomeDimension = dim;
		if (biomeDimension.biomeList[i] != null) {
			throw new IllegalArgumentException("LOTR biome already exists at index " + i + " for dimension " + biomeDimension.dimensionName + "!");
		}
		biomeDimension.biomeList[i] = this;
		if (major) {
			biomeDimension.majorBiomes.add(this);
		}
		waterColorMultiplier = BiomeColors.DEFAULT_WATER;
		decorator = new LOTRBiomeDecorator(this);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableCaveCreatureList.clear();
		if (hasDomesticAnimals()) {
			spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySheep.class, 12, 4, 4));
			spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPig.class, 10, 4, 4));
			spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityChicken.class, 10, 4, 4));
			spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityCow.class, 8, 4, 4));
			spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 5, 4, 4));
		} else {
			spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySheep.class, 12, 4, 4));
			spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityWildBoar.class, 10, 4, 4));
			spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityChicken.class, 8, 4, 4));
			spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityDeer.class, 10, 4, 4));
			spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityAurochs.class, 6, 4, 4));
		}
		spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(LOTREntityFish.class, 10, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityButterfly.class, 8, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityRabbit.class, 8, 4, 4));
		spawnableLOTRAmbientList.add(new BiomeGenBase.SpawnListEntry(LOTREntityBird.class, 10, 4, 4));
		spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBat.class, 10, 8, 8));
		setBanditChance(LOTREventSpawner.EventChance.NEVER);
		invasionSpawns = new LOTRBiomeInvasionSpawns(this);
	}

	public void addBiomeF3Info(List info, World world, LOTRBiomeVariant variant, int i, int j, int k) {
		int colorRGB = color & 0xFFFFFF;
		String colorString = Integer.toHexString(colorRGB);
		while (colorString.length() < 6) {
			colorString = "0" + colorString;
		}
		info.add("Middle-earth biome: " + getBiomeDisplayName() + ", ID: " + biomeID + ", c: #" + colorString);
		info.add("Variant: " + variant.variantName + ", loaded: " + LOTRBiomeVariantStorage.getSize(world));
	}

	protected void addBiomeVariant(LOTRBiomeVariant v) {
		this.addBiomeVariant(v, 1.0f);
	}

	protected void addBiomeVariant(LOTRBiomeVariant v, float f) {
		if (v.variantScale == LOTRBiomeVariant.VariantScale.ALL) {
			biomeVariantsLarge.add(v, f);
			biomeVariantsSmall.add(v, f);
		} else if (v.variantScale == LOTRBiomeVariant.VariantScale.LARGE) {
			biomeVariantsLarge.add(v, f);
		} else if (v.variantScale == LOTRBiomeVariant.VariantScale.SMALL) {
			biomeVariantsSmall.add(v, f);
		}
	}

	protected void addBiomeVariantSet(LOTRBiomeVariant[] set) {
		for (LOTRBiomeVariant v : set) {
			this.addBiomeVariant(v);
		}
	}

	public boolean canSpawnHostilesInDay() {
		return false;
	}

	@Override
	public boolean canSpawnLightningBolt() {
		return !getEnableSnow() && super.canSpawnLightningBolt();
	}

	public final boolean canSpawnTravellingTrader(Class entityClass) {
		return spawnableTraders.contains(entityClass);
	}

	protected void clearBiomeVariants() {
		biomeVariantsLarge.clear();
		biomeVariantsSmall.clear();
		variantChance = 0.4f;
	}

	protected final void clearTravellingTraders() {
		spawnableTraders.clear();
	}

	@Override
	public BiomeGenBase createMutation() {
		return this;
	}

	@Override
	public void decorate(World world, Random random, int i, int k) {
		decorator.decorate(world, random, i, k);
	}

	@Override
	public final WorldGenAbstractTree func_150567_a(Random random) {
		LOTRTreeType tree = decorator.getRandomTree(random);
		return tree.create(false, random);
	}

	public void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, double stoneNoise, int height, LOTRBiomeVariant variant) {
		int chunkX = i & 0xF;
		int chunkZ = k & 0xF;
		int xzIndex = chunkX * 16 + chunkZ;
		int ySize = blocks.length / 256;
		int seaLevel = 63;
		double stoneNoiseFiller = modifyStoneNoiseForFiller(stoneNoise);
		int fillerDepthBase = (int) (stoneNoiseFiller / 4.0 + 5.0 + random.nextDouble() * 0.25);
		int fillerDepth = -1;
		Block top = topBlock;
		byte topMeta = (byte) topBlockMeta;
		Block filler = fillerBlock;
		byte fillerMeta = (byte) fillerBlockMeta;
		if (enableRocky && height >= 90) {
			float hFactor = (height - 90) / 10.0f;
			float thresh = 1.2f - hFactor * 0.2f;
			thresh = Math.max(thresh, 0.0f);
			double d12 = biomeTerrainNoise.func_151601_a(i * 0.03, k * 0.03);
			if (d12 + biomeTerrainNoise.func_151601_a(i * 0.3, k * 0.3) > thresh) {
				if (random.nextInt(5) == 0) {
					top = Blocks.gravel;
				} else {
					top = Blocks.stone;
				}
				topMeta = 0;
				filler = Blocks.stone;
				fillerMeta = 0;
				int prevHeight = height;
				height++;
				if (random.nextInt(20) == 0) {
					// empty if block
				}
				for (int j = height; j >= prevHeight; --j) {
					int index = xzIndex * ySize + j;
					blocks[index] = Blocks.stone;
					meta[index] = 0;
				}
			}
		}
		if (enablePodzol) {
			boolean podzol = false;
			if (topBlock == Blocks.grass) {
				float trees = decorator.treesPerChunk + getTreeIncreaseChance();
				trees = Math.max(trees, variant.treeFactor * 0.5f);
				if (trees >= 1.0f) {
					float thresh = 0.8f;
					thresh -= trees * 0.15f;
					thresh = Math.max(thresh, 0.0f);
					double d = 0.06;
					double randNoise = biomeTerrainNoise.func_151601_a(i * d, k * d);
					if (randNoise > thresh) {
						podzol = true;
					}
				}
			}
			if (podzol) {
				terrainRand.setSeed(world.getSeed());
				terrainRand.setSeed(terrainRand.nextLong() + i * 4668095025L + k * 1387590552L ^ world.getSeed());
				float pdzRand = terrainRand.nextFloat();
				if (pdzRand < 0.35f) {
					top = Blocks.dirt;
					topMeta = 2;
				} else if (pdzRand < 0.5f) {
					top = Blocks.dirt;
					topMeta = 1;
				} else if (pdzRand < 0.51f) {
					top = Blocks.gravel;
					topMeta = 0;
				}
			}
		}
		if (variant.hasMarsh && LOTRBiomeVariant.marshNoise.func_151601_a(i * 0.1, k * 0.1) > -0.1) {
			for (int j = ySize - 1; j >= 0; --j) {
				int index = xzIndex * ySize + j;
				if (blocks[index] != null && blocks[index].getMaterial() == Material.air) {
					continue;
				}
				if (j != seaLevel - 1 || blocks[index] == Blocks.water) {
					break;
				}
				blocks[index] = Blocks.water;
				break;
			}
		}
		for (int j = ySize - 1; j >= 0; --j) {
			int index = xzIndex * ySize + j;
			if (j <= 0 + random.nextInt(5)) {
				blocks[index] = Blocks.bedrock;
				continue;
			}
			Block block = blocks[index];
			if (block == Blocks.air) {
				fillerDepth = -1;
				continue;
			}
			if (block != Blocks.stone) {
				continue;
			}
			if (fillerDepth == -1) {
				if (fillerDepthBase <= 0) {
					top = Blocks.air;
					topMeta = 0;
					filler = Blocks.stone;
					fillerMeta = 0;
				} else if (j >= seaLevel - 4 && j <= seaLevel + 1) {
					top = topBlock;
					topMeta = (byte) topBlockMeta;
					filler = fillerBlock;
					fillerMeta = (byte) fillerBlockMeta;
				}
				if (j < seaLevel && top == Blocks.air) {
					top = Blocks.water;
					topMeta = 0;
				}
				fillerDepth = fillerDepthBase;
				if (j >= seaLevel - 1) {
					blocks[index] = top;
					meta[index] = topMeta;
					continue;
				}
				blocks[index] = filler;
				meta[index] = fillerMeta;
				continue;
			}
			if (fillerDepth <= 0) {
				continue;
			}
			blocks[index] = filler;
			meta[index] = fillerMeta;
			if (--fillerDepth == 0) {
				boolean sand = false;
				if (filler == Blocks.sand) {
					if (fillerMeta == 1) {
						filler = LOTRMod.redSandstone;
					} else {
						filler = Blocks.sandstone;
					}
					fillerMeta = 0;
					sand = true;
				}
				if (filler == LOTRMod.whiteSand) {
					filler = LOTRMod.whiteSandstone;
					fillerMeta = 0;
					sand = true;
				}
				if (sand) {
					fillerDepth = 10 + random.nextInt(4);
				}
			}
			if ((this instanceof LOTRBiomeGenGondor || this instanceof LOTRBiomeGenIthilien || this instanceof LOTRBiomeGenDorEnErnil) && fillerDepth == 0 && filler == fillerBlock) {
				fillerDepth = 8 + random.nextInt(3);
				filler = LOTRMod.rock;
				fillerMeta = 1;
				continue;
			}
			if ((this instanceof LOTRBiomeGenRohan || this instanceof LOTRBiomeGenAdornland) && fillerDepth == 0 && filler == fillerBlock) {
				fillerDepth = 8 + random.nextInt(3);
				filler = LOTRMod.rock;
				fillerMeta = 2;
				continue;
			}
			if (!(this instanceof LOTRBiomeGenDorwinion) || fillerDepth != 0 || fillerBlock == LOTRMod.rock || filler != fillerBlock) {
				continue;
			}
			fillerDepth = 6 + random.nextInt(3);
			filler = LOTRMod.rock;
			fillerMeta = 5;
		}
		int rockDepth = (int) (stoneNoise * 6.0 + 2.0 + random.nextDouble() * 0.25);
		generateMountainTerrain(world, random, blocks, meta, i, k, xzIndex, ySize, height, rockDepth, variant);
		variant.generateVariantTerrain(world, random, blocks, meta, i, k, height, this);
	}

	protected void generateMountainTerrain(World world, Random random, Block[] blocks, byte[] meta, int i, int k, int xzIndex, int ySize, int height, int rockDepth, LOTRBiomeVariant variant) {
	}

	public final LOTREventSpawner.EventChance getBanditChance() {
		return banditChance;
	}

	public final Class<? extends LOTREntityBandit> getBanditEntityClass() {
		if (banditEntityClass == null) {
			return LOTREntityBandit.class;
		}
		return banditEntityClass;
	}

	@SideOnly(value = Side.CLIENT)
	public final int getBaseFoliageColor(int i, int j, int k) {
		LOTRBiomeVariant variant = ((LOTRWorldChunkManager) LOTRMod.proxy.getClientWorld().getWorldChunkManager()).getBiomeVariantAt(i, k);
		float temp = getFloatTemperature(i, j, k) + variant.tempBoost;
		float rain = rainfall + variant.rainBoost;
		temp = MathHelper.clamp_float(temp, 0.0f, 1.0f);
		rain = MathHelper.clamp_float(rain, 0.0f, 1.0f);
		return ColorizerFoliage.getFoliageColor(temp, rain);
	}

	@SideOnly(value = Side.CLIENT)
	public final int getBaseGrassColor(int i, int j, int k) {
		float temp = getFloatTemperature(i, j, k);
		float rain = rainfall;
		WorldChunkManager wcMgr = LOTRMod.proxy.getClientWorld().getWorldChunkManager();
		if (wcMgr instanceof LOTRWorldChunkManager) {
			LOTRBiomeVariant variant = ((LOTRWorldChunkManager) wcMgr).getBiomeVariantAt(i, k);
			temp += variant.tempBoost;
			rain += variant.rainBoost;
		}
		temp = MathHelper.clamp_float(temp, 0.0f, 1.0f);
		rain = MathHelper.clamp_float(rain, 0.0f, 1.0f);
		return ColorizerGrass.getGrassColor(temp, rain);
	}

	@SideOnly(value = Side.CLIENT)
	public final int getBaseSkyColorByTemp(int i, int j, int k) {
		return super.getSkyColorByTemp(getFloatTemperature(i, j, k));
	}

	public LOTRAchievement getBiomeAchievement() {
		return null;
	}

	public final String getBiomeDisplayName() {
		return StatCollector.translateToLocal("lotr.biome." + biomeName + ".name");
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public int getBiomeFoliageColor(int i, int j, int k) {
		return biomeColors.foliage != null ? biomeColors.foliage.getRGB() : getBaseFoliageColor(i, j, k);
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public int getBiomeGrassColor(int i, int j, int k) {
		return biomeColors.grass != null ? biomeColors.grass.getRGB() : getBaseGrassColor(i, j, k);
	}

	public abstract LOTRMusicRegion.Sub getBiomeMusic();

	public LOTRBiomeVariantList getBiomeVariantsLarge() {
		return biomeVariantsLarge;
	}

	public LOTRBiomeVariantList getBiomeVariantsSmall() {
		return biomeVariantsSmall;
	}

	public LOTRWaypoint.Region getBiomeWaypoints() {
		return null;
	}

	public LOTRRoadType.BridgeType getBridgeBlock() {
		return LOTRRoadType.BridgeType.DEFAULT;
	}

	public float getChanceToSpawnAnimals() {
		return 1.0f;
	}

	public final Vec3 getCloudColor(Vec3 clouds) {
		if (biomeColors.clouds != null) {
			float[] colors = biomeColors.clouds.getColorComponents(null);
			clouds.xCoord *= colors[0];
			clouds.yCoord *= colors[1];
			clouds.zCoord *= colors[2];
		}
		return clouds;
	}

	public boolean getEnableRain() {
		return enableRain;
	}

	public boolean getEnableRiver() {
		return true;
	}

	@Override
	public boolean getEnableSnow() {
		if (LOTRMod.isChristmas() && LOTRMod.proxy.isClient()) {
			return true;
		}
		return super.getEnableSnow();
	}

	public final Vec3 getFogColor(Vec3 fog) {
		if (biomeColors.fog != null) {
			float[] colors = biomeColors.fog.getColorComponents(null);
			fog.xCoord *= colors[0];
			fog.yCoord *= colors[1];
			fog.zCoord *= colors[2];
		}
		return fog;
	}

	public LOTRBiomeSpawnList getNPCSpawnList(World world, Random random, int i, int j, int k, LOTRBiomeVariant variant) {
		return npcSpawnList;
	}

	public BiomeGenBase.FlowerEntry getRandomFlower(World world, Random rand, int i, int j, int k) {
		return (BiomeGenBase.FlowerEntry) WeightedRandom.getRandomItem(rand, flowers);
	}

	public GrassBlockAndMeta getRandomGrass(Random random) {
		boolean fern = decorator.enableFern;
		boolean special = decorator.enableSpecialGrasses;
		if (fern && random.nextInt(3) == 0) {
			return new GrassBlockAndMeta(Blocks.tallgrass, 2);
		}
		if (special && random.nextInt(500) == 0) {
			return new GrassBlockAndMeta(LOTRMod.flaxPlant, 0);
		}
		if (random.nextInt(4) > 0) {
			if (special) {
				if (random.nextInt(200) == 0) {
					return new GrassBlockAndMeta(LOTRMod.tallGrass, 3);
				}
				if (random.nextInt(16) == 0) {
					return new GrassBlockAndMeta(LOTRMod.tallGrass, 1);
				}
				if (random.nextInt(10) == 0) {
					return new GrassBlockAndMeta(LOTRMod.tallGrass, 2);
				}
			}
			if (random.nextInt(80) == 0) {
				return new GrassBlockAndMeta(LOTRMod.tallGrass, 4);
			}
			return new GrassBlockAndMeta(LOTRMod.tallGrass, 0);
		}
		if (random.nextInt(3) == 0) {
			return new GrassBlockAndMeta(LOTRMod.clover, 0);
		}
		return new GrassBlockAndMeta(Blocks.tallgrass, 1);
	}

	public WorldGenerator getRandomWorldGenForDoubleFlower(Random random) {
		WorldGenDoublePlant doubleFlowerGen = new WorldGenDoublePlant();
		int i = random.nextInt(3);
		switch (i) {
		case 0: {
			doubleFlowerGen.func_150548_a(1);
			break;
		}
		case 1: {
			doubleFlowerGen.func_150548_a(4);
			break;
		}
		case 2: {
			doubleFlowerGen.func_150548_a(5);
		}
		}
		return doubleFlowerGen;
	}

	public WorldGenerator getRandomWorldGenForDoubleGrass(Random random) {
		WorldGenDoublePlant generator = new WorldGenDoublePlant();
		if (decorator.enableFern && random.nextInt(4) == 0) {
			generator.func_150548_a(3);
		} else {
			generator.func_150548_a(2);
		}
		return generator;
	}

	@Override
	public final WorldGenerator getRandomWorldGenForGrass(Random random) {
		GrassBlockAndMeta obj = getRandomGrass(random);
		return new WorldGenTallGrass(obj.block, obj.meta);
	}

	public LOTRRoadType getRoadBlock() {
		return LOTRRoadType.PATH;
	}

	@Override
	@SideOnly(value = Side.CLIENT)
	public final int getSkyColorByTemp(float f) {
		if (LOTRTickHandlerClient.scrapTraderMisbehaveTick > 0) {
			return 0;
		}
		if (biomeColors.sky != null) {
			return biomeColors.sky.getRGB();
		}
		return super.getSkyColorByTemp(f);
	}

	public int getSnowHeight() {
		return 0;
	}

	@Override
	public List getSpawnableList(EnumCreatureType creatureType) {
		if (creatureType == creatureType_LOTRAmbient) {
			return spawnableLOTRAmbientList;
		}
		return super.getSpawnableList(creatureType);
	}

	public final WorldGenAbstractTree getTreeGen(World world, Random random, int i, int j, int k) {
		LOTRWorldChunkManager chunkManager = (LOTRWorldChunkManager) world.getWorldChunkManager();
		LOTRBiomeVariant variant = chunkManager.getBiomeVariantAt(i, k);
		LOTRTreeType tree = decorator.getRandomTreeForVariant(random, variant);
		return tree.create(false, random);
	}

	public float getTreeIncreaseChance() {
		return 0.1f;
	}

	protected boolean hasDomesticAnimals() {
		return false;
	}

	public final boolean hasFog() {
		return biomeColors.foggy;
	}

	public boolean hasSeasonalGrass() {
		return temperature > 0.3f && temperature < 1.0f;
	}

	public boolean hasSky() {
		return true;
	}

	public final boolean isDwarvenBiome(World world) {
		if (initDwarven) {
			return isDwarven;
		}
		initDwarven = true;
		isDwarven = npcSpawnList.containsEntityClassByDefault(LOTREntityDwarf.class, world) && !npcSpawnList.containsEntityClassByDefault(LOTREntityWickedDwarf.class, world);
		return isDwarven;
	}

	public boolean isHiddenBiome() {
		return false;
	}

	public boolean isRiver() {
		return false;
	}

	public boolean isWateryBiome() {
		return heightBaseParameter < 0.0f;
	}

	protected double modifyStoneNoiseForFiller(double stoneNoise) {
		return stoneNoise;
	}

	@Override
	public final void plantFlower(World world, Random rand, int x, int y, int z) {
		BiomeGenBase.FlowerEntry flower = getRandomFlower(world, rand, x, y, z);
		if (flower == null || flower.block == null || !flower.block.canBlockStay(world, x, y, z)) {
			return;
		}
		world.setBlock(x, y, z, flower.block, flower.metadata, 3);
	}

	protected void registerForestFlowers() {
		flowers.clear();
		addDefaultFlowers();
		addFlower(LOTRMod.bluebell, 0, 5);
		addFlower(LOTRMod.marigold, 0, 10);
	}

	protected void registerHaradFlowers() {
		flowers.clear();
		addFlower(LOTRMod.haradFlower, 0, 10);
		addFlower(LOTRMod.haradFlower, 1, 10);
		addFlower(LOTRMod.haradFlower, 2, 5);
		addFlower(LOTRMod.haradFlower, 3, 5);
	}

	protected void registerJungleFlowers() {
		flowers.clear();
		addDefaultFlowers();
		addFlower(LOTRMod.haradFlower, 2, 20);
		addFlower(LOTRMod.haradFlower, 3, 20);
	}

	protected void registerMountainsFlowers() {
		flowers.clear();
		addDefaultFlowers();
		addFlower(Blocks.red_flower, 1, 10);
		addFlower(LOTRMod.bluebell, 0, 5);
	}

	protected void registerPlainsFlowers() {
		flowers.clear();
		addFlower(Blocks.red_flower, 4, 3);
		addFlower(Blocks.red_flower, 5, 3);
		addFlower(Blocks.red_flower, 6, 3);
		addFlower(Blocks.red_flower, 7, 3);
		addFlower(Blocks.red_flower, 0, 20);
		addFlower(Blocks.red_flower, 3, 20);
		addFlower(Blocks.red_flower, 8, 20);
		addFlower(Blocks.yellow_flower, 0, 30);
		addFlower(LOTRMod.bluebell, 0, 5);
		addFlower(LOTRMod.marigold, 0, 10);
		addFlower(LOTRMod.lavender, 0, 5);
	}

	protected void registerRhunForestFlowers() {
		registerForestFlowers();
		addFlower(LOTRMod.marigold, 0, 10);
		addFlower(LOTRMod.rhunFlower, 0, 10);
		addFlower(LOTRMod.rhunFlower, 1, 10);
		addFlower(LOTRMod.rhunFlower, 2, 10);
		addFlower(LOTRMod.rhunFlower, 3, 10);
		addFlower(LOTRMod.rhunFlower, 4, 10);
	}

	protected void registerRhunPlainsFlowers() {
		registerPlainsFlowers();
		addFlower(LOTRMod.marigold, 0, 10);
		addFlower(LOTRMod.rhunFlower, 0, 10);
		addFlower(LOTRMod.rhunFlower, 1, 10);
		addFlower(LOTRMod.rhunFlower, 2, 10);
		addFlower(LOTRMod.rhunFlower, 3, 10);
		addFlower(LOTRMod.rhunFlower, 4, 10);
	}

	protected void registerSavannaFlowers() {
		flowers.clear();
		addDefaultFlowers();
	}

	protected void registerSwampFlowers() {
		flowers.clear();
		addDefaultFlowers();
	}

	protected void registerTaigaFlowers() {
		flowers.clear();
		addDefaultFlowers();
		addFlower(Blocks.red_flower, 1, 10);
		addFlower(LOTRMod.bluebell, 0, 5);
	}

	protected void registerTravellingTrader(Class entityClass) {
		spawnableTraders.add(entityClass);
		LOTREventSpawner.createTraderSpawner(entityClass);
	}

	protected final void setBanditChance(LOTREventSpawner.EventChance c) {
		banditChance = c;
	}

	protected final void setBanditEntityClass(Class<? extends LOTREntityBandit> c) {
		banditEntityClass = c;
	}

	@Override
	public LOTRBiome setBiomeName(String s) {
		return (LOTRBiome) super.setBiomeName(s);
	}

	@Override
	public LOTRBiome setColor(int color) {
		Integer existingBiomeID = biomeDimension.colorsToBiomeIDs.get(color |= 0xFF000000);
		if (existingBiomeID != null) {
			throw new RuntimeException("LOTR biome (ID " + biomeID + ") is duplicating the color of another LOTR biome (ID " + existingBiomeID + ")");
		}
		biomeDimension.colorsToBiomeIDs.put(color, biomeID);
		return (LOTRBiome) super.setColor(color);
	}

	public LOTRBiome setMinMaxHeight(float f, float f1) {
		heightBaseParameter = f;
		f -= 2.0f;
		rootHeight = f += 0.2f;
		heightVariation = f1 / 2.0f;
		return this;
	}

	@Override
	public LOTRBiome setTemperatureRainfall(float f, float f1) {
		super.setTemperatureRainfall(f, f1);
		return this;
	}

	public int spawnCountMultiplier() {
		return 1;
	}

	public static void initBiomes() {
		river = new LOTRBiomeGenRiver(0, false).setMinMaxHeight(-0.5f, 0.0f).setColor(3570869).setBiomeName("river");
		ocean = new LOTRBiomeGenOcean(1, false).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(-1.0f, 0.0f).setColor(0x024B75).setBiomeName("ocean");
		ocean1 = new LOTRBiomeGenOcean(2, false).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(-0.9f, 0.0f).setColor(0x025582).setBiomeName("ocean");
		ocean2 = new LOTRBiomeGenOcean(3, false).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(-0.8f, 0.0f).setColor(0x026193).setBiomeName("ocean");
		ocean3 = new LOTRBiomeGenOcean(4, false).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(-0.7f, 0.0f).setColor(0x036FAC).setBiomeName("ocean");
		lake = new LOTRBiomeGenLake(5, false).setColor(3433630).setBiomeName("lake");
		lake1 = new LOTRBiomeGenLake(6, false).setColor(2906508).setBiomeName("lake");
		island = new LOTRBiomeGenOcean(7, false).setTemperatureRainfall(0.9f, 0.8f).setMinMaxHeight(0.0f, 0.3f).setColor(10138963).setBiomeName("island");
		beach = new LOTRBiomeGenBeach(8, false).setBeachBlock(Blocks.sand, 0).setColor(14404247).setBiomeName("beach");
		beachGravel = new LOTRBiomeGenBeach(9, false).setBeachBlock(Blocks.gravel, 0).setColor(9868704).setBiomeName("beachGravel");
		beachWhite = new LOTRBiomeGenBeach(10, false).setBeachBlock(LOTRMod.whiteSand, 0).setColor(15592941).setBiomeName("beachWhite");
		lindonCoast = new LOTRBiomeGenLindonCoast(11, false).setTemperatureRainfall(0.9f, 0.9f).setMinMaxHeight(0.0f, 0.5f).setColor(9278870).setBiomeName("lindonCoast");
		lindon = new LOTRBiomeGenLindon(12, true).setTemperatureRainfall(0.9f, 0.9f).setMinMaxHeight(0.15f, 0.2f).setColor(7646533).setBiomeName("lindon");
		lindonWoodlands = new LOTRBiomeGenLindonWoodlands(13, false).setTemperatureRainfall(0.9f, 1.0f).setMinMaxHeight(0.2f, 0.5f).setColor(1996591).setBiomeName("lindonWoodlands");
		blueMountains = new LOTRBiomeGenBlueMountains(14, true).setTemperatureRainfall(0.22f, 0.8f).setMinMaxHeight(1.0f, 2.5f).setColor(13228770).setBiomeName("blueMountains");
		blueMountainsFoothills = new LOTRBiomeGenBlueMountainsFoothills(15, true).setTemperatureRainfall(0.5f, 0.8f).setMinMaxHeight(0.5f, 0.9f).setColor(11253170).setBiomeName("blueMountainsFoothills");
		towerHills = new LOTRBiomeGenTowerHills(16, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.5f, 0.5f).setColor(6854209).setBiomeName("towerHills");
		eriador = new LOTRBiomeGenEriador(17, true).setTemperatureRainfall(0.9f, 0.8f).setMinMaxHeight(0.1f, 0.4f).setColor(7054916).setBiomeName("eriador");
		eriadorDowns = new LOTRBiomeGenEriadorDowns(18, true).setTemperatureRainfall(0.6f, 0.7f).setMinMaxHeight(0.5f, 0.5f).setColor(7638087).setBiomeName("eriadorDowns");
		breeland = new LOTRBiomeGenBreeland(20, true).setTemperatureRainfall(0.8f, 0.7f).setMinMaxHeight(0.1f, 0.2f).setColor(6268208).setBiomeName("breeland");
		chetwood = new LOTRBiomeGenChetwood(21, true).setTemperatureRainfall(0.8f, 0.9f).setMinMaxHeight(0.2f, 0.4f).setColor(5278763).setBiomeName("chetwood");
		angle = new LOTRBiomeGenAngle(22, true).setTemperatureRainfall(0.6f, 0.8f).setMinMaxHeight(0.15f, 0.3f).setColor(9416527).setBiomeName("angle");
		erynVorn = new LOTRBiomeGenErynVorn(23, false).setTemperatureRainfall(0.8f, 0.9f).setMinMaxHeight(0.1f, 0.4f).setColor(4357965).setBiomeName("erynVorn");
		minhiriath = new LOTRBiomeGenMinhiriath(24, true).setTemperatureRainfall(0.7f, 0.4f).setMinMaxHeight(0.1f, 0.2f).setColor(7380550).setBiomeName("minhiriath");
		swanfleet = new LOTRBiomeGenSwanfleet(26, true).setTemperatureRainfall(0.8f, 1.0f).setMinMaxHeight(0.0f, 0.1f).setColor(6265945).setBiomeName("swanfleet");
		eregion = new LOTRBiomeGenEregion(27, true).setTemperatureRainfall(0.6f, 0.7f).setMinMaxHeight(0.2f, 0.3f).setColor(6656072).setBiomeName("eregion");
		eregionForest = new LOTRBiomeGenEregion(28, false).setTemperatureRainfall(0.6f, 0.7f).setMinMaxHeight(0.2f, 0.3f).setColor(6658881).setBiomeName("eregionForest");
		enedwaith = new LOTRBiomeGenEnedwaith(29, true).setTemperatureRainfall(0.6f, 0.8f).setMinMaxHeight(0.2f, 0.3f).setColor(8038479).setBiomeName("enedwaith");
		dunland = new LOTRBiomeGenDunland(31, true).setTemperatureRainfall(0.4f, 0.7f).setMinMaxHeight(0.3f, 0.5f).setColor(6261060).setBiomeName("dunland");
		adornland = new LOTRBiomeGenAdornland(32, true).setTemperatureRainfall(0.7f, 0.6f).setMinMaxHeight(0.2f, 0.2f).setColor(6128966).setBiomeName("adornland");
		fangorn = new LOTRBiomeGenFangorn(33, true).setTemperatureRainfall(0.7f, 0.8f).setMinMaxHeight(0.2f, 0.4f).setColor(4355353).setBiomeName("fangorn");
		fangornClearing = new LOTRBiomeGenFangornClearing(34, false).setTemperatureRainfall(0.7f, 0.8f).setMinMaxHeight(0.2f, 0.1f).setColor(5877050).setBiomeName("fangornClearing");
		loneLands = new LOTRBiomeGenLoneLands(35, true).setTemperatureRainfall(0.6f, 0.5f).setMinMaxHeight(0.15f, 0.4f).setColor(8562762).setBiomeName("loneLands");
		loneLandsHills = new LOTRBiomeGenLoneLandsHills(36, false).setTemperatureRainfall(0.6f, 0.5f).setMinMaxHeight(0.6f, 0.8f).setColor(8687182).setBiomeName("loneLandsHills");
		rivendell = new LOTRBiomeGenRivendell(37, true).setTemperatureRainfall(0.9f, 1.0f).setMinMaxHeight(0.15f, 0.3f).setColor(8828714).setBiomeName("rivendell");
		rivendellHills = new LOTRBiomeGenRivendellHills(38, true).setTemperatureRainfall(0.7f, 0.8f).setMinMaxHeight(2.0f, 0.5f).setColor(14210481).setBiomeName("rivendellHills");
		trollshaws = new LOTRBiomeGenTrollshaws(39, true).setTemperatureRainfall(0.6f, 0.8f).setMinMaxHeight(0.15f, 1.0f).setColor(5798959).setBiomeName("trollshaws");
		ettenmoors = new LOTRBiomeGenEttenmoors(40, true).setTemperatureRainfall(0.2f, 0.6f).setMinMaxHeight(0.5f, 0.6f).setColor(8161626).setBiomeName("ettenmoors");
		coldfells = new LOTRBiomeGenColdfells(41, true).setTemperatureRainfall(0.25f, 0.8f).setMinMaxHeight(0.4f, 0.8f).setColor(8296018).setBiomeName("coldfells");
		angmar = new LOTRBiomeGenAngmar(42, true).setTemperatureRainfall(0.2f, 0.2f).setMinMaxHeight(0.2f, 0.6f).setColor(7305047).setBiomeName("angmar");
		angmarMountains = new LOTRBiomeGenAngmarMountains(43, true).setTemperatureRainfall(0.25f, 0.1f).setMinMaxHeight(1.6f, 1.5f).setColor(13619147).setBiomeName("angmarMountains");
		tundra = new LOTRBiomeGenTundra(44, true).setTemperatureRainfall(0.1f, 0.3f).setMinMaxHeight(0.1f, 0.2f).setColor(13748405).setBiomeName("tundra");
		taiga = new LOTRBiomeGenTaiga(45, true).setTemperatureRainfall(0.1f, 0.7f).setMinMaxHeight(0.1f, 0.5f).setColor(6526543).setBiomeName("taiga");
		forodwaith = new LOTRBiomeGenForodwaith(46, true).setTemperatureRainfall(0.0f, 0.2f).setMinMaxHeight(0.1f, 0.1f).setColor(14211282).setBiomeName("forodwaith");
		forodwaithMountains = new LOTRBiomeGenForodwaithMountains(47, true).setTemperatureRainfall(0.0f, 0.2f).setMinMaxHeight(2.0f, 2.0f).setColor(15592942).setBiomeName("forodwaithMountains");
		forodwaithGlacier = new LOTRBiomeGenForodwaithGlacier(48, true).setTemperatureRainfall(0.0f, 0.1f).setMinMaxHeight(1.0f, 0.1f).setColor(9424096).setBiomeName("forodwaithGlacier");
		forodwaithCoast = new LOTRBiomeGenForodwaithCoast(49, false).setTemperatureRainfall(0.0f, 0.4f).setMinMaxHeight(0.0f, 0.5f).setColor(9214637).setBiomeName("forodwaithCoast");
		mistyMountains = new LOTRBiomeGenMistyMountains(50, true).setTemperatureRainfall(0.2f, 0.5f).setMinMaxHeight(2.0f, 2.0f).setColor(15263713).setBiomeName("mistyMountains");
		mistyMountainsFoothills = new LOTRBiomeGenMistyMountainsFoothills(51, true).setTemperatureRainfall(0.25f, 0.6f).setMinMaxHeight(0.7f, 0.9f).setColor(12501430).setBiomeName("mistyMountainsFoothills");
		greyMountains = new LOTRBiomeGenGreyMountains(55, true).setTemperatureRainfall(0.28f, 0.2f).setMinMaxHeight(1.8f, 2.0f).setColor(12106416).setBiomeName("greyMountains");
		greyMountainsFoothills = new LOTRBiomeGenGreyMountainsFoothills(56, true).setTemperatureRainfall(0.5f, 0.7f).setMinMaxHeight(0.5f, 0.9f).setColor(9148000).setBiomeName("greyMountainsFoothills");
		anduinHills = new LOTRBiomeGenAnduin(57, true).setTemperatureRainfall(0.7f, 0.7f).setMinMaxHeight(0.6f, 0.4f).setColor(7058012).setBiomeName("anduinHills");
		anduinMouth = new LOTRBiomeGenAnduinMouth(58, true).setTemperatureRainfall(0.9f, 1.0f).setMinMaxHeight(0.0f, 0.1f).setColor(5089363).setBiomeName("anduinMouth");
		anduinVale = new LOTRBiomeGenAnduinVale(59, true).setTemperatureRainfall(0.9f, 1.1f).setMinMaxHeight(0.05f, 0.05f).setColor(7447880).setBiomeName("anduinVale");
		emynMuil = new LOTRBiomeGenEmynMuil(60, true).setTemperatureRainfall(0.5f, 0.9f).setMinMaxHeight(0.2f, 0.8f).setColor(9866354).setBiomeName("emynMuil");
		gladdenFields = new LOTRBiomeGenGladdenFields(61, true).setTemperatureRainfall(0.6f, 1.2f).setMinMaxHeight(0.0f, 0.1f).setColor(5020505).setBiomeName("gladdenFields");
		lothlorien = new LOTRBiomeGenLothlorien(62, true).setTemperatureRainfall(0.9f, 1.0f).setMinMaxHeight(0.1f, 0.3f).setColor(16504895).setBiomeName("lothlorien");
		lothlorienEdge = new LOTRBiomeGenLothlorienEdge(63, true).setTemperatureRainfall(0.9f, 1.0f).setMinMaxHeight(0.1f, 0.2f).setColor(13944387).setBiomeName("lothlorienEdge");
		celebrant = new LOTRBiomeGenCelebrant(64, true).setTemperatureRainfall(1.1f, 1.1f).setMinMaxHeight(0.1f, 0.05f).setColor(7647046).setBiomeName("celebrant");
		celebrantForest = new LOTRBiomeGenCelebrant(65, false).setTemperatureRainfall(1.1f, 1.1f).setMinMaxHeight(0.1f, 0.05f).setColor(6528561).setBiomeName("celebrantForest");
		mirkwoodMountains = new LOTRBiomeGenMirkwoodMountains(66, true).setTemperatureRainfall(0.28f, 0.9f).setMinMaxHeight(1.2f, 1.5f).setColor(2632989).setBiomeName("mirkwoodMountains");
		woodlandRealm = new LOTRBiomeGenWoodlandRealm(67, true).setTemperatureRainfall(0.8f, 0.9f).setMinMaxHeight(0.2f, 0.3f).setColor(4089126).setBiomeName("woodlandRealm");
		mirkwoodCorrupted = new LOTRBiomeGenMirkwoodCorrupted(68, true).setTemperatureRainfall(0.6f, 0.8f).setMinMaxHeight(0.2f, 0.4f).setColor(3032091).setBiomeName("mirkwoodCorrupted");
		mirkwoodNorth = new LOTRBiomeGenMirkwoodNorth(69, true).setTemperatureRainfall(0.7f, 0.7f).setMinMaxHeight(0.2f, 0.4f).setColor(3822115).setBiomeName("mirkwoodNorth");
		woodlandRealmHills = new LOTRBiomeGenWoodlandRealmHills(70, false).setTemperatureRainfall(0.8f, 0.6f).setMinMaxHeight(0.9f, 0.7f).setColor(4087079).setBiomeName("woodlandRealmHills");
		eastBight = new LOTRBiomeGenEastBight(71, true).setTemperatureRainfall(0.8f, 0.3f).setMinMaxHeight(0.15f, 0.05f).setColor(9082205).setBiomeName("eastBight");
		erebor = new LOTRBiomeGenErebor(77, true).setTemperatureRainfall(0.6f, 0.7f).setMinMaxHeight(0.4f, 0.6f).setColor(7499093).setBiomeName("erebor");
		ironHills = new LOTRBiomeGenIronHills(78, true).setTemperatureRainfall(0.27f, 0.4f).setMinMaxHeight(0.3f, 1.4f).setColor(9142093).setBiomeName("ironHills");
		wilderland = new LOTRBiomeGenWilderland(79, true).setTemperatureRainfall(0.9f, 0.4f).setMinMaxHeight(0.2f, 0.4f).setColor(9612368).setBiomeName("wilderland");
		wold = new LOTRBiomeGenWold(81, true).setTemperatureRainfall(0.9f, 0.1f).setMinMaxHeight(0.4f, 0.3f).setColor(9483599).setBiomeName("wold");
		gondor = new LOTRBiomeGenGondor(85, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.1f, 0.15f).setColor(8959045).setBiomeName("gondor");
		gondorWoodlands = new LOTRBiomeGenGondorWoodlands(86, false).setTemperatureRainfall(0.8f, 0.9f).setMinMaxHeight(0.2f, 0.2f).setColor(7972921).setBiomeName("gondorWoodlands");
		ithilien = new LOTRBiomeGenIthilien(88, true).setTemperatureRainfall(0.9f, 0.9f).setMinMaxHeight(0.15f, 0.5f).setColor(7710516).setBiomeName("ithilien");
		ithilienHills = new LOTRBiomeGenIthilienHills(89, false).setTemperatureRainfall(0.7f, 0.7f).setMinMaxHeight(0.6f, 0.6f).setColor(6985792).setBiomeName("ithilienHills");
		ithilienWasteland = new LOTRBiomeGenIthilienWasteland(90, true).setTemperatureRainfall(0.6f, 0.6f).setMinMaxHeight(0.15f, 0.2f).setColor(8030031).setBiomeName("ithilienWasteland");
		pelennor = new LOTRBiomeGenPelennor(91, true).setTemperatureRainfall(0.9f, 0.9f).setMinMaxHeight(0.1f, 0.02f).setColor(11258955).setBiomeName("pelennor");
		pelargir = new LOTRBiomeGenPelargir(92, true).setTemperatureRainfall(1.0f, 1.0f).setMinMaxHeight(0.08f, 0.2f).setColor(9414713).setBiomeName("pelargir");
		lossarnach = new LOTRBiomeGenLossarnach(93, true).setTemperatureRainfall(1.0f, 1.0f).setMinMaxHeight(0.1f, 0.2f).setColor(8439086).setBiomeName("lossarnach");
		imlothMelui = new LOTRBiomeGenImlothMelui(94, true).setTemperatureRainfall(1.0f, 1.2f).setMinMaxHeight(0.1f, 0.2f).setColor(14517608).setBiomeName("imlothMelui");
		lebennin = new LOTRBiomeGenLebennin(95, true).setTemperatureRainfall(1.0f, 0.9f).setMinMaxHeight(0.1f, 0.3f).setColor(7845418).setBiomeName("lebennin");
		dorEnErnil = new LOTRBiomeGenDorEnErnil(96, true).setTemperatureRainfall(0.9f, 0.9f).setMinMaxHeight(0.07f, 0.2f).setColor(8502338).setBiomeName("dorEnErnil");
		dorEnErnilHills = new LOTRBiomeGenDorEnErnilHills(97, false).setTemperatureRainfall(0.8f, 0.7f).setMinMaxHeight(0.5f, 0.5f).setColor(7906614).setBiomeName("dorEnErnilHills");
		tolfalas = new LOTRBiomeGenTolfalas(98, true).setTemperatureRainfall(0.8f, 0.4f).setMinMaxHeight(0.3f, 1.0f).setColor(10199149).setBiomeName("tolfalas");
		lamedon = new LOTRBiomeGenLamedon(99, true).setTemperatureRainfall(0.9f, 0.5f).setMinMaxHeight(0.2f, 0.2f).setColor(10927460).setBiomeName("lamedon");
		lamedonHills = new LOTRBiomeGenLamedonHills(100, true).setTemperatureRainfall(0.6f, 0.4f).setMinMaxHeight(0.6f, 0.9f).setColor(13555369).setBiomeName("lamedonHills");
		blackrootVale = new LOTRBiomeGenBlackrootVale(101, true).setTemperatureRainfall(0.8f, 0.9f).setMinMaxHeight(0.2f, 0.12f).setColor(7183921).setBiomeName("blackrootVale");
		pinnathGelin = new LOTRBiomeGenPinnathGelin(102, false).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.5f, 0.5f).setColor(8562746).setBiomeName("pinnathGelin");
		andrast = new LOTRBiomeGenAndrast(104, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.2f, 0.2f).setColor(8885856).setBiomeName("andrast");
		pukel = new LOTRBiomeGenPukel(105, true).setTemperatureRainfall(0.7f, 0.7f).setMinMaxHeight(0.2f, 0.4f).setColor(5667394).setBiomeName("pukel");
		mordor = new LOTRBiomeGenMordor(106, true).setTemperatureRainfall(2.0f, 0.0f).setMinMaxHeight(0.3f, 0.5f).setColor(2828578).setBiomeName("mordor");
		mordorMountains = new LOTRBiomeGenMordorMountains(107, true).setTemperatureRainfall(2.0f, 0.0f).setMinMaxHeight(2.0f, 3.0f).setColor(4737094).setBiomeName("mordorMountains");
		udun = new LOTRBiomeGenUdun(108, true).setTemperatureRainfall(1.5f, 0.0f).setMinMaxHeight(0.2f, 0.7f).setColor(65536).setBiomeName("udun");
		gorgoroth = new LOTRBiomeGenGorgoroth(109, true).setTemperatureRainfall(2.0f, 0.0f).setMinMaxHeight(0.6f, 0.2f).setColor(1447186).setBiomeName("gorgoroth");
		morgulVale = new LOTRBiomeGenMorgulVale(110, true).setTemperatureRainfall(1.0f, 0.0f).setMinMaxHeight(0.2f, 0.1f).setColor(5597234).setBiomeName("morgulVale");
		nanUngol = new LOTRBiomeGenNanUngol(111, true).setTemperatureRainfall(2.0f, 0.0f).setMinMaxHeight(0.1f, 0.4f).setColor(656641).setBiomeName("nanUngol");
		easternDesolation = new LOTRBiomeGenEasternDesolation(112, true).setTemperatureRainfall(1.0f, 0.3f).setMinMaxHeight(0.2f, 0.2f).setColor(6712392).setBiomeName("easternDesolation");
		nurn = new LOTRBiomeGenNurn(113, true).setTemperatureRainfall(0.9f, 0.4f).setMinMaxHeight(0.1f, 0.2f).setColor(3818531).setBiomeName("nurn");
		nurnMarshes = new LOTRBiomeGenNurnMarshes(114, true).setTemperatureRainfall(0.9f, 0.4f).setMinMaxHeight(0.0f, 0.1f).setColor(4150323).setBiomeName("nurnMarshes");
		nurnen = new LOTRBiomeGenNurnen(115, false).setTemperatureRainfall(0.9f, 0.4f).setMinMaxHeight(-1.0f, 0.3f).setColor(2702427).setBiomeName("nurnen");
		nurnen1 = new LOTRBiomeGenNurnen(116, false).setTemperatureRainfall(0.9f, 0.4f).setMinMaxHeight(-1.0f, 0.3f).setColor(2307151).setBiomeName("nurnen1");
		nurnen2 = new LOTRBiomeGenNurnen(117, false).setTemperatureRainfall(0.9f, 0.4f).setMinMaxHeight(-1.0f, 0.3f).setColor(1911359).setBiomeName("nurnen2");
		dorwinion = new LOTRBiomeGenDorwinion(118, true).setTemperatureRainfall(0.9f, 0.9f).setMinMaxHeight(0.1f, 0.3f).setColor(7120197).setBiomeName("dorwinion");
		dorwinionHills = new LOTRBiomeGenDorwinionHills(119, true).setTemperatureRainfall(0.9f, 0.8f).setMinMaxHeight(0.8f, 0.8f).setColor(13357993).setBiomeName("dorwinionHills");
		rhun = new LOTRBiomeGenRhun(120, true).setTemperatureRainfall(0.9f, 0.3f).setMinMaxHeight(0.3f, 0.0f).setColor(10465880).setBiomeName("rhun");
		rhunForest = new LOTRBiomeGenRhunForest(121, true).setTemperatureRainfall(0.8f, 0.9f).setMinMaxHeight(0.3f, 0.5f).setColor(7505723).setBiomeName("rhunForest");
		rhunLand = new LOTRBiomeGenRhunLand(122, true).setTemperatureRainfall(1.0f, 0.8f).setMinMaxHeight(0.1f, 0.3f).setColor(11381583).setBiomeName("rhunLand");
		rhunLandSteppe = new LOTRBiomeGenRhunLandSteppe(124, true).setTemperatureRainfall(1.0f, 0.3f).setMinMaxHeight(0.2f, 0.05f).setColor(11712354).setBiomeName("rhunLandSteppe");
		rhunLandHills = new LOTRBiomeGenRhunLandHills(125, true).setTemperatureRainfall(1.0f, 0.5f).setMinMaxHeight(0.6f, 0.8f).setColor(9342286).setBiomeName("rhunLandHills");
		rhunRedForest = new LOTRBiomeGenRhunRedForest(126, true).setTemperatureRainfall(0.9f, 1.0f).setMinMaxHeight(0.1f, 0.3f).setColor(9530430).setBiomeName("rhunRedForest");
		rhunIsland = new LOTRBiomeGenRhunIsland(127, false).setTemperatureRainfall(1.0f, 0.8f).setMinMaxHeight(0.1f, 0.4f).setColor(10858839).setBiomeName("rhunIsland");
		rhunIslandForest = new LOTRBiomeGenRhunIslandForest(128, false).setTemperatureRainfall(0.9f, 1.0f).setMinMaxHeight(0.1f, 0.4f).setColor(9533758).setBiomeName("rhunIslandForest");
		redMountains = new LOTRBiomeGenRedMountains(129, true).setTemperatureRainfall(0.3f, 0.4f).setMinMaxHeight(1.5f, 2.0f).setColor(9662796).setBiomeName("redMountains");
		redMountainsFoothills = new LOTRBiomeGenRedMountainsFoothills(130, true).setTemperatureRainfall(0.7f, 0.4f).setMinMaxHeight(0.5f, 0.9f).setColor(10064978).setBiomeName("redMountainsFoothills");
		lastDesert = new LOTRBiomeGenLastDesert(131, true).setTemperatureRainfall(0.7f, 0.0f).setMinMaxHeight(0.2f, 0.05f).setColor(13878151).setBiomeName("lastDesert");
		windMountains = new LOTRBiomeGenWindMountains(132, true).setTemperatureRainfall(0.28f, 0.2f).setMinMaxHeight(2.0f, 2.0f).setColor(13882323).setBiomeName("windMountains");
		windMountainsFoothills = new LOTRBiomeGenWindMountainsFoothills(133, true).setTemperatureRainfall(0.4f, 0.6f).setMinMaxHeight(0.5f, 0.6f).setColor(10133354).setBiomeName("windMountainsFoothills");
		harondor = new LOTRBiomeGenHarondor(134, true).setTemperatureRainfall(1.0f, 0.6f).setMinMaxHeight(0.2f, 0.3f).setColor(10663238).setBiomeName("harondor");
		harnedor = new LOTRBiomeGenHarnedor(135, true).setTemperatureRainfall(1.0f, 0.3f).setMinMaxHeight(0.1f, 0.3f).setColor(11449173).setBiomeName("harnedor");
		lostladen = new LOTRBiomeGenLostladen(136, true).setTemperatureRainfall(1.2f, 0.2f).setMinMaxHeight(0.2f, 0.1f).setColor(10658661).setBiomeName("lostladen");
		umbar = new LOTRBiomeGenUmbar(137, true).setTemperatureRainfall(0.9f, 0.6f).setMinMaxHeight(0.1f, 0.2f).setColor(9542740).setBiomeName("umbar");
		umbarForest = new LOTRBiomeGenUmbarForest(138, false).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.2f, 0.3f).setColor(7178042).setBiomeName("umbarForest");
		umbarHills = new LOTRBiomeGenUmbar(139, false).setTemperatureRainfall(0.8f, 0.5f).setMinMaxHeight(1.2f, 0.8f).setColor(8357717).setBiomeName("umbarHills");
		nearHarad = new LOTRBiomeGenNearHarad(140, true).setTemperatureRainfall(1.5f, 0.1f).setMinMaxHeight(0.2f, 0.1f).setColor(14205815).setBiomeName("nearHarad");
		haradMountains = new LOTRBiomeGenHaradMountains(141, true).setTemperatureRainfall(0.9f, 0.5f).setMinMaxHeight(1.8f, 2.0f).setColor(9867381).setBiomeName("haradMountains");
		nearHaradHills = new LOTRBiomeGenNearHaradHills(142, false).setTemperatureRainfall(1.2f, 0.3f).setMinMaxHeight(0.5f, 0.8f).setColor(12167010).setBiomeName("nearHaradHills");
		farHaradForest = new LOTRBiomeGenFarHaradForest(143, true).setTemperatureRainfall(1.0f, 1.0f).setMinMaxHeight(0.3f, 0.4f).setColor(3703325).setBiomeName("farHaradForest");
		nearHaradFertile = new LOTRBiomeGenNearHaradFertile(144, true).setTemperatureRainfall(1.2f, 0.7f).setMinMaxHeight(0.2f, 0.1f).setColor(10398286).setBiomeName("nearHaradFertile");
		nearHaradSemiDesert = new LOTRBiomeGenNearHaradSemiDesert(145, true).setTemperatureRainfall(1.5f, 0.2f).setMinMaxHeight(0.2f, 0.1f).setColor(12434282).setBiomeName("nearHaradSemiDesert");

		nearHaradFertileForest = new LOTRBiomeGenNearHaradFertileForest(146, false).setTemperatureRainfall(1.2f, 1.0f).setMinMaxHeight(0.2f, 0.4f).setColor(6915122).setBiomeName("nearHaradFertileForest");
		nearHaradRedDesert = new LOTRBiomeGenNearHaradRed(147, true).setTemperatureRainfall(1.5f, 0.1f).setMinMaxHeight(0.2f, 0.0f).setColor(13210447).setBiomeName("nearHaradRedDesert");
		nearHaradRiverbank = new LOTRBiomeGenNearHaradRiverbank(148, false).setTemperatureRainfall(1.2f, 0.8f).setMinMaxHeight(0.1f, 0.1f).setColor(7183952).setBiomeName("nearHaradRiverbank");
		nearHaradOasis = new LOTRBiomeGenNearHaradOasis(149, false).setTemperatureRainfall(1.2f, 0.8f).setMinMaxHeight(0.1f, 0.1f).setColor(832768).setBiomeName("nearHaradOasis");
		gulfHarad = new LOTRBiomeGenGulfHarad(150, true).setTemperatureRainfall(1.0f, 0.5f).setMinMaxHeight(0.15f, 0.1f).setColor(9152592).setBiomeName("gulfHarad");
		gulfHaradForest = new LOTRBiomeGenGulfHaradForest(151, false).setTemperatureRainfall(1.0f, 1.0f).setMinMaxHeight(0.2f, 0.4f).setColor(5868590).setBiomeName("gulfHaradForest");
		farHarad = new LOTRBiomeGenFarHaradSavannah(152, true).setTemperatureRainfall(1.2f, 0.2f).setMinMaxHeight(0.1f, 0.1f).setColor(9740353).setBiomeName("farHarad");
		farHaradVolcano = new LOTRBiomeGenFarHaradVolcano(153, true).setTemperatureRainfall(1.5f, 0.0f).setMinMaxHeight(0.6f, 1.2f).setColor(6838068).setBiomeName("farHaradVolcano");
		farHaradCoast = new LOTRBiomeGenFarHaradCoast(154, false).setTemperatureRainfall(1.2f, 0.8f).setMinMaxHeight(0.0f, 0.5f).setColor(8356472).setBiomeName("farHaradCoast");
		farHaradJungle = new LOTRBiomeGenFarHaradJungle(155, true).setTemperatureRainfall(1.2f, 0.9f).setMinMaxHeight(0.2f, 0.4f).setColor(4944931).setBiomeName("farHaradJungle");
		farHaradJungleEdge = new LOTRBiomeGenFarHaradJungleEdge(156, true).setTemperatureRainfall(1.2f, 0.8f).setMinMaxHeight(0.2f, 0.2f).setColor(7440430).setBiomeName("farHaradJungleEdge");
		farHaradJungleLake = new LOTRBiomeGenFarHaradJungleLake(157, false).setTemperatureRainfall(1.2f, 0.9f).setMinMaxHeight(-0.5f, 0.2f).setColor(2271948).setBiomeName("farHaradJungleLake");
		tauredainClearing = new LOTRBiomeGenTauredainClearing(158, true).setTemperatureRainfall(1.2f, 0.8f).setMinMaxHeight(0.2f, 0.2f).setColor(10796101).setBiomeName("tauredainClearing");
		farHaradArid = new LOTRBiomeGenFarHaradArid(159, true).setTemperatureRainfall(1.5f, 0.3f).setMinMaxHeight(0.2f, 0.15f).setColor(11185749).setBiomeName("farHaradArid");
		farHaradAridHills = new LOTRBiomeGenFarHaradArid(160, false).setTemperatureRainfall(1.5f, 0.3f).setMinMaxHeight(1.0f, 0.6f).setColor(10063195).setBiomeName("farHaradAridHills");
		farHaradSwamp = new LOTRBiomeGenFarHaradSwamp(161, true).setTemperatureRainfall(0.8f, 1.0f).setMinMaxHeight(0.0f, 0.1f).setColor(5608267).setBiomeName("farHaradSwamp");
		farHaradCloudForest = new LOTRBiomeGenFarHaradCloudForest(162, true).setTemperatureRainfall(1.2f, 1.2f).setMinMaxHeight(0.7f, 0.4f).setColor(3046208).setBiomeName("farHaradCloudForest");
		farHaradBushland = new LOTRBiomeGenFarHaradBushland(163, true).setTemperatureRainfall(1.0f, 0.4f).setMinMaxHeight(0.2f, 0.1f).setColor(10064190).setBiomeName("farHaradBushland");
		farHaradBushlandHills = new LOTRBiomeGenFarHaradBushland(164, false).setTemperatureRainfall(0.8f, 0.4f).setMinMaxHeight(0.8f, 0.8f).setColor(8354100).setBiomeName("farHaradBushlandHills");
		farHaradMangrove = new LOTRBiomeGenFarHaradMangrove(165, true).setTemperatureRainfall(1.0f, 0.9f).setMinMaxHeight(-0.05f, 0.05f).setColor(8883789).setBiomeName("farHaradMangrove");
		farHaradJungleMountains = new LOTRBiomeGenFarHaradJungleMountains(166, true).setTemperatureRainfall(1.0f, 1.0f).setMinMaxHeight(1.8f, 1.5f).setColor(6511174).setBiomeName("farHaradJungleMountains");
		halfTrollForest = new LOTRBiomeGenHalfTrollForest(167, true).setTemperatureRainfall(0.8f, 0.2f).setMinMaxHeight(0.3f, 0.4f).setColor(5992500).setBiomeName("halfTrollForest");
		pertorogwaith = new LOTRBiomeGenPertorogwaith(168, true).setTemperatureRainfall(0.7f, 0.1f).setMinMaxHeight(0.2f, 0.5f).setColor(8879706).setBiomeName("pertorogwaith");
		farHaradKanuka = new LOTRBiomeGenKanuka(169, true).setTemperatureRainfall(1.0f, 1.0f).setMinMaxHeight(0.3f, 0.5f).setColor(5142552).setBiomeName("farHaradKanuka");
		deadMarshes = new LOTRBiomeGenDeadMarshes(170, true).setTemperatureRainfall(0.4f, 1.0f).setMinMaxHeight(0.0f, 0.1f).setColor(7303999).setBiomeName("deadMarshes");
		oldForest = new LOTRBiomeGenOldForest(171, true).setTemperatureRainfall(0.5f, 1.0f).setMinMaxHeight(0.2f, 0.3f).setColor(4551995).setBiomeName("oldForest");
		midgewater = new LOTRBiomeGenMidgewater(172, true).setTemperatureRainfall(0.6f, 1.0f).setMinMaxHeight(0.0f, 0.1f).setColor(6392136).setBiomeName("midgewater");
		brownLands = new LOTRBiomeGenBrownLands(173, true).setTemperatureRainfall(1.0f, 0.2f).setMinMaxHeight(0.2f, 0.2f).setColor(8552016).setBiomeName("brownLands");
		meneltarma = new LOTRBiomeGenMeneltarma(174, false).setTemperatureRainfall(0.9f, 0.8f).setMinMaxHeight(0.1f, 0.2f).setColor(9549658).setBiomeName("meneltarma");
		dagorlad = new LOTRBiomeGenDagorlad(175, true).setTemperatureRainfall(1.0f, 0.2f).setMinMaxHeight(0.1f, 0.05f).setColor(7036741).setBiomeName("dagorlad");
		entwashMouth = new LOTRBiomeGenEntwashMouth(176, true).setTemperatureRainfall(1.0f, 0.5f).setMinMaxHeight(0.0f, 0.1f).setColor(5612358).setBiomeName("entwashMouth");
		fangornWasteland = new LOTRBiomeGenFangornWasteland(177, true).setTemperatureRainfall(0.7f, 0.4f).setMinMaxHeight(0.2f, 0.4f).setColor(6782028).setBiomeName("fangornWasteland");
		barrowDowns = new LOTRBiomeGenBarrowDowns(178, true).setTemperatureRainfall(0.6f, 0.7f).setMinMaxHeight(0.3f, 0.4f).setColor(8097362).setBiomeName("barrowDowns");
		longMarshes = new LOTRBiomeGenLongMarshes(179, true).setTemperatureRainfall(0.6f, 0.9f).setMinMaxHeight(0.0f, 0.1f).setColor(7178054).setBiomeName("longMarshes");
		nindalf = new LOTRBiomeGenNindalf(180, true).setTemperatureRainfall(0.4f, 1.0f).setMinMaxHeight(0.0f, 0.1f).setColor(7111750).setBiomeName("nindalf");
		nanCurunir = new LOTRBiomeGenNanCurunir(181, true).setTemperatureRainfall(0.6f, 0.4f).setMinMaxHeight(0.2f, 0.1f).setColor(7109714).setBiomeName("nanCurunir");
		dolGuldur = new LOTRBiomeGenDolGuldur(182, true).setTemperatureRainfall(0.6f, 0.8f).setMinMaxHeight(0.2f, 0.5f).setColor(2371343).setBiomeName("dolGuldur");
		whiteMountains = new LOTRBiomeGenWhiteMountains(183, true).setTemperatureRainfall(0.6f, 0.8f).setMinMaxHeight(1.5f, 2.0f).setColor(15066600).setBiomeName("whiteMountains");
		whiteMountainsFoothills = new LOTRBiomeGenWhiteMountainsFoothills(184, true).setTemperatureRainfall(0.6f, 0.7f).setMinMaxHeight(0.5f, 0.9f).setColor(12635575).setBiomeName("whiteMountainsFoothills");
		harlindon = new LOTRBiomeGenLindon(185, true).setTemperatureRainfall(0.9f, 0.9f).setMinMaxHeight(0.15f, 0.2f).setColor(7514179).setBiomeName("harlindon");
		utumno = new LOTRBiomeGenUtumno(0).setTemperatureRainfall(2.0f, 0.0f).setMinMaxHeight(0.0f, 0.0f).setColor(0).setBiomeName("utumno");
		rhovanion = new LOTRBiomeGenRhovanion(72, true).setTemperatureRainfall(0.8f, 0.7f).setMinMaxHeight(0.1f, 0.2f).setColor(8233807).setBiomeName("rhovanion");
		rhovanionFields = new LOTRBiomeGenRhovanionFields(73, true).setTemperatureRainfall(0.7f, 0.7f).setMinMaxHeight(0.1f, 0.2f).setColor(7574354).setBiomeName("rhovanionFields");
		rhovanionFieldsForest = new LOTRBiomeGenRhovanionFieldsForest(74, true).setTemperatureRainfall(0.8f, 0.7f).setMinMaxHeight(0.1f, 0.2f).setColor(7181893).setBiomeName("rhovanionFieldsForest");
		rhovanionNorth = new LOTRBiomeGenRhovanionNorth(75, true).setTemperatureRainfall(0.6f, 0.6f).setMinMaxHeight(0.2f, 0.5f).setColor(7113037).setBiomeName("rhovanionNorth");
		rhovanionNorthForest = new LOTRBiomeGenRhovanionNorthForest(76, true).setTemperatureRainfall(0.6f, 0.6f).setMinMaxHeight(0.2f, 0.5f).setColor(6588735).setBiomeName("rhovanionNorthForest");
		gundabad = new LOTRBiomeGenGundabad(52, true).setTemperatureRainfall(0.2f, 0.5f).setMinMaxHeight(2.0f, 2.0f).setColor(14212048).setBiomeName("gundabad");
		khazadDum = new LOTRBiomeGenKhazadDum(53, true).setTemperatureRainfall(0.2f, 0.5f).setMinMaxHeight(2.0f, 2.0f).setColor(12895942).setBiomeName("khazadDum");
		khazadDumFoothills = new LOTRBiomeGenKhazadDumFoothills(54, true).setTemperatureRainfall(0.25f, 0.6f).setMinMaxHeight(0.7f, 0.9f).setColor(13620179).setBiomeName("khazadDumFoothills");
		enedwaithForest = new LOTRBiomeGenEnedwaithForest(30, true).setTemperatureRainfall(0.4f, 0.7f).setMinMaxHeight(0.3f, 0.5f).setColor(6920524).setBiomeName("enedwaithForest");
		gwathlo = new LOTRBiomeGenGwathlo(25, true).setTemperatureRainfall(0.9f, 0.8f).setMinMaxHeight(0.1f, 0.3f).setColor(11321943).setBiomeName("gwathlo");
		eriadorForest = new LOTRBiomeGenEriadorForest(19, false).setTemperatureRainfall(0.9f, 1.0f).setMinMaxHeight(0.2f, 0.5f).setColor(6000954).setBiomeName("eriadorForest");
		wilderlandForest = new LOTRBiomeGenWilderlandForest(80, false).setTemperatureRainfall(0.9f, 0.4f).setMinMaxHeight(0.2f, 0.4f).setColor(7706181).setBiomeName("wilderlandForest");
		calenardhon = new LOTRBiomeGenCalenardhon(82, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.2f, 0.15f).setColor(7384389).setBiomeName("calenardhon");
		calenardhonWoodlands = new LOTRBiomeGenCalenardhonWoodlands(83, false).setTemperatureRainfall(0.9f, 0.9f).setMinMaxHeight(0.2f, 0.4f).setColor(6527293).setBiomeName("calenardhonWoodlands");
		calenardhonWest = new LOTRBiomeGenCalenardhon(84, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.2f, 0.15f).setColor(7184448).setBiomeName("calenardhonWest");
		gondorWest = new LOTRBiomeGenGondorWest(87, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.1f, 0.15f).setColor(7775552).setBiomeName("gondorWest");
		anfalas = new LOTRBiomeGenAnfalas(103, true).setTemperatureRainfall(1.0f, 1.0f).setMinMaxHeight(0.08f, 0.2f).setColor(10863708).setBiomeName("anfalas");
		rhunLandWest = new LOTRBiomeGenRhunWest(123, true).setTemperatureRainfall(1.0f, 0.8f).setMinMaxHeight(0.1f, 0.3f).setColor(10464336).setBiomeName("rhunLandWest");

		int i = 186;
		forostarMoors = new LOTRBiomeGenNumenorMarshes(i, true).setTemperatureRainfall(0.6f, 0.9f).setMinMaxHeight(0.0f, 0.1f).setColor(8361811).setBiomeName("forostarMoors");
		i++;
		numenorWoodlands = new LOTRBiomeGenNumenorWoodlands(i, false).setTemperatureRainfall(0.8f, 0.9f).setMinMaxHeight(0.2f, 0.2f).setColor(6130478).setBiomeName("numenorWoodlands");
		i++;
		forostar = new LOTRBiomeGenNumenor(i, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.1f, 0.15f).setColor(8367443).setBiomeName("forostar");
		i++;
		mittalmar = new LOTRBiomeGenNumenor(i, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.1f, 0.15f).setColor(9354823).setBiomeName("mittalmar");
		i++;
		emeriyo = new LOTRBiomeGenNumenor(i, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.1f, 0.15f).setColor(10339657).setBiomeName("emeriyo");
		i++;
		arandor = new LOTRBiomeGenNumenor(i, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.1f, 0.15f).setColor(0xa3c04e).setBiomeName("arandor");
		i++;
		hyarnustar = new LOTRBiomeGenNumenor(i, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.1f, 0.15f).setColor(10272588).setBiomeName("hyarnustar");
		i++;
		orrostar = new LOTRBiomeGenNumenor(i, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.1f, 0.15f).setColor(8695876).setBiomeName("orrostar");
		i++;
		hyarrostar = new LOTRBiomeGenNumenor(i, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.1f, 0.15f).setColor(8565059).setBiomeName("hyarrostar");
		i++;
		andustar = new LOTRBiomeGenNumenor(i, true).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.1f, 0.15f).setColor(8170308).setBiomeName("andustar");
		i++;
		anduniyoHills = new LOTRBiomeGenNumenor(i, false).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.5f, 0.5f).setColor(8495427).setBiomeName("anduniyoHills");
		i++;
		numenorHills = new LOTRBiomeGenNumenor(i, false).setTemperatureRainfall(0.8f, 0.8f).setMinMaxHeight(0.5f, 0.5f).setColor(7510079).setBiomeName("numenorHills");
		i++;
		hyarrostarWoodlands = new LOTRBiomeGenNumenorWoodlands(i, false).setTemperatureRainfall(0.8f, 0.9f).setMinMaxHeight(0.2f, 0.2f).setColor(5733947).setBiomeName("hyarrostarWoodlands");
		i++;
		mouthSiril = new LOTRBiomeGenNumenorMarshes(i, true).setTemperatureRainfall(0.9f, 1.0f).setMinMaxHeight(0.0f, 0.1f).setColor(7118431).setBiomeName("mouthSiril");
		i++;
		nisimaldar = new LOTRBiomeGenNisimaldar(i, true).setTemperatureRainfall(0.9f, 1.0f).setMinMaxHeight(0.1f, 0.3f).setColor(10462242).setBiomeName("nisimaldar");
		i++;
		meneltarm = new LOTRBiomeGenMeneltarm(i, true).setTemperatureRainfall(0.6f, 0.8f).setMinMaxHeight(1.5f, 2.0f).setColor(15197922).setBiomeName("meneltarm");
		i++;
		meneltarmFoothills = new LOTRBiomeGenMeneltarmFoothills(i, true).setTemperatureRainfall(0.6f, 0.7f).setMinMaxHeight(0.5f, 0.9f).setColor(13489861).setBiomeName("meneltarmFoothills");
		i++;
		khand = new LOTRBiomeGenNearHaradKhand(i, true).setTemperatureRainfall(1.5f, 0.2f).setMinMaxHeight(0.2f, 0.1f).setColor(0xBDBB6B).setBiomeName("nearHaradSemiDesert");
	}

	public static void updateWaterColor(int i, int j, int k) {
		int min = 0;
		int max = waterLimitSouth - waterLimitNorth;
		float latitude = (float) MathHelper.clamp_int(k - waterLimitNorth, min, max) / (float) max;
		float[] northColors = waterColorNorth.getColorComponents(null);
		float[] southColors = waterColorSouth.getColorComponents(null);
		float dR = southColors[0] - northColors[0];
		float dG = southColors[1] - northColors[1];
		float dB = southColors[2] - northColors[2];
		float r = dR * latitude;
		float g = dG * latitude;
		float b = dB * latitude;
		Color water = new Color(r += northColors[0], g += northColors[1], b += northColors[2]);
		int waterRGB = water.getRGB();
		for (LOTRDimension dimension : LOTRDimension.values()) {
			for (LOTRBiome biome : dimension.biomeList) {
				if (biome == null || biome.biomeColors.hasCustomWater()) {
					continue;
				}
				biome.biomeColors.updateWater(waterRGB);
			}
		}
	}

	public static class BiomeColors {
		private static int DEFAULT_WATER = 7186907;
		private LOTRBiome theBiome;
		private Color grass;
		private Color foliage;
		private Color sky;
		private Color clouds;
		private Color fog;
		private boolean foggy;
		private boolean hasCustomWater = false;

		public BiomeColors(LOTRBiome biome) {
			theBiome = biome;
		}

		public boolean hasCustomWater() {
			return hasCustomWater;
		}

		public void resetClouds() {
			clouds = null;
		}

		public void resetFog() {
			fog = null;
		}

		public void resetFoliage() {
			foliage = null;
		}

		public void resetGrass() {
			grass = null;
		}

		public void resetSky() {
			sky = null;
		}

		public void resetWater() {
			setWater(DEFAULT_WATER);
		}

		public void setClouds(int rgb) {
			clouds = new Color(rgb);
		}

		public void setFog(int rgb) {
			fog = new Color(rgb);
		}

		public void setFoggy(boolean flag) {
			foggy = flag;
		}

		public void setFoliage(int rgb) {
			foliage = new Color(rgb);
		}

		public void setGrass(int rgb) {
			grass = new Color(rgb);
		}

		public void setSky(int rgb) {
			sky = new Color(rgb);
		}

		public void setWater(int rgb) {
			theBiome.waterColorMultiplier = rgb;
			if (rgb != DEFAULT_WATER) {
				hasCustomWater = true;
			}
		}

		public void updateWater(int rgb) {
			theBiome.waterColorMultiplier = rgb;
		}
	}

	public static class BiomeTerrain {
		private double xzScale = -1.0;
		private double heightStretchFactor = -1.0;

		public BiomeTerrain(LOTRBiome biome) {
		}

		public double getHeightStretchFactor() {
			return heightStretchFactor;
		}

		public double getXZScale() {
			return xzScale;
		}

		public boolean hasHeightStretchFactor() {
			return heightStretchFactor != -1.0;
		}

		public boolean hasXZScale() {
			return xzScale != -1.0;
		}

		public void resetHeightStretchFactor() {
			setHeightStretchFactor(-1.0);
		}

		public void resetXZScale() {
			setXZScale(-1.0);
		}

		public void setHeightStretchFactor(double d) {
			heightStretchFactor = d;
		}

		public void setXZScale(double d) {
			xzScale = d;
		}
	}

	public static class GrassBlockAndMeta {
		public final Block block;
		public final int meta;

		public GrassBlockAndMeta(Block b, int i) {
			block = b;
			meta = i;
		}
	}

}
