package bd.util;

import bd.entity.*;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.*;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import lotr.common.*;
import lotr.common.fac.LOTRFaction;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.*;
import net.minecraft.world.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class BDEventHandler {
	public BDEventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}

	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event) {
		EntityLivingBase entity = event.entityLiving;
		if (event.source.getEntity() instanceof EntityLivingBase) {
		}
		World world = entity.worldObj;
		if (event.source.getSourceOfDamage() instanceof BDEntityArrowFire && !world.isRemote) {
			applyStandardFire(entity);
		}
		if (event.source.getSourceOfDamage() instanceof BDEntityArrowBlindness && !world.isRemote) {
			applyStandardBlindness(entity);
		}
		if (event.source.getSourceOfDamage() instanceof BDEntityArrowSlowness && !world.isRemote) {
			applyStandardSlowness(entity);
		}
		if (event.source.getSourceOfDamage() instanceof BDEntityArrowHunger && !world.isRemote) {
			applyStandardHunger(entity);
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onPlayerLoginFactionCheck(PlayerEvent.PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
		if (!player.worldObj.isRemote) {
			LOTRPlayerData pd = LOTRLevelData.getData(player);
			if (pd.getViewingFaction() == LOTRFaction.HOBBIT) {
				pd.setViewingFaction(LOTRFaction.GONDOR);
			}
		}
	}

	public static void applyStandardBlindness(EntityLivingBase entity) {
		EnumDifficulty difficulty = entity.worldObj.difficultySetting;
		int duration = 1 + difficulty.getDifficultyId() * 2;
		PotionEffect poison = new PotionEffect(Potion.blindness.id, duration * 20);
		entity.addPotionEffect(poison);
	}

	public static void applyStandardFire(EntityLivingBase entity) {
		EnumDifficulty difficulty = entity.worldObj.difficultySetting;
		int duration = 1 + difficulty.getDifficultyId() * 2;
		entity.setFire(duration);
	}

	public static void applyStandardHunger(EntityLivingBase entity) {
		EnumDifficulty difficulty = entity.worldObj.difficultySetting;
		int duration = 1 + difficulty.getDifficultyId() * 2;
		PotionEffect poison = new PotionEffect(Potion.hunger.id, duration * 20);
		entity.addPotionEffect(poison);
	}

	public static void applyStandardSlowness(EntityLivingBase entity) {
		EnumDifficulty difficulty = entity.worldObj.difficultySetting;
		int duration = 1 + difficulty.getDifficultyId() * 2;
		PotionEffect poison = new PotionEffect(Potion.moveSlowdown.id, duration * 20);
		entity.addPotionEffect(poison);
	}

}
