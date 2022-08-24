package bd.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.*;

public class BDModelUltravioletHelmet extends LOTRModelBiped {
	public ModelRenderer bone;
	public ModelRenderer bone2;
	public ModelRenderer bone3;
	public ModelRenderer bone10;
	public ModelRenderer bone11;
	public ModelRenderer bone12;
	public ModelRenderer bone4;
	public ModelRenderer bone5;
	public ModelRenderer bone6;
	public ModelRenderer bone7;
	public ModelRenderer bone8;
	public ModelRenderer bone9;

	public BDModelUltravioletHelmet() {
		textureWidth = 64;
		textureHeight = 64;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 32, -4.0F, -8.0F, -4.0F, 8, 8, 8, 1.0F));
		bipedHead.cubeList.add(new ModelBox(bipedHead, 32, 32, -4.0F, -8.0F, -4.0F, 8, 8, 8, 1.5F));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-3.5F, -8.9151F, 2.4441F);
		bipedHead.addChild(bone);
		setRotationAngle(bone, 0.9964F, -0.3286F, -0.219F);
		bone.cubeList.add(new ModelBox(bone, 2, 51, -1.5F, -1.5F, -3.0F, 3, 3, 6, 0.0F));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.25F, 4.0F);
		bone.addChild(bone2);
		setRotationAngle(bone2, -0.3927F, 0.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 2, 51, -1.0F, -1.0F, -2.0F, 2, 2, 5, 0.0F));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, 3.25F);
		bone2.addChild(bone3);
		setRotationAngle(bone3, 0.3927F, 0.0F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 2, 51, -1.0F, -1.0F, -1.0F, 2, 2, 3, -0.25F));

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-1.5F, -3.9151F, 1.4441F);
		bipedHead.addChild(bone10);
		setRotationAngle(bone10, 0.6037F, -0.3286F, -0.219F);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 0.25F, 4.0F);
		bone10.addChild(bone11);
		setRotationAngle(bone11, -0.3927F, 0.0F, 0.0F);
		bone11.cubeList.add(new ModelBox(bone11, 2, 51, -1.0F, -1.0F, -2.0F, 2, 2, 5, 0.0F));

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 0.0F, 3.25F);
		bone11.addChild(bone12);
		setRotationAngle(bone12, 0.3927F, 0.0F, 0.0F);
		bone12.cubeList.add(new ModelBox(bone12, 2, 51, -1.0F, -1.0F, -1.0F, 2, 2, 3, -0.25F));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(3.5F, -8.9151F, 2.4441F);
		bipedHead.addChild(bone4);
		setRotationAngle(bone4, 0.9964F, 0.3286F, 0.219F);
		bone4.cubeList.add(new ModelBox(bone4, 2, 51, -1.5F, -1.5F, -3.0F, 3, 3, 6, 0.0F));
		bone4.mirror = true;

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.25F, 4.0F);
		bone4.addChild(bone5);
		setRotationAngle(bone5, -0.3927F, 0.0F, 0.0F);
		bone5.cubeList.add(new ModelBox(bone5, 2, 51, -1.0F, -1.0F, -2.0F, 2, 2, 5, 0.0F));
		bone5.mirror = true;

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 3.25F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.3927F, 0.0F, 0.0F);
		bone6.cubeList.add(new ModelBox(bone6, 2, 51, -1.0F, -1.0F, -1.0F, 2, 2, 3, -0.25F));
		bone6.mirror = true;

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(1.5F, -3.9151F, 1.4441F);
		bipedHead.addChild(bone7);
		setRotationAngle(bone7, 0.6037F, 0.3286F, 0.219F);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 0.25F, 4.0F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, -0.3927F, 0.0F, 0.0F);
		bone8.cubeList.add(new ModelBox(bone8, 2, 51, -1.0F, -1.0F, -2.0F, 2, 2, 5, 0.0F));
		bone8.mirror = true;

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 0.0F, 3.25F);
		bone8.addChild(bone9);
		setRotationAngle(bone9, 0.3927F, 0.0F, 0.0F);
		bone9.cubeList.add(new ModelBox(bone9, 2, 51, -1.0F, -1.0F, -1.0F, 2, 2, 3, -0.25F));
		bone9.mirror = true;
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}