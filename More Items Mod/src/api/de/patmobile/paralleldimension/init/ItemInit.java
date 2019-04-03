package de.patmobile.paralleldimension.init;

import java.util.ArrayList;

import de.patmobile.paralleldimension.ParallelDimensionMod;
import de.patmobile.paralleldimension.items.ItemFeuerzeug;
import de.patmobile.paralleldimension.items.ItemStandard;
import net.minecraft.item.Item;

@net.minecraftforge.registries.ObjectHolder("paralleldimension:items")
public class ItemInit 
{
	
	public static ArrayList<Item> itemsToRegister = new ArrayList<>();
	
	//Items
	public static Item Saphir;
	public static Item Rubin;
	public static Item HoellenFeuerzeug;
	
	
	public static void initItems() {
	Saphir = new ItemStandard("saphir", ParallelDimensionMod.ParallelDimensionTab).addToRegistryList();
	Rubin = new ItemStandard("rubin", ParallelDimensionMod.ParallelDimensionTab).addToRegistryList();
	HoellenFeuerzeug = new ItemFeuerzeug("hoellenfeuerzeug", ParallelDimensionMod.ParallelDimensionTab, 128).addToRegistryList();

	}
	
	
}