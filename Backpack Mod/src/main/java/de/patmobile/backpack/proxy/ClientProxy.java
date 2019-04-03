package de.patmobile.backpack.proxy;


import de.patmobile.backpack.handler.GuiHandler;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientProxy extends CommonProxy {
	
	@Override
	public void construct() {
		super.construct();
		GuiHandler.construct();
}


	@Override
	public void setup() {
		super.setup();
	
	}
	
	@Override
	public void complete() {
		super.complete();
}
    
}