/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.IEntityLivingData
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAITasks
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package lotr.common.entity.npc;

import bd.database.BDRegistry;
import lotr.common.*;
import lotr.common.entity.ai.LOTREntityAIAttackOnCollide;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LOTREntityBreeGuard
extends LOTREntityBreeMan {
    private static final ItemStack[] guardWeapons = new ItemStack[]{new ItemStack(Items.iron_sword), new ItemStack(Items.iron_sword), new ItemStack(LOTRMod.pikeIron)};

    public LOTREntityBreeGuard(World world) {
        super(world);
        this.addTargetTasks(true);
        this.npcShield = LOTRShields.ALIGNMENT_BREE;
    }

    @Override
    protected int addBreeAttackAI(int prio) {
        this.tasks.addTask(prio, (EntityAIBase)new LOTREntityAIAttackOnCollide(this, 1.45, false));
        return prio;
    }

    @Override
    protected void addBreeAvoidAI(int prio) {
    }

    @Override
    public void setupNPCGender() {
        this.familyInfo.setMale(true);
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        int i = this.rand.nextInt(guardWeapons.length);
        this.npcItemsInv.setMeleeWeapon(guardWeapons[i].copy());
        this.npcItemsInv.setIdleItem(this.npcItemsInv.getMeleeWeapon());
        this.setCurrentItemOrArmor(1, new ItemStack(BDRegistry.eriador1_boots));
        this.setCurrentItemOrArmor(2, new ItemStack(BDRegistry.eriador1_leggings));
        this.setCurrentItemOrArmor(3, new ItemStack(BDRegistry.eriador1_chestplate));
        this.setCurrentItemOrArmor(4, new ItemStack(BDRegistry.eriador1_helmet));
        return data;
    }

    @Override
    public float getAlignmentBonus() {
        return 2.0f;
    }

    @Override
    public String getSpeechBank(EntityPlayer entityplayer) {
        if (this.isFriendlyAndAligned(entityplayer)) {
            if (this.hiredNPCInfo.getHiringPlayer() == entityplayer) {
                return "bree/guard/hired";
            }
            return "bree/guard/friendly";
        }
        return "bree/guard/hostile";
    }
}

