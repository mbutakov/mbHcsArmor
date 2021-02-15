package mbutakov.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ResourceLocation;
public abstract interface IRenderModel
{
  public abstract IModelArmor getRenderer();
  
  public abstract ResourceLocation getTexture();
  
}
