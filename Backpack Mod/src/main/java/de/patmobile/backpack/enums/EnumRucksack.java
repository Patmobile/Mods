package de.patmobile.backpack.enums;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;

public enum EnumRucksack implements IStringSerializable {
	
	KLEIN("klein", EnumRarity.COMMON, 9, 3),
	GROSS("gross", EnumRarity.COMMON, 9, 5);
	
	private final String name;
	private final EnumRarity rarity;
	private final int sizeX, sizeY;
	
	private EnumRucksack(String name, EnumRarity rarity, int sizeX, int sizeY) {
		this.name = name;
		this.rarity = rarity;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	
	public String getName() {
		return name;
	}
	
	public EnumRarity getRarity() {
		return rarity;
	}
	
	public int getSizeX() {
		return sizeX;
	}
	
	public int getSizeY() {
		return sizeY;
	}
	
	public int getCount() {
		return getSizeX() * getSizeY();
	}
}