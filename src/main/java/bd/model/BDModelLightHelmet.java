package bd.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.*;

public class BDModelLightHelmet extends LOTRModelBiped {
	public ModelRenderer WingsHelmet;
	public ModelRenderer LeftWing2;
	public ModelRenderer RightWing2;

	public BDModelLightHelmet() {
		textureWidth = 64;
		textureHeight = 32;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 16, -4.0F, -8.0F, -4.0F, 8, 8, 8, 1.0F));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 32, 16, -4.0F, -8.0F, -4.0F, 8, 8, 8, 1.5F));

		WingsHelmet = new ModelRenderer(this);
		WingsHelmet.setRotationPoint(6.0F, -3.0F, 2.0F);
		bipedHead.addChild(WingsHelmet);

		LeftWing2 = new ModelRenderer(this);
		LeftWing2.setRotationPoint(-1.0F, -1.0F, -1.75F);
		WingsHelmet.addChild(LeftWing2);
		setRotationAngle(LeftWing2, 0.0F, -0.7854F, 0.0F);
		LeftWing2.cubeList.add(new ModelBox(LeftWing2, 0, 4, 0.0F, -11.0F, 0.0F, 8, 12, 0, 0.0F));

		RightWing2 = new ModelRenderer(this);
		RightWing2.setRotationPoint(-11.0F, -1.0F, -1.75F);
		WingsHelmet.addChild(RightWing2);
		setRotationAngle(RightWing2, 0.0F, -2.3562F, 0.0F);
		RightWing2.cubeList.add(new ModelBox(RightWing2, 0, 4, 0.0F, -11.0F, 0.0F, 8, 12, 0, 0.0F));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}