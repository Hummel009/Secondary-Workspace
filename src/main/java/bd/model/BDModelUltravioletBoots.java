package bd.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.*;

public class BDModelUltravioletBoots extends LOTRModelBiped {
	public ModelRenderer LeftBootOver;
	public ModelRenderer RightBootOver;

	public BDModelUltravioletBoots() {
		textureWidth = 64;
		textureHeight = 64;

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 0, 48, -2.0F, 0.0F, -2.0F, 4, 12, 4, 1.0F));
		bipedLeftLeg.mirror = true;

		LeftBootOver = new ModelRenderer(this);
		LeftBootOver.setRotationPoint(0.25F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(LeftBootOver);
		setRotationAngle(LeftBootOver, 0.0F, 0.0F, -0.0873F);
		LeftBootOver.cubeList.add(new ModelBox(LeftBootOver, 15, 27, -2.0F, -0.25F, -3.0F, 5, 11, 6, 0.1F));

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 48, -2.0F, 0.0F, -2.0F, 4, 12, 4, 1.0F));

		RightBootOver = new ModelRenderer(this);
		RightBootOver.setRotationPoint(0.75F, 0.75F, 0.0F);
		bipedRightLeg.addChild(RightBootOver);
		setRotationAngle(RightBootOver, 0.0F, 0.0F, 0.0873F);
		RightBootOver.cubeList.add(new ModelBox(RightBootOver, 41, 43, -4.0F, -1.0F, -3.0F, 5, 11, 6, 0.1F));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}