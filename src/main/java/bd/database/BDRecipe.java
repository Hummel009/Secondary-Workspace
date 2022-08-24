package bd.database;

import java.util.*;

import lotr.common.LOTRMod;
import lotr.common.item.LOTRItemBanner;
import lotr.common.recipe.LOTRRecipes;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.*;

public class BDRecipe {
	public static List<IRecipe> eregion = new ArrayList<>();
	public static List<IRecipe> khand = new ArrayList<>();

	public static void createEregion() {
		eregion.add(new ShapedOreRecipe(new ItemStack(BDRegistry.table_eregion), "XX", "XX", Character.valueOf('X'), "plankWood"));
	}

	public static void createKhand() {
		khand.add(new ShapedOreRecipe(new ItemStack(BDRegistry.table_khand), "XX", "XX", Character.valueOf('X'), "plankWood"));
	}

	public static void createUnsmelt() {
		LOTRRecipes.uncraftableUnsmeltingRecipes.addAll(khand);
		LOTRRecipes.uncraftableUnsmeltingRecipes.addAll(eregion);
	}

	public static void preInit() {
		createUnsmelt();
		recreateMorgulRecipes();
		recreateGondorianRecipes();
		recreateDwarvenRecipes();
		recreateDunlendingRecipes();
		recreateNearHaradRecipes();
		recreateHighElvenRecipes();
		recreateRhunRecipes();
		createKhand();
		createEregion();
	}

