package de.patmobile.moreitems.items;


import de.patmobile.moreitems.api.IUItem;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraftforge.api.distmarker.*;

public class UItemArmor extends ItemArmor implements IUItem {
	
	protected final String type_name;
	
	protected final String name;
	
	public UItemArmor(String name, Properties properties, IArmorMaterial material, EntityEquipmentSlot slot) {
		this(name, null, properties, material, slot);
	}
	
	public UItemArmor(String name, ItemGroup group, Properties properties, IArmorMaterial material, EntityEquipmentSlot slot) {
		super(material, slot, group == null ? properties : properties.group(group));
		this.type_name = name + "_" + getTypeString(slot);
		this.name = name;
	}
	
	@Override
	public String getEntryName() {
		return type_name;
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (!material.getName().equals("invalid")) {
			return null;
		}
		return String.format("%s:textures/models/armor/%s_layer_%d%s.png", getRegistryName().getNamespace(), name, (slot == EntityEquipmentSlot.LEGS ? 2 : 1), type == null ? "" : String.format("_%s", type));
	}
	
	protected String getTypeString(EntityEquipmentSlot slot) {
		switch (slot) {
		case HEAD:
			return "helmet";
		case CHEST:
			return "chestplate";
		case LEGS:
			return "leggings";
		case FEET:
			return "boots";
		default:
			return "invalid";
		}
	}
	
}