package bd.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.*;

public class BDModelMordor3Helmet extends LOTRModelBiped {
	public ModelRenderer crown;

	public BDModelMordor3Helmet() {
		textureWidth = 64;
		textureHeight = 32;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 1.0F));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 32, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 1.5F));

		crown = new ModelRenderer(this);
		crown.setRotationPoint(0.0F, -9.0F, -4.0F);
		bipedHead.addChild(crown);
		crown.cubeList.add(new ModelBox(crown, 0, 20, -1.0F, -4.0F, -1.75F, 2, 5, 2, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 23, -0.5F, -8.0F, -1.25F, 1, 4, 1, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 23, -2.5F, -7.5F, 8.25F, 1, 3, 1, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 20, -3.0F, -4.5F, 7.75F, 2, 5, 2, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 20, 1.0F, -4.5F, 7.75F, 2, 5, 2, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 23, 1.5F, -7.5F, 8.25F, 1, 3, 1, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 20, 3.0F, -4.0F, 0.0F, 2, 7, 2, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 23, 3.5F, -7.0F, 0.5F, 1, 3, 1, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 20, -5.0F, -4.0F, 0.0F, 2, 7, 2, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 23, -4.5F, -7.0F, 0.5F, 1, 3, 1, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 20, -6.0F, -6.0F, 4.0F, 2, 7, 2, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 20, 4.0F, -6.0F, 4.0F, 2, 7, 2, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 23, 4.5F, -9.0F, 4.5F, 1, 3, 1, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 23, -5.5F, -9.0F, 4.5F, 1, 3, 1, 0.0F));
		crown.cubeList.add(new ModelBox(crown, 0, 20, -2.0F, -2.0F, -1.0F, 4, 2, 10, 0.0F));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}