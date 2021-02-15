package mbutakov.armor.RedArmyArmor;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;
import mbutakov.armor.IModelArmor;
import mbutakov.armor.ModelPartRender;
import mbutakov.armor.Armor2021.Armor2021;
import mbutakov.utils.ohim;

public class ModelRedArmor implements IModelArmor {
	private int body;
	private int head;
	private int larm;
	private int rarm;
	private int lleg;
	private int rleg;
	private int lboot;
	private int rboot;
	ohim modelRedArmy;

	public ModelRedArmor() {
		if (FMLCommonHandler.instance().getEffectiveSide().isClient()) {
			modelRedArmy = new ohim("RedArmy.obj",
					Armor2021.class.getResourceAsStream("/assets/mbhcsarmor/armor/models/RedArmy.obj"));
			  this.head = GL11.glGenLists(8);
			    GL11.glNewList(this.head, 4864);
			    GL11.glPushMatrix();
			    this.modelRedArmy.renderPart("Head");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.body = this.head + 1;
			    GL11.glNewList(this.body, 4864);
			    GL11.glPushMatrix();
			    this.modelRedArmy.renderPart("Body");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.larm = this.body + 1;
			    GL11.glNewList(this.larm, 4864);
			    GL11.glPushMatrix();
			    this.modelRedArmy.renderPart("L_arm");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.rarm = this.larm + 1;
			    GL11.glNewList(this.rarm, 4864);
			    GL11.glPushMatrix();
			    this.modelRedArmy.renderPart("R_arm");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.lleg = this.rarm + 1;
			    GL11.glNewList(this.lleg, 4864);
			    GL11.glPushMatrix();
			    this.modelRedArmy.renderPart("L_leg");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.rleg = this.lleg + 1;
			    GL11.glNewList(this.rleg, 4864);
			    GL11.glPushMatrix();
			    this.modelRedArmy.renderPart("R_leg");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.lboot = this.rleg + 1;
			    GL11.glNewList(this.lboot, 4864);
			    GL11.glPushMatrix();
			    this.modelRedArmy.renderPart("L_boot");
			    GL11.glPopMatrix();
			    GL11.glEndList();
			    this.rboot = this.lboot + 1;
			    GL11.glNewList(this.rboot, 4864);
			    GL11.glPushMatrix();
			    this.modelRedArmy.renderPart("R_boot");
			    GL11.glPopMatrix();
			    GL11.glEndList();
		}
	}

	public void renderPart(ModelPartRender.MODELPART paramModelPart) {
		  GL11.glTranslatef(0.0F, 1.55F, 0.0F);
		    GL11.glScalef(-0.0101F, -0.0101F, -0.0101F);
		    GL11.glPushAttrib(8200);
		    GL11.glEnable(2884);
		    GL11.glCullFace(1028);
		    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		    switch (paramModelPart) {
		      case BODY:
		        GL11.glTranslatef(0.0F, 3.5F, 0.0F);
		        GL11.glCallList(this.body);
		        break;
		      case HEAD:
		        GL11.glTranslatef(0.0F, -6.0F, 0.0F);
		        GL11.glScalef(1.1F, 1.05F, 1.05F);
		        GL11.glCallList(this.head);
		        break;
		      case LARM:
		        GL11.glTranslatef(-31.0F, 16.5F, 0.0F);
		        GL11.glCallList(this.larm);
		        break;
		      case RARM:
		        GL11.glTranslatef(31.0F, 16.5F, 0.0F);
		        GL11.glCallList(this.rarm);
		        break;
		      case LLEG:
		        GL11.glTranslatef(-13.0F, 78.0F, 0.0F);
		        GL11.glCallList(this.lleg);
		        break;
		      case RLEG:
		        GL11.glTranslatef(13.0F, 78.0F, 0.0F);
		        GL11.glCallList(this.rleg);
		        break;
		      case RBOOT:
		        GL11.glTranslatef(12.0F, 79.0F, 0.0F);
		        GL11.glCallList(this.rboot);
		        break;
		      case LBOOT:
		        GL11.glTranslatef(-12.0F, 79.0F, 0.0F);
		        GL11.glCallList(this.lboot);
		        break;
			default:
				break;
		    } 
		    GL11.glPopAttrib();
	}
}
