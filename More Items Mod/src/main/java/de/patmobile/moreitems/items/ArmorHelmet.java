package de.patmobile.moreitems.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;

public class ArmorHelmet extends UItemArmor {
	
	public ArmorHelmet(String name, Properties properties, IArmorMaterial material) {
		this(name, null, properties, material);
	}
	
	public ArmorHelmet(String name, ItemGroup group, Properties properties, IArmorMaterial material) {
		super(name, group, properties, material, EntityEquipmentSlot.HEAD);
	}
	
}