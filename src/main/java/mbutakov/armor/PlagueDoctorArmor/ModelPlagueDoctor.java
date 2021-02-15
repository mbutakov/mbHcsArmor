package mbutakov.armor.PlagueDoctorArmor;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;
import mbutakov.armor.IModelArmor;
import mbutakov.armor.ModelPartRender;
import mbutakov.armor.Armor2021.Armor2021;
import mbutakov.utils.ohim;

public class ModelPlagueDoctor implements IModelArmor {
	private int body;
	private int head;
	private int larm;
	private int rarm;
	private int lleg;
	private int rleg;
	private int lboot;
	private int rboot;
	ohim modelPlague;

	public ModelPlagueDoctor() {
		if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
			modelPlague = new ohim("PlagueDoctor.obj",
					Armor2021.class.getResourceAsStream("/assets/mbhcsarmor/armor/models/PlagueDoctor.obj"));
			   this.head = GL11.glGenLists(8);
			    GL11.glNewList(this.head, 4864);
			    GL11.glPushMatrix();
			    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			    this.modelPlague.renderPart("Head");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.body = this.head + 1;
			    GL11.glNewList(this.body, 4864);
			    GL11.glPushMatrix();
			    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			    this.modelPlague.renderPart("Body");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.larm = this.body + 1;
			    GL11.glNewList(this.larm, 4864);
			    GL11.glPushMatrix();
			    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			    this.modelPlague.renderPart("Left_right");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.rarm = this.larm + 1;
			    GL11.glNewList(this.rarm, 4864);
			    GL11.glPushMatrix();
			    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			    this.modelPlague.renderPart("Right_arm");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.lleg = this.rarm + 1;
			    GL11.glNewList(this.lleg, 4864);
			    GL11.glPushMatrix();
			    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			    this.modelPlague.renderPart("Left_pant");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.rleg = this.lleg + 1;
			    GL11.glNewList(this.rleg, 4864);
			    GL11.glPushMatrix();
			    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			    this.modelPlague.renderPart("Right_pant");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.lboot = this.rleg + 1;
			    GL11.glNewList(this.lboot, 4864);
			    GL11.glPushMatrix();
			    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			    this.modelPlague.renderPart("Left_leg");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.rboot = this.lboot + 1;
			    GL11.glNewList(this.rboot, 4864);
			    GL11.glPushMatrix();
			    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			    this.modelPlague.renderPart("Right_leg");
			    GL11.glPopMatrix();
			    GL11.glEndList();
		}
	}

	public void renderPart(ModelPartRender.MODELPART paramModelPart) {
		GL11.glTranslatef(0.0F, 1.55F, 0.0F);
		GL11.glScalef(-0.0015F, -0.0015F, -0.0015F);
		GL11.glPushAttrib(8200);
		GL11.glEnable(2884);
		GL11.glCullFace(1028);
		switch (paramModelPart.ordinal()) {
		case 0:
	        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glTranslatef(0.0F, 50.0F, 0.0F);
	        GL11.glCallList(this.body);
			break;
		case 1:
	        GL11.glTranslatef(0.0F, 0.2F, 0.0F);
	        GL11.glScalef(1.0F, 1.05F, 1.05F);
	        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glCallList(this.head);
			break;
		case 2:
	        GL11.glTranslatef(240.0F, 20.0F, 0.0F);
	        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glScalef(1.12F, 1.12F, 1.12F);
	        GL11.glCallList(this.larm);
			break;
		case 3:
	        GL11.glTranslatef(-240.0F, 20.0F, 0.0F);
	        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glScalef(1.12F, 1.12F, 1.12F);
	        GL11.glCallList(this.rarm);
			break;
		case 4:
	        GL11.glTranslatef(81.0F, 530.0F, 0.0F);
	        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glCallList(this.lleg);
			break;
		case 5:
	        GL11.glTranslatef(-81.0F, 530.0F, 0.0F);
	        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glCallList(this.rleg);
			break;
		case 6:
	        GL11.glTranslatef(80.0F, 531.0F, 0.0F);
	        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glCallList(this.lboot);
			break;
		case 7:
	        GL11.glTranslatef(-80.0F, 531.0F, 0.0F);
	        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glCallList(this.rboot);
		}
		GL11.glPopAttrib();
	}
}
