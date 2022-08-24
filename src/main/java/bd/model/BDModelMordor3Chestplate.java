package bd.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.*;
import net.minecraft.entity.Entity;

public class BDModelMordor3Chestplate extends LOTRModelBiped {
	public ModelRenderer cape;
	public ModelRenderer RightPauldron;
	public ModelRenderer LeftPauldron;

	public BDModelMordor3Chestplate() {
		textureWidth = 64;
		textureHeight = 64;

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 24, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 1.01F));

		cape = new ModelRenderer(this);
		cape.setRotationPoint(0.0F, -1.25F, 3.2F);
		bipedBody.addChild(cape);
		setRotationAngle(cape, 0.0436F, 0.0F, 0.0F);
		cape.cubeList.add(new ModelBox(cape, 40, 40, -6.0F, 0.25F, 0.0F, 12, 24, 0, 0.0F));

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 48, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F));

		RightPauldron = new ModelRenderer(this);
		RightPauldron.setRotationPoint(0.0F, 1.0F, 0.5F);
		bipedRightArm.addChild(RightPauldron);
		setRotationAngle(RightPauldron, 0.0F, 3.1416F, 0.0F);
		RightPauldron.cubeList.add(new ModelBox(RightPauldron, 0, 52, 0.0F, -5.0F, -3.0F, 5, 5, 7, 0.0F));
		RightPauldron.cubeList.add(new ModelBox(RightPauldron, 0, 52, 0.0F, 4.0F, -3.0F, 5, 5, 7, 0.0F));
		RightPauldron.cubeList.add(new ModelBox(RightPauldron, 33, 1, 0.0F, -8.0F, 0.5F, 8, 19, 0, 0.0F));

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 48, 16, -1.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F));
		bipedLeftArm.mirror = true;

		LeftPauldron = new ModelRenderer(this);
		LeftPauldron.setRotationPoint(0.0F, 1.0F, -0.5F);
		bipedLeftArm.addChild(LeftPauldron);
		LeftPauldron.cubeList.add(new ModelBox(LeftPauldron, 0, 52, 0.0F, -5.0F, -3.0F, 5, 5, 7, 0.0F));
		LeftPauldron.cubeList.add(new ModelBox(LeftPauldron, 33, 1, 0.0F, -8.0F, 0.5F, 8, 19, 0, 0.0F));
		LeftPauldron.cubeList.add(new ModelBox(LeftPauldron, 0, 52, 0.0F, 4.0F, -3.0F, 5, 5, 7, 0.0F));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		ModelHelper.setCapeAngles(cape, entity);
	}
}