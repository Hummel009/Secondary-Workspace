package bd.entity;

import bd.database.BDRegistry;
import lotr.common.LOTRMod;
import lotr.common.item.LOTRItemHaradRobes;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BDEntityKhandLevyman extends BDEntityKhandMan {
	private static ItemStack[] levyWeapons = { new ItemStack(BDRegistry.khand1_dagger), new ItemStack(BDRegistry.khand1_dagger_poisoned), new ItemStack(LOTRMod.daggerIron), new ItemStack(LOTRMod.daggerBronze), new ItemStack(BDRegistry.khand1_sword), new ItemStack(BDRegistry.khand1_hammer), new ItemStack(Items.iron_sword), new ItemStack(LOTRMod.swordBronze), new ItemStack(LOTRMod.battleaxeIron), new ItemStack(LOTRMod.battleaxeBronze), new ItemStack(BDRegistry.khand1_spear), new ItemStack(LOTRMod.spearIron), new ItemStack(LOTRMod.spearBronze) };
	private static ItemStack[] levySpears = { new ItemStack(BDRegistry.khand1_spear), new ItemStack(LOTRMod.spearIron), new ItemStack(LOTRMod.spearBronze) };
	private static ItemStack[] levyBodies = { new ItemStack(Items.leather_chestplate), new ItemStack(LOTRMod.bodyBronze) };
	private static ItemStack[] levyLegs = { new ItemStack(Items.leather_leggings), new ItemStack(LOTRMod.legsBronze) };
	private static ItemStack[] levyBoots = { new ItemStack(Items.leather_boots), new ItemStack(LOTRMod.bootsBronze) };
	private static final int[] kaftanColors = { 14823729, 11862016, 5512477, 14196753, 11374145, 7366222 };

	public BDEntityKhandLevyman(World world) {
		super(world);
		this.addTargetTasks(true);
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public String getSpeechBank(EntityPlayer entityplayer) {
		if (isFriendlyAndAligned(entityplayer)) {
			if (hiredNPCInfo.getHiringPlayer() == entityplayer) {
				return "rhun/warrior/hired";
			}
			return "rhun/warrior/friendly";
		}
		return "rhun/warrior/hostile";
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		int i = rand.nextInt(levyWeapons.length);
		npcItemsInv.setMeleeWeapon(levyWeapons[i].copy());
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		if (rand.nextInt(5) == 0) {
			npcItemsInv.setSpearBackup(npcItemsInv.getMeleeWeapon());
			i = rand.nextInt(levySpears.length);
			npcItemsInv.setMeleeWeapon(levySpears[i].copy());
		}
		i = rand.nextInt(levyBoots.length);
		setCurrentItemOrArmor(1, levyBoots[i].copy());
		i = rand.nextInt(levyLegs.length);
		setCurrentItemOrArmor(2, levyLegs[i].copy());
		i = rand.nextInt(levyBodies.length);
		setCurrentItemOrArmor(3, levyBodies[i].copy());
		setCurrentItemOrArmor(4, null);
		if (rand.nextBoolean()) {
			ItemStack kaftan = new ItemStack(LOTRMod.bodyKaftan);
			int kaftanColor = kaftanColors[rand.nextInt(kaftanColors.length)];
			LOTRItemHaradRobes.setRobesColor(kaftan, kaftanColor);
			setCurrentItemOrArmor(3, kaftan);
			if (rand.nextBoolean()) {
				ItemStack kaftanLegs = new ItemStack(LOTRMod.legsKaftan);
				LOTRItemHaradRobes.setRobesColor(kaftanLegs, kaftanColor);
				setCurrentItemOrArmor(2, kaftanLegs);
			}
		}
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
