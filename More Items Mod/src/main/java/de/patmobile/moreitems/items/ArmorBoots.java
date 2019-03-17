package de.patmobile.moreitems.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;

public class ArmorBoots extends UItemArmor {
	
	public ArmorBoots(String name, Properties properties, IArmorMaterial material) {
		this(name, null, properties, material);
	}
	
	public ArmorBoots(String name, ItemGroup group, Properties properties, IArmorMaterial material) {
		super(name, group, properties, material, EntityEquipmentSlot.FEET);
	}
	
}