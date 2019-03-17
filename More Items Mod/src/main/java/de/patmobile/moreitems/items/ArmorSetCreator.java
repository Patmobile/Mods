package de.patmobile.moreitems.items;


import de.patmobile.moreitems.util.ItemProperties;
import net.minecraft.item.*;
import net.minecraft.item.Item.Properties;

public class ArmorSetCreator {
	
	public static ArmorSet create(String name, Properties properties, IArmorMaterial material) {
		return create(name, null, properties, material);
	}
	
	public static ArmorSet create(String name, ItemGroup group, Properties properties, IArmorMaterial material) {
		return new ArmorSet(new ArmorHelmet(name, group, new ItemProperties(properties), material), new ArmorChestplate(name, group, new ItemProperties(properties), material), new ArmorLeggins(name, group, new ItemProperties(properties), material), new ArmorBoots(name, group, new ItemProperties(properties), material));
	}
}