	private static void recreateDunlendingRecipes() {
		LOTRRecipes.dunlendingRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dunlendingTable), "XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), Blocks.cobblestone));
		LOTRRecipes.dunlendingRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.helmetDunlending), "XXX", "Y Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.dunlendingRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDunlending), "X X", "YYY", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.dunlendingRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.legsDunlending), "XXX", "Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.dunlendingRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bootsDunlending), "Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.dunlendingRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dunlendingClub), "X", "X", "X", Character.valueOf('X'), "plankWood"));
		LOTRRecipes.dunlendingRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.DUNLAND.bannerID), "X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"));
	}

	private static void recreateDwarvenRecipes() {
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarvenTable), "XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6)));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.shovelDwarven), "X", "Y", "Y", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeDwarven), "XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.axeDwarven), "XX", "XY", " Y", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.swordDwarven), "X", "X", "Y", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.hoeDwarven), "XX", " Y", " Y", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.daggerDwarven), "X", "Y", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeDwarven), "XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.hammerDwarven), "XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.helmetDwarven), "XXX", "X X", Character.valueOf('X'), LOTRMod.dwarfSteel));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bodyDwarven), "X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.dwarfSteel));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.legsDwarven), "XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.dwarfSteel));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bootsDwarven), "X X", "X X", Character.valueOf('X'), LOTRMod.dwarfSteel));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.throwingAxeDwarven), " X ", " YX", "Y  ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.chandelier, 2, 8), " X ", "YZY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Blocks.torch, Character.valueOf('Z'), LOTRMod.dwarfSteel));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.mattockDwarven), "XXX", "XY ", " Y ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.DWARF.bannerID), "X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.spearDwarven), "  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.dwarfBars, 16), "XXX", "XXX", Character.valueOf('X'), LOTRMod.dwarfSteel));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.boarArmorDwarven), "X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), Items.leather));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pikeDwarven), "  X", " YX", "Y  ", Character.valueOf('X'), LOTRMod.dwarfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gateDwarven, 4), "ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), new ItemStack(LOTRMod.brick, 1, 6), Character.valueOf('Z'), LOTRMod.dwarfSteel));
		LOTRRecipes.dwarvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.mechanism), " X ", "YZY", " X ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), Items.flint, Character.valueOf('Z'), LOTRMod.dwarfSteel));
	}

	private static void recreateGondorianRecipes() {
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gondorianTable), "XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.rock, 1, 1)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.beacon), "XXX", "XXX", "YYY", Character.valueOf('X'), "logWood", Character.valueOf('Y'), Blocks.cobblestone));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle11, 6, 3), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.smoothStone, 2, 1), "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 2), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.smoothStone, 1, 1)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 1), "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 3), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 1)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorBrick, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 1)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 2), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 3), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 1)));
		LOTRRecipes.gondorianRecipes.add(new ShapelessOreRecipe(new ItemStack(LOTRMod.brick, 1, 2), new ItemStack(LOTRMod.brick, 1, 1), "vine"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 4), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 2)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorBrickMossy, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 2)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 4), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 2)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 5), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 3)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorBrickCracked, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 3)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 5), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 3)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 1, 5), "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 1)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.helmetGondor), "XXX", "X X", Character.valueOf('X'), "ingotIron"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bodyGondor), "X X", "XXX", "XXX", Character.valueOf('X'), "ingotIron"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.legsGondor), "XXX", "X X", "X X", Character.valueOf('X'), "ingotIron"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bootsGondor), "X X", "X X", Character.valueOf('X'), "ingotIron"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.swordGondor), "X", "X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.spearGondor), "  X", " Y ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.daggerGondor), "X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.hammerGondor), "XYX", "XYX", " Y ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gondorBow), " XY", "X Y", " XY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Items.string));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.GONDOR.bannerID), "X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorGondor), "X  ", "XYX", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 6), "X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle5, 6, 0), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 6)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorRock, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gateGondor, 4), "ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), "ingotIron"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick5, 4, 8), "XY", "YX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 1), Character.valueOf('Y'), Blocks.cobblestone));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle11, 6, 0), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 8)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorBrickRustic, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 8)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 7), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 8)));
		LOTRRecipes.gondorianRecipes.add(new ShapelessOreRecipe(new ItemStack(LOTRMod.brick5, 1, 9), new ItemStack(LOTRMod.brick5, 1, 8), "vine"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle11, 6, 1), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 9)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorBrickRusticMossy, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 9)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 8), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 9)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle11, 6, 2), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 10)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsGondorBrickRusticCracked, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 10)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 9), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 10)));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.GONDOR_STEWARD.bannerID), "XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), "dyeWhite"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pikeGondor), "  X", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.chestLebethron), "XXX", "XYX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.planks, 1, 8), Character.valueOf('Y'), "nuggetSilver"));
		LOTRRecipes.gondorianRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick4, 1, 6), "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick2, 1, 11)));
	}

	private static void recreateHighElvenRecipes() {
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.highElvenTable), "XX", "XX", Character.valueOf('X'), "plankWood"));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.shovelHighElven), "X", "Y", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeHighElven), "XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.axeHighElven), "XX", "XY", " Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.hoeHighElven), "XX", " Y", " Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.swordHighElven), "X", "X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.daggerHighElven), "X", "Y", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.spearHighElven), "  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.helmetHighElven), "XXX", "X X", Character.valueOf('X'), LOTRMod.elfSteel));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bodyHighElven), "X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.legsHighElven), "XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bootsHighElven), "X X", "X X", Character.valueOf('X'), LOTRMod.elfSteel));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.HIGH_ELF.bannerID), "X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorHighElven), "X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), Items.leather));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.polearmHighElven), "  X", " Y ", "X  ", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.highElvenRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.highElvenBow), " XY", "X Y", " XY", Character.valueOf('X'), LOTRMod.elfSteel, Character.valueOf('Y'), Items.string));
	}

	private static void recreateMorgulRecipes() {
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick, 4, 0), "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.morgulTable), "XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.rock, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle10, 6, 7), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.smoothStone, 2, 0), "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 0), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.smoothStone, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle, 6, 1), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsMordorBrick, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 0), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 1), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.orcTorchItem, 2), "X", "Y", "Y", Character.valueOf('X'), LOTRMod.nauriteGem, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle2, 6, 2), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 7)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsMordorBrickCracked, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 7)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall, 6, 9), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 7)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.orcForge), "XXX", "X X", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.MORDOR.bannerID), "X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wargArmorMordor), "X  ", "XYX", "XXX", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), Items.leather));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.scimitarOrc), "X", "X", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeOrc), "XXX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.daggerOrc), "X", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.helmetOrc), "XXX", "X X", Character.valueOf('X'), LOTRMod.orcSteel));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bodyOrc), "X X", "XXX", "XXX", Character.valueOf('X'), LOTRMod.orcSteel));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.legsOrc), "XXX", "X X", "X X", Character.valueOf('X'), LOTRMod.orcSteel));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bootsOrc), "X X", "X X", Character.valueOf('X'), LOTRMod.orcSteel));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.spearOrc), "  X", " Y ", "Y  ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.shovelOrc), "X", "Y", "Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pickaxeOrc), "XXX", " Y ", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.axeOrc), "XX", "XY", " Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.hoeOrc), "XX", " Y", " Y", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.hammerOrc), "XYX", "XYX", " Y ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pillar, 3, 7), "X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle5, 6, 1), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar, 1, 7)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick2, 1, 10), "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.polearmOrc), " XX", " YX", "Y  ", Character.valueOf('X'), LOTRMod.orcSteel, Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsMordorRock, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.MINAS_MORGUL.bannerID), "XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), new ItemStack(Items.skull, 1, 0)));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.BLACK_URUK.bannerID), "XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), LOTRMod.blackUrukSteel));
		LOTRRecipes.morgulRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.NAN_UNGOL.bannerID), "XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), Items.string));
	}

	private static void recreateNearHaradRecipes() {
		LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.nearHaradTable), "XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(Blocks.sandstone, 1, 0)));
		LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.NEAR_HARAD.bannerID), "X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"));
		LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.HARAD_NOMAD.bannerID), "XA", "Y ", "Z ", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood", Character.valueOf('A'), Blocks.sand));
		LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.helmetNearHarad), "XXX", "X X", Character.valueOf('X'), "ingotBronze"));
		LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bodyNearHarad), "X X", "XXX", "XXX", Character.valueOf('X'), "ingotBronze"));
		LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.legsNearHarad), "XXX", "X X", "X X", Character.valueOf('X'), "ingotBronze"));
		LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bootsNearHarad), "X X", "X X", Character.valueOf('X'), "ingotBronze"));
		LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.horseArmorNearHarad), "X  ", "XYX", "XXX", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.helmetHarnedor), "XXX", "Y Y", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bodyHarnedor), "X X", "YYY", "XXX", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.legsHarnedor), "XXX", "Y Y", "X X", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.nearHaradRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bootsHarnedor), "Y Y", "X X", Character.valueOf('X'), "ingotBronze", Character.valueOf('Y'), Items.leather));
	}

	private static void recreateRhunRecipes() {
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.rhunTable), "XX", "YY", Character.valueOf('X'), "plankWood", Character.valueOf('Y'), new ItemStack(LOTRMod.brick5, 1, 11)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.banner, 1, LOTRItemBanner.BannerType.RHUN.bannerID), "X", "Y", "Z", Character.valueOf('X'), Blocks.wool, Character.valueOf('Y'), "stickWood", Character.valueOf('Z'), "plankWood"));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick5, 4, 11), "XX", "XX", Character.valueOf('X'), "rhunStone"));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 0), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 11)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsRhunBrick, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 11)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall3, 6, 15), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 11)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick5, 1, 12), "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 11)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pillar2, 3, 8), "X", "X", "X", Character.valueOf('X'), "rhunStone"));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 4), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 8)));
		LOTRRecipes.rhunRecipes.add(new ShapelessOreRecipe(new ItemStack(LOTRMod.brick5, 1, 13), new ItemStack(LOTRMod.brick5, 1, 11), "vine"));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 1), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 13)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsRhunBrickMossy, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 13)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 10), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 13)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 2), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 14)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsRhunBrickCracked, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 14)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 11), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 14)));
		LOTRRecipes.rhunRecipes.add(new ShapelessOreRecipe(new ItemStack(LOTRMod.brick5, 1, 15), new ItemStack(LOTRMod.brick5, 1, 11), new ItemStack(LOTRMod.rhunFlower, 1, 1)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 3), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 15)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsRhunBrickFlowers, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 15)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 12), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick5, 1, 15)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick6, 1, 0), " X ", "XYX", " X ", Character.valueOf('X'), "nuggetGold", Character.valueOf('Y'), new ItemStack(LOTRMod.brick5, 1, 11)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick6, 4, 1), "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 4)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 5), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 1)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.stairsRhunBrickRed, 4), "X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 1)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.wall4, 6, 13), "XXX", "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 1)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.brick6, 1, 2), "XX", "XX", Character.valueOf('X'), new ItemStack(LOTRMod.brick6, 1, 1)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pillar2, 3, 9), "X", "X", "X", Character.valueOf('X'), new ItemStack(LOTRMod.rock, 1, 4)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.slabSingle12, 6, 6), "XXX", Character.valueOf('X'), new ItemStack(LOTRMod.pillar2, 1, 9)));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.swordRhun), "X", "X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.daggerRhun), "X", "Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.spearRhun), "  X", " Y ", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.polearmRhun), " XX", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.pikeRhun), "  X", " YX", "Y  ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.helmetRhun), "XXX", "Y Y", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bodyRhun), "X X", "YYY", "XXX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.legsRhun), "XXX", "Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.bootsRhun), "Y Y", "X X", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Items.leather));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.rhunBow), " XY", "X Y", " XY", Character.valueOf('X'), "stickWood", Character.valueOf('Y'), Items.string));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.rhunFireJar), "XYX", "YZY", "XYX", Character.valueOf('X'), LOTRMod.gildedIron, Character.valueOf('Y'), Items.gunpowder, Character.valueOf('Z'), LOTRMod.nauriteGem));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.rhunFirePot, 4), "Z", "Y", "X", Character.valueOf('X'), LOTRMod.gildedIron, Character.valueOf('Y'), Items.gunpowder, Character.valueOf('Z'), LOTRMod.nauriteGem));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.gateRhun, 4), "ZYZ", "YXY", "ZYZ", Character.valueOf('X'), LOTRMod.gateGear, Character.valueOf('Y'), "plankWood", Character.valueOf('Z'), LOTRMod.gildedIron));
		LOTRRecipes.rhunRecipes.add(new ShapedOreRecipe(new ItemStack(LOTRMod.battleaxeRhun), "XXX", "XYX", " Y ", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), "stickWood"));
	}
}