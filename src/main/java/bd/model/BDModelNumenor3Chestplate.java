package bd.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.*;
import net.minecraft.entity.Entity;

public class BDModelNumenor3Chestplate extends LOTRModelBiped {
	public ModelRenderer cape;

	public BDModelNumenor3Chestplate() {
		textureWidth = 64;
		textureHeight = 64;

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 24, 16, -1.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F));
		bipedLeftArm.mirror = true;

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 24, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F));

		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 0, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 1.01F));

		cape = new ModelRenderer(this);
		cape.setRotationPoint(1.0F, 1.0F, 3.1F);
		bipedBody.addChild(cape);
		setRotationAngle(cape, 0.0436F, 0.0F, 0.0F);
		cape.cubeList.add(new ModelBox(cape, 32, 42, -7.0F, -2.0F, 0.0F, 12, 22, 0, 0.0F));
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