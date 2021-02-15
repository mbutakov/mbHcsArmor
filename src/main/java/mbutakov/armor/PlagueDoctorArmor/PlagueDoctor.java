package mbutakov.armor.PlagueDoctorArmor;

import java.util.List;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.Core;
import mbutakov.mbResourceLocation;
import mbutakov.armor.ModelPartRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class PlagueDoctor{

	
	
	public static ModelPlagueDoctor plagueDoctor = new ModelPlagueDoctor();
	
	
	public static class Pants extends ItemArmor {

		public void onUpdate(ItemStack stack, World world, Entity player, int p_77663_4_, boolean p_77663_5_) {
		}

		public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		}

		public void addInformation(ItemStack stack, EntityPlayer playerIn, List lines, boolean advanced) {
		}

		public Pants(ArmorMaterial armorMaterial, int par3, int par4) {
			super(armorMaterial, par3, par4);
			this.setCreativeTab(Core.mbHcsArmor);
			this.setUnlocalizedName("pdp");
			this.setTextureName("mbhcsarmor:pdp");
			this.setNoRepair();
		}
		
		@SideOnly(Side.CLIENT)
		public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
			return "mbhcsarmor:textures/items/null.png";
		}

		public static void render(RenderPlayer renderModel){
		      GL11.glPushMatrix();
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.PLAGUE_DOCTOR);
		      renderModel.modelBipedMain.bipedLeftLeg.postRender(0.0625F);
		      PlagueDoctor.plagueDoctor.renderPart(ModelPartRender.MODELPART.RLEG);
		      GL11.glPopMatrix();
		      GL11.glPushMatrix();
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.PLAGUE_DOCTOR);
		      renderModel.modelBipedMain.bipedRightLeg.postRender(0.0625F);
		      PlagueDoctor.plagueDoctor.renderPart(ModelPartRender.MODELPART.RLEG);
		      GL11.glPopMatrix();
		}
	}

	public static class Helmet extends ItemArmor{
		public Helmet(ArmorMaterial armorMaterial, int par3, int par4){
			super(armorMaterial, par3, par4);
			this.setCreativeTab(Core.mbHcsArmor);
			this.setUnlocalizedName("pdh");
			this.setTextureName("mbhcsarmor:pdh");
			this.setNoRepair();
		}

		@SideOnly(Side.CLIENT)
		public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type){
			return "mbhcsarmor:textures/items/null.png";
		}
		

		public boolean getIsRepairable(ItemStack toRepair, ItemStack repair){
			return repair != null && repair.getItem().equals(Items.iron_ingot);
		}

		public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
			player.addPotionEffect(new PotionEffect(16, 53, 0, true));
		}
		
	    public void onUpdate(ItemStack stack, World world, Entity player, int p_77663_4_, boolean p_77663_5_) {
	    }

		public void addInformation(ItemStack stack, EntityPlayer playerIn, List lines, boolean advanced) {
		}
		
		public static void render(RenderPlayer renderModel){
			GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.PLAGUE_DOCTOR);
			renderModel.modelBipedMain.bipedHead.postRender(0.0625f);
			plagueDoctor.renderPart(ModelPartRender.MODELPART.HEAD);
			GL11.glPopMatrix();
		}
	}

	public static class Boots extends ItemArmor{

		public Boots(ArmorMaterial armorMaterial, int par3, int par4){
			super(armorMaterial, par3, par4);
			this.setCreativeTab(Core.mbHcsArmor);
			this.setUnlocalizedName("pdboots");
			this.setTextureName("mbhcsarmor:pdb");
			this.setNoRepair();
		}

		public String owner = "owner";
		
	    public void onUpdate(ItemStack stack, World world, Entity player, int p_77663_4_, boolean p_77663_5_) {
	    }

		public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		}

		public void addInformation(ItemStack stack, EntityPlayer playerIn, List lines, boolean advanced) {
		}

		@SideOnly(Side.CLIENT)
		public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type){
			return "mbhcsarmor:textures/items/null.png";
		}

		public boolean getIsRepairable(ItemStack toRepair, ItemStack repair){
			return repair != null && repair.getItem().equals(Items.iron_ingot);
		}

		
		public static void render(RenderPlayer renderModel){
		      GL11.glPushMatrix();
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.PLAGUE_DOCTOR);
		      renderModel.modelBipedMain.bipedLeftLeg.postRender(0.0625F);
		      PlagueDoctor.plagueDoctor.renderPart(ModelPartRender.MODELPART.LBOOT);
		      GL11.glPopMatrix();
		      GL11.glPushMatrix();
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.PLAGUE_DOCTOR);
		      renderModel.modelBipedMain.bipedRightLeg.postRender(0.0625F);
		      PlagueDoctor.plagueDoctor.renderPart(ModelPartRender.MODELPART.RBOOT);
		      GL11.glPopMatrix();
			}
	}

	public static class Body extends ItemArmor {

		public Body(ArmorMaterial armorMaterial, int par3, int par4){
			super(armorMaterial, par3, par4);
			this.setCreativeTab(Core.mbHcsArmor);
			this.setUnlocalizedName("pdbody");
			this.setTextureName("mbhcsarmor:pdc");
			this.setNoRepair();
		}


		public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		}
		
	    public void onUpdate(ItemStack stack, World world, Entity player, int p_77663_4_, boolean p_77663_5_) {
	    }
		
		public void addInformation(ItemStack stack, EntityPlayer playerIn, List lines, boolean advanced) {
			
		}
		@SideOnly(Side.CLIENT)
		public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type){
			return "mbhcsarmor:textures/items/null.png";
		}

		public boolean getIsRepairable(ItemStack toRepair, ItemStack repair){
			return repair != null && repair.getItem().equals(Items.iron_ingot);
		}

		
		public static void render(RenderPlayer renderModel){
		      GL11.glPushMatrix();
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.PLAGUE_DOCTOR);
		      renderModel.modelBipedMain.bipedBody.postRender(0.0625F);
		      PlagueDoctor.plagueDoctor.renderPart(ModelPartRender.MODELPART.BODY);
		      GL11.glPopMatrix();
		      GL11.glPushMatrix();
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.PLAGUE_DOCTOR);
		      renderModel.modelBipedMain.bipedRightArm.postRender(0.0625F);
		      PlagueDoctor.plagueDoctor.renderPart(ModelPartRender.MODELPART.RARM);
		      GL11.glPopMatrix();
		      GL11.glPushMatrix();
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.PLAGUE_DOCTOR);
		      renderModel.modelBipedMain.bipedLeftArm.postRender(0.0625F);
		      PlagueDoctor.plagueDoctor.renderPart(ModelPartRender.MODELPART.LARM);
		      GL11.glPopMatrix();
			}
	}

	

    
	public static NBTTagCompound getTagCompound(ItemStack itemStack){
		if(itemStack == null){
			return null;
		}
		NBTTagCompound nbt = itemStack.getTagCompound();
		if(!itemStack.hasTagCompound()){
			itemStack.setTagCompound(nbt = new NBTTagCompound());
		}
		return nbt;
	}
}
