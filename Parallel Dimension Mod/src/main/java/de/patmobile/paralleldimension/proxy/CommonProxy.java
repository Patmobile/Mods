package de.patmobile.paralleldimension.proxy;

import de.patmobile.paralleldimension.init.BlockInit;
import de.patmobile.paralleldimension.init.ItemInit;


public class CommonProxy implements IModProxy {
	
    
    @Override
	public void construct() {
        
    	ItemInit.construct();
    	BlockInit.construct();
 
	}

    @Override
	public void setup() {

    	

	}
	
	@Override
	public void complete() {
}
	
}
