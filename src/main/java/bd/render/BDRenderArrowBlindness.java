/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderArrow
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 */
package bd.render;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class BDRenderArrowBlindness extends RenderArrow {
	private static final ResourceLocation arrowPoisonTexture = new ResourceLocation("bd:item/arrowBlindness.png");

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return arrowPoisonTexture;
	}
}
