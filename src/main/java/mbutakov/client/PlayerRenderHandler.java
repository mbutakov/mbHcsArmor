package mbutakov.client;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.armor.Armor2021.Armor2021;
import mbutakov.armor.JokerArmor.JokerArmor;
import mbutakov.armor.KrampusArmor.KrampusArmor;
import mbutakov.armor.NaziArmor.NaziArmor;
import mbutakov.armor.PlagueDoctorArmor.PlagueDoctor;
import mbutakov.armor.RedArmyArmor.RedArmyArmor;
import mbutakov.armor.SantaArmor.SantaArmor;
import mbutakov.common.mItemRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderPlayerEvent;

public class PlayerRenderHandler {

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void renderArmor(RenderPlayerEvent.Specials.Post paramPost) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(3042);
		GL11.glDisable(3008);
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(32826);
		EntityPlayer localEntityPlayer = paramPost.entityPlayer;
		ItemStack localItemStack;
		Item localItem;
		if (localEntityPlayer.getCurrentArmor(3) != null) {
			localItemStack = localEntityPlayer.getCurrentArmor(3);
			localItem = localItemStack.getItem();
			if (localItem == mItemRegister.a21h) {
				Armor2021.Helmet.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.pdh) {
				PlagueDoctor.Helmet.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.kh) {
				KrampusArmor.Helmet.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.jh) {
				JokerArmor.Helmet.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.rh) {
				RedArmyArmor.Helmet.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.nh) {
				NaziArmor.Helmet.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.sh) {
				SantaArmor.Helmet.render(paramPost.renderer);
			}
		}
		if (localEntityPlayer.getCurrentArmor(2) != null) {
			localItemStack = localEntityPlayer.getCurrentArmor(2);
			localItem = localItemStack.getItem();
			if (localItem == mItemRegister.a21c) {
				Armor2021.Body.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.pdc) {
				PlagueDoctor.Body.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.kc) {
				KrampusArmor.Body.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.jc) {
				JokerArmor.Body.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.rc) {
				RedArmyArmor.Body.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.nc) {
				NaziArmor.Body.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.sc) {
				SantaArmor.Body.render(paramPost.renderer);
			}
		}
		if (localEntityPlayer.getCurrentArmor(1) != null) {
			localItemStack = localEntityPlayer.getCurrentArmor(1);
			localItem = localItemStack.getItem();
			if (localItem == mItemRegister.a21l) {
				Armor2021.Pants.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.pdp) {
				PlagueDoctor.Pants.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.kp) {
				KrampusArmor.Pants.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.jp) {
				JokerArmor.Pants.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.rp) {
				RedArmyArmor.Pants.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.np) {
				NaziArmor.Pants.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.sp) {
				SantaArmor.Pants.render(paramPost.renderer);
			}
		}
		if (localEntityPlayer.getCurrentArmor(0) != null) {
			localItemStack = localEntityPlayer.getCurrentArmor(0);
			localItem = localItemStack.getItem();
			if (localItem == mItemRegister.a21b) {
				Armor2021.Boots.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.pdb) {
				PlagueDoctor.Boots.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.kb) {
				KrampusArmor.Boots.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.jb) {
				JokerArmor.Boots.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.rb) {
				RedArmyArmor.Boots.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.nb) {
				NaziArmor.Boots.render(paramPost.renderer);
			}
			if (localItem == mItemRegister.sb) {
				SantaArmor.Boots.render(paramPost.renderer);
			}
		}
		GL11.glEnable(3008);
		GL11.glDisable(3042);
	}

}
