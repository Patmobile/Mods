package de.patmobile.moreitems.proxy;

import de.patmobile.moreitems.Init.InitArmorSets;
import de.patmobile.moreitems.Init.InitToolSets;
import de.patmobile.moreitems.Init.ItemInit;


public class CommonProxy implements IModProxy {
	
       
    @Override
	public void construct() {
    	ItemInit.construct();
		InitToolSets.construct();
		InitArmorSets.construct();
	}

    @Override
	public void setup() {

	}
	
	@Override
	public void complete() {
}


	
}