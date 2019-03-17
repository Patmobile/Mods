package de.patmobile.moreitems.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;

public class ArmorLeggins extends UItemArmor {
	
	public ArmorLeggins(String name, Properties properties, IArmorMaterial material) {
		this(name, null, properties, material);
	}
	
	public ArmorLeggins(String name, ItemGroup group, Properties properties, IArmorMaterial material) {
		super(name, group, properties, material, EntityEquipmentSlot.LEGS);
	}
	
}