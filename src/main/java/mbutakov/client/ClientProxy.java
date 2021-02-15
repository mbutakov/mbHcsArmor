package mbutakov.client;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mbutakov.common.CommonProxy;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	public static PlayerRenderHandler playerRenderHandler;
	
	public void preInit() {
		super.preInit();
	}

	public void Init() {
		final PlayerRenderHandler events = new PlayerRenderHandler();
        MinecraftForge.EVENT_BUS.register((Object)events);
        FMLCommonHandler.instance().bus().register((Object)events);
	}

}
