package de.patmobile.moreblocks.init;

import de.patmobile.moreblocks.ModConfig;
import de.patmobile.moreblocks.blocks.BlockBasic;
import de.patmobile.moreblocks.blocks.BlockTreppe;
import de.patmobile.moreblocks.registry.BlockRegistry;



public class BlockInit {
	   
	public static final BlockBasic Eisziegel = new BlockBasic("eisziegel");
	public static final BlockBasic Schneeziegel = new BlockBasic("schneeziegel");
	public static final BlockBasic VerstaerkterDiamantblock = new BlockBasic("verstaerkterdiamantblock");
	
	public static final BlockTreppe EisziegelTreppe = new BlockTreppe("eisziegeltreppe", BlockInit.Eisziegel.getDefaultState());
	public static final BlockTreppe SchneeziegelTreppe = new BlockTreppe("schneeziegeltreppe", BlockInit.Schneeziegel.getDefaultState());
	public static final BlockTreppe VerstaerkteDiamantTreppe = new BlockTreppe("verstaerktediamanttreppe", BlockInit.VerstaerkterDiamantblock.getDefaultState());
	
	public static void construct() {
		BlockRegistry.register(ModConfig.MODID, BlockInit.class);
	}
	
}