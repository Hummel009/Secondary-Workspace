package bd.render;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class BDRenderArrowSlowness extends RenderArrow {
	private static final ResourceLocation arrowPoisonTexture = new ResourceLocation("bd:item/arrowSlowness.png");

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return arrowPoisonTexture;
	}
}
