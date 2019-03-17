package de.patmobile.moreitems.Init;


import de.patmobile.moreitems.ModConfig;
import de.patmobile.moreitems.items.ItemStandard;
import de.patmobile.moreitems.registry.ItemRegistry;
import net.minecraft.item.Item;

public class ItemInit 
{
	
	
	public static final Item VerstaerkterDiamant = new ItemStandard("verstaerkterdiamant");
	public static final Item Eisenfeder = new ItemStandard("eisenfeder");
	public static final Item Trampolingitter = new ItemStandard("trampolingitter");
	
	public static void construct() {
		ItemRegistry.register(ModConfig.MODID, ItemInit.class);
    }
	
	

}