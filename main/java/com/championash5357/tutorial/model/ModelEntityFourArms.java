package com.championash5357.tutorial.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelEntityFourArms extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Head;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
    ModelRenderer Arm3;
    ModelRenderer Arm4;
  
  public ModelEntityFourArms()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(0F, 0F, 0F, 8, 12, 6);
      Body.setRotationPoint(-4F, 0F, -2F);
      Body.setTextureSize(64, 64);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 0, 18);
      Leg1.addBox(0F, 0F, 0F, 4, 12, 6);
      Leg1.setRotationPoint(-4F, 12F, -2F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 18);
      Leg2.addBox(0F, 0F, 0F, 4, 12, 6);
      Leg2.setRotationPoint(0F, 12F, -2F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 28, 0);
      Head.addBox(0F, 0F, 0F, 8, 8, 8);
      Head.setRotationPoint(-4F, -8F, -3F);
      Head.setTextureSize(64, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Arm1 = new ModelRenderer(this, 20, 18);
      Arm1.addBox(0F, 0F, 0F, 4, 8, 3);
      Arm1.setRotationPoint(-8F, 0F, 1F);
      Arm1.setTextureSize(64, 64);
      Arm1.mirror = true;
      setRotation(Arm1, 0F, 0F, 0F);
      Arm2 = new ModelRenderer(this, 20, 29);
      Arm2.addBox(0F, 0F, 0F, 4, 8, 3);
      Arm2.setRotationPoint(-8F, 4F, -2F);
      Arm2.setTextureSize(64, 64);
      Arm2.mirror = true;
      setRotation(Arm2, 0F, 0F, 0F);
      Arm3 = new ModelRenderer(this, 20, 18);
      Arm3.addBox(0F, 0F, 0F, 4, 8, 3);
      Arm3.setRotationPoint(4F, 0F, 1F);
      Arm3.setTextureSize(64, 64);
      Arm3.mirror = true;
      setRotation(Arm3, 0F, 0F, 0F);
      Arm4 = new ModelRenderer(this, 20, 29);
      Arm4.addBox(0F, 0F, 0F, 4, 8, 3);
      Arm4.setRotationPoint(4F, 4F, -2F);
      Arm4.setTextureSize(64, 64);
      Arm4.mirror = true;
      setRotation(Arm4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Head.render(f5);
    Arm1.render(f5);
    Arm2.render(f5);
    Arm3.render(f5);
    Arm4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    this.Head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Head.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Arm1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.Arm3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.Arm1.rotateAngleZ = 0.0F;
    this.Arm3.rotateAngleZ = 0.0F;
    this.Arm2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.Arm4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.Arm2.rotateAngleZ = 0.0F;
    this.Arm4.rotateAngleZ = 0.0F;
    this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Leg1.rotateAngleY = 0.0F;
    this.Leg2.rotateAngleY = 0.0F;
  }

}