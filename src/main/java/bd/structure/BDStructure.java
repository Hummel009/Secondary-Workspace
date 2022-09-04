package bd.structure;

import java.util.*;

import cpw.mods.fml.common.FMLLog;
import lotr.common.LOTRConfig;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.structure.*;
import lotr.common.world.structure.LOTRStructures.IVillageProperties;
import lotr.common.world.structure2.*;
import lotr.common.world.village.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BDStructure {

	private static HashMap<Integer, IStructureProvider> idToClassMapping = new HashMap();
	private static HashMap<Integer, String> idToStringMapping = new HashMap();
	public static HashMap<Integer, StructureColorInfo> structureItemSpawners = new LinkedHashMap<>();
	public static int id = 3000;

	public static String getNameFromID(int ID) {
		return idToStringMapping.get(ID);
	}

	public static IStructureProvider getStructureForID(int ID) {
		return idToClassMapping.get(ID);
	}

	public static void preInit() {
		registerStructure(id++, BDStructureEregionForge.class, "EregionForge", 15716696, 15716696);
		registerStructure(id++, BDStructureEregionHouse.class, "EregionHouse", 15716696, 15716696);
		registerStructure(id++, BDStructureEregionTower.class, "EregionTower", 15716696, 15716696);

		registerStructure(id++, BDStructureKhandAltar.class, "KhandAltar", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandBazaar.class, "KhandBazaar", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandFarm.class, "KhandFarm", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandHouse.class, "KhandHouse", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandPasture.class, "KhandPasture", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandPyramid.class, "KhandPyramid", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandSmithy.class, "KhandSmithy", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandTavern.class, "KhandTavern", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandTotem.class, "KhandTotem", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandTower.class, "KhandTower", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandTownWall.class, "KhandTownWall", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandVillageLight.class, "KhandVillageLight", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandVillageSign.class, "KhandVillageSign", 14266458, 14266458);
		registerStructure(id++, BDStructureKhandWarCamp.class, "KhandWarCamp", 14266458, 14266458);

		registerVillage(1262, new BDStructureKhandVillage(LOTRBiome.gulfHarad, 1.0f), "KhandVillage", 14266458, 14266458, new IVillageProperties<BDStructureKhandVillage.Instance>() {

			@Override
			public void apply(BDStructureKhandVillage.Instance instance) {
				instance.villageType = BDStructureKhandVillage.VillageType.VILLAGE;
			}
		});
		registerVillage(1264, new BDStructureKhandVillage(LOTRBiome.gulfHarad, 1.0f), "KhandTown", 14266458, 14266458, new IVillageProperties<BDStructureKhandVillage.Instance>() {

			@Override
			public void apply(BDStructureKhandVillage.Instance instance) {
				instance.villageType = BDStructureKhandVillage.VillageType.TOWN;
			}
		});
		registerVillage(1265, new BDStructureKhandVillage(LOTRBiome.gulfHarad, 1.0f), "KhandFortVillage", 14266458, 14266458, new IVillageProperties<BDStructureKhandVillage.Instance>() {

			@Override
			public void apply(BDStructureKhandVillage.Instance instance) {
				instance.villageType = BDStructureKhandVillage.VillageType.FORT;
			}
		});
	}

	private static void registerStructure(int id, Class<? extends WorldGenerator> strClass, String name, int colorBG, int colorFG) {
		registerStructure(id, strClass, name, colorBG, colorFG, false);
	}

	private static void registerStructure(int id, final Class<? extends WorldGenerator> strClass, String name, int colorBG, int colorFG, boolean hide) {
		IStructureProvider strProvider = new IStructureProvider() {

			@Override
			public boolean generateStructure(World world, EntityPlayer entityplayer, int i, int j, int k) {
				WorldGenerator generator = null;
				try {
					generator = strClass.getConstructor(Boolean.TYPE).newInstance(true);
				} catch (Exception e) {
					FMLLog.warning("Failed to build LOTR structure " + strClass.getName());
					e.printStackTrace();
				}
				if (generator != null) {
					boolean timelapse = LOTRConfig.strTimelapse;
					if (generator instanceof LOTRWorldGenStructureBase2) {
						LOTRWorldGenStructureBase2 strGen = (LOTRWorldGenStructureBase2) generator;
						strGen.restrictions = false;
						strGen.usingPlayer = entityplayer;
						if (timelapse) {
							LOTRStructureTimelapse.start(strGen, world, i, j, k);
							return true;
						}
						return strGen.generateWithSetRotation(world, world.rand, i, j, k, strGen.usingPlayerRotation());
					}
					if (generator instanceof LOTRWorldGenStructureBase) {
						LOTRWorldGenStructureBase strGen = (LOTRWorldGenStructureBase) generator;
						strGen.restrictions = false;
						strGen.usingPlayer = entityplayer;
						if (timelapse) {
							LOTRStructureTimelapse.start(strGen, world, i, j, k);
							return true;
						}
						return strGen.generate(world, world.rand, i, j, k);
					}
				}
				return false;
			}

			@Override
			public boolean isVillage() {
				return false;
			}
		};
		registerStructure(id, strProvider, name, colorBG, colorFG, hide);
	}

	private static void registerStructure(int id, IStructureProvider str, String name, int colorBG, int colorFG, boolean hide) {
		if (idToClassMapping.containsKey(id)) {
			throw new IllegalArgumentException("Structure ID " + id + " is already registered to " + name + "!");
		}
		idToClassMapping.put(id, str);
		idToStringMapping.put(id, name);
		structureItemSpawners.put(id, new StructureColorInfo(id, colorBG, colorFG, str.isVillage(), hide));
	}

	private static void registerVillage(int id, final LOTRVillageGen village, String name, int colorBG, int colorFG, final IVillageProperties properties) {
		IStructureProvider strProvider = new IStructureProvider() {

			@Override
			public boolean generateStructure(World world, EntityPlayer entityplayer, int i, int j, int k) {
				LOTRVillageGen.AbstractInstance<?> instance = village.createAndSetupVillageInstance(world, i, k, world.rand, LocationInfo.SPAWNED_BY_PLAYER);
				instance.setRotation((LOTRStructures.getRotationFromPlayer(entityplayer) + 2) % 4);
				properties.apply(instance);
				village.generateCompleteVillageInstance(instance, world, i, k);
				return true;
			}

			@Override
			public boolean isVillage() {
				return true;
			}
		};
		registerStructure(id, strProvider, name, colorBG, colorFG, false);
	}

	public interface IStructureProvider {
		boolean generateStructure(World var1, EntityPlayer var2, int var3, int var4, int var5);

		boolean isVillage();
	}

	public static class StructureColorInfo {
		public final int spawnedID;
		public final int colorBackground;
		public final int colorForeground;
		public final boolean isVillage;
		public final boolean isHidden;

		public StructureColorInfo(int i, int colorBG, int colorFG, boolean vill, boolean hide) {
			spawnedID = i;
			colorBackground = colorBG;
			colorForeground = colorFG;
			isVillage = vill;
			isHidden = hide;
		}
	}

}