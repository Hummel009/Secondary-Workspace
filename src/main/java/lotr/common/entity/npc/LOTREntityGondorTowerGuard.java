package lotr.common.entity.npc;

import lotr.common.LOTRMod;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LOTREntityGondorTowerGuard extends LOTREntityGondorSoldier {
	public LOTREntityGondorTowerGuard(World world) {
		super(world);
		spawnRidingHorse = false;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24.0);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24);
	}

	@Override
	public EntityAIBase createGondorAttackAI() {
		return new LOTREntityAIAttackOnCollide(this, 1.5, false);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
		data = super.onSpawnWithEgg(data);
		npcItemsInv.setMeleeWeapon(new ItemStack(LOTRMod.spearGondor));
		npcItemsInv.setIdleItem(npcItemsInv.getMeleeWeapon());
		npcItemsInv.setSpearBackup(null);
		return data;
	}
}
