package bd.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.*;

public class BDModelLightChestplate extends LOTRModelBiped {
	public ModelRenderer wings;
	public ModelRenderer leftwing;
	public ModelRenderer rightwing;

	public BDModelLightChestplate() {
		textureWidth = 64;
		textureHeight = 32;

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 48, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F));

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 48, 16, -1.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F));
		bipedLeftArm.mirror = true;

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 24, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 1.01F));

		wings = new ModelRenderer(this);
		wings.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addChild(wings);

		leftwing = new ModelRenderer(this);
		leftwing.setRotationPoint(2.0F, 11.5F, 3.0F);
		wings.addChild(leftwing);
		setRotationAngle(leftwing, 0.0F, 0.3927F, 0.0F);
		leftwing.cubeList.add(new ModelBox(leftwing, 0, -7, 0.0F, -17.5F, 0.0F, 0, 29, 10, 0.0F));

		rightwing = new ModelRenderer(this);
		rightwing.setRotationPoint(-2.0F, 11.5F, 3.0F);
		wings.addChild(rightwing);
		setRotationAngle(rightwing, 0.0F, -0.3927F, 0.0F);
		rightwing.cubeList.add(new ModelBox(rightwing, 0, -7, 0.0F, -17.5F, 0.0F, 0, 29, 10, 0.0F));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}