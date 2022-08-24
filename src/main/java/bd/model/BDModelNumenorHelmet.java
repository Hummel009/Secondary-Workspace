package bd.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.*;

public class BDModelNumenorHelmet extends LOTRModelBiped {
	private final ModelRenderer WingsHelmet;
	private final ModelRenderer LeftWing2;
	private final ModelRenderer RightWing2;
	private final ModelRenderer RightWing2C_r1;
	private final ModelRenderer top;

	public BDModelNumenorHelmet() {
		textureWidth = 64;
		textureHeight = 64;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 1.0F));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 32, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 1.5F));

		WingsHelmet = new ModelRenderer(this);
		WingsHelmet.setRotationPoint(6.0F, -3.0F, 2.0F);
		bipedHead.addChild(WingsHelmet);

		LeftWing2 = new ModelRenderer(this);
		LeftWing2.setRotationPoint(-1.0F, -1.0F, -1.75F);
		WingsHelmet.addChild(LeftWing2);
		setRotationAngle(LeftWing2, 0.0F, -0.3927F, 0.0F);
		LeftWing2.cubeList.add(new ModelBox(LeftWing2, 0, 39, -7.3827F, -15.0F, -0.9239F, 15, 16, 0, 0.0F));

		RightWing2 = new ModelRenderer(this);
		RightWing2.setRotationPoint(-11.0F, -1.0F, -1.75F);
		WingsHelmet.addChild(RightWing2);
		setRotationAngle(RightWing2, 0.0F, -1.9635F, 0.0F);

		RightWing2C_r1 = new ModelRenderer(this);
		RightWing2C_r1.setRotationPoint(1.0F, 1.0F, 1.0F);
		RightWing2.addChild(RightWing2C_r1);
		setRotationAngle(RightWing2C_r1, 0.0F, -0.7854F, 0.0F);
		RightWing2C_r1.cubeList.add(new ModelBox(RightWing2C_r1, 0, 39, -8.3827F, -16.0F, -0.0761F, 15, 16, 0, 0.0F));

		top = new ModelRenderer(this);
		top.setRotationPoint(-6.0F, 27.0F, -2.0F);
		WingsHelmet.addChild(top);
		top.cubeList.add(new ModelBox(top, 31, 41, -3.0F, -33.75F, -5.0F, 6, 2, 10, -0.1F));
		top.cubeList.add(new ModelBox(top, 40, 53, -1.0F, -34.5F, -5.0F, 2, 1, 10, -0.2F));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}