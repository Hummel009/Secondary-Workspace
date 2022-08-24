package bd.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.*;

public class BDModelUltravioletChestplate extends LOTRModelBiped {
	private final ModelRenderer LeftPauldron;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer RightPauldron;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;

	public BDModelUltravioletChestplate() {
		textureWidth = 64;
		textureHeight = 64;

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.mirror = true;
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 40, 48, -1.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F));

		LeftPauldron = new ModelRenderer(this);
		LeftPauldron.setRotationPoint(0.0F, 1.0F, -0.5F);
		bipedLeftArm.addChild(LeftPauldron);
		LeftPauldron.cubeList.add(new ModelBox(LeftPauldron, 40, 36, 0.0F, -5.0F, -3.0F, 5, 5, 7, 0.0F));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(5.0063F, -3.0042F, 0.75F);
		LeftPauldron.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 48, 38, -1.0F, -4.25F, -1.0F, 2, 3, 2, -0.3F));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 48, 38, -1.0F, -1.5F, -1.0F, 2, 3, 2, 0.0F));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(3.0F, -6.0F, 0.75F);
		LeftPauldron.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.3927F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 48, 38, 0.0F, -4.25F, -1.0F, 2, 3, 2, -0.3F));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 48, 38, 0.0F, -1.5F, -1.0F, 2, 3, 2, 0.0F));

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 16, 48, -4.0F, 0.0F, -2.0F, 8, 12, 4, 1.01F));

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 40, 48, -3.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F));

		RightPauldron = new ModelRenderer(this);
		RightPauldron.setRotationPoint(0.0F, 1.0F, 0.5F);
		bipedRightArm.addChild(RightPauldron);
		setRotationAngle(RightPauldron, 0.0F, 3.1416F, 0.0F);
		RightPauldron.cubeList.add(new ModelBox(RightPauldron, 40, 36, 0.0F, -5.0F, -3.0F, 5, 5, 7, 0.0F));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(4.9763F, -8.158F, 0.25F);
		RightPauldron.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.3927F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 48, 38, -1.0F, -1.5F, -1.0F, 2, 3, 2, -0.3F));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(3.0F, -6.0F, 0.25F);
		RightPauldron.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.3927F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 48, 38, 0.0F, -1.5F, -1.0F, 2, 3, 2, 0.0F));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(6.9508F, -4.9487F, 0.25F);
		RightPauldron.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 0.7854F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 48, 38, -1.0F, -1.5F, -1.0F, 2, 3, 2, -0.3F));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(5.0063F, -3.0042F, 0.25F);
		RightPauldron.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, 0.7854F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 48, 38, -1.0F, -1.5F, -1.0F, 2, 3, 2, 0.0F));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
