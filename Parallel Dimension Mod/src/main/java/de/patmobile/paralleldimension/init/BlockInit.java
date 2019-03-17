package de.patmobile.paralleldimension.init;

import de.patmobile.paralleldimension.ModConfig;
import de.patmobile.paralleldimension.blocks.BlockFeuer;
import de.patmobile.paralleldimension.blocks.BlockOre;
import de.patmobile.paralleldimension.blocks.BlockParallelDimensionPortal;
import de.patmobile.paralleldimension.helper.HarvestLevelHelper;
import de.patmobile.paralleldimension.registry.BlockRegistry;
import net.minecraft.block.BlockPortal;

public class BlockInit {
	   
	public static final BlockOre Saphirerz = new BlockOre("saphirerz", HarvestLevelHelper.SAPHIR);
	public static final BlockOre Rubinerz = new BlockOre("rubinerz", HarvestLevelHelper.RUBIN);
	public static final BlockFeuer HoellenFeuer = new BlockFeuer("hoellenfeuer");
	public static final BlockParallelDimensionPortal ParallelDimensionPortal = new BlockParallelDimensionPortal("paralleldimensionportal");
	
	public static void construct() {
		BlockRegistry.register(ModConfig.MODID, BlockInit.class);
	}
	
}