package mbutakov;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mbutakov.common.CommonProxy;
import mbutakov.common.mItemRegister;
import mbutakov.utils.TabConstructor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;

@Mod(modid = "mbHcsArmor", name = "mbHcsArmor", version = "0.1")
public class Core {

	@SidedProxy(clientSide = "mbutakov.client.ClientProxy", serverSide = "mbutakov.common.CommonProxy")
	public static CommonProxy proxy;
	public static CreativeTabs mbHcsArmor = new TabConstructor("mbHcsArmor", mItemRegister.pdh);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		mItemRegister.registerItems();
		proxy.preInit();
	}

	@EventHandler
	public void Init(FMLInitializationEvent e) {
		proxy.Init();
	}

	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		if(FMLClientHandler.instance().getSide().isClient()) {
			mItemRegister.langItemReg();
		}
		    
	}
	

}
