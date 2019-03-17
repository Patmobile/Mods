package de.patmobile.paralleldimension.init;


import de.patmobile.paralleldimension.ModConfig;
import de.patmobile.paralleldimension.items.ItemFeuerzeug;
import de.patmobile.paralleldimension.items.ItemStandard;
import de.patmobile.paralleldimension.registry.ItemRegistry;
import net.minecraft.item.Item;

public class ItemInit 
{
	
	
	public static final Item Saphir = new ItemStandard("saphir");
	public static final Item Rubin = new ItemStandard("rubin");
	public static final Item HoellenFeuerzeug = new ItemFeuerzeug("hoellenfeuerzeug");
	
	
	public static void construct() {
		ItemRegistry.register(ModConfig.MODID, ItemInit.class);
    }
	
}