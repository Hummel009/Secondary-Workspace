package bd.render;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class BDRenderArrowHunger extends RenderArrow {
	private static final ResourceLocation arrowPoisonTexture = new ResourceLocation("bd:item/arrowHunger.png");

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return arrowPoisonTexture;
	}
}
