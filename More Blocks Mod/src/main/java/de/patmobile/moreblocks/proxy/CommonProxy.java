package de.patmobile.moreblocks.proxy;

import de.patmobile.moreblocks.init.BlockInit;

public class CommonProxy implements IModProxy {
	
       
    @Override
	public void construct() {
        
    	BlockInit.construct();
	}

    @Override
	public void setup() {

	}
	
	@Override
	public void complete() {
}


	
}