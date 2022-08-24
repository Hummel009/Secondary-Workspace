package bd.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.*;

public class BDModelMordor2Helmet extends LOTRModelBiped {
	public ModelRenderer topKokoshnik;

	public BDModelMordor2Helmet() {
		textureWidth = 64;
		textureHeight = 32;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 16, -4.0F, -8.0F, -4.0F, 8, 8, 8, 1.0F));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 32, 16, -4.0F, -8.0F, -4.0F, 8, 8, 8, 1.5F));

		topKokoshnik = new ModelRenderer(this);
		topKokoshnik.setRotationPoint(0.0F, -8.0F, 0.0F);
		bipedHead.addChild(topKokoshnik);
		topKokoshnik.cubeList.add(new ModelBox(topKokoshnik, 0, 6, -7.0F, -10.0F, 0.0F, 14, 10, 0, 0.0F));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}