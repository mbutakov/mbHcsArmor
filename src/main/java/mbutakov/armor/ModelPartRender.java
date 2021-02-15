package mbutakov.armor;

import api.player.render.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.*;
public class ModelPartRender extends RenderPlayerBase
{
    public ModelPartRender(final RenderPlayerAPI renderPlayerAPI) {
        super(renderPlayerAPI);
    }
    
    public void a(final AbstractClientPlayer abstractClientPlayer, final float n) {
        super.renderSpecials(abstractClientPlayer, n);
    }
    
    public enum MODELPART
    {
        BODY, 
        HEAD, 
        LARM, 
        RARM, 
        LLEG, 
        RLEG, 
        LBOOT, 
        RBOOT, 
        JAGVOROT;
    }
}
