package lotr.common.entity.npc;

import bd.database.BDRegistry;
import lotr.common.LOTRShields;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LOTREntityAngmarHillmanWarrior extends LOTREntityAngmarHillman {
	private static ItemStack[] weapons = { new ItemStack(BDRegistry.karndum2_sword), new ItemStack(BDRegistry.karndum2_battleaxe), new ItemStack(BDRegistry.karndum2_hammer), new ItemStack(BDRegistry.karndum2_dagger), new ItemStack(BDRegistry.karndum2_pike), new ItemStack(BDRegistry.karndum2_spear) };
	private static ItemStack[] helmets = { new ItemStack(BDRegistry.karndum2_helmet) };
	private static ItemStack[] bodies = { new ItemStack(BDRegistry.karndum2_chestplate) };
	private static ItemStack[] legs = { new ItemStack(BDRegistry.karndum2_leggings) };
	private static ItemStack[] boots = { new ItemStack(BDRegistry.karndum2_boots) };

	public LOTREntityAngmarHillmanWarrior(World world) {
		super(world);
		npcShield = LOTRShields.ALIGNMENT_ANGMAR;
	}

	@Override
	public void dropHillmanItems(boolean flag, int i) {
	}

	@Override
	public float getAlignmentBonus() {
		return 2.0f;
	}

	@Override
	public EntityAIBase getHillmanAttackAI() {
		return new LOTREntityAIAttackOnCollide(this, 1.6, false);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		int i = rand.nextInt(weapons.length);
		npcItemsInv.setMeleeWeapon(weapons[i].copy());
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		i = rand.nextInt(boots.length);
		setCurrentItemOrArmor(1, boots[i].copy());
		i = rand.nextInt(legs.length);
		setCurrentItemOrArmor(2, legs[i].copy());
		i = rand.nextInt(bodies.length);
		setCurrentItemOrArmor(3, bodies[i].copy());
		if (rand.nextInt(5) != 0) {
			i = rand.nextInt(helmets.length);
			setCurrentItemOrArmor(4, helmets[i].copy());
		}
		return data;
	}

	@Override
	public void setupNPCGender() {
		familyInfo.setMale(true);
	}
}
