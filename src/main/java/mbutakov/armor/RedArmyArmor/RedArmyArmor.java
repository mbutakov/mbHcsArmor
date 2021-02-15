package mbutakov.armor.RedArmyArmor;

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

public class RedArmyArmor{

	
	
	public static ModelRedArmor RedArmy = new ModelRedArmor();
	
	
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
			this.setUnlocalizedName("rp");
			this.setTextureName("mbhcsarmor:RedArmy_Pants");
			this.setNoRepair();
		}
		
		@SideOnly(Side.CLIENT)
		public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
			return "mbhcsarmor:textures/items/null.png";
		}

		public static void render(RenderPlayer renderModel){
		      GL11.glPushMatrix();
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.REDARMY);
		      renderModel.modelBipedMain.bipedLeftLeg.postRender(0.0625F);
		      RedArmyArmor.RedArmy.renderPart(ModelPartRender.MODELPART.LLEG);
		      GL11.glPopMatrix();
		      GL11.glPushMatrix();
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.REDARMY);
		      renderModel.modelBipedMain.bipedRightLeg.postRender(0.0625F);
		      RedArmyArmor.RedArmy.renderPart(ModelPartRender.MODELPART.RLEG);
		      GL11.glPopMatrix();
		}
	}

	public static class Helmet extends ItemArmor{
		public Helmet(ArmorMaterial armorMaterial, int par3, int par4){
			super(armorMaterial, par3, par4);
			this.setCreativeTab(Core.mbHcsArmor);
			this.setUnlocalizedName("rh");
			this.setTextureName("mbhcsarmor:RedArmy_Head");
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
			Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.REDARMY);
			renderModel.modelBipedMain.bipedHead.postRender(0.0625f);
			RedArmyArmor.RedArmy.renderPart(ModelPartRender.MODELPART.HEAD);
			GL11.glPopMatrix();
		}
	}

	public static class Boots extends ItemArmor{

		public Boots(ArmorMaterial armorMaterial, int par3, int par4){
			super(armorMaterial, par3, par4);
			this.setCreativeTab(Core.mbHcsArmor);
			this.setUnlocalizedName("rb");
			this.setTextureName("mbhcsarmor:RedArmy_Boots");
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
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.REDARMY);
		      renderModel.modelBipedMain.bipedLeftLeg.postRender(0.0625F);
		      RedArmyArmor.RedArmy.renderPart(ModelPartRender.MODELPART.LBOOT);
		      GL11.glPopMatrix();
		      GL11.glPushMatrix();
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.REDARMY);
		      renderModel.modelBipedMain.bipedRightLeg.postRender(0.0625F);
		      RedArmyArmor.RedArmy.renderPart(ModelPartRender.MODELPART.RBOOT);
		      GL11.glPopMatrix();
			}
	}

	public static class Body extends ItemArmor {

		public Body(ArmorMaterial armorMaterial, int par3, int par4){
			super(armorMaterial, par3, par4);
			this.setCreativeTab(Core.mbHcsArmor);
			this.setUnlocalizedName("rc");
			this.setTextureName("mbhcsarmor:RedArmy_Body");
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
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.REDARMY);
		      renderModel.modelBipedMain.bipedBody.postRender(0.0625F);
		      RedArmyArmor.RedArmy.renderPart(ModelPartRender.MODELPART.BODY);
		      GL11.glPopMatrix();
		      GL11.glPushMatrix();
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.REDARMY);
		      renderModel.modelBipedMain.bipedRightArm.postRender(0.0625F);
		      RedArmyArmor.RedArmy.renderPart(ModelPartRender.MODELPART.RARM);
		      GL11.glPopMatrix();
		      GL11.glPushMatrix();
		      Minecraft.getMinecraft().renderEngine.bindTexture(mbResourceLocation.REDARMY);
		      renderModel.modelBipedMain.bipedLeftArm.postRender(0.0625F);
		      RedArmyArmor.RedArmy.renderPart(ModelPartRender.MODELPART.LARM);
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
