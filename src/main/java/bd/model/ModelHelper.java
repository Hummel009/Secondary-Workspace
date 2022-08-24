package bd.model;

import lotr.client.LOTRTickHandlerClient;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

public class ModelHelper {
	public static void setCapeAngles(ModelRenderer cape, Entity entity) {
		if (entity == null || !(entity instanceof EntityPlayer)) {
			float var = cape.rotateAngleX;
			if (entity != null && entity.isSprinting()) {
				if (cape.rotateAngleX < (float) Math.toRadians(61)) {
					cape.rotateAngleX = var += (float) Math.toRadians(0.5);
				}
				cape.rotateAngleX = var;

			} else {
				cape.rotateAngleX = cape.rotateAngleX > (float) Math.toRadians(8) ? (cape.rotateAngleX -= (float) Math.toRadians(0.5)) : cape.rotateAngleX < (float) Math.toRadians(8) ? (cape.rotateAngleX += (float) Math.toRadians(0.5)) : (float) Math.toRadians(8);
			}
		} else {
			EntityPlayer entityplayer = (EntityPlayer) entity;
			float tick = LOTRTickHandlerClient.renderTick;

			double d = entityplayer.field_71091_bM + (entityplayer.field_71094_bP - entityplayer.field_71091_bM) * tick - (entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * tick);
			double d1 = entityplayer.field_71096_bN + (entityplayer.field_71095_bQ - entityplayer.field_71096_bN) * tick - (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * tick);
			double d2 = entityplayer.field_71097_bO + (entityplayer.field_71085_bR - entityplayer.field_71097_bO) * tick - (entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * tick);
			float f6 = entityplayer.prevRenderYawOffset + (entityplayer.renderYawOffset - entityplayer.prevRenderYawOffset) * tick;
			double d3 = MathHelper.sin(f6 * 3.1415927f / 180.0f);
			double d4 = -MathHelper.cos(f6 * 3.1415927f / 180.0f);
			float f7 = (float) d1 * 10.0f;
			if (f7 < -6.0f) {
				f7 = -6.0f;
			}
			if (f7 > 32.0f) {
				f7 = 32.0f;
			}
			float f8 = (float) (d * d3 + d2 * d4) * 100.0f;
			float f9 = (float) (d * d4 - d2 * d3) * 100.0f;
			if (f8 < 0.0f) {
				f8 = 0.0f;
			}
			float f10 = entityplayer.prevCameraYaw + (entityplayer.cameraYaw - entityplayer.prevCameraYaw) * tick;
			f7 += MathHelper.sin((entityplayer.prevDistanceWalkedModified + (entityplayer.distanceWalkedModified - entityplayer.prevDistanceWalkedModified) * tick) * 6.0f) * 32.0f * f10;
			if (entityplayer.isSneaking()) {
				f7 += 25.0f;
			}

			cape.rotateAngleX = (float) Math.toRadians(6.0f + f8 / 2.0f + f7);
			cape.rotateAngleY = (float) Math.toRadians(-f9 / 5.0f);
			cape.rotateAngleZ = (float) Math.toRadians(f9 / 5.0f);
		}
	}
}