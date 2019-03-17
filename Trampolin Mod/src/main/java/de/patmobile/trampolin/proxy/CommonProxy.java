package de.patmobile.trampolin.proxy;

import de.patmobile.trampolin.init.BlockInit;

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