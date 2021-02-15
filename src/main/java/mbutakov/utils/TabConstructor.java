package mbutakov.utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mbutakov.common.mItemRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TabConstructor extends CreativeTabs {

	public Item tabIcon;
	
	public TabConstructor(String lable,Item item) {
		super(lable);
		this.tabIcon = item;
	}

	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		if(tabIcon != null) {
			return this.tabIcon;
		}else {
			return mItemRegister.kh;
		}
	}

}
