package bd.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.*;

public class BDModelMordor2Chestplate extends LOTRModelBiped {
	public BDModelMordor2Chestplate() {
		textureWidth = 64;
		textureHeight = 32;

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 40, 16, -1.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F));
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 0, 6, 0.0F, -7.0F, 0.0F, 7, 18, 0, 0.0F));
		bipedLeftArm.mirror = true;

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 16, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 1.01F));

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 40, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F));
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 0, 6, -7.0F, -7.0F, 0.0F, 7, 18, 0, 0.0F));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}