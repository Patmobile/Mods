package de.patmobile.moreitems.items;


import de.patmobile.moreitems.registry.IItemRegistryType;
import net.minecraft.item.Item;

public class ArmorSet implements IItemRegistryType {
	
	private final ArmorHelmet helmet;
	private final ArmorChestplate chestplate;
	private final ArmorLeggins leggings;
	private final ArmorBoots boots;
	
	public ArmorSet(ArmorHelmet helmet, ArmorChestplate chestplate, ArmorLeggins leggings, ArmorBoots boots) {
		this.helmet = helmet;
		this.chestplate = chestplate;
		this.leggings = leggings;
		this.boots = boots;
	}
	
	@Override
	public Item[] getItemArray() {
		return new Item[] { helmet, chestplate, leggings, boots };
	}
	
	public ArmorHelmet getHelmet() {
		return helmet;
	}
	
	public ArmorChestplate getChestplate() {
		return chestplate;
	}
	
	public ArmorLeggins getLeggings() {
		return leggings;
	}
	
	public ArmorBoots getBoots() {
		return boots;
	}
